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

object ColorControl : BaseCluster() {
  const val ID = 768L

  sealed class Attribute(val id: Long, val name: String) {
    object CurrentHue : Attribute(0L, "CurrentHue")

    object CurrentSaturation : Attribute(1L, "CurrentSaturation")

    object RemainingTime : Attribute(2L, "RemainingTime")

    object CurrentX : Attribute(3L, "CurrentX")

    object CurrentY : Attribute(4L, "CurrentY")

    object DriftCompensation : Attribute(5L, "DriftCompensation")

    object CompensationText : Attribute(6L, "CompensationText")

    object ColorTemperatureMireds : Attribute(7L, "ColorTemperatureMireds")

    object ColorMode : Attribute(8L, "ColorMode")

    object Options : Attribute(15L, "Options")

    object NumberOfPrimaries : Attribute(16L, "NumberOfPrimaries")

    object Primary1X : Attribute(17L, "Primary1X")

    object Primary1Y : Attribute(18L, "Primary1Y")

    object Primary1Intensity : Attribute(19L, "Primary1Intensity")

    object Primary2X : Attribute(21L, "Primary2X")

    object Primary2Y : Attribute(22L, "Primary2Y")

    object Primary2Intensity : Attribute(23L, "Primary2Intensity")

    object Primary3X : Attribute(25L, "Primary3X")

    object Primary3Y : Attribute(26L, "Primary3Y")

    object Primary3Intensity : Attribute(27L, "Primary3Intensity")

    object Primary4X : Attribute(32L, "Primary4X")

    object Primary4Y : Attribute(33L, "Primary4Y")

    object Primary4Intensity : Attribute(34L, "Primary4Intensity")

    object Primary5X : Attribute(36L, "Primary5X")

    object Primary5Y : Attribute(37L, "Primary5Y")

    object Primary5Intensity : Attribute(38L, "Primary5Intensity")

    object Primary6X : Attribute(40L, "Primary6X")

    object Primary6Y : Attribute(41L, "Primary6Y")

    object Primary6Intensity : Attribute(42L, "Primary6Intensity")

    object WhitePointX : Attribute(48L, "WhitePointX")

    object WhitePointY : Attribute(49L, "WhitePointY")

    object ColorPointRX : Attribute(50L, "ColorPointRX")

    object ColorPointRY : Attribute(51L, "ColorPointRY")

    object ColorPointRIntensity : Attribute(52L, "ColorPointRIntensity")

    object ColorPointGX : Attribute(54L, "ColorPointGX")

    object ColorPointGY : Attribute(55L, "ColorPointGY")

    object ColorPointGIntensity : Attribute(56L, "ColorPointGIntensity")

    object ColorPointBX : Attribute(58L, "ColorPointBX")

    object ColorPointBY : Attribute(59L, "ColorPointBY")

    object ColorPointBIntensity : Attribute(60L, "ColorPointBIntensity")

    object EnhancedCurrentHue : Attribute(16384L, "EnhancedCurrentHue")

    object EnhancedColorMode : Attribute(16385L, "EnhancedColorMode")

    object ColorLoopActive : Attribute(16386L, "ColorLoopActive")

    object ColorLoopDirection : Attribute(16387L, "ColorLoopDirection")

    object ColorLoopTime : Attribute(16388L, "ColorLoopTime")

    object ColorLoopStartEnhancedHue : Attribute(16389L, "ColorLoopStartEnhancedHue")

    object ColorLoopStoredEnhancedHue : Attribute(16390L, "ColorLoopStoredEnhancedHue")

    object ColorCapabilities : Attribute(16394L, "ColorCapabilities")

    object ColorTempPhysicalMinMireds : Attribute(16395L, "ColorTempPhysicalMinMireds")

    object ColorTempPhysicalMaxMireds : Attribute(16396L, "ColorTempPhysicalMaxMireds")

    object CoupleColorTempToLevelMinMireds : Attribute(16397L, "CoupleColorTempToLevelMinMireds")

    object StartUpColorTemperatureMireds : Attribute(16400L, "StartUpColorTemperatureMireds")

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
    object MoveToHue : Command(0L, "MoveToHue")

    object MoveHue : Command(1L, "MoveHue")

    object StepHue : Command(2L, "StepHue")

    object MoveToSaturation : Command(3L, "MoveToSaturation")

