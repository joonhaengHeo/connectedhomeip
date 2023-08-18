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

object Actions : BaseCluster() {
  const val ID = 37L

  sealed class Attribute(val id: Long, val name: String) {
    object ActionList : Attribute(0L, "ActionList")

    object EndpointLists : Attribute(1L, "EndpointLists")

    object SetupURL : Attribute(2L, "SetupURL")

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
    object StateChanged : Event(0L, "StateChanged")

    object ActionFailed : Event(1L, "ActionFailed")

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
    object InstantAction : Command(0L, "InstantAction")

    object InstantActionWithTransition : Command(1L, "InstantActionWithTransition")

    object StartAction : Command(2L, "StartAction")

    object StartActionWithDuration : Command(3L, "StartActionWithDuration")

    object StopAction : Command(4L, "StopAction")

    object PauseAction : Command(5L, "PauseAction")

    object PauseActionWithDuration : Command(6L, "PauseActionWithDuration")

    object ResumeAction : Command(7L, "ResumeAction")

    object EnableAction : Command(8L, "EnableAction")

    object EnableActionWithDuration : Command(9L, "EnableActionWithDuration")

    object DisableAction : Command(10L, "DisableAction")

    object DisableActionWithDuration : Command(11L, "DisableActionWithDuration")

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

  sealed class InstantActionCommandField(val id: Int, val name: String) {
    object ActionID : InstantActionCommandField(0, "ActionID")

    object InvokeID : InstantActionCommandField(1, "InvokeID")

    companion object {
      fun values(): List<InstantActionCommandField> {
        return InstantActionCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): InstantActionCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): InstantActionCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class InstantActionWithTransitionCommandField(val id: Int, val name: String) {
    object ActionID : InstantActionWithTransitionCommandField(0, "ActionID")

    object InvokeID : InstantActionWithTransitionCommandField(1, "InvokeID")

    object TransitionTime : InstantActionWithTransitionCommandField(2, "TransitionTime")

    companion object {
      fun values(): List<InstantActionWithTransitionCommandField> {
        return InstantActionWithTransitionCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): InstantActionWithTransitionCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): InstantActionWithTransitionCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class StartActionCommandField(val id: Int, val name: String) {
    object ActionID : StartActionCommandField(0, "ActionID")

    object InvokeID : StartActionCommandField(1, "InvokeID")

    companion object {
      fun values(): List<StartActionCommandField> {
        return StartActionCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): StartActionCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): StartActionCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class StartActionWithDurationCommandField(val id: Int, val name: String) {
    object ActionID : StartActionWithDurationCommandField(0, "ActionID")

    object InvokeID : StartActionWithDurationCommandField(1, "InvokeID")

    object Duration : StartActionWithDurationCommandField(2, "Duration")

    companion object {
      fun values(): List<StartActionWithDurationCommandField> {
        return StartActionWithDurationCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): StartActionWithDurationCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): StartActionWithDurationCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class StopActionCommandField(val id: Int, val name: String) {
    object ActionID : StopActionCommandField(0, "ActionID")

    object InvokeID : StopActionCommandField(1, "InvokeID")

    companion object {
      fun values(): List<StopActionCommandField> {
        return StopActionCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): StopActionCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): StopActionCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class PauseActionCommandField(val id: Int, val name: String) {
    object ActionID : PauseActionCommandField(0, "ActionID")

    object InvokeID : PauseActionCommandField(1, "InvokeID")

    companion object {
      fun values(): List<PauseActionCommandField> {
        return PauseActionCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): PauseActionCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): PauseActionCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class PauseActionWithDurationCommandField(val id: Int, val name: String) {
    object ActionID : PauseActionWithDurationCommandField(0, "ActionID")

    object InvokeID : PauseActionWithDurationCommandField(1, "InvokeID")

    object Duration : PauseActionWithDurationCommandField(2, "Duration")

    companion object {
      fun values(): List<PauseActionWithDurationCommandField> {
        return PauseActionWithDurationCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): PauseActionWithDurationCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): PauseActionWithDurationCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class ResumeActionCommandField(val id: Int, val name: String) {
    object ActionID : ResumeActionCommandField(0, "ActionID")

    object InvokeID : ResumeActionCommandField(1, "InvokeID")

    companion object {
      fun values(): List<ResumeActionCommandField> {
        return ResumeActionCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): ResumeActionCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): ResumeActionCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class EnableActionCommandField(val id: Int, val name: String) {
    object ActionID : EnableActionCommandField(0, "ActionID")

    object InvokeID : EnableActionCommandField(1, "InvokeID")

    companion object {
      fun values(): List<EnableActionCommandField> {
        return EnableActionCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): EnableActionCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): EnableActionCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class EnableActionWithDurationCommandField(val id: Int, val name: String) {
    object ActionID : EnableActionWithDurationCommandField(0, "ActionID")

    object InvokeID : EnableActionWithDurationCommandField(1, "InvokeID")

    object Duration : EnableActionWithDurationCommandField(2, "Duration")

    companion object {
      fun values(): List<EnableActionWithDurationCommandField> {
        return EnableActionWithDurationCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): EnableActionWithDurationCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): EnableActionWithDurationCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class DisableActionCommandField(val id: Int, val name: String) {
    object ActionID : DisableActionCommandField(0, "ActionID")

    object InvokeID : DisableActionCommandField(1, "InvokeID")

    companion object {
      fun values(): List<DisableActionCommandField> {
        return DisableActionCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): DisableActionCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): DisableActionCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class DisableActionWithDurationCommandField(val id: Int, val name: String) {
    object ActionID : DisableActionWithDurationCommandField(0, "ActionID")

    object InvokeID : DisableActionWithDurationCommandField(1, "InvokeID")

    object Duration : DisableActionWithDurationCommandField(2, "Duration")

    companion object {
      fun values(): List<DisableActionWithDurationCommandField> {
        return DisableActionWithDurationCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): DisableActionWithDurationCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): DisableActionWithDurationCommandField {
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
