/*
 *
 *    Copyright (c) 2023 Project CHIP Authors
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package chip.devicecontroller.cluster

import chip.tlv.Tag
import chip.tlv.AnonymousTag
import chip.tlv.ContextSpecificTag
import chip.tlv.TlvWriter

import java.util.Optional

class ChipStructs {
    class ScenesClusterAttributeValuePair(
        val attributeID: Long,
        val attributeValue: Long) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ScenesClusterAttributeValuePair {\n")
        builder.append("\tattributeID : $attributeID\n")
        builder.append("\tattributeValue : $attributeValue\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), attributeID)
        tlvWriter.put(ContextSpecificTag(1), attributeValue)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ScenesClusterExtensionFieldSet(
        val clusterID: Long,
        val attributeValueList: List<ScenesClusterAttributeValuePair>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ScenesClusterExtensionFieldSet {\n")
        builder.append("\tclusterID : $clusterID\n")
        builder.append("\tattributeValueList : $attributeValueList\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), clusterID)
        tlvWriter.startList(ContextSpecificTag(1))
      val iter_attributeValueList = attributeValueList.iterator()
      while(iter_attributeValueList.hasNext()) {
        val next = iter_attributeValueList.next()
        next.toTlv(AnonymousTag, tlvWriter)
      }
      tlvWriter.endList()
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class DescriptorClusterDeviceTypeStruct(
        val deviceType: Long,
        val revision: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("DescriptorClusterDeviceTypeStruct {\n")
        builder.append("\tdeviceType : $deviceType\n")
        builder.append("\trevision : $revision\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), deviceType)
        tlvWriter.put(ContextSpecificTag(1), revision)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class BindingClusterTargetStruct(
        val node: Optional<Long>,
        val group: Optional<Int>,
        val endpoint: Optional<Int>,
        val cluster: Optional<Long>,
        val fabricIndex: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("BindingClusterTargetStruct {\n")
        builder.append("\tnode : $node\n")
        builder.append("\tgroup : $group\n")
        builder.append("\tendpoint : $endpoint\n")
        builder.append("\tcluster : $cluster\n")
        builder.append("\tfabricIndex : $fabricIndex\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        if (node.isPresent) {
      val opt_node = node.get()
      tlvWriter.put(ContextSpecificTag(1), opt_node)
    }
        if (group.isPresent) {
      val opt_group = group.get()
      tlvWriter.put(ContextSpecificTag(2), opt_group)
    }
        if (endpoint.isPresent) {
      val opt_endpoint = endpoint.get()
      tlvWriter.put(ContextSpecificTag(3), opt_endpoint)
    }
        if (cluster.isPresent) {
      val opt_cluster = cluster.get()
      tlvWriter.put(ContextSpecificTag(4), opt_cluster)
    }
        tlvWriter.put(ContextSpecificTag(254), fabricIndex)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class AccessControlClusterAccessControlTargetStruct(
        val cluster: Long?,
        val endpoint: Int?,
        val deviceType: Long?) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("AccessControlClusterAccessControlTargetStruct {\n")
        builder.append("\tcluster : $cluster\n")
        builder.append("\tendpoint : $endpoint\n")
        builder.append("\tdeviceType : $deviceType\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        if (cluster == null) { tlvWriter.putNull(ContextSpecificTag(0)) }
    else {
      tlvWriter.put(ContextSpecificTag(0), cluster)
    }
        if (endpoint == null) { tlvWriter.putNull(ContextSpecificTag(1)) }
    else {
      tlvWriter.put(ContextSpecificTag(1), endpoint)
    }
        if (deviceType == null) { tlvWriter.putNull(ContextSpecificTag(2)) }
    else {
      tlvWriter.put(ContextSpecificTag(2), deviceType)
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class AccessControlClusterAccessControlEntryStruct(
        val privilege: Int,
        val authMode: Int,
        val subjects: List<Long>?,
        val targets: List<AccessControlClusterAccessControlTargetStruct>?,
        val fabricIndex: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("AccessControlClusterAccessControlEntryStruct {\n")
        builder.append("\tprivilege : $privilege\n")
        builder.append("\tauthMode : $authMode\n")
        builder.append("\tsubjects : $subjects\n")
        builder.append("\ttargets : $targets\n")
        builder.append("\tfabricIndex : $fabricIndex\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(1), privilege)
        tlvWriter.put(ContextSpecificTag(2), authMode)
        if (subjects == null) { tlvWriter.putNull(ContextSpecificTag(3)) }
    else {
      tlvWriter.startList(ContextSpecificTag(3))
      val iter_subjects = subjects.iterator()
      while(iter_subjects.hasNext()) {
        val next = iter_subjects.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
    }
        if (targets == null) { tlvWriter.putNull(ContextSpecificTag(4)) }
    else {
      tlvWriter.startList(ContextSpecificTag(4))
      val iter_targets = targets.iterator()
      while(iter_targets.hasNext()) {
        val next = iter_targets.next()
        next.toTlv(AnonymousTag, tlvWriter)
      }
      tlvWriter.endList()
    }
        tlvWriter.put(ContextSpecificTag(254), fabricIndex)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class AccessControlClusterAccessControlExtensionStruct(
        val data: ByteArray,
        val fabricIndex: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("AccessControlClusterAccessControlExtensionStruct {\n")
        builder.append("\tdata : $data\n")
        builder.append("\tfabricIndex : $fabricIndex\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(1), data)
        tlvWriter.put(ContextSpecificTag(254), fabricIndex)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ActionsClusterActionStruct(
        val actionID: Int,
        val name: String,
        val type: Int,
        val endpointListID: Int,
        val supportedCommands: Int,
        val state: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ActionsClusterActionStruct {\n")
        builder.append("\tactionID : $actionID\n")
        builder.append("\tname : $name\n")
        builder.append("\ttype : $type\n")
        builder.append("\tendpointListID : $endpointListID\n")
        builder.append("\tsupportedCommands : $supportedCommands\n")
        builder.append("\tstate : $state\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), actionID)
        tlvWriter.put(ContextSpecificTag(1), name)
        tlvWriter.put(ContextSpecificTag(2), type)
        tlvWriter.put(ContextSpecificTag(3), endpointListID)
        tlvWriter.put(ContextSpecificTag(4), supportedCommands)
        tlvWriter.put(ContextSpecificTag(5), state)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ActionsClusterEndpointListStruct(
        val endpointListID: Int,
        val name: String,
        val type: Int,
        val endpoints: List<Int>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ActionsClusterEndpointListStruct {\n")
        builder.append("\tendpointListID : $endpointListID\n")
        builder.append("\tname : $name\n")
        builder.append("\ttype : $type\n")
        builder.append("\tendpoints : $endpoints\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), endpointListID)
        tlvWriter.put(ContextSpecificTag(1), name)
        tlvWriter.put(ContextSpecificTag(2), type)
        tlvWriter.startList(ContextSpecificTag(3))
      val iter_endpoints = endpoints.iterator()
      while(iter_endpoints.hasNext()) {
        val next = iter_endpoints.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class BasicInformationClusterCapabilityMinimaStruct(
        val caseSessionsPerFabric: Int,
        val subscriptionsPerFabric: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("BasicInformationClusterCapabilityMinimaStruct {\n")
        builder.append("\tcaseSessionsPerFabric : $caseSessionsPerFabric\n")
        builder.append("\tsubscriptionsPerFabric : $subscriptionsPerFabric\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), caseSessionsPerFabric)
        tlvWriter.put(ContextSpecificTag(1), subscriptionsPerFabric)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class BasicInformationClusterProductAppearanceStruct(
        val finish: Int,
        val primaryColor: Int?) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("BasicInformationClusterProductAppearanceStruct {\n")
        builder.append("\tfinish : $finish\n")
        builder.append("\tprimaryColor : $primaryColor\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), finish)
        if (primaryColor == null) { tlvWriter.putNull(ContextSpecificTag(1)) }
    else {
      tlvWriter.put(ContextSpecificTag(1), primaryColor)
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class OtaSoftwareUpdateRequestorClusterProviderLocation(
        val providerNodeID: Long,
        val endpoint: Int,
        val fabricIndex: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("OtaSoftwareUpdateRequestorClusterProviderLocation {\n")
        builder.append("\tproviderNodeID : $providerNodeID\n")
        builder.append("\tendpoint : $endpoint\n")
        builder.append("\tfabricIndex : $fabricIndex\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(1), providerNodeID)
        tlvWriter.put(ContextSpecificTag(2), endpoint)
        tlvWriter.put(ContextSpecificTag(254), fabricIndex)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class PowerSourceClusterBatChargeFaultChangeType(
        val current: List<Int>,
        val previous: List<Int>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("PowerSourceClusterBatChargeFaultChangeType {\n")
        builder.append("\tcurrent : $current\n")
        builder.append("\tprevious : $previous\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.startList(ContextSpecificTag(0))
      val iter_current = current.iterator()
      while(iter_current.hasNext()) {
        val next = iter_current.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
        tlvWriter.startList(ContextSpecificTag(1))
      val iter_previous = previous.iterator()
      while(iter_previous.hasNext()) {
        val next = iter_previous.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class PowerSourceClusterBatFaultChangeType(
        val current: List<Int>,
        val previous: List<Int>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("PowerSourceClusterBatFaultChangeType {\n")
        builder.append("\tcurrent : $current\n")
        builder.append("\tprevious : $previous\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.startList(ContextSpecificTag(0))
      val iter_current = current.iterator()
      while(iter_current.hasNext()) {
        val next = iter_current.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
        tlvWriter.startList(ContextSpecificTag(1))
      val iter_previous = previous.iterator()
      while(iter_previous.hasNext()) {
        val next = iter_previous.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class PowerSourceClusterWiredFaultChangeType(
        val current: List<Int>,
        val previous: List<Int>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("PowerSourceClusterWiredFaultChangeType {\n")
        builder.append("\tcurrent : $current\n")
        builder.append("\tprevious : $previous\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.startList(ContextSpecificTag(0))
      val iter_current = current.iterator()
      while(iter_current.hasNext()) {
        val next = iter_current.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
        tlvWriter.startList(ContextSpecificTag(1))
      val iter_previous = previous.iterator()
      while(iter_previous.hasNext()) {
        val next = iter_previous.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class GeneralCommissioningClusterBasicCommissioningInfo(
        val failSafeExpiryLengthSeconds: Int,
        val maxCumulativeFailsafeSeconds: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("GeneralCommissioningClusterBasicCommissioningInfo {\n")
        builder.append("\tfailSafeExpiryLengthSeconds : $failSafeExpiryLengthSeconds\n")
        builder.append("\tmaxCumulativeFailsafeSeconds : $maxCumulativeFailsafeSeconds\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), failSafeExpiryLengthSeconds)
        tlvWriter.put(ContextSpecificTag(1), maxCumulativeFailsafeSeconds)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class NetworkCommissioningClusterNetworkInfoStruct(
        val networkID: ByteArray,
        val connected: Boolean) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("NetworkCommissioningClusterNetworkInfoStruct {\n")
        builder.append("\tnetworkID : $networkID\n")
        builder.append("\tconnected : $connected\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), networkID)
        tlvWriter.put(ContextSpecificTag(1), connected)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class NetworkCommissioningClusterThreadInterfaceScanResultStruct(
        val panId: Int,
        val extendedPanId: Long,
        val networkName: String,
        val channel: Int,
        val version: Int,
        val extendedAddress: ByteArray,
        val rssi: Int,
        val lqi: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("NetworkCommissioningClusterThreadInterfaceScanResultStruct {\n")
        builder.append("\tpanId : $panId\n")
        builder.append("\textendedPanId : $extendedPanId\n")
        builder.append("\tnetworkName : $networkName\n")
        builder.append("\tchannel : $channel\n")
        builder.append("\tversion : $version\n")
        builder.append("\textendedAddress : $extendedAddress\n")
        builder.append("\trssi : $rssi\n")
        builder.append("\tlqi : $lqi\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), panId)
        tlvWriter.put(ContextSpecificTag(1), extendedPanId)
        tlvWriter.put(ContextSpecificTag(2), networkName)
        tlvWriter.put(ContextSpecificTag(3), channel)
        tlvWriter.put(ContextSpecificTag(4), version)
        tlvWriter.put(ContextSpecificTag(5), extendedAddress)
        tlvWriter.put(ContextSpecificTag(6), rssi)
        tlvWriter.put(ContextSpecificTag(7), lqi)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class NetworkCommissioningClusterWiFiInterfaceScanResultStruct(
        val security: Int,
        val ssid: ByteArray,
        val bssid: ByteArray,
        val channel: Int,
        val wiFiBand: Int,
        val rssi: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("NetworkCommissioningClusterWiFiInterfaceScanResultStruct {\n")
        builder.append("\tsecurity : $security\n")
        builder.append("\tssid : $ssid\n")
        builder.append("\tbssid : $bssid\n")
        builder.append("\tchannel : $channel\n")
        builder.append("\twiFiBand : $wiFiBand\n")
        builder.append("\trssi : $rssi\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), security)
        tlvWriter.put(ContextSpecificTag(1), ssid)
        tlvWriter.put(ContextSpecificTag(2), bssid)
        tlvWriter.put(ContextSpecificTag(3), channel)
        tlvWriter.put(ContextSpecificTag(4), wiFiBand)
        tlvWriter.put(ContextSpecificTag(5), rssi)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class GeneralDiagnosticsClusterNetworkInterface(
        val name: String,
        val isOperational: Boolean,
        val offPremiseServicesReachableIPv4: Boolean?,
        val offPremiseServicesReachableIPv6: Boolean?,
        val hardwareAddress: ByteArray,
        val IPv4Addresses: List<ByteArray>,
        val IPv6Addresses: List<ByteArray>,
        val type: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("GeneralDiagnosticsClusterNetworkInterface {\n")
        builder.append("\tname : $name\n")
        builder.append("\tisOperational : $isOperational\n")
        builder.append("\toffPremiseServicesReachableIPv4 : $offPremiseServicesReachableIPv4\n")
        builder.append("\toffPremiseServicesReachableIPv6 : $offPremiseServicesReachableIPv6\n")
        builder.append("\thardwareAddress : $hardwareAddress\n")
        builder.append("\tIPv4Addresses : $IPv4Addresses\n")
        builder.append("\tIPv6Addresses : $IPv6Addresses\n")
        builder.append("\ttype : $type\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), name)
        tlvWriter.put(ContextSpecificTag(1), isOperational)
        if (offPremiseServicesReachableIPv4 == null) { tlvWriter.putNull(ContextSpecificTag(2)) }
    else {
      tlvWriter.put(ContextSpecificTag(2), offPremiseServicesReachableIPv4)
    }
        if (offPremiseServicesReachableIPv6 == null) { tlvWriter.putNull(ContextSpecificTag(3)) }
    else {
      tlvWriter.put(ContextSpecificTag(3), offPremiseServicesReachableIPv6)
    }
        tlvWriter.put(ContextSpecificTag(4), hardwareAddress)
        tlvWriter.startList(ContextSpecificTag(5))
      val iter_IPv4Addresses = IPv4Addresses.iterator()
      while(iter_IPv4Addresses.hasNext()) {
        val next = iter_IPv4Addresses.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
        tlvWriter.startList(ContextSpecificTag(6))
      val iter_IPv6Addresses = IPv6Addresses.iterator()
      while(iter_IPv6Addresses.hasNext()) {
        val next = iter_IPv6Addresses.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
        tlvWriter.put(ContextSpecificTag(7), type)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class SoftwareDiagnosticsClusterThreadMetricsStruct(
        val id: Long,
        val name: Optional<String>,
        val stackFreeCurrent: Optional<Long>,
        val stackFreeMinimum: Optional<Long>,
        val stackSize: Optional<Long>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("SoftwareDiagnosticsClusterThreadMetricsStruct {\n")
        builder.append("\tid : $id\n")
        builder.append("\tname : $name\n")
        builder.append("\tstackFreeCurrent : $stackFreeCurrent\n")
        builder.append("\tstackFreeMinimum : $stackFreeMinimum\n")
        builder.append("\tstackSize : $stackSize\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), id)
        if (name.isPresent) {
      val opt_name = name.get()
      tlvWriter.put(ContextSpecificTag(1), opt_name)
    }
        if (stackFreeCurrent.isPresent) {
      val opt_stackFreeCurrent = stackFreeCurrent.get()
      tlvWriter.put(ContextSpecificTag(2), opt_stackFreeCurrent)
    }
        if (stackFreeMinimum.isPresent) {
      val opt_stackFreeMinimum = stackFreeMinimum.get()
      tlvWriter.put(ContextSpecificTag(3), opt_stackFreeMinimum)
    }
        if (stackSize.isPresent) {
      val opt_stackSize = stackSize.get()
      tlvWriter.put(ContextSpecificTag(4), opt_stackSize)
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ThreadNetworkDiagnosticsClusterNeighborTableStruct(
        val extAddress: Long,
        val age: Long,
        val rloc16: Int,
        val linkFrameCounter: Long,
        val mleFrameCounter: Long,
        val lqi: Int,
        val averageRssi: Int?,
        val lastRssi: Int?,
        val frameErrorRate: Int,
        val messageErrorRate: Int,
        val rxOnWhenIdle: Boolean,
        val fullThreadDevice: Boolean,
        val fullNetworkData: Boolean,
        val isChild: Boolean) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ThreadNetworkDiagnosticsClusterNeighborTableStruct {\n")
        builder.append("\textAddress : $extAddress\n")
        builder.append("\tage : $age\n")
        builder.append("\trloc16 : $rloc16\n")
        builder.append("\tlinkFrameCounter : $linkFrameCounter\n")
        builder.append("\tmleFrameCounter : $mleFrameCounter\n")
        builder.append("\tlqi : $lqi\n")
        builder.append("\taverageRssi : $averageRssi\n")
        builder.append("\tlastRssi : $lastRssi\n")
        builder.append("\tframeErrorRate : $frameErrorRate\n")
        builder.append("\tmessageErrorRate : $messageErrorRate\n")
        builder.append("\trxOnWhenIdle : $rxOnWhenIdle\n")
        builder.append("\tfullThreadDevice : $fullThreadDevice\n")
        builder.append("\tfullNetworkData : $fullNetworkData\n")
        builder.append("\tisChild : $isChild\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), extAddress)
        tlvWriter.put(ContextSpecificTag(1), age)
        tlvWriter.put(ContextSpecificTag(2), rloc16)
        tlvWriter.put(ContextSpecificTag(3), linkFrameCounter)
        tlvWriter.put(ContextSpecificTag(4), mleFrameCounter)
        tlvWriter.put(ContextSpecificTag(5), lqi)
        if (averageRssi == null) { tlvWriter.putNull(ContextSpecificTag(6)) }
    else {
      tlvWriter.put(ContextSpecificTag(6), averageRssi)
    }
        if (lastRssi == null) { tlvWriter.putNull(ContextSpecificTag(7)) }
    else {
      tlvWriter.put(ContextSpecificTag(7), lastRssi)
    }
        tlvWriter.put(ContextSpecificTag(8), frameErrorRate)
        tlvWriter.put(ContextSpecificTag(9), messageErrorRate)
        tlvWriter.put(ContextSpecificTag(10), rxOnWhenIdle)
        tlvWriter.put(ContextSpecificTag(11), fullThreadDevice)
        tlvWriter.put(ContextSpecificTag(12), fullNetworkData)
        tlvWriter.put(ContextSpecificTag(13), isChild)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ThreadNetworkDiagnosticsClusterOperationalDatasetComponents(
        val activeTimestampPresent: Boolean,
        val pendingTimestampPresent: Boolean,
        val masterKeyPresent: Boolean,
        val networkNamePresent: Boolean,
        val extendedPanIdPresent: Boolean,
        val meshLocalPrefixPresent: Boolean,
        val delayPresent: Boolean,
        val panIdPresent: Boolean,
        val channelPresent: Boolean,
        val pskcPresent: Boolean,
        val securityPolicyPresent: Boolean,
        val channelMaskPresent: Boolean) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ThreadNetworkDiagnosticsClusterOperationalDatasetComponents {\n")
        builder.append("\tactiveTimestampPresent : $activeTimestampPresent\n")
        builder.append("\tpendingTimestampPresent : $pendingTimestampPresent\n")
        builder.append("\tmasterKeyPresent : $masterKeyPresent\n")
        builder.append("\tnetworkNamePresent : $networkNamePresent\n")
        builder.append("\textendedPanIdPresent : $extendedPanIdPresent\n")
        builder.append("\tmeshLocalPrefixPresent : $meshLocalPrefixPresent\n")
        builder.append("\tdelayPresent : $delayPresent\n")
        builder.append("\tpanIdPresent : $panIdPresent\n")
        builder.append("\tchannelPresent : $channelPresent\n")
        builder.append("\tpskcPresent : $pskcPresent\n")
        builder.append("\tsecurityPolicyPresent : $securityPolicyPresent\n")
        builder.append("\tchannelMaskPresent : $channelMaskPresent\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), activeTimestampPresent)
        tlvWriter.put(ContextSpecificTag(1), pendingTimestampPresent)
        tlvWriter.put(ContextSpecificTag(2), masterKeyPresent)
        tlvWriter.put(ContextSpecificTag(3), networkNamePresent)
        tlvWriter.put(ContextSpecificTag(4), extendedPanIdPresent)
        tlvWriter.put(ContextSpecificTag(5), meshLocalPrefixPresent)
        tlvWriter.put(ContextSpecificTag(6), delayPresent)
        tlvWriter.put(ContextSpecificTag(7), panIdPresent)
        tlvWriter.put(ContextSpecificTag(8), channelPresent)
        tlvWriter.put(ContextSpecificTag(9), pskcPresent)
        tlvWriter.put(ContextSpecificTag(10), securityPolicyPresent)
        tlvWriter.put(ContextSpecificTag(11), channelMaskPresent)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ThreadNetworkDiagnosticsClusterRouteTableStruct(
        val extAddress: Long,
        val rloc16: Int,
        val routerId: Int,
        val nextHop: Int,
        val pathCost: Int,
        val LQIIn: Int,
        val LQIOut: Int,
        val age: Int,
        val allocated: Boolean,
        val linkEstablished: Boolean) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ThreadNetworkDiagnosticsClusterRouteTableStruct {\n")
        builder.append("\textAddress : $extAddress\n")
        builder.append("\trloc16 : $rloc16\n")
        builder.append("\trouterId : $routerId\n")
        builder.append("\tnextHop : $nextHop\n")
        builder.append("\tpathCost : $pathCost\n")
        builder.append("\tLQIIn : $LQIIn\n")
        builder.append("\tLQIOut : $LQIOut\n")
        builder.append("\tage : $age\n")
        builder.append("\tallocated : $allocated\n")
        builder.append("\tlinkEstablished : $linkEstablished\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), extAddress)
        tlvWriter.put(ContextSpecificTag(1), rloc16)
        tlvWriter.put(ContextSpecificTag(2), routerId)
        tlvWriter.put(ContextSpecificTag(3), nextHop)
        tlvWriter.put(ContextSpecificTag(4), pathCost)
        tlvWriter.put(ContextSpecificTag(5), LQIIn)
        tlvWriter.put(ContextSpecificTag(6), LQIOut)
        tlvWriter.put(ContextSpecificTag(7), age)
        tlvWriter.put(ContextSpecificTag(8), allocated)
        tlvWriter.put(ContextSpecificTag(9), linkEstablished)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ThreadNetworkDiagnosticsClusterSecurityPolicy(
        val rotationTime: Int,
        val flags: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ThreadNetworkDiagnosticsClusterSecurityPolicy {\n")
        builder.append("\trotationTime : $rotationTime\n")
        builder.append("\tflags : $flags\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), rotationTime)
        tlvWriter.put(ContextSpecificTag(1), flags)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class TimeSynchronizationClusterDSTOffsetStruct(
        val offset: Long,
        val validStarting: Long,
        val validUntil: Long?) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("TimeSynchronizationClusterDSTOffsetStruct {\n")
        builder.append("\toffset : $offset\n")
        builder.append("\tvalidStarting : $validStarting\n")
        builder.append("\tvalidUntil : $validUntil\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), offset)
        tlvWriter.put(ContextSpecificTag(1), validStarting)
        if (validUntil == null) { tlvWriter.putNull(ContextSpecificTag(2)) }
    else {
      tlvWriter.put(ContextSpecificTag(2), validUntil)
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class TimeSynchronizationClusterFabricScopedTrustedTimeSourceStruct(
        val nodeID: Long,
        val endpoint: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("TimeSynchronizationClusterFabricScopedTrustedTimeSourceStruct {\n")
        builder.append("\tnodeID : $nodeID\n")
        builder.append("\tendpoint : $endpoint\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), nodeID)
        tlvWriter.put(ContextSpecificTag(1), endpoint)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class TimeSynchronizationClusterTimeZoneStruct(
        val offset: Long,
        val validAt: Long,
        val name: Optional<String>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("TimeSynchronizationClusterTimeZoneStruct {\n")
        builder.append("\toffset : $offset\n")
        builder.append("\tvalidAt : $validAt\n")
        builder.append("\tname : $name\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), offset)
        tlvWriter.put(ContextSpecificTag(1), validAt)
        if (name.isPresent) {
      val opt_name = name.get()
      tlvWriter.put(ContextSpecificTag(2), opt_name)
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class TimeSynchronizationClusterTrustedTimeSourceStruct(
        val fabricIndex: Int,
        val nodeID: Long,
        val endpoint: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("TimeSynchronizationClusterTrustedTimeSourceStruct {\n")
        builder.append("\tfabricIndex : $fabricIndex\n")
        builder.append("\tnodeID : $nodeID\n")
        builder.append("\tendpoint : $endpoint\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), fabricIndex)
        tlvWriter.put(ContextSpecificTag(1), nodeID)
        tlvWriter.put(ContextSpecificTag(2), endpoint)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class BridgedDeviceBasicInformationClusterProductAppearanceStruct(
        val finish: Int,
        val primaryColor: Int?) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("BridgedDeviceBasicInformationClusterProductAppearanceStruct {\n")
        builder.append("\tfinish : $finish\n")
        builder.append("\tprimaryColor : $primaryColor\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), finish)
        if (primaryColor == null) { tlvWriter.putNull(ContextSpecificTag(1)) }
    else {
      tlvWriter.put(ContextSpecificTag(1), primaryColor)
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class OperationalCredentialsClusterFabricDescriptorStruct(
        val rootPublicKey: ByteArray,
        val vendorID: Int,
        val fabricID: Long,
        val nodeID: Long,
        val label: String,
        val fabricIndex: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("OperationalCredentialsClusterFabricDescriptorStruct {\n")
        builder.append("\trootPublicKey : $rootPublicKey\n")
        builder.append("\tvendorID : $vendorID\n")
        builder.append("\tfabricID : $fabricID\n")
        builder.append("\tnodeID : $nodeID\n")
        builder.append("\tlabel : $label\n")
        builder.append("\tfabricIndex : $fabricIndex\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(1), rootPublicKey)
        tlvWriter.put(ContextSpecificTag(2), vendorID)
        tlvWriter.put(ContextSpecificTag(3), fabricID)
        tlvWriter.put(ContextSpecificTag(4), nodeID)
        tlvWriter.put(ContextSpecificTag(5), label)
        tlvWriter.put(ContextSpecificTag(254), fabricIndex)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class OperationalCredentialsClusterNOCStruct(
        val noc: ByteArray,
        val icac: ByteArray?,
        val fabricIndex: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("OperationalCredentialsClusterNOCStruct {\n")
        builder.append("\tnoc : $noc\n")
        builder.append("\ticac : $icac\n")
        builder.append("\tfabricIndex : $fabricIndex\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(1), noc)
        if (icac == null) { tlvWriter.putNull(ContextSpecificTag(2)) }
    else {
      tlvWriter.put(ContextSpecificTag(2), icac)
    }
        tlvWriter.put(ContextSpecificTag(254), fabricIndex)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class GroupKeyManagementClusterGroupInfoMapStruct(
        val groupId: Int,
        val endpoints: List<Int>,
        val groupName: Optional<String>,
        val fabricIndex: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("GroupKeyManagementClusterGroupInfoMapStruct {\n")
        builder.append("\tgroupId : $groupId\n")
        builder.append("\tendpoints : $endpoints\n")
        builder.append("\tgroupName : $groupName\n")
        builder.append("\tfabricIndex : $fabricIndex\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(1), groupId)
        tlvWriter.startList(ContextSpecificTag(2))
      val iter_endpoints = endpoints.iterator()
      while(iter_endpoints.hasNext()) {
        val next = iter_endpoints.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
        if (groupName.isPresent) {
      val opt_groupName = groupName.get()
      tlvWriter.put(ContextSpecificTag(3), opt_groupName)
    }
        tlvWriter.put(ContextSpecificTag(254), fabricIndex)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class GroupKeyManagementClusterGroupKeyMapStruct(
        val groupId: Int,
        val groupKeySetID: Int,
        val fabricIndex: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("GroupKeyManagementClusterGroupKeyMapStruct {\n")
        builder.append("\tgroupId : $groupId\n")
        builder.append("\tgroupKeySetID : $groupKeySetID\n")
        builder.append("\tfabricIndex : $fabricIndex\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(1), groupId)
        tlvWriter.put(ContextSpecificTag(2), groupKeySetID)
        tlvWriter.put(ContextSpecificTag(254), fabricIndex)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class GroupKeyManagementClusterGroupKeySetStruct(
        val groupKeySetID: Int,
        val groupKeySecurityPolicy: Int,
        val epochKey0: ByteArray?,
        val epochStartTime0: Long?,
        val epochKey1: ByteArray?,
        val epochStartTime1: Long?,
        val epochKey2: ByteArray?,
        val epochStartTime2: Long?) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("GroupKeyManagementClusterGroupKeySetStruct {\n")
        builder.append("\tgroupKeySetID : $groupKeySetID\n")
        builder.append("\tgroupKeySecurityPolicy : $groupKeySecurityPolicy\n")
        builder.append("\tepochKey0 : $epochKey0\n")
        builder.append("\tepochStartTime0 : $epochStartTime0\n")
        builder.append("\tepochKey1 : $epochKey1\n")
        builder.append("\tepochStartTime1 : $epochStartTime1\n")
        builder.append("\tepochKey2 : $epochKey2\n")
        builder.append("\tepochStartTime2 : $epochStartTime2\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), groupKeySetID)
        tlvWriter.put(ContextSpecificTag(1), groupKeySecurityPolicy)
        if (epochKey0 == null) { tlvWriter.putNull(ContextSpecificTag(2)) }
    else {
      tlvWriter.put(ContextSpecificTag(2), epochKey0)
    }
        if (epochStartTime0 == null) { tlvWriter.putNull(ContextSpecificTag(3)) }
    else {
      tlvWriter.put(ContextSpecificTag(3), epochStartTime0)
    }
        if (epochKey1 == null) { tlvWriter.putNull(ContextSpecificTag(4)) }
    else {
      tlvWriter.put(ContextSpecificTag(4), epochKey1)
    }
        if (epochStartTime1 == null) { tlvWriter.putNull(ContextSpecificTag(5)) }
    else {
      tlvWriter.put(ContextSpecificTag(5), epochStartTime1)
    }
        if (epochKey2 == null) { tlvWriter.putNull(ContextSpecificTag(6)) }
    else {
      tlvWriter.put(ContextSpecificTag(6), epochKey2)
    }
        if (epochStartTime2 == null) { tlvWriter.putNull(ContextSpecificTag(7)) }
    else {
      tlvWriter.put(ContextSpecificTag(7), epochStartTime2)
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class FixedLabelClusterLabelStruct(
        val label: String,
        val value: String) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("FixedLabelClusterLabelStruct {\n")
        builder.append("\tlabel : $label\n")
        builder.append("\tvalue : $value\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), label)
        tlvWriter.put(ContextSpecificTag(1), value)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class UserLabelClusterLabelStruct(
        val label: String,
        val value: String) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("UserLabelClusterLabelStruct {\n")
        builder.append("\tlabel : $label\n")
        builder.append("\tvalue : $value\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), label)
        tlvWriter.put(ContextSpecificTag(1), value)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class IcdManagementClusterMonitoringRegistrationStruct(
        val checkInNodeID: Long,
        val monitoredSubject: Long,
        val key: ByteArray,
        val fabricIndex: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("IcdManagementClusterMonitoringRegistrationStruct {\n")
        builder.append("\tcheckInNodeID : $checkInNodeID\n")
        builder.append("\tmonitoredSubject : $monitoredSubject\n")
        builder.append("\tkey : $key\n")
        builder.append("\tfabricIndex : $fabricIndex\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(1), checkInNodeID)
        tlvWriter.put(ContextSpecificTag(2), monitoredSubject)
        tlvWriter.put(ContextSpecificTag(3), key)
        tlvWriter.put(ContextSpecificTag(254), fabricIndex)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ModeSelectClusterSemanticTagStruct(
        val mfgCode: Int,
        val value: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ModeSelectClusterSemanticTagStruct {\n")
        builder.append("\tmfgCode : $mfgCode\n")
        builder.append("\tvalue : $value\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), mfgCode)
        tlvWriter.put(ContextSpecificTag(1), value)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ModeSelectClusterModeOptionStruct(
        val label: String,
        val mode: Int,
        val semanticTags: List<ModeSelectClusterSemanticTagStruct>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ModeSelectClusterModeOptionStruct {\n")
        builder.append("\tlabel : $label\n")
        builder.append("\tmode : $mode\n")
        builder.append("\tsemanticTags : $semanticTags\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), label)
        tlvWriter.put(ContextSpecificTag(1), mode)
        tlvWriter.startList(ContextSpecificTag(2))
      val iter_semanticTags = semanticTags.iterator()
      while(iter_semanticTags.hasNext()) {
        val next = iter_semanticTags.next()
        next.toTlv(AnonymousTag, tlvWriter)
      }
      tlvWriter.endList()
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class LaundryWasherModeClusterModeTagStruct(
        val mfgCode: Optional<Int>,
        val value: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("LaundryWasherModeClusterModeTagStruct {\n")
        builder.append("\tmfgCode : $mfgCode\n")
        builder.append("\tvalue : $value\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        if (mfgCode.isPresent) {
      val opt_mfgCode = mfgCode.get()
      tlvWriter.put(ContextSpecificTag(0), opt_mfgCode)
    }
        tlvWriter.put(ContextSpecificTag(1), value)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class LaundryWasherModeClusterModeOptionStruct(
        val label: String,
        val mode: Int,
        val modeTags: List<LaundryWasherModeClusterModeTagStruct>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("LaundryWasherModeClusterModeOptionStruct {\n")
        builder.append("\tlabel : $label\n")
        builder.append("\tmode : $mode\n")
        builder.append("\tmodeTags : $modeTags\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), label)
        tlvWriter.put(ContextSpecificTag(1), mode)
        tlvWriter.startList(ContextSpecificTag(2))
      val iter_modeTags = modeTags.iterator()
      while(iter_modeTags.hasNext()) {
        val next = iter_modeTags.next()
        next.toTlv(AnonymousTag, tlvWriter)
      }
      tlvWriter.endList()
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class RefrigeratorAndTemperatureControlledCabinetModeClusterModeTagStruct(
        val mfgCode: Optional<Int>,
        val value: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("RefrigeratorAndTemperatureControlledCabinetModeClusterModeTagStruct {\n")
        builder.append("\tmfgCode : $mfgCode\n")
        builder.append("\tvalue : $value\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        if (mfgCode.isPresent) {
      val opt_mfgCode = mfgCode.get()
      tlvWriter.put(ContextSpecificTag(0), opt_mfgCode)
    }
        tlvWriter.put(ContextSpecificTag(1), value)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class RefrigeratorAndTemperatureControlledCabinetModeClusterModeOptionStruct(
        val label: String,
        val mode: Int,
        val modeTags: List<RefrigeratorAndTemperatureControlledCabinetModeClusterModeTagStruct>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("RefrigeratorAndTemperatureControlledCabinetModeClusterModeOptionStruct {\n")
        builder.append("\tlabel : $label\n")
        builder.append("\tmode : $mode\n")
        builder.append("\tmodeTags : $modeTags\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), label)
        tlvWriter.put(ContextSpecificTag(1), mode)
        tlvWriter.startList(ContextSpecificTag(2))
      val iter_modeTags = modeTags.iterator()
      while(iter_modeTags.hasNext()) {
        val next = iter_modeTags.next()
        next.toTlv(AnonymousTag, tlvWriter)
      }
      tlvWriter.endList()
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class RvcRunModeClusterModeTagStruct(
        val mfgCode: Optional<Int>,
        val value: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("RvcRunModeClusterModeTagStruct {\n")
        builder.append("\tmfgCode : $mfgCode\n")
        builder.append("\tvalue : $value\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        if (mfgCode.isPresent) {
      val opt_mfgCode = mfgCode.get()
      tlvWriter.put(ContextSpecificTag(0), opt_mfgCode)
    }
        tlvWriter.put(ContextSpecificTag(1), value)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class RvcRunModeClusterModeOptionStruct(
        val label: String,
        val mode: Int,
        val modeTags: List<RvcRunModeClusterModeTagStruct>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("RvcRunModeClusterModeOptionStruct {\n")
        builder.append("\tlabel : $label\n")
        builder.append("\tmode : $mode\n")
        builder.append("\tmodeTags : $modeTags\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), label)
        tlvWriter.put(ContextSpecificTag(1), mode)
        tlvWriter.startList(ContextSpecificTag(2))
      val iter_modeTags = modeTags.iterator()
      while(iter_modeTags.hasNext()) {
        val next = iter_modeTags.next()
        next.toTlv(AnonymousTag, tlvWriter)
      }
      tlvWriter.endList()
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class RvcCleanModeClusterModeTagStruct(
        val mfgCode: Optional<Int>,
        val value: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("RvcCleanModeClusterModeTagStruct {\n")
        builder.append("\tmfgCode : $mfgCode\n")
        builder.append("\tvalue : $value\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        if (mfgCode.isPresent) {
      val opt_mfgCode = mfgCode.get()
      tlvWriter.put(ContextSpecificTag(0), opt_mfgCode)
    }
        tlvWriter.put(ContextSpecificTag(1), value)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class RvcCleanModeClusterModeOptionStruct(
        val label: String,
        val mode: Int,
        val modeTags: List<RvcCleanModeClusterModeTagStruct>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("RvcCleanModeClusterModeOptionStruct {\n")
        builder.append("\tlabel : $label\n")
        builder.append("\tmode : $mode\n")
        builder.append("\tmodeTags : $modeTags\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), label)
        tlvWriter.put(ContextSpecificTag(1), mode)
        tlvWriter.startList(ContextSpecificTag(2))
      val iter_modeTags = modeTags.iterator()
      while(iter_modeTags.hasNext()) {
        val next = iter_modeTags.next()
        next.toTlv(AnonymousTag, tlvWriter)
      }
      tlvWriter.endList()
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class DishwasherModeClusterModeTagStruct(
        val mfgCode: Optional<Int>,
        val value: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("DishwasherModeClusterModeTagStruct {\n")
        builder.append("\tmfgCode : $mfgCode\n")
        builder.append("\tvalue : $value\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        if (mfgCode.isPresent) {
      val opt_mfgCode = mfgCode.get()
      tlvWriter.put(ContextSpecificTag(0), opt_mfgCode)
    }
        tlvWriter.put(ContextSpecificTag(1), value)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class DishwasherModeClusterModeOptionStruct(
        val label: String,
        val mode: Int,
        val modeTags: List<DishwasherModeClusterModeTagStruct>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("DishwasherModeClusterModeOptionStruct {\n")
        builder.append("\tlabel : $label\n")
        builder.append("\tmode : $mode\n")
        builder.append("\tmodeTags : $modeTags\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), label)
        tlvWriter.put(ContextSpecificTag(1), mode)
        tlvWriter.startList(ContextSpecificTag(2))
      val iter_modeTags = modeTags.iterator()
      while(iter_modeTags.hasNext()) {
        val next = iter_modeTags.next()
        next.toTlv(AnonymousTag, tlvWriter)
      }
      tlvWriter.endList()
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class OperationalStateClusterErrorStateStruct(
        val errorStateID: Int,
        val errorStateLabel: Optional<String>,
        val errorStateDetails: Optional<String>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("OperationalStateClusterErrorStateStruct {\n")
        builder.append("\terrorStateID : $errorStateID\n")
        builder.append("\terrorStateLabel : $errorStateLabel\n")
        builder.append("\terrorStateDetails : $errorStateDetails\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), errorStateID)
        if (errorStateLabel.isPresent) {
      val opt_errorStateLabel = errorStateLabel.get()
      tlvWriter.put(ContextSpecificTag(1), opt_errorStateLabel)
    }
        if (errorStateDetails.isPresent) {
      val opt_errorStateDetails = errorStateDetails.get()
      tlvWriter.put(ContextSpecificTag(2), opt_errorStateDetails)
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class OperationalStateClusterOperationalStateStruct(
        val operationalStateID: Int,
        val operationalStateLabel: Optional<String>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("OperationalStateClusterOperationalStateStruct {\n")
        builder.append("\toperationalStateID : $operationalStateID\n")
        builder.append("\toperationalStateLabel : $operationalStateLabel\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), operationalStateID)
        if (operationalStateLabel.isPresent) {
      val opt_operationalStateLabel = operationalStateLabel.get()
      tlvWriter.put(ContextSpecificTag(1), opt_operationalStateLabel)
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class RvcOperationalStateClusterErrorStateStruct(
        val errorStateID: Int,
        val errorStateLabel: Optional<String>,
        val errorStateDetails: Optional<String>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("RvcOperationalStateClusterErrorStateStruct {\n")
        builder.append("\terrorStateID : $errorStateID\n")
        builder.append("\terrorStateLabel : $errorStateLabel\n")
        builder.append("\terrorStateDetails : $errorStateDetails\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), errorStateID)
        if (errorStateLabel.isPresent) {
      val opt_errorStateLabel = errorStateLabel.get()
      tlvWriter.put(ContextSpecificTag(1), opt_errorStateLabel)
    }
        if (errorStateDetails.isPresent) {
      val opt_errorStateDetails = errorStateDetails.get()
      tlvWriter.put(ContextSpecificTag(2), opt_errorStateDetails)
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class RvcOperationalStateClusterOperationalStateStruct(
        val operationalStateID: Int,
        val operationalStateLabel: Optional<String>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("RvcOperationalStateClusterOperationalStateStruct {\n")
        builder.append("\toperationalStateID : $operationalStateID\n")
        builder.append("\toperationalStateLabel : $operationalStateLabel\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), operationalStateID)
        if (operationalStateLabel.isPresent) {
      val opt_operationalStateLabel = operationalStateLabel.get()
      tlvWriter.put(ContextSpecificTag(1), opt_operationalStateLabel)
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class DoorLockClusterCredentialStruct(
        val credentialType: Int,
        val credentialIndex: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("DoorLockClusterCredentialStruct {\n")
        builder.append("\tcredentialType : $credentialType\n")
        builder.append("\tcredentialIndex : $credentialIndex\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), credentialType)
        tlvWriter.put(ContextSpecificTag(1), credentialIndex)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ThermostatClusterThermostatScheduleTransition(
        val transitionTime: Int,
        val heatSetpoint: Int?,
        val coolSetpoint: Int?) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ThermostatClusterThermostatScheduleTransition {\n")
        builder.append("\ttransitionTime : $transitionTime\n")
        builder.append("\theatSetpoint : $heatSetpoint\n")
        builder.append("\tcoolSetpoint : $coolSetpoint\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), transitionTime)
        if (heatSetpoint == null) { tlvWriter.putNull(ContextSpecificTag(1)) }
    else {
      tlvWriter.put(ContextSpecificTag(1), heatSetpoint)
    }
        if (coolSetpoint == null) { tlvWriter.putNull(ContextSpecificTag(2)) }
    else {
      tlvWriter.put(ContextSpecificTag(2), coolSetpoint)
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ChannelClusterChannelInfoStruct(
        val majorNumber: Int,
        val minorNumber: Int,
        val name: Optional<String>,
        val callSign: Optional<String>,
        val affiliateCallSign: Optional<String>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ChannelClusterChannelInfoStruct {\n")
        builder.append("\tmajorNumber : $majorNumber\n")
        builder.append("\tminorNumber : $minorNumber\n")
        builder.append("\tname : $name\n")
        builder.append("\tcallSign : $callSign\n")
        builder.append("\taffiliateCallSign : $affiliateCallSign\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), majorNumber)
        tlvWriter.put(ContextSpecificTag(1), minorNumber)
        if (name.isPresent) {
      val opt_name = name.get()
      tlvWriter.put(ContextSpecificTag(2), opt_name)
    }
        if (callSign.isPresent) {
      val opt_callSign = callSign.get()
      tlvWriter.put(ContextSpecificTag(3), opt_callSign)
    }
        if (affiliateCallSign.isPresent) {
      val opt_affiliateCallSign = affiliateCallSign.get()
      tlvWriter.put(ContextSpecificTag(4), opt_affiliateCallSign)
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ChannelClusterLineupInfoStruct(
        val operatorName: String,
        val lineupName: Optional<String>,
        val postalCode: Optional<String>,
        val lineupInfoType: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ChannelClusterLineupInfoStruct {\n")
        builder.append("\toperatorName : $operatorName\n")
        builder.append("\tlineupName : $lineupName\n")
        builder.append("\tpostalCode : $postalCode\n")
        builder.append("\tlineupInfoType : $lineupInfoType\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), operatorName)
        if (lineupName.isPresent) {
      val opt_lineupName = lineupName.get()
      tlvWriter.put(ContextSpecificTag(1), opt_lineupName)
    }
        if (postalCode.isPresent) {
      val opt_postalCode = postalCode.get()
      tlvWriter.put(ContextSpecificTag(2), opt_postalCode)
    }
        tlvWriter.put(ContextSpecificTag(3), lineupInfoType)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class TargetNavigatorClusterTargetInfoStruct(
        val identifier: Int,
        val name: String) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("TargetNavigatorClusterTargetInfoStruct {\n")
        builder.append("\tidentifier : $identifier\n")
        builder.append("\tname : $name\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), identifier)
        tlvWriter.put(ContextSpecificTag(1), name)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class MediaPlaybackClusterPlaybackPositionStruct(
        val updatedAt: Long,
        val position: Long?) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("MediaPlaybackClusterPlaybackPositionStruct {\n")
        builder.append("\tupdatedAt : $updatedAt\n")
        builder.append("\tposition : $position\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), updatedAt)
        if (position == null) { tlvWriter.putNull(ContextSpecificTag(1)) }
    else {
      tlvWriter.put(ContextSpecificTag(1), position)
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class MediaInputClusterInputInfoStruct(
        val index: Int,
        val inputType: Int,
        val name: String,
        val description: String) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("MediaInputClusterInputInfoStruct {\n")
        builder.append("\tindex : $index\n")
        builder.append("\tinputType : $inputType\n")
        builder.append("\tname : $name\n")
        builder.append("\tdescription : $description\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), index)
        tlvWriter.put(ContextSpecificTag(1), inputType)
        tlvWriter.put(ContextSpecificTag(2), name)
        tlvWriter.put(ContextSpecificTag(3), description)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ContentLauncherClusterDimensionStruct(
        val width: Double,
        val height: Double,
        val metric: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ContentLauncherClusterDimensionStruct {\n")
        builder.append("\twidth : $width\n")
        builder.append("\theight : $height\n")
        builder.append("\tmetric : $metric\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), width)
        tlvWriter.put(ContextSpecificTag(1), height)
        tlvWriter.put(ContextSpecificTag(2), metric)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ContentLauncherClusterAdditionalInfoStruct(
        val name: String,
        val value: String) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ContentLauncherClusterAdditionalInfoStruct {\n")
        builder.append("\tname : $name\n")
        builder.append("\tvalue : $value\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), name)
        tlvWriter.put(ContextSpecificTag(1), value)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ContentLauncherClusterParameterStruct(
        val type: Int,
        val value: String,
        val externalIDList: Optional<List<ContentLauncherClusterAdditionalInfoStruct>>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ContentLauncherClusterParameterStruct {\n")
        builder.append("\ttype : $type\n")
        builder.append("\tvalue : $value\n")
        builder.append("\texternalIDList : $externalIDList\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), type)
        tlvWriter.put(ContextSpecificTag(1), value)
        if (externalIDList.isPresent) {
      val opt_externalIDList = externalIDList.get()
      tlvWriter.startList(ContextSpecificTag(2))
      val iter_opt_externalIDList = opt_externalIDList.iterator()
      while(iter_opt_externalIDList.hasNext()) {
        val next = iter_opt_externalIDList.next()
        next.toTlv(AnonymousTag, tlvWriter)
      }
      tlvWriter.endList()
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ContentLauncherClusterContentSearchStruct(
        val parameterList: List<ContentLauncherClusterParameterStruct>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ContentLauncherClusterContentSearchStruct {\n")
        builder.append("\tparameterList : $parameterList\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.startList(ContextSpecificTag(0))
      val iter_parameterList = parameterList.iterator()
      while(iter_parameterList.hasNext()) {
        val next = iter_parameterList.next()
        next.toTlv(AnonymousTag, tlvWriter)
      }
      tlvWriter.endList()
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ContentLauncherClusterStyleInformationStruct(
        val imageURL: Optional<String>,
        val color: Optional<String>,
        val size: Optional<ContentLauncherClusterDimensionStruct>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ContentLauncherClusterStyleInformationStruct {\n")
        builder.append("\timageURL : $imageURL\n")
        builder.append("\tcolor : $color\n")
        builder.append("\tsize : $size\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        if (imageURL.isPresent) {
      val opt_imageURL = imageURL.get()
      tlvWriter.put(ContextSpecificTag(0), opt_imageURL)
    }
        if (color.isPresent) {
      val opt_color = color.get()
      tlvWriter.put(ContextSpecificTag(1), opt_color)
    }
        if (size.isPresent) {
      val opt_size = size.get()
      opt_size.toTlv(ContextSpecificTag(2), tlvWriter)
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ContentLauncherClusterBrandingInformationStruct(
        val providerName: String,
        val background: Optional<ContentLauncherClusterStyleInformationStruct>,
        val logo: Optional<ContentLauncherClusterStyleInformationStruct>,
        val progressBar: Optional<ContentLauncherClusterStyleInformationStruct>,
        val splash: Optional<ContentLauncherClusterStyleInformationStruct>,
        val waterMark: Optional<ContentLauncherClusterStyleInformationStruct>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ContentLauncherClusterBrandingInformationStruct {\n")
        builder.append("\tproviderName : $providerName\n")
        builder.append("\tbackground : $background\n")
        builder.append("\tlogo : $logo\n")
        builder.append("\tprogressBar : $progressBar\n")
        builder.append("\tsplash : $splash\n")
        builder.append("\twaterMark : $waterMark\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), providerName)
        if (background.isPresent) {
      val opt_background = background.get()
      opt_background.toTlv(ContextSpecificTag(1), tlvWriter)
    }
        if (logo.isPresent) {
      val opt_logo = logo.get()
      opt_logo.toTlv(ContextSpecificTag(2), tlvWriter)
    }
        if (progressBar.isPresent) {
      val opt_progressBar = progressBar.get()
      opt_progressBar.toTlv(ContextSpecificTag(3), tlvWriter)
    }
        if (splash.isPresent) {
      val opt_splash = splash.get()
      opt_splash.toTlv(ContextSpecificTag(4), tlvWriter)
    }
        if (waterMark.isPresent) {
      val opt_waterMark = waterMark.get()
      opt_waterMark.toTlv(ContextSpecificTag(5), tlvWriter)
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class AudioOutputClusterOutputInfoStruct(
        val index: Int,
        val outputType: Int,
        val name: String) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("AudioOutputClusterOutputInfoStruct {\n")
        builder.append("\tindex : $index\n")
        builder.append("\toutputType : $outputType\n")
        builder.append("\tname : $name\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), index)
        tlvWriter.put(ContextSpecificTag(1), outputType)
        tlvWriter.put(ContextSpecificTag(2), name)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ApplicationLauncherClusterApplicationStruct(
        val catalogVendorID: Int,
        val applicationID: String) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ApplicationLauncherClusterApplicationStruct {\n")
        builder.append("\tcatalogVendorID : $catalogVendorID\n")
        builder.append("\tapplicationID : $applicationID\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), catalogVendorID)
        tlvWriter.put(ContextSpecificTag(1), applicationID)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ApplicationLauncherClusterApplicationEPStruct(
        val application: ApplicationLauncherClusterApplicationStruct,
        val endpoint: Optional<Int>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ApplicationLauncherClusterApplicationEPStruct {\n")
        builder.append("\tapplication : $application\n")
        builder.append("\tendpoint : $endpoint\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        application.toTlv(ContextSpecificTag(0), tlvWriter)
        if (endpoint.isPresent) {
      val opt_endpoint = endpoint.get()
      tlvWriter.put(ContextSpecificTag(1), opt_endpoint)
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class ApplicationBasicClusterApplicationStruct(
        val catalogVendorID: Int,
        val applicationID: String) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("ApplicationBasicClusterApplicationStruct {\n")
        builder.append("\tcatalogVendorID : $catalogVendorID\n")
        builder.append("\tapplicationID : $applicationID\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), catalogVendorID)
        tlvWriter.put(ContextSpecificTag(1), applicationID)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class UnitTestingClusterSimpleStruct(
        val a: Int,
        val b: Boolean,
        val c: Int,
        val d: ByteArray,
        val e: String,
        val f: Int,
        val g: Float,
        val h: Double) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("UnitTestingClusterSimpleStruct {\n")
        builder.append("\ta : $a\n")
        builder.append("\tb : $b\n")
        builder.append("\tc : $c\n")
        builder.append("\td : $d\n")
        builder.append("\te : $e\n")
        builder.append("\tf : $f\n")
        builder.append("\tg : $g\n")
        builder.append("\th : $h\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), a)
        tlvWriter.put(ContextSpecificTag(1), b)
        tlvWriter.put(ContextSpecificTag(2), c)
        tlvWriter.put(ContextSpecificTag(3), d)
        tlvWriter.put(ContextSpecificTag(4), e)
        tlvWriter.put(ContextSpecificTag(5), f)
        tlvWriter.put(ContextSpecificTag(6), g)
        tlvWriter.put(ContextSpecificTag(7), h)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class UnitTestingClusterTestFabricScoped(
        val fabricSensitiveInt8u: Int,
        val optionalFabricSensitiveInt8u: Optional<Int>,
        val nullableFabricSensitiveInt8u: Int?,
        val nullableOptionalFabricSensitiveInt8u: Optional<Int>?,
        val fabricSensitiveCharString: String,
        val fabricSensitiveStruct: UnitTestingClusterSimpleStruct,
        val fabricSensitiveInt8uList: List<Int>,
        val fabricIndex: Int) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("UnitTestingClusterTestFabricScoped {\n")
        builder.append("\tfabricSensitiveInt8u : $fabricSensitiveInt8u\n")
        builder.append("\toptionalFabricSensitiveInt8u : $optionalFabricSensitiveInt8u\n")
        builder.append("\tnullableFabricSensitiveInt8u : $nullableFabricSensitiveInt8u\n")
        builder.append("\tnullableOptionalFabricSensitiveInt8u : $nullableOptionalFabricSensitiveInt8u\n")
        builder.append("\tfabricSensitiveCharString : $fabricSensitiveCharString\n")
        builder.append("\tfabricSensitiveStruct : $fabricSensitiveStruct\n")
        builder.append("\tfabricSensitiveInt8uList : $fabricSensitiveInt8uList\n")
        builder.append("\tfabricIndex : $fabricIndex\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(1), fabricSensitiveInt8u)
        if (optionalFabricSensitiveInt8u.isPresent) {
      val opt_optionalFabricSensitiveInt8u = optionalFabricSensitiveInt8u.get()
      tlvWriter.put(ContextSpecificTag(2), opt_optionalFabricSensitiveInt8u)
    }
        if (nullableFabricSensitiveInt8u == null) { tlvWriter.putNull(ContextSpecificTag(3)) }
    else {
      tlvWriter.put(ContextSpecificTag(3), nullableFabricSensitiveInt8u)
    }
        if (nullableOptionalFabricSensitiveInt8u == null) { tlvWriter.putNull(ContextSpecificTag(4)) }
    else {
      if (nullableOptionalFabricSensitiveInt8u.isPresent) {
      val opt_nullableOptionalFabricSensitiveInt8u = nullableOptionalFabricSensitiveInt8u.get()
      tlvWriter.put(ContextSpecificTag(4), opt_nullableOptionalFabricSensitiveInt8u)
    }
    }
        tlvWriter.put(ContextSpecificTag(5), fabricSensitiveCharString)
        fabricSensitiveStruct.toTlv(ContextSpecificTag(6), tlvWriter)
        tlvWriter.startList(ContextSpecificTag(7))
      val iter_fabricSensitiveInt8uList = fabricSensitiveInt8uList.iterator()
      while(iter_fabricSensitiveInt8uList.hasNext()) {
        val next = iter_fabricSensitiveInt8uList.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
        tlvWriter.put(ContextSpecificTag(254), fabricIndex)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class UnitTestingClusterNullablesAndOptionalsStruct(
        val nullableInt: Int?,
        val optionalInt: Optional<Int>,
        val nullableOptionalInt: Optional<Int>?,
        val nullableString: String?,
        val optionalString: Optional<String>,
        val nullableOptionalString: Optional<String>?,
        val nullableStruct: UnitTestingClusterSimpleStruct?,
        val optionalStruct: Optional<UnitTestingClusterSimpleStruct>,
        val nullableOptionalStruct: Optional<UnitTestingClusterSimpleStruct>?,
        val nullableList: List<Int>?,
        val optionalList: Optional<List<Int>>,
        val nullableOptionalList: Optional<List<Int>>?) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("UnitTestingClusterNullablesAndOptionalsStruct {\n")
        builder.append("\tnullableInt : $nullableInt\n")
        builder.append("\toptionalInt : $optionalInt\n")
        builder.append("\tnullableOptionalInt : $nullableOptionalInt\n")
        builder.append("\tnullableString : $nullableString\n")
        builder.append("\toptionalString : $optionalString\n")
        builder.append("\tnullableOptionalString : $nullableOptionalString\n")
        builder.append("\tnullableStruct : $nullableStruct\n")
        builder.append("\toptionalStruct : $optionalStruct\n")
        builder.append("\tnullableOptionalStruct : $nullableOptionalStruct\n")
        builder.append("\tnullableList : $nullableList\n")
        builder.append("\toptionalList : $optionalList\n")
        builder.append("\tnullableOptionalList : $nullableOptionalList\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        if (nullableInt == null) { tlvWriter.putNull(ContextSpecificTag(0)) }
    else {
      tlvWriter.put(ContextSpecificTag(0), nullableInt)
    }
        if (optionalInt.isPresent) {
      val opt_optionalInt = optionalInt.get()
      tlvWriter.put(ContextSpecificTag(1), opt_optionalInt)
    }
        if (nullableOptionalInt == null) { tlvWriter.putNull(ContextSpecificTag(2)) }
    else {
      if (nullableOptionalInt.isPresent) {
      val opt_nullableOptionalInt = nullableOptionalInt.get()
      tlvWriter.put(ContextSpecificTag(2), opt_nullableOptionalInt)
    }
    }
        if (nullableString == null) { tlvWriter.putNull(ContextSpecificTag(3)) }
    else {
      tlvWriter.put(ContextSpecificTag(3), nullableString)
    }
        if (optionalString.isPresent) {
      val opt_optionalString = optionalString.get()
      tlvWriter.put(ContextSpecificTag(4), opt_optionalString)
    }
        if (nullableOptionalString == null) { tlvWriter.putNull(ContextSpecificTag(5)) }
    else {
      if (nullableOptionalString.isPresent) {
      val opt_nullableOptionalString = nullableOptionalString.get()
      tlvWriter.put(ContextSpecificTag(5), opt_nullableOptionalString)
    }
    }
        if (nullableStruct == null) { tlvWriter.putNull(ContextSpecificTag(6)) }
    else {
      nullableStruct.toTlv(ContextSpecificTag(6), tlvWriter)
    }
        if (optionalStruct.isPresent) {
      val opt_optionalStruct = optionalStruct.get()
      opt_optionalStruct.toTlv(ContextSpecificTag(7), tlvWriter)
    }
        if (nullableOptionalStruct == null) { tlvWriter.putNull(ContextSpecificTag(8)) }
    else {
      if (nullableOptionalStruct.isPresent) {
      val opt_nullableOptionalStruct = nullableOptionalStruct.get()
      opt_nullableOptionalStruct.toTlv(ContextSpecificTag(8), tlvWriter)
    }
    }
        if (nullableList == null) { tlvWriter.putNull(ContextSpecificTag(9)) }
    else {
      tlvWriter.startList(ContextSpecificTag(9))
      val iter_nullableList = nullableList.iterator()
      while(iter_nullableList.hasNext()) {
        val next = iter_nullableList.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
    }
        if (optionalList.isPresent) {
      val opt_optionalList = optionalList.get()
      tlvWriter.startList(ContextSpecificTag(10))
      val iter_opt_optionalList = opt_optionalList.iterator()
      while(iter_opt_optionalList.hasNext()) {
        val next = iter_opt_optionalList.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
    }
        if (nullableOptionalList == null) { tlvWriter.putNull(ContextSpecificTag(11)) }
    else {
      if (nullableOptionalList.isPresent) {
      val opt_nullableOptionalList = nullableOptionalList.get()
      tlvWriter.startList(ContextSpecificTag(11))
      val iter_opt_nullableOptionalList = opt_nullableOptionalList.iterator()
      while(iter_opt_nullableOptionalList.hasNext()) {
        val next = iter_opt_nullableOptionalList.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
    }
    }
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class UnitTestingClusterNestedStruct(
        val a: Int,
        val b: Boolean,
        val c: UnitTestingClusterSimpleStruct) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("UnitTestingClusterNestedStruct {\n")
        builder.append("\ta : $a\n")
        builder.append("\tb : $b\n")
        builder.append("\tc : $c\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), a)
        tlvWriter.put(ContextSpecificTag(1), b)
        c.toTlv(ContextSpecificTag(2), tlvWriter)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class UnitTestingClusterNestedStructList(
        val a: Int,
        val b: Boolean,
        val c: UnitTestingClusterSimpleStruct,
        val d: List<UnitTestingClusterSimpleStruct>,
        val e: List<Long>,
        val f: List<ByteArray>,
        val g: List<Int>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("UnitTestingClusterNestedStructList {\n")
        builder.append("\ta : $a\n")
        builder.append("\tb : $b\n")
        builder.append("\tc : $c\n")
        builder.append("\td : $d\n")
        builder.append("\te : $e\n")
        builder.append("\tf : $f\n")
        builder.append("\tg : $g\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), a)
        tlvWriter.put(ContextSpecificTag(1), b)
        c.toTlv(ContextSpecificTag(2), tlvWriter)
        tlvWriter.startList(ContextSpecificTag(3))
      val iter_d = d.iterator()
      while(iter_d.hasNext()) {
        val next = iter_d.next()
        next.toTlv(AnonymousTag, tlvWriter)
      }
      tlvWriter.endList()
        tlvWriter.startList(ContextSpecificTag(4))
      val iter_e = e.iterator()
      while(iter_e.hasNext()) {
        val next = iter_e.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
        tlvWriter.startList(ContextSpecificTag(5))
      val iter_f = f.iterator()
      while(iter_f.hasNext()) {
        val next = iter_f.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
        tlvWriter.startList(ContextSpecificTag(6))
      val iter_g = g.iterator()
      while(iter_g.hasNext()) {
        val next = iter_g.next()
        tlvWriter.put(AnonymousTag, next)
      }
      tlvWriter.endList()
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class UnitTestingClusterDoubleNestedStructList(
        val a: List<UnitTestingClusterNestedStructList>) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("UnitTestingClusterDoubleNestedStructList {\n")
        builder.append("\ta : $a\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.startList(ContextSpecificTag(0))
      val iter_a = a.iterator()
      while(iter_a.hasNext()) {
        val next = iter_a.next()
        next.toTlv(AnonymousTag, tlvWriter)
      }
      tlvWriter.endList()
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    
    class UnitTestingClusterTestListStructOctet(
        val member1: Long,
        val member2: ByteArray) {
      override fun toString() : String {
        val builder: StringBuilder = StringBuilder()
        builder.append("UnitTestingClusterTestListStructOctet {\n")
        builder.append("\tmember1 : $member1\n")
        builder.append("\tmember2 : $member2\n")
        builder.append("}\n")
        return builder.toString()
      }

      fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
        tlvWriter.startStructure(tag)
        tlvWriter.put(ContextSpecificTag(0), member1)
        tlvWriter.put(ContextSpecificTag(1), member2)
        tlvWriter.endStructure()
      }

      fun toTlv() : ByteArray {
        val tlvWriter = TlvWriter()
        toTlv(AnonymousTag, tlvWriter)
        return tlvWriter.getEncoded()
      }
    }
    }