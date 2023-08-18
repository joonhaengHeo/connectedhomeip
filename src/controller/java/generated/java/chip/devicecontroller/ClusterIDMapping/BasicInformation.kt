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

object BasicInformation : BaseCluster() {
  const val ID = 40L

  sealed class Attribute(val id: Long, val name: String) {
    object DataModelRevision : Attribute(0L, "DataModelRevision")

    object VendorName : Attribute(1L, "VendorName")

    object VendorID : Attribute(2L, "VendorID")

    object ProductName : Attribute(3L, "ProductName")

    object ProductID : Attribute(4L, "ProductID")

    object NodeLabel : Attribute(5L, "NodeLabel")

    object Location : Attribute(6L, "Location")

    object HardwareVersion : Attribute(7L, "HardwareVersion")

    object HardwareVersionString : Attribute(8L, "HardwareVersionString")

    object SoftwareVersion : Attribute(9L, "SoftwareVersion")

    object SoftwareVersionString : Attribute(10L, "SoftwareVersionString")

    object ManufacturingDate : Attribute(11L, "ManufacturingDate")

    object PartNumber : Attribute(12L, "PartNumber")

    object ProductURL : Attribute(13L, "ProductURL")

    object ProductLabel : Attribute(14L, "ProductLabel")

    object SerialNumber : Attribute(15L, "SerialNumber")

    object LocalConfigDisabled : Attribute(16L, "LocalConfigDisabled")

    object Reachable : Attribute(17L, "Reachable")

    object UniqueID : Attribute(18L, "UniqueID")

    object CapabilityMinima : Attribute(19L, "CapabilityMinima")

    object ProductAppearance : Attribute(20L, "ProductAppearance")

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
    object StartUp : Event(0L, "StartUp")

    object ShutDown : Event(1L, "ShutDown")

    object Leave : Event(2L, "Leave")

    object ReachableChanged : Event(3L, "ReachableChanged")

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
    object MfgSpecificPing : Command(0L, "MfgSpecificPing")

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
