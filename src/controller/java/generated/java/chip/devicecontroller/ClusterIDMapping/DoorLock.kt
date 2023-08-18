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

object DoorLock : BaseCluster() {
  const val ID = 257L

  sealed class Attribute(val id: Long, val name: String) {
    object LockState : Attribute(0L, "LockState")

    object LockType : Attribute(1L, "LockType")

    object ActuatorEnabled : Attribute(2L, "ActuatorEnabled")

    object DoorState : Attribute(3L, "DoorState")

    object DoorOpenEvents : Attribute(4L, "DoorOpenEvents")

    object DoorClosedEvents : Attribute(5L, "DoorClosedEvents")

    object OpenPeriod : Attribute(6L, "OpenPeriod")

    object NumberOfTotalUsersSupported : Attribute(17L, "NumberOfTotalUsersSupported")

    object NumberOfPINUsersSupported : Attribute(18L, "NumberOfPINUsersSupported")

    object NumberOfRFIDUsersSupported : Attribute(19L, "NumberOfRFIDUsersSupported")

    object NumberOfWeekDaySchedulesSupportedPerUser :
      Attribute(20L, "NumberOfWeekDaySchedulesSupportedPerUser")

    object NumberOfYearDaySchedulesSupportedPerUser :
      Attribute(21L, "NumberOfYearDaySchedulesSupportedPerUser")

    object NumberOfHolidaySchedulesSupported : Attribute(22L, "NumberOfHolidaySchedulesSupported")

    object MaxPINCodeLength : Attribute(23L, "MaxPINCodeLength")

    object MinPINCodeLength : Attribute(24L, "MinPINCodeLength")

    object MaxRFIDCodeLength : Attribute(25L, "MaxRFIDCodeLength")

    object MinRFIDCodeLength : Attribute(26L, "MinRFIDCodeLength")

    object CredentialRulesSupport : Attribute(27L, "CredentialRulesSupport")

    object NumberOfCredentialsSupportedPerUser :
      Attribute(28L, "NumberOfCredentialsSupportedPerUser")

    object Language : Attribute(33L, "Language")

    object LEDSettings : Attribute(34L, "LEDSettings")

    object AutoRelockTime : Attribute(35L, "AutoRelockTime")

    object SoundVolume : Attribute(36L, "SoundVolume")

    object OperatingMode : Attribute(37L, "OperatingMode")

    object SupportedOperatingModes : Attribute(38L, "SupportedOperatingModes")

    object DefaultConfigurationRegister : Attribute(39L, "DefaultConfigurationRegister")

    object EnableLocalProgramming : Attribute(40L, "EnableLocalProgramming")

    object EnableOneTouchLocking : Attribute(41L, "EnableOneTouchLocking")

    object EnableInsideStatusLED : Attribute(42L, "EnableInsideStatusLED")

    object EnablePrivacyModeButton : Attribute(43L, "EnablePrivacyModeButton")

    object LocalProgrammingFeatures : Attribute(44L, "LocalProgrammingFeatures")

    object WrongCodeEntryLimit : Attribute(48L, "WrongCodeEntryLimit")

    object UserCodeTemporaryDisableTime : Attribute(49L, "UserCodeTemporaryDisableTime")

    object SendPINOverTheAir : Attribute(50L, "SendPINOverTheAir")

    object RequirePINforRemoteOperation : Attribute(51L, "RequirePINforRemoteOperation")

    object ExpiringUserTimeout : Attribute(53L, "ExpiringUserTimeout")

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
    object DoorLockAlarm : Event(0L, "DoorLockAlarm")

    object DoorStateChange : Event(1L, "DoorStateChange")

    object LockOperation : Event(2L, "LockOperation")

    object LockOperationError : Event(3L, "LockOperationError")

    object LockUserChange : Event(4L, "LockUserChange")

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

  sealed class Command(val id: Long, val name: String) {
    object LockDoor : Command(0L, "LockDoor")

    object UnlockDoor : Command(1L, "UnlockDoor")

    object UnlockWithTimeout : Command(3L, "UnlockWithTimeout")

    object SetWeekDaySchedule : Command(11L, "SetWeekDaySchedule")

    object GetWeekDaySchedule : Command(12L, "GetWeekDaySchedule")

    object ClearWeekDaySchedule : Command(13L, "ClearWeekDaySchedule")

    object SetYearDaySchedule : Command(14L, "SetYearDaySchedule")

    object GetYearDaySchedule : Command(15L, "GetYearDaySchedule")

    object ClearYearDaySchedule : Command(16L, "ClearYearDaySchedule")

    object SetHolidaySchedule : Command(17L, "SetHolidaySchedule")