    object MoveSaturation : Command(4L, "MoveSaturation")

    object StepSaturation : Command(5L, "StepSaturation")

    object MoveToHueAndSaturation : Command(6L, "MoveToHueAndSaturation")

    object MoveToColor : Command(7L, "MoveToColor")

    object MoveColor : Command(8L, "MoveColor")

    object StepColor : Command(9L, "StepColor")

    object MoveToColorTemperature : Command(10L, "MoveToColorTemperature")

    object EnhancedMoveToHue : Command(64L, "EnhancedMoveToHue")

    object EnhancedMoveHue : Command(65L, "EnhancedMoveHue")

    object EnhancedStepHue : Command(66L, "EnhancedStepHue")

    object EnhancedMoveToHueAndSaturation : Command(67L, "EnhancedMoveToHueAndSaturation")

    object ColorLoopSet : Command(68L, "ColorLoopSet")

    object StopMoveStep : Command(71L, "StopMoveStep")

    object MoveColorTemperature : Command(75L, "MoveColorTemperature")

    object StepColorTemperature : Command(76L, "StepColorTemperature")

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

  sealed class MoveToHueCommandField(val id: Int, val name: String) {
    object Hue : MoveToHueCommandField(0, "Hue")

    object Direction : MoveToHueCommandField(1, "Direction")

    object TransitionTime : MoveToHueCommandField(2, "TransitionTime")

    object OptionsMask : MoveToHueCommandField(3, "OptionsMask")

    object OptionsOverride : MoveToHueCommandField(4, "OptionsOverride")

