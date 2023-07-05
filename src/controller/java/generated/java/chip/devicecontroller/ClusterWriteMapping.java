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
package chip.devicecontroller;

import chip.clusterinfo.ClusterCommandCallback;
import chip.clusterinfo.CommandParameterInfo;
import chip.clusterinfo.CommandResponseInfo;
import chip.clusterinfo.DelegatedClusterCallback;
import chip.clusterinfo.InteractionInfo;
import chip.devicecontroller.ChipClusters.DefaultClusterCallback;
import chip.devicecontroller.model.AttributeWriteRequest;
import chip.devicecontroller.model.ChipAttributePath;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ClusterWriteMapping {
  public static class DelegatedWriteCallback implements WriteAttributesCallback, DelegatedClusterCallback {
    private ClusterCommandCallback callback;

    @Override
    public void setCallbackDelegate(ClusterCommandCallback callback) {
      this.callback = callback;
    }

    @Override
    public void onResponse(ChipAttributePath attributePath) {
      Map<CommandResponseInfo, Object> responseValues = new LinkedHashMap<>();
      callback.onSuccess(responseValues);
    }

    @Override
    public void onError(ChipAttributePath attributePath, Exception e) {
      callback.onFailure(e);
    }
  }

  public Map<String, Map<String, InteractionInfo>> getWriteAttributeMap() {
    Map<String, Map<String, InteractionInfo>> writeAttributeMap = new HashMap<>();
    Map<String, InteractionInfo> writeIdentifyInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeIdentifyIdentifyTimeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo identifyidentifyTimeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeIdentifyIdentifyTimeCommandParams.put(
        "value",
        identifyidentifyTimeCommandParameterInfo
    );
    InteractionInfo writeIdentifyIdentifyTimeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Identify.ID, ClusterIDMapping.Identify.Attribute.IdentifyTime.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.IdentifyCluster) cluster).writeIdentifyTimeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeIdentifyIdentifyTimeCommandParams
    );
    writeIdentifyInteractionInfo.put("writeIdentifyTimeAttribute", writeIdentifyIdentifyTimeAttributeInteractionInfo);
    writeAttributeMap.put("identify", writeIdentifyInteractionInfo);
    Map<String, InteractionInfo> writeGroupsInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("groups", writeGroupsInteractionInfo);
    Map<String, InteractionInfo> writeScenesInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("scenes", writeScenesInteractionInfo);
    Map<String, InteractionInfo> writeOnOffInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeOnOffOnTimeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo onOffonTimeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeOnOffOnTimeCommandParams.put(
        "value",
        onOffonTimeCommandParameterInfo
    );
    InteractionInfo writeOnOffOnTimeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.OnOff.ID, ClusterIDMapping.OnOff.Attribute.OnTime.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.OnOffCluster) cluster).writeOnTimeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeOnOffOnTimeCommandParams
    );
    writeOnOffInteractionInfo.put("writeOnTimeAttribute", writeOnOffOnTimeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeOnOffOffWaitTimeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo onOffoffWaitTimeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeOnOffOffWaitTimeCommandParams.put(
        "value",
        onOffoffWaitTimeCommandParameterInfo
    );
    InteractionInfo writeOnOffOffWaitTimeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.OnOff.ID, ClusterIDMapping.OnOff.Attribute.OffWaitTime.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.OnOffCluster) cluster).writeOffWaitTimeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeOnOffOffWaitTimeCommandParams
    );
    writeOnOffInteractionInfo.put("writeOffWaitTimeAttribute", writeOnOffOffWaitTimeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeOnOffStartUpOnOffCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo onOffstartUpOnOffCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeOnOffStartUpOnOffCommandParams.put(
        "value",
        onOffstartUpOnOffCommandParameterInfo
    );
    InteractionInfo writeOnOffStartUpOnOffAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.OnOff.ID, ClusterIDMapping.OnOff.Attribute.StartUpOnOff.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.OnOffCluster) cluster).writeStartUpOnOffAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeOnOffStartUpOnOffCommandParams
    );
    writeOnOffInteractionInfo.put("writeStartUpOnOffAttribute", writeOnOffStartUpOnOffAttributeInteractionInfo);
    writeAttributeMap.put("onOff", writeOnOffInteractionInfo);
    Map<String, InteractionInfo> writeOnOffSwitchConfigurationInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeOnOffSwitchConfigurationSwitchActionsCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo onOffSwitchConfigurationswitchActionsCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeOnOffSwitchConfigurationSwitchActionsCommandParams.put(
        "value",
        onOffSwitchConfigurationswitchActionsCommandParameterInfo
    );
    InteractionInfo writeOnOffSwitchConfigurationSwitchActionsAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.OnOffSwitchConfiguration.ID, ClusterIDMapping.OnOffSwitchConfiguration.Attribute.SwitchActions.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.OnOffSwitchConfigurationCluster) cluster).writeSwitchActionsAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeOnOffSwitchConfigurationSwitchActionsCommandParams
    );
    writeOnOffSwitchConfigurationInteractionInfo.put("writeSwitchActionsAttribute", writeOnOffSwitchConfigurationSwitchActionsAttributeInteractionInfo);
    writeAttributeMap.put("onOffSwitchConfiguration", writeOnOffSwitchConfigurationInteractionInfo);
    Map<String, InteractionInfo> writeLevelControlInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeLevelControlOptionsCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo levelControloptionsCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeLevelControlOptionsCommandParams.put(
        "value",
        levelControloptionsCommandParameterInfo
    );
    InteractionInfo writeLevelControlOptionsAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.LevelControl.ID, ClusterIDMapping.LevelControl.Attribute.Options.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.LevelControlCluster) cluster).writeOptionsAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeLevelControlOptionsCommandParams
    );
    writeLevelControlInteractionInfo.put("writeOptionsAttribute", writeLevelControlOptionsAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeLevelControlOnOffTransitionTimeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo levelControlonOffTransitionTimeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeLevelControlOnOffTransitionTimeCommandParams.put(
        "value",
        levelControlonOffTransitionTimeCommandParameterInfo
    );
    InteractionInfo writeLevelControlOnOffTransitionTimeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.LevelControl.ID, ClusterIDMapping.LevelControl.Attribute.OnOffTransitionTime.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.LevelControlCluster) cluster).writeOnOffTransitionTimeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeLevelControlOnOffTransitionTimeCommandParams
    );
    writeLevelControlInteractionInfo.put("writeOnOffTransitionTimeAttribute", writeLevelControlOnOffTransitionTimeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeLevelControlOnLevelCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo levelControlonLevelCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeLevelControlOnLevelCommandParams.put(
        "value",
        levelControlonLevelCommandParameterInfo
    );
    InteractionInfo writeLevelControlOnLevelAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.LevelControl.ID, ClusterIDMapping.LevelControl.Attribute.OnLevel.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.LevelControlCluster) cluster).writeOnLevelAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeLevelControlOnLevelCommandParams
    );
    writeLevelControlInteractionInfo.put("writeOnLevelAttribute", writeLevelControlOnLevelAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeLevelControlOnTransitionTimeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo levelControlonTransitionTimeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeLevelControlOnTransitionTimeCommandParams.put(
        "value",
        levelControlonTransitionTimeCommandParameterInfo
    );
    InteractionInfo writeLevelControlOnTransitionTimeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.LevelControl.ID, ClusterIDMapping.LevelControl.Attribute.OnTransitionTime.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.LevelControlCluster) cluster).writeOnTransitionTimeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeLevelControlOnTransitionTimeCommandParams
    );
    writeLevelControlInteractionInfo.put("writeOnTransitionTimeAttribute", writeLevelControlOnTransitionTimeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeLevelControlOffTransitionTimeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo levelControloffTransitionTimeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeLevelControlOffTransitionTimeCommandParams.put(
        "value",
        levelControloffTransitionTimeCommandParameterInfo
    );
    InteractionInfo writeLevelControlOffTransitionTimeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.LevelControl.ID, ClusterIDMapping.LevelControl.Attribute.OffTransitionTime.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.LevelControlCluster) cluster).writeOffTransitionTimeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeLevelControlOffTransitionTimeCommandParams
    );
    writeLevelControlInteractionInfo.put("writeOffTransitionTimeAttribute", writeLevelControlOffTransitionTimeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeLevelControlDefaultMoveRateCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo levelControldefaultMoveRateCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeLevelControlDefaultMoveRateCommandParams.put(
        "value",
        levelControldefaultMoveRateCommandParameterInfo
    );
    InteractionInfo writeLevelControlDefaultMoveRateAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.LevelControl.ID, ClusterIDMapping.LevelControl.Attribute.DefaultMoveRate.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.LevelControlCluster) cluster).writeDefaultMoveRateAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeLevelControlDefaultMoveRateCommandParams
    );
    writeLevelControlInteractionInfo.put("writeDefaultMoveRateAttribute", writeLevelControlDefaultMoveRateAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeLevelControlStartUpCurrentLevelCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo levelControlstartUpCurrentLevelCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeLevelControlStartUpCurrentLevelCommandParams.put(
        "value",
        levelControlstartUpCurrentLevelCommandParameterInfo
    );
    InteractionInfo writeLevelControlStartUpCurrentLevelAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.LevelControl.ID, ClusterIDMapping.LevelControl.Attribute.StartUpCurrentLevel.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.LevelControlCluster) cluster).writeStartUpCurrentLevelAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeLevelControlStartUpCurrentLevelCommandParams
    );
    writeLevelControlInteractionInfo.put("writeStartUpCurrentLevelAttribute", writeLevelControlStartUpCurrentLevelAttributeInteractionInfo);
    writeAttributeMap.put("levelControl", writeLevelControlInteractionInfo);
    Map<String, InteractionInfo> writeBinaryInputBasicInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeBinaryInputBasicActiveTextCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo binaryInputBasicactiveTextCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            String.class, 
            String.class 
        );
    writeBinaryInputBasicActiveTextCommandParams.put(
        "value",
        binaryInputBasicactiveTextCommandParameterInfo
    );
    InteractionInfo writeBinaryInputBasicActiveTextAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BinaryInputBasic.ID, ClusterIDMapping.BinaryInputBasic.Attribute.ActiveText.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BinaryInputBasicCluster) cluster).writeActiveTextAttribute(
//          (DefaultClusterCallback) callback,
//          (String) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBinaryInputBasicActiveTextCommandParams
    );
    writeBinaryInputBasicInteractionInfo.put("writeActiveTextAttribute", writeBinaryInputBasicActiveTextAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBinaryInputBasicDescriptionCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo binaryInputBasicdescriptionCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            String.class, 
            String.class 
        );
    writeBinaryInputBasicDescriptionCommandParams.put(
        "value",
        binaryInputBasicdescriptionCommandParameterInfo
    );
    InteractionInfo writeBinaryInputBasicDescriptionAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BinaryInputBasic.ID, ClusterIDMapping.BinaryInputBasic.Attribute.Description.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BinaryInputBasicCluster) cluster).writeDescriptionAttribute(
//          (DefaultClusterCallback) callback,
//          (String) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBinaryInputBasicDescriptionCommandParams
    );
    writeBinaryInputBasicInteractionInfo.put("writeDescriptionAttribute", writeBinaryInputBasicDescriptionAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBinaryInputBasicInactiveTextCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo binaryInputBasicinactiveTextCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            String.class, 
            String.class 
        );
    writeBinaryInputBasicInactiveTextCommandParams.put(
        "value",
        binaryInputBasicinactiveTextCommandParameterInfo
    );
    InteractionInfo writeBinaryInputBasicInactiveTextAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BinaryInputBasic.ID, ClusterIDMapping.BinaryInputBasic.Attribute.InactiveText.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BinaryInputBasicCluster) cluster).writeInactiveTextAttribute(
//          (DefaultClusterCallback) callback,
//          (String) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBinaryInputBasicInactiveTextCommandParams
    );
    writeBinaryInputBasicInteractionInfo.put("writeInactiveTextAttribute", writeBinaryInputBasicInactiveTextAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBinaryInputBasicOutOfServiceCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo binaryInputBasicoutOfServiceCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Boolean.class, 
            Boolean.class 
        );
    writeBinaryInputBasicOutOfServiceCommandParams.put(
        "value",
        binaryInputBasicoutOfServiceCommandParameterInfo
    );
    InteractionInfo writeBinaryInputBasicOutOfServiceAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BinaryInputBasic.ID, ClusterIDMapping.BinaryInputBasic.Attribute.OutOfService.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BinaryInputBasicCluster) cluster).writeOutOfServiceAttribute(
//          (DefaultClusterCallback) callback,
//          (Boolean) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBinaryInputBasicOutOfServiceCommandParams
    );
    writeBinaryInputBasicInteractionInfo.put("writeOutOfServiceAttribute", writeBinaryInputBasicOutOfServiceAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBinaryInputBasicPresentValueCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo binaryInputBasicpresentValueCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Boolean.class, 
            Boolean.class 
        );
    writeBinaryInputBasicPresentValueCommandParams.put(
        "value",
        binaryInputBasicpresentValueCommandParameterInfo
    );
    InteractionInfo writeBinaryInputBasicPresentValueAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BinaryInputBasic.ID, ClusterIDMapping.BinaryInputBasic.Attribute.PresentValue.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BinaryInputBasicCluster) cluster).writePresentValueAttribute(
//          (DefaultClusterCallback) callback,
//          (Boolean) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBinaryInputBasicPresentValueCommandParams
    );
    writeBinaryInputBasicInteractionInfo.put("writePresentValueAttribute", writeBinaryInputBasicPresentValueAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBinaryInputBasicReliabilityCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo binaryInputBasicreliabilityCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeBinaryInputBasicReliabilityCommandParams.put(
        "value",
        binaryInputBasicreliabilityCommandParameterInfo
    );
    InteractionInfo writeBinaryInputBasicReliabilityAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BinaryInputBasic.ID, ClusterIDMapping.BinaryInputBasic.Attribute.Reliability.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BinaryInputBasicCluster) cluster).writeReliabilityAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBinaryInputBasicReliabilityCommandParams
    );
    writeBinaryInputBasicInteractionInfo.put("writeReliabilityAttribute", writeBinaryInputBasicReliabilityAttributeInteractionInfo);
    writeAttributeMap.put("binaryInputBasic", writeBinaryInputBasicInteractionInfo);
    Map<String, InteractionInfo> writePulseWidthModulationInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("pulseWidthModulation", writePulseWidthModulationInteractionInfo);
    Map<String, InteractionInfo> writeDescriptorInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("descriptor", writeDescriptorInteractionInfo);
    Map<String, InteractionInfo> writeBindingInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("binding", writeBindingInteractionInfo);
    Map<String, InteractionInfo> writeAccessControlInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("accessControl", writeAccessControlInteractionInfo);
    Map<String, InteractionInfo> writeActionsInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("actions", writeActionsInteractionInfo);
    Map<String, InteractionInfo> writeBasicInformationInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeBasicInformationNodeLabelCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo basicInformationnodeLabelCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            String.class, 
            String.class 
        );
    writeBasicInformationNodeLabelCommandParams.put(
        "value",
        basicInformationnodeLabelCommandParameterInfo
    );
    InteractionInfo writeBasicInformationNodeLabelAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BasicInformation.ID, ClusterIDMapping.BasicInformation.Attribute.NodeLabel.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BasicInformationCluster) cluster).writeNodeLabelAttribute(
//          (DefaultClusterCallback) callback,
//          (String) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBasicInformationNodeLabelCommandParams
    );
    writeBasicInformationInteractionInfo.put("writeNodeLabelAttribute", writeBasicInformationNodeLabelAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBasicInformationLocationCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo basicInformationlocationCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            String.class, 
            String.class 
        );
    writeBasicInformationLocationCommandParams.put(
        "value",
        basicInformationlocationCommandParameterInfo
    );
    InteractionInfo writeBasicInformationLocationAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BasicInformation.ID, ClusterIDMapping.BasicInformation.Attribute.Location.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BasicInformationCluster) cluster).writeLocationAttribute(
//          (DefaultClusterCallback) callback,
//          (String) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBasicInformationLocationCommandParams
    );
    writeBasicInformationInteractionInfo.put("writeLocationAttribute", writeBasicInformationLocationAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBasicInformationLocalConfigDisabledCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo basicInformationlocalConfigDisabledCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Boolean.class, 
            Boolean.class 
        );
    writeBasicInformationLocalConfigDisabledCommandParams.put(
        "value",
        basicInformationlocalConfigDisabledCommandParameterInfo
    );
    InteractionInfo writeBasicInformationLocalConfigDisabledAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BasicInformation.ID, ClusterIDMapping.BasicInformation.Attribute.LocalConfigDisabled.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BasicInformationCluster) cluster).writeLocalConfigDisabledAttribute(
//          (DefaultClusterCallback) callback,
//          (Boolean) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBasicInformationLocalConfigDisabledCommandParams
    );
    writeBasicInformationInteractionInfo.put("writeLocalConfigDisabledAttribute", writeBasicInformationLocalConfigDisabledAttributeInteractionInfo);
    writeAttributeMap.put("basicInformation", writeBasicInformationInteractionInfo);
    Map<String, InteractionInfo> writeOtaSoftwareUpdateProviderInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("otaSoftwareUpdateProvider", writeOtaSoftwareUpdateProviderInteractionInfo);
    Map<String, InteractionInfo> writeOtaSoftwareUpdateRequestorInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("otaSoftwareUpdateRequestor", writeOtaSoftwareUpdateRequestorInteractionInfo);
    Map<String, InteractionInfo> writeLocalizationConfigurationInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeLocalizationConfigurationActiveLocaleCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo localizationConfigurationactiveLocaleCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            String.class, 
            String.class 
        );
    writeLocalizationConfigurationActiveLocaleCommandParams.put(
        "value",
        localizationConfigurationactiveLocaleCommandParameterInfo
    );
    InteractionInfo writeLocalizationConfigurationActiveLocaleAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.LocalizationConfiguration.ID, ClusterIDMapping.LocalizationConfiguration.Attribute.ActiveLocale.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.LocalizationConfigurationCluster) cluster).writeActiveLocaleAttribute(
//          (DefaultClusterCallback) callback,
//          (String) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeLocalizationConfigurationActiveLocaleCommandParams
    );
    writeLocalizationConfigurationInteractionInfo.put("writeActiveLocaleAttribute", writeLocalizationConfigurationActiveLocaleAttributeInteractionInfo);
    writeAttributeMap.put("localizationConfiguration", writeLocalizationConfigurationInteractionInfo);
    Map<String, InteractionInfo> writeTimeFormatLocalizationInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeTimeFormatLocalizationHourFormatCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo timeFormatLocalizationhourFormatCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeTimeFormatLocalizationHourFormatCommandParams.put(
        "value",
        timeFormatLocalizationhourFormatCommandParameterInfo
    );
    InteractionInfo writeTimeFormatLocalizationHourFormatAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.TimeFormatLocalization.ID, ClusterIDMapping.TimeFormatLocalization.Attribute.HourFormat.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.TimeFormatLocalizationCluster) cluster).writeHourFormatAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeTimeFormatLocalizationHourFormatCommandParams
    );
    writeTimeFormatLocalizationInteractionInfo.put("writeHourFormatAttribute", writeTimeFormatLocalizationHourFormatAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeTimeFormatLocalizationActiveCalendarTypeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo timeFormatLocalizationactiveCalendarTypeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeTimeFormatLocalizationActiveCalendarTypeCommandParams.put(
        "value",
        timeFormatLocalizationactiveCalendarTypeCommandParameterInfo
    );
    InteractionInfo writeTimeFormatLocalizationActiveCalendarTypeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.TimeFormatLocalization.ID, ClusterIDMapping.TimeFormatLocalization.Attribute.ActiveCalendarType.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.TimeFormatLocalizationCluster) cluster).writeActiveCalendarTypeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeTimeFormatLocalizationActiveCalendarTypeCommandParams
    );
    writeTimeFormatLocalizationInteractionInfo.put("writeActiveCalendarTypeAttribute", writeTimeFormatLocalizationActiveCalendarTypeAttributeInteractionInfo);
    writeAttributeMap.put("timeFormatLocalization", writeTimeFormatLocalizationInteractionInfo);
    Map<String, InteractionInfo> writeUnitLocalizationInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeUnitLocalizationTemperatureUnitCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitLocalizationtemperatureUnitCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitLocalizationTemperatureUnitCommandParams.put(
        "value",
        unitLocalizationtemperatureUnitCommandParameterInfo
    );
    InteractionInfo writeUnitLocalizationTemperatureUnitAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitLocalization.ID, ClusterIDMapping.UnitLocalization.Attribute.TemperatureUnit.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitLocalizationCluster) cluster).writeTemperatureUnitAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitLocalizationTemperatureUnitCommandParams
    );
    writeUnitLocalizationInteractionInfo.put("writeTemperatureUnitAttribute", writeUnitLocalizationTemperatureUnitAttributeInteractionInfo);
    writeAttributeMap.put("unitLocalization", writeUnitLocalizationInteractionInfo);
    Map<String, InteractionInfo> writePowerSourceConfigurationInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("powerSourceConfiguration", writePowerSourceConfigurationInteractionInfo);
    Map<String, InteractionInfo> writePowerSourceInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("powerSource", writePowerSourceInteractionInfo);
    Map<String, InteractionInfo> writeGeneralCommissioningInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeGeneralCommissioningBreadcrumbCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo generalCommissioningbreadcrumbCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeGeneralCommissioningBreadcrumbCommandParams.put(
        "value",
        generalCommissioningbreadcrumbCommandParameterInfo
    );
    InteractionInfo writeGeneralCommissioningBreadcrumbAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.GeneralCommissioning.ID, ClusterIDMapping.GeneralCommissioning.Attribute.Breadcrumb.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.GeneralCommissioningCluster) cluster).writeBreadcrumbAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeGeneralCommissioningBreadcrumbCommandParams
    );
    writeGeneralCommissioningInteractionInfo.put("writeBreadcrumbAttribute", writeGeneralCommissioningBreadcrumbAttributeInteractionInfo);
    writeAttributeMap.put("generalCommissioning", writeGeneralCommissioningInteractionInfo);
    Map<String, InteractionInfo> writeNetworkCommissioningInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeNetworkCommissioningInterfaceEnabledCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo networkCommissioninginterfaceEnabledCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Boolean.class, 
            Boolean.class 
        );
    writeNetworkCommissioningInterfaceEnabledCommandParams.put(
        "value",
        networkCommissioninginterfaceEnabledCommandParameterInfo
    );
    InteractionInfo writeNetworkCommissioningInterfaceEnabledAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.NetworkCommissioning.ID, ClusterIDMapping.NetworkCommissioning.Attribute.InterfaceEnabled.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.NetworkCommissioningCluster) cluster).writeInterfaceEnabledAttribute(
//          (DefaultClusterCallback) callback,
//          (Boolean) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeNetworkCommissioningInterfaceEnabledCommandParams
    );
    writeNetworkCommissioningInteractionInfo.put("writeInterfaceEnabledAttribute", writeNetworkCommissioningInterfaceEnabledAttributeInteractionInfo);
    writeAttributeMap.put("networkCommissioning", writeNetworkCommissioningInteractionInfo);
    Map<String, InteractionInfo> writeDiagnosticLogsInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("diagnosticLogs", writeDiagnosticLogsInteractionInfo);
    Map<String, InteractionInfo> writeGeneralDiagnosticsInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("generalDiagnostics", writeGeneralDiagnosticsInteractionInfo);
    Map<String, InteractionInfo> writeSoftwareDiagnosticsInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("softwareDiagnostics", writeSoftwareDiagnosticsInteractionInfo);
    Map<String, InteractionInfo> writeThreadNetworkDiagnosticsInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("threadNetworkDiagnostics", writeThreadNetworkDiagnosticsInteractionInfo);
    Map<String, InteractionInfo> writeWiFiNetworkDiagnosticsInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("wiFiNetworkDiagnostics", writeWiFiNetworkDiagnosticsInteractionInfo);
    Map<String, InteractionInfo> writeEthernetNetworkDiagnosticsInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("ethernetNetworkDiagnostics", writeEthernetNetworkDiagnosticsInteractionInfo);
    Map<String, InteractionInfo> writeTimeSynchronizationInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("timeSynchronization", writeTimeSynchronizationInteractionInfo);
    Map<String, InteractionInfo> writeBridgedDeviceBasicInformationInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeBridgedDeviceBasicInformationNodeLabelCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo bridgedDeviceBasicInformationnodeLabelCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            String.class, 
            String.class 
        );
    writeBridgedDeviceBasicInformationNodeLabelCommandParams.put(
        "value",
        bridgedDeviceBasicInformationnodeLabelCommandParameterInfo
    );
    InteractionInfo writeBridgedDeviceBasicInformationNodeLabelAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BridgedDeviceBasicInformation.ID, ClusterIDMapping.BridgedDeviceBasicInformation.Attribute.NodeLabel.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BridgedDeviceBasicInformationCluster) cluster).writeNodeLabelAttribute(
//          (DefaultClusterCallback) callback,
//          (String) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBridgedDeviceBasicInformationNodeLabelCommandParams
    );
    writeBridgedDeviceBasicInformationInteractionInfo.put("writeNodeLabelAttribute", writeBridgedDeviceBasicInformationNodeLabelAttributeInteractionInfo);
    writeAttributeMap.put("bridgedDeviceBasicInformation", writeBridgedDeviceBasicInformationInteractionInfo);
    Map<String, InteractionInfo> writeSwitchInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("switch", writeSwitchInteractionInfo);
    Map<String, InteractionInfo> writeAdministratorCommissioningInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("administratorCommissioning", writeAdministratorCommissioningInteractionInfo);
    Map<String, InteractionInfo> writeOperationalCredentialsInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("operationalCredentials", writeOperationalCredentialsInteractionInfo);
    Map<String, InteractionInfo> writeGroupKeyManagementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("groupKeyManagement", writeGroupKeyManagementInteractionInfo);
    Map<String, InteractionInfo> writeFixedLabelInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("fixedLabel", writeFixedLabelInteractionInfo);
    Map<String, InteractionInfo> writeUserLabelInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("userLabel", writeUserLabelInteractionInfo);
    Map<String, InteractionInfo> writeProxyConfigurationInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("proxyConfiguration", writeProxyConfigurationInteractionInfo);
    Map<String, InteractionInfo> writeProxyDiscoveryInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("proxyDiscovery", writeProxyDiscoveryInteractionInfo);
    Map<String, InteractionInfo> writeProxyValidInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("proxyValid", writeProxyValidInteractionInfo);
    Map<String, InteractionInfo> writeBooleanStateInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("booleanState", writeBooleanStateInteractionInfo);
    Map<String, InteractionInfo> writeIcdManagementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("icdManagement", writeIcdManagementInteractionInfo);
    Map<String, InteractionInfo> writeModeSelectInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeModeSelectStartUpModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo modeSelectstartUpModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeModeSelectStartUpModeCommandParams.put(
        "value",
        modeSelectstartUpModeCommandParameterInfo
    );
    InteractionInfo writeModeSelectStartUpModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ModeSelect.ID, ClusterIDMapping.ModeSelect.Attribute.StartUpMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ModeSelectCluster) cluster).writeStartUpModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeModeSelectStartUpModeCommandParams
    );
    writeModeSelectInteractionInfo.put("writeStartUpModeAttribute", writeModeSelectStartUpModeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeModeSelectOnModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo modeSelectonModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeModeSelectOnModeCommandParams.put(
        "value",
        modeSelectonModeCommandParameterInfo
    );
    InteractionInfo writeModeSelectOnModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ModeSelect.ID, ClusterIDMapping.ModeSelect.Attribute.OnMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ModeSelectCluster) cluster).writeOnModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeModeSelectOnModeCommandParams
    );
    writeModeSelectInteractionInfo.put("writeOnModeAttribute", writeModeSelectOnModeAttributeInteractionInfo);
    writeAttributeMap.put("modeSelect", writeModeSelectInteractionInfo);
    Map<String, InteractionInfo> writeLaundryWasherModeInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeLaundryWasherModeStartUpModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo laundryWasherModestartUpModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeLaundryWasherModeStartUpModeCommandParams.put(
        "value",
        laundryWasherModestartUpModeCommandParameterInfo
    );
    InteractionInfo writeLaundryWasherModeStartUpModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.LaundryWasherMode.ID, ClusterIDMapping.LaundryWasherMode.Attribute.StartUpMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.LaundryWasherModeCluster) cluster).writeStartUpModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeLaundryWasherModeStartUpModeCommandParams
    );
    writeLaundryWasherModeInteractionInfo.put("writeStartUpModeAttribute", writeLaundryWasherModeStartUpModeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeLaundryWasherModeOnModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo laundryWasherModeonModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeLaundryWasherModeOnModeCommandParams.put(
        "value",
        laundryWasherModeonModeCommandParameterInfo
    );
    InteractionInfo writeLaundryWasherModeOnModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.LaundryWasherMode.ID, ClusterIDMapping.LaundryWasherMode.Attribute.OnMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.LaundryWasherModeCluster) cluster).writeOnModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeLaundryWasherModeOnModeCommandParams
    );
    writeLaundryWasherModeInteractionInfo.put("writeOnModeAttribute", writeLaundryWasherModeOnModeAttributeInteractionInfo);
    writeAttributeMap.put("laundryWasherMode", writeLaundryWasherModeInteractionInfo);
    Map<String, InteractionInfo> writeRefrigeratorAndTemperatureControlledCabinetModeInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeRefrigeratorAndTemperatureControlledCabinetModeStartUpModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo refrigeratorAndTemperatureControlledCabinetModestartUpModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeRefrigeratorAndTemperatureControlledCabinetModeStartUpModeCommandParams.put(
        "value",
        refrigeratorAndTemperatureControlledCabinetModestartUpModeCommandParameterInfo
    );
    InteractionInfo writeRefrigeratorAndTemperatureControlledCabinetModeStartUpModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.RefrigeratorAndTemperatureControlledCabinetMode.ID, ClusterIDMapping.RefrigeratorAndTemperatureControlledCabinetMode.Attribute.StartUpMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.RefrigeratorAndTemperatureControlledCabinetModeCluster) cluster).writeStartUpModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeRefrigeratorAndTemperatureControlledCabinetModeStartUpModeCommandParams
    );
    writeRefrigeratorAndTemperatureControlledCabinetModeInteractionInfo.put("writeStartUpModeAttribute", writeRefrigeratorAndTemperatureControlledCabinetModeStartUpModeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeRefrigeratorAndTemperatureControlledCabinetModeOnModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo refrigeratorAndTemperatureControlledCabinetModeonModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeRefrigeratorAndTemperatureControlledCabinetModeOnModeCommandParams.put(
        "value",
        refrigeratorAndTemperatureControlledCabinetModeonModeCommandParameterInfo
    );
    InteractionInfo writeRefrigeratorAndTemperatureControlledCabinetModeOnModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.RefrigeratorAndTemperatureControlledCabinetMode.ID, ClusterIDMapping.RefrigeratorAndTemperatureControlledCabinetMode.Attribute.OnMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.RefrigeratorAndTemperatureControlledCabinetModeCluster) cluster).writeOnModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeRefrigeratorAndTemperatureControlledCabinetModeOnModeCommandParams
    );
    writeRefrigeratorAndTemperatureControlledCabinetModeInteractionInfo.put("writeOnModeAttribute", writeRefrigeratorAndTemperatureControlledCabinetModeOnModeAttributeInteractionInfo);
    writeAttributeMap.put("refrigeratorAndTemperatureControlledCabinetMode", writeRefrigeratorAndTemperatureControlledCabinetModeInteractionInfo);
    Map<String, InteractionInfo> writeLaundryWasherControlsInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeLaundryWasherControlsSpinSpeedCurrentCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo laundryWasherControlsspinSpeedCurrentCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeLaundryWasherControlsSpinSpeedCurrentCommandParams.put(
        "value",
        laundryWasherControlsspinSpeedCurrentCommandParameterInfo
    );
    InteractionInfo writeLaundryWasherControlsSpinSpeedCurrentAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.LaundryWasherControls.ID, ClusterIDMapping.LaundryWasherControls.Attribute.SpinSpeedCurrent.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.LaundryWasherControlsCluster) cluster).writeSpinSpeedCurrentAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeLaundryWasherControlsSpinSpeedCurrentCommandParams
    );
    writeLaundryWasherControlsInteractionInfo.put("writeSpinSpeedCurrentAttribute", writeLaundryWasherControlsSpinSpeedCurrentAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeLaundryWasherControlsNumberOfRinsesCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo laundryWasherControlsnumberOfRinsesCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeLaundryWasherControlsNumberOfRinsesCommandParams.put(
        "value",
        laundryWasherControlsnumberOfRinsesCommandParameterInfo
    );
    InteractionInfo writeLaundryWasherControlsNumberOfRinsesAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.LaundryWasherControls.ID, ClusterIDMapping.LaundryWasherControls.Attribute.NumberOfRinses.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.LaundryWasherControlsCluster) cluster).writeNumberOfRinsesAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeLaundryWasherControlsNumberOfRinsesCommandParams
    );
    writeLaundryWasherControlsInteractionInfo.put("writeNumberOfRinsesAttribute", writeLaundryWasherControlsNumberOfRinsesAttributeInteractionInfo);
    writeAttributeMap.put("laundryWasherControls", writeLaundryWasherControlsInteractionInfo);
    Map<String, InteractionInfo> writeRvcRunModeInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeRvcRunModeStartUpModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo rvcRunModestartUpModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeRvcRunModeStartUpModeCommandParams.put(
        "value",
        rvcRunModestartUpModeCommandParameterInfo
    );
    InteractionInfo writeRvcRunModeStartUpModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.RvcRunMode.ID, ClusterIDMapping.RvcRunMode.Attribute.StartUpMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.RvcRunModeCluster) cluster).writeStartUpModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeRvcRunModeStartUpModeCommandParams
    );
    writeRvcRunModeInteractionInfo.put("writeStartUpModeAttribute", writeRvcRunModeStartUpModeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeRvcRunModeOnModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo rvcRunModeonModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeRvcRunModeOnModeCommandParams.put(
        "value",
        rvcRunModeonModeCommandParameterInfo
    );
    InteractionInfo writeRvcRunModeOnModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.RvcRunMode.ID, ClusterIDMapping.RvcRunMode.Attribute.OnMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.RvcRunModeCluster) cluster).writeOnModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeRvcRunModeOnModeCommandParams
    );
    writeRvcRunModeInteractionInfo.put("writeOnModeAttribute", writeRvcRunModeOnModeAttributeInteractionInfo);
    writeAttributeMap.put("rvcRunMode", writeRvcRunModeInteractionInfo);
    Map<String, InteractionInfo> writeRvcCleanModeInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeRvcCleanModeStartUpModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo rvcCleanModestartUpModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeRvcCleanModeStartUpModeCommandParams.put(
        "value",
        rvcCleanModestartUpModeCommandParameterInfo
    );
    InteractionInfo writeRvcCleanModeStartUpModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.RvcCleanMode.ID, ClusterIDMapping.RvcCleanMode.Attribute.StartUpMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.RvcCleanModeCluster) cluster).writeStartUpModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeRvcCleanModeStartUpModeCommandParams
    );
    writeRvcCleanModeInteractionInfo.put("writeStartUpModeAttribute", writeRvcCleanModeStartUpModeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeRvcCleanModeOnModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo rvcCleanModeonModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeRvcCleanModeOnModeCommandParams.put(
        "value",
        rvcCleanModeonModeCommandParameterInfo
    );
    InteractionInfo writeRvcCleanModeOnModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.RvcCleanMode.ID, ClusterIDMapping.RvcCleanMode.Attribute.OnMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.RvcCleanModeCluster) cluster).writeOnModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeRvcCleanModeOnModeCommandParams
    );
    writeRvcCleanModeInteractionInfo.put("writeOnModeAttribute", writeRvcCleanModeOnModeAttributeInteractionInfo);
    writeAttributeMap.put("rvcCleanMode", writeRvcCleanModeInteractionInfo);
    Map<String, InteractionInfo> writeTemperatureControlInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("temperatureControl", writeTemperatureControlInteractionInfo);
    Map<String, InteractionInfo> writeRefrigeratorAlarmInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("refrigeratorAlarm", writeRefrigeratorAlarmInteractionInfo);
    Map<String, InteractionInfo> writeDishwasherModeInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeDishwasherModeStartUpModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo dishwasherModestartUpModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeDishwasherModeStartUpModeCommandParams.put(
        "value",
        dishwasherModestartUpModeCommandParameterInfo
    );
    InteractionInfo writeDishwasherModeStartUpModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DishwasherMode.ID, ClusterIDMapping.DishwasherMode.Attribute.StartUpMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DishwasherModeCluster) cluster).writeStartUpModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDishwasherModeStartUpModeCommandParams
    );
    writeDishwasherModeInteractionInfo.put("writeStartUpModeAttribute", writeDishwasherModeStartUpModeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDishwasherModeOnModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo dishwasherModeonModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeDishwasherModeOnModeCommandParams.put(
        "value",
        dishwasherModeonModeCommandParameterInfo
    );
    InteractionInfo writeDishwasherModeOnModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DishwasherMode.ID, ClusterIDMapping.DishwasherMode.Attribute.OnMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DishwasherModeCluster) cluster).writeOnModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDishwasherModeOnModeCommandParams
    );
    writeDishwasherModeInteractionInfo.put("writeOnModeAttribute", writeDishwasherModeOnModeAttributeInteractionInfo);
    writeAttributeMap.put("dishwasherMode", writeDishwasherModeInteractionInfo);
    Map<String, InteractionInfo> writeAirQualityInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("airQuality", writeAirQualityInteractionInfo);
    Map<String, InteractionInfo> writeSmokeCoAlarmInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeSmokeCoAlarmSensitivityLevelCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo smokeCoAlarmsensitivityLevelCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeSmokeCoAlarmSensitivityLevelCommandParams.put(
        "value",
        smokeCoAlarmsensitivityLevelCommandParameterInfo
    );
    InteractionInfo writeSmokeCoAlarmSensitivityLevelAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.SmokeCoAlarm.ID, ClusterIDMapping.SmokeCoAlarm.Attribute.SensitivityLevel.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.SmokeCoAlarmCluster) cluster).writeSensitivityLevelAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeSmokeCoAlarmSensitivityLevelCommandParams
    );
    writeSmokeCoAlarmInteractionInfo.put("writeSensitivityLevelAttribute", writeSmokeCoAlarmSensitivityLevelAttributeInteractionInfo);
    writeAttributeMap.put("smokeCoAlarm", writeSmokeCoAlarmInteractionInfo);
    Map<String, InteractionInfo> writeDishwasherAlarmInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("dishwasherAlarm", writeDishwasherAlarmInteractionInfo);
    Map<String, InteractionInfo> writeOperationalStateInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("operationalState", writeOperationalStateInteractionInfo);
    Map<String, InteractionInfo> writeRvcOperationalStateInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("rvcOperationalState", writeRvcOperationalStateInteractionInfo);
    Map<String, InteractionInfo> writeHepaFilterMonitoringInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("hepaFilterMonitoring", writeHepaFilterMonitoringInteractionInfo);
    Map<String, InteractionInfo> writeActivatedCarbonFilterMonitoringInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("activatedCarbonFilterMonitoring", writeActivatedCarbonFilterMonitoringInteractionInfo);
    Map<String, InteractionInfo> writeCeramicFilterMonitoringInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("ceramicFilterMonitoring", writeCeramicFilterMonitoringInteractionInfo);
    Map<String, InteractionInfo> writeElectrostaticFilterMonitoringInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("electrostaticFilterMonitoring", writeElectrostaticFilterMonitoringInteractionInfo);
    Map<String, InteractionInfo> writeUvFilterMonitoringInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("uvFilterMonitoring", writeUvFilterMonitoringInteractionInfo);
    Map<String, InteractionInfo> writeIonizingFilterMonitoringInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("ionizingFilterMonitoring", writeIonizingFilterMonitoringInteractionInfo);
    Map<String, InteractionInfo> writeZeoliteFilterMonitoringInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("zeoliteFilterMonitoring", writeZeoliteFilterMonitoringInteractionInfo);
    Map<String, InteractionInfo> writeOzoneFilterMonitoringInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("ozoneFilterMonitoring", writeOzoneFilterMonitoringInteractionInfo);
    Map<String, InteractionInfo> writeWaterTankMonitoringInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("waterTankMonitoring", writeWaterTankMonitoringInteractionInfo);
    Map<String, InteractionInfo> writeFuelTankMonitoringInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("fuelTankMonitoring", writeFuelTankMonitoringInteractionInfo);
    Map<String, InteractionInfo> writeInkCartridgeMonitoringInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("inkCartridgeMonitoring", writeInkCartridgeMonitoringInteractionInfo);
    Map<String, InteractionInfo> writeTonerCartridgeMonitoringInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("tonerCartridgeMonitoring", writeTonerCartridgeMonitoringInteractionInfo);
    Map<String, InteractionInfo> writeDoorLockInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeDoorLockDoorOpenEventsCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLockdoorOpenEventsCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeDoorLockDoorOpenEventsCommandParams.put(
        "value",
        doorLockdoorOpenEventsCommandParameterInfo
    );
    InteractionInfo writeDoorLockDoorOpenEventsAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.DoorOpenEvents.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeDoorOpenEventsAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockDoorOpenEventsCommandParams
    );
    writeDoorLockInteractionInfo.put("writeDoorOpenEventsAttribute", writeDoorLockDoorOpenEventsAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDoorLockDoorClosedEventsCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLockdoorClosedEventsCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeDoorLockDoorClosedEventsCommandParams.put(
        "value",
        doorLockdoorClosedEventsCommandParameterInfo
    );
    InteractionInfo writeDoorLockDoorClosedEventsAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.DoorClosedEvents.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeDoorClosedEventsAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockDoorClosedEventsCommandParams
    );
    writeDoorLockInteractionInfo.put("writeDoorClosedEventsAttribute", writeDoorLockDoorClosedEventsAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDoorLockOpenPeriodCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLockopenPeriodCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeDoorLockOpenPeriodCommandParams.put(
        "value",
        doorLockopenPeriodCommandParameterInfo
    );
    InteractionInfo writeDoorLockOpenPeriodAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.OpenPeriod.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeOpenPeriodAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockOpenPeriodCommandParams
    );
    writeDoorLockInteractionInfo.put("writeOpenPeriodAttribute", writeDoorLockOpenPeriodAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDoorLockLanguageCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLocklanguageCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            String.class, 
            String.class 
        );
    writeDoorLockLanguageCommandParams.put(
        "value",
        doorLocklanguageCommandParameterInfo
    );
    InteractionInfo writeDoorLockLanguageAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.Language.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeLanguageAttribute(
//          (DefaultClusterCallback) callback,
//          (String) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockLanguageCommandParams
    );
    writeDoorLockInteractionInfo.put("writeLanguageAttribute", writeDoorLockLanguageAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDoorLockLEDSettingsCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLockLEDSettingsCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeDoorLockLEDSettingsCommandParams.put(
        "value",
        doorLockLEDSettingsCommandParameterInfo
    );
    InteractionInfo writeDoorLockLEDSettingsAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.LEDSettings.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeLEDSettingsAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockLEDSettingsCommandParams
    );
    writeDoorLockInteractionInfo.put("writeLEDSettingsAttribute", writeDoorLockLEDSettingsAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDoorLockAutoRelockTimeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLockautoRelockTimeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeDoorLockAutoRelockTimeCommandParams.put(
        "value",
        doorLockautoRelockTimeCommandParameterInfo
    );
    InteractionInfo writeDoorLockAutoRelockTimeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.AutoRelockTime.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeAutoRelockTimeAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockAutoRelockTimeCommandParams
    );
    writeDoorLockInteractionInfo.put("writeAutoRelockTimeAttribute", writeDoorLockAutoRelockTimeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDoorLockSoundVolumeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLocksoundVolumeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeDoorLockSoundVolumeCommandParams.put(
        "value",
        doorLocksoundVolumeCommandParameterInfo
    );
    InteractionInfo writeDoorLockSoundVolumeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.SoundVolume.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeSoundVolumeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockSoundVolumeCommandParams
    );
    writeDoorLockInteractionInfo.put("writeSoundVolumeAttribute", writeDoorLockSoundVolumeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDoorLockOperatingModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLockoperatingModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeDoorLockOperatingModeCommandParams.put(
        "value",
        doorLockoperatingModeCommandParameterInfo
    );
    InteractionInfo writeDoorLockOperatingModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.OperatingMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeOperatingModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockOperatingModeCommandParams
    );
    writeDoorLockInteractionInfo.put("writeOperatingModeAttribute", writeDoorLockOperatingModeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDoorLockEnableLocalProgrammingCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLockenableLocalProgrammingCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Boolean.class, 
            Boolean.class 
        );
    writeDoorLockEnableLocalProgrammingCommandParams.put(
        "value",
        doorLockenableLocalProgrammingCommandParameterInfo
    );
    InteractionInfo writeDoorLockEnableLocalProgrammingAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.EnableLocalProgramming.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeEnableLocalProgrammingAttribute(
//          (DefaultClusterCallback) callback,
//          (Boolean) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockEnableLocalProgrammingCommandParams
    );
    writeDoorLockInteractionInfo.put("writeEnableLocalProgrammingAttribute", writeDoorLockEnableLocalProgrammingAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDoorLockEnableOneTouchLockingCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLockenableOneTouchLockingCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Boolean.class, 
            Boolean.class 
        );
    writeDoorLockEnableOneTouchLockingCommandParams.put(
        "value",
        doorLockenableOneTouchLockingCommandParameterInfo
    );
    InteractionInfo writeDoorLockEnableOneTouchLockingAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.EnableOneTouchLocking.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeEnableOneTouchLockingAttribute(
//          (DefaultClusterCallback) callback,
//          (Boolean) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockEnableOneTouchLockingCommandParams
    );
    writeDoorLockInteractionInfo.put("writeEnableOneTouchLockingAttribute", writeDoorLockEnableOneTouchLockingAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDoorLockEnableInsideStatusLEDCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLockenableInsideStatusLEDCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Boolean.class, 
            Boolean.class 
        );
    writeDoorLockEnableInsideStatusLEDCommandParams.put(
        "value",
        doorLockenableInsideStatusLEDCommandParameterInfo
    );
    InteractionInfo writeDoorLockEnableInsideStatusLEDAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.EnableInsideStatusLED.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeEnableInsideStatusLEDAttribute(
//          (DefaultClusterCallback) callback,
//          (Boolean) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockEnableInsideStatusLEDCommandParams
    );
    writeDoorLockInteractionInfo.put("writeEnableInsideStatusLEDAttribute", writeDoorLockEnableInsideStatusLEDAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDoorLockEnablePrivacyModeButtonCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLockenablePrivacyModeButtonCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Boolean.class, 
            Boolean.class 
        );
    writeDoorLockEnablePrivacyModeButtonCommandParams.put(
        "value",
        doorLockenablePrivacyModeButtonCommandParameterInfo
    );
    InteractionInfo writeDoorLockEnablePrivacyModeButtonAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.EnablePrivacyModeButton.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeEnablePrivacyModeButtonAttribute(
//          (DefaultClusterCallback) callback,
//          (Boolean) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockEnablePrivacyModeButtonCommandParams
    );
    writeDoorLockInteractionInfo.put("writeEnablePrivacyModeButtonAttribute", writeDoorLockEnablePrivacyModeButtonAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDoorLockLocalProgrammingFeaturesCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLocklocalProgrammingFeaturesCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeDoorLockLocalProgrammingFeaturesCommandParams.put(
        "value",
        doorLocklocalProgrammingFeaturesCommandParameterInfo
    );
    InteractionInfo writeDoorLockLocalProgrammingFeaturesAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.LocalProgrammingFeatures.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeLocalProgrammingFeaturesAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockLocalProgrammingFeaturesCommandParams
    );
    writeDoorLockInteractionInfo.put("writeLocalProgrammingFeaturesAttribute", writeDoorLockLocalProgrammingFeaturesAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDoorLockWrongCodeEntryLimitCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLockwrongCodeEntryLimitCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeDoorLockWrongCodeEntryLimitCommandParams.put(
        "value",
        doorLockwrongCodeEntryLimitCommandParameterInfo
    );
    InteractionInfo writeDoorLockWrongCodeEntryLimitAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.WrongCodeEntryLimit.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeWrongCodeEntryLimitAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockWrongCodeEntryLimitCommandParams
    );
    writeDoorLockInteractionInfo.put("writeWrongCodeEntryLimitAttribute", writeDoorLockWrongCodeEntryLimitAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDoorLockUserCodeTemporaryDisableTimeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLockuserCodeTemporaryDisableTimeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeDoorLockUserCodeTemporaryDisableTimeCommandParams.put(
        "value",
        doorLockuserCodeTemporaryDisableTimeCommandParameterInfo
    );
    InteractionInfo writeDoorLockUserCodeTemporaryDisableTimeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.UserCodeTemporaryDisableTime.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeUserCodeTemporaryDisableTimeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockUserCodeTemporaryDisableTimeCommandParams
    );
    writeDoorLockInteractionInfo.put("writeUserCodeTemporaryDisableTimeAttribute", writeDoorLockUserCodeTemporaryDisableTimeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDoorLockSendPINOverTheAirCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLocksendPINOverTheAirCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Boolean.class, 
            Boolean.class 
        );
    writeDoorLockSendPINOverTheAirCommandParams.put(
        "value",
        doorLocksendPINOverTheAirCommandParameterInfo
    );
    InteractionInfo writeDoorLockSendPINOverTheAirAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.SendPINOverTheAir.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeSendPINOverTheAirAttribute(
//          (DefaultClusterCallback) callback,
//          (Boolean) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockSendPINOverTheAirCommandParams
    );
    writeDoorLockInteractionInfo.put("writeSendPINOverTheAirAttribute", writeDoorLockSendPINOverTheAirAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDoorLockRequirePINforRemoteOperationCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLockrequirePINforRemoteOperationCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Boolean.class, 
            Boolean.class 
        );
    writeDoorLockRequirePINforRemoteOperationCommandParams.put(
        "value",
        doorLockrequirePINforRemoteOperationCommandParameterInfo
    );
    InteractionInfo writeDoorLockRequirePINforRemoteOperationAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.RequirePINforRemoteOperation.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeRequirePINforRemoteOperationAttribute(
//          (DefaultClusterCallback) callback,
//          (Boolean) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockRequirePINforRemoteOperationCommandParams
    );
    writeDoorLockInteractionInfo.put("writeRequirePINforRemoteOperationAttribute", writeDoorLockRequirePINforRemoteOperationAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeDoorLockExpiringUserTimeoutCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo doorLockexpiringUserTimeoutCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeDoorLockExpiringUserTimeoutCommandParams.put(
        "value",
        doorLockexpiringUserTimeoutCommandParameterInfo
    );
    InteractionInfo writeDoorLockExpiringUserTimeoutAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.DoorLock.ID, ClusterIDMapping.DoorLock.Attribute.ExpiringUserTimeout.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.DoorLockCluster) cluster).writeExpiringUserTimeoutAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeDoorLockExpiringUserTimeoutCommandParams
    );
    writeDoorLockInteractionInfo.put("writeExpiringUserTimeoutAttribute", writeDoorLockExpiringUserTimeoutAttributeInteractionInfo);
    writeAttributeMap.put("doorLock", writeDoorLockInteractionInfo);
    Map<String, InteractionInfo> writeWindowCoveringInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeWindowCoveringModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo windowCoveringmodeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeWindowCoveringModeCommandParams.put(
        "value",
        windowCoveringmodeCommandParameterInfo
    );
    InteractionInfo writeWindowCoveringModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.WindowCovering.ID, ClusterIDMapping.WindowCovering.Attribute.Mode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.WindowCoveringCluster) cluster).writeModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeWindowCoveringModeCommandParams
    );
    writeWindowCoveringInteractionInfo.put("writeModeAttribute", writeWindowCoveringModeAttributeInteractionInfo);
    writeAttributeMap.put("windowCovering", writeWindowCoveringInteractionInfo);
    Map<String, InteractionInfo> writeBarrierControlInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeBarrierControlBarrierOpenEventsCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo barrierControlbarrierOpenEventsCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeBarrierControlBarrierOpenEventsCommandParams.put(
        "value",
        barrierControlbarrierOpenEventsCommandParameterInfo
    );
    InteractionInfo writeBarrierControlBarrierOpenEventsAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BarrierControl.ID, ClusterIDMapping.BarrierControl.Attribute.BarrierOpenEvents.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BarrierControlCluster) cluster).writeBarrierOpenEventsAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBarrierControlBarrierOpenEventsCommandParams
    );
    writeBarrierControlInteractionInfo.put("writeBarrierOpenEventsAttribute", writeBarrierControlBarrierOpenEventsAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBarrierControlBarrierCloseEventsCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo barrierControlbarrierCloseEventsCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeBarrierControlBarrierCloseEventsCommandParams.put(
        "value",
        barrierControlbarrierCloseEventsCommandParameterInfo
    );
    InteractionInfo writeBarrierControlBarrierCloseEventsAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BarrierControl.ID, ClusterIDMapping.BarrierControl.Attribute.BarrierCloseEvents.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BarrierControlCluster) cluster).writeBarrierCloseEventsAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBarrierControlBarrierCloseEventsCommandParams
    );
    writeBarrierControlInteractionInfo.put("writeBarrierCloseEventsAttribute", writeBarrierControlBarrierCloseEventsAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBarrierControlBarrierCommandOpenEventsCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo barrierControlbarrierCommandOpenEventsCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeBarrierControlBarrierCommandOpenEventsCommandParams.put(
        "value",
        barrierControlbarrierCommandOpenEventsCommandParameterInfo
    );
    InteractionInfo writeBarrierControlBarrierCommandOpenEventsAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BarrierControl.ID, ClusterIDMapping.BarrierControl.Attribute.BarrierCommandOpenEvents.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BarrierControlCluster) cluster).writeBarrierCommandOpenEventsAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBarrierControlBarrierCommandOpenEventsCommandParams
    );
    writeBarrierControlInteractionInfo.put("writeBarrierCommandOpenEventsAttribute", writeBarrierControlBarrierCommandOpenEventsAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBarrierControlBarrierCommandCloseEventsCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo barrierControlbarrierCommandCloseEventsCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeBarrierControlBarrierCommandCloseEventsCommandParams.put(
        "value",
        barrierControlbarrierCommandCloseEventsCommandParameterInfo
    );
    InteractionInfo writeBarrierControlBarrierCommandCloseEventsAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BarrierControl.ID, ClusterIDMapping.BarrierControl.Attribute.BarrierCommandCloseEvents.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BarrierControlCluster) cluster).writeBarrierCommandCloseEventsAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBarrierControlBarrierCommandCloseEventsCommandParams
    );
    writeBarrierControlInteractionInfo.put("writeBarrierCommandCloseEventsAttribute", writeBarrierControlBarrierCommandCloseEventsAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBarrierControlBarrierOpenPeriodCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo barrierControlbarrierOpenPeriodCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeBarrierControlBarrierOpenPeriodCommandParams.put(
        "value",
        barrierControlbarrierOpenPeriodCommandParameterInfo
    );
    InteractionInfo writeBarrierControlBarrierOpenPeriodAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BarrierControl.ID, ClusterIDMapping.BarrierControl.Attribute.BarrierOpenPeriod.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BarrierControlCluster) cluster).writeBarrierOpenPeriodAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBarrierControlBarrierOpenPeriodCommandParams
    );
    writeBarrierControlInteractionInfo.put("writeBarrierOpenPeriodAttribute", writeBarrierControlBarrierOpenPeriodAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBarrierControlBarrierClosePeriodCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo barrierControlbarrierClosePeriodCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeBarrierControlBarrierClosePeriodCommandParams.put(
        "value",
        barrierControlbarrierClosePeriodCommandParameterInfo
    );
    InteractionInfo writeBarrierControlBarrierClosePeriodAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BarrierControl.ID, ClusterIDMapping.BarrierControl.Attribute.BarrierClosePeriod.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BarrierControlCluster) cluster).writeBarrierClosePeriodAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBarrierControlBarrierClosePeriodCommandParams
    );
    writeBarrierControlInteractionInfo.put("writeBarrierClosePeriodAttribute", writeBarrierControlBarrierClosePeriodAttributeInteractionInfo);
    writeAttributeMap.put("barrierControl", writeBarrierControlInteractionInfo);
    Map<String, InteractionInfo> writePumpConfigurationAndControlInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writePumpConfigurationAndControlLifetimeRunningHoursCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo pumpConfigurationAndControllifetimeRunningHoursCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writePumpConfigurationAndControlLifetimeRunningHoursCommandParams.put(
        "value",
        pumpConfigurationAndControllifetimeRunningHoursCommandParameterInfo
    );
    InteractionInfo writePumpConfigurationAndControlLifetimeRunningHoursAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.PumpConfigurationAndControl.ID, ClusterIDMapping.PumpConfigurationAndControl.Attribute.LifetimeRunningHours.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.PumpConfigurationAndControlCluster) cluster).writeLifetimeRunningHoursAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writePumpConfigurationAndControlLifetimeRunningHoursCommandParams
    );
    writePumpConfigurationAndControlInteractionInfo.put("writeLifetimeRunningHoursAttribute", writePumpConfigurationAndControlLifetimeRunningHoursAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writePumpConfigurationAndControlLifetimeEnergyConsumedCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo pumpConfigurationAndControllifetimeEnergyConsumedCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writePumpConfigurationAndControlLifetimeEnergyConsumedCommandParams.put(
        "value",
        pumpConfigurationAndControllifetimeEnergyConsumedCommandParameterInfo
    );
    InteractionInfo writePumpConfigurationAndControlLifetimeEnergyConsumedAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.PumpConfigurationAndControl.ID, ClusterIDMapping.PumpConfigurationAndControl.Attribute.LifetimeEnergyConsumed.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.PumpConfigurationAndControlCluster) cluster).writeLifetimeEnergyConsumedAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writePumpConfigurationAndControlLifetimeEnergyConsumedCommandParams
    );
    writePumpConfigurationAndControlInteractionInfo.put("writeLifetimeEnergyConsumedAttribute", writePumpConfigurationAndControlLifetimeEnergyConsumedAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writePumpConfigurationAndControlOperationModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo pumpConfigurationAndControloperationModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writePumpConfigurationAndControlOperationModeCommandParams.put(
        "value",
        pumpConfigurationAndControloperationModeCommandParameterInfo
    );
    InteractionInfo writePumpConfigurationAndControlOperationModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.PumpConfigurationAndControl.ID, ClusterIDMapping.PumpConfigurationAndControl.Attribute.OperationMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.PumpConfigurationAndControlCluster) cluster).writeOperationModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writePumpConfigurationAndControlOperationModeCommandParams
    );
    writePumpConfigurationAndControlInteractionInfo.put("writeOperationModeAttribute", writePumpConfigurationAndControlOperationModeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writePumpConfigurationAndControlControlModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo pumpConfigurationAndControlcontrolModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writePumpConfigurationAndControlControlModeCommandParams.put(
        "value",
        pumpConfigurationAndControlcontrolModeCommandParameterInfo
    );
    InteractionInfo writePumpConfigurationAndControlControlModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.PumpConfigurationAndControl.ID, ClusterIDMapping.PumpConfigurationAndControl.Attribute.ControlMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.PumpConfigurationAndControlCluster) cluster).writeControlModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writePumpConfigurationAndControlControlModeCommandParams
    );
    writePumpConfigurationAndControlInteractionInfo.put("writeControlModeAttribute", writePumpConfigurationAndControlControlModeAttributeInteractionInfo);
    writeAttributeMap.put("pumpConfigurationAndControl", writePumpConfigurationAndControlInteractionInfo);
    Map<String, InteractionInfo> writeThermostatInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeThermostatHVACSystemTypeConfigurationCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatHVACSystemTypeConfigurationCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatHVACSystemTypeConfigurationCommandParams.put(
        "value",
        thermostatHVACSystemTypeConfigurationCommandParameterInfo
    );
    InteractionInfo writeThermostatHVACSystemTypeConfigurationAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.HVACSystemTypeConfiguration.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeHVACSystemTypeConfigurationAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatHVACSystemTypeConfigurationCommandParams
    );
    writeThermostatInteractionInfo.put("writeHVACSystemTypeConfigurationAttribute", writeThermostatHVACSystemTypeConfigurationAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatLocalTemperatureCalibrationCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatlocalTemperatureCalibrationCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatLocalTemperatureCalibrationCommandParams.put(
        "value",
        thermostatlocalTemperatureCalibrationCommandParameterInfo
    );
    InteractionInfo writeThermostatLocalTemperatureCalibrationAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.LocalTemperatureCalibration.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeLocalTemperatureCalibrationAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatLocalTemperatureCalibrationCommandParams
    );
    writeThermostatInteractionInfo.put("writeLocalTemperatureCalibrationAttribute", writeThermostatLocalTemperatureCalibrationAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatOccupiedCoolingSetpointCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatoccupiedCoolingSetpointCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatOccupiedCoolingSetpointCommandParams.put(
        "value",
        thermostatoccupiedCoolingSetpointCommandParameterInfo
    );
    InteractionInfo writeThermostatOccupiedCoolingSetpointAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.OccupiedCoolingSetpoint.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeOccupiedCoolingSetpointAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatOccupiedCoolingSetpointCommandParams
    );
    writeThermostatInteractionInfo.put("writeOccupiedCoolingSetpointAttribute", writeThermostatOccupiedCoolingSetpointAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatOccupiedHeatingSetpointCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatoccupiedHeatingSetpointCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatOccupiedHeatingSetpointCommandParams.put(
        "value",
        thermostatoccupiedHeatingSetpointCommandParameterInfo
    );
    InteractionInfo writeThermostatOccupiedHeatingSetpointAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.OccupiedHeatingSetpoint.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeOccupiedHeatingSetpointAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatOccupiedHeatingSetpointCommandParams
    );
    writeThermostatInteractionInfo.put("writeOccupiedHeatingSetpointAttribute", writeThermostatOccupiedHeatingSetpointAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatUnoccupiedCoolingSetpointCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatunoccupiedCoolingSetpointCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatUnoccupiedCoolingSetpointCommandParams.put(
        "value",
        thermostatunoccupiedCoolingSetpointCommandParameterInfo
    );
    InteractionInfo writeThermostatUnoccupiedCoolingSetpointAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.UnoccupiedCoolingSetpoint.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeUnoccupiedCoolingSetpointAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatUnoccupiedCoolingSetpointCommandParams
    );
    writeThermostatInteractionInfo.put("writeUnoccupiedCoolingSetpointAttribute", writeThermostatUnoccupiedCoolingSetpointAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatUnoccupiedHeatingSetpointCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatunoccupiedHeatingSetpointCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatUnoccupiedHeatingSetpointCommandParams.put(
        "value",
        thermostatunoccupiedHeatingSetpointCommandParameterInfo
    );
    InteractionInfo writeThermostatUnoccupiedHeatingSetpointAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.UnoccupiedHeatingSetpoint.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeUnoccupiedHeatingSetpointAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatUnoccupiedHeatingSetpointCommandParams
    );
    writeThermostatInteractionInfo.put("writeUnoccupiedHeatingSetpointAttribute", writeThermostatUnoccupiedHeatingSetpointAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatMinHeatSetpointLimitCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatminHeatSetpointLimitCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatMinHeatSetpointLimitCommandParams.put(
        "value",
        thermostatminHeatSetpointLimitCommandParameterInfo
    );
    InteractionInfo writeThermostatMinHeatSetpointLimitAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.MinHeatSetpointLimit.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeMinHeatSetpointLimitAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatMinHeatSetpointLimitCommandParams
    );
    writeThermostatInteractionInfo.put("writeMinHeatSetpointLimitAttribute", writeThermostatMinHeatSetpointLimitAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatMaxHeatSetpointLimitCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatmaxHeatSetpointLimitCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatMaxHeatSetpointLimitCommandParams.put(
        "value",
        thermostatmaxHeatSetpointLimitCommandParameterInfo
    );
    InteractionInfo writeThermostatMaxHeatSetpointLimitAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.MaxHeatSetpointLimit.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeMaxHeatSetpointLimitAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatMaxHeatSetpointLimitCommandParams
    );
    writeThermostatInteractionInfo.put("writeMaxHeatSetpointLimitAttribute", writeThermostatMaxHeatSetpointLimitAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatMinCoolSetpointLimitCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatminCoolSetpointLimitCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatMinCoolSetpointLimitCommandParams.put(
        "value",
        thermostatminCoolSetpointLimitCommandParameterInfo
    );
    InteractionInfo writeThermostatMinCoolSetpointLimitAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.MinCoolSetpointLimit.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeMinCoolSetpointLimitAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatMinCoolSetpointLimitCommandParams
    );
    writeThermostatInteractionInfo.put("writeMinCoolSetpointLimitAttribute", writeThermostatMinCoolSetpointLimitAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatMaxCoolSetpointLimitCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatmaxCoolSetpointLimitCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatMaxCoolSetpointLimitCommandParams.put(
        "value",
        thermostatmaxCoolSetpointLimitCommandParameterInfo
    );
    InteractionInfo writeThermostatMaxCoolSetpointLimitAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.MaxCoolSetpointLimit.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeMaxCoolSetpointLimitAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatMaxCoolSetpointLimitCommandParams
    );
    writeThermostatInteractionInfo.put("writeMaxCoolSetpointLimitAttribute", writeThermostatMaxCoolSetpointLimitAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatMinSetpointDeadBandCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatminSetpointDeadBandCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatMinSetpointDeadBandCommandParams.put(
        "value",
        thermostatminSetpointDeadBandCommandParameterInfo
    );
    InteractionInfo writeThermostatMinSetpointDeadBandAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.MinSetpointDeadBand.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeMinSetpointDeadBandAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatMinSetpointDeadBandCommandParams
    );
    writeThermostatInteractionInfo.put("writeMinSetpointDeadBandAttribute", writeThermostatMinSetpointDeadBandAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatRemoteSensingCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatremoteSensingCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatRemoteSensingCommandParams.put(
        "value",
        thermostatremoteSensingCommandParameterInfo
    );
    InteractionInfo writeThermostatRemoteSensingAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.RemoteSensing.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeRemoteSensingAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatRemoteSensingCommandParams
    );
    writeThermostatInteractionInfo.put("writeRemoteSensingAttribute", writeThermostatRemoteSensingAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatControlSequenceOfOperationCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatcontrolSequenceOfOperationCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatControlSequenceOfOperationCommandParams.put(
        "value",
        thermostatcontrolSequenceOfOperationCommandParameterInfo
    );
    InteractionInfo writeThermostatControlSequenceOfOperationAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.ControlSequenceOfOperation.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeControlSequenceOfOperationAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatControlSequenceOfOperationCommandParams
    );
    writeThermostatInteractionInfo.put("writeControlSequenceOfOperationAttribute", writeThermostatControlSequenceOfOperationAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatSystemModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatsystemModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatSystemModeCommandParams.put(
        "value",
        thermostatsystemModeCommandParameterInfo
    );
    InteractionInfo writeThermostatSystemModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.SystemMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeSystemModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatSystemModeCommandParams
    );
    writeThermostatInteractionInfo.put("writeSystemModeAttribute", writeThermostatSystemModeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatTemperatureSetpointHoldCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostattemperatureSetpointHoldCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatTemperatureSetpointHoldCommandParams.put(
        "value",
        thermostattemperatureSetpointHoldCommandParameterInfo
    );
    InteractionInfo writeThermostatTemperatureSetpointHoldAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.TemperatureSetpointHold.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeTemperatureSetpointHoldAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatTemperatureSetpointHoldCommandParams
    );
    writeThermostatInteractionInfo.put("writeTemperatureSetpointHoldAttribute", writeThermostatTemperatureSetpointHoldAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatTemperatureSetpointHoldDurationCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostattemperatureSetpointHoldDurationCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatTemperatureSetpointHoldDurationCommandParams.put(
        "value",
        thermostattemperatureSetpointHoldDurationCommandParameterInfo
    );
    InteractionInfo writeThermostatTemperatureSetpointHoldDurationAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.TemperatureSetpointHoldDuration.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeTemperatureSetpointHoldDurationAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatTemperatureSetpointHoldDurationCommandParams
    );
    writeThermostatInteractionInfo.put("writeTemperatureSetpointHoldDurationAttribute", writeThermostatTemperatureSetpointHoldDurationAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatThermostatProgrammingOperationModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatthermostatProgrammingOperationModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatThermostatProgrammingOperationModeCommandParams.put(
        "value",
        thermostatthermostatProgrammingOperationModeCommandParameterInfo
    );
    InteractionInfo writeThermostatThermostatProgrammingOperationModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.ThermostatProgrammingOperationMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeThermostatProgrammingOperationModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatThermostatProgrammingOperationModeCommandParams
    );
    writeThermostatInteractionInfo.put("writeThermostatProgrammingOperationModeAttribute", writeThermostatThermostatProgrammingOperationModeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatOccupiedSetbackCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatoccupiedSetbackCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatOccupiedSetbackCommandParams.put(
        "value",
        thermostatoccupiedSetbackCommandParameterInfo
    );
    InteractionInfo writeThermostatOccupiedSetbackAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.OccupiedSetback.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeOccupiedSetbackAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatOccupiedSetbackCommandParams
    );
    writeThermostatInteractionInfo.put("writeOccupiedSetbackAttribute", writeThermostatOccupiedSetbackAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatUnoccupiedSetbackCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatunoccupiedSetbackCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatUnoccupiedSetbackCommandParams.put(
        "value",
        thermostatunoccupiedSetbackCommandParameterInfo
    );
    InteractionInfo writeThermostatUnoccupiedSetbackAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.UnoccupiedSetback.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeUnoccupiedSetbackAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatUnoccupiedSetbackCommandParams
    );
    writeThermostatInteractionInfo.put("writeUnoccupiedSetbackAttribute", writeThermostatUnoccupiedSetbackAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatEmergencyHeatDeltaCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatemergencyHeatDeltaCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatEmergencyHeatDeltaCommandParams.put(
        "value",
        thermostatemergencyHeatDeltaCommandParameterInfo
    );
    InteractionInfo writeThermostatEmergencyHeatDeltaAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.EmergencyHeatDelta.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeEmergencyHeatDeltaAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatEmergencyHeatDeltaCommandParams
    );
    writeThermostatInteractionInfo.put("writeEmergencyHeatDeltaAttribute", writeThermostatEmergencyHeatDeltaAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatACTypeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatACTypeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatACTypeCommandParams.put(
        "value",
        thermostatACTypeCommandParameterInfo
    );
    InteractionInfo writeThermostatACTypeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.ACType.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeACTypeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatACTypeCommandParams
    );
    writeThermostatInteractionInfo.put("writeACTypeAttribute", writeThermostatACTypeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatACCapacityCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatACCapacityCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatACCapacityCommandParams.put(
        "value",
        thermostatACCapacityCommandParameterInfo
    );
    InteractionInfo writeThermostatACCapacityAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.ACCapacity.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeACCapacityAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatACCapacityCommandParams
    );
    writeThermostatInteractionInfo.put("writeACCapacityAttribute", writeThermostatACCapacityAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatACRefrigerantTypeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatACRefrigerantTypeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatACRefrigerantTypeCommandParams.put(
        "value",
        thermostatACRefrigerantTypeCommandParameterInfo
    );
    InteractionInfo writeThermostatACRefrigerantTypeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.ACRefrigerantType.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeACRefrigerantTypeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatACRefrigerantTypeCommandParams
    );
    writeThermostatInteractionInfo.put("writeACRefrigerantTypeAttribute", writeThermostatACRefrigerantTypeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatACCompressorTypeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatACCompressorTypeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatACCompressorTypeCommandParams.put(
        "value",
        thermostatACCompressorTypeCommandParameterInfo
    );
    InteractionInfo writeThermostatACCompressorTypeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.ACCompressorType.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeACCompressorTypeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatACCompressorTypeCommandParams
    );
    writeThermostatInteractionInfo.put("writeACCompressorTypeAttribute", writeThermostatACCompressorTypeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatACErrorCodeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatACErrorCodeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeThermostatACErrorCodeCommandParams.put(
        "value",
        thermostatACErrorCodeCommandParameterInfo
    );
    InteractionInfo writeThermostatACErrorCodeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.ACErrorCode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeACErrorCodeAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatACErrorCodeCommandParams
    );
    writeThermostatInteractionInfo.put("writeACErrorCodeAttribute", writeThermostatACErrorCodeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatACLouverPositionCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatACLouverPositionCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatACLouverPositionCommandParams.put(
        "value",
        thermostatACLouverPositionCommandParameterInfo
    );
    InteractionInfo writeThermostatACLouverPositionAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.ACLouverPosition.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeACLouverPositionAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatACLouverPositionCommandParams
    );
    writeThermostatInteractionInfo.put("writeACLouverPositionAttribute", writeThermostatACLouverPositionAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatACCapacityformatCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatACCapacityformatCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatACCapacityformatCommandParams.put(
        "value",
        thermostatACCapacityformatCommandParameterInfo
    );
    InteractionInfo writeThermostatACCapacityformatAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.Thermostat.ID, ClusterIDMapping.Thermostat.Attribute.ACCapacityformat.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatCluster) cluster).writeACCapacityformatAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatACCapacityformatCommandParams
    );
    writeThermostatInteractionInfo.put("writeACCapacityformatAttribute", writeThermostatACCapacityformatAttributeInteractionInfo);
    writeAttributeMap.put("thermostat", writeThermostatInteractionInfo);
    Map<String, InteractionInfo> writeFanControlInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeFanControlFanModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo fanControlfanModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeFanControlFanModeCommandParams.put(
        "value",
        fanControlfanModeCommandParameterInfo
    );
    InteractionInfo writeFanControlFanModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.FanControl.ID, ClusterIDMapping.FanControl.Attribute.FanMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.FanControlCluster) cluster).writeFanModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeFanControlFanModeCommandParams
    );
    writeFanControlInteractionInfo.put("writeFanModeAttribute", writeFanControlFanModeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeFanControlFanModeSequenceCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo fanControlfanModeSequenceCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeFanControlFanModeSequenceCommandParams.put(
        "value",
        fanControlfanModeSequenceCommandParameterInfo
    );
    InteractionInfo writeFanControlFanModeSequenceAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.FanControl.ID, ClusterIDMapping.FanControl.Attribute.FanModeSequence.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.FanControlCluster) cluster).writeFanModeSequenceAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeFanControlFanModeSequenceCommandParams
    );
    writeFanControlInteractionInfo.put("writeFanModeSequenceAttribute", writeFanControlFanModeSequenceAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeFanControlPercentSettingCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo fanControlpercentSettingCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeFanControlPercentSettingCommandParams.put(
        "value",
        fanControlpercentSettingCommandParameterInfo
    );
    InteractionInfo writeFanControlPercentSettingAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.FanControl.ID, ClusterIDMapping.FanControl.Attribute.PercentSetting.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.FanControlCluster) cluster).writePercentSettingAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeFanControlPercentSettingCommandParams
    );
    writeFanControlInteractionInfo.put("writePercentSettingAttribute", writeFanControlPercentSettingAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeFanControlSpeedSettingCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo fanControlspeedSettingCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeFanControlSpeedSettingCommandParams.put(
        "value",
        fanControlspeedSettingCommandParameterInfo
    );
    InteractionInfo writeFanControlSpeedSettingAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.FanControl.ID, ClusterIDMapping.FanControl.Attribute.SpeedSetting.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.FanControlCluster) cluster).writeSpeedSettingAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeFanControlSpeedSettingCommandParams
    );
    writeFanControlInteractionInfo.put("writeSpeedSettingAttribute", writeFanControlSpeedSettingAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeFanControlRockSettingCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo fanControlrockSettingCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeFanControlRockSettingCommandParams.put(
        "value",
        fanControlrockSettingCommandParameterInfo
    );
    InteractionInfo writeFanControlRockSettingAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.FanControl.ID, ClusterIDMapping.FanControl.Attribute.RockSetting.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.FanControlCluster) cluster).writeRockSettingAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeFanControlRockSettingCommandParams
    );
    writeFanControlInteractionInfo.put("writeRockSettingAttribute", writeFanControlRockSettingAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeFanControlWindSettingCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo fanControlwindSettingCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeFanControlWindSettingCommandParams.put(
        "value",
        fanControlwindSettingCommandParameterInfo
    );
    InteractionInfo writeFanControlWindSettingAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.FanControl.ID, ClusterIDMapping.FanControl.Attribute.WindSetting.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.FanControlCluster) cluster).writeWindSettingAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeFanControlWindSettingCommandParams
    );
    writeFanControlInteractionInfo.put("writeWindSettingAttribute", writeFanControlWindSettingAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeFanControlAirflowDirectionCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo fanControlairflowDirectionCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeFanControlAirflowDirectionCommandParams.put(
        "value",
        fanControlairflowDirectionCommandParameterInfo
    );
    InteractionInfo writeFanControlAirflowDirectionAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.FanControl.ID, ClusterIDMapping.FanControl.Attribute.AirflowDirection.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.FanControlCluster) cluster).writeAirflowDirectionAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeFanControlAirflowDirectionCommandParams
    );
    writeFanControlInteractionInfo.put("writeAirflowDirectionAttribute", writeFanControlAirflowDirectionAttributeInteractionInfo);
    writeAttributeMap.put("fanControl", writeFanControlInteractionInfo);
    Map<String, InteractionInfo> writeThermostatUserInterfaceConfigurationInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeThermostatUserInterfaceConfigurationTemperatureDisplayModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatUserInterfaceConfigurationtemperatureDisplayModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatUserInterfaceConfigurationTemperatureDisplayModeCommandParams.put(
        "value",
        thermostatUserInterfaceConfigurationtemperatureDisplayModeCommandParameterInfo
    );
    InteractionInfo writeThermostatUserInterfaceConfigurationTemperatureDisplayModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ThermostatUserInterfaceConfiguration.ID, ClusterIDMapping.ThermostatUserInterfaceConfiguration.Attribute.TemperatureDisplayMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatUserInterfaceConfigurationCluster) cluster).writeTemperatureDisplayModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatUserInterfaceConfigurationTemperatureDisplayModeCommandParams
    );
    writeThermostatUserInterfaceConfigurationInteractionInfo.put("writeTemperatureDisplayModeAttribute", writeThermostatUserInterfaceConfigurationTemperatureDisplayModeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatUserInterfaceConfigurationKeypadLockoutCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatUserInterfaceConfigurationkeypadLockoutCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatUserInterfaceConfigurationKeypadLockoutCommandParams.put(
        "value",
        thermostatUserInterfaceConfigurationkeypadLockoutCommandParameterInfo
    );
    InteractionInfo writeThermostatUserInterfaceConfigurationKeypadLockoutAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ThermostatUserInterfaceConfiguration.ID, ClusterIDMapping.ThermostatUserInterfaceConfiguration.Attribute.KeypadLockout.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatUserInterfaceConfigurationCluster) cluster).writeKeypadLockoutAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatUserInterfaceConfigurationKeypadLockoutCommandParams
    );
    writeThermostatUserInterfaceConfigurationInteractionInfo.put("writeKeypadLockoutAttribute", writeThermostatUserInterfaceConfigurationKeypadLockoutAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeThermostatUserInterfaceConfigurationScheduleProgrammingVisibilityCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo thermostatUserInterfaceConfigurationscheduleProgrammingVisibilityCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeThermostatUserInterfaceConfigurationScheduleProgrammingVisibilityCommandParams.put(
        "value",
        thermostatUserInterfaceConfigurationscheduleProgrammingVisibilityCommandParameterInfo
    );
    InteractionInfo writeThermostatUserInterfaceConfigurationScheduleProgrammingVisibilityAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ThermostatUserInterfaceConfiguration.ID, ClusterIDMapping.ThermostatUserInterfaceConfiguration.Attribute.ScheduleProgrammingVisibility.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ThermostatUserInterfaceConfigurationCluster) cluster).writeScheduleProgrammingVisibilityAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeThermostatUserInterfaceConfigurationScheduleProgrammingVisibilityCommandParams
    );
    writeThermostatUserInterfaceConfigurationInteractionInfo.put("writeScheduleProgrammingVisibilityAttribute", writeThermostatUserInterfaceConfigurationScheduleProgrammingVisibilityAttributeInteractionInfo);
    writeAttributeMap.put("thermostatUserInterfaceConfiguration", writeThermostatUserInterfaceConfigurationInteractionInfo);
    Map<String, InteractionInfo> writeColorControlInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeColorControlOptionsCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo colorControloptionsCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeColorControlOptionsCommandParams.put(
        "value",
        colorControloptionsCommandParameterInfo
    );
    InteractionInfo writeColorControlOptionsAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ColorControl.ID, ClusterIDMapping.ColorControl.Attribute.Options.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ColorControlCluster) cluster).writeOptionsAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeColorControlOptionsCommandParams
    );
    writeColorControlInteractionInfo.put("writeOptionsAttribute", writeColorControlOptionsAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeColorControlWhitePointXCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo colorControlwhitePointXCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeColorControlWhitePointXCommandParams.put(
        "value",
        colorControlwhitePointXCommandParameterInfo
    );
    InteractionInfo writeColorControlWhitePointXAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ColorControl.ID, ClusterIDMapping.ColorControl.Attribute.WhitePointX.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ColorControlCluster) cluster).writeWhitePointXAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeColorControlWhitePointXCommandParams
    );
    writeColorControlInteractionInfo.put("writeWhitePointXAttribute", writeColorControlWhitePointXAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeColorControlWhitePointYCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo colorControlwhitePointYCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeColorControlWhitePointYCommandParams.put(
        "value",
        colorControlwhitePointYCommandParameterInfo
    );
    InteractionInfo writeColorControlWhitePointYAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ColorControl.ID, ClusterIDMapping.ColorControl.Attribute.WhitePointY.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ColorControlCluster) cluster).writeWhitePointYAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeColorControlWhitePointYCommandParams
    );
    writeColorControlInteractionInfo.put("writeWhitePointYAttribute", writeColorControlWhitePointYAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeColorControlColorPointRXCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo colorControlcolorPointRXCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeColorControlColorPointRXCommandParams.put(
        "value",
        colorControlcolorPointRXCommandParameterInfo
    );
    InteractionInfo writeColorControlColorPointRXAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ColorControl.ID, ClusterIDMapping.ColorControl.Attribute.ColorPointRX.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ColorControlCluster) cluster).writeColorPointRXAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeColorControlColorPointRXCommandParams
    );
    writeColorControlInteractionInfo.put("writeColorPointRXAttribute", writeColorControlColorPointRXAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeColorControlColorPointRYCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo colorControlcolorPointRYCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeColorControlColorPointRYCommandParams.put(
        "value",
        colorControlcolorPointRYCommandParameterInfo
    );
    InteractionInfo writeColorControlColorPointRYAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ColorControl.ID, ClusterIDMapping.ColorControl.Attribute.ColorPointRY.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ColorControlCluster) cluster).writeColorPointRYAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeColorControlColorPointRYCommandParams
    );
    writeColorControlInteractionInfo.put("writeColorPointRYAttribute", writeColorControlColorPointRYAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeColorControlColorPointRIntensityCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo colorControlcolorPointRIntensityCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeColorControlColorPointRIntensityCommandParams.put(
        "value",
        colorControlcolorPointRIntensityCommandParameterInfo
    );
    InteractionInfo writeColorControlColorPointRIntensityAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ColorControl.ID, ClusterIDMapping.ColorControl.Attribute.ColorPointRIntensity.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ColorControlCluster) cluster).writeColorPointRIntensityAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeColorControlColorPointRIntensityCommandParams
    );
    writeColorControlInteractionInfo.put("writeColorPointRIntensityAttribute", writeColorControlColorPointRIntensityAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeColorControlColorPointGXCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo colorControlcolorPointGXCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeColorControlColorPointGXCommandParams.put(
        "value",
        colorControlcolorPointGXCommandParameterInfo
    );
    InteractionInfo writeColorControlColorPointGXAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ColorControl.ID, ClusterIDMapping.ColorControl.Attribute.ColorPointGX.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ColorControlCluster) cluster).writeColorPointGXAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeColorControlColorPointGXCommandParams
    );
    writeColorControlInteractionInfo.put("writeColorPointGXAttribute", writeColorControlColorPointGXAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeColorControlColorPointGYCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo colorControlcolorPointGYCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeColorControlColorPointGYCommandParams.put(
        "value",
        colorControlcolorPointGYCommandParameterInfo
    );
    InteractionInfo writeColorControlColorPointGYAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ColorControl.ID, ClusterIDMapping.ColorControl.Attribute.ColorPointGY.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ColorControlCluster) cluster).writeColorPointGYAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeColorControlColorPointGYCommandParams
    );
    writeColorControlInteractionInfo.put("writeColorPointGYAttribute", writeColorControlColorPointGYAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeColorControlColorPointGIntensityCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo colorControlcolorPointGIntensityCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeColorControlColorPointGIntensityCommandParams.put(
        "value",
        colorControlcolorPointGIntensityCommandParameterInfo
    );
    InteractionInfo writeColorControlColorPointGIntensityAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ColorControl.ID, ClusterIDMapping.ColorControl.Attribute.ColorPointGIntensity.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ColorControlCluster) cluster).writeColorPointGIntensityAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeColorControlColorPointGIntensityCommandParams
    );
    writeColorControlInteractionInfo.put("writeColorPointGIntensityAttribute", writeColorControlColorPointGIntensityAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeColorControlColorPointBXCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo colorControlcolorPointBXCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeColorControlColorPointBXCommandParams.put(
        "value",
        colorControlcolorPointBXCommandParameterInfo
    );
    InteractionInfo writeColorControlColorPointBXAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ColorControl.ID, ClusterIDMapping.ColorControl.Attribute.ColorPointBX.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ColorControlCluster) cluster).writeColorPointBXAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeColorControlColorPointBXCommandParams
    );
    writeColorControlInteractionInfo.put("writeColorPointBXAttribute", writeColorControlColorPointBXAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeColorControlColorPointBYCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo colorControlcolorPointBYCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeColorControlColorPointBYCommandParams.put(
        "value",
        colorControlcolorPointBYCommandParameterInfo
    );
    InteractionInfo writeColorControlColorPointBYAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ColorControl.ID, ClusterIDMapping.ColorControl.Attribute.ColorPointBY.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ColorControlCluster) cluster).writeColorPointBYAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeColorControlColorPointBYCommandParams
    );
    writeColorControlInteractionInfo.put("writeColorPointBYAttribute", writeColorControlColorPointBYAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeColorControlColorPointBIntensityCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo colorControlcolorPointBIntensityCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeColorControlColorPointBIntensityCommandParams.put(
        "value",
        colorControlcolorPointBIntensityCommandParameterInfo
    );
    InteractionInfo writeColorControlColorPointBIntensityAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ColorControl.ID, ClusterIDMapping.ColorControl.Attribute.ColorPointBIntensity.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ColorControlCluster) cluster).writeColorPointBIntensityAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeColorControlColorPointBIntensityCommandParams
    );
    writeColorControlInteractionInfo.put("writeColorPointBIntensityAttribute", writeColorControlColorPointBIntensityAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeColorControlStartUpColorTemperatureMiredsCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo colorControlstartUpColorTemperatureMiredsCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeColorControlStartUpColorTemperatureMiredsCommandParams.put(
        "value",
        colorControlstartUpColorTemperatureMiredsCommandParameterInfo
    );
    InteractionInfo writeColorControlStartUpColorTemperatureMiredsAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ColorControl.ID, ClusterIDMapping.ColorControl.Attribute.StartUpColorTemperatureMireds.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ColorControlCluster) cluster).writeStartUpColorTemperatureMiredsAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeColorControlStartUpColorTemperatureMiredsCommandParams
    );
    writeColorControlInteractionInfo.put("writeStartUpColorTemperatureMiredsAttribute", writeColorControlStartUpColorTemperatureMiredsAttributeInteractionInfo);
    writeAttributeMap.put("colorControl", writeColorControlInteractionInfo);
    Map<String, InteractionInfo> writeBallastConfigurationInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeBallastConfigurationMinLevelCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo ballastConfigurationminLevelCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeBallastConfigurationMinLevelCommandParams.put(
        "value",
        ballastConfigurationminLevelCommandParameterInfo
    );
    InteractionInfo writeBallastConfigurationMinLevelAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BallastConfiguration.ID, ClusterIDMapping.BallastConfiguration.Attribute.MinLevel.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BallastConfigurationCluster) cluster).writeMinLevelAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBallastConfigurationMinLevelCommandParams
    );
    writeBallastConfigurationInteractionInfo.put("writeMinLevelAttribute", writeBallastConfigurationMinLevelAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBallastConfigurationMaxLevelCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo ballastConfigurationmaxLevelCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeBallastConfigurationMaxLevelCommandParams.put(
        "value",
        ballastConfigurationmaxLevelCommandParameterInfo
    );
    InteractionInfo writeBallastConfigurationMaxLevelAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BallastConfiguration.ID, ClusterIDMapping.BallastConfiguration.Attribute.MaxLevel.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BallastConfigurationCluster) cluster).writeMaxLevelAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBallastConfigurationMaxLevelCommandParams
    );
    writeBallastConfigurationInteractionInfo.put("writeMaxLevelAttribute", writeBallastConfigurationMaxLevelAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBallastConfigurationIntrinsicBallastFactorCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo ballastConfigurationintrinsicBallastFactorCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeBallastConfigurationIntrinsicBallastFactorCommandParams.put(
        "value",
        ballastConfigurationintrinsicBallastFactorCommandParameterInfo
    );
    InteractionInfo writeBallastConfigurationIntrinsicBallastFactorAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BallastConfiguration.ID, ClusterIDMapping.BallastConfiguration.Attribute.IntrinsicBallastFactor.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BallastConfigurationCluster) cluster).writeIntrinsicBallastFactorAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBallastConfigurationIntrinsicBallastFactorCommandParams
    );
    writeBallastConfigurationInteractionInfo.put("writeIntrinsicBallastFactorAttribute", writeBallastConfigurationIntrinsicBallastFactorAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBallastConfigurationBallastFactorAdjustmentCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo ballastConfigurationballastFactorAdjustmentCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeBallastConfigurationBallastFactorAdjustmentCommandParams.put(
        "value",
        ballastConfigurationballastFactorAdjustmentCommandParameterInfo
    );
    InteractionInfo writeBallastConfigurationBallastFactorAdjustmentAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BallastConfiguration.ID, ClusterIDMapping.BallastConfiguration.Attribute.BallastFactorAdjustment.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BallastConfigurationCluster) cluster).writeBallastFactorAdjustmentAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBallastConfigurationBallastFactorAdjustmentCommandParams
    );
    writeBallastConfigurationInteractionInfo.put("writeBallastFactorAdjustmentAttribute", writeBallastConfigurationBallastFactorAdjustmentAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBallastConfigurationLampTypeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo ballastConfigurationlampTypeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            String.class, 
            String.class 
        );
    writeBallastConfigurationLampTypeCommandParams.put(
        "value",
        ballastConfigurationlampTypeCommandParameterInfo
    );
    InteractionInfo writeBallastConfigurationLampTypeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BallastConfiguration.ID, ClusterIDMapping.BallastConfiguration.Attribute.LampType.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BallastConfigurationCluster) cluster).writeLampTypeAttribute(
//          (DefaultClusterCallback) callback,
//          (String) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBallastConfigurationLampTypeCommandParams
    );
    writeBallastConfigurationInteractionInfo.put("writeLampTypeAttribute", writeBallastConfigurationLampTypeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBallastConfigurationLampManufacturerCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo ballastConfigurationlampManufacturerCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            String.class, 
            String.class 
        );
    writeBallastConfigurationLampManufacturerCommandParams.put(
        "value",
        ballastConfigurationlampManufacturerCommandParameterInfo
    );
    InteractionInfo writeBallastConfigurationLampManufacturerAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BallastConfiguration.ID, ClusterIDMapping.BallastConfiguration.Attribute.LampManufacturer.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BallastConfigurationCluster) cluster).writeLampManufacturerAttribute(
//          (DefaultClusterCallback) callback,
//          (String) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBallastConfigurationLampManufacturerCommandParams
    );
    writeBallastConfigurationInteractionInfo.put("writeLampManufacturerAttribute", writeBallastConfigurationLampManufacturerAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBallastConfigurationLampRatedHoursCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo ballastConfigurationlampRatedHoursCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeBallastConfigurationLampRatedHoursCommandParams.put(
        "value",
        ballastConfigurationlampRatedHoursCommandParameterInfo
    );
    InteractionInfo writeBallastConfigurationLampRatedHoursAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BallastConfiguration.ID, ClusterIDMapping.BallastConfiguration.Attribute.LampRatedHours.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BallastConfigurationCluster) cluster).writeLampRatedHoursAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBallastConfigurationLampRatedHoursCommandParams
    );
    writeBallastConfigurationInteractionInfo.put("writeLampRatedHoursAttribute", writeBallastConfigurationLampRatedHoursAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBallastConfigurationLampBurnHoursCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo ballastConfigurationlampBurnHoursCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeBallastConfigurationLampBurnHoursCommandParams.put(
        "value",
        ballastConfigurationlampBurnHoursCommandParameterInfo
    );
    InteractionInfo writeBallastConfigurationLampBurnHoursAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BallastConfiguration.ID, ClusterIDMapping.BallastConfiguration.Attribute.LampBurnHours.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BallastConfigurationCluster) cluster).writeLampBurnHoursAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBallastConfigurationLampBurnHoursCommandParams
    );
    writeBallastConfigurationInteractionInfo.put("writeLampBurnHoursAttribute", writeBallastConfigurationLampBurnHoursAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBallastConfigurationLampAlarmModeCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo ballastConfigurationlampAlarmModeCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeBallastConfigurationLampAlarmModeCommandParams.put(
        "value",
        ballastConfigurationlampAlarmModeCommandParameterInfo
    );
    InteractionInfo writeBallastConfigurationLampAlarmModeAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BallastConfiguration.ID, ClusterIDMapping.BallastConfiguration.Attribute.LampAlarmMode.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BallastConfigurationCluster) cluster).writeLampAlarmModeAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBallastConfigurationLampAlarmModeCommandParams
    );
    writeBallastConfigurationInteractionInfo.put("writeLampAlarmModeAttribute", writeBallastConfigurationLampAlarmModeAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeBallastConfigurationLampBurnHoursTripPointCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo ballastConfigurationlampBurnHoursTripPointCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeBallastConfigurationLampBurnHoursTripPointCommandParams.put(
        "value",
        ballastConfigurationlampBurnHoursTripPointCommandParameterInfo
    );
    InteractionInfo writeBallastConfigurationLampBurnHoursTripPointAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.BallastConfiguration.ID, ClusterIDMapping.BallastConfiguration.Attribute.LampBurnHoursTripPoint.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.BallastConfigurationCluster) cluster).writeLampBurnHoursTripPointAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeBallastConfigurationLampBurnHoursTripPointCommandParams
    );
    writeBallastConfigurationInteractionInfo.put("writeLampBurnHoursTripPointAttribute", writeBallastConfigurationLampBurnHoursTripPointAttributeInteractionInfo);
    writeAttributeMap.put("ballastConfiguration", writeBallastConfigurationInteractionInfo);
    Map<String, InteractionInfo> writeIlluminanceMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("illuminanceMeasurement", writeIlluminanceMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeTemperatureMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("temperatureMeasurement", writeTemperatureMeasurementInteractionInfo);
    Map<String, InteractionInfo> writePressureMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("pressureMeasurement", writePressureMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeFlowMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("flowMeasurement", writeFlowMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeRelativeHumidityMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("relativeHumidityMeasurement", writeRelativeHumidityMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeOccupancySensingInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeOccupancySensingPIROccupiedToUnoccupiedDelayCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo occupancySensingPIROccupiedToUnoccupiedDelayCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeOccupancySensingPIROccupiedToUnoccupiedDelayCommandParams.put(
        "value",
        occupancySensingPIROccupiedToUnoccupiedDelayCommandParameterInfo
    );
    InteractionInfo writeOccupancySensingPIROccupiedToUnoccupiedDelayAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.OccupancySensing.ID, ClusterIDMapping.OccupancySensing.Attribute.PIROccupiedToUnoccupiedDelay.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.OccupancySensingCluster) cluster).writePIROccupiedToUnoccupiedDelayAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeOccupancySensingPIROccupiedToUnoccupiedDelayCommandParams
    );
    writeOccupancySensingInteractionInfo.put("writePIROccupiedToUnoccupiedDelayAttribute", writeOccupancySensingPIROccupiedToUnoccupiedDelayAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeOccupancySensingPIRUnoccupiedToOccupiedDelayCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo occupancySensingPIRUnoccupiedToOccupiedDelayCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeOccupancySensingPIRUnoccupiedToOccupiedDelayCommandParams.put(
        "value",
        occupancySensingPIRUnoccupiedToOccupiedDelayCommandParameterInfo
    );
    InteractionInfo writeOccupancySensingPIRUnoccupiedToOccupiedDelayAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.OccupancySensing.ID, ClusterIDMapping.OccupancySensing.Attribute.PIRUnoccupiedToOccupiedDelay.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.OccupancySensingCluster) cluster).writePIRUnoccupiedToOccupiedDelayAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeOccupancySensingPIRUnoccupiedToOccupiedDelayCommandParams
    );
    writeOccupancySensingInteractionInfo.put("writePIRUnoccupiedToOccupiedDelayAttribute", writeOccupancySensingPIRUnoccupiedToOccupiedDelayAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeOccupancySensingPIRUnoccupiedToOccupiedThresholdCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo occupancySensingPIRUnoccupiedToOccupiedThresholdCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeOccupancySensingPIRUnoccupiedToOccupiedThresholdCommandParams.put(
        "value",
        occupancySensingPIRUnoccupiedToOccupiedThresholdCommandParameterInfo
    );
    InteractionInfo writeOccupancySensingPIRUnoccupiedToOccupiedThresholdAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.OccupancySensing.ID, ClusterIDMapping.OccupancySensing.Attribute.PIRUnoccupiedToOccupiedThreshold.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.OccupancySensingCluster) cluster).writePIRUnoccupiedToOccupiedThresholdAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeOccupancySensingPIRUnoccupiedToOccupiedThresholdCommandParams
    );
    writeOccupancySensingInteractionInfo.put("writePIRUnoccupiedToOccupiedThresholdAttribute", writeOccupancySensingPIRUnoccupiedToOccupiedThresholdAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeOccupancySensingUltrasonicOccupiedToUnoccupiedDelayCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo occupancySensingultrasonicOccupiedToUnoccupiedDelayCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeOccupancySensingUltrasonicOccupiedToUnoccupiedDelayCommandParams.put(
        "value",
        occupancySensingultrasonicOccupiedToUnoccupiedDelayCommandParameterInfo
    );
    InteractionInfo writeOccupancySensingUltrasonicOccupiedToUnoccupiedDelayAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.OccupancySensing.ID, ClusterIDMapping.OccupancySensing.Attribute.UltrasonicOccupiedToUnoccupiedDelay.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.OccupancySensingCluster) cluster).writeUltrasonicOccupiedToUnoccupiedDelayAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeOccupancySensingUltrasonicOccupiedToUnoccupiedDelayCommandParams
    );
    writeOccupancySensingInteractionInfo.put("writeUltrasonicOccupiedToUnoccupiedDelayAttribute", writeOccupancySensingUltrasonicOccupiedToUnoccupiedDelayAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeOccupancySensingUltrasonicUnoccupiedToOccupiedDelayCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo occupancySensingultrasonicUnoccupiedToOccupiedDelayCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeOccupancySensingUltrasonicUnoccupiedToOccupiedDelayCommandParams.put(
        "value",
        occupancySensingultrasonicUnoccupiedToOccupiedDelayCommandParameterInfo
    );
    InteractionInfo writeOccupancySensingUltrasonicUnoccupiedToOccupiedDelayAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.OccupancySensing.ID, ClusterIDMapping.OccupancySensing.Attribute.UltrasonicUnoccupiedToOccupiedDelay.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.OccupancySensingCluster) cluster).writeUltrasonicUnoccupiedToOccupiedDelayAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeOccupancySensingUltrasonicUnoccupiedToOccupiedDelayCommandParams
    );
    writeOccupancySensingInteractionInfo.put("writeUltrasonicUnoccupiedToOccupiedDelayAttribute", writeOccupancySensingUltrasonicUnoccupiedToOccupiedDelayAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeOccupancySensingUltrasonicUnoccupiedToOccupiedThresholdCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo occupancySensingultrasonicUnoccupiedToOccupiedThresholdCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeOccupancySensingUltrasonicUnoccupiedToOccupiedThresholdCommandParams.put(
        "value",
        occupancySensingultrasonicUnoccupiedToOccupiedThresholdCommandParameterInfo
    );
    InteractionInfo writeOccupancySensingUltrasonicUnoccupiedToOccupiedThresholdAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.OccupancySensing.ID, ClusterIDMapping.OccupancySensing.Attribute.UltrasonicUnoccupiedToOccupiedThreshold.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.OccupancySensingCluster) cluster).writeUltrasonicUnoccupiedToOccupiedThresholdAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeOccupancySensingUltrasonicUnoccupiedToOccupiedThresholdCommandParams
    );
    writeOccupancySensingInteractionInfo.put("writeUltrasonicUnoccupiedToOccupiedThresholdAttribute", writeOccupancySensingUltrasonicUnoccupiedToOccupiedThresholdAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeOccupancySensingPhysicalContactOccupiedToUnoccupiedDelayCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo occupancySensingphysicalContactOccupiedToUnoccupiedDelayCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeOccupancySensingPhysicalContactOccupiedToUnoccupiedDelayCommandParams.put(
        "value",
        occupancySensingphysicalContactOccupiedToUnoccupiedDelayCommandParameterInfo
    );
    InteractionInfo writeOccupancySensingPhysicalContactOccupiedToUnoccupiedDelayAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.OccupancySensing.ID, ClusterIDMapping.OccupancySensing.Attribute.PhysicalContactOccupiedToUnoccupiedDelay.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.OccupancySensingCluster) cluster).writePhysicalContactOccupiedToUnoccupiedDelayAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeOccupancySensingPhysicalContactOccupiedToUnoccupiedDelayCommandParams
    );
    writeOccupancySensingInteractionInfo.put("writePhysicalContactOccupiedToUnoccupiedDelayAttribute", writeOccupancySensingPhysicalContactOccupiedToUnoccupiedDelayAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeOccupancySensingPhysicalContactUnoccupiedToOccupiedDelayCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo occupancySensingphysicalContactUnoccupiedToOccupiedDelayCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeOccupancySensingPhysicalContactUnoccupiedToOccupiedDelayCommandParams.put(
        "value",
        occupancySensingphysicalContactUnoccupiedToOccupiedDelayCommandParameterInfo
    );
    InteractionInfo writeOccupancySensingPhysicalContactUnoccupiedToOccupiedDelayAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.OccupancySensing.ID, ClusterIDMapping.OccupancySensing.Attribute.PhysicalContactUnoccupiedToOccupiedDelay.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.OccupancySensingCluster) cluster).writePhysicalContactUnoccupiedToOccupiedDelayAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeOccupancySensingPhysicalContactUnoccupiedToOccupiedDelayCommandParams
    );
    writeOccupancySensingInteractionInfo.put("writePhysicalContactUnoccupiedToOccupiedDelayAttribute", writeOccupancySensingPhysicalContactUnoccupiedToOccupiedDelayAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeOccupancySensingPhysicalContactUnoccupiedToOccupiedThresholdCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo occupancySensingphysicalContactUnoccupiedToOccupiedThresholdCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeOccupancySensingPhysicalContactUnoccupiedToOccupiedThresholdCommandParams.put(
        "value",
        occupancySensingphysicalContactUnoccupiedToOccupiedThresholdCommandParameterInfo
    );
    InteractionInfo writeOccupancySensingPhysicalContactUnoccupiedToOccupiedThresholdAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.OccupancySensing.ID, ClusterIDMapping.OccupancySensing.Attribute.PhysicalContactUnoccupiedToOccupiedThreshold.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.OccupancySensingCluster) cluster).writePhysicalContactUnoccupiedToOccupiedThresholdAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeOccupancySensingPhysicalContactUnoccupiedToOccupiedThresholdCommandParams
    );
    writeOccupancySensingInteractionInfo.put("writePhysicalContactUnoccupiedToOccupiedThresholdAttribute", writeOccupancySensingPhysicalContactUnoccupiedToOccupiedThresholdAttributeInteractionInfo);
    writeAttributeMap.put("occupancySensing", writeOccupancySensingInteractionInfo);
    Map<String, InteractionInfo> writeCarbonMonoxideConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("carbonMonoxideConcentrationMeasurement", writeCarbonMonoxideConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeCarbonDioxideConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("carbonDioxideConcentrationMeasurement", writeCarbonDioxideConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeEthyleneConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("ethyleneConcentrationMeasurement", writeEthyleneConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeEthyleneOxideConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("ethyleneOxideConcentrationMeasurement", writeEthyleneOxideConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeHydrogenConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("hydrogenConcentrationMeasurement", writeHydrogenConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeHydrogenSulfideConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("hydrogenSulfideConcentrationMeasurement", writeHydrogenSulfideConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeNitricOxideConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("nitricOxideConcentrationMeasurement", writeNitricOxideConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeNitrogenDioxideConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("nitrogenDioxideConcentrationMeasurement", writeNitrogenDioxideConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeOxygenConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("oxygenConcentrationMeasurement", writeOxygenConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeOzoneConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("ozoneConcentrationMeasurement", writeOzoneConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeSulfurDioxideConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("sulfurDioxideConcentrationMeasurement", writeSulfurDioxideConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeDissolvedOxygenConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("dissolvedOxygenConcentrationMeasurement", writeDissolvedOxygenConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeBromateConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("bromateConcentrationMeasurement", writeBromateConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeChloraminesConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("chloraminesConcentrationMeasurement", writeChloraminesConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeChlorineConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("chlorineConcentrationMeasurement", writeChlorineConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeFecalColiformEColiConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("fecalColiformEColiConcentrationMeasurement", writeFecalColiformEColiConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeFluorideConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("fluorideConcentrationMeasurement", writeFluorideConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeHaloaceticAcidsConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("haloaceticAcidsConcentrationMeasurement", writeHaloaceticAcidsConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeTotalTrihalomethanesConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("totalTrihalomethanesConcentrationMeasurement", writeTotalTrihalomethanesConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeTotalColiformBacteriaConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("totalColiformBacteriaConcentrationMeasurement", writeTotalColiformBacteriaConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeTurbidityConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("turbidityConcentrationMeasurement", writeTurbidityConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeCopperConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("copperConcentrationMeasurement", writeCopperConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeLeadConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("leadConcentrationMeasurement", writeLeadConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeManganeseConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("manganeseConcentrationMeasurement", writeManganeseConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeSulfateConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("sulfateConcentrationMeasurement", writeSulfateConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeBromodichloromethaneConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("bromodichloromethaneConcentrationMeasurement", writeBromodichloromethaneConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeBromoformConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("bromoformConcentrationMeasurement", writeBromoformConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeChlorodibromomethaneConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("chlorodibromomethaneConcentrationMeasurement", writeChlorodibromomethaneConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeChloroformConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("chloroformConcentrationMeasurement", writeChloroformConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeSodiumConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("sodiumConcentrationMeasurement", writeSodiumConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writePm25ConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("pm25ConcentrationMeasurement", writePm25ConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeFormaldehydeConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("formaldehydeConcentrationMeasurement", writeFormaldehydeConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writePm1ConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("pm1ConcentrationMeasurement", writePm1ConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writePm10ConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("pm10ConcentrationMeasurement", writePm10ConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeTotalVolatileOrganicCompoundsConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("totalVolatileOrganicCompoundsConcentrationMeasurement", writeTotalVolatileOrganicCompoundsConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeRadonConcentrationMeasurementInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("radonConcentrationMeasurement", writeRadonConcentrationMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeWakeOnLanInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("wakeOnLan", writeWakeOnLanInteractionInfo);
    Map<String, InteractionInfo> writeChannelInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("channel", writeChannelInteractionInfo);
    Map<String, InteractionInfo> writeTargetNavigatorInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("targetNavigator", writeTargetNavigatorInteractionInfo);
    Map<String, InteractionInfo> writeMediaPlaybackInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("mediaPlayback", writeMediaPlaybackInteractionInfo);
    Map<String, InteractionInfo> writeMediaInputInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("mediaInput", writeMediaInputInteractionInfo);
    Map<String, InteractionInfo> writeLowPowerInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("lowPower", writeLowPowerInteractionInfo);
    Map<String, InteractionInfo> writeKeypadInputInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("keypadInput", writeKeypadInputInteractionInfo);
    Map<String, InteractionInfo> writeContentLauncherInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeContentLauncherSupportedStreamingProtocolsCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo contentLaunchersupportedStreamingProtocolsCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeContentLauncherSupportedStreamingProtocolsCommandParams.put(
        "value",
        contentLaunchersupportedStreamingProtocolsCommandParameterInfo
    );
    InteractionInfo writeContentLauncherSupportedStreamingProtocolsAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ContentLauncher.ID, ClusterIDMapping.ContentLauncher.Attribute.SupportedStreamingProtocols.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ContentLauncherCluster) cluster).writeSupportedStreamingProtocolsAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeContentLauncherSupportedStreamingProtocolsCommandParams
    );
    writeContentLauncherInteractionInfo.put("writeSupportedStreamingProtocolsAttribute", writeContentLauncherSupportedStreamingProtocolsAttributeInteractionInfo);
    writeAttributeMap.put("contentLauncher", writeContentLauncherInteractionInfo);
    Map<String, InteractionInfo> writeAudioOutputInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("audioOutput", writeAudioOutputInteractionInfo);
    Map<String, InteractionInfo> writeApplicationLauncherInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("applicationLauncher", writeApplicationLauncherInteractionInfo);
    Map<String, InteractionInfo> writeApplicationBasicInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("applicationBasic", writeApplicationBasicInteractionInfo);
    Map<String, InteractionInfo> writeAccountLoginInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("accountLogin", writeAccountLoginInteractionInfo);
    Map<String, InteractionInfo> writeElectricalMeasurementInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeElectricalMeasurementAverageRmsVoltageMeasurementPeriodCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo electricalMeasurementaverageRmsVoltageMeasurementPeriodCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeElectricalMeasurementAverageRmsVoltageMeasurementPeriodCommandParams.put(
        "value",
        electricalMeasurementaverageRmsVoltageMeasurementPeriodCommandParameterInfo
    );
    InteractionInfo writeElectricalMeasurementAverageRmsVoltageMeasurementPeriodAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ElectricalMeasurement.ID, ClusterIDMapping.ElectricalMeasurement.Attribute.AverageRmsVoltageMeasurementPeriod.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ElectricalMeasurementCluster) cluster).writeAverageRmsVoltageMeasurementPeriodAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeElectricalMeasurementAverageRmsVoltageMeasurementPeriodCommandParams
    );
    writeElectricalMeasurementInteractionInfo.put("writeAverageRmsVoltageMeasurementPeriodAttribute", writeElectricalMeasurementAverageRmsVoltageMeasurementPeriodAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeElectricalMeasurementAverageRmsUnderVoltageCounterCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo electricalMeasurementaverageRmsUnderVoltageCounterCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeElectricalMeasurementAverageRmsUnderVoltageCounterCommandParams.put(
        "value",
        electricalMeasurementaverageRmsUnderVoltageCounterCommandParameterInfo
    );
    InteractionInfo writeElectricalMeasurementAverageRmsUnderVoltageCounterAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ElectricalMeasurement.ID, ClusterIDMapping.ElectricalMeasurement.Attribute.AverageRmsUnderVoltageCounter.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ElectricalMeasurementCluster) cluster).writeAverageRmsUnderVoltageCounterAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeElectricalMeasurementAverageRmsUnderVoltageCounterCommandParams
    );
    writeElectricalMeasurementInteractionInfo.put("writeAverageRmsUnderVoltageCounterAttribute", writeElectricalMeasurementAverageRmsUnderVoltageCounterAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeElectricalMeasurementRmsExtremeOverVoltagePeriodCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo electricalMeasurementrmsExtremeOverVoltagePeriodCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeElectricalMeasurementRmsExtremeOverVoltagePeriodCommandParams.put(
        "value",
        electricalMeasurementrmsExtremeOverVoltagePeriodCommandParameterInfo
    );
    InteractionInfo writeElectricalMeasurementRmsExtremeOverVoltagePeriodAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ElectricalMeasurement.ID, ClusterIDMapping.ElectricalMeasurement.Attribute.RmsExtremeOverVoltagePeriod.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ElectricalMeasurementCluster) cluster).writeRmsExtremeOverVoltagePeriodAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeElectricalMeasurementRmsExtremeOverVoltagePeriodCommandParams
    );
    writeElectricalMeasurementInteractionInfo.put("writeRmsExtremeOverVoltagePeriodAttribute", writeElectricalMeasurementRmsExtremeOverVoltagePeriodAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeElectricalMeasurementRmsExtremeUnderVoltagePeriodCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo electricalMeasurementrmsExtremeUnderVoltagePeriodCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeElectricalMeasurementRmsExtremeUnderVoltagePeriodCommandParams.put(
        "value",
        electricalMeasurementrmsExtremeUnderVoltagePeriodCommandParameterInfo
    );
    InteractionInfo writeElectricalMeasurementRmsExtremeUnderVoltagePeriodAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ElectricalMeasurement.ID, ClusterIDMapping.ElectricalMeasurement.Attribute.RmsExtremeUnderVoltagePeriod.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ElectricalMeasurementCluster) cluster).writeRmsExtremeUnderVoltagePeriodAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeElectricalMeasurementRmsExtremeUnderVoltagePeriodCommandParams
    );
    writeElectricalMeasurementInteractionInfo.put("writeRmsExtremeUnderVoltagePeriodAttribute", writeElectricalMeasurementRmsExtremeUnderVoltagePeriodAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeElectricalMeasurementRmsVoltageSagPeriodCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo electricalMeasurementrmsVoltageSagPeriodCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeElectricalMeasurementRmsVoltageSagPeriodCommandParams.put(
        "value",
        electricalMeasurementrmsVoltageSagPeriodCommandParameterInfo
    );
    InteractionInfo writeElectricalMeasurementRmsVoltageSagPeriodAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ElectricalMeasurement.ID, ClusterIDMapping.ElectricalMeasurement.Attribute.RmsVoltageSagPeriod.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ElectricalMeasurementCluster) cluster).writeRmsVoltageSagPeriodAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeElectricalMeasurementRmsVoltageSagPeriodCommandParams
    );
    writeElectricalMeasurementInteractionInfo.put("writeRmsVoltageSagPeriodAttribute", writeElectricalMeasurementRmsVoltageSagPeriodAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeElectricalMeasurementRmsVoltageSwellPeriodCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo electricalMeasurementrmsVoltageSwellPeriodCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeElectricalMeasurementRmsVoltageSwellPeriodCommandParams.put(
        "value",
        electricalMeasurementrmsVoltageSwellPeriodCommandParameterInfo
    );
    InteractionInfo writeElectricalMeasurementRmsVoltageSwellPeriodAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ElectricalMeasurement.ID, ClusterIDMapping.ElectricalMeasurement.Attribute.RmsVoltageSwellPeriod.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ElectricalMeasurementCluster) cluster).writeRmsVoltageSwellPeriodAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeElectricalMeasurementRmsVoltageSwellPeriodCommandParams
    );
    writeElectricalMeasurementInteractionInfo.put("writeRmsVoltageSwellPeriodAttribute", writeElectricalMeasurementRmsVoltageSwellPeriodAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeElectricalMeasurementOverloadAlarmsMaskCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo electricalMeasurementoverloadAlarmsMaskCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeElectricalMeasurementOverloadAlarmsMaskCommandParams.put(
        "value",
        electricalMeasurementoverloadAlarmsMaskCommandParameterInfo
    );
    InteractionInfo writeElectricalMeasurementOverloadAlarmsMaskAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ElectricalMeasurement.ID, ClusterIDMapping.ElectricalMeasurement.Attribute.OverloadAlarmsMask.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ElectricalMeasurementCluster) cluster).writeOverloadAlarmsMaskAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeElectricalMeasurementOverloadAlarmsMaskCommandParams
    );
    writeElectricalMeasurementInteractionInfo.put("writeOverloadAlarmsMaskAttribute", writeElectricalMeasurementOverloadAlarmsMaskAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeElectricalMeasurementAcOverloadAlarmsMaskCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo electricalMeasurementacOverloadAlarmsMaskCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeElectricalMeasurementAcOverloadAlarmsMaskCommandParams.put(
        "value",
        electricalMeasurementacOverloadAlarmsMaskCommandParameterInfo
    );
    InteractionInfo writeElectricalMeasurementAcOverloadAlarmsMaskAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.ElectricalMeasurement.ID, ClusterIDMapping.ElectricalMeasurement.Attribute.AcOverloadAlarmsMask.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.ElectricalMeasurementCluster) cluster).writeAcOverloadAlarmsMaskAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeElectricalMeasurementAcOverloadAlarmsMaskCommandParams
    );
    writeElectricalMeasurementInteractionInfo.put("writeAcOverloadAlarmsMaskAttribute", writeElectricalMeasurementAcOverloadAlarmsMaskAttributeInteractionInfo);
    writeAttributeMap.put("electricalMeasurement", writeElectricalMeasurementInteractionInfo);
    Map<String, InteractionInfo> writeUnitTestingInteractionInfo = new LinkedHashMap<>();
    Map<String, CommandParameterInfo> writeUnitTestingBooleanCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingbooleanCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Boolean.class, 
            Boolean.class 
        );
    writeUnitTestingBooleanCommandParams.put(
        "value",
        unitTestingbooleanCommandParameterInfo
    );
    InteractionInfo writeUnitTestingBooleanAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Boolean.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeBooleanAttribute(
//          (DefaultClusterCallback) callback,
//          (Boolean) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingBooleanCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeBooleanAttribute", writeUnitTestingBooleanAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingBitmap8CommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingbitmap8CommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingBitmap8CommandParams.put(
        "value",
        unitTestingbitmap8CommandParameterInfo
    );
    InteractionInfo writeUnitTestingBitmap8AttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Bitmap8.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeBitmap8Attribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingBitmap8CommandParams
    );
    writeUnitTestingInteractionInfo.put("writeBitmap8Attribute", writeUnitTestingBitmap8AttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingBitmap16CommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingbitmap16CommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingBitmap16CommandParams.put(
        "value",
        unitTestingbitmap16CommandParameterInfo
    );
    InteractionInfo writeUnitTestingBitmap16AttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Bitmap16.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeBitmap16Attribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingBitmap16CommandParams
    );
    writeUnitTestingInteractionInfo.put("writeBitmap16Attribute", writeUnitTestingBitmap16AttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingBitmap32CommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingbitmap32CommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingBitmap32CommandParams.put(
        "value",
        unitTestingbitmap32CommandParameterInfo
    );
    InteractionInfo writeUnitTestingBitmap32AttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Bitmap32.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeBitmap32Attribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingBitmap32CommandParams
    );
    writeUnitTestingInteractionInfo.put("writeBitmap32Attribute", writeUnitTestingBitmap32AttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingBitmap64CommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingbitmap64CommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingBitmap64CommandParams.put(
        "value",
        unitTestingbitmap64CommandParameterInfo
    );
    InteractionInfo writeUnitTestingBitmap64AttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Bitmap64.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeBitmap64Attribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingBitmap64CommandParams
    );
    writeUnitTestingInteractionInfo.put("writeBitmap64Attribute", writeUnitTestingBitmap64AttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingInt8uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingint8uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingInt8uCommandParams.put(
        "value",
        unitTestingint8uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingInt8uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Int8u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeInt8uAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingInt8uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeInt8uAttribute", writeUnitTestingInt8uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingInt16uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingint16uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingInt16uCommandParams.put(
        "value",
        unitTestingint16uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingInt16uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Int16u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeInt16uAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingInt16uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeInt16uAttribute", writeUnitTestingInt16uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingInt24uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingint24uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingInt24uCommandParams.put(
        "value",
        unitTestingint24uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingInt24uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Int24u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeInt24uAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingInt24uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeInt24uAttribute", writeUnitTestingInt24uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingInt32uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingint32uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingInt32uCommandParams.put(
        "value",
        unitTestingint32uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingInt32uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Int32u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeInt32uAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingInt32uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeInt32uAttribute", writeUnitTestingInt32uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingInt40uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingint40uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingInt40uCommandParams.put(
        "value",
        unitTestingint40uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingInt40uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Int40u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeInt40uAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingInt40uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeInt40uAttribute", writeUnitTestingInt40uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingInt48uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingint48uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingInt48uCommandParams.put(
        "value",
        unitTestingint48uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingInt48uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Int48u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeInt48uAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingInt48uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeInt48uAttribute", writeUnitTestingInt48uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingInt56uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingint56uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingInt56uCommandParams.put(
        "value",
        unitTestingint56uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingInt56uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Int56u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeInt56uAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingInt56uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeInt56uAttribute", writeUnitTestingInt56uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingInt64uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingint64uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingInt64uCommandParams.put(
        "value",
        unitTestingint64uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingInt64uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Int64u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeInt64uAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingInt64uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeInt64uAttribute", writeUnitTestingInt64uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingInt8sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingint8sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingInt8sCommandParams.put(
        "value",
        unitTestingint8sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingInt8sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Int8s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeInt8sAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingInt8sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeInt8sAttribute", writeUnitTestingInt8sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingInt16sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingint16sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingInt16sCommandParams.put(
        "value",
        unitTestingint16sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingInt16sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Int16s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeInt16sAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingInt16sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeInt16sAttribute", writeUnitTestingInt16sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingInt24sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingint24sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingInt24sCommandParams.put(
        "value",
        unitTestingint24sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingInt24sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Int24s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeInt24sAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingInt24sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeInt24sAttribute", writeUnitTestingInt24sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingInt32sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingint32sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingInt32sCommandParams.put(
        "value",
        unitTestingint32sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingInt32sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Int32s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeInt32sAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingInt32sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeInt32sAttribute", writeUnitTestingInt32sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingInt40sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingint40sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingInt40sCommandParams.put(
        "value",
        unitTestingint40sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingInt40sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Int40s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeInt40sAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingInt40sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeInt40sAttribute", writeUnitTestingInt40sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingInt48sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingint48sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingInt48sCommandParams.put(
        "value",
        unitTestingint48sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingInt48sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Int48s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeInt48sAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingInt48sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeInt48sAttribute", writeUnitTestingInt48sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingInt56sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingint56sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingInt56sCommandParams.put(
        "value",
        unitTestingint56sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingInt56sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Int56s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeInt56sAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingInt56sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeInt56sAttribute", writeUnitTestingInt56sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingInt64sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingint64sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingInt64sCommandParams.put(
        "value",
        unitTestingint64sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingInt64sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Int64s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeInt64sAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingInt64sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeInt64sAttribute", writeUnitTestingInt64sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingEnum8CommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingenum8CommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingEnum8CommandParams.put(
        "value",
        unitTestingenum8CommandParameterInfo
    );
    InteractionInfo writeUnitTestingEnum8AttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Enum8.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeEnum8Attribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingEnum8CommandParams
    );
    writeUnitTestingInteractionInfo.put("writeEnum8Attribute", writeUnitTestingEnum8AttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingEnum16CommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingenum16CommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingEnum16CommandParams.put(
        "value",
        unitTestingenum16CommandParameterInfo
    );
    InteractionInfo writeUnitTestingEnum16AttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Enum16.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeEnum16Attribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingEnum16CommandParams
    );
    writeUnitTestingInteractionInfo.put("writeEnum16Attribute", writeUnitTestingEnum16AttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingFloatSingleCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingfloatSingleCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Float.class, 
            Float.class 
        );
    writeUnitTestingFloatSingleCommandParams.put(
        "value",
        unitTestingfloatSingleCommandParameterInfo
    );
    InteractionInfo writeUnitTestingFloatSingleAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.FloatSingle.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeFloatSingleAttribute(
//          (DefaultClusterCallback) callback,
//          (Float) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingFloatSingleCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeFloatSingleAttribute", writeUnitTestingFloatSingleAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingFloatDoubleCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingfloatDoubleCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Double.class, 
            Double.class 
        );
    writeUnitTestingFloatDoubleCommandParams.put(
        "value",
        unitTestingfloatDoubleCommandParameterInfo
    );
    InteractionInfo writeUnitTestingFloatDoubleAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.FloatDouble.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeFloatDoubleAttribute(
//          (DefaultClusterCallback) callback,
//          (Double) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingFloatDoubleCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeFloatDoubleAttribute", writeUnitTestingFloatDoubleAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingOctetStringCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingoctetStringCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            byte[].class, 
            byte[].class 
        );
    writeUnitTestingOctetStringCommandParams.put(
        "value",
        unitTestingoctetStringCommandParameterInfo
    );
    InteractionInfo writeUnitTestingOctetStringAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.OctetString.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeOctetStringAttribute(
//          (DefaultClusterCallback) callback,
//          (byte[]) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingOctetStringCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeOctetStringAttribute", writeUnitTestingOctetStringAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingLongOctetStringCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestinglongOctetStringCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            byte[].class, 
            byte[].class 
        );
    writeUnitTestingLongOctetStringCommandParams.put(
        "value",
        unitTestinglongOctetStringCommandParameterInfo
    );
    InteractionInfo writeUnitTestingLongOctetStringAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.LongOctetString.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeLongOctetStringAttribute(
//          (DefaultClusterCallback) callback,
//          (byte[]) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingLongOctetStringCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeLongOctetStringAttribute", writeUnitTestingLongOctetStringAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingCharStringCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingcharStringCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            String.class, 
            String.class 
        );
    writeUnitTestingCharStringCommandParams.put(
        "value",
        unitTestingcharStringCommandParameterInfo
    );
    InteractionInfo writeUnitTestingCharStringAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.CharString.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeCharStringAttribute(
//          (DefaultClusterCallback) callback,
//          (String) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingCharStringCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeCharStringAttribute", writeUnitTestingCharStringAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingLongCharStringCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestinglongCharStringCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            String.class, 
            String.class 
        );
    writeUnitTestingLongCharStringCommandParams.put(
        "value",
        unitTestinglongCharStringCommandParameterInfo
    );
    InteractionInfo writeUnitTestingLongCharStringAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.LongCharString.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeLongCharStringAttribute(
//          (DefaultClusterCallback) callback,
//          (String) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingLongCharStringCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeLongCharStringAttribute", writeUnitTestingLongCharStringAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingEpochUsCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingepochUsCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingEpochUsCommandParams.put(
        "value",
        unitTestingepochUsCommandParameterInfo
    );
    InteractionInfo writeUnitTestingEpochUsAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.EpochUs.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeEpochUsAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingEpochUsCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeEpochUsAttribute", writeUnitTestingEpochUsAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingEpochSCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingepochSCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingEpochSCommandParams.put(
        "value",
        unitTestingepochSCommandParameterInfo
    );
    InteractionInfo writeUnitTestingEpochSAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.EpochS.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeEpochSAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingEpochSCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeEpochSAttribute", writeUnitTestingEpochSAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingVendorIdCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingvendorIdCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingVendorIdCommandParams.put(
        "value",
        unitTestingvendorIdCommandParameterInfo
    );
    InteractionInfo writeUnitTestingVendorIdAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.VendorId.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeVendorIdAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingVendorIdCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeVendorIdAttribute", writeUnitTestingVendorIdAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingEnumAttrCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingenumAttrCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingEnumAttrCommandParams.put(
        "value",
        unitTestingenumAttrCommandParameterInfo
    );
    InteractionInfo writeUnitTestingEnumAttrAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.EnumAttr.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeEnumAttrAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingEnumAttrCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeEnumAttrAttribute", writeUnitTestingEnumAttrAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingRangeRestrictedInt8uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingrangeRestrictedInt8uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingRangeRestrictedInt8uCommandParams.put(
        "value",
        unitTestingrangeRestrictedInt8uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingRangeRestrictedInt8uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.RangeRestrictedInt8u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeRangeRestrictedInt8uAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingRangeRestrictedInt8uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeRangeRestrictedInt8uAttribute", writeUnitTestingRangeRestrictedInt8uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingRangeRestrictedInt8sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingrangeRestrictedInt8sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingRangeRestrictedInt8sCommandParams.put(
        "value",
        unitTestingrangeRestrictedInt8sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingRangeRestrictedInt8sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.RangeRestrictedInt8s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeRangeRestrictedInt8sAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingRangeRestrictedInt8sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeRangeRestrictedInt8sAttribute", writeUnitTestingRangeRestrictedInt8sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingRangeRestrictedInt16uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingrangeRestrictedInt16uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingRangeRestrictedInt16uCommandParams.put(
        "value",
        unitTestingrangeRestrictedInt16uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingRangeRestrictedInt16uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.RangeRestrictedInt16u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeRangeRestrictedInt16uAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingRangeRestrictedInt16uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeRangeRestrictedInt16uAttribute", writeUnitTestingRangeRestrictedInt16uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingRangeRestrictedInt16sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingrangeRestrictedInt16sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingRangeRestrictedInt16sCommandParams.put(
        "value",
        unitTestingrangeRestrictedInt16sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingRangeRestrictedInt16sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.RangeRestrictedInt16s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeRangeRestrictedInt16sAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingRangeRestrictedInt16sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeRangeRestrictedInt16sAttribute", writeUnitTestingRangeRestrictedInt16sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingTimedWriteBooleanCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingtimedWriteBooleanCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Boolean.class, 
            Boolean.class 
        );
    writeUnitTestingTimedWriteBooleanCommandParams.put(
        "value",
        unitTestingtimedWriteBooleanCommandParameterInfo
    );
    InteractionInfo writeUnitTestingTimedWriteBooleanAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.TimedWriteBoolean.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeTimedWriteBooleanAttribute(
//          (DefaultClusterCallback) callback,
//          (Boolean) commandArguments.get("value")
//, 10000 
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingTimedWriteBooleanCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeTimedWriteBooleanAttribute", writeUnitTestingTimedWriteBooleanAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingGeneralErrorBooleanCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestinggeneralErrorBooleanCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Boolean.class, 
            Boolean.class 
        );
    writeUnitTestingGeneralErrorBooleanCommandParams.put(
        "value",
        unitTestinggeneralErrorBooleanCommandParameterInfo
    );
    InteractionInfo writeUnitTestingGeneralErrorBooleanAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.GeneralErrorBoolean.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeGeneralErrorBooleanAttribute(
//          (DefaultClusterCallback) callback,
//          (Boolean) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingGeneralErrorBooleanCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeGeneralErrorBooleanAttribute", writeUnitTestingGeneralErrorBooleanAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingClusterErrorBooleanCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingclusterErrorBooleanCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Boolean.class, 
            Boolean.class 
        );
    writeUnitTestingClusterErrorBooleanCommandParams.put(
        "value",
        unitTestingclusterErrorBooleanCommandParameterInfo
    );
    InteractionInfo writeUnitTestingClusterErrorBooleanAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.ClusterErrorBoolean.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeClusterErrorBooleanAttribute(
//          (DefaultClusterCallback) callback,
//          (Boolean) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingClusterErrorBooleanCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeClusterErrorBooleanAttribute", writeUnitTestingClusterErrorBooleanAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingUnsupportedCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingunsupportedCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Boolean.class, 
            Boolean.class 
        );
    writeUnitTestingUnsupportedCommandParams.put(
        "value",
        unitTestingunsupportedCommandParameterInfo
    );
    InteractionInfo writeUnitTestingUnsupportedAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.Unsupported.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeUnsupportedAttribute(
//          (DefaultClusterCallback) callback,
//          (Boolean) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingUnsupportedCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeUnsupportedAttribute", writeUnitTestingUnsupportedAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableBooleanCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableBooleanCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Boolean.class, 
            Boolean.class 
        );
    writeUnitTestingNullableBooleanCommandParams.put(
        "value",
        unitTestingnullableBooleanCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableBooleanAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableBoolean.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableBooleanAttribute(
//          (DefaultClusterCallback) callback,
//          (Boolean) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableBooleanCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableBooleanAttribute", writeUnitTestingNullableBooleanAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableBitmap8CommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableBitmap8CommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingNullableBitmap8CommandParams.put(
        "value",
        unitTestingnullableBitmap8CommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableBitmap8AttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableBitmap8.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableBitmap8Attribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableBitmap8CommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableBitmap8Attribute", writeUnitTestingNullableBitmap8AttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableBitmap16CommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableBitmap16CommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingNullableBitmap16CommandParams.put(
        "value",
        unitTestingnullableBitmap16CommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableBitmap16AttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableBitmap16.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableBitmap16Attribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableBitmap16CommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableBitmap16Attribute", writeUnitTestingNullableBitmap16AttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableBitmap32CommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableBitmap32CommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingNullableBitmap32CommandParams.put(
        "value",
        unitTestingnullableBitmap32CommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableBitmap32AttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableBitmap32.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableBitmap32Attribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableBitmap32CommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableBitmap32Attribute", writeUnitTestingNullableBitmap32AttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableBitmap64CommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableBitmap64CommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingNullableBitmap64CommandParams.put(
        "value",
        unitTestingnullableBitmap64CommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableBitmap64AttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableBitmap64.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableBitmap64Attribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableBitmap64CommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableBitmap64Attribute", writeUnitTestingNullableBitmap64AttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableInt8uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableInt8uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingNullableInt8uCommandParams.put(
        "value",
        unitTestingnullableInt8uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableInt8uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableInt8u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableInt8uAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableInt8uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableInt8uAttribute", writeUnitTestingNullableInt8uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableInt16uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableInt16uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingNullableInt16uCommandParams.put(
        "value",
        unitTestingnullableInt16uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableInt16uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableInt16u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableInt16uAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableInt16uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableInt16uAttribute", writeUnitTestingNullableInt16uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableInt24uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableInt24uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingNullableInt24uCommandParams.put(
        "value",
        unitTestingnullableInt24uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableInt24uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableInt24u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableInt24uAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableInt24uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableInt24uAttribute", writeUnitTestingNullableInt24uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableInt32uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableInt32uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingNullableInt32uCommandParams.put(
        "value",
        unitTestingnullableInt32uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableInt32uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableInt32u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableInt32uAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableInt32uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableInt32uAttribute", writeUnitTestingNullableInt32uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableInt40uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableInt40uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingNullableInt40uCommandParams.put(
        "value",
        unitTestingnullableInt40uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableInt40uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableInt40u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableInt40uAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableInt40uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableInt40uAttribute", writeUnitTestingNullableInt40uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableInt48uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableInt48uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingNullableInt48uCommandParams.put(
        "value",
        unitTestingnullableInt48uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableInt48uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableInt48u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableInt48uAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableInt48uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableInt48uAttribute", writeUnitTestingNullableInt48uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableInt56uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableInt56uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingNullableInt56uCommandParams.put(
        "value",
        unitTestingnullableInt56uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableInt56uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableInt56u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableInt56uAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableInt56uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableInt56uAttribute", writeUnitTestingNullableInt56uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableInt64uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableInt64uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingNullableInt64uCommandParams.put(
        "value",
        unitTestingnullableInt64uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableInt64uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableInt64u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableInt64uAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableInt64uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableInt64uAttribute", writeUnitTestingNullableInt64uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableInt8sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableInt8sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingNullableInt8sCommandParams.put(
        "value",
        unitTestingnullableInt8sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableInt8sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableInt8s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableInt8sAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableInt8sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableInt8sAttribute", writeUnitTestingNullableInt8sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableInt16sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableInt16sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingNullableInt16sCommandParams.put(
        "value",
        unitTestingnullableInt16sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableInt16sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableInt16s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableInt16sAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableInt16sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableInt16sAttribute", writeUnitTestingNullableInt16sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableInt24sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableInt24sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingNullableInt24sCommandParams.put(
        "value",
        unitTestingnullableInt24sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableInt24sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableInt24s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableInt24sAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableInt24sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableInt24sAttribute", writeUnitTestingNullableInt24sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableInt32sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableInt32sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingNullableInt32sCommandParams.put(
        "value",
        unitTestingnullableInt32sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableInt32sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableInt32s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableInt32sAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableInt32sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableInt32sAttribute", writeUnitTestingNullableInt32sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableInt40sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableInt40sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingNullableInt40sCommandParams.put(
        "value",
        unitTestingnullableInt40sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableInt40sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableInt40s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableInt40sAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableInt40sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableInt40sAttribute", writeUnitTestingNullableInt40sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableInt48sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableInt48sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingNullableInt48sCommandParams.put(
        "value",
        unitTestingnullableInt48sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableInt48sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableInt48s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableInt48sAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableInt48sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableInt48sAttribute", writeUnitTestingNullableInt48sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableInt56sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableInt56sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingNullableInt56sCommandParams.put(
        "value",
        unitTestingnullableInt56sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableInt56sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableInt56s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableInt56sAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableInt56sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableInt56sAttribute", writeUnitTestingNullableInt56sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableInt64sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableInt64sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Long.class, 
            Long.class 
        );
    writeUnitTestingNullableInt64sCommandParams.put(
        "value",
        unitTestingnullableInt64sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableInt64sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableInt64s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableInt64sAttribute(
//          (DefaultClusterCallback) callback,
//          (Long) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableInt64sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableInt64sAttribute", writeUnitTestingNullableInt64sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableEnum8CommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableEnum8CommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingNullableEnum8CommandParams.put(
        "value",
        unitTestingnullableEnum8CommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableEnum8AttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableEnum8.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableEnum8Attribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableEnum8CommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableEnum8Attribute", writeUnitTestingNullableEnum8AttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableEnum16CommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableEnum16CommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingNullableEnum16CommandParams.put(
        "value",
        unitTestingnullableEnum16CommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableEnum16AttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableEnum16.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableEnum16Attribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableEnum16CommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableEnum16Attribute", writeUnitTestingNullableEnum16AttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableFloatSingleCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableFloatSingleCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Float.class, 
            Float.class 
        );
    writeUnitTestingNullableFloatSingleCommandParams.put(
        "value",
        unitTestingnullableFloatSingleCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableFloatSingleAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableFloatSingle.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableFloatSingleAttribute(
//          (DefaultClusterCallback) callback,
//          (Float) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableFloatSingleCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableFloatSingleAttribute", writeUnitTestingNullableFloatSingleAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableFloatDoubleCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableFloatDoubleCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Double.class, 
            Double.class 
        );
    writeUnitTestingNullableFloatDoubleCommandParams.put(
        "value",
        unitTestingnullableFloatDoubleCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableFloatDoubleAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableFloatDouble.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableFloatDoubleAttribute(
//          (DefaultClusterCallback) callback,
//          (Double) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableFloatDoubleCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableFloatDoubleAttribute", writeUnitTestingNullableFloatDoubleAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableOctetStringCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableOctetStringCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            byte[].class, 
            byte[].class 
        );
    writeUnitTestingNullableOctetStringCommandParams.put(
        "value",
        unitTestingnullableOctetStringCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableOctetStringAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableOctetString.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableOctetStringAttribute(
//          (DefaultClusterCallback) callback,
//          (byte[]) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableOctetStringCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableOctetStringAttribute", writeUnitTestingNullableOctetStringAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableCharStringCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableCharStringCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            String.class, 
            String.class 
        );
    writeUnitTestingNullableCharStringCommandParams.put(
        "value",
        unitTestingnullableCharStringCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableCharStringAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableCharString.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableCharStringAttribute(
//          (DefaultClusterCallback) callback,
//          (String) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableCharStringCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableCharStringAttribute", writeUnitTestingNullableCharStringAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableEnumAttrCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableEnumAttrCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingNullableEnumAttrCommandParams.put(
        "value",
        unitTestingnullableEnumAttrCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableEnumAttrAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableEnumAttr.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableEnumAttrAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableEnumAttrCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableEnumAttrAttribute", writeUnitTestingNullableEnumAttrAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableRangeRestrictedInt8uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableRangeRestrictedInt8uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingNullableRangeRestrictedInt8uCommandParams.put(
        "value",
        unitTestingnullableRangeRestrictedInt8uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableRangeRestrictedInt8uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableRangeRestrictedInt8u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableRangeRestrictedInt8uAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableRangeRestrictedInt8uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableRangeRestrictedInt8uAttribute", writeUnitTestingNullableRangeRestrictedInt8uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableRangeRestrictedInt8sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableRangeRestrictedInt8sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingNullableRangeRestrictedInt8sCommandParams.put(
        "value",
        unitTestingnullableRangeRestrictedInt8sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableRangeRestrictedInt8sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableRangeRestrictedInt8s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableRangeRestrictedInt8sAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableRangeRestrictedInt8sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableRangeRestrictedInt8sAttribute", writeUnitTestingNullableRangeRestrictedInt8sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableRangeRestrictedInt16uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableRangeRestrictedInt16uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingNullableRangeRestrictedInt16uCommandParams.put(
        "value",
        unitTestingnullableRangeRestrictedInt16uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableRangeRestrictedInt16uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableRangeRestrictedInt16u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableRangeRestrictedInt16uAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableRangeRestrictedInt16uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableRangeRestrictedInt16uAttribute", writeUnitTestingNullableRangeRestrictedInt16uAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingNullableRangeRestrictedInt16sCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingnullableRangeRestrictedInt16sCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingNullableRangeRestrictedInt16sCommandParams.put(
        "value",
        unitTestingnullableRangeRestrictedInt16sCommandParameterInfo
    );
    InteractionInfo writeUnitTestingNullableRangeRestrictedInt16sAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.NullableRangeRestrictedInt16s.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeNullableRangeRestrictedInt16sAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingNullableRangeRestrictedInt16sCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeNullableRangeRestrictedInt16sAttribute", writeUnitTestingNullableRangeRestrictedInt16sAttributeInteractionInfo);
    Map<String, CommandParameterInfo> writeUnitTestingWriteOnlyInt8uCommandParams = new LinkedHashMap<String, CommandParameterInfo>();
    CommandParameterInfo unitTestingwriteOnlyInt8uCommandParameterInfo =
        new CommandParameterInfo(
            "value", 
            Integer.class, 
            Integer.class 
        );
    writeUnitTestingWriteOnlyInt8uCommandParams.put(
        "value",
        unitTestingwriteOnlyInt8uCommandParameterInfo
    );
    InteractionInfo writeUnitTestingWriteOnlyInt8uAttributeInteractionInfo = new InteractionInfo(
      (deviceController, devicePtr, endpointId, callback, commandArguments) -> {
        final AttributeWriteRequest pathRequest = AttributeWriteRequest.newInstance(endpointId, ClusterIDMapping.UnitTesting.ID, ClusterIDMapping.UnitTesting.Attribute.WriteOnlyInt8u.getID(), null);
        deviceController.write((DelegatedWriteCallback)callback, devicePtr, List.of(pathRequest), 0, 0);
//      (cluster, callback, commandArguments) -> {
//        ((ChipClusters.UnitTestingCluster) cluster).writeWriteOnlyInt8uAttribute(
//          (DefaultClusterCallback) callback,
//          (Integer) commandArguments.get("value")
//
//        );
//      },
      },
      //() -> new ClusterInfoMapping.DelegatedDefaultClusterCallback(),
      () -> new DelegatedWriteCallback(),
      writeUnitTestingWriteOnlyInt8uCommandParams
    );
    writeUnitTestingInteractionInfo.put("writeWriteOnlyInt8uAttribute", writeUnitTestingWriteOnlyInt8uAttributeInteractionInfo);
    writeAttributeMap.put("unitTesting", writeUnitTestingInteractionInfo);
    Map<String, InteractionInfo> writeFaultInjectionInteractionInfo = new LinkedHashMap<>();
    writeAttributeMap.put("faultInjection", writeFaultInjectionInteractionInfo);return writeAttributeMap;
  }
}
