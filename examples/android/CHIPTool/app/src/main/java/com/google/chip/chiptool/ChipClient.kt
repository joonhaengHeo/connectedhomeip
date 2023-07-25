/*
 *   Copyright (c) 2020 Project CHIP Authors
 *   All rights reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package com.google.chip.chiptool

import android.content.Context
import android.util.Log
import chip.devicecontroller.ChipDeviceController
import chip.devicecontroller.ChipStructs
import chip.devicecontroller.ControllerParams
import chip.devicecontroller.GetConnectedDeviceCallbackJni.GetConnectedDeviceCallback
import chip.devicecontroller.NetworkCredentials
import chip.devicecontroller.NetworkCredentials.ThreadCredentials
import chip.platform.AndroidBleManager
import chip.platform.AndroidChipPlatform
import chip.platform.ChipMdnsCallbackImpl
import chip.platform.DiagnosticDataProviderImpl
import chip.platform.NsdManagerServiceBrowser
import chip.platform.NsdManagerServiceResolver
import chip.platform.PreferencesConfigurationManager
import chip.platform.PreferencesKeyValueStoreManager
import com.google.chip.chiptool.attestation.ExampleAttestationTrustStoreDelegate
import com.google.chip.chiptool.provisioning.EnterNetworkFragment
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.ArrayList
import java.util.Optional

/** Lazily instantiates [ChipDeviceController] and holds a reference to it. */
object ChipClient {
  private const val TAG = "ChipClient"
  private lateinit var chipDeviceController: ChipDeviceController
  private lateinit var androidPlatform: AndroidChipPlatform
  /* 0xFFF4 is a test vendor ID, replace with your assigned company ID */
  private const val VENDOR_ID = 0xFFF4

  fun getDeviceController(context: Context): ChipDeviceController {
    getAndroidChipPlatform(context)

    if (!this::chipDeviceController.isInitialized) {
      chipDeviceController =
        ChipDeviceController(ControllerParams.newBuilder().setAttemptNetworkScanWiFi(true).setAttemptNetworkScanThread(true).setControllerVendorId(VENDOR_ID).build())

      // Set delegate for attestation trust store for device attestation verifier.
      // It will replace the default attestation trust store.
      chipDeviceController.setAttestationTrustStoreDelegate(
        ExampleAttestationTrustStoreDelegate(chipDeviceController)
      )

      chipDeviceController.setScanNetworksListener(object: ChipDeviceController.ScanNetworksListener {
        override fun onScanNetworksFailure(errorCode: Int) {
          Log.d(TAG, "onScanNetworksFailure: $errorCode")
        }

        override fun onScanNetworksSuccess(networkingStatus: Int?, debugText: Optional<String>?, wiFiScanResults: Optional<ArrayList<ChipStructs.NetworkCommissioningClusterWiFiInterfaceScanResultStruct>>?, threadScanResults: Optional<ArrayList<ChipStructs.NetworkCommissioningClusterThreadInterfaceScanResultStruct>>?) {
          Log.d(TAG, "onScanNetworksSuccess: $networkingStatus")
          if (wiFiScanResults != null && wiFiScanResults.isPresent) {
            Log.d(TAG, "wiFiScanResults: ${wiFiScanResults.get()}")
          }

          if (threadScanResults != null && threadScanResults.isPresent) {
            Log.d(TAG, "threadScanResults: ${threadScanResults.get()}") }
            for (result in threadScanResults!!.get()) {
              if (result.networkName == "OpenThreadMatter") {
                val credentials = ThreadCredentials(EnterNetworkFragment.makeThreadOperationalDataset(result.channel, result.panId, "1111111122222222".hexToByteArray(), "00112233445566778899aabbccddeeff".hexToByteArray()))
                chipDeviceController.updateCommissioningNetworkCredentials(NetworkCredentials.forThread(credentials))
              }
            }
        }

      })
    }

    return chipDeviceController
  }

  private fun String.hexToByteArray(): ByteArray {
    return chunked(2).map { byteStr -> byteStr.toUByte(16).toByte() }.toByteArray()
  }

  fun getAndroidChipPlatform(context: Context?): AndroidChipPlatform {
    if (!this::androidPlatform.isInitialized && context != null) {
      // force ChipDeviceController load jni
      ChipDeviceController.loadJni()
      androidPlatform =
        AndroidChipPlatform(
          AndroidBleManager(context),
          PreferencesKeyValueStoreManager(context),
          PreferencesConfigurationManager(context),
          NsdManagerServiceResolver(context),
          NsdManagerServiceBrowser(context),
          ChipMdnsCallbackImpl(),
          DiagnosticDataProviderImpl(context)
        )
    }

    return androidPlatform
  }

  /**
   * Wrapper around [ChipDeviceController.getConnectedDevicePointer] to return the value directly.
   */
  suspend fun getConnectedDevicePointer(context: Context, nodeId: Long): Long {
    // TODO (#21539) This is a memory leak because we currently never call
    // releaseConnectedDevicePointer
    // once we are done with the returned device pointer. Memory leak was introduced since the
    // refactor
    // that introduced it was very large in order to fix a use after free, which was considered
    // to be
    // worse than the memory leak that was introduced.
    return suspendCancellableCoroutine { continuation ->
      getDeviceController(context)
        .getConnectedDevicePointer(
          nodeId,
          object : GetConnectedDeviceCallback {
            override fun onDeviceConnected(devicePointer: Long) {
              Log.d(TAG, "Got connected device pointer")
              continuation.resume(devicePointer)
            }

            override fun onConnectionFailure(nodeId: Long, error: Exception) {
              val errorMessage = "Unable to get connected device with nodeId $nodeId"
              Log.e(TAG, errorMessage, error)
              continuation.resumeWithException(IllegalStateException(errorMessage))
            }
          }
        )
    }
  }
}