    companion object {
      fun values(): List<MoveToHueCommandField> {
        return MoveToHueCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): MoveToHueCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): MoveToHueCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class MoveHueCommandField(val id: Int, val name: String) {
    object MoveMode : MoveHueCommandField(0, "MoveMode")

    object Rate : MoveHueCommandField(1, "Rate")

    object OptionsMask : MoveHueCommandField(2, "OptionsMask")

    object OptionsOverride : MoveHueCommandField(3, "OptionsOverride")

    companion object {
      fun values(): List<MoveHueCommandField> {
        return MoveHueCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): MoveHueCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): MoveHueCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class StepHueCommandField(val id: Int, val name: String) {
    object StepMode : StepHueCommandField(0, "StepMode")

    object StepSize : StepHueCommandField(1, "StepSize")

    object TransitionTime : StepHueCommandField(2, "TransitionTime")

    object OptionsMask : StepHueCommandField(3, "OptionsMask")

    object OptionsOverride : StepHueCommandField(4, "OptionsOverride")

    companion object {
      fun values(): List<StepHueCommandField> {
        return StepHueCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): StepHueCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): StepHueCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class MoveToSaturationCommandField(val id: Int, val name: String) {
    object Saturation : MoveToSaturationCommandField(0, "Saturation")

    object TransitionTime : MoveToSaturationCommandField(1, "TransitionTime")

    object OptionsMask : MoveToSaturationCommandField(2, "OptionsMask")

    object OptionsOverride : MoveToSaturationCommandField(3, "OptionsOverride")

    companion object {
      fun values(): List<MoveToSaturationCommandField> {
        return MoveToSaturationCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): MoveToSaturationCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): MoveToSaturationCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class MoveSaturationCommandField(val id: Int, val name: String) {
    object MoveMode : MoveSaturationCommandField(0, "MoveMode")

    object Rate : MoveSaturationCommandField(1, "Rate")

    object OptionsMask : MoveSaturationCommandField(2, "OptionsMask")

    object OptionsOverride : MoveSaturationCommandField(3, "OptionsOverride")

    companion object {
      fun values(): List<MoveSaturationCommandField> {
        return MoveSaturationCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): MoveSaturationCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): MoveSaturationCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class StepSaturationCommandField(val id: Int, val name: String) {
    object StepMode : StepSaturationCommandField(0, "StepMode")

    object StepSize : StepSaturationCommandField(1, "StepSize")

    object TransitionTime : StepSaturationCommandField(2, "TransitionTime")

    object OptionsMask : StepSaturationCommandField(3, "OptionsMask")

    object OptionsOverride : StepSaturationCommandField(4, "OptionsOverride")

    companion object {
      fun values(): List<StepSaturationCommandField> {
        return StepSaturationCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): StepSaturationCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): StepSaturationCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class MoveToHueAndSaturationCommandField(val id: Int, val name: String) {
    object Hue : MoveToHueAndSaturationCommandField(0, "Hue")

    object Saturation : MoveToHueAndSaturationCommandField(1, "Saturation")

    object TransitionTime : MoveToHueAndSaturationCommandField(2, "TransitionTime")

    object OptionsMask : MoveToHueAndSaturationCommandField(3, "OptionsMask")

    object OptionsOverride : MoveToHueAndSaturationCommandField(4, "OptionsOverride")

    companion object {
      fun values(): List<MoveToHueAndSaturationCommandField> {
        return MoveToHueAndSaturationCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): MoveToHueAndSaturationCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): MoveToHueAndSaturationCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class MoveToColorCommandField(val id: Int, val name: String) {
    object ColorX : MoveToColorCommandField(0, "ColorX")

    object ColorY : MoveToColorCommandField(1, "ColorY")

    object TransitionTime : MoveToColorCommandField(2, "TransitionTime")

    object OptionsMask : MoveToColorCommandField(3, "OptionsMask")

    object OptionsOverride : MoveToColorCommandField(4, "OptionsOverride")

    companion object {
      fun values(): List<MoveToColorCommandField> {
        return MoveToColorCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): MoveToColorCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): MoveToColorCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class MoveColorCommandField(val id: Int, val name: String) {
    object RateX : MoveColorCommandField(0, "RateX")

    object RateY : MoveColorCommandField(1, "RateY")

    object OptionsMask : MoveColorCommandField(2, "OptionsMask")

    object OptionsOverride : MoveColorCommandField(3, "OptionsOverride")

    companion object {
      fun values(): List<MoveColorCommandField> {
        return MoveColorCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): MoveColorCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): MoveColorCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class StepColorCommandField(val id: Int, val name: String) {
    object StepX : StepColorCommandField(0, "StepX")

    object StepY : StepColorCommandField(1, "StepY")

    object TransitionTime : StepColorCommandField(2, "TransitionTime")

    object OptionsMask : StepColorCommandField(3, "OptionsMask")

    object OptionsOverride : StepColorCommandField(4, "OptionsOverride")

    companion object {
      fun values(): List<StepColorCommandField> {
        return StepColorCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): StepColorCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): StepColorCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class MoveToColorTemperatureCommandField(val id: Int, val name: String) {
    object ColorTemperatureMireds : MoveToColorTemperatureCommandField(0, "ColorTemperatureMireds")

    object TransitionTime : MoveToColorTemperatureCommandField(1, "TransitionTime")

    object OptionsMask : MoveToColorTemperatureCommandField(2, "OptionsMask")

    object OptionsOverride : MoveToColorTemperatureCommandField(3, "OptionsOverride")

    companion object {
      fun values(): List<MoveToColorTemperatureCommandField> {
        return MoveToColorTemperatureCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): MoveToColorTemperatureCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): MoveToColorTemperatureCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class EnhancedMoveToHueCommandField(val id: Int, val name: String) {
    object EnhancedHue : EnhancedMoveToHueCommandField(0, "EnhancedHue")

    object Direction : EnhancedMoveToHueCommandField(1, "Direction")

    object TransitionTime : EnhancedMoveToHueCommandField(2, "TransitionTime")

    object OptionsMask : EnhancedMoveToHueCommandField(3, "OptionsMask")

    object OptionsOverride : EnhancedMoveToHueCommandField(4, "OptionsOverride")

    companion object {
      fun values(): List<EnhancedMoveToHueCommandField> {
        return EnhancedMoveToHueCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): EnhancedMoveToHueCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): EnhancedMoveToHueCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class EnhancedMoveHueCommandField(val id: Int, val name: String) {
    object MoveMode : EnhancedMoveHueCommandField(0, "MoveMode")

    object Rate : EnhancedMoveHueCommandField(1, "Rate")

    object OptionsMask : EnhancedMoveHueCommandField(2, "OptionsMask")

    object OptionsOverride : EnhancedMoveHueCommandField(3, "OptionsOverride")

    companion object {
      fun values(): List<EnhancedMoveHueCommandField> {
        return EnhancedMoveHueCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): EnhancedMoveHueCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): EnhancedMoveHueCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class EnhancedStepHueCommandField(val id: Int, val name: String) {
    object StepMode : EnhancedStepHueCommandField(0, "StepMode")

    object StepSize : EnhancedStepHueCommandField(1, "StepSize")

    object TransitionTime : EnhancedStepHueCommandField(2, "TransitionTime")

    object OptionsMask : EnhancedStepHueCommandField(3, "OptionsMask")

    object OptionsOverride : EnhancedStepHueCommandField(4, "OptionsOverride")

    companion object {
      fun values(): List<EnhancedStepHueCommandField> {
        return EnhancedStepHueCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): EnhancedStepHueCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): EnhancedStepHueCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class EnhancedMoveToHueAndSaturationCommandField(val id: Int, val name: String) {
    object EnhancedHue : EnhancedMoveToHueAndSaturationCommandField(0, "EnhancedHue")

    object Saturation : EnhancedMoveToHueAndSaturationCommandField(1, "Saturation")

    object TransitionTime : EnhancedMoveToHueAndSaturationCommandField(2, "TransitionTime")

    object OptionsMask : EnhancedMoveToHueAndSaturationCommandField(3, "OptionsMask")

    object OptionsOverride : EnhancedMoveToHueAndSaturationCommandField(4, "OptionsOverride")

    companion object {
      fun values(): List<EnhancedMoveToHueAndSaturationCommandField> {
        return EnhancedMoveToHueAndSaturationCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): EnhancedMoveToHueAndSaturationCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): EnhancedMoveToHueAndSaturationCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class ColorLoopSetCommandField(val id: Int, val name: String) {
    object UpdateFlags : ColorLoopSetCommandField(0, "UpdateFlags")

    object Action : ColorLoopSetCommandField(1, "Action")

    object Direction : ColorLoopSetCommandField(2, "Direction")

    object Time : ColorLoopSetCommandField(3, "Time")

    object StartHue : ColorLoopSetCommandField(4, "StartHue")

    object OptionsMask : ColorLoopSetCommandField(5, "OptionsMask")

    object OptionsOverride : ColorLoopSetCommandField(6, "OptionsOverride")

    companion object {
      fun values(): List<ColorLoopSetCommandField> {
        return ColorLoopSetCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): ColorLoopSetCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): ColorLoopSetCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class StopMoveStepCommandField(val id: Int, val name: String) {
    object OptionsMask : StopMoveStepCommandField(0, "OptionsMask")

    object OptionsOverride : StopMoveStepCommandField(1, "OptionsOverride")

    companion object {
      fun values(): List<StopMoveStepCommandField> {
        return StopMoveStepCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): StopMoveStepCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): StopMoveStepCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class MoveColorTemperatureCommandField(val id: Int, val name: String) {
    object MoveMode : MoveColorTemperatureCommandField(0, "MoveMode")

    object Rate : MoveColorTemperatureCommandField(1, "Rate")

    object ColorTemperatureMinimumMireds :
      MoveColorTemperatureCommandField(2, "ColorTemperatureMinimumMireds")

    object ColorTemperatureMaximumMireds :
      MoveColorTemperatureCommandField(3, "ColorTemperatureMaximumMireds")

    object OptionsMask : MoveColorTemperatureCommandField(4, "OptionsMask")

    object OptionsOverride : MoveColorTemperatureCommandField(5, "OptionsOverride")

    companion object {
      fun values(): List<MoveColorTemperatureCommandField> {
        return MoveColorTemperatureCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): MoveColorTemperatureCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): MoveColorTemperatureCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class StepColorTemperatureCommandField(val id: Int, val name: String) {
    object StepMode : StepColorTemperatureCommandField(0, "StepMode")

    object StepSize : StepColorTemperatureCommandField(1, "StepSize")

    object TransitionTime : StepColorTemperatureCommandField(2, "TransitionTime")

    object ColorTemperatureMinimumMireds :
      StepColorTemperatureCommandField(3, "ColorTemperatureMinimumMireds")

    object ColorTemperatureMaximumMireds :
      StepColorTemperatureCommandField(4, "ColorTemperatureMaximumMireds")

    object OptionsMask : StepColorTemperatureCommandField(5, "OptionsMask")

    object OptionsOverride : StepColorTemperatureCommandField(6, "OptionsOverride")

    companion object {
      fun values(): List<StepColorTemperatureCommandField> {
        return StepColorTemperatureCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): StepColorTemperatureCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): StepColorTemperatureCommandField {
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
