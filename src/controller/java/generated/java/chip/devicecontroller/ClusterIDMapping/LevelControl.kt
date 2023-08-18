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

object LevelControl : BaseCluster() {
  const val ID = 8L

  sealed class Attribute(val id: Long, val name: String) {
    object CurrentLevel : Attribute(0L, "CurrentLevel")

    object RemainingTime : Attribute(1L, "RemainingTime")

    object MinLevel : Attribute(2L, "MinLevel")

    object MaxLevel : Attribute(3L, "MaxLevel")

    object CurrentFrequency : Attribute(4L, "CurrentFrequency")

    object MinFrequency : Attribute(5L, "MinFrequency")

    object MaxFrequency : Attribute(6L, "MaxFrequency")

    object Options : Attribute(15L, "Options")

    object OnOffTransitionTime : Attribute(16L, "OnOffTransitionTime")

    object OnLevel : Attribute(17L, "OnLevel")

    object OnTransitionTime : Attribute(18L, "OnTransitionTime")

    object OffTransitionTime : Attribute(19L, "OffTransitionTime")

    object DefaultMoveRate : Attribute(20L, "DefaultMoveRate")

    object StartUpCurrentLevel : Attribute(16384L, "StartUpCurrentLevel")

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
    object MoveToLevel : Command(0L, "MoveToLevel")

    object Move : Command(1L, "Move")

    object Step : Command(2L, "Step")

    object Stop : Command(3L, "Stop")

    object MoveToLevelWithOnOff : Command(4L, "MoveToLevelWithOnOff")

    object MoveWithOnOff : Command(5L, "MoveWithOnOff")

    object StepWithOnOff : Command(6L, "StepWithOnOff")

    object StopWithOnOff : Command(7L, "StopWithOnOff")

    object MoveToClosestFrequency : Command(8L, "MoveToClosestFrequency")

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

  sealed class MoveToLevelCommandField(val id: Int, val name: String) {
    object Level : MoveToLevelCommandField(0, "Level")

    object TransitionTime : MoveToLevelCommandField(1, "TransitionTime")

    object OptionsMask : MoveToLevelCommandField(2, "OptionsMask")

    object OptionsOverride : MoveToLevelCommandField(3, "OptionsOverride")

    companion object {
      fun values(): List<MoveToLevelCommandField> {
        return MoveToLevelCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): MoveToLevelCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): MoveToLevelCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class MoveCommandField(val id: Int, val name: String) {
    object MoveMode : MoveCommandField(0, "MoveMode")

    object Rate : MoveCommandField(1, "Rate")

    object OptionsMask : MoveCommandField(2, "OptionsMask")

    object OptionsOverride : MoveCommandField(3, "OptionsOverride")

    companion object {
      fun values(): List<MoveCommandField> {
        return MoveCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): MoveCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): MoveCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class StepCommandField(val id: Int, val name: String) {
    object StepMode : StepCommandField(0, "StepMode")

    object StepSize : StepCommandField(1, "StepSize")

    object TransitionTime : StepCommandField(2, "TransitionTime")

    object OptionsMask : StepCommandField(3, "OptionsMask")

    object OptionsOverride : StepCommandField(4, "OptionsOverride")

    companion object {
      fun values(): List<StepCommandField> {
        return StepCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): StepCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): StepCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class StopCommandField(val id: Int, val name: String) {
    object OptionsMask : StopCommandField(0, "OptionsMask")

    object OptionsOverride : StopCommandField(1, "OptionsOverride")

    companion object {
      fun values(): List<StopCommandField> {
        return StopCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): StopCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): StopCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class MoveToLevelWithOnOffCommandField(val id: Int, val name: String) {
    object Level : MoveToLevelWithOnOffCommandField(0, "Level")

    object TransitionTime : MoveToLevelWithOnOffCommandField(1, "TransitionTime")

    object OptionsMask : MoveToLevelWithOnOffCommandField(2, "OptionsMask")

    object OptionsOverride : MoveToLevelWithOnOffCommandField(3, "OptionsOverride")

    companion object {
      fun values(): List<MoveToLevelWithOnOffCommandField> {
        return MoveToLevelWithOnOffCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): MoveToLevelWithOnOffCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): MoveToLevelWithOnOffCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class MoveWithOnOffCommandField(val id: Int, val name: String) {
    object MoveMode : MoveWithOnOffCommandField(0, "MoveMode")

    object Rate : MoveWithOnOffCommandField(1, "Rate")

    object OptionsMask : MoveWithOnOffCommandField(2, "OptionsMask")

    object OptionsOverride : MoveWithOnOffCommandField(3, "OptionsOverride")

    companion object {
      fun values(): List<MoveWithOnOffCommandField> {
        return MoveWithOnOffCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): MoveWithOnOffCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): MoveWithOnOffCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class StepWithOnOffCommandField(val id: Int, val name: String) {
    object StepMode : StepWithOnOffCommandField(0, "StepMode")

    object StepSize : StepWithOnOffCommandField(1, "StepSize")

    object TransitionTime : StepWithOnOffCommandField(2, "TransitionTime")

    object OptionsMask : StepWithOnOffCommandField(3, "OptionsMask")

    object OptionsOverride : StepWithOnOffCommandField(4, "OptionsOverride")

    companion object {
      fun values(): List<StepWithOnOffCommandField> {
        return StepWithOnOffCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): StepWithOnOffCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): StepWithOnOffCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class StopWithOnOffCommandField(val id: Int, val name: String) {
    object OptionsMask : StopWithOnOffCommandField(0, "OptionsMask")

    object OptionsOverride : StopWithOnOffCommandField(1, "OptionsOverride")

    companion object {
      fun values(): List<StopWithOnOffCommandField> {
        return StopWithOnOffCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): StopWithOnOffCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): StopWithOnOffCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class MoveToClosestFrequencyCommandField(val id: Int, val name: String) {
    object Frequency : MoveToClosestFrequencyCommandField(0, "Frequency")

    companion object {
      fun values(): List<MoveToClosestFrequencyCommandField> {
        return MoveToClosestFrequencyCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): MoveToClosestFrequencyCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): MoveToClosestFrequencyCommandField {
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
