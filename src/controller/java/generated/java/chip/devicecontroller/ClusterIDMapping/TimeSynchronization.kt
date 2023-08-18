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

object TimeSynchronization : BaseCluster() {
  const val ID = 56L

  sealed class Attribute(val id: Long, val name: String) {
    object UTCTime : Attribute(0L, "UTCTime")

    object Granularity : Attribute(1L, "Granularity")

    object TimeSource : Attribute(2L, "TimeSource")

    object TrustedTimeSource : Attribute(3L, "TrustedTimeSource")

    object DefaultNTP : Attribute(4L, "DefaultNTP")

    object TimeZone : Attribute(5L, "TimeZone")

    object DSTOffset : Attribute(6L, "DSTOffset")

    object LocalTime : Attribute(7L, "LocalTime")

    object TimeZoneDatabase : Attribute(8L, "TimeZoneDatabase")

    object NTPServerAvailable : Attribute(9L, "NTPServerAvailable")

    object TimeZoneListMaxSize : Attribute(10L, "TimeZoneListMaxSize")

    object DSTOffsetListMaxSize : Attribute(11L, "DSTOffsetListMaxSize")

    object SupportsDNSResolve : Attribute(12L, "SupportsDNSResolve")

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
    object DSTTableEmpty : Event(0L, "DSTTableEmpty")

    object DSTStatus : Event(1L, "DSTStatus")

    object TimeZoneStatus : Event(2L, "TimeZoneStatus")

    object TimeFailure : Event(3L, "TimeFailure")

    object MissingTrustedTimeSource : Event(4L, "MissingTrustedTimeSource")

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
    object SetUTCTime : Command(0L, "SetUTCTime")

    object SetTrustedTimeSource : Command(1L, "SetTrustedTimeSource")

    object SetTimeZone : Command(2L, "SetTimeZone")

    object SetDSTOffset : Command(4L, "SetDSTOffset")

    object SetDefaultNTP : Command(5L, "SetDefaultNTP")

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

  sealed class SetUTCTimeCommandField(val id: Int, val name: String) {
    object UTCTime : SetUTCTimeCommandField(0, "UTCTime")

    object Granularity : SetUTCTimeCommandField(1, "Granularity")

    object TimeSource : SetUTCTimeCommandField(2, "TimeSource")

    companion object {
      fun values(): List<SetUTCTimeCommandField> {
        return SetUTCTimeCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): SetUTCTimeCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): SetUTCTimeCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class SetTrustedTimeSourceCommandField(val id: Int, val name: String) {
    object TrustedTimeSource : SetTrustedTimeSourceCommandField(0, "TrustedTimeSource")

    companion object {
      fun values(): List<SetTrustedTimeSourceCommandField> {
        return SetTrustedTimeSourceCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): SetTrustedTimeSourceCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): SetTrustedTimeSourceCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class SetTimeZoneCommandField(val id: Int, val name: String) {
    object TimeZone : SetTimeZoneCommandField(0, "TimeZone")

    companion object {
      fun values(): List<SetTimeZoneCommandField> {
        return SetTimeZoneCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): SetTimeZoneCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): SetTimeZoneCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class SetDSTOffsetCommandField(val id: Int, val name: String) {
    object DSTOffset : SetDSTOffsetCommandField(0, "DSTOffset")

    companion object {
      fun values(): List<SetDSTOffsetCommandField> {
        return SetDSTOffsetCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): SetDSTOffsetCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): SetDSTOffsetCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class SetDefaultNTPCommandField(val id: Int, val name: String) {
    object DefaultNTP : SetDefaultNTPCommandField(0, "DefaultNTP")

    companion object {
      fun values(): List<SetDefaultNTPCommandField> {
        return SetDefaultNTPCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): SetDefaultNTPCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): SetDefaultNTPCommandField {
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