    object GetHolidaySchedule : Command(18L, "GetHolidaySchedule")

    object ClearHolidaySchedule : Command(19L, "ClearHolidaySchedule")

    object SetUser : Command(26L, "SetUser")

    object GetUser : Command(27L, "GetUser")

    object ClearUser : Command(29L, "ClearUser")

    object SetCredential : Command(34L, "SetCredential")

    object GetCredentialStatus : Command(36L, "GetCredentialStatus")

    object ClearCredential : Command(38L, "ClearCredential")

    object UnboltDoor : Command(39L, "UnboltDoor")

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

  sealed class LockDoorCommandField(val id: Int, val name: String) {
    object PINCode : LockDoorCommandField(0, "PINCode")

    companion object {
      fun values(): List<LockDoorCommandField> {
        return LockDoorCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): LockDoorCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): LockDoorCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class UnlockDoorCommandField(val id: Int, val name: String) {
    object PINCode : UnlockDoorCommandField(0, "PINCode")

    companion object {
      fun values(): List<UnlockDoorCommandField> {
        return UnlockDoorCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): UnlockDoorCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): UnlockDoorCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class UnlockWithTimeoutCommandField(val id: Int, val name: String) {
    object Timeout : UnlockWithTimeoutCommandField(0, "Timeout")

    object PINCode : UnlockWithTimeoutCommandField(1, "PINCode")

    companion object {
      fun values(): List<UnlockWithTimeoutCommandField> {
        return UnlockWithTimeoutCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): UnlockWithTimeoutCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): UnlockWithTimeoutCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class SetWeekDayScheduleCommandField(val id: Int, val name: String) {
    object WeekDayIndex : SetWeekDayScheduleCommandField(0, "WeekDayIndex")

    object UserIndex : SetWeekDayScheduleCommandField(1, "UserIndex")

    object DaysMask : SetWeekDayScheduleCommandField(2, "DaysMask")

    object StartHour : SetWeekDayScheduleCommandField(3, "StartHour")

    object StartMinute : SetWeekDayScheduleCommandField(4, "StartMinute")

    object EndHour : SetWeekDayScheduleCommandField(5, "EndHour")

    object EndMinute : SetWeekDayScheduleCommandField(6, "EndMinute")

    companion object {
      fun values(): List<SetWeekDayScheduleCommandField> {
        return SetWeekDayScheduleCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): SetWeekDayScheduleCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): SetWeekDayScheduleCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class GetWeekDayScheduleCommandField(val id: Int, val name: String) {
    object WeekDayIndex : GetWeekDayScheduleCommandField(0, "WeekDayIndex")

    object UserIndex : GetWeekDayScheduleCommandField(1, "UserIndex")

    companion object {
      fun values(): List<GetWeekDayScheduleCommandField> {
        return GetWeekDayScheduleCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): GetWeekDayScheduleCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): GetWeekDayScheduleCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class ClearWeekDayScheduleCommandField(val id: Int, val name: String) {
    object WeekDayIndex : ClearWeekDayScheduleCommandField(0, "WeekDayIndex")

    object UserIndex : ClearWeekDayScheduleCommandField(1, "UserIndex")

    companion object {
      fun values(): List<ClearWeekDayScheduleCommandField> {
        return ClearWeekDayScheduleCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): ClearWeekDayScheduleCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): ClearWeekDayScheduleCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class SetYearDayScheduleCommandField(val id: Int, val name: String) {
    object YearDayIndex : SetYearDayScheduleCommandField(0, "YearDayIndex")

    object UserIndex : SetYearDayScheduleCommandField(1, "UserIndex")

    object LocalStartTime : SetYearDayScheduleCommandField(2, "LocalStartTime")

    object LocalEndTime : SetYearDayScheduleCommandField(3, "LocalEndTime")

    companion object {
      fun values(): List<SetYearDayScheduleCommandField> {
        return SetYearDayScheduleCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): SetYearDayScheduleCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): SetYearDayScheduleCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class GetYearDayScheduleCommandField(val id: Int, val name: String) {
    object YearDayIndex : GetYearDayScheduleCommandField(0, "YearDayIndex")

    object UserIndex : GetYearDayScheduleCommandField(1, "UserIndex")

    companion object {
      fun values(): List<GetYearDayScheduleCommandField> {
        return GetYearDayScheduleCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): GetYearDayScheduleCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): GetYearDayScheduleCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class ClearYearDayScheduleCommandField(val id: Int, val name: String) {
    object YearDayIndex : ClearYearDayScheduleCommandField(0, "YearDayIndex")

    object UserIndex : ClearYearDayScheduleCommandField(1, "UserIndex")

    companion object {
      fun values(): List<ClearYearDayScheduleCommandField> {
        return ClearYearDayScheduleCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): ClearYearDayScheduleCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): ClearYearDayScheduleCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class SetHolidayScheduleCommandField(val id: Int, val name: String) {
    object HolidayIndex : SetHolidayScheduleCommandField(0, "HolidayIndex")

    object LocalStartTime : SetHolidayScheduleCommandField(1, "LocalStartTime")

    object LocalEndTime : SetHolidayScheduleCommandField(2, "LocalEndTime")

    object OperatingMode : SetHolidayScheduleCommandField(3, "OperatingMode")

    companion object {
      fun values(): List<SetHolidayScheduleCommandField> {
        return SetHolidayScheduleCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): SetHolidayScheduleCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): SetHolidayScheduleCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class GetHolidayScheduleCommandField(val id: Int, val name: String) {
    object HolidayIndex : GetHolidayScheduleCommandField(0, "HolidayIndex")

    companion object {
      fun values(): List<GetHolidayScheduleCommandField> {
        return GetHolidayScheduleCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): GetHolidayScheduleCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): GetHolidayScheduleCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class ClearHolidayScheduleCommandField(val id: Int, val name: String) {
    object HolidayIndex : ClearHolidayScheduleCommandField(0, "HolidayIndex")

    companion object {
      fun values(): List<ClearHolidayScheduleCommandField> {
        return ClearHolidayScheduleCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): ClearHolidayScheduleCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): ClearHolidayScheduleCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class SetUserCommandField(val id: Int, val name: String) {
    object OperationType : SetUserCommandField(0, "OperationType")

    object UserIndex : SetUserCommandField(1, "UserIndex")

    object UserName : SetUserCommandField(2, "UserName")

    object UserUniqueID : SetUserCommandField(3, "UserUniqueID")

    object UserStatus : SetUserCommandField(4, "UserStatus")

    object UserType : SetUserCommandField(5, "UserType")

    object CredentialRule : SetUserCommandField(6, "CredentialRule")

    companion object {
      fun values(): List<SetUserCommandField> {
        return SetUserCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): SetUserCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): SetUserCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class GetUserCommandField(val id: Int, val name: String) {
    object UserIndex : GetUserCommandField(0, "UserIndex")

    companion object {
      fun values(): List<GetUserCommandField> {
        return GetUserCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): GetUserCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): GetUserCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class ClearUserCommandField(val id: Int, val name: String) {
    object UserIndex : ClearUserCommandField(0, "UserIndex")

    companion object {
      fun values(): List<ClearUserCommandField> {
        return ClearUserCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): ClearUserCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): ClearUserCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class SetCredentialCommandField(val id: Int, val name: String) {
    object OperationType : SetCredentialCommandField(0, "OperationType")

    object Credential : SetCredentialCommandField(1, "Credential")

    object CredentialData : SetCredentialCommandField(2, "CredentialData")

    object UserIndex : SetCredentialCommandField(3, "UserIndex")

    object UserStatus : SetCredentialCommandField(4, "UserStatus")

    object UserType : SetCredentialCommandField(5, "UserType")

    companion object {
      fun values(): List<SetCredentialCommandField> {
        return SetCredentialCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): SetCredentialCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): SetCredentialCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class GetCredentialStatusCommandField(val id: Int, val name: String) {
    object Credential : GetCredentialStatusCommandField(0, "Credential")

    companion object {
      fun values(): List<GetCredentialStatusCommandField> {
        return GetCredentialStatusCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): GetCredentialStatusCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): GetCredentialStatusCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class ClearCredentialCommandField(val id: Int, val name: String) {
    object Credential : ClearCredentialCommandField(0, "Credential")

    companion object {
      fun values(): List<ClearCredentialCommandField> {
        return ClearCredentialCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): ClearCredentialCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): ClearCredentialCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class UnboltDoorCommandField(val id: Int, val name: String) {
    object PINCode : UnboltDoorCommandField(0, "PINCode")

    companion object {
      fun values(): List<UnboltDoorCommandField> {
        return UnboltDoorCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): UnboltDoorCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): UnboltDoorCommandField {
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

  override fun getEventName(id: Long): String {
    return Event.value(id).toString()
  }

  override fun getCommandName(id: Long): String {
    return Command.value(id).toString()
  }

  override fun getAttributeID(name: String): Long {
    return Attribute.valueOf(name).id
  }

  override fun getEventID(name: String): Long {
    return Event.valueOf(name).id
  }

  override fun getCommandID(name: String): Long {
    return Command.valueOf(name).id
  }
}
