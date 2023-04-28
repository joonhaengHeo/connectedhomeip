package com.google.chip.chiptool.clusterclient

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import chip.devicecontroller.ChipClusters
import chip.devicecontroller.ChipDeviceController
import chip.devicecontroller.ChipStructs
import com.google.chip.chiptool.ChipClient
import com.google.chip.chiptool.databinding.AddressUpdateFragmentBinding
import com.google.chip.chiptool.util.DeviceIdUtil
import kotlinx.coroutines.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/** Fragment for updating the address of a device given its fabric and node ID. */
class AddressUpdateFragment: Fragment() {
  private val deviceController: ChipDeviceController
    get() = ChipClient.getDeviceController(requireContext())

  val deviceId: Long
    get() = binding.deviceIdEd.text.toString().toULong(16).toLong()
  var endpointId : Int
    get() = binding.epIdEd.text.toString().toInt()
    set(value) {
      binding.epIdEd.setText(value.toString())
    }
  private val nodeList = ArrayList<String>()
  private var _binding: AddressUpdateFragmentBinding? = null
  private val binding get() = _binding!!
  
  private val scope = CoroutineScope(Dispatchers.Main + Job())

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = AddressUpdateFragmentBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val compressedFabricId = deviceController.compressedFabricId
    binding.fabricIdEd.setText(compressedFabricId.toULong().toString(16).padStart(16, '0'))
    binding.deviceIdEd.setText(DeviceIdUtil.getLastDeviceId(requireContext()).toULong().toString(16))
    binding.epIdEd.setText(endpointId.toString())

    binding.discoverBtn.setOnClickListener { operationalDiscoverClick() }
  }

  private fun operationalDiscoverClick() {
    try {
      binding.discoverBtn.isEnabled = false
      deviceController.discoverOperationalNodes()
      Toast.makeText(requireContext(), "Discover Operational Nodes", Toast.LENGTH_SHORT).show()
    } catch (ex: Exception) {
      Log.d(TAG, "Exception", ex)
      Toast.makeText(requireContext(), "Discover Operational Nodes failed: $ex", Toast.LENGTH_SHORT).show()
    }

    scope.launch {
      delay(7000)
      updateSpinner()
      binding.discoverBtn.isEnabled = true
    }
  }

  private suspend fun updateSpinner() {
    val deviceController = ChipClient.getDeviceController(requireContext())
    nodeList.clear()
    for(i in 0..10) {
      val device = deviceController.GetOperationalNodeDevice(i) ?: break
      val nodeIdStr = device.nodeId.toULong().toString(16)
      val cluster = getDescriptorClusterForDevice(device.nodeId)
      val deviceType = suspendCoroutine<Long> {
        cluster.readDeviceTypeListAttribute(object : ChipClusters.DescriptorCluster.DeviceTypeListAttributeCallback {
          override fun onSuccess(values: MutableList<ChipStructs.DescriptorClusterDeviceTypeStruct>?) {
            val value = values?.get(0) ?: return
            it.resume(value.deviceType)
          }

          override fun onError(ex: java.lang.Exception?) {
            Log.d(TAG, "onError : $ex")
            it.resume(0)
          }

        })
      }
      val deviceTypeStr = String.format("0x%04X", deviceType)
      nodeList.add("$nodeIdStr:$deviceTypeStr")
    }
    requireActivity().runOnUiThread {
      binding.discoverListSpinner.adapter =
        ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, nodeList)
      binding.discoverListSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
          val nodeId = nodeList[position].split(":")[0].trim()
          binding.deviceIdEd.setText(nodeId)
        }

        override fun onNothingSelected(parent: AdapterView<*>) {}
      }
    }
  }

  fun getDeviceList() : MutableList<String> {
    return nodeList
  }

  private suspend fun getDescriptorClusterForDevice(deviceId : Long) : ChipClusters.DescriptorCluster {
    return ChipClusters.DescriptorCluster(ChipClient.getConnectedDevicePointer(requireContext(), deviceId), 1)
  }

    override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
  companion object {
    private const val TAG = "AddressUpdateFragment"
  }
}