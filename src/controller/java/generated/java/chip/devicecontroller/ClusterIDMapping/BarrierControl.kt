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

object BarrierControl : BaseCluster() {
  const val ID = 259L

  sealed class Attribute(val id: Long, val name: String) {
    object BarrierMovingState : Attribute(1L, "BarrierMovingState")

    object BarrierSafetyStatus : Attribute(2L, "BarrierSafetyStatus")

    object BarrierCapabilities : Attribute(3L, "BarrierCapabilities")

    object BarrierOpenEvents : Attribute(4L, "BarrierOpenEvents")

    object BarrierCloseEvents : Attribute(5L, "BarrierCloseEvents")

    object BarrierCommandOpenEvents : Attribute(6L, "BarrierCommandOpenEvents")

    object BarrierCommandCloseEvents : Attribute(7L, "BarrierCommandCloseEvents")

    object BarrierOpenPeriod : Attribute(8L, "BarrierOpenPeriod")

    object BarrierClosePeriod : Attribute(9L, "BarrierClosePeriod")

    object BarrierPosition : Attribute(10L, "BarrierPosition")

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
    object BarrierControlGoToPercent : Command(0L, "BarrierControlGoToPercent")

    object BarrierControlStop : Command(1L, "BarrierControlStop")

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

  sealed class BarrierControlGoToPercentCommandField(val id: Int, val name: String) {
    object PercentOpen : BarrierControlGoToPercentCommandField(0, "PercentOpen")

    companion object {
      fun values(): List<BarrierControlGoToPercentCommandField> {
        return BarrierControlGoToPercentCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): BarrierControlGoToPercentCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): BarrierControlGoToPercentCommandField {
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
