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

object PumpConfigurationAndControl : BaseCluster() {
  const val ID = 512L

  sealed class Attribute(val id: Long, val name: String) {
    object MaxPressure : Attribute(0L, "MaxPressure")

    object MaxSpeed : Attribute(1L, "MaxSpeed")

    object MaxFlow : Attribute(2L, "MaxFlow")

    object MinConstPressure : Attribute(3L, "MinConstPressure")

    object MaxConstPressure : Attribute(4L, "MaxConstPressure")

    object MinCompPressure : Attribute(5L, "MinCompPressure")

    object MaxCompPressure : Attribute(6L, "MaxCompPressure")

    object MinConstSpeed : Attribute(7L, "MinConstSpeed")

    object MaxConstSpeed : Attribute(8L, "MaxConstSpeed")

    object MinConstFlow : Attribute(9L, "MinConstFlow")

    object MaxConstFlow : Attribute(10L, "MaxConstFlow")

    object MinConstTemp : Attribute(11L, "MinConstTemp")

    object MaxConstTemp : Attribute(12L, "MaxConstTemp")

    object PumpStatus : Attribute(16L, "PumpStatus")

    object EffectiveOperationMode : Attribute(17L, "EffectiveOperationMode")

    object EffectiveControlMode : Attribute(18L, "EffectiveControlMode")

    object Capacity : Attribute(19L, "Capacity")

    object Speed : Attribute(20L, "Speed")

    object LifetimeRunningHours : Attribute(21L, "LifetimeRunningHours")

    object Power : Attribute(22L, "Power")

    object LifetimeEnergyConsumed : Attribute(23L, "LifetimeEnergyConsumed")

    object OperationMode : Attribute(32L, "OperationMode")

    object ControlMode : Attribute(33L, "ControlMode")

    object GeneratedCommandList : Attribute(65528L, "GeneratedCommandList")

    object AcceptedCommandList : Attribute(65529L, "AcceptedCommandList")

    object EventList : Attribute(65530L, "EventList")

    object AttributeList : Attribute(65531L, "AttributeList")

    object FeatureMap : Attribute(65532L, "FeatureMap")

    object ClusterRevision : Attribute(65533L, "ClusterRevision")

    companion object {
      fun values(): List<Attribute> {
        return Attribute::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Long): Attribute {
        for (attribute in values()) {
          if (attribute.id == id) {
            return attribute
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): Attribute {
        for (attribute in values()) {
          if (attribute.name == value) {
            return attribute
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class Event(val id: Long, val name: String) {
    object SupplyVoltageLow : Event(0L, "SupplyVoltageLow")

    object SupplyVoltageHigh : Event(1L, "SupplyVoltageHigh")

    object PowerMissingPhase : Event(2L, "PowerMissingPhase")

    object SystemPressureLow : Event(3L, "SystemPressureLow")

    object SystemPressureHigh : Event(4L, "SystemPressureHigh")

    object DryRunning : Event(5L, "DryRunning")

    object MotorTemperatureHigh : Event(6L, "MotorTemperatureHigh")

    object PumpMotorFatalFailure : Event(7L, "PumpMotorFatalFailure")

    object ElectronicTemperatureHigh : Event(8L, "ElectronicTemperatureHigh")

    object PumpBlocked : Event(9L, "PumpBlocked")

    object SensorFailure : Event(10L, "SensorFailure")

    object ElectronicNonFatalFailure : Event(11L, "ElectronicNonFatalFailure")

    object ElectronicFatalFailure : Event(12L, "ElectronicFatalFailure")

    object GeneralFault : Event(13L, "GeneralFault")

    object Leakage : Event(14L, "Leakage")

    object AirDetection : Event(15L, "AirDetection")

    object TurbineOperation : Event(16L, "TurbineOperation")

    companion object {
      fun values(): List<Event> {
        return Event::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Long): Event {
        for (event in values()) {
          if (event.id == id) {
            return event
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): Event {
        for (event in values()) {
          if (event.name == value) {
            return event
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  override fun getID(): Long {
    return ID
  }

  override fun getAttributeName(id: Long): String {
    return Attribute.value(id).toString()
  }

  override fun getEventName(id: Long): String {
    return Event.value(id).toString()
  }

  override fun getAttributeID(name: String): Long {
    return Attribute.valueOf(name).id
  }

  override fun getEventID(name: String): Long {
    return Event.valueOf(name).id
  }
}
