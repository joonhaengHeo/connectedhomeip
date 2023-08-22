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

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.nfc.NdefMessage
import android.nfc.NfcAdapter
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.Menu
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import chip.onboardingpayload.OnboardingPayload
import chip.onboardingpayload.OnboardingPayloadParser
import chip.onboardingpayload.UnrecognizedQrCodeException
import com.google.chip.chiptool.provisioning.AddressCommissioningFragment
import com.google.chip.chiptool.provisioning.DeviceProvisioningFragment
import com.google.chip.chiptool.provisioning.EnterNetworkFragment
import com.google.chip.chiptool.provisioning.ProvisionNetworkType
import com.google.chip.chiptool.setuppayloadscanner.BarcodeFragment
import com.google.chip.chiptool.setuppayloadscanner.CHIPDeviceDetailsFragment
import com.google.chip.chiptool.setuppayloadscanner.CHIPDeviceInfo
import com.google.chip.chiptool.setuppayloadscanner.CHIPLedgerDetailsFragment
import org.json.JSONObject

class CHIPToolActivity :
  AppCompatActivity(),
  BarcodeFragment.Callback,
  SelectActionFragment.Callback,
  DeviceProvisioningFragment.Callback,
  EnterNetworkFragment.Callback,
  CHIPDeviceDetailsFragment.Callback,
  CHIPLedgerDetailsFragment.Callback {

  private var networkType: ProvisionNetworkType? = null
  private var deviceInfo: CHIPDeviceInfo? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.top_activity)

    if (savedInstanceState == null) {
      val fragment = if (isEasyMode()) {
        EasyModeFragment.newInstance()
      } else {
        SelectActionFragment.newInstance()
      }
      supportFragmentManager
        .beginTransaction()
        .add(R.id.nav_host_fragment, fragment, fragment.javaClass.simpleName)
        .commit()
    } else {
      networkType =
        ProvisionNetworkType.fromName(savedInstanceState.getString(ARG_PROVISION_NETWORK_TYPE))
    }

    if (intent?.action == NfcAdapter.ACTION_NDEF_DISCOVERED) onNfcIntent(intent)

    if (Intent.ACTION_VIEW == intent?.action) {
      onReturnIntent(intent)
    }
  }

  private fun isEasyMode(): Boolean {
    val prefs = getSharedPreferences(CONFIG_PREFERENCE_FILE_KEY, Context.MODE_PRIVATE)
    return prefs.getBoolean(PREF_EASY_MODE, USE_EASY_MODE)
  }

  private fun setEasyMode(easyMode: Boolean) {
    val prefs = getSharedPreferences(CONFIG_PREFERENCE_FILE_KEY, Context.MODE_PRIVATE)
    val prefEdits = prefs.edit()
    prefEdits.putBoolean(PREF_EASY_MODE, easyMode)
    prefEdits.apply()
  }

  private fun addNodeId(nodeId: ULong) {
    val prefs = getSharedPreferences(CONFIG_PREFERENCE_FILE_KEY, Context.MODE_PRIVATE)
    val nodeSet = prefs.getStringSet(PREF_COMMISSIONED_NODE_ID, setOf()) ?: setOf()
    val mutableNodeSet = mutableSetOf<String>().apply {
      addAll(nodeSet)
      add(nodeId.toString())
    }
    val prefEdits = prefs.edit()
    prefEdits.putStringSet(PREF_COMMISSIONED_NODE_ID, mutableNodeSet)
    prefEdits.apply()
  }

  @SuppressLint("UseSwitchCompatOrMaterialCode")
  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.option_menu, menu)
    val switch = menu?.getItem(0)?.actionView?.findViewById<Switch>(R.id.easymode_switch) ?: return false

    switch.isChecked = isEasyMode()
    switch.setOnCheckedChangeListener { _, _ ->
      Log.d(TAG, "switch : ${switch.isChecked}")
      setEasyMode(switch.isChecked)
      if (isEasyMode()) {
        showFragment(EasyModeFragment.newInstance(), false)
      } else {
        showFragment(SelectActionFragment.newInstance(), false)
      }

    }
    return true
  }

  override fun onSaveInstanceState(outState: Bundle) {
    outState.putString(ARG_PROVISION_NETWORK_TYPE, networkType?.name)

    super.onSaveInstanceState(outState)
  }

  override fun onCHIPDeviceInfoReceived(deviceInfo: CHIPDeviceInfo, setupCode: String?) {
    this.deviceInfo = deviceInfo
    if (isEasyMode()) {
      showFragment(DeviceProvisioningFragment.newInstance(deviceInfo!!, setupCode, null))
    } else if (networkType == null) {
      showFragment(CHIPDeviceDetailsFragment.newInstance(deviceInfo))
    } else {
      if (deviceInfo.ipAddress != null) {
        showFragment(DeviceProvisioningFragment.newInstance(deviceInfo!!, setupCode, null))
      } else {
        showFragment(EnterNetworkFragment.newInstance(networkType!!), false)
      }
    }
  }

  override fun onCommissioningComplete(code: Int, nodeId: ULong?) {
    runOnUiThread {
      Toast.makeText(this, getString(R.string.commissioning_completed, code), Toast.LENGTH_SHORT)
        .show()
    }
    ChipClient.getDeviceController(this).close()

    if (nodeId != null) {
      addNodeId(nodeId)
    }

    if (isEasyMode()) {
      showFragment(EasyModeFragment.newInstance(), false)
    } else {
      showFragment(SelectActionFragment.newInstance(), false)
    }
  }

  override fun onShowDeviceAddressInput() {
    showFragment(AddressCommissioningFragment.newInstance(), false)
  }

  override fun onNetworkCredentialsEntered(networkCredentials: NetworkCredentialsParcelable) {
    showFragment(DeviceProvisioningFragment.newInstance(deviceInfo!!, null, networkCredentials))
  }

  override fun handleReadFromLedgerClicked(deviceInfo: CHIPDeviceInfo) {
    showFragment(CHIPLedgerDetailsFragment.newInstance(deviceInfo))
  }

  override fun handleCustomFlowRedirectClicked(redirectUrl: String) {
    val redirectIntent = Intent(Intent.ACTION_VIEW, Uri.parse(redirectUrl))
    startActivity(redirectIntent)
  }

  override fun SetNetworkType(type: ProvisionNetworkType) {
    networkType = type
  }

  private fun showFragment(fragment: Fragment, showOnBack: Boolean = true) {
    val fragmentTransaction =
      supportFragmentManager
        .beginTransaction()
        .replace(R.id.nav_host_fragment, fragment, fragment.javaClass.simpleName)

    if (showOnBack) {
      fragmentTransaction.addToBackStack(null)
    }

    fragmentTransaction.commit()
  }

  private fun onNfcIntent(intent: Intent?) {
    // Require 1 NDEF message containing 1 NDEF record
    val messages = intent?.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)
    if (messages?.size != 1) return

    val records = (messages[0] as NdefMessage).records
    if (records.size != 1) return

    // Require NDEF URI record starting with "mt:"
    val uri = records[0].toUri()
    if (!uri?.scheme.equals("mt", true)) return

    lateinit var setupPayload: OnboardingPayload
    try {
      setupPayload = OnboardingPayloadParser().parseQrCode(uri.toString().toUpperCase())
    } catch (ex: UnrecognizedQrCodeException) {
      Log.e(TAG, "Unrecognized QR Code", ex)
      Toast.makeText(this, "Unrecognized QR Code", Toast.LENGTH_SHORT).show()
      return
    }

    val deviceInfo = CHIPDeviceInfo.fromSetupPayload(setupPayload)

    val buttons =
      arrayOf(
        getString(R.string.nfc_tag_action_show),
        getString(R.string.nfc_tag_action_wifi),
        getString(R.string.nfc_tag_action_thread)
      )

    AlertDialog.Builder(this)
      .setTitle(R.string.nfc_tag_action_title)
      .setItems(buttons) { _, which ->
        this.networkType =
          when (which) {
            1 -> ProvisionNetworkType.WIFI
            2 -> ProvisionNetworkType.THREAD
            else -> null
          }
        onCHIPDeviceInfoReceived(deviceInfo, uri.toString().toUpperCase())
      }
      .create()
      .show()
  }

  private fun onReturnIntent(intent: Intent) {
    val appLinkData = intent.data
    // Require URI schema "mt:"
    if (!appLinkData?.scheme.equals("mt", true)) {
      Log.d(TAG, "Unrecognized URI schema : ${appLinkData?.scheme}")
      return
    }
    // Require URI host "modelinfo"
    if (!appLinkData?.host.equals("modelinfo", true)) {
      Log.d(TAG, "Unrecognized URI host : ${appLinkData?.host}")
      return
    }

    // parse payload
    try {
      val payloadBase64String = appLinkData?.getQueryParameter("payload")
      if (payloadBase64String.isNullOrEmpty()) {
        Log.d(TAG, "Unrecognized payload")
        return
      }

      val decodeBytes = Base64.decode(payloadBase64String, Base64.DEFAULT)
      val payloadString = String(decodeBytes)
      val payload = JSONObject(payloadString)

      // parse payload from JSON
      val setupPayload = OnboardingPayload()
      // set defaults
      setupPayload.discoveryCapabilities = mutableSetOf()
      setupPayload.optionalQRCodeInfo = HashMap()

      // read from payload
      setupPayload.version = payload.getInt("version")
      setupPayload.vendorId = payload.getInt("vendorId")
      setupPayload.productId = payload.getInt("productId")
      setupPayload.commissioningFlow = payload.getInt("commissioningFlow")
      setupPayload.discriminator = payload.getInt("discriminator")
      setupPayload.setupPinCode = payload.getLong("setupPinCode")

      val deviceInfo = CHIPDeviceInfo.fromSetupPayload(setupPayload)
      val buttons = arrayOf(getString(R.string.nfc_tag_action_show))

      AlertDialog.Builder(this)
        .setTitle(R.string.provision_custom_flow_alert_title)
        .setItems(buttons) { _, _ -> onCHIPDeviceInfoReceived(deviceInfo, null) }
        .create()
        .show()
    } catch (ex: UnrecognizedQrCodeException) {
      Log.e(TAG, "Unrecognized Payload", ex)
      Toast.makeText(this, "Unrecognized Setup Payload", Toast.LENGTH_SHORT).show()
      return
    }
  }

  companion object {
    private const val TAG = "CHIPToolActivity"
    private const val ADDRESS_COMMISSIONING_FRAGMENT_TAG = "address_commissioning_fragment"
    private const val ARG_PROVISION_NETWORK_TYPE = "provision_network_type"

    private const val USE_EASY_MODE = true
    private const val PREF_EASY_MODE = "easy_mode"
    const val PREF_COMMISSIONED_NODE_ID = "node_id"

    const val CONFIG_PREFERENCE_FILE_KEY = "config"
  }
}
