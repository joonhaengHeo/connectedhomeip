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

object OnOff : BaseCluster() {
  const val ID = 6L

  sealed class Attribute(val id: Long, val name: String) {
    object OnOff : Attribute(0L, "OnOff")

    object GlobalSceneControl : Attribute(16384L, "GlobalSceneControl")

    object OnTime : Attribute(16385L, "OnTime")

    object OffWaitTime : Attribute(16386L, "OffWaitTime")

    object StartUpOnOff : Attribute(16387L, "StartUpOnOff")

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
    object Off : Command(0L, "Off")

    object On : Command(1L, "On")

    object Toggle : Command(2L, "Toggle")

    object OffWithEffect : Command(64L, "OffWithEffect")

    object OnWithRecallGlobalScene : Command(65L, "OnWithRecallGlobalScene")

    object OnWithTimedOff : Command(66L, "OnWithTimedOff")

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

  sealed class OffWithEffectCommandField(val id: Int, val name: String) {
    object EffectIdentifier : OffWithEffectCommandField(0, "EffectIdentifier")

    object EffectVariant : OffWithEffectCommandField(1, "EffectVariant")

    companion object {
      fun values(): List<OffWithEffectCommandField> {
        return OffWithEffectCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): OffWithEffectCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): OffWithEffectCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class OnWithTimedOffCommandField(val id: Int, val name: String) {
    object OnOffControl : OnWithTimedOffCommandField(0, "OnOffControl")

    object OnTime : OnWithTimedOffCommandField(1, "OnTime")

    object OffWaitTime : OnWithTimedOffCommandField(2, "OffWaitTime")

    companion object {
      fun values(): List<OnWithTimedOffCommandField> {
        return OnWithTimedOffCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): OnWithTimedOffCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): OnWithTimedOffCommandField {
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
