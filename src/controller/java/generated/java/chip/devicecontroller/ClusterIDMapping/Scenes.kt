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

object Scenes : BaseCluster() {
  const val ID = 5L

  sealed class Attribute(val id: Long, val name: String) {
    object SceneCount : Attribute(0L, "SceneCount")

    object CurrentScene : Attribute(1L, "CurrentScene")

    object CurrentGroup : Attribute(2L, "CurrentGroup")

    object SceneValid : Attribute(3L, "SceneValid")

    object NameSupport : Attribute(4L, "NameSupport")

    object LastConfiguredBy : Attribute(5L, "LastConfiguredBy")

    object SceneTableSize : Attribute(6L, "SceneTableSize")

    object RemainingCapacity : Attribute(7L, "RemainingCapacity")

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
    object AddScene : Command(0L, "AddScene")

    object ViewScene : Command(1L, "ViewScene")

    object RemoveScene : Command(2L, "RemoveScene")

    object RemoveAllScenes : Command(3L, "RemoveAllScenes")

    object StoreScene : Command(4L, "StoreScene")

    object RecallScene : Command(5L, "RecallScene")

    object GetSceneMembership : Command(6L, "GetSceneMembership")

    object EnhancedAddScene : Command(64L, "EnhancedAddScene")

    object EnhancedViewScene : Command(65L, "EnhancedViewScene")

    object CopyScene : Command(66L, "CopyScene")

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

  sealed class AddSceneCommandField(val id: Int, val name: String) {
    object GroupID : AddSceneCommandField(0, "GroupID")

    object SceneID : AddSceneCommandField(1, "SceneID")

    object TransitionTime : AddSceneCommandField(2, "TransitionTime")

    object SceneName : AddSceneCommandField(3, "SceneName")

    object ExtensionFieldSets : AddSceneCommandField(4, "ExtensionFieldSets")

    companion object {
      fun values(): List<AddSceneCommandField> {
        return AddSceneCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): AddSceneCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): AddSceneCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class ViewSceneCommandField(val id: Int, val name: String) {
    object GroupID : ViewSceneCommandField(0, "GroupID")

    object SceneID : ViewSceneCommandField(1, "SceneID")

    companion object {
      fun values(): List<ViewSceneCommandField> {
        return ViewSceneCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): ViewSceneCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): ViewSceneCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class RemoveSceneCommandField(val id: Int, val name: String) {
    object GroupID : RemoveSceneCommandField(0, "GroupID")

    object SceneID : RemoveSceneCommandField(1, "SceneID")

    companion object {
      fun values(): List<RemoveSceneCommandField> {
        return RemoveSceneCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): RemoveSceneCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): RemoveSceneCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class RemoveAllScenesCommandField(val id: Int, val name: String) {
    object GroupID : RemoveAllScenesCommandField(0, "GroupID")

    companion object {
      fun values(): List<RemoveAllScenesCommandField> {
        return RemoveAllScenesCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): RemoveAllScenesCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): RemoveAllScenesCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class StoreSceneCommandField(val id: Int, val name: String) {
    object GroupID : StoreSceneCommandField(0, "GroupID")

    object SceneID : StoreSceneCommandField(1, "SceneID")

    companion object {
      fun values(): List<StoreSceneCommandField> {
        return StoreSceneCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): StoreSceneCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): StoreSceneCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class RecallSceneCommandField(val id: Int, val name: String) {
    object GroupID : RecallSceneCommandField(0, "GroupID")

    object SceneID : RecallSceneCommandField(1, "SceneID")

    object TransitionTime : RecallSceneCommandField(2, "TransitionTime")

    companion object {
      fun values(): List<RecallSceneCommandField> {
        return RecallSceneCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): RecallSceneCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): RecallSceneCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class GetSceneMembershipCommandField(val id: Int, val name: String) {
    object GroupID : GetSceneMembershipCommandField(0, "GroupID")

    companion object {
      fun values(): List<GetSceneMembershipCommandField> {
        return GetSceneMembershipCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): GetSceneMembershipCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): GetSceneMembershipCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class EnhancedAddSceneCommandField(val id: Int, val name: String) {
    object GroupID : EnhancedAddSceneCommandField(0, "GroupID")

    object SceneID : EnhancedAddSceneCommandField(1, "SceneID")

    object TransitionTime : EnhancedAddSceneCommandField(2, "TransitionTime")

    object SceneName : EnhancedAddSceneCommandField(3, "SceneName")

    object ExtensionFieldSets : EnhancedAddSceneCommandField(4, "ExtensionFieldSets")

    companion object {
      fun values(): List<EnhancedAddSceneCommandField> {
        return EnhancedAddSceneCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): EnhancedAddSceneCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): EnhancedAddSceneCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class EnhancedViewSceneCommandField(val id: Int, val name: String) {
    object GroupID : EnhancedViewSceneCommandField(0, "GroupID")

    object SceneID : EnhancedViewSceneCommandField(1, "SceneID")

    companion object {
      fun values(): List<EnhancedViewSceneCommandField> {
        return EnhancedViewSceneCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): EnhancedViewSceneCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): EnhancedViewSceneCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class CopySceneCommandField(val id: Int, val name: String) {
    object Mode : CopySceneCommandField(0, "Mode")

    object GroupIdentifierFrom : CopySceneCommandField(1, "GroupIdentifierFrom")

    object SceneIdentifierFrom : CopySceneCommandField(2, "SceneIdentifierFrom")

    object GroupIdentifierTo : CopySceneCommandField(3, "GroupIdentifierTo")

    object SceneIdentifierTo : CopySceneCommandField(4, "SceneIdentifierTo")

    companion object {
      fun values(): List<CopySceneCommandField> {
        return CopySceneCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): CopySceneCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): CopySceneCommandField {
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
