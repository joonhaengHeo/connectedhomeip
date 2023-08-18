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
package chip.devicecontroller.ClusterIDMapping

object Clusters {
  fun getCluster(clusterId: Long): BaseCluster? {
    if (clusterId == Identify.ID) {
      return Identify
    }
    if (clusterId == Groups.ID) {
      return Groups
    }
    if (clusterId == Scenes.ID) {
      return Scenes
    }
    if (clusterId == OnOff.ID) {
      return OnOff
    }
    if (clusterId == OnOffSwitchConfiguration.ID) {
      return OnOffSwitchConfiguration
    }
    if (clusterId == LevelControl.ID) {
      return LevelControl
    }
    if (clusterId == BinaryInputBasic.ID) {
      return BinaryInputBasic
    }
    if (clusterId == PulseWidthModulation.ID) {
      return PulseWidthModulation
    }
    if (clusterId == Descriptor.ID) {
      return Descriptor
    }
    if (clusterId == Binding.ID) {
      return Binding
    }
    if (clusterId == AccessControl.ID) {
      return AccessControl
    }
    if (clusterId == Actions.ID) {
      return Actions
    }
    if (clusterId == BasicInformation.ID) {
      return BasicInformation
    }
    if (clusterId == OtaSoftwareUpdateProvider.ID) {
      return OtaSoftwareUpdateProvider
    }
    if (clusterId == OtaSoftwareUpdateRequestor.ID) {
      return OtaSoftwareUpdateRequestor
    }
    if (clusterId == LocalizationConfiguration.ID) {
      return LocalizationConfiguration
    }
    if (clusterId == TimeFormatLocalization.ID) {
      return TimeFormatLocalization
    }
    if (clusterId == UnitLocalization.ID) {
      return UnitLocalization
    }
    if (clusterId == PowerSourceConfiguration.ID) {
      return PowerSourceConfiguration
    }
    if (clusterId == PowerSource.ID) {
      return PowerSource
    }
    if (clusterId == GeneralCommissioning.ID) {
      return GeneralCommissioning
    }
    if (clusterId == NetworkCommissioning.ID) {
      return NetworkCommissioning
    }
    if (clusterId == DiagnosticLogs.ID) {
      return DiagnosticLogs
    }
    if (clusterId == GeneralDiagnostics.ID) {
      return GeneralDiagnostics
    }
    if (clusterId == SoftwareDiagnostics.ID) {
      return SoftwareDiagnostics
    }
    if (clusterId == ThreadNetworkDiagnostics.ID) {
      return ThreadNetworkDiagnostics
    }
    if (clusterId == WiFiNetworkDiagnostics.ID) {
      return WiFiNetworkDiagnostics
    }
    if (clusterId == EthernetNetworkDiagnostics.ID) {
      return EthernetNetworkDiagnostics
    }
    if (clusterId == TimeSynchronization.ID) {
      return TimeSynchronization
    }
    if (clusterId == BridgedDeviceBasicInformation.ID) {
      return BridgedDeviceBasicInformation
    }
    if (clusterId == Switch.ID) {
      return Switch
    }
    if (clusterId == AdministratorCommissioning.ID) {
      return AdministratorCommissioning
    }
    if (clusterId == OperationalCredentials.ID) {
      return OperationalCredentials
    }
    if (clusterId == GroupKeyManagement.ID) {
      return GroupKeyManagement
    }
    if (clusterId == FixedLabel.ID) {
      return FixedLabel
    }
    if (clusterId == UserLabel.ID) {
      return UserLabel
    }
    if (clusterId == ProxyConfiguration.ID) {
      return ProxyConfiguration
    }
    if (clusterId == ProxyDiscovery.ID) {
      return ProxyDiscovery
    }
    if (clusterId == ProxyValid.ID) {
      return ProxyValid
    }
    if (clusterId == BooleanState.ID) {
      return BooleanState
    }
    if (clusterId == IcdManagement.ID) {
      return IcdManagement
    }
    if (clusterId == ModeSelect.ID) {
      return ModeSelect
    }
    if (clusterId == LaundryWasherMode.ID) {
      return LaundryWasherMode
    }
    if (clusterId == RefrigeratorAndTemperatureControlledCabinetMode.ID) {
      return RefrigeratorAndTemperatureControlledCabinetMode
    }
    if (clusterId == LaundryWasherControls.ID) {
      return LaundryWasherControls
    }
    if (clusterId == RvcRunMode.ID) {
      return RvcRunMode
    }
    if (clusterId == RvcCleanMode.ID) {
      return RvcCleanMode
    }
    if (clusterId == TemperatureControl.ID) {
      return TemperatureControl
    }
    if (clusterId == RefrigeratorAlarm.ID) {
      return RefrigeratorAlarm
    }
    if (clusterId == DishwasherMode.ID) {
      return DishwasherMode
    }
    if (clusterId == AirQuality.ID) {
      return AirQuality
    }
    if (clusterId == SmokeCoAlarm.ID) {
      return SmokeCoAlarm
    }
    if (clusterId == DishwasherAlarm.ID) {
      return DishwasherAlarm
    }
    if (clusterId == OperationalState.ID) {
      return OperationalState
    }
    if (clusterId == RvcOperationalState.ID) {
      return RvcOperationalState
    }
    if (clusterId == HepaFilterMonitoring.ID) {
      return HepaFilterMonitoring
    }
    if (clusterId == ActivatedCarbonFilterMonitoring.ID) {
      return ActivatedCarbonFilterMonitoring
    }
    if (clusterId == DoorLock.ID) {
      return DoorLock
    }
    if (clusterId == WindowCovering.ID) {
      return WindowCovering
    }
    if (clusterId == BarrierControl.ID) {
      return BarrierControl
    }
    if (clusterId == PumpConfigurationAndControl.ID) {
      return PumpConfigurationAndControl
    }
    if (clusterId == Thermostat.ID) {
      return Thermostat
    }
    if (clusterId == FanControl.ID) {
      return FanControl
    }
    if (clusterId == ThermostatUserInterfaceConfiguration.ID) {
      return ThermostatUserInterfaceConfiguration
    }
    if (clusterId == ColorControl.ID) {
      return ColorControl
    }
    if (clusterId == BallastConfiguration.ID) {
      return BallastConfiguration
    }
    if (clusterId == IlluminanceMeasurement.ID) {
      return IlluminanceMeasurement
    }
    if (clusterId == TemperatureMeasurement.ID) {
      return TemperatureMeasurement
    }
    if (clusterId == PressureMeasurement.ID) {
      return PressureMeasurement
    }
    if (clusterId == FlowMeasurement.ID) {
      return FlowMeasurement
    }
    if (clusterId == RelativeHumidityMeasurement.ID) {
      return RelativeHumidityMeasurement
    }
    if (clusterId == OccupancySensing.ID) {
      return OccupancySensing
    }
    if (clusterId == CarbonMonoxideConcentrationMeasurement.ID) {
      return CarbonMonoxideConcentrationMeasurement
    }
    if (clusterId == CarbonDioxideConcentrationMeasurement.ID) {
      return CarbonDioxideConcentrationMeasurement
    }
    if (clusterId == NitrogenDioxideConcentrationMeasurement.ID) {
      return NitrogenDioxideConcentrationMeasurement
    }
    if (clusterId == OzoneConcentrationMeasurement.ID) {
      return OzoneConcentrationMeasurement
    }
    if (clusterId == Pm25ConcentrationMeasurement.ID) {
      return Pm25ConcentrationMeasurement
    }
    if (clusterId == FormaldehydeConcentrationMeasurement.ID) {
      return FormaldehydeConcentrationMeasurement
    }
    if (clusterId == Pm1ConcentrationMeasurement.ID) {
      return Pm1ConcentrationMeasurement
    }
    if (clusterId == Pm10ConcentrationMeasurement.ID) {
      return Pm10ConcentrationMeasurement
    }
    if (clusterId == TotalVolatileOrganicCompoundsConcentrationMeasurement.ID) {
      return TotalVolatileOrganicCompoundsConcentrationMeasurement
    }
    if (clusterId == RadonConcentrationMeasurement.ID) {
      return RadonConcentrationMeasurement
    }
    if (clusterId == WakeOnLan.ID) {
      return WakeOnLan
    }
    if (clusterId == Channel.ID) {
      return Channel
    }
    if (clusterId == TargetNavigator.ID) {
      return TargetNavigator
    }
    if (clusterId == MediaPlayback.ID) {
      return MediaPlayback
    }
    if (clusterId == MediaInput.ID) {
      return MediaInput
    }
    if (clusterId == LowPower.ID) {
      return LowPower
    }
    if (clusterId == KeypadInput.ID) {
      return KeypadInput
    }
    if (clusterId == ContentLauncher.ID) {
      return ContentLauncher
    }
    if (clusterId == AudioOutput.ID) {
      return AudioOutput
    }
    if (clusterId == ApplicationLauncher.ID) {
      return ApplicationLauncher
    }
    if (clusterId == ApplicationBasic.ID) {
      return ApplicationBasic
    }
    if (clusterId == AccountLogin.ID) {
      return AccountLogin
    }
    if (clusterId == ElectricalMeasurement.ID) {
      return ElectricalMeasurement
    }
    if (clusterId == UnitTesting.ID) {
      return UnitTesting
    }
    if (clusterId == FaultInjection.ID) {
      return FaultInjection
    }
    return null
  }
}
