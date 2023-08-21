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
package chip.devicecontroller

sealed class ClusterIDMapping {
  object Identify : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object IdentifyTime : Attribute(0L, "IdentifyTime")

      object IdentifyType : Attribute(1L, "IdentifyType")

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

    enum class Command(val id: Long) {
      Identify(0L),
      TriggerEffect(64L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class IdentifyCommandField(val id: Int) {
      IdentifyTime(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): IdentifyCommandField {
          for (field in IdentifyCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TriggerEffectCommandField(val id: Int) {
      EffectIdentifier(0),
      EffectVariant(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TriggerEffectCommandField {
          for (field in TriggerEffectCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 3L
  }

  object Groups : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object NameSupport : Attribute(0L, "NameSupport")

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

    enum class Command(val id: Long) {
      AddGroup(0L),
      ViewGroup(1L),
      GetGroupMembership(2L),
      RemoveGroup(3L),
      RemoveAllGroups(4L),
      AddGroupIfIdentifying(5L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class AddGroupCommandField(val id: Int) {
      GroupID(0),
      GroupName(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): AddGroupCommandField {
          for (field in AddGroupCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ViewGroupCommandField(val id: Int) {
      GroupID(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ViewGroupCommandField {
          for (field in ViewGroupCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class GetGroupMembershipCommandField(val id: Int) {
      GroupList(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): GetGroupMembershipCommandField {
          for (field in GetGroupMembershipCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class RemoveGroupCommandField(val id: Int) {
      GroupID(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): RemoveGroupCommandField {
          for (field in RemoveGroupCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class AddGroupIfIdentifyingCommandField(val id: Int) {
      GroupID(0),
      GroupName(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): AddGroupIfIdentifyingCommandField {
          for (field in AddGroupIfIdentifyingCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 4L
  }

  object Scenes : ClusterIDMapping() {
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

    enum class Command(val id: Long) {
      AddScene(0L),
      ViewScene(1L),
      RemoveScene(2L),
      RemoveAllScenes(3L),
      StoreScene(4L),
      RecallScene(5L),
      GetSceneMembership(6L),
      EnhancedAddScene(64L),
      EnhancedViewScene(65L),
      CopyScene(66L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class AddSceneCommandField(val id: Int) {
      GroupID(0),
      SceneID(1),
      TransitionTime(2),
      SceneName(3),
      ExtensionFieldSets(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): AddSceneCommandField {
          for (field in AddSceneCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ViewSceneCommandField(val id: Int) {
      GroupID(0),
      SceneID(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ViewSceneCommandField {
          for (field in ViewSceneCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class RemoveSceneCommandField(val id: Int) {
      GroupID(0),
      SceneID(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): RemoveSceneCommandField {
          for (field in RemoveSceneCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class RemoveAllScenesCommandField(val id: Int) {
      GroupID(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): RemoveAllScenesCommandField {
          for (field in RemoveAllScenesCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class StoreSceneCommandField(val id: Int) {
      GroupID(0),
      SceneID(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): StoreSceneCommandField {
          for (field in StoreSceneCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class RecallSceneCommandField(val id: Int) {
      GroupID(0),
      SceneID(1),
      TransitionTime(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): RecallSceneCommandField {
          for (field in RecallSceneCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class GetSceneMembershipCommandField(val id: Int) {
      GroupID(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): GetSceneMembershipCommandField {
          for (field in GetSceneMembershipCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class EnhancedAddSceneCommandField(val id: Int) {
      GroupID(0),
      SceneID(1),
      TransitionTime(2),
      SceneName(3),
      ExtensionFieldSets(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): EnhancedAddSceneCommandField {
          for (field in EnhancedAddSceneCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class EnhancedViewSceneCommandField(val id: Int) {
      GroupID(0),
      SceneID(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): EnhancedViewSceneCommandField {
          for (field in EnhancedViewSceneCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class CopySceneCommandField(val id: Int) {
      Mode(0),
      GroupIdentifierFrom(1),
      SceneIdentifierFrom(2),
      GroupIdentifierTo(3),
      SceneIdentifierTo(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): CopySceneCommandField {
          for (field in CopySceneCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 5L
  }

  object OnOff : ClusterIDMapping() {
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

    enum class Command(val id: Long) {
      Off(0L),
      On(1L),
      Toggle(2L),
      OffWithEffect(64L),
      OnWithRecallGlobalScene(65L),
      OnWithTimedOff(66L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class OffWithEffectCommandField(val id: Int) {
      EffectIdentifier(0),
      EffectVariant(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): OffWithEffectCommandField {
          for (field in OffWithEffectCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class OnWithTimedOffCommandField(val id: Int) {
      OnOffControl(0),
      OnTime(1),
      OffWaitTime(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): OnWithTimedOffCommandField {
          for (field in OnWithTimedOffCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 6L
  }

  object OnOffSwitchConfiguration : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object SwitchType : Attribute(0L, "SwitchType")

      object SwitchActions : Attribute(16L, "SwitchActions")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 7L
  }

  object LevelControl : ClusterIDMapping() {
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

    enum class Command(val id: Long) {
      MoveToLevel(0L),
      Move(1L),
      Step(2L),
      Stop(3L),
      MoveToLevelWithOnOff(4L),
      MoveWithOnOff(5L),
      StepWithOnOff(6L),
      StopWithOnOff(7L),
      MoveToClosestFrequency(8L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class MoveToLevelCommandField(val id: Int) {
      Level(0),
      TransitionTime(1),
      OptionsMask(2),
      OptionsOverride(3);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): MoveToLevelCommandField {
          for (field in MoveToLevelCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class MoveCommandField(val id: Int) {
      MoveMode(0),
      Rate(1),
      OptionsMask(2),
      OptionsOverride(3);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): MoveCommandField {
          for (field in MoveCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class StepCommandField(val id: Int) {
      StepMode(0),
      StepSize(1),
      TransitionTime(2),
      OptionsMask(3),
      OptionsOverride(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): StepCommandField {
          for (field in StepCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class StopCommandField(val id: Int) {
      OptionsMask(0),
      OptionsOverride(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): StopCommandField {
          for (field in StopCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class MoveToLevelWithOnOffCommandField(val id: Int) {
      Level(0),
      TransitionTime(1),
      OptionsMask(2),
      OptionsOverride(3);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): MoveToLevelWithOnOffCommandField {
          for (field in MoveToLevelWithOnOffCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class MoveWithOnOffCommandField(val id: Int) {
      MoveMode(0),
      Rate(1),
      OptionsMask(2),
      OptionsOverride(3);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): MoveWithOnOffCommandField {
          for (field in MoveWithOnOffCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class StepWithOnOffCommandField(val id: Int) {
      StepMode(0),
      StepSize(1),
      TransitionTime(2),
      OptionsMask(3),
      OptionsOverride(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): StepWithOnOffCommandField {
          for (field in StepWithOnOffCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class StopWithOnOffCommandField(val id: Int) {
      OptionsMask(0),
      OptionsOverride(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): StopWithOnOffCommandField {
          for (field in StopWithOnOffCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class MoveToClosestFrequencyCommandField(val id: Int) {
      Frequency(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): MoveToClosestFrequencyCommandField {
          for (field in MoveToClosestFrequencyCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 8L
  }

  object BinaryInputBasic : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object ActiveText : Attribute(4L, "ActiveText")

      object Description : Attribute(28L, "Description")

      object InactiveText : Attribute(46L, "InactiveText")

      object OutOfService : Attribute(81L, "OutOfService")

      object Polarity : Attribute(84L, "Polarity")

      object PresentValue : Attribute(85L, "PresentValue")

      object Reliability : Attribute(103L, "Reliability")

      object StatusFlags : Attribute(111L, "StatusFlags")

      object ApplicationType : Attribute(256L, "ApplicationType")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 15L
  }

  object PulseWidthModulation : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 28L
  }

  object Descriptor : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object DeviceTypeList : Attribute(0L, "DeviceTypeList")

      object ServerList : Attribute(1L, "ServerList")

      object ClientList : Attribute(2L, "ClientList")

      object PartsList : Attribute(3L, "PartsList")

      object TagList : Attribute(4L, "TagList")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 29L
  }

  object Binding : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object Binding : Attribute(0L, "Binding")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 30L
  }

  object AccessControl : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object Acl : Attribute(0L, "Acl")

      object Extension : Attribute(1L, "Extension")

      object SubjectsPerAccessControlEntry : Attribute(2L, "SubjectsPerAccessControlEntry")

      object TargetsPerAccessControlEntry : Attribute(3L, "TargetsPerAccessControlEntry")

      object AccessControlEntriesPerFabric : Attribute(4L, "AccessControlEntriesPerFabric")

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

    enum class Event(val id: Long) {
      AccessControlEntryChanged(0L),
      AccessControlExtensionChanged(1L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
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

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      return Event.valueOf(name).id
    }

    const val ID = 31L
  }

  object Actions : ClusterIDMapping() {
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

    enum class Event(val id: Long) {
      StateChanged(0L),
      ActionFailed(1L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class Command(val id: Long) {
      InstantAction(0L),
      InstantActionWithTransition(1L),
      StartAction(2L),
      StartActionWithDuration(3L),
      StopAction(4L),
      PauseAction(5L),
      PauseActionWithDuration(6L),
      ResumeAction(7L),
      EnableAction(8L),
      EnableActionWithDuration(9L),
      DisableAction(10L),
      DisableActionWithDuration(11L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class InstantActionCommandField(val id: Int) {
      ActionID(0),
      InvokeID(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): InstantActionCommandField {
          for (field in InstantActionCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class InstantActionWithTransitionCommandField(val id: Int) {
      ActionID(0),
      InvokeID(1),
      TransitionTime(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): InstantActionWithTransitionCommandField {
          for (field in InstantActionWithTransitionCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class StartActionCommandField(val id: Int) {
      ActionID(0),
      InvokeID(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): StartActionCommandField {
          for (field in StartActionCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class StartActionWithDurationCommandField(val id: Int) {
      ActionID(0),
      InvokeID(1),
      Duration(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): StartActionWithDurationCommandField {
          for (field in StartActionWithDurationCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class StopActionCommandField(val id: Int) {
      ActionID(0),
      InvokeID(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): StopActionCommandField {
          for (field in StopActionCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class PauseActionCommandField(val id: Int) {
      ActionID(0),
      InvokeID(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): PauseActionCommandField {
          for (field in PauseActionCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class PauseActionWithDurationCommandField(val id: Int) {
      ActionID(0),
      InvokeID(1),
      Duration(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): PauseActionWithDurationCommandField {
          for (field in PauseActionWithDurationCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ResumeActionCommandField(val id: Int) {
      ActionID(0),
      InvokeID(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ResumeActionCommandField {
          for (field in ResumeActionCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class EnableActionCommandField(val id: Int) {
      ActionID(0),
      InvokeID(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): EnableActionCommandField {
          for (field in EnableActionCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class EnableActionWithDurationCommandField(val id: Int) {
      ActionID(0),
      InvokeID(1),
      Duration(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): EnableActionWithDurationCommandField {
          for (field in EnableActionWithDurationCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class DisableActionCommandField(val id: Int) {
      ActionID(0),
      InvokeID(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): DisableActionCommandField {
          for (field in DisableActionCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class DisableActionWithDurationCommandField(val id: Int) {
      ActionID(0),
      InvokeID(1),
      Duration(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): DisableActionWithDurationCommandField {
          for (field in DisableActionWithDurationCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 37L
  }

  object BasicInformation : ClusterIDMapping() {
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

    enum class Event(val id: Long) {
      StartUp(0L),
      ShutDown(1L),
      Leave(2L),
      ReachableChanged(3L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class Command(val id: Long) {
      MfgSpecificPing(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 40L
  }

  object OtaSoftwareUpdateProvider : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
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

    enum class Command(val id: Long) {
      QueryImage(0L),
      ApplyUpdateRequest(2L),
      NotifyUpdateApplied(4L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class QueryImageCommandField(val id: Int) {
      VendorID(0),
      ProductID(1),
      SoftwareVersion(2),
      ProtocolsSupported(3),
      HardwareVersion(4),
      Location(5),
      RequestorCanConsent(6),
      MetadataForProvider(7);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): QueryImageCommandField {
          for (field in QueryImageCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ApplyUpdateRequestCommandField(val id: Int) {
      UpdateToken(0),
      NewVersion(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ApplyUpdateRequestCommandField {
          for (field in ApplyUpdateRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class NotifyUpdateAppliedCommandField(val id: Int) {
      UpdateToken(0),
      SoftwareVersion(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): NotifyUpdateAppliedCommandField {
          for (field in NotifyUpdateAppliedCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 41L
  }

  object OtaSoftwareUpdateRequestor : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object DefaultOTAProviders : Attribute(0L, "DefaultOTAProviders")

      object UpdatePossible : Attribute(1L, "UpdatePossible")

      object UpdateState : Attribute(2L, "UpdateState")

      object UpdateStateProgress : Attribute(3L, "UpdateStateProgress")

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

    enum class Event(val id: Long) {
      StateTransition(0L),
      VersionApplied(1L),
      DownloadError(2L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class Command(val id: Long) {
      AnnounceOTAProvider(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class AnnounceOTAProviderCommandField(val id: Int) {
      ProviderNodeID(0),
      VendorID(1),
      AnnouncementReason(2),
      MetadataForNode(3),
      Endpoint(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): AnnounceOTAProviderCommandField {
          for (field in AnnounceOTAProviderCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 42L
  }

  object LocalizationConfiguration : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object ActiveLocale : Attribute(0L, "ActiveLocale")

      object SupportedLocales : Attribute(1L, "SupportedLocales")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 43L
  }

  object TimeFormatLocalization : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object HourFormat : Attribute(0L, "HourFormat")

      object ActiveCalendarType : Attribute(1L, "ActiveCalendarType")

      object SupportedCalendarTypes : Attribute(2L, "SupportedCalendarTypes")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 44L
  }

  object UnitLocalization : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object TemperatureUnit : Attribute(0L, "TemperatureUnit")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 45L
  }

  object PowerSourceConfiguration : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object Sources : Attribute(0L, "Sources")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 46L
  }

  object PowerSource : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object Status : Attribute(0L, "Status")

      object Order : Attribute(1L, "Order")

      object Description : Attribute(2L, "Description")

      object WiredAssessedInputVoltage : Attribute(3L, "WiredAssessedInputVoltage")

      object WiredAssessedInputFrequency : Attribute(4L, "WiredAssessedInputFrequency")

      object WiredCurrentType : Attribute(5L, "WiredCurrentType")

      object WiredAssessedCurrent : Attribute(6L, "WiredAssessedCurrent")

      object WiredNominalVoltage : Attribute(7L, "WiredNominalVoltage")

      object WiredMaximumCurrent : Attribute(8L, "WiredMaximumCurrent")

      object WiredPresent : Attribute(9L, "WiredPresent")

      object ActiveWiredFaults : Attribute(10L, "ActiveWiredFaults")

      object BatVoltage : Attribute(11L, "BatVoltage")

      object BatPercentRemaining : Attribute(12L, "BatPercentRemaining")

      object BatTimeRemaining : Attribute(13L, "BatTimeRemaining")

      object BatChargeLevel : Attribute(14L, "BatChargeLevel")

      object BatReplacementNeeded : Attribute(15L, "BatReplacementNeeded")

      object BatReplaceability : Attribute(16L, "BatReplaceability")

      object BatPresent : Attribute(17L, "BatPresent")

      object ActiveBatFaults : Attribute(18L, "ActiveBatFaults")

      object BatReplacementDescription : Attribute(19L, "BatReplacementDescription")

      object BatCommonDesignation : Attribute(20L, "BatCommonDesignation")

      object BatANSIDesignation : Attribute(21L, "BatANSIDesignation")

      object BatIECDesignation : Attribute(22L, "BatIECDesignation")

      object BatApprovedChemistry : Attribute(23L, "BatApprovedChemistry")

      object BatCapacity : Attribute(24L, "BatCapacity")

      object BatQuantity : Attribute(25L, "BatQuantity")

      object BatChargeState : Attribute(26L, "BatChargeState")

      object BatTimeToFullCharge : Attribute(27L, "BatTimeToFullCharge")

      object BatFunctionalWhileCharging : Attribute(28L, "BatFunctionalWhileCharging")

      object BatChargingCurrent : Attribute(29L, "BatChargingCurrent")

      object ActiveBatChargeFaults : Attribute(30L, "ActiveBatChargeFaults")

      object EndpointList : Attribute(31L, "EndpointList")

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

    enum class Event(val id: Long) {
      WiredFaultChange(0L),
      BatFaultChange(1L),
      BatChargeFaultChange(2L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
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

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      return Event.valueOf(name).id
    }

    const val ID = 47L
  }

  object GeneralCommissioning : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object Breadcrumb : Attribute(0L, "Breadcrumb")

      object BasicCommissioningInfo : Attribute(1L, "BasicCommissioningInfo")

      object RegulatoryConfig : Attribute(2L, "RegulatoryConfig")

      object LocationCapability : Attribute(3L, "LocationCapability")

      object SupportsConcurrentConnection : Attribute(4L, "SupportsConcurrentConnection")

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

    enum class Command(val id: Long) {
      ArmFailSafe(0L),
      SetRegulatoryConfig(2L),
      CommissioningComplete(4L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ArmFailSafeCommandField(val id: Int) {
      ExpiryLengthSeconds(0),
      Breadcrumb(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ArmFailSafeCommandField {
          for (field in ArmFailSafeCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SetRegulatoryConfigCommandField(val id: Int) {
      NewRegulatoryConfig(0),
      CountryCode(1),
      Breadcrumb(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SetRegulatoryConfigCommandField {
          for (field in SetRegulatoryConfigCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 48L
  }

  object NetworkCommissioning : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MaxNetworks : Attribute(0L, "MaxNetworks")

      object Networks : Attribute(1L, "Networks")

      object ScanMaxTimeSeconds : Attribute(2L, "ScanMaxTimeSeconds")

      object ConnectMaxTimeSeconds : Attribute(3L, "ConnectMaxTimeSeconds")

      object InterfaceEnabled : Attribute(4L, "InterfaceEnabled")

      object LastNetworkingStatus : Attribute(5L, "LastNetworkingStatus")

      object LastNetworkID : Attribute(6L, "LastNetworkID")

      object LastConnectErrorValue : Attribute(7L, "LastConnectErrorValue")

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

    enum class Command(val id: Long) {
      ScanNetworks(0L),
      AddOrUpdateWiFiNetwork(2L),
      AddOrUpdateThreadNetwork(3L),
      RemoveNetwork(4L),
      ConnectNetwork(6L),
      ReorderNetwork(8L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ScanNetworksCommandField(val id: Int) {
      Ssid(0),
      Breadcrumb(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ScanNetworksCommandField {
          for (field in ScanNetworksCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class AddOrUpdateWiFiNetworkCommandField(val id: Int) {
      Ssid(0),
      Credentials(1),
      Breadcrumb(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): AddOrUpdateWiFiNetworkCommandField {
          for (field in AddOrUpdateWiFiNetworkCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class AddOrUpdateThreadNetworkCommandField(val id: Int) {
      OperationalDataset(0),
      Breadcrumb(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): AddOrUpdateThreadNetworkCommandField {
          for (field in AddOrUpdateThreadNetworkCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class RemoveNetworkCommandField(val id: Int) {
      NetworkID(0),
      Breadcrumb(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): RemoveNetworkCommandField {
          for (field in RemoveNetworkCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ConnectNetworkCommandField(val id: Int) {
      NetworkID(0),
      Breadcrumb(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ConnectNetworkCommandField {
          for (field in ConnectNetworkCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ReorderNetworkCommandField(val id: Int) {
      NetworkID(0),
      NetworkIndex(1),
      Breadcrumb(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ReorderNetworkCommandField {
          for (field in ReorderNetworkCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 49L
  }

  object DiagnosticLogs : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
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

    enum class Command(val id: Long) {
      RetrieveLogsRequest(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class RetrieveLogsRequestCommandField(val id: Int) {
      Intent(0),
      RequestedProtocol(1),
      TransferFileDesignator(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): RetrieveLogsRequestCommandField {
          for (field in RetrieveLogsRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 50L
  }

  object GeneralDiagnostics : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object NetworkInterfaces : Attribute(0L, "NetworkInterfaces")

      object RebootCount : Attribute(1L, "RebootCount")

      object UpTime : Attribute(2L, "UpTime")

      object TotalOperationalHours : Attribute(3L, "TotalOperationalHours")

      object BootReason : Attribute(4L, "BootReason")

      object ActiveHardwareFaults : Attribute(5L, "ActiveHardwareFaults")

      object ActiveRadioFaults : Attribute(6L, "ActiveRadioFaults")

      object ActiveNetworkFaults : Attribute(7L, "ActiveNetworkFaults")

      object TestEventTriggersEnabled : Attribute(8L, "TestEventTriggersEnabled")

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

    enum class Event(val id: Long) {
      HardwareFaultChange(0L),
      RadioFaultChange(1L),
      NetworkFaultChange(2L),
      BootReason(3L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class Command(val id: Long) {
      TestEventTrigger(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TestEventTriggerCommandField(val id: Int) {
      EnableKey(0),
      EventTrigger(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TestEventTriggerCommandField {
          for (field in TestEventTriggerCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 51L
  }

  object SoftwareDiagnostics : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object ThreadMetrics : Attribute(0L, "ThreadMetrics")

      object CurrentHeapFree : Attribute(1L, "CurrentHeapFree")

      object CurrentHeapUsed : Attribute(2L, "CurrentHeapUsed")

      object CurrentHeapHighWatermark : Attribute(3L, "CurrentHeapHighWatermark")

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

    enum class Event(val id: Long) {
      SoftwareFault(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class Command(val id: Long) {
      ResetWatermarks(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 52L
  }

  object ThreadNetworkDiagnostics : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object Channel : Attribute(0L, "Channel")

      object RoutingRole : Attribute(1L, "RoutingRole")

      object NetworkName : Attribute(2L, "NetworkName")

      object PanId : Attribute(3L, "PanId")

      object ExtendedPanId : Attribute(4L, "ExtendedPanId")

      object MeshLocalPrefix : Attribute(5L, "MeshLocalPrefix")

      object OverrunCount : Attribute(6L, "OverrunCount")

      object NeighborTable : Attribute(7L, "NeighborTable")

      object RouteTable : Attribute(8L, "RouteTable")

      object PartitionId : Attribute(9L, "PartitionId")

      object Weighting : Attribute(10L, "Weighting")

      object DataVersion : Attribute(11L, "DataVersion")

      object StableDataVersion : Attribute(12L, "StableDataVersion")

      object LeaderRouterId : Attribute(13L, "LeaderRouterId")

      object DetachedRoleCount : Attribute(14L, "DetachedRoleCount")

      object ChildRoleCount : Attribute(15L, "ChildRoleCount")

      object RouterRoleCount : Attribute(16L, "RouterRoleCount")

      object LeaderRoleCount : Attribute(17L, "LeaderRoleCount")

      object AttachAttemptCount : Attribute(18L, "AttachAttemptCount")

      object PartitionIdChangeCount : Attribute(19L, "PartitionIdChangeCount")

      object BetterPartitionAttachAttemptCount :
        Attribute(20L, "BetterPartitionAttachAttemptCount")

      object ParentChangeCount : Attribute(21L, "ParentChangeCount")

      object TxTotalCount : Attribute(22L, "TxTotalCount")

      object TxUnicastCount : Attribute(23L, "TxUnicastCount")

      object TxBroadcastCount : Attribute(24L, "TxBroadcastCount")

      object TxAckRequestedCount : Attribute(25L, "TxAckRequestedCount")

      object TxAckedCount : Attribute(26L, "TxAckedCount")

      object TxNoAckRequestedCount : Attribute(27L, "TxNoAckRequestedCount")

      object TxDataCount : Attribute(28L, "TxDataCount")

      object TxDataPollCount : Attribute(29L, "TxDataPollCount")

      object TxBeaconCount : Attribute(30L, "TxBeaconCount")

      object TxBeaconRequestCount : Attribute(31L, "TxBeaconRequestCount")

      object TxOtherCount : Attribute(32L, "TxOtherCount")

      object TxRetryCount : Attribute(33L, "TxRetryCount")

      object TxDirectMaxRetryExpiryCount : Attribute(34L, "TxDirectMaxRetryExpiryCount")

      object TxIndirectMaxRetryExpiryCount : Attribute(35L, "TxIndirectMaxRetryExpiryCount")

      object TxErrCcaCount : Attribute(36L, "TxErrCcaCount")

      object TxErrAbortCount : Attribute(37L, "TxErrAbortCount")

      object TxErrBusyChannelCount : Attribute(38L, "TxErrBusyChannelCount")

      object RxTotalCount : Attribute(39L, "RxTotalCount")

      object RxUnicastCount : Attribute(40L, "RxUnicastCount")

      object RxBroadcastCount : Attribute(41L, "RxBroadcastCount")

      object RxDataCount : Attribute(42L, "RxDataCount")

      object RxDataPollCount : Attribute(43L, "RxDataPollCount")

      object RxBeaconCount : Attribute(44L, "RxBeaconCount")

      object RxBeaconRequestCount : Attribute(45L, "RxBeaconRequestCount")

      object RxOtherCount : Attribute(46L, "RxOtherCount")

      object RxAddressFilteredCount : Attribute(47L, "RxAddressFilteredCount")

      object RxDestAddrFilteredCount : Attribute(48L, "RxDestAddrFilteredCount")

      object RxDuplicatedCount : Attribute(49L, "RxDuplicatedCount")

      object RxErrNoFrameCount : Attribute(50L, "RxErrNoFrameCount")

      object RxErrUnknownNeighborCount : Attribute(51L, "RxErrUnknownNeighborCount")

      object RxErrInvalidSrcAddrCount : Attribute(52L, "RxErrInvalidSrcAddrCount")

      object RxErrSecCount : Attribute(53L, "RxErrSecCount")

      object RxErrFcsCount : Attribute(54L, "RxErrFcsCount")

      object RxErrOtherCount : Attribute(55L, "RxErrOtherCount")

      object ActiveTimestamp : Attribute(56L, "ActiveTimestamp")

      object PendingTimestamp : Attribute(57L, "PendingTimestamp")

      object Delay : Attribute(58L, "Delay")

      object SecurityPolicy : Attribute(59L, "SecurityPolicy")

      object ChannelPage0Mask : Attribute(60L, "ChannelPage0Mask")

      object OperationalDatasetComponents : Attribute(61L, "OperationalDatasetComponents")

      object ActiveNetworkFaultsList : Attribute(62L, "ActiveNetworkFaultsList")

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

    enum class Event(val id: Long) {
      ConnectionStatus(0L),
      NetworkFaultChange(1L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class Command(val id: Long) {
      ResetCounts(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 53L
  }

  object WiFiNetworkDiagnostics : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object Bssid : Attribute(0L, "Bssid")

      object SecurityType : Attribute(1L, "SecurityType")

      object WiFiVersion : Attribute(2L, "WiFiVersion")

      object ChannelNumber : Attribute(3L, "ChannelNumber")

      object Rssi : Attribute(4L, "Rssi")

      object BeaconLostCount : Attribute(5L, "BeaconLostCount")

      object BeaconRxCount : Attribute(6L, "BeaconRxCount")

      object PacketMulticastRxCount : Attribute(7L, "PacketMulticastRxCount")

      object PacketMulticastTxCount : Attribute(8L, "PacketMulticastTxCount")

      object PacketUnicastRxCount : Attribute(9L, "PacketUnicastRxCount")

      object PacketUnicastTxCount : Attribute(10L, "PacketUnicastTxCount")

      object CurrentMaxRate : Attribute(11L, "CurrentMaxRate")

      object OverrunCount : Attribute(12L, "OverrunCount")

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

    enum class Event(val id: Long) {
      Disconnection(0L),
      AssociationFailure(1L),
      ConnectionStatus(2L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class Command(val id: Long) {
      ResetCounts(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 54L
  }

  object EthernetNetworkDiagnostics : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object PHYRate : Attribute(0L, "PHYRate")

      object FullDuplex : Attribute(1L, "FullDuplex")

      object PacketRxCount : Attribute(2L, "PacketRxCount")

      object PacketTxCount : Attribute(3L, "PacketTxCount")

      object TxErrCount : Attribute(4L, "TxErrCount")

      object CollisionCount : Attribute(5L, "CollisionCount")

      object OverrunCount : Attribute(6L, "OverrunCount")

      object CarrierDetect : Attribute(7L, "CarrierDetect")

      object TimeSinceReset : Attribute(8L, "TimeSinceReset")

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

    enum class Command(val id: Long) {
      ResetCounts(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 55L
  }

  object TimeSynchronization : ClusterIDMapping() {
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

    enum class Event(val id: Long) {
      DSTTableEmpty(0L),
      DSTStatus(1L),
      TimeZoneStatus(2L),
      TimeFailure(3L),
      MissingTrustedTimeSource(4L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class Command(val id: Long) {
      SetUTCTime(0L),
      SetTrustedTimeSource(1L),
      SetTimeZone(2L),
      SetDSTOffset(4L),
      SetDefaultNTP(5L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SetUTCTimeCommandField(val id: Int) {
      UTCTime(0),
      Granularity(1),
      TimeSource(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SetUTCTimeCommandField {
          for (field in SetUTCTimeCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SetTrustedTimeSourceCommandField(val id: Int) {
      TrustedTimeSource(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SetTrustedTimeSourceCommandField {
          for (field in SetTrustedTimeSourceCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SetTimeZoneCommandField(val id: Int) {
      TimeZone(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SetTimeZoneCommandField {
          for (field in SetTimeZoneCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SetDSTOffsetCommandField(val id: Int) {
      DSTOffset(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SetDSTOffsetCommandField {
          for (field in SetDSTOffsetCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SetDefaultNTPCommandField(val id: Int) {
      DefaultNTP(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SetDefaultNTPCommandField {
          for (field in SetDefaultNTPCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 56L
  }

  object BridgedDeviceBasicInformation : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object VendorName : Attribute(1L, "VendorName")

      object VendorID : Attribute(2L, "VendorID")

      object ProductName : Attribute(3L, "ProductName")

      object NodeLabel : Attribute(5L, "NodeLabel")

      object HardwareVersion : Attribute(7L, "HardwareVersion")

      object HardwareVersionString : Attribute(8L, "HardwareVersionString")

      object SoftwareVersion : Attribute(9L, "SoftwareVersion")

      object SoftwareVersionString : Attribute(10L, "SoftwareVersionString")

      object ManufacturingDate : Attribute(11L, "ManufacturingDate")

      object PartNumber : Attribute(12L, "PartNumber")

      object ProductURL : Attribute(13L, "ProductURL")

      object ProductLabel : Attribute(14L, "ProductLabel")

      object SerialNumber : Attribute(15L, "SerialNumber")

      object Reachable : Attribute(17L, "Reachable")

      object UniqueID : Attribute(18L, "UniqueID")

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

    enum class Event(val id: Long) {
      StartUp(0L),
      ShutDown(1L),
      Leave(2L),
      ReachableChanged(3L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
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

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      return Event.valueOf(name).id
    }

    const val ID = 57L
  }

  object Switch : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object NumberOfPositions : Attribute(0L, "NumberOfPositions")

      object CurrentPosition : Attribute(1L, "CurrentPosition")

      object MultiPressMax : Attribute(2L, "MultiPressMax")

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

    enum class Event(val id: Long) {
      SwitchLatched(0L),
      InitialPress(1L),
      LongPress(2L),
      ShortRelease(3L),
      LongRelease(4L),
      MultiPressOngoing(5L),
      MultiPressComplete(6L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
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

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      return Event.valueOf(name).id
    }

    const val ID = 59L
  }

  object AdministratorCommissioning : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object WindowStatus : Attribute(0L, "WindowStatus")

      object AdminFabricIndex : Attribute(1L, "AdminFabricIndex")

      object AdminVendorId : Attribute(2L, "AdminVendorId")

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

    enum class Command(val id: Long) {
      OpenCommissioningWindow(0L),
      OpenBasicCommissioningWindow(1L),
      RevokeCommissioning(2L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class OpenCommissioningWindowCommandField(val id: Int) {
      CommissioningTimeout(0),
      PAKEPasscodeVerifier(1),
      Discriminator(2),
      Iterations(3),
      Salt(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): OpenCommissioningWindowCommandField {
          for (field in OpenCommissioningWindowCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class OpenBasicCommissioningWindowCommandField(val id: Int) {
      CommissioningTimeout(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): OpenBasicCommissioningWindowCommandField {
          for (field in OpenBasicCommissioningWindowCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 60L
  }

  object OperationalCredentials : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object NOCs : Attribute(0L, "NOCs")

      object Fabrics : Attribute(1L, "Fabrics")

      object SupportedFabrics : Attribute(2L, "SupportedFabrics")

      object CommissionedFabrics : Attribute(3L, "CommissionedFabrics")

      object TrustedRootCertificates : Attribute(4L, "TrustedRootCertificates")

      object CurrentFabricIndex : Attribute(5L, "CurrentFabricIndex")

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

    enum class Command(val id: Long) {
      AttestationRequest(0L),
      CertificateChainRequest(2L),
      CSRRequest(4L),
      AddNOC(6L),
      UpdateNOC(7L),
      UpdateFabricLabel(9L),
      RemoveFabric(10L),
      AddTrustedRootCertificate(11L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class AttestationRequestCommandField(val id: Int) {
      AttestationNonce(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): AttestationRequestCommandField {
          for (field in AttestationRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class CertificateChainRequestCommandField(val id: Int) {
      CertificateType(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): CertificateChainRequestCommandField {
          for (field in CertificateChainRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class CSRRequestCommandField(val id: Int) {
      CSRNonce(0),
      IsForUpdateNOC(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): CSRRequestCommandField {
          for (field in CSRRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class AddNOCCommandField(val id: Int) {
      NOCValue(0),
      ICACValue(1),
      IPKValue(2),
      CaseAdminSubject(3),
      AdminVendorId(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): AddNOCCommandField {
          for (field in AddNOCCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class UpdateNOCCommandField(val id: Int) {
      NOCValue(0),
      ICACValue(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): UpdateNOCCommandField {
          for (field in UpdateNOCCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class UpdateFabricLabelCommandField(val id: Int) {
      Label(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): UpdateFabricLabelCommandField {
          for (field in UpdateFabricLabelCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class RemoveFabricCommandField(val id: Int) {
      FabricIndex(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): RemoveFabricCommandField {
          for (field in RemoveFabricCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class AddTrustedRootCertificateCommandField(val id: Int) {
      RootCACertificate(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): AddTrustedRootCertificateCommandField {
          for (field in AddTrustedRootCertificateCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 62L
  }

  object GroupKeyManagement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object GroupKeyMap : Attribute(0L, "GroupKeyMap")

      object GroupTable : Attribute(1L, "GroupTable")

      object MaxGroupsPerFabric : Attribute(2L, "MaxGroupsPerFabric")

      object MaxGroupKeysPerFabric : Attribute(3L, "MaxGroupKeysPerFabric")

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

    enum class Command(val id: Long) {
      KeySetWrite(0L),
      KeySetRead(1L),
      KeySetRemove(3L),
      KeySetReadAllIndices(4L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class KeySetWriteCommandField(val id: Int) {
      GroupKeySet(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): KeySetWriteCommandField {
          for (field in KeySetWriteCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class KeySetReadCommandField(val id: Int) {
      GroupKeySetID(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): KeySetReadCommandField {
          for (field in KeySetReadCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class KeySetRemoveCommandField(val id: Int) {
      GroupKeySetID(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): KeySetRemoveCommandField {
          for (field in KeySetRemoveCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 63L
  }

  object FixedLabel : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object LabelList : Attribute(0L, "LabelList")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 64L
  }

  object UserLabel : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object LabelList : Attribute(0L, "LabelList")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 65L
  }

  object ProxyConfiguration : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 66L
  }

  object ProxyDiscovery : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 67L
  }

  object ProxyValid : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 68L
  }

  object BooleanState : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object StateValue : Attribute(0L, "StateValue")

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

    enum class Event(val id: Long) {
      StateChange(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
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

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      return Event.valueOf(name).id
    }

    const val ID = 69L
  }

  object IcdManagement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object IdleModeInterval : Attribute(0L, "IdleModeInterval")

      object ActiveModeInterval : Attribute(1L, "ActiveModeInterval")

      object ActiveModeThreshold : Attribute(2L, "ActiveModeThreshold")

      object RegisteredClients : Attribute(3L, "RegisteredClients")

      object ICDCounter : Attribute(4L, "ICDCounter")

      object ClientsSupportedPerFabric : Attribute(5L, "ClientsSupportedPerFabric")

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

    enum class Command(val id: Long) {
      RegisterClient(0L),
      UnregisterClient(2L),
      StayActiveRequest(3L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class RegisterClientCommandField(val id: Int) {
      CheckInNodeID(0),
      MonitoredSubject(1),
      Key(2),
      VerificationKey(3);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): RegisterClientCommandField {
          for (field in RegisterClientCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class UnregisterClientCommandField(val id: Int) {
      CheckInNodeID(0),
      VerificationKey(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): UnregisterClientCommandField {
          for (field in UnregisterClientCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 70L
  }

  object ModeSelect : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object Description : Attribute(0L, "Description")

      object StandardNamespace : Attribute(1L, "StandardNamespace")

      object SupportedModes : Attribute(2L, "SupportedModes")

      object CurrentMode : Attribute(3L, "CurrentMode")

      object StartUpMode : Attribute(4L, "StartUpMode")

      object OnMode : Attribute(5L, "OnMode")

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

    enum class Command(val id: Long) {
      ChangeToMode(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ChangeToModeCommandField(val id: Int) {
      NewMode(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ChangeToModeCommandField {
          for (field in ChangeToModeCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 80L
  }

  object LaundryWasherMode : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object SupportedModes : Attribute(0L, "SupportedModes")

      object CurrentMode : Attribute(1L, "CurrentMode")

      object StartUpMode : Attribute(2L, "StartUpMode")

      object OnMode : Attribute(3L, "OnMode")

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

    enum class Command(val id: Long) {
      ChangeToMode(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ChangeToModeCommandField(val id: Int) {
      NewMode(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ChangeToModeCommandField {
          for (field in ChangeToModeCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 81L
  }

  object RefrigeratorAndTemperatureControlledCabinetMode : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object SupportedModes : Attribute(0L, "SupportedModes")

      object CurrentMode : Attribute(1L, "CurrentMode")

      object StartUpMode : Attribute(2L, "StartUpMode")

      object OnMode : Attribute(3L, "OnMode")

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

    enum class Command(val id: Long) {
      ChangeToMode(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ChangeToModeCommandField(val id: Int) {
      NewMode(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ChangeToModeCommandField {
          for (field in ChangeToModeCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 82L
  }

  object LaundryWasherControls : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object SpinSpeeds : Attribute(0L, "SpinSpeeds")

      object SpinSpeedCurrent : Attribute(1L, "SpinSpeedCurrent")

      object NumberOfRinses : Attribute(2L, "NumberOfRinses")

      object SupportedRinses : Attribute(3L, "SupportedRinses")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 83L
  }

  object RvcRunMode : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object SupportedModes : Attribute(0L, "SupportedModes")

      object CurrentMode : Attribute(1L, "CurrentMode")

      object StartUpMode : Attribute(2L, "StartUpMode")

      object OnMode : Attribute(3L, "OnMode")

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

    enum class Command(val id: Long) {
      ChangeToMode(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ChangeToModeCommandField(val id: Int) {
      NewMode(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ChangeToModeCommandField {
          for (field in ChangeToModeCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 84L
  }

  object RvcCleanMode : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object SupportedModes : Attribute(0L, "SupportedModes")

      object CurrentMode : Attribute(1L, "CurrentMode")

      object StartUpMode : Attribute(2L, "StartUpMode")

      object OnMode : Attribute(3L, "OnMode")

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

    enum class Command(val id: Long) {
      ChangeToMode(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ChangeToModeCommandField(val id: Int) {
      NewMode(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ChangeToModeCommandField {
          for (field in ChangeToModeCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 85L
  }

  object TemperatureControl : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object TemperatureSetpoint : Attribute(0L, "TemperatureSetpoint")

      object MinTemperature : Attribute(1L, "MinTemperature")

      object MaxTemperature : Attribute(2L, "MaxTemperature")

      object Step : Attribute(3L, "Step")

      object SelectedTemperatureLevel : Attribute(4L, "SelectedTemperatureLevel")

      object SupportedTemperatureLevels : Attribute(5L, "SupportedTemperatureLevels")

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

    enum class Command(val id: Long) {
      SetTemperature(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SetTemperatureCommandField(val id: Int) {
      TargetTemperature(0),
      TargetTemperatureLevel(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SetTemperatureCommandField {
          for (field in SetTemperatureCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 86L
  }

  object RefrigeratorAlarm : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object Mask : Attribute(0L, "Mask")

      object State : Attribute(2L, "State")

      object Supported : Attribute(3L, "Supported")

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

    enum class Event(val id: Long) {
      Notify(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
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

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      return Event.valueOf(name).id
    }

    const val ID = 87L
  }

  object DishwasherMode : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object SupportedModes : Attribute(0L, "SupportedModes")

      object CurrentMode : Attribute(1L, "CurrentMode")

      object StartUpMode : Attribute(2L, "StartUpMode")

      object OnMode : Attribute(3L, "OnMode")

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

    enum class Command(val id: Long) {
      ChangeToMode(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ChangeToModeCommandField(val id: Int) {
      NewMode(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ChangeToModeCommandField {
          for (field in ChangeToModeCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 89L
  }

  object AirQuality : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object AirQuality : Attribute(0L, "AirQuality")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 91L
  }

  object SmokeCoAlarm : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object ExpressedState : Attribute(0L, "ExpressedState")

      object SmokeState : Attribute(1L, "SmokeState")

      object COState : Attribute(2L, "COState")

      object BatteryAlert : Attribute(3L, "BatteryAlert")

      object DeviceMuted : Attribute(4L, "DeviceMuted")

      object TestInProgress : Attribute(5L, "TestInProgress")

      object HardwareFaultAlert : Attribute(6L, "HardwareFaultAlert")

      object EndOfServiceAlert : Attribute(7L, "EndOfServiceAlert")

      object InterconnectSmokeAlarm : Attribute(8L, "InterconnectSmokeAlarm")

      object InterconnectCOAlarm : Attribute(9L, "InterconnectCOAlarm")

      object ContaminationState : Attribute(10L, "ContaminationState")

      object SmokeSensitivityLevel : Attribute(11L, "SmokeSensitivityLevel")

      object ExpiryDate : Attribute(12L, "ExpiryDate")

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

    enum class Event(val id: Long) {
      SmokeAlarm(0L),
      COAlarm(1L),
      LowBattery(2L),
      HardwareFault(3L),
      EndOfService(4L),
      SelfTestComplete(5L),
      AlarmMuted(6L),
      MuteEnded(7L),
      InterconnectSmokeAlarm(8L),
      InterconnectCOAlarm(9L),
      AllClear(10L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class Command(val id: Long) {
      SelfTestRequest(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 92L
  }

  object DishwasherAlarm : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object Mask : Attribute(0L, "Mask")

      object Latch : Attribute(1L, "Latch")

      object State : Attribute(2L, "State")

      object Supported : Attribute(3L, "Supported")

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

    enum class Event(val id: Long) {
      Notify(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class Command(val id: Long) {
      Reset(0L),
      ModifyEnabledAlarms(1L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ResetCommandField(val id: Int) {
      Alarms(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ResetCommandField {
          for (field in ResetCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ModifyEnabledAlarmsCommandField(val id: Int) {
      Mask(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ModifyEnabledAlarmsCommandField {
          for (field in ModifyEnabledAlarmsCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 93L
  }

  object OperationalState : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object PhaseList : Attribute(0L, "PhaseList")

      object CurrentPhase : Attribute(1L, "CurrentPhase")

      object CountdownTime : Attribute(2L, "CountdownTime")

      object OperationalStateList : Attribute(3L, "OperationalStateList")

      object OperationalState : Attribute(4L, "OperationalState")

      object OperationalError : Attribute(5L, "OperationalError")

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

    enum class Event(val id: Long) {
      OperationalError(0L),
      OperationCompletion(1L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class Command(val id: Long) {
      Pause(0L),
      Stop(1L),
      Start(2L),
      Resume(3L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 96L
  }

  object RvcOperationalState : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object PhaseList : Attribute(0L, "PhaseList")

      object CurrentPhase : Attribute(1L, "CurrentPhase")

      object CountdownTime : Attribute(2L, "CountdownTime")

      object OperationalStateList : Attribute(3L, "OperationalStateList")

      object OperationalState : Attribute(4L, "OperationalState")

      object OperationalError : Attribute(5L, "OperationalError")

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

    enum class Event(val id: Long) {
      OperationalError(0L),
      OperationCompletion(1L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class Command(val id: Long) {
      Pause(0L),
      Stop(1L),
      Start(2L),
      Resume(3L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 97L
  }

  object HepaFilterMonitoring : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object Condition : Attribute(0L, "Condition")

      object DegradationDirection : Attribute(1L, "DegradationDirection")

      object ChangeIndication : Attribute(2L, "ChangeIndication")

      object InPlaceIndicator : Attribute(3L, "InPlaceIndicator")

      object LastChangedTime : Attribute(4L, "LastChangedTime")

      object ReplacementProductList : Attribute(5L, "ReplacementProductList")

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

    enum class Command(val id: Long) {
      ResetCondition(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 113L
  }

  object ActivatedCarbonFilterMonitoring : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object Condition : Attribute(0L, "Condition")

      object DegradationDirection : Attribute(1L, "DegradationDirection")

      object ChangeIndication : Attribute(2L, "ChangeIndication")

      object InPlaceIndicator : Attribute(3L, "InPlaceIndicator")

      object LastChangedTime : Attribute(4L, "LastChangedTime")

      object ReplacementProductList : Attribute(5L, "ReplacementProductList")

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

    enum class Command(val id: Long) {
      ResetCondition(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 114L
  }

  object DoorLock : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object LockState : Attribute(0L, "LockState")

      object LockType : Attribute(1L, "LockType")

      object ActuatorEnabled : Attribute(2L, "ActuatorEnabled")

      object DoorState : Attribute(3L, "DoorState")

      object DoorOpenEvents : Attribute(4L, "DoorOpenEvents")

      object DoorClosedEvents : Attribute(5L, "DoorClosedEvents")

      object OpenPeriod : Attribute(6L, "OpenPeriod")

      object NumberOfTotalUsersSupported : Attribute(17L, "NumberOfTotalUsersSupported")

      object NumberOfPINUsersSupported : Attribute(18L, "NumberOfPINUsersSupported")

      object NumberOfRFIDUsersSupported : Attribute(19L, "NumberOfRFIDUsersSupported")

      object NumberOfWeekDaySchedulesSupportedPerUser :
        Attribute(20L, "NumberOfWeekDaySchedulesSupportedPerUser")

      object NumberOfYearDaySchedulesSupportedPerUser :
        Attribute(21L, "NumberOfYearDaySchedulesSupportedPerUser")

      object NumberOfHolidaySchedulesSupported :
        Attribute(22L, "NumberOfHolidaySchedulesSupported")

      object MaxPINCodeLength : Attribute(23L, "MaxPINCodeLength")

      object MinPINCodeLength : Attribute(24L, "MinPINCodeLength")

      object MaxRFIDCodeLength : Attribute(25L, "MaxRFIDCodeLength")

      object MinRFIDCodeLength : Attribute(26L, "MinRFIDCodeLength")

      object CredentialRulesSupport : Attribute(27L, "CredentialRulesSupport")

      object NumberOfCredentialsSupportedPerUser :
        Attribute(28L, "NumberOfCredentialsSupportedPerUser")

      object Language : Attribute(33L, "Language")

      object LEDSettings : Attribute(34L, "LEDSettings")

      object AutoRelockTime : Attribute(35L, "AutoRelockTime")

      object SoundVolume : Attribute(36L, "SoundVolume")

      object OperatingMode : Attribute(37L, "OperatingMode")

      object SupportedOperatingModes : Attribute(38L, "SupportedOperatingModes")

      object DefaultConfigurationRegister : Attribute(39L, "DefaultConfigurationRegister")

      object EnableLocalProgramming : Attribute(40L, "EnableLocalProgramming")

      object EnableOneTouchLocking : Attribute(41L, "EnableOneTouchLocking")

      object EnableInsideStatusLED : Attribute(42L, "EnableInsideStatusLED")

      object EnablePrivacyModeButton : Attribute(43L, "EnablePrivacyModeButton")

      object LocalProgrammingFeatures : Attribute(44L, "LocalProgrammingFeatures")

      object WrongCodeEntryLimit : Attribute(48L, "WrongCodeEntryLimit")

      object UserCodeTemporaryDisableTime : Attribute(49L, "UserCodeTemporaryDisableTime")

      object SendPINOverTheAir : Attribute(50L, "SendPINOverTheAir")

      object RequirePINforRemoteOperation : Attribute(51L, "RequirePINforRemoteOperation")

      object ExpiringUserTimeout : Attribute(53L, "ExpiringUserTimeout")

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

    enum class Event(val id: Long) {
      DoorLockAlarm(0L),
      DoorStateChange(1L),
      LockOperation(2L),
      LockOperationError(3L),
      LockUserChange(4L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class Command(val id: Long) {
      LockDoor(0L),
      UnlockDoor(1L),
      UnlockWithTimeout(3L),
      SetWeekDaySchedule(11L),
      GetWeekDaySchedule(12L),
      ClearWeekDaySchedule(13L),
      SetYearDaySchedule(14L),
      GetYearDaySchedule(15L),
      ClearYearDaySchedule(16L),
      SetHolidaySchedule(17L),
      GetHolidaySchedule(18L),
      ClearHolidaySchedule(19L),
      SetUser(26L),
      GetUser(27L),
      ClearUser(29L),
      SetCredential(34L),
      GetCredentialStatus(36L),
      ClearCredential(38L),
      UnboltDoor(39L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class LockDoorCommandField(val id: Int) {
      PINCode(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): LockDoorCommandField {
          for (field in LockDoorCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class UnlockDoorCommandField(val id: Int) {
      PINCode(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): UnlockDoorCommandField {
          for (field in UnlockDoorCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class UnlockWithTimeoutCommandField(val id: Int) {
      Timeout(0),
      PINCode(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): UnlockWithTimeoutCommandField {
          for (field in UnlockWithTimeoutCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SetWeekDayScheduleCommandField(val id: Int) {
      WeekDayIndex(0),
      UserIndex(1),
      DaysMask(2),
      StartHour(3),
      StartMinute(4),
      EndHour(5),
      EndMinute(6);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SetWeekDayScheduleCommandField {
          for (field in SetWeekDayScheduleCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class GetWeekDayScheduleCommandField(val id: Int) {
      WeekDayIndex(0),
      UserIndex(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): GetWeekDayScheduleCommandField {
          for (field in GetWeekDayScheduleCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ClearWeekDayScheduleCommandField(val id: Int) {
      WeekDayIndex(0),
      UserIndex(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ClearWeekDayScheduleCommandField {
          for (field in ClearWeekDayScheduleCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SetYearDayScheduleCommandField(val id: Int) {
      YearDayIndex(0),
      UserIndex(1),
      LocalStartTime(2),
      LocalEndTime(3);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SetYearDayScheduleCommandField {
          for (field in SetYearDayScheduleCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class GetYearDayScheduleCommandField(val id: Int) {
      YearDayIndex(0),
      UserIndex(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): GetYearDayScheduleCommandField {
          for (field in GetYearDayScheduleCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ClearYearDayScheduleCommandField(val id: Int) {
      YearDayIndex(0),
      UserIndex(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ClearYearDayScheduleCommandField {
          for (field in ClearYearDayScheduleCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SetHolidayScheduleCommandField(val id: Int) {
      HolidayIndex(0),
      LocalStartTime(1),
      LocalEndTime(2),
      OperatingMode(3);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SetHolidayScheduleCommandField {
          for (field in SetHolidayScheduleCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class GetHolidayScheduleCommandField(val id: Int) {
      HolidayIndex(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): GetHolidayScheduleCommandField {
          for (field in GetHolidayScheduleCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ClearHolidayScheduleCommandField(val id: Int) {
      HolidayIndex(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ClearHolidayScheduleCommandField {
          for (field in ClearHolidayScheduleCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SetUserCommandField(val id: Int) {
      OperationType(0),
      UserIndex(1),
      UserName(2),
      UserUniqueID(3),
      UserStatus(4),
      UserType(5),
      CredentialRule(6);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SetUserCommandField {
          for (field in SetUserCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class GetUserCommandField(val id: Int) {
      UserIndex(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): GetUserCommandField {
          for (field in GetUserCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ClearUserCommandField(val id: Int) {
      UserIndex(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ClearUserCommandField {
          for (field in ClearUserCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SetCredentialCommandField(val id: Int) {
      OperationType(0),
      Credential(1),
      CredentialData(2),
      UserIndex(3),
      UserStatus(4),
      UserType(5);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SetCredentialCommandField {
          for (field in SetCredentialCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class GetCredentialStatusCommandField(val id: Int) {
      Credential(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): GetCredentialStatusCommandField {
          for (field in GetCredentialStatusCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ClearCredentialCommandField(val id: Int) {
      Credential(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ClearCredentialCommandField {
          for (field in ClearCredentialCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class UnboltDoorCommandField(val id: Int) {
      PINCode(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): UnboltDoorCommandField {
          for (field in UnboltDoorCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 257L
  }

  object WindowCovering : ClusterIDMapping() {
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

    enum class Command(val id: Long) {
      UpOrOpen(0L),
      DownOrClose(1L),
      StopMotion(2L),
      GoToLiftValue(4L),
      GoToLiftPercentage(5L),
      GoToTiltValue(7L),
      GoToTiltPercentage(8L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class GoToLiftValueCommandField(val id: Int) {
      LiftValue(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): GoToLiftValueCommandField {
          for (field in GoToLiftValueCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class GoToLiftPercentageCommandField(val id: Int) {
      LiftPercent100thsValue(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): GoToLiftPercentageCommandField {
          for (field in GoToLiftPercentageCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class GoToTiltValueCommandField(val id: Int) {
      TiltValue(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): GoToTiltValueCommandField {
          for (field in GoToTiltValueCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class GoToTiltPercentageCommandField(val id: Int) {
      TiltPercent100thsValue(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): GoToTiltPercentageCommandField {
          for (field in GoToTiltPercentageCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 258L
  }

  object BarrierControl : ClusterIDMapping() {
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

    enum class Command(val id: Long) {
      BarrierControlGoToPercent(0L),
      BarrierControlStop(1L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class BarrierControlGoToPercentCommandField(val id: Int) {
      PercentOpen(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): BarrierControlGoToPercentCommandField {
          for (field in BarrierControlGoToPercentCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 259L
  }

  object PumpConfigurationAndControl : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MaxPressure : Attribute(0L, "MaxPressure")

      object MaxSpeed : Attribute(1L, "MaxSpeed")

      object MaxFlow : Attribute(2L, "MaxFlow")

      object MinConstPressure : Attribute(3L, "MinConstPressure")

      object MaxConstPressure : Attribute(4L, "MaxConstPressure")

      object MinCompPressure : Attribute(5L, "MinCompPressure")

      object MaxCompPressure : Attribute(6L, "MaxCompPressure")

      object MinConstSpeed : Attribute(7L, "MinConstSpeed")

      object MaxConstSpeed : Attribute(8L, "MaxConstSpeed")

      object MinConstFlow : Attribute(9L, "MinConstFlow")

      object MaxConstFlow : Attribute(10L, "MaxConstFlow")

      object MinConstTemp : Attribute(11L, "MinConstTemp")

      object MaxConstTemp : Attribute(12L, "MaxConstTemp")

      object PumpStatus : Attribute(16L, "PumpStatus")

      object EffectiveOperationMode : Attribute(17L, "EffectiveOperationMode")

      object EffectiveControlMode : Attribute(18L, "EffectiveControlMode")

      object Capacity : Attribute(19L, "Capacity")

      object Speed : Attribute(20L, "Speed")

      object LifetimeRunningHours : Attribute(21L, "LifetimeRunningHours")

      object Power : Attribute(22L, "Power")

      object LifetimeEnergyConsumed : Attribute(23L, "LifetimeEnergyConsumed")

      object OperationMode : Attribute(32L, "OperationMode")

      object ControlMode : Attribute(33L, "ControlMode")

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

    enum class Event(val id: Long) {
      SupplyVoltageLow(0L),
      SupplyVoltageHigh(1L),
      PowerMissingPhase(2L),
      SystemPressureLow(3L),
      SystemPressureHigh(4L),
      DryRunning(5L),
      MotorTemperatureHigh(6L),
      PumpMotorFatalFailure(7L),
      ElectronicTemperatureHigh(8L),
      PumpBlocked(9L),
      SensorFailure(10L),
      ElectronicNonFatalFailure(11L),
      ElectronicFatalFailure(12L),
      GeneralFault(13L),
      Leakage(14L),
      AirDetection(15L),
      TurbineOperation(16L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
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

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      return Event.valueOf(name).id
    }

    const val ID = 512L
  }

  object Thermostat : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object LocalTemperature : Attribute(0L, "LocalTemperature")

      object OutdoorTemperature : Attribute(1L, "OutdoorTemperature")

      object Occupancy : Attribute(2L, "Occupancy")

      object AbsMinHeatSetpointLimit : Attribute(3L, "AbsMinHeatSetpointLimit")

      object AbsMaxHeatSetpointLimit : Attribute(4L, "AbsMaxHeatSetpointLimit")

      object AbsMinCoolSetpointLimit : Attribute(5L, "AbsMinCoolSetpointLimit")

      object AbsMaxCoolSetpointLimit : Attribute(6L, "AbsMaxCoolSetpointLimit")

      object PICoolingDemand : Attribute(7L, "PICoolingDemand")

      object PIHeatingDemand : Attribute(8L, "PIHeatingDemand")

      object HVACSystemTypeConfiguration : Attribute(9L, "HVACSystemTypeConfiguration")

      object LocalTemperatureCalibration : Attribute(16L, "LocalTemperatureCalibration")

      object OccupiedCoolingSetpoint : Attribute(17L, "OccupiedCoolingSetpoint")

      object OccupiedHeatingSetpoint : Attribute(18L, "OccupiedHeatingSetpoint")

      object UnoccupiedCoolingSetpoint : Attribute(19L, "UnoccupiedCoolingSetpoint")

      object UnoccupiedHeatingSetpoint : Attribute(20L, "UnoccupiedHeatingSetpoint")

      object MinHeatSetpointLimit : Attribute(21L, "MinHeatSetpointLimit")

      object MaxHeatSetpointLimit : Attribute(22L, "MaxHeatSetpointLimit")

      object MinCoolSetpointLimit : Attribute(23L, "MinCoolSetpointLimit")

      object MaxCoolSetpointLimit : Attribute(24L, "MaxCoolSetpointLimit")

      object MinSetpointDeadBand : Attribute(25L, "MinSetpointDeadBand")

      object RemoteSensing : Attribute(26L, "RemoteSensing")

      object ControlSequenceOfOperation : Attribute(27L, "ControlSequenceOfOperation")

      object SystemMode : Attribute(28L, "SystemMode")

      object ThermostatRunningMode : Attribute(30L, "ThermostatRunningMode")

      object StartOfWeek : Attribute(32L, "StartOfWeek")

      object NumberOfWeeklyTransitions : Attribute(33L, "NumberOfWeeklyTransitions")

      object NumberOfDailyTransitions : Attribute(34L, "NumberOfDailyTransitions")

      object TemperatureSetpointHold : Attribute(35L, "TemperatureSetpointHold")

      object TemperatureSetpointHoldDuration : Attribute(36L, "TemperatureSetpointHoldDuration")

      object ThermostatProgrammingOperationMode :
        Attribute(37L, "ThermostatProgrammingOperationMode")

      object ThermostatRunningState : Attribute(41L, "ThermostatRunningState")

      object SetpointChangeSource : Attribute(48L, "SetpointChangeSource")

      object SetpointChangeAmount : Attribute(49L, "SetpointChangeAmount")

      object SetpointChangeSourceTimestamp : Attribute(50L, "SetpointChangeSourceTimestamp")

      object OccupiedSetback : Attribute(52L, "OccupiedSetback")

      object OccupiedSetbackMin : Attribute(53L, "OccupiedSetbackMin")

      object OccupiedSetbackMax : Attribute(54L, "OccupiedSetbackMax")

      object UnoccupiedSetback : Attribute(55L, "UnoccupiedSetback")

      object UnoccupiedSetbackMin : Attribute(56L, "UnoccupiedSetbackMin")

      object UnoccupiedSetbackMax : Attribute(57L, "UnoccupiedSetbackMax")

      object EmergencyHeatDelta : Attribute(58L, "EmergencyHeatDelta")

      object ACType : Attribute(64L, "ACType")

      object ACCapacity : Attribute(65L, "ACCapacity")

      object ACRefrigerantType : Attribute(66L, "ACRefrigerantType")

      object ACCompressorType : Attribute(67L, "ACCompressorType")

      object ACErrorCode : Attribute(68L, "ACErrorCode")

      object ACLouverPosition : Attribute(69L, "ACLouverPosition")

      object ACCoilTemperature : Attribute(70L, "ACCoilTemperature")

      object ACCapacityformat : Attribute(71L, "ACCapacityformat")

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

    enum class Command(val id: Long) {
      SetpointRaiseLower(0L),
      SetWeeklySchedule(1L),
      GetWeeklySchedule(2L),
      ClearWeeklySchedule(3L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SetpointRaiseLowerCommandField(val id: Int) {
      Mode(0),
      Amount(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SetpointRaiseLowerCommandField {
          for (field in SetpointRaiseLowerCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SetWeeklyScheduleCommandField(val id: Int) {
      NumberOfTransitionsForSequence(0),
      DayOfWeekForSequence(1),
      ModeForSequence(2),
      Transitions(3);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SetWeeklyScheduleCommandField {
          for (field in SetWeeklyScheduleCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class GetWeeklyScheduleCommandField(val id: Int) {
      DaysToReturn(0),
      ModeToReturn(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): GetWeeklyScheduleCommandField {
          for (field in GetWeeklyScheduleCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 513L
  }

  object FanControl : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object FanMode : Attribute(0L, "FanMode")

      object FanModeSequence : Attribute(1L, "FanModeSequence")

      object PercentSetting : Attribute(2L, "PercentSetting")

      object PercentCurrent : Attribute(3L, "PercentCurrent")

      object SpeedMax : Attribute(4L, "SpeedMax")

      object SpeedSetting : Attribute(5L, "SpeedSetting")

      object SpeedCurrent : Attribute(6L, "SpeedCurrent")

      object RockSupport : Attribute(7L, "RockSupport")

      object RockSetting : Attribute(8L, "RockSetting")

      object WindSupport : Attribute(9L, "WindSupport")

      object WindSetting : Attribute(10L, "WindSetting")

      object AirflowDirection : Attribute(11L, "AirflowDirection")

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

    enum class Command(val id: Long) {
      Step(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class StepCommandField(val id: Int) {
      Direction(0),
      Wrap(1),
      LowestOff(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): StepCommandField {
          for (field in StepCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 514L
  }

  object ThermostatUserInterfaceConfiguration : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object TemperatureDisplayMode : Attribute(0L, "TemperatureDisplayMode")

      object KeypadLockout : Attribute(1L, "KeypadLockout")

      object ScheduleProgrammingVisibility : Attribute(2L, "ScheduleProgrammingVisibility")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 516L
  }

  object ColorControl : ClusterIDMapping() {
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

    enum class Command(val id: Long) {
      MoveToHue(0L),
      MoveHue(1L),
      StepHue(2L),
      MoveToSaturation(3L),
      MoveSaturation(4L),
      StepSaturation(5L),
      MoveToHueAndSaturation(6L),
      MoveToColor(7L),
      MoveColor(8L),
      StepColor(9L),
      MoveToColorTemperature(10L),
      EnhancedMoveToHue(64L),
      EnhancedMoveHue(65L),
      EnhancedStepHue(66L),
      EnhancedMoveToHueAndSaturation(67L),
      ColorLoopSet(68L),
      StopMoveStep(71L),
      MoveColorTemperature(75L),
      StepColorTemperature(76L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class MoveToHueCommandField(val id: Int) {
      Hue(0),
      Direction(1),
      TransitionTime(2),
      OptionsMask(3),
      OptionsOverride(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): MoveToHueCommandField {
          for (field in MoveToHueCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class MoveHueCommandField(val id: Int) {
      MoveMode(0),
      Rate(1),
      OptionsMask(2),
      OptionsOverride(3);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): MoveHueCommandField {
          for (field in MoveHueCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class StepHueCommandField(val id: Int) {
      StepMode(0),
      StepSize(1),
      TransitionTime(2),
      OptionsMask(3),
      OptionsOverride(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): StepHueCommandField {
          for (field in StepHueCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class MoveToSaturationCommandField(val id: Int) {
      Saturation(0),
      TransitionTime(1),
      OptionsMask(2),
      OptionsOverride(3);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): MoveToSaturationCommandField {
          for (field in MoveToSaturationCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class MoveSaturationCommandField(val id: Int) {
      MoveMode(0),
      Rate(1),
      OptionsMask(2),
      OptionsOverride(3);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): MoveSaturationCommandField {
          for (field in MoveSaturationCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class StepSaturationCommandField(val id: Int) {
      StepMode(0),
      StepSize(1),
      TransitionTime(2),
      OptionsMask(3),
      OptionsOverride(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): StepSaturationCommandField {
          for (field in StepSaturationCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class MoveToHueAndSaturationCommandField(val id: Int) {
      Hue(0),
      Saturation(1),
      TransitionTime(2),
      OptionsMask(3),
      OptionsOverride(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): MoveToHueAndSaturationCommandField {
          for (field in MoveToHueAndSaturationCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class MoveToColorCommandField(val id: Int) {
      ColorX(0),
      ColorY(1),
      TransitionTime(2),
      OptionsMask(3),
      OptionsOverride(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): MoveToColorCommandField {
          for (field in MoveToColorCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class MoveColorCommandField(val id: Int) {
      RateX(0),
      RateY(1),
      OptionsMask(2),
      OptionsOverride(3);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): MoveColorCommandField {
          for (field in MoveColorCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class StepColorCommandField(val id: Int) {
      StepX(0),
      StepY(1),
      TransitionTime(2),
      OptionsMask(3),
      OptionsOverride(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): StepColorCommandField {
          for (field in StepColorCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class MoveToColorTemperatureCommandField(val id: Int) {
      ColorTemperatureMireds(0),
      TransitionTime(1),
      OptionsMask(2),
      OptionsOverride(3);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): MoveToColorTemperatureCommandField {
          for (field in MoveToColorTemperatureCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class EnhancedMoveToHueCommandField(val id: Int) {
      EnhancedHue(0),
      Direction(1),
      TransitionTime(2),
      OptionsMask(3),
      OptionsOverride(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): EnhancedMoveToHueCommandField {
          for (field in EnhancedMoveToHueCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class EnhancedMoveHueCommandField(val id: Int) {
      MoveMode(0),
      Rate(1),
      OptionsMask(2),
      OptionsOverride(3);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): EnhancedMoveHueCommandField {
          for (field in EnhancedMoveHueCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class EnhancedStepHueCommandField(val id: Int) {
      StepMode(0),
      StepSize(1),
      TransitionTime(2),
      OptionsMask(3),
      OptionsOverride(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): EnhancedStepHueCommandField {
          for (field in EnhancedStepHueCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class EnhancedMoveToHueAndSaturationCommandField(val id: Int) {
      EnhancedHue(0),
      Saturation(1),
      TransitionTime(2),
      OptionsMask(3),
      OptionsOverride(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): EnhancedMoveToHueAndSaturationCommandField {
          for (field in EnhancedMoveToHueAndSaturationCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ColorLoopSetCommandField(val id: Int) {
      UpdateFlags(0),
      Action(1),
      Direction(2),
      Time(3),
      StartHue(4),
      OptionsMask(5),
      OptionsOverride(6);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ColorLoopSetCommandField {
          for (field in ColorLoopSetCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class StopMoveStepCommandField(val id: Int) {
      OptionsMask(0),
      OptionsOverride(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): StopMoveStepCommandField {
          for (field in StopMoveStepCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class MoveColorTemperatureCommandField(val id: Int) {
      MoveMode(0),
      Rate(1),
      ColorTemperatureMinimumMireds(2),
      ColorTemperatureMaximumMireds(3),
      OptionsMask(4),
      OptionsOverride(5);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): MoveColorTemperatureCommandField {
          for (field in MoveColorTemperatureCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class StepColorTemperatureCommandField(val id: Int) {
      StepMode(0),
      StepSize(1),
      TransitionTime(2),
      ColorTemperatureMinimumMireds(3),
      ColorTemperatureMaximumMireds(4),
      OptionsMask(5),
      OptionsOverride(6);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): StepColorTemperatureCommandField {
          for (field in StepColorTemperatureCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 768L
  }

  object BallastConfiguration : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object PhysicalMinLevel : Attribute(0L, "PhysicalMinLevel")

      object PhysicalMaxLevel : Attribute(1L, "PhysicalMaxLevel")

      object BallastStatus : Attribute(2L, "BallastStatus")

      object MinLevel : Attribute(16L, "MinLevel")

      object MaxLevel : Attribute(17L, "MaxLevel")

      object IntrinsicBallastFactor : Attribute(20L, "IntrinsicBallastFactor")

      object BallastFactorAdjustment : Attribute(21L, "BallastFactorAdjustment")

      object LampQuantity : Attribute(32L, "LampQuantity")

      object LampType : Attribute(48L, "LampType")

      object LampManufacturer : Attribute(49L, "LampManufacturer")

      object LampRatedHours : Attribute(50L, "LampRatedHours")

      object LampBurnHours : Attribute(51L, "LampBurnHours")

      object LampAlarmMode : Attribute(52L, "LampAlarmMode")

      object LampBurnHoursTripPoint : Attribute(53L, "LampBurnHoursTripPoint")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 769L
  }

  object IlluminanceMeasurement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MeasuredValue : Attribute(0L, "MeasuredValue")

      object MinMeasuredValue : Attribute(1L, "MinMeasuredValue")

      object MaxMeasuredValue : Attribute(2L, "MaxMeasuredValue")

      object Tolerance : Attribute(3L, "Tolerance")

      object LightSensorType : Attribute(4L, "LightSensorType")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1024L
  }

  object TemperatureMeasurement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MeasuredValue : Attribute(0L, "MeasuredValue")

      object MinMeasuredValue : Attribute(1L, "MinMeasuredValue")

      object MaxMeasuredValue : Attribute(2L, "MaxMeasuredValue")

      object Tolerance : Attribute(3L, "Tolerance")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1026L
  }

  object PressureMeasurement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MeasuredValue : Attribute(0L, "MeasuredValue")

      object MinMeasuredValue : Attribute(1L, "MinMeasuredValue")

      object MaxMeasuredValue : Attribute(2L, "MaxMeasuredValue")

      object Tolerance : Attribute(3L, "Tolerance")

      object ScaledValue : Attribute(16L, "ScaledValue")

      object MinScaledValue : Attribute(17L, "MinScaledValue")

      object MaxScaledValue : Attribute(18L, "MaxScaledValue")

      object ScaledTolerance : Attribute(19L, "ScaledTolerance")

      object Scale : Attribute(20L, "Scale")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1027L
  }

  object FlowMeasurement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MeasuredValue : Attribute(0L, "MeasuredValue")

      object MinMeasuredValue : Attribute(1L, "MinMeasuredValue")

      object MaxMeasuredValue : Attribute(2L, "MaxMeasuredValue")

      object Tolerance : Attribute(3L, "Tolerance")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1028L
  }

  object RelativeHumidityMeasurement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MeasuredValue : Attribute(0L, "MeasuredValue")

      object MinMeasuredValue : Attribute(1L, "MinMeasuredValue")

      object MaxMeasuredValue : Attribute(2L, "MaxMeasuredValue")

      object Tolerance : Attribute(3L, "Tolerance")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1029L
  }

  object OccupancySensing : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object Occupancy : Attribute(0L, "Occupancy")

      object OccupancySensorType : Attribute(1L, "OccupancySensorType")

      object OccupancySensorTypeBitmap : Attribute(2L, "OccupancySensorTypeBitmap")

      object PIROccupiedToUnoccupiedDelay : Attribute(16L, "PIROccupiedToUnoccupiedDelay")

      object PIRUnoccupiedToOccupiedDelay : Attribute(17L, "PIRUnoccupiedToOccupiedDelay")

      object PIRUnoccupiedToOccupiedThreshold : Attribute(18L, "PIRUnoccupiedToOccupiedThreshold")

      object UltrasonicOccupiedToUnoccupiedDelay :
        Attribute(32L, "UltrasonicOccupiedToUnoccupiedDelay")

      object UltrasonicUnoccupiedToOccupiedDelay :
        Attribute(33L, "UltrasonicUnoccupiedToOccupiedDelay")

      object UltrasonicUnoccupiedToOccupiedThreshold :
        Attribute(34L, "UltrasonicUnoccupiedToOccupiedThreshold")

      object PhysicalContactOccupiedToUnoccupiedDelay :
        Attribute(48L, "PhysicalContactOccupiedToUnoccupiedDelay")

      object PhysicalContactUnoccupiedToOccupiedDelay :
        Attribute(49L, "PhysicalContactUnoccupiedToOccupiedDelay")

      object PhysicalContactUnoccupiedToOccupiedThreshold :
        Attribute(50L, "PhysicalContactUnoccupiedToOccupiedThreshold")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1030L
  }

  object CarbonMonoxideConcentrationMeasurement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MeasuredValue : Attribute(0L, "MeasuredValue")

      object MinMeasuredValue : Attribute(1L, "MinMeasuredValue")

      object MaxMeasuredValue : Attribute(2L, "MaxMeasuredValue")

      object PeakMeasuredValue : Attribute(3L, "PeakMeasuredValue")

      object PeakMeasuredValueWindow : Attribute(4L, "PeakMeasuredValueWindow")

      object AverageMeasuredValue : Attribute(5L, "AverageMeasuredValue")

      object AverageMeasuredValueWindow : Attribute(6L, "AverageMeasuredValueWindow")

      object Uncertainty : Attribute(7L, "Uncertainty")

      object MeasurementUnit : Attribute(8L, "MeasurementUnit")

      object MeasurementMedium : Attribute(9L, "MeasurementMedium")

      object LevelValue : Attribute(10L, "LevelValue")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1036L
  }

  object CarbonDioxideConcentrationMeasurement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MeasuredValue : Attribute(0L, "MeasuredValue")

      object MinMeasuredValue : Attribute(1L, "MinMeasuredValue")

      object MaxMeasuredValue : Attribute(2L, "MaxMeasuredValue")

      object PeakMeasuredValue : Attribute(3L, "PeakMeasuredValue")

      object PeakMeasuredValueWindow : Attribute(4L, "PeakMeasuredValueWindow")

      object AverageMeasuredValue : Attribute(5L, "AverageMeasuredValue")

      object AverageMeasuredValueWindow : Attribute(6L, "AverageMeasuredValueWindow")

      object Uncertainty : Attribute(7L, "Uncertainty")

      object MeasurementUnit : Attribute(8L, "MeasurementUnit")

      object MeasurementMedium : Attribute(9L, "MeasurementMedium")

      object LevelValue : Attribute(10L, "LevelValue")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1037L
  }

  object NitrogenDioxideConcentrationMeasurement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MeasuredValue : Attribute(0L, "MeasuredValue")

      object MinMeasuredValue : Attribute(1L, "MinMeasuredValue")

      object MaxMeasuredValue : Attribute(2L, "MaxMeasuredValue")

      object PeakMeasuredValue : Attribute(3L, "PeakMeasuredValue")

      object PeakMeasuredValueWindow : Attribute(4L, "PeakMeasuredValueWindow")

      object AverageMeasuredValue : Attribute(5L, "AverageMeasuredValue")

      object AverageMeasuredValueWindow : Attribute(6L, "AverageMeasuredValueWindow")

      object Uncertainty : Attribute(7L, "Uncertainty")

      object MeasurementUnit : Attribute(8L, "MeasurementUnit")

      object MeasurementMedium : Attribute(9L, "MeasurementMedium")

      object LevelValue : Attribute(10L, "LevelValue")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1043L
  }

  object OzoneConcentrationMeasurement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MeasuredValue : Attribute(0L, "MeasuredValue")

      object MinMeasuredValue : Attribute(1L, "MinMeasuredValue")

      object MaxMeasuredValue : Attribute(2L, "MaxMeasuredValue")

      object PeakMeasuredValue : Attribute(3L, "PeakMeasuredValue")

      object PeakMeasuredValueWindow : Attribute(4L, "PeakMeasuredValueWindow")

      object AverageMeasuredValue : Attribute(5L, "AverageMeasuredValue")

      object AverageMeasuredValueWindow : Attribute(6L, "AverageMeasuredValueWindow")

      object Uncertainty : Attribute(7L, "Uncertainty")

      object MeasurementUnit : Attribute(8L, "MeasurementUnit")

      object MeasurementMedium : Attribute(9L, "MeasurementMedium")

      object LevelValue : Attribute(10L, "LevelValue")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1045L
  }

  object Pm25ConcentrationMeasurement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MeasuredValue : Attribute(0L, "MeasuredValue")

      object MinMeasuredValue : Attribute(1L, "MinMeasuredValue")

      object MaxMeasuredValue : Attribute(2L, "MaxMeasuredValue")

      object PeakMeasuredValue : Attribute(3L, "PeakMeasuredValue")

      object PeakMeasuredValueWindow : Attribute(4L, "PeakMeasuredValueWindow")

      object AverageMeasuredValue : Attribute(5L, "AverageMeasuredValue")

      object AverageMeasuredValueWindow : Attribute(6L, "AverageMeasuredValueWindow")

      object Uncertainty : Attribute(7L, "Uncertainty")

      object MeasurementUnit : Attribute(8L, "MeasurementUnit")

      object MeasurementMedium : Attribute(9L, "MeasurementMedium")

      object LevelValue : Attribute(10L, "LevelValue")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1066L
  }

  object FormaldehydeConcentrationMeasurement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MeasuredValue : Attribute(0L, "MeasuredValue")

      object MinMeasuredValue : Attribute(1L, "MinMeasuredValue")

      object MaxMeasuredValue : Attribute(2L, "MaxMeasuredValue")

      object PeakMeasuredValue : Attribute(3L, "PeakMeasuredValue")

      object PeakMeasuredValueWindow : Attribute(4L, "PeakMeasuredValueWindow")

      object AverageMeasuredValue : Attribute(5L, "AverageMeasuredValue")

      object AverageMeasuredValueWindow : Attribute(6L, "AverageMeasuredValueWindow")

      object Uncertainty : Attribute(7L, "Uncertainty")

      object MeasurementUnit : Attribute(8L, "MeasurementUnit")

      object MeasurementMedium : Attribute(9L, "MeasurementMedium")

      object LevelValue : Attribute(10L, "LevelValue")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1067L
  }

  object Pm1ConcentrationMeasurement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MeasuredValue : Attribute(0L, "MeasuredValue")

      object MinMeasuredValue : Attribute(1L, "MinMeasuredValue")

      object MaxMeasuredValue : Attribute(2L, "MaxMeasuredValue")

      object PeakMeasuredValue : Attribute(3L, "PeakMeasuredValue")

      object PeakMeasuredValueWindow : Attribute(4L, "PeakMeasuredValueWindow")

      object AverageMeasuredValue : Attribute(5L, "AverageMeasuredValue")

      object AverageMeasuredValueWindow : Attribute(6L, "AverageMeasuredValueWindow")

      object Uncertainty : Attribute(7L, "Uncertainty")

      object MeasurementUnit : Attribute(8L, "MeasurementUnit")

      object MeasurementMedium : Attribute(9L, "MeasurementMedium")

      object LevelValue : Attribute(10L, "LevelValue")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1068L
  }

  object Pm10ConcentrationMeasurement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MeasuredValue : Attribute(0L, "MeasuredValue")

      object MinMeasuredValue : Attribute(1L, "MinMeasuredValue")

      object MaxMeasuredValue : Attribute(2L, "MaxMeasuredValue")

      object PeakMeasuredValue : Attribute(3L, "PeakMeasuredValue")

      object PeakMeasuredValueWindow : Attribute(4L, "PeakMeasuredValueWindow")

      object AverageMeasuredValue : Attribute(5L, "AverageMeasuredValue")

      object AverageMeasuredValueWindow : Attribute(6L, "AverageMeasuredValueWindow")

      object Uncertainty : Attribute(7L, "Uncertainty")

      object MeasurementUnit : Attribute(8L, "MeasurementUnit")

      object MeasurementMedium : Attribute(9L, "MeasurementMedium")

      object LevelValue : Attribute(10L, "LevelValue")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1069L
  }

  object TotalVolatileOrganicCompoundsConcentrationMeasurement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MeasuredValue : Attribute(0L, "MeasuredValue")

      object MinMeasuredValue : Attribute(1L, "MinMeasuredValue")

      object MaxMeasuredValue : Attribute(2L, "MaxMeasuredValue")

      object PeakMeasuredValue : Attribute(3L, "PeakMeasuredValue")

      object PeakMeasuredValueWindow : Attribute(4L, "PeakMeasuredValueWindow")

      object AverageMeasuredValue : Attribute(5L, "AverageMeasuredValue")

      object AverageMeasuredValueWindow : Attribute(6L, "AverageMeasuredValueWindow")

      object Uncertainty : Attribute(7L, "Uncertainty")

      object MeasurementUnit : Attribute(8L, "MeasurementUnit")

      object MeasurementMedium : Attribute(9L, "MeasurementMedium")

      object LevelValue : Attribute(10L, "LevelValue")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1070L
  }

  object RadonConcentrationMeasurement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MeasuredValue : Attribute(0L, "MeasuredValue")

      object MinMeasuredValue : Attribute(1L, "MinMeasuredValue")

      object MaxMeasuredValue : Attribute(2L, "MaxMeasuredValue")

      object PeakMeasuredValue : Attribute(3L, "PeakMeasuredValue")

      object PeakMeasuredValueWindow : Attribute(4L, "PeakMeasuredValueWindow")

      object AverageMeasuredValue : Attribute(5L, "AverageMeasuredValue")

      object AverageMeasuredValueWindow : Attribute(6L, "AverageMeasuredValueWindow")

      object Uncertainty : Attribute(7L, "Uncertainty")

      object MeasurementUnit : Attribute(8L, "MeasurementUnit")

      object MeasurementMedium : Attribute(9L, "MeasurementMedium")

      object LevelValue : Attribute(10L, "LevelValue")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1071L
  }

  object WakeOnLan : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MACAddress : Attribute(0L, "MACAddress")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1283L
  }

  object Channel : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object ChannelList : Attribute(0L, "ChannelList")

      object Lineup : Attribute(1L, "Lineup")

      object CurrentChannel : Attribute(2L, "CurrentChannel")

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

    enum class Command(val id: Long) {
      ChangeChannel(0L),
      ChangeChannelByNumber(2L),
      SkipChannel(3L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ChangeChannelCommandField(val id: Int) {
      Match(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ChangeChannelCommandField {
          for (field in ChangeChannelCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class ChangeChannelByNumberCommandField(val id: Int) {
      MajorNumber(0),
      MinorNumber(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): ChangeChannelByNumberCommandField {
          for (field in ChangeChannelByNumberCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SkipChannelCommandField(val id: Int) {
      Count(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SkipChannelCommandField {
          for (field in SkipChannelCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 1284L
  }

  object TargetNavigator : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object TargetList : Attribute(0L, "TargetList")

      object CurrentTarget : Attribute(1L, "CurrentTarget")

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

    enum class Command(val id: Long) {
      NavigateTarget(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class NavigateTargetCommandField(val id: Int) {
      Target(0),
      Data(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): NavigateTargetCommandField {
          for (field in NavigateTargetCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 1285L
  }

  object MediaPlayback : ClusterIDMapping() {
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

    enum class Command(val id: Long) {
      Play(0L),
      Pause(1L),
      Stop(2L),
      StartOver(3L),
      Previous(4L),
      Next(5L),
      Rewind(6L),
      FastForward(7L),
      SkipForward(8L),
      SkipBackward(9L),
      Seek(11L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SkipForwardCommandField(val id: Int) {
      DeltaPositionMilliseconds(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SkipForwardCommandField {
          for (field in SkipForwardCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SkipBackwardCommandField(val id: Int) {
      DeltaPositionMilliseconds(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SkipBackwardCommandField {
          for (field in SkipBackwardCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SeekCommandField(val id: Int) {
      Position(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SeekCommandField {
          for (field in SeekCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 1286L
  }

  object MediaInput : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object InputList : Attribute(0L, "InputList")

      object CurrentInput : Attribute(1L, "CurrentInput")

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

    enum class Command(val id: Long) {
      SelectInput(0L),
      ShowInputStatus(1L),
      HideInputStatus(2L),
      RenameInput(3L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SelectInputCommandField(val id: Int) {
      Index(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SelectInputCommandField {
          for (field in SelectInputCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class RenameInputCommandField(val id: Int) {
      Index(0),
      Name(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): RenameInputCommandField {
          for (field in RenameInputCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 1287L
  }

  object LowPower : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
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

    enum class Command(val id: Long) {
      Sleep(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 1288L
  }

  object KeypadInput : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
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

    enum class Command(val id: Long) {
      SendKey(0L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SendKeyCommandField(val id: Int) {
      KeyCode(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SendKeyCommandField {
          for (field in SendKeyCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 1289L
  }

  object ContentLauncher : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object AcceptHeader : Attribute(0L, "AcceptHeader")

      object SupportedStreamingProtocols : Attribute(1L, "SupportedStreamingProtocols")

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

    enum class Command(val id: Long) {
      LaunchContent(0L),
      LaunchURL(1L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class LaunchContentCommandField(val id: Int) {
      Search(0),
      AutoPlay(1),
      Data(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): LaunchContentCommandField {
          for (field in LaunchContentCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class LaunchURLCommandField(val id: Int) {
      ContentURL(0),
      DisplayString(1),
      BrandingInformation(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): LaunchURLCommandField {
          for (field in LaunchURLCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 1290L
  }

  object AudioOutput : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object OutputList : Attribute(0L, "OutputList")

      object CurrentOutput : Attribute(1L, "CurrentOutput")

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

    enum class Command(val id: Long) {
      SelectOutput(0L),
      RenameOutput(1L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SelectOutputCommandField(val id: Int) {
      Index(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SelectOutputCommandField {
          for (field in SelectOutputCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class RenameOutputCommandField(val id: Int) {
      Index(0),
      Name(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): RenameOutputCommandField {
          for (field in RenameOutputCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 1291L
  }

  object ApplicationLauncher : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object CatalogList : Attribute(0L, "CatalogList")

      object CurrentApp : Attribute(1L, "CurrentApp")

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

    enum class Command(val id: Long) {
      LaunchApp(0L),
      StopApp(1L),
      HideApp(2L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class LaunchAppCommandField(val id: Int) {
      Application(0),
      Data(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): LaunchAppCommandField {
          for (field in LaunchAppCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class StopAppCommandField(val id: Int) {
      Application(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): StopAppCommandField {
          for (field in StopAppCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class HideAppCommandField(val id: Int) {
      Application(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): HideAppCommandField {
          for (field in HideAppCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 1292L
  }

  object ApplicationBasic : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object VendorName : Attribute(0L, "VendorName")

      object VendorID : Attribute(1L, "VendorID")

      object ApplicationName : Attribute(2L, "ApplicationName")

      object ProductID : Attribute(3L, "ProductID")

      object Application : Attribute(4L, "Application")

      object Status : Attribute(5L, "Status")

      object ApplicationVersion : Attribute(6L, "ApplicationVersion")

      object AllowedVendorList : Attribute(7L, "AllowedVendorList")

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

    override fun getID(): Long {
      return ID
    }

    override fun getAttributeName(id: Long): String {
      return Attribute.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    const val ID = 1293L
  }

  object AccountLogin : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
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

    enum class Command(val id: Long) {
      GetSetupPIN(0L),
      Login(2L),
      Logout(3L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class GetSetupPINCommandField(val id: Int) {
      TempAccountIdentifier(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): GetSetupPINCommandField {
          for (field in GetSetupPINCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class LoginCommandField(val id: Int) {
      TempAccountIdentifier(0),
      SetupPIN(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): LoginCommandField {
          for (field in LoginCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 1294L
  }

  object ElectricalMeasurement : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object MeasurementType : Attribute(0L, "MeasurementType")

      object DcVoltage : Attribute(256L, "DcVoltage")

      object DcVoltageMin : Attribute(257L, "DcVoltageMin")

      object DcVoltageMax : Attribute(258L, "DcVoltageMax")

      object DcCurrent : Attribute(259L, "DcCurrent")

      object DcCurrentMin : Attribute(260L, "DcCurrentMin")

      object DcCurrentMax : Attribute(261L, "DcCurrentMax")

      object DcPower : Attribute(262L, "DcPower")

      object DcPowerMin : Attribute(263L, "DcPowerMin")

      object DcPowerMax : Attribute(264L, "DcPowerMax")

      object DcVoltageMultiplier : Attribute(512L, "DcVoltageMultiplier")

      object DcVoltageDivisor : Attribute(513L, "DcVoltageDivisor")

      object DcCurrentMultiplier : Attribute(514L, "DcCurrentMultiplier")

      object DcCurrentDivisor : Attribute(515L, "DcCurrentDivisor")

      object DcPowerMultiplier : Attribute(516L, "DcPowerMultiplier")

      object DcPowerDivisor : Attribute(517L, "DcPowerDivisor")

      object AcFrequency : Attribute(768L, "AcFrequency")

      object AcFrequencyMin : Attribute(769L, "AcFrequencyMin")

      object AcFrequencyMax : Attribute(770L, "AcFrequencyMax")

      object NeutralCurrent : Attribute(771L, "NeutralCurrent")

      object TotalActivePower : Attribute(772L, "TotalActivePower")

      object TotalReactivePower : Attribute(773L, "TotalReactivePower")

      object TotalApparentPower : Attribute(774L, "TotalApparentPower")

      object Measured1stHarmonicCurrent : Attribute(775L, "Measured1stHarmonicCurrent")

      object Measured3rdHarmonicCurrent : Attribute(776L, "Measured3rdHarmonicCurrent")

      object Measured5thHarmonicCurrent : Attribute(777L, "Measured5thHarmonicCurrent")

      object Measured7thHarmonicCurrent : Attribute(778L, "Measured7thHarmonicCurrent")

      object Measured9thHarmonicCurrent : Attribute(779L, "Measured9thHarmonicCurrent")

      object Measured11thHarmonicCurrent : Attribute(780L, "Measured11thHarmonicCurrent")

      object MeasuredPhase1stHarmonicCurrent : Attribute(781L, "MeasuredPhase1stHarmonicCurrent")

      object MeasuredPhase3rdHarmonicCurrent : Attribute(782L, "MeasuredPhase3rdHarmonicCurrent")

      object MeasuredPhase5thHarmonicCurrent : Attribute(783L, "MeasuredPhase5thHarmonicCurrent")

      object MeasuredPhase7thHarmonicCurrent : Attribute(784L, "MeasuredPhase7thHarmonicCurrent")

      object MeasuredPhase9thHarmonicCurrent : Attribute(785L, "MeasuredPhase9thHarmonicCurrent")

      object MeasuredPhase11thHarmonicCurrent : Attribute(786L, "MeasuredPhase11thHarmonicCurrent")

      object AcFrequencyMultiplier : Attribute(1024L, "AcFrequencyMultiplier")

      object AcFrequencyDivisor : Attribute(1025L, "AcFrequencyDivisor")

      object PowerMultiplier : Attribute(1026L, "PowerMultiplier")

      object PowerDivisor : Attribute(1027L, "PowerDivisor")

      object HarmonicCurrentMultiplier : Attribute(1028L, "HarmonicCurrentMultiplier")

      object PhaseHarmonicCurrentMultiplier : Attribute(1029L, "PhaseHarmonicCurrentMultiplier")

      object InstantaneousVoltage : Attribute(1280L, "InstantaneousVoltage")

      object InstantaneousLineCurrent : Attribute(1281L, "InstantaneousLineCurrent")

      object InstantaneousActiveCurrent : Attribute(1282L, "InstantaneousActiveCurrent")

      object InstantaneousReactiveCurrent : Attribute(1283L, "InstantaneousReactiveCurrent")

      object InstantaneousPower : Attribute(1284L, "InstantaneousPower")

      object RmsVoltage : Attribute(1285L, "RmsVoltage")

      object RmsVoltageMin : Attribute(1286L, "RmsVoltageMin")

      object RmsVoltageMax : Attribute(1287L, "RmsVoltageMax")

      object RmsCurrent : Attribute(1288L, "RmsCurrent")

      object RmsCurrentMin : Attribute(1289L, "RmsCurrentMin")

      object RmsCurrentMax : Attribute(1290L, "RmsCurrentMax")

      object ActivePower : Attribute(1291L, "ActivePower")

      object ActivePowerMin : Attribute(1292L, "ActivePowerMin")

      object ActivePowerMax : Attribute(1293L, "ActivePowerMax")

      object ReactivePower : Attribute(1294L, "ReactivePower")

      object ApparentPower : Attribute(1295L, "ApparentPower")

      object PowerFactor : Attribute(1296L, "PowerFactor")

      object AverageRmsVoltageMeasurementPeriod :
        Attribute(1297L, "AverageRmsVoltageMeasurementPeriod")

      object AverageRmsUnderVoltageCounter : Attribute(1299L, "AverageRmsUnderVoltageCounter")

      object RmsExtremeOverVoltagePeriod : Attribute(1300L, "RmsExtremeOverVoltagePeriod")

      object RmsExtremeUnderVoltagePeriod : Attribute(1301L, "RmsExtremeUnderVoltagePeriod")

      object RmsVoltageSagPeriod : Attribute(1302L, "RmsVoltageSagPeriod")

      object RmsVoltageSwellPeriod : Attribute(1303L, "RmsVoltageSwellPeriod")

      object AcVoltageMultiplier : Attribute(1536L, "AcVoltageMultiplier")

      object AcVoltageDivisor : Attribute(1537L, "AcVoltageDivisor")

      object AcCurrentMultiplier : Attribute(1538L, "AcCurrentMultiplier")

      object AcCurrentDivisor : Attribute(1539L, "AcCurrentDivisor")

      object AcPowerMultiplier : Attribute(1540L, "AcPowerMultiplier")

      object AcPowerDivisor : Attribute(1541L, "AcPowerDivisor")

      object OverloadAlarmsMask : Attribute(1792L, "OverloadAlarmsMask")

      object VoltageOverload : Attribute(1793L, "VoltageOverload")

      object CurrentOverload : Attribute(1794L, "CurrentOverload")

      object AcOverloadAlarmsMask : Attribute(2048L, "AcOverloadAlarmsMask")

      object AcVoltageOverload : Attribute(2049L, "AcVoltageOverload")

      object AcCurrentOverload : Attribute(2050L, "AcCurrentOverload")

      object AcActivePowerOverload : Attribute(2051L, "AcActivePowerOverload")

      object AcReactivePowerOverload : Attribute(2052L, "AcReactivePowerOverload")

      object AverageRmsOverVoltage : Attribute(2053L, "AverageRmsOverVoltage")

      object AverageRmsUnderVoltage : Attribute(2054L, "AverageRmsUnderVoltage")

      object RmsExtremeOverVoltage : Attribute(2055L, "RmsExtremeOverVoltage")

      object RmsExtremeUnderVoltage : Attribute(2056L, "RmsExtremeUnderVoltage")

      object RmsVoltageSag : Attribute(2057L, "RmsVoltageSag")

      object RmsVoltageSwell : Attribute(2058L, "RmsVoltageSwell")

      object LineCurrentPhaseB : Attribute(2305L, "LineCurrentPhaseB")

      object ActiveCurrentPhaseB : Attribute(2306L, "ActiveCurrentPhaseB")

      object ReactiveCurrentPhaseB : Attribute(2307L, "ReactiveCurrentPhaseB")

      object RmsVoltagePhaseB : Attribute(2309L, "RmsVoltagePhaseB")

      object RmsVoltageMinPhaseB : Attribute(2310L, "RmsVoltageMinPhaseB")

      object RmsVoltageMaxPhaseB : Attribute(2311L, "RmsVoltageMaxPhaseB")

      object RmsCurrentPhaseB : Attribute(2312L, "RmsCurrentPhaseB")

      object RmsCurrentMinPhaseB : Attribute(2313L, "RmsCurrentMinPhaseB")

      object RmsCurrentMaxPhaseB : Attribute(2314L, "RmsCurrentMaxPhaseB")

      object ActivePowerPhaseB : Attribute(2315L, "ActivePowerPhaseB")

      object ActivePowerMinPhaseB : Attribute(2316L, "ActivePowerMinPhaseB")

      object ActivePowerMaxPhaseB : Attribute(2317L, "ActivePowerMaxPhaseB")

      object ReactivePowerPhaseB : Attribute(2318L, "ReactivePowerPhaseB")

      object ApparentPowerPhaseB : Attribute(2319L, "ApparentPowerPhaseB")

      object PowerFactorPhaseB : Attribute(2320L, "PowerFactorPhaseB")

      object AverageRmsVoltageMeasurementPeriodPhaseB :
        Attribute(2321L, "AverageRmsVoltageMeasurementPeriodPhaseB")

      object AverageRmsOverVoltageCounterPhaseB :
        Attribute(2322L, "AverageRmsOverVoltageCounterPhaseB")

      object AverageRmsUnderVoltageCounterPhaseB :
        Attribute(2323L, "AverageRmsUnderVoltageCounterPhaseB")

      object RmsExtremeOverVoltagePeriodPhaseB :
        Attribute(2324L, "RmsExtremeOverVoltagePeriodPhaseB")

      object RmsExtremeUnderVoltagePeriodPhaseB :
        Attribute(2325L, "RmsExtremeUnderVoltagePeriodPhaseB")

      object RmsVoltageSagPeriodPhaseB : Attribute(2326L, "RmsVoltageSagPeriodPhaseB")

      object RmsVoltageSwellPeriodPhaseB : Attribute(2327L, "RmsVoltageSwellPeriodPhaseB")

      object LineCurrentPhaseC : Attribute(2561L, "LineCurrentPhaseC")

      object ActiveCurrentPhaseC : Attribute(2562L, "ActiveCurrentPhaseC")

      object ReactiveCurrentPhaseC : Attribute(2563L, "ReactiveCurrentPhaseC")

      object RmsVoltagePhaseC : Attribute(2565L, "RmsVoltagePhaseC")

      object RmsVoltageMinPhaseC : Attribute(2566L, "RmsVoltageMinPhaseC")

      object RmsVoltageMaxPhaseC : Attribute(2567L, "RmsVoltageMaxPhaseC")

      object RmsCurrentPhaseC : Attribute(2568L, "RmsCurrentPhaseC")

      object RmsCurrentMinPhaseC : Attribute(2569L, "RmsCurrentMinPhaseC")

      object RmsCurrentMaxPhaseC : Attribute(2570L, "RmsCurrentMaxPhaseC")

      object ActivePowerPhaseC : Attribute(2571L, "ActivePowerPhaseC")

      object ActivePowerMinPhaseC : Attribute(2572L, "ActivePowerMinPhaseC")

      object ActivePowerMaxPhaseC : Attribute(2573L, "ActivePowerMaxPhaseC")

      object ReactivePowerPhaseC : Attribute(2574L, "ReactivePowerPhaseC")

      object ApparentPowerPhaseC : Attribute(2575L, "ApparentPowerPhaseC")

      object PowerFactorPhaseC : Attribute(2576L, "PowerFactorPhaseC")

      object AverageRmsVoltageMeasurementPeriodPhaseC :
        Attribute(2577L, "AverageRmsVoltageMeasurementPeriodPhaseC")

      object AverageRmsOverVoltageCounterPhaseC :
        Attribute(2578L, "AverageRmsOverVoltageCounterPhaseC")

      object AverageRmsUnderVoltageCounterPhaseC :
        Attribute(2579L, "AverageRmsUnderVoltageCounterPhaseC")

      object RmsExtremeOverVoltagePeriodPhaseC :
        Attribute(2580L, "RmsExtremeOverVoltagePeriodPhaseC")

      object RmsExtremeUnderVoltagePeriodPhaseC :
        Attribute(2581L, "RmsExtremeUnderVoltagePeriodPhaseC")

      object RmsVoltageSagPeriodPhaseC : Attribute(2582L, "RmsVoltageSagPeriodPhaseC")

      object RmsVoltageSwellPeriodPhaseC : Attribute(2583L, "RmsVoltageSwellPeriodPhaseC")

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

    enum class Command(val id: Long) {
      GetProfileInfoCommand(0L),
      GetMeasurementProfileCommand(1L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class GetMeasurementProfileCommandCommandField(val id: Int) {
      AttributeId(0),
      StartTime(1),
      NumberOfIntervals(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): GetMeasurementProfileCommandCommandField {
          for (field in GetMeasurementProfileCommandCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 2820L
  }

  object UnitTesting : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
      object Boolean : Attribute(0L, "Boolean")

      object Bitmap8 : Attribute(1L, "Bitmap8")

      object Bitmap16 : Attribute(2L, "Bitmap16")

      object Bitmap32 : Attribute(3L, "Bitmap32")

      object Bitmap64 : Attribute(4L, "Bitmap64")

      object Int8u : Attribute(5L, "Int8u")

      object Int16u : Attribute(6L, "Int16u")

      object Int24u : Attribute(7L, "Int24u")

      object Int32u : Attribute(8L, "Int32u")

      object Int40u : Attribute(9L, "Int40u")

      object Int48u : Attribute(10L, "Int48u")

      object Int56u : Attribute(11L, "Int56u")

      object Int64u : Attribute(12L, "Int64u")

      object Int8s : Attribute(13L, "Int8s")

      object Int16s : Attribute(14L, "Int16s")

      object Int24s : Attribute(15L, "Int24s")

      object Int32s : Attribute(16L, "Int32s")

      object Int40s : Attribute(17L, "Int40s")

      object Int48s : Attribute(18L, "Int48s")

      object Int56s : Attribute(19L, "Int56s")

      object Int64s : Attribute(20L, "Int64s")

      object Enum8 : Attribute(21L, "Enum8")

      object Enum16 : Attribute(22L, "Enum16")

      object FloatSingle : Attribute(23L, "FloatSingle")

      object FloatDouble : Attribute(24L, "FloatDouble")

      object OctetString : Attribute(25L, "OctetString")

      object ListInt8u : Attribute(26L, "ListInt8u")

      object ListOctetString : Attribute(27L, "ListOctetString")

      object ListStructOctetString : Attribute(28L, "ListStructOctetString")

      object LongOctetString : Attribute(29L, "LongOctetString")

      object CharString : Attribute(30L, "CharString")

      object LongCharString : Attribute(31L, "LongCharString")

      object EpochUs : Attribute(32L, "EpochUs")

      object EpochS : Attribute(33L, "EpochS")

      object VendorId : Attribute(34L, "VendorId")

      object ListNullablesAndOptionalsStruct : Attribute(35L, "ListNullablesAndOptionalsStruct")

      object EnumAttr : Attribute(36L, "EnumAttr")

      object StructAttr : Attribute(37L, "StructAttr")

      object RangeRestrictedInt8u : Attribute(38L, "RangeRestrictedInt8u")

      object RangeRestrictedInt8s : Attribute(39L, "RangeRestrictedInt8s")

      object RangeRestrictedInt16u : Attribute(40L, "RangeRestrictedInt16u")

      object RangeRestrictedInt16s : Attribute(41L, "RangeRestrictedInt16s")

      object ListLongOctetString : Attribute(42L, "ListLongOctetString")

      object ListFabricScoped : Attribute(43L, "ListFabricScoped")

      object TimedWriteBoolean : Attribute(48L, "TimedWriteBoolean")

      object GeneralErrorBoolean : Attribute(49L, "GeneralErrorBoolean")

      object ClusterErrorBoolean : Attribute(50L, "ClusterErrorBoolean")

      object Unsupported : Attribute(255L, "Unsupported")

      object NullableBoolean : Attribute(16384L, "NullableBoolean")

      object NullableBitmap8 : Attribute(16385L, "NullableBitmap8")

      object NullableBitmap16 : Attribute(16386L, "NullableBitmap16")

      object NullableBitmap32 : Attribute(16387L, "NullableBitmap32")

      object NullableBitmap64 : Attribute(16388L, "NullableBitmap64")

      object NullableInt8u : Attribute(16389L, "NullableInt8u")

      object NullableInt16u : Attribute(16390L, "NullableInt16u")

      object NullableInt24u : Attribute(16391L, "NullableInt24u")

      object NullableInt32u : Attribute(16392L, "NullableInt32u")

      object NullableInt40u : Attribute(16393L, "NullableInt40u")

      object NullableInt48u : Attribute(16394L, "NullableInt48u")

      object NullableInt56u : Attribute(16395L, "NullableInt56u")

      object NullableInt64u : Attribute(16396L, "NullableInt64u")

      object NullableInt8s : Attribute(16397L, "NullableInt8s")

      object NullableInt16s : Attribute(16398L, "NullableInt16s")

      object NullableInt24s : Attribute(16399L, "NullableInt24s")

      object NullableInt32s : Attribute(16400L, "NullableInt32s")

      object NullableInt40s : Attribute(16401L, "NullableInt40s")

      object NullableInt48s : Attribute(16402L, "NullableInt48s")

      object NullableInt56s : Attribute(16403L, "NullableInt56s")

      object NullableInt64s : Attribute(16404L, "NullableInt64s")

      object NullableEnum8 : Attribute(16405L, "NullableEnum8")

      object NullableEnum16 : Attribute(16406L, "NullableEnum16")

      object NullableFloatSingle : Attribute(16407L, "NullableFloatSingle")

      object NullableFloatDouble : Attribute(16408L, "NullableFloatDouble")

      object NullableOctetString : Attribute(16409L, "NullableOctetString")

      object NullableCharString : Attribute(16414L, "NullableCharString")

      object NullableEnumAttr : Attribute(16420L, "NullableEnumAttr")

      object NullableStruct : Attribute(16421L, "NullableStruct")

      object NullableRangeRestrictedInt8u : Attribute(16422L, "NullableRangeRestrictedInt8u")

      object NullableRangeRestrictedInt8s : Attribute(16423L, "NullableRangeRestrictedInt8s")

      object NullableRangeRestrictedInt16u : Attribute(16424L, "NullableRangeRestrictedInt16u")

      object NullableRangeRestrictedInt16s : Attribute(16425L, "NullableRangeRestrictedInt16s")

      object WriteOnlyInt8u : Attribute(16426L, "WriteOnlyInt8u")

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

    enum class Event(val id: Long) {
      TestEvent(1L),
      TestFabricScopedEvent(2L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Event {
          for (event in Event.values()) {
            if (event.id == id) {
              return event
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class Command(val id: Long) {
      Test(0L),
      TestNotHandled(1L),
      TestSpecific(2L),
      TestUnknownCommand(3L),
      TestAddArguments(4L),
      TestSimpleArgumentRequest(5L),
      TestStructArrayArgumentRequest(6L),
      TestStructArgumentRequest(7L),
      TestNestedStructArgumentRequest(8L),
      TestListStructArgumentRequest(9L),
      TestListInt8UArgumentRequest(10L),
      TestNestedStructListArgumentRequest(11L),
      TestListNestedStructListArgumentRequest(12L),
      TestListInt8UReverseRequest(13L),
      TestEnumsRequest(14L),
      TestNullableOptionalRequest(15L),
      TestComplexNullableOptionalRequest(16L),
      SimpleStructEchoRequest(17L),
      TimedInvokeRequest(18L),
      TestSimpleOptionalArgumentRequest(19L),
      TestEmitTestEventRequest(20L),
      TestEmitTestFabricScopedEventRequest(21L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TestAddArgumentsCommandField(val id: Int) {
      Arg1(0),
      Arg2(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TestAddArgumentsCommandField {
          for (field in TestAddArgumentsCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TestSimpleArgumentRequestCommandField(val id: Int) {
      Arg1(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TestSimpleArgumentRequestCommandField {
          for (field in TestSimpleArgumentRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TestStructArrayArgumentRequestCommandField(val id: Int) {
      Arg1(0),
      Arg2(1),
      Arg3(2),
      Arg4(3),
      Arg5(4),
      Arg6(5);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TestStructArrayArgumentRequestCommandField {
          for (field in TestStructArrayArgumentRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TestStructArgumentRequestCommandField(val id: Int) {
      Arg1(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TestStructArgumentRequestCommandField {
          for (field in TestStructArgumentRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TestNestedStructArgumentRequestCommandField(val id: Int) {
      Arg1(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TestNestedStructArgumentRequestCommandField {
          for (field in TestNestedStructArgumentRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TestListStructArgumentRequestCommandField(val id: Int) {
      Arg1(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TestListStructArgumentRequestCommandField {
          for (field in TestListStructArgumentRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TestListInt8UArgumentRequestCommandField(val id: Int) {
      Arg1(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TestListInt8UArgumentRequestCommandField {
          for (field in TestListInt8UArgumentRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TestNestedStructListArgumentRequestCommandField(val id: Int) {
      Arg1(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TestNestedStructListArgumentRequestCommandField {
          for (field in TestNestedStructListArgumentRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TestListNestedStructListArgumentRequestCommandField(val id: Int) {
      Arg1(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TestListNestedStructListArgumentRequestCommandField {
          for (field in TestListNestedStructListArgumentRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TestListInt8UReverseRequestCommandField(val id: Int) {
      Arg1(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TestListInt8UReverseRequestCommandField {
          for (field in TestListInt8UReverseRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TestEnumsRequestCommandField(val id: Int) {
      Arg1(0),
      Arg2(1);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TestEnumsRequestCommandField {
          for (field in TestEnumsRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TestNullableOptionalRequestCommandField(val id: Int) {
      Arg1(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TestNullableOptionalRequestCommandField {
          for (field in TestNullableOptionalRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TestComplexNullableOptionalRequestCommandField(val id: Int) {
      NullableInt(0),
      OptionalInt(1),
      NullableOptionalInt(2),
      NullableString(3),
      OptionalString(4),
      NullableOptionalString(5),
      NullableStruct(6),
      OptionalStruct(7),
      NullableOptionalStruct(8),
      NullableList(9),
      OptionalList(10),
      NullableOptionalList(11);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TestComplexNullableOptionalRequestCommandField {
          for (field in TestComplexNullableOptionalRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class SimpleStructEchoRequestCommandField(val id: Int) {
      Arg1(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): SimpleStructEchoRequestCommandField {
          for (field in SimpleStructEchoRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TestSimpleOptionalArgumentRequestCommandField(val id: Int) {
      Arg1(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TestSimpleOptionalArgumentRequestCommandField {
          for (field in TestSimpleOptionalArgumentRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TestEmitTestEventRequestCommandField(val id: Int) {
      Arg1(0),
      Arg2(1),
      Arg3(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TestEmitTestEventRequestCommandField {
          for (field in TestEmitTestEventRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class TestEmitTestFabricScopedEventRequestCommandField(val id: Int) {
      Arg1(0);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): TestEmitTestFabricScopedEventRequestCommandField {
          for (field in TestEmitTestFabricScopedEventRequestCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 4294048773L
  }

  object FaultInjection : ClusterIDMapping() {
    sealed class Attribute(val id: Long, val name: String) {
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

    enum class Command(val id: Long) {
      FailAtFault(0L),
      FailRandomlyAtFault(1L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Command {
          for (command in Command.values()) {
            if (command.id == id) {
              return command
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class FailAtFaultCommandField(val id: Int) {
      Type(0),
      Id(1),
      NumCallsToSkip(2),
      NumCallsToFail(3),
      TakeMutex(4);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): FailAtFaultCommandField {
          for (field in FailAtFaultCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
        }
      }
    }

    enum class FailRandomlyAtFaultCommandField(val id: Int) {
      Type(0),
      Id(1),
      Percentage(2);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Int): FailRandomlyAtFaultCommandField {
          for (field in FailRandomlyAtFaultCommandField.values()) {
            if (field.id == id) {
              return field
            }
          }
          throw NoSuchFieldError()
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

    const val ID = 4294048774L
  }

  companion object {
    fun getCluster(clusterId: Long): ClusterIDMapping? {
      if (clusterId == Identify.ID) {
        return Identify
      }
      if (clusterId == Groups.ID) {
        return Groups
      }
      if (clusterId == Scenes.ID) {
        return Scenes
      }
      if (clusterId == OnOff.ID) {
        return OnOff
      }
      if (clusterId == OnOffSwitchConfiguration.ID) {
        return OnOffSwitchConfiguration
      }
      if (clusterId == LevelControl.ID) {
        return LevelControl
      }
      if (clusterId == BinaryInputBasic.ID) {
        return BinaryInputBasic
      }
      if (clusterId == PulseWidthModulation.ID) {
        return PulseWidthModulation
      }
      if (clusterId == Descriptor.ID) {
        return Descriptor
      }
      if (clusterId == Binding.ID) {
        return Binding
      }
      if (clusterId == AccessControl.ID) {
        return AccessControl
      }
      if (clusterId == Actions.ID) {
        return Actions
      }
      if (clusterId == BasicInformation.ID) {
        return BasicInformation
      }
      if (clusterId == OtaSoftwareUpdateProvider.ID) {
        return OtaSoftwareUpdateProvider
      }
      if (clusterId == OtaSoftwareUpdateRequestor.ID) {
        return OtaSoftwareUpdateRequestor
      }
      if (clusterId == LocalizationConfiguration.ID) {
        return LocalizationConfiguration
      }
      if (clusterId == TimeFormatLocalization.ID) {
        return TimeFormatLocalization
      }
      if (clusterId == UnitLocalization.ID) {
        return UnitLocalization
      }
      if (clusterId == PowerSourceConfiguration.ID) {
        return PowerSourceConfiguration
      }
      if (clusterId == PowerSource.ID) {
        return PowerSource
      }
      if (clusterId == GeneralCommissioning.ID) {
        return GeneralCommissioning
      }
      if (clusterId == NetworkCommissioning.ID) {
        return NetworkCommissioning
      }
      if (clusterId == DiagnosticLogs.ID) {
        return DiagnosticLogs
      }
      if (clusterId == GeneralDiagnostics.ID) {
        return GeneralDiagnostics
      }
      if (clusterId == SoftwareDiagnostics.ID) {
        return SoftwareDiagnostics
      }
      if (clusterId == ThreadNetworkDiagnostics.ID) {
        return ThreadNetworkDiagnostics
      }
      if (clusterId == WiFiNetworkDiagnostics.ID) {
        return WiFiNetworkDiagnostics
      }
      if (clusterId == EthernetNetworkDiagnostics.ID) {
        return EthernetNetworkDiagnostics
      }
      if (clusterId == TimeSynchronization.ID) {
        return TimeSynchronization
      }
      if (clusterId == BridgedDeviceBasicInformation.ID) {
        return BridgedDeviceBasicInformation
      }
      if (clusterId == Switch.ID) {
        return Switch
      }
      if (clusterId == AdministratorCommissioning.ID) {
        return AdministratorCommissioning
      }
      if (clusterId == OperationalCredentials.ID) {
        return OperationalCredentials
      }
      if (clusterId == GroupKeyManagement.ID) {
        return GroupKeyManagement
      }
      if (clusterId == FixedLabel.ID) {
        return FixedLabel
      }
      if (clusterId == UserLabel.ID) {
        return UserLabel
      }
      if (clusterId == ProxyConfiguration.ID) {
        return ProxyConfiguration
      }
      if (clusterId == ProxyDiscovery.ID) {
        return ProxyDiscovery
      }
      if (clusterId == ProxyValid.ID) {
        return ProxyValid
      }
      if (clusterId == BooleanState.ID) {
        return BooleanState
      }
      if (clusterId == IcdManagement.ID) {
        return IcdManagement
      }
      if (clusterId == ModeSelect.ID) {
        return ModeSelect
      }
      if (clusterId == LaundryWasherMode.ID) {
        return LaundryWasherMode
      }
      if (clusterId == RefrigeratorAndTemperatureControlledCabinetMode.ID) {
        return RefrigeratorAndTemperatureControlledCabinetMode
      }
      if (clusterId == LaundryWasherControls.ID) {
        return LaundryWasherControls
      }
      if (clusterId == RvcRunMode.ID) {
        return RvcRunMode
      }
      if (clusterId == RvcCleanMode.ID) {
        return RvcCleanMode
      }
      if (clusterId == TemperatureControl.ID) {
        return TemperatureControl
      }
      if (clusterId == RefrigeratorAlarm.ID) {
        return RefrigeratorAlarm
      }
      if (clusterId == DishwasherMode.ID) {
        return DishwasherMode
      }
      if (clusterId == AirQuality.ID) {
        return AirQuality
      }
      if (clusterId == SmokeCoAlarm.ID) {
        return SmokeCoAlarm
      }
      if (clusterId == DishwasherAlarm.ID) {
        return DishwasherAlarm
      }
      if (clusterId == OperationalState.ID) {
        return OperationalState
      }
      if (clusterId == RvcOperationalState.ID) {
        return RvcOperationalState
      }
      if (clusterId == HepaFilterMonitoring.ID) {
        return HepaFilterMonitoring
      }
      if (clusterId == ActivatedCarbonFilterMonitoring.ID) {
        return ActivatedCarbonFilterMonitoring
      }
      if (clusterId == DoorLock.ID) {
        return DoorLock
      }
      if (clusterId == WindowCovering.ID) {
        return WindowCovering
      }
      if (clusterId == BarrierControl.ID) {
        return BarrierControl
      }
      if (clusterId == PumpConfigurationAndControl.ID) {
        return PumpConfigurationAndControl
      }
      if (clusterId == Thermostat.ID) {
        return Thermostat
      }
      if (clusterId == FanControl.ID) {
        return FanControl
      }
      if (clusterId == ThermostatUserInterfaceConfiguration.ID) {
        return ThermostatUserInterfaceConfiguration
      }
      if (clusterId == ColorControl.ID) {
        return ColorControl
      }
      if (clusterId == BallastConfiguration.ID) {
        return BallastConfiguration
      }
      if (clusterId == IlluminanceMeasurement.ID) {
        return IlluminanceMeasurement
      }
      if (clusterId == TemperatureMeasurement.ID) {
        return TemperatureMeasurement
      }
      if (clusterId == PressureMeasurement.ID) {
        return PressureMeasurement
      }
      if (clusterId == FlowMeasurement.ID) {
        return FlowMeasurement
      }
      if (clusterId == RelativeHumidityMeasurement.ID) {
        return RelativeHumidityMeasurement
      }
      if (clusterId == OccupancySensing.ID) {
        return OccupancySensing
      }
      if (clusterId == CarbonMonoxideConcentrationMeasurement.ID) {
        return CarbonMonoxideConcentrationMeasurement
      }
      if (clusterId == CarbonDioxideConcentrationMeasurement.ID) {
        return CarbonDioxideConcentrationMeasurement
      }
      if (clusterId == NitrogenDioxideConcentrationMeasurement.ID) {
        return NitrogenDioxideConcentrationMeasurement
      }
      if (clusterId == OzoneConcentrationMeasurement.ID) {
        return OzoneConcentrationMeasurement
      }
      if (clusterId == Pm25ConcentrationMeasurement.ID) {
        return Pm25ConcentrationMeasurement
      }
      if (clusterId == FormaldehydeConcentrationMeasurement.ID) {
        return FormaldehydeConcentrationMeasurement
      }
      if (clusterId == Pm1ConcentrationMeasurement.ID) {
        return Pm1ConcentrationMeasurement
      }
      if (clusterId == Pm10ConcentrationMeasurement.ID) {
        return Pm10ConcentrationMeasurement
      }
      if (clusterId == TotalVolatileOrganicCompoundsConcentrationMeasurement.ID) {
        return TotalVolatileOrganicCompoundsConcentrationMeasurement
      }
      if (clusterId == RadonConcentrationMeasurement.ID) {
        return RadonConcentrationMeasurement
      }
      if (clusterId == WakeOnLan.ID) {
        return WakeOnLan
      }
      if (clusterId == Channel.ID) {
        return Channel
      }
      if (clusterId == TargetNavigator.ID) {
        return TargetNavigator
      }
      if (clusterId == MediaPlayback.ID) {
        return MediaPlayback
      }
      if (clusterId == MediaInput.ID) {
        return MediaInput
      }
      if (clusterId == LowPower.ID) {
        return LowPower
      }
      if (clusterId == KeypadInput.ID) {
        return KeypadInput
      }
      if (clusterId == ContentLauncher.ID) {
        return ContentLauncher
      }
      if (clusterId == AudioOutput.ID) {
        return AudioOutput
      }
      if (clusterId == ApplicationLauncher.ID) {
        return ApplicationLauncher
      }
      if (clusterId == ApplicationBasic.ID) {
        return ApplicationBasic
      }
      if (clusterId == AccountLogin.ID) {
        return AccountLogin
      }
      if (clusterId == ElectricalMeasurement.ID) {
        return ElectricalMeasurement
      }
      if (clusterId == UnitTesting.ID) {
        return UnitTesting
      }
      if (clusterId == FaultInjection.ID) {
        return FaultInjection
      }
      return null
    }
  }

  abstract fun getID(): Long

  @Throws(NoSuchFieldError::class)
  open fun getAttributeName(id: Long): String {
    throw NoSuchFieldError()
  }

  @Throws(NoSuchFieldError::class)
  open fun getEventName(id: Long): String {
    throw NoSuchFieldError()
  }

  @Throws(NoSuchFieldError::class)
  open fun getCommandName(id: Long): String {
    throw NoSuchFieldError()
  }

  @Throws(IllegalArgumentException::class)
  open fun getAttributeID(name: String): Long {
    throw IllegalArgumentException()
  }

  @Throws(IllegalArgumentException::class)
  open fun getEventID(name: String): Long {
    throw IllegalArgumentException()
  }

  @Throws(IllegalArgumentException::class)
  open fun getCommandID(name: String): Long {
    throw IllegalArgumentException()
  }
}
