package com.google.chip.chiptool.clusterclient

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import chip.devicecontroller.ChipClusters
import chip.devicecontroller.ChipDeviceController
import chip.devicecontroller.DiagnosticLogType
import chip.devicecontroller.DownloadFileCallback
import chip.devicecontroller.ChipStructs
import com.google.chip.chiptool.ChipClient
import com.google.chip.chiptool.R
import com.google.chip.chiptool.databinding.CameraFragmentBinding
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.Optional
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class CameraFragment : Fragment() {
  private val deviceController: ChipDeviceController
    get() = ChipClient.getDeviceController(requireContext())

  private lateinit var scope: CoroutineScope
  private lateinit var addressUpdateFragment: AddressUpdateFragment

  private var _binding: CameraFragmentBinding? = null
  private val binding
    get() = _binding!!

  private val timeout: Long
    get() = binding.timeoutEd.text.toString().toULongOrNull()?.toLong() ?: 0L

  private val resolutionWidth: Int
    get() = binding.widthEd.text.toString().toIntOrNull() ?: 1280

  private val resolutionHeight: Int
    get() = binding.heightEd.text.toString().toIntOrNull() ?: 720

  enum class TransferProtocolEnum(val value: Int) {
    ResponsePayload(0), BDX(1)
  }
  private val transferProtocolTypeList = TransferProtocolEnum.values()
  private val transferProtocolType: TransferProtocolEnum
    get() = transferProtocolTypeList[binding.transferProtocolTypeSp.selectedItemPosition]

  private var mDownloadFile: File? = null
  private var mDownloadFileOutputStream: FileOutputStream? = null
  private var mReceiveFileLen = 0U

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = CameraFragmentBinding.inflate(inflater, container, false)
    scope = viewLifecycleOwner.lifecycleScope

    addressUpdateFragment =
      childFragmentManager.findFragmentById(R.id.addressUpdateFragment) as AddressUpdateFragment

    binding.transferProtocolTypeSp.adapter =
      ArrayAdapter(
        requireContext(),
        android.R.layout.simple_spinner_dropdown_item,
          transferProtocolTypeList
      )

    binding.captureSnapshotBtn.setOnClickListener { 
        scope.launch { captureSnapshotClick() } 
    }

    binding.liveviewLocalBtn.setOnClickListener { 
        showMessage(getString(R.string.camera_liveview_local_not_implemented)) 
    }

    binding.liveviewRemoteBtn.setOnClickListener { 
        showMessage(getString(R.string.camera_liveview_remote_not_implemented)) 
    }

    return binding.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  inner class SnapshotDownloadCallback(private val snapshotStreamID: Int) : DownloadFileCallback {
    override fun onError(fabricIndex: Int, nodeId: Long, errorCode: Long) {
      Log.d(TAG, "SnapshotDownloadCallback:onError: $fabricIndex, ${nodeId.toULong()}, $errorCode")
      showMessage(getString(R.string.camera_snapshot_download_failed))
      mDownloadFileOutputStream?.flush()
      scope.launch { deallocateStream(snapshotStreamID) }
    }

    override fun onSuccess(fabricIndex: Int, nodeId: Long) {
      Log.d(TAG, "SnapshotDownloadCallback:onSuccess: $fabricIndex, ${nodeId.toULong()}")
      mDownloadFileOutputStream?.flush()
      showMessage(getString(R.string.camera_snapshot_download_completed))
      mDownloadFile?.let { showNotification(it) }
      scope.launch { deallocateStream(snapshotStreamID) }
    }

    override fun onTransferData(fabricIndex: Int, nodeId: Long, data: ByteArray): Boolean {
      Log.d(TAG, "SnapshotDownloadCallback:onTransferData : ${data.size}")
      if (mDownloadFileOutputStream == null) {
        Log.d(TAG, "mDownloadFileOutputStream or mDownloadFile is null")
        return false
      }
      return addData(mDownloadFileOutputStream!!, data)
    }

    private fun addData(outputStream: FileOutputStream, data: ByteArray): Boolean {
      try {
        outputStream.write(data)
      } catch (e: IOException) {
        Log.d(TAG, "IOException", e)
        return false
      }
      mReceiveFileLen += data.size.toUInt()
      showMessage(getString(R.string.camera_receive_data_size, mReceiveFileLen.toInt()))
      return true
    }
  }

  private suspend fun captureSnapshotClick() {
    val endpointId = addressUpdateFragment.endpointId
    val devicePtr =
        try {
            ChipClient.getConnectedDevicePointer(requireContext(), addressUpdateFragment.deviceId)
        } catch (e: IllegalStateException) {
            Log.d(TAG, "getConnectedDevicePointer exception", e)
            showMessage("Get DevicePointer fail!")
            return
        }
    val cluster = ChipClusters.CameraAvStreamManagementCluster(devicePtr, endpointId)

    // Set min resolution to 1280x720
    val minResolution = ChipStructs.CameraAvStreamManagementClusterVideoResolutionStruct(resolutionWidth, resolutionHeight)
    // Set max resolution to 1920x1080
    val maxResolution = ChipStructs.CameraAvStreamManagementClusterVideoResolutionStruct(1920, 1080)

    // 0 means JPEG
    val imageCodec = 0
    // Set max frame rate to 30
    val maxFrameRate = 30
    // Set quality to 1
    val quality = 1

    showMessage("Allocating Snapshot Stream...")

    cluster.snapshotStreamAllocate(
      object : ChipClusters.CameraAvStreamManagementCluster.SnapshotStreamAllocateResponseCallback {
        override fun onSuccess(snapshotStreamID: Int?) {
          if (snapshotStreamID != null) {
            Log.d(TAG, "Allocate Success. Stream ID: $snapshotStreamID")
            requireActivity().runOnUiThread {
              startCaptureSnapshot(snapshotStreamID)
            }
          } else {
            showMessage("Allocate Failed: Stream ID is null")
          }
        }

        override fun onError(error: Exception) {
          Log.e(TAG, "Allocate Error", error)
          showMessage("Allocate Error: ${error.message}")
        }
      },
      imageCodec,
      maxFrameRate,
      minResolution,
      maxResolution,
      quality,
      Optional.of(false), // Set watermarkEnabled to false
      Optional.of(false)  // Set OSDEnabled to false
    )
  }

  private fun startCaptureSnapshot(snapshotStreamID: Int) {
    mDownloadFile = createSnapshotFile(
      deviceController.fabricIndex.toUInt(),
      addressUpdateFragment.deviceId.toULong()
    )
    
    if (mDownloadFile == null) {
        showMessage(getString(R.string.camera_cannot_write_storage))
        return
    }

    mDownloadFileOutputStream = FileOutputStream(mDownloadFile)
    
    showMessage("Capturing Snapshot...")

    deviceController.captureSnapshotFromNode(
      addressUpdateFragment.deviceId,
      addressUpdateFragment.endpointId,
      snapshotStreamID,
      resolutionWidth,
      resolutionHeight,
      transferProtocolType.value,
      timeout,
      SnapshotDownloadCallback(snapshotStreamID)
    )
  }

  private suspend fun deallocateStream(snapshotStreamID: Int) {
    val endpointId = addressUpdateFragment.endpointId
    val devicePtr =
        try {
            ChipClient.getConnectedDevicePointer(requireContext(), addressUpdateFragment.deviceId)
        } catch (e: IllegalStateException) {
            Log.d(TAG, "getConnectedDevicePointer exception", e)
            showMessage("Get DevicePointer fail!")
            return
        }
    val cluster = ChipClusters.CameraAvStreamManagementCluster(devicePtr, endpointId)

    cluster.snapshotStreamDeallocate(
      object : ChipClusters.DefaultClusterCallback {
        override fun onError(error: Exception) {
          Log.e(TAG, "Deallocate Error for Stream ID $snapshotStreamID", error)
        }
        override fun onSuccess() {
          Log.d(TAG, "Deallocate Success for Stream ID: $snapshotStreamID")
        }
      },
      snapshotStreamID
    )
  }

  private fun isExternalStorageWritable(): Boolean {
    return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
  }

  private fun createSnapshotFile(fabricIndex: UInt, nodeId: ULong): File? {
    if (!isExternalStorageWritable()) {
      return null
    }
    val now = System.currentTimeMillis()
    val fileName = "captureSnapshot_${fabricIndex}_${nodeId}_$now.jpg"
    mReceiveFileLen = 0U
    return File(requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES), fileName)
  }

  private fun showNotification(file: File) {
    val intent =
      Intent(Intent.ACTION_VIEW).apply {
        setDataAndType(getFileUri(file), "image/jpeg")
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
      }

    requireActivity().startActivity(intent)
  }

  private fun getFileUri(file: File): Uri {
    return FileProvider.getUriForFile(
      requireContext(),
      "${requireContext().packageName}.provider",
      file
    )
  }

  private fun showMessage(msg: String) {
    requireActivity().runOnUiThread { binding.cameraStatusTv.text = msg }
  }

  companion object {
    private const val TAG = "CameraFragment"

    fun newInstance(): CameraFragment = CameraFragment()
  }
}