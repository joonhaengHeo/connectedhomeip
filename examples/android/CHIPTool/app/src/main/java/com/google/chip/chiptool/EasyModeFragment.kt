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
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import chip.devicecontroller.ChipDeviceController
import chip.devicecontroller.ChipIdLookup
import chip.devicecontroller.ClusterIDMapping
import chip.devicecontroller.ReportCallback
import chip.devicecontroller.model.ChipAttributePath
import chip.devicecontroller.model.ChipEventPath
import chip.devicecontroller.model.NodeState
import chip.tlv.TlvReader
import com.google.chip.chiptool.clusterclient.BasicClientFragment
import com.google.chip.chiptool.databinding.EasyModeFragmentBinding
import com.google.chip.chiptool.setuppayloadscanner.BarcodeFragment
import com.google.chip.chiptool.util.toAny
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

class EasyModeFragment : Fragment() {
    private var _binding: EasyModeFragmentBinding? = null
    private val binding
        get() = _binding!!

    private val deviceController: ChipDeviceController
        get() = ChipClient.getDeviceController(requireContext())

    private lateinit var scope: CoroutineScope

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = EasyModeFragmentBinding.inflate(inflater, container, false)
        scope = viewLifecycleOwner.lifecycleScope

        binding.fabricListSpinner.adapter = makeSpinnerAdapter(listOf("1"))
        binding.fabricListSpinner.isEnabled = false
        binding.generateFabricBtn.isEnabled = false
        binding.endpointListSpinner.isEnabled = false
        binding.clusterListSpinner.isEnabled = false

        val prefs = requireActivity().getSharedPreferences(CHIPToolActivity.CONFIG_PREFERENCE_FILE_KEY, Context.MODE_PRIVATE)
        val nodeIdSet = prefs.getStringSet(CHIPToolActivity.PREF_COMMISSIONED_NODE_ID, setOf()) ?: setOf()

        binding.nodeListSpinner.adapter = makeSpinnerAdapter(nodeIdSet.toList().sorted())
        binding.commissioningBtn.setOnClickListener { handleCommissioningClicked() }
        binding.connectBtn.setOnClickListener { scope.launch { handleConnectClicked() } }
        binding.endpointListSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val endpoint = binding.endpointListSpinner.selectedItem.toString()
                scope.launch { handleEndpointSelected(endpoint.toUInt()) }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        return binding.root
    }

    private fun makeSpinnerAdapter(spinnerList: List<String>): ArrayAdapter<String> {
        return ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                spinnerList
        ).apply { setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {}

    private fun handleCommissioningClicked() {
        showFragment(BarcodeFragment.newInstance(easyMode = true), false)
    }

    private suspend fun handleConnectClicked() {
        if (!binding.connectBtn.isChecked) {
            Log.d(TAG, "not connect")
            changeConnectingMode(false)
            return
        }

        Log.d(TAG, "connecting")
        changeConnectingMode(true)

        val deviceId = binding.nodeListSpinner.selectedItem.toString().toULong().toLong()

        val devicePtr =
                ChipClient.getConnectedDevicePointer(requireContext(), deviceId)

        // Read Descriptor cluster, partsList attribute
        val endpointId = 0
        val clusterId = ClusterIDMapping.Descriptor.ID
        val attributeId = ClusterIDMapping.Descriptor.Attribute.PartsList.id
        val attributePath = ChipAttributePath.newInstance(endpointId, clusterId, attributeId)
        deviceController.readAttributePath(object: ReportCallback {
            override fun onError(attributePath: ChipAttributePath?, eventPath: ChipEventPath?, e: Exception) {
                Log.d(TAG, "read error", e)
            }

            override fun onReport(nodeState: NodeState?) {
                val state = nodeState?.getEndpointState(endpointId)?.getClusterState(clusterId)?.getAttributeState(attributeId) ?: return
                val value = TlvReader(state.tlv).toAny() as List<*>
                requireActivity().runOnUiThread {
                    val endpoints = mutableListOf("0")
                    endpoints.addAll(value.map { it.toString() })
                    binding.endpointListSpinner.adapter = makeSpinnerAdapter(endpoints)
                }
            }

        }, devicePtr, listOf(attributePath), 0)
    }

    private suspend fun handleEndpointSelected(endpointId: UInt) {
        val deviceId = binding.nodeListSpinner.selectedItem.toString().toULong().toLong()
        val devicePtr =
                ChipClient.getConnectedDevicePointer(requireContext(), deviceId)

        // Read Descriptor cluster, partsList attribute
        val clusterId = ClusterIDMapping.Descriptor.ID
        val attributeId = ClusterIDMapping.Descriptor.Attribute.ServerList.id
        val attributePath = ChipAttributePath.newInstance(endpointId.toInt(), clusterId, attributeId)
        deviceController.readAttributePath(object: ReportCallback {
            override fun onError(attributePath: ChipAttributePath?, eventPath: ChipEventPath?, e: Exception) {
                Log.d(TAG, "read error", e)
            }

            override fun onReport(nodeState: NodeState?) {
                val state = nodeState?.getEndpointState(endpointId.toInt())?.getClusterState(clusterId)?.getAttributeState(attributeId) ?: return
                val value = TlvReader(state.tlv).toAny() as List<*>
                requireActivity().runOnUiThread {
                    binding.clusterListSpinner.adapter = makeSpinnerAdapter(value.map { "${it.toString()}:${ChipIdLookup.clusterIdToName(it as Long)}" })
                }
            }

        }, devicePtr, listOf(attributePath), 0)
    }

    private fun changeConnectingMode(enabled: Boolean) {
        requireActivity().runOnUiThread {
            //binding.generateFabricBtn.isEnabled = !enabled
            //binding.fabricListSpinner.isEnabled = !enabled
            binding.nodeListSpinner.isEnabled = !enabled
            binding.commissioningBtn.isEnabled = !enabled
            binding.endpointListSpinner.isEnabled = enabled
            binding.clusterListSpinner.isEnabled = enabled
        }
    }

    private fun showFragment(fragment: Fragment, showOnBack: Boolean = true) {
        val fragmentTransaction =
                parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment, fragment.javaClass.simpleName)

        if (showOnBack) {
            fragmentTransaction.addToBackStack(null)
        }

        fragmentTransaction.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic fun newInstance() = EasyModeFragment()

        private const val TAG = "EasyModeFragment"
    }
}