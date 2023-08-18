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

object MediaPlayback : BaseCluster() {
  const val ID = 1286L

  sealed class Attribute(val id: Long, val name: String) {
    object CurrentState : Attribute(0L, "CurrentState")

    object StartTime : Attribute(1L, "StartTime")

    object Duration : Attribute(2L, "Duration")

    object SampledPosition : Attribute(3L, "SampledPosition")

    object PlaybackSpeed : Attribute(4L, "PlaybackSpeed")

    object SeekRangeEnd : Attribute(5L, "SeekRangeEnd")

    object SeekRangeStart : Attribute(6L, "SeekRangeStart")

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
    object Play : Command(0L, "Play")

    object Pause : Command(1L, "Pause")

    object Stop : Command(2L, "Stop")

    object StartOver : Command(3L, "StartOver")

    object Previous : Command(4L, "Previous")

    object Next : Command(5L, "Next")

    object Rewind : Command(6L, "Rewind")

    object FastForward : Command(7L, "FastForward")

    object SkipForward : Command(8L, "SkipForward")

    object SkipBackward : Command(9L, "SkipBackward")

    object Seek : Command(11L, "Seek")

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

  sealed class SkipForwardCommandField(val id: Int, val name: String) {
    object DeltaPositionMilliseconds : SkipForwardCommandField(0, "DeltaPositionMilliseconds")

    companion object {
      fun values(): List<SkipForwardCommandField> {
        return SkipForwardCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): SkipForwardCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): SkipForwardCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class SkipBackwardCommandField(val id: Int, val name: String) {
    object DeltaPositionMilliseconds : SkipBackwardCommandField(0, "DeltaPositionMilliseconds")

    companion object {
      fun values(): List<SkipBackwardCommandField> {
        return SkipBackwardCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): SkipBackwardCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): SkipBackwardCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class SeekCommandField(val id: Int, val name: String) {
    object Position : SeekCommandField(0, "Position")

    companion object {
      fun values(): List<SeekCommandField> {
        return SeekCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): SeekCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): SeekCommandField {
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
