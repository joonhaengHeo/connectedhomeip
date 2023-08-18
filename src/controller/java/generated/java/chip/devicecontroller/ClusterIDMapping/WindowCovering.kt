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

object WindowCovering : BaseCluster() {
  const val ID = 258L

  sealed class Attribute(val id: Long, val name: String) {
    object Type : Attribute(0L, "Type")

    object PhysicalClosedLimitLift : Attribute(1L, "PhysicalClosedLimitLift")

    object PhysicalClosedLimitTilt : Attribute(2L, "PhysicalClosedLimitTilt")

    object CurrentPositionLift : Attribute(3L, "CurrentPositionLift")

    object CurrentPositionTilt : Attribute(4L, "CurrentPositionTilt")

    object NumberOfActuationsLift : Attribute(5L, "NumberOfActuationsLift")

    object NumberOfActuationsTilt : Attribute(6L, "NumberOfActuationsTilt")

    object ConfigStatus : Attribute(7L, "ConfigStatus")

    object CurrentPositionLiftPercentage : Attribute(8L, "CurrentPositionLiftPercentage")

    object CurrentPositionTiltPercentage : Attribute(9L, "CurrentPositionTiltPercentage")

    object OperationalStatus : Attribute(10L, "OperationalStatus")

    object TargetPositionLiftPercent100ths : Attribute(11L, "TargetPositionLiftPercent100ths")

    object TargetPositionTiltPercent100ths : Attribute(12L, "TargetPositionTiltPercent100ths")

    object EndProductType : Attribute(13L, "EndProductType")

    object CurrentPositionLiftPercent100ths : Attribute(14L, "CurrentPositionLiftPercent100ths")

    object CurrentPositionTiltPercent100ths : Attribute(15L, "CurrentPositionTiltPercent100ths")

    object InstalledOpenLimitLift : Attribute(16L, "InstalledOpenLimitLift")

    object InstalledClosedLimitLift : Attribute(17L, "InstalledClosedLimitLift")

    object InstalledOpenLimitTilt : Attribute(18L, "InstalledOpenLimitTilt")

    object InstalledClosedLimitTilt : Attribute(19L, "InstalledClosedLimitTilt")

    object Mode : Attribute(23L, "Mode")

    object SafetyStatus : Attribute(26L, "SafetyStatus")

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
    object UpOrOpen : Command(0L, "UpOrOpen")

    object DownOrClose : Command(1L, "DownOrClose")

    object StopMotion : Command(2L, "StopMotion")

    object GoToLiftValue : Command(4L, "GoToLiftValue")

    object GoToLiftPercentage : Command(5L, "GoToLiftPercentage")

    object GoToTiltValue : Command(7L, "GoToTiltValue")

    object GoToTiltPercentage : Command(8L, "GoToTiltPercentage")

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

  sealed class GoToLiftValueCommandField(val id: Int, val name: String) {
    object LiftValue : GoToLiftValueCommandField(0, "LiftValue")

    companion object {
      fun values(): List<GoToLiftValueCommandField> {
        return GoToLiftValueCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): GoToLiftValueCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): GoToLiftValueCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class GoToLiftPercentageCommandField(val id: Int, val name: String) {
    object LiftPercent100thsValue : GoToLiftPercentageCommandField(0, "LiftPercent100thsValue")

    companion object {
      fun values(): List<GoToLiftPercentageCommandField> {
        return GoToLiftPercentageCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): GoToLiftPercentageCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): GoToLiftPercentageCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class GoToTiltValueCommandField(val id: Int, val name: String) {
    object TiltValue : GoToTiltValueCommandField(0, "TiltValue")

    companion object {
      fun values(): List<GoToTiltValueCommandField> {
        return GoToTiltValueCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): GoToTiltValueCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): GoToTiltValueCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class GoToTiltPercentageCommandField(val id: Int, val name: String) {
    object TiltPercent100thsValue : GoToTiltPercentageCommandField(0, "TiltPercent100thsValue")

    companion object {
      fun values(): List<GoToTiltPercentageCommandField> {
        return GoToTiltPercentageCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): GoToTiltPercentageCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): GoToTiltPercentageCommandField {
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
