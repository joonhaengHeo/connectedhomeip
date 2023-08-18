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

object Thermostat : BaseCluster() {
  const val ID = 513L

  sealed class Attribute(val id: Long, val name: String) {
    object LocalTemperature : Attribute(0L, "LocalTemperature")

    object OutdoorTemperature : Attribute(1L, "OutdoorTemperature")

    object Occupancy : Attribute(2L, "Occupancy")

    object AbsMinHeatSetpointLimit : Attribute(3L, "AbsMinHeatSetpointLimit")

    object AbsMaxHeatSetpointLimit : Attribute(4L, "AbsMaxHeatSetpointLimit")

    object AbsMinCoolSetpointLimit : Attribute(5L, "AbsMinCoolSetpointLimit")

    object AbsMaxCoolSetpointLimit : Attribute(6L, "AbsMaxCoolSetpointLimit")

    object PICoolingDemand : Attribute(7L, "PICoolingDemand")

    object PIHeatingDemand : Attribute(8L, "PIHeatingDemand")

    object HVACSystemTypeConfiguration : Attribute(9L, "HVACSystemTypeConfiguration")

    object LocalTemperatureCalibration : Attribute(16L, "LocalTemperatureCalibration")

    object OccupiedCoolingSetpoint : Attribute(17L, "OccupiedCoolingSetpoint")

    object OccupiedHeatingSetpoint : Attribute(18L, "OccupiedHeatingSetpoint")

    object UnoccupiedCoolingSetpoint : Attribute(19L, "UnoccupiedCoolingSetpoint")

    object UnoccupiedHeatingSetpoint : Attribute(20L, "UnoccupiedHeatingSetpoint")

    object MinHeatSetpointLimit : Attribute(21L, "MinHeatSetpointLimit")

    object MaxHeatSetpointLimit : Attribute(22L, "MaxHeatSetpointLimit")

    object MinCoolSetpointLimit : Attribute(23L, "MinCoolSetpointLimit")

    object MaxCoolSetpointLimit : Attribute(24L, "MaxCoolSetpointLimit")

    object MinSetpointDeadBand : Attribute(25L, "MinSetpointDeadBand")

    object RemoteSensing : Attribute(26L, "RemoteSensing")

    object ControlSequenceOfOperation : Attribute(27L, "ControlSequenceOfOperation")

    object SystemMode : Attribute(28L, "SystemMode")

    object ThermostatRunningMode : Attribute(30L, "ThermostatRunningMode")

    object StartOfWeek : Attribute(32L, "StartOfWeek")

    object NumberOfWeeklyTransitions : Attribute(33L, "NumberOfWeeklyTransitions")

    object NumberOfDailyTransitions : Attribute(34L, "NumberOfDailyTransitions")

    object TemperatureSetpointHold : Attribute(35L, "TemperatureSetpointHold")

    object TemperatureSetpointHoldDuration : Attribute(36L, "TemperatureSetpointHoldDuration")

    object ThermostatProgrammingOperationMode :
      Attribute(37L, "ThermostatProgrammingOperationMode")

    object ThermostatRunningState : Attribute(41L, "ThermostatRunningState")

    object SetpointChangeSource : Attribute(48L, "SetpointChangeSource")

    object SetpointChangeAmount : Attribute(49L, "SetpointChangeAmount")

    object SetpointChangeSourceTimestamp : Attribute(50L, "SetpointChangeSourceTimestamp")

    object OccupiedSetback : Attribute(52L, "OccupiedSetback")

    object OccupiedSetbackMin : Attribute(53L, "OccupiedSetbackMin")

    object OccupiedSetbackMax : Attribute(54L, "OccupiedSetbackMax")

    object UnoccupiedSetback : Attribute(55L, "UnoccupiedSetback")

    object UnoccupiedSetbackMin : Attribute(56L, "UnoccupiedSetbackMin")

    object UnoccupiedSetbackMax : Attribute(57L, "UnoccupiedSetbackMax")

    object EmergencyHeatDelta : Attribute(58L, "EmergencyHeatDelta")

    object ACType : Attribute(64L, "ACType")

    object ACCapacity : Attribute(65L, "ACCapacity")

    object ACRefrigerantType : Attribute(66L, "ACRefrigerantType")

    object ACCompressorType : Attribute(67L, "ACCompressorType")

    object ACErrorCode : Attribute(68L, "ACErrorCode")

    object ACLouverPosition : Attribute(69L, "ACLouverPosition")

    object ACCoilTemperature : Attribute(70L, "ACCoilTemperature")

    object ACCapacityformat : Attribute(71L, "ACCapacityformat")

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

  sealed class Command(val id: Long, val name: String) {
    object SetpointRaiseLower : Command(0L, "SetpointRaiseLower")

    object SetWeeklySchedule : Command(1L, "SetWeeklySchedule")

    object GetWeeklySchedule : Command(2L, "GetWeeklySchedule")

    object ClearWeeklySchedule : Command(3L, "ClearWeeklySchedule")

    companion object {
      fun values(): List<Command> {
        return Command::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Long): Command {
        for (command in values()) {
          if (command.id == id) {
            return command
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): Command {
        for (command in values()) {
          if (command.name == value) {
            return command
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class SetpointRaiseLowerCommandField(val id: Int, val name: String) {
    object Mode : SetpointRaiseLowerCommandField(0, "Mode")

    object Amount : SetpointRaiseLowerCommandField(1, "Amount")

    companion object {
      fun values(): List<SetpointRaiseLowerCommandField> {
        return SetpointRaiseLowerCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): SetpointRaiseLowerCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): SetpointRaiseLowerCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class SetWeeklyScheduleCommandField(val id: Int, val name: String) {
    object NumberOfTransitionsForSequence :
      SetWeeklyScheduleCommandField(0, "NumberOfTransitionsForSequence")

    object DayOfWeekForSequence : SetWeeklyScheduleCommandField(1, "DayOfWeekForSequence")

    object ModeForSequence : SetWeeklyScheduleCommandField(2, "ModeForSequence")

    object Transitions : SetWeeklyScheduleCommandField(3, "Transitions")

    companion object {
      fun values(): List<SetWeeklyScheduleCommandField> {
        return SetWeeklyScheduleCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): SetWeeklyScheduleCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): SetWeeklyScheduleCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class GetWeeklyScheduleCommandField(val id: Int, val name: String) {
    object DaysToReturn : GetWeeklyScheduleCommandField(0, "DaysToReturn")

    object ModeToReturn : GetWeeklyScheduleCommandField(1, "ModeToReturn")

    companion object {
      fun values(): List<GetWeeklyScheduleCommandField> {
        return GetWeeklyScheduleCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): GetWeeklyScheduleCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): GetWeeklyScheduleCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
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

  override fun getCommandName(id: Long): String {
    return Command.value(id).toString()
  }

  override fun getAttributeID(name: String): Long {
    return Attribute.valueOf(name).id
  }

  override fun getCommandID(name: String): Long {
    return Command.valueOf(name).id
  }
}
