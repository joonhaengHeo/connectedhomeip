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

class ClusterIDMapping {
  class Identify : BaseCluster {
    enum class Attribute(val id: Long) {
      IdentifyTime(0L),
      IdentifyType(1L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 3L
    }
  }

  class Groups : BaseCluster {
    enum class Attribute(val id: Long) {
      NameSupport(0L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 4L
    }
  }

  class Scenes : BaseCluster {
    enum class Attribute(val id: Long) {
      SceneCount(0L),
      CurrentScene(1L),
      CurrentGroup(2L),
      SceneValid(3L),
      NameSupport(4L),
      LastConfiguredBy(5L),
      SceneTableSize(6L),
      RemainingCapacity(7L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 5L
    }
  }

  class OnOff : BaseCluster {
    enum class Attribute(val id: Long) {
      OnOff(0L),
      GlobalSceneControl(16384L),
      OnTime(16385L),
      OffWaitTime(16386L),
      StartUpOnOff(16387L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 6L
    }
  }

  class OnOffSwitchConfiguration : BaseCluster {
    enum class Attribute(val id: Long) {
      SwitchType(0L),
      SwitchActions(16L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 7L
    }
  }

  class LevelControl : BaseCluster {
    enum class Attribute(val id: Long) {
      CurrentLevel(0L),
      RemainingTime(1L),
      MinLevel(2L),
      MaxLevel(3L),
      CurrentFrequency(4L),
      MinFrequency(5L),
      MaxFrequency(6L),
      Options(15L),
      OnOffTransitionTime(16L),
      OnLevel(17L),
      OnTransitionTime(18L),
      OffTransitionTime(19L),
      DefaultMoveRate(20L),
      StartUpCurrentLevel(16384L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 8L
    }
  }

  class BinaryInputBasic : BaseCluster {
    enum class Attribute(val id: Long) {
      ActiveText(4L),
      Description(28L),
      InactiveText(46L),
      OutOfService(81L),
      Polarity(84L),
      PresentValue(85L),
      Reliability(103L),
      StatusFlags(111L),
      ApplicationType(256L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 15L
    }
  }

  class PulseWidthModulation : BaseCluster {
    enum class Attribute(val id: Long) {
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 28L
    }
  }

  class Descriptor : BaseCluster {
    enum class Attribute(val id: Long) {
      DeviceTypeList(0L),
      ServerList(1L),
      ClientList(2L),
      PartsList(3L),
      TagList(4L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 29L
    }
  }

  class Binding : BaseCluster {
    enum class Attribute(val id: Long) {
      Binding(0L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 30L
    }
  }

  class AccessControl : BaseCluster {
    enum class Attribute(val id: Long) {
      Acl(0L),
      Extension(1L),
      SubjectsPerAccessControlEntry(2L),
      TargetsPerAccessControlEntry(3L),
      AccessControlEntriesPerFabric(4L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      return Event.valueOf(name).id
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 31L
    }
  }

  class Actions : BaseCluster {
    enum class Attribute(val id: Long) {
      ActionList(0L),
      EndpointLists(1L),
      SetupURL(2L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    companion object {
      const val ID = 37L
    }
  }

  class BasicInformation : BaseCluster {
    enum class Attribute(val id: Long) {
      DataModelRevision(0L),
      VendorName(1L),
      VendorID(2L),
      ProductName(3L),
      ProductID(4L),
      NodeLabel(5L),
      Location(6L),
      HardwareVersion(7L),
      HardwareVersionString(8L),
      SoftwareVersion(9L),
      SoftwareVersionString(10L),
      ManufacturingDate(11L),
      PartNumber(12L),
      ProductURL(13L),
      ProductLabel(14L),
      SerialNumber(15L),
      LocalConfigDisabled(16L),
      Reachable(17L),
      UniqueID(18L),
      CapabilityMinima(19L),
      ProductAppearance(20L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    companion object {
      const val ID = 40L
    }
  }

  class OtaSoftwareUpdateProvider : BaseCluster {
    enum class Attribute(val id: Long) {
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 41L
    }
  }

  class OtaSoftwareUpdateRequestor : BaseCluster {
    enum class Attribute(val id: Long) {
      DefaultOTAProviders(0L),
      UpdatePossible(1L),
      UpdateState(2L),
      UpdateStateProgress(3L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    companion object {
      const val ID = 42L
    }
  }

  class LocalizationConfiguration : BaseCluster {
    enum class Attribute(val id: Long) {
      ActiveLocale(0L),
      SupportedLocales(1L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 43L
    }
  }

  class TimeFormatLocalization : BaseCluster {
    enum class Attribute(val id: Long) {
      HourFormat(0L),
      ActiveCalendarType(1L),
      SupportedCalendarTypes(2L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 44L
    }
  }

  class UnitLocalization : BaseCluster {
    enum class Attribute(val id: Long) {
      TemperatureUnit(0L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 45L
    }
  }

  class PowerSourceConfiguration : BaseCluster {
    enum class Attribute(val id: Long) {
      Sources(0L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 46L
    }
  }

  class PowerSource : BaseCluster {
    enum class Attribute(val id: Long) {
      Status(0L),
      Order(1L),
      Description(2L),
      WiredAssessedInputVoltage(3L),
      WiredAssessedInputFrequency(4L),
      WiredCurrentType(5L),
      WiredAssessedCurrent(6L),
      WiredNominalVoltage(7L),
      WiredMaximumCurrent(8L),
      WiredPresent(9L),
      ActiveWiredFaults(10L),
      BatVoltage(11L),
      BatPercentRemaining(12L),
      BatTimeRemaining(13L),
      BatChargeLevel(14L),
      BatReplacementNeeded(15L),
      BatReplaceability(16L),
      BatPresent(17L),
      ActiveBatFaults(18L),
      BatReplacementDescription(19L),
      BatCommonDesignation(20L),
      BatANSIDesignation(21L),
      BatIECDesignation(22L),
      BatApprovedChemistry(23L),
      BatCapacity(24L),
      BatQuantity(25L),
      BatChargeState(26L),
      BatTimeToFullCharge(27L),
      BatFunctionalWhileCharging(28L),
      BatChargingCurrent(29L),
      ActiveBatChargeFaults(30L),
      EndpointList(31L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      return Event.valueOf(name).id
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 47L
    }
  }

  class GeneralCommissioning : BaseCluster {
    enum class Attribute(val id: Long) {
      Breadcrumb(0L),
      BasicCommissioningInfo(1L),
      RegulatoryConfig(2L),
      LocationCapability(3L),
      SupportsConcurrentConnection(4L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 48L
    }
  }

  class NetworkCommissioning : BaseCluster {
    enum class Attribute(val id: Long) {
      MaxNetworks(0L),
      Networks(1L),
      ScanMaxTimeSeconds(2L),
      ConnectMaxTimeSeconds(3L),
      InterfaceEnabled(4L),
      LastNetworkingStatus(5L),
      LastNetworkID(6L),
      LastConnectErrorValue(7L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 49L
    }
  }

  class DiagnosticLogs : BaseCluster {
    enum class Attribute(val id: Long) {
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 50L
    }
  }

  class GeneralDiagnostics : BaseCluster {
    enum class Attribute(val id: Long) {
      NetworkInterfaces(0L),
      RebootCount(1L),
      UpTime(2L),
      TotalOperationalHours(3L),
      BootReason(4L),
      ActiveHardwareFaults(5L),
      ActiveRadioFaults(6L),
      ActiveNetworkFaults(7L),
      TestEventTriggersEnabled(8L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    companion object {
      const val ID = 51L
    }
  }

  class SoftwareDiagnostics : BaseCluster {
    enum class Attribute(val id: Long) {
      ThreadMetrics(0L),
      CurrentHeapFree(1L),
      CurrentHeapUsed(2L),
      CurrentHeapHighWatermark(3L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    companion object {
      const val ID = 52L
    }
  }

  class ThreadNetworkDiagnostics : BaseCluster {
    enum class Attribute(val id: Long) {
      Channel(0L),
      RoutingRole(1L),
      NetworkName(2L),
      PanId(3L),
      ExtendedPanId(4L),
      MeshLocalPrefix(5L),
      OverrunCount(6L),
      NeighborTable(7L),
      RouteTable(8L),
      PartitionId(9L),
      Weighting(10L),
      DataVersion(11L),
      StableDataVersion(12L),
      LeaderRouterId(13L),
      DetachedRoleCount(14L),
      ChildRoleCount(15L),
      RouterRoleCount(16L),
      LeaderRoleCount(17L),
      AttachAttemptCount(18L),
      PartitionIdChangeCount(19L),
      BetterPartitionAttachAttemptCount(20L),
      ParentChangeCount(21L),
      TxTotalCount(22L),
      TxUnicastCount(23L),
      TxBroadcastCount(24L),
      TxAckRequestedCount(25L),
      TxAckedCount(26L),
      TxNoAckRequestedCount(27L),
      TxDataCount(28L),
      TxDataPollCount(29L),
      TxBeaconCount(30L),
      TxBeaconRequestCount(31L),
      TxOtherCount(32L),
      TxRetryCount(33L),
      TxDirectMaxRetryExpiryCount(34L),
      TxIndirectMaxRetryExpiryCount(35L),
      TxErrCcaCount(36L),
      TxErrAbortCount(37L),
      TxErrBusyChannelCount(38L),
      RxTotalCount(39L),
      RxUnicastCount(40L),
      RxBroadcastCount(41L),
      RxDataCount(42L),
      RxDataPollCount(43L),
      RxBeaconCount(44L),
      RxBeaconRequestCount(45L),
      RxOtherCount(46L),
      RxAddressFilteredCount(47L),
      RxDestAddrFilteredCount(48L),
      RxDuplicatedCount(49L),
      RxErrNoFrameCount(50L),
      RxErrUnknownNeighborCount(51L),
      RxErrInvalidSrcAddrCount(52L),
      RxErrSecCount(53L),
      RxErrFcsCount(54L),
      RxErrOtherCount(55L),
      ActiveTimestamp(56L),
      PendingTimestamp(57L),
      Delay(58L),
      SecurityPolicy(59L),
      ChannelPage0Mask(60L),
      OperationalDatasetComponents(61L),
      ActiveNetworkFaultsList(62L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    companion object {
      const val ID = 53L
    }
  }

  class WiFiNetworkDiagnostics : BaseCluster {
    enum class Attribute(val id: Long) {
      Bssid(0L),
      SecurityType(1L),
      WiFiVersion(2L),
      ChannelNumber(3L),
      Rssi(4L),
      BeaconLostCount(5L),
      BeaconRxCount(6L),
      PacketMulticastRxCount(7L),
      PacketMulticastTxCount(8L),
      PacketUnicastRxCount(9L),
      PacketUnicastTxCount(10L),
      CurrentMaxRate(11L),
      OverrunCount(12L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    companion object {
      const val ID = 54L
    }
  }

  class EthernetNetworkDiagnostics : BaseCluster {
    enum class Attribute(val id: Long) {
      PHYRate(0L),
      FullDuplex(1L),
      PacketRxCount(2L),
      PacketTxCount(3L),
      TxErrCount(4L),
      CollisionCount(5L),
      OverrunCount(6L),
      CarrierDetect(7L),
      TimeSinceReset(8L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 55L
    }
  }

  class TimeSynchronization : BaseCluster {
    enum class Attribute(val id: Long) {
      UTCTime(0L),
      Granularity(1L),
      TimeSource(2L),
      TrustedTimeSource(3L),
      DefaultNTP(4L),
      TimeZone(5L),
      DSTOffset(6L),
      LocalTime(7L),
      TimeZoneDatabase(8L),
      NTPServerAvailable(9L),
      TimeZoneListMaxSize(10L),
      DSTOffsetListMaxSize(11L),
      SupportsDNSResolve(12L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    companion object {
      const val ID = 56L
    }
  }

  class BridgedDeviceBasicInformation : BaseCluster {
    enum class Attribute(val id: Long) {
      VendorName(1L),
      VendorID(2L),
      ProductName(3L),
      NodeLabel(5L),
      HardwareVersion(7L),
      HardwareVersionString(8L),
      SoftwareVersion(9L),
      SoftwareVersionString(10L),
      ManufacturingDate(11L),
      PartNumber(12L),
      ProductURL(13L),
      ProductLabel(14L),
      SerialNumber(15L),
      Reachable(17L),
      UniqueID(18L),
      ProductAppearance(20L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      return Event.valueOf(name).id
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 57L
    }
  }

  class Switch : BaseCluster {
    enum class Attribute(val id: Long) {
      NumberOfPositions(0L),
      CurrentPosition(1L),
      MultiPressMax(2L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      return Event.valueOf(name).id
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 59L
    }
  }

  class AdministratorCommissioning : BaseCluster {
    enum class Attribute(val id: Long) {
      WindowStatus(0L),
      AdminFabricIndex(1L),
      AdminVendorId(2L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 60L
    }
  }

  class OperationalCredentials : BaseCluster {
    enum class Attribute(val id: Long) {
      NOCs(0L),
      Fabrics(1L),
      SupportedFabrics(2L),
      CommissionedFabrics(3L),
      TrustedRootCertificates(4L),
      CurrentFabricIndex(5L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 62L
    }
  }

  class GroupKeyManagement : BaseCluster {
    enum class Attribute(val id: Long) {
      GroupKeyMap(0L),
      GroupTable(1L),
      MaxGroupsPerFabric(2L),
      MaxGroupKeysPerFabric(3L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 63L
    }
  }

  class FixedLabel : BaseCluster {
    enum class Attribute(val id: Long) {
      LabelList(0L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 64L
    }
  }

  class UserLabel : BaseCluster {
    enum class Attribute(val id: Long) {
      LabelList(0L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 65L
    }
  }

  class ProxyConfiguration : BaseCluster {
    enum class Attribute(val id: Long) {
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 66L
    }
  }

  class ProxyDiscovery : BaseCluster {
    enum class Attribute(val id: Long) {
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 67L
    }
  }

  class ProxyValid : BaseCluster {
    enum class Attribute(val id: Long) {
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 68L
    }
  }

  class BooleanState : BaseCluster {
    enum class Attribute(val id: Long) {
      StateValue(0L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      return Event.valueOf(name).id
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 69L
    }
  }

  class IcdManagement : BaseCluster {
    enum class Attribute(val id: Long) {
      IdleModeInterval(0L),
      ActiveModeInterval(1L),
      ActiveModeThreshold(2L),
      RegisteredClients(3L),
      ICDCounter(4L),
      ClientsSupportedPerFabric(5L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 70L
    }
  }

  class ModeSelect : BaseCluster {
    enum class Attribute(val id: Long) {
      Description(0L),
      StandardNamespace(1L),
      SupportedModes(2L),
      CurrentMode(3L),
      StartUpMode(4L),
      OnMode(5L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 80L
    }
  }

  class LaundryWasherMode : BaseCluster {
    enum class Attribute(val id: Long) {
      SupportedModes(0L),
      CurrentMode(1L),
      StartUpMode(2L),
      OnMode(3L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 81L
    }
  }

  class RefrigeratorAndTemperatureControlledCabinetMode : BaseCluster {
    enum class Attribute(val id: Long) {
      SupportedModes(0L),
      CurrentMode(1L),
      StartUpMode(2L),
      OnMode(3L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 82L
    }
  }

  class LaundryWasherControls : BaseCluster {
    enum class Attribute(val id: Long) {
      SpinSpeeds(0L),
      SpinSpeedCurrent(1L),
      NumberOfRinses(2L),
      SupportedRinses(3L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 83L
    }
  }

  class RvcRunMode : BaseCluster {
    enum class Attribute(val id: Long) {
      SupportedModes(0L),
      CurrentMode(1L),
      StartUpMode(2L),
      OnMode(3L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 84L
    }
  }

  class RvcCleanMode : BaseCluster {
    enum class Attribute(val id: Long) {
      SupportedModes(0L),
      CurrentMode(1L),
      StartUpMode(2L),
      OnMode(3L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 85L
    }
  }

  class TemperatureControl : BaseCluster {
    enum class Attribute(val id: Long) {
      TemperatureSetpoint(0L),
      MinTemperature(1L),
      MaxTemperature(2L),
      Step(3L),
      SelectedTemperatureLevel(4L),
      SupportedTemperatureLevels(5L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 86L
    }
  }

  class RefrigeratorAlarm : BaseCluster {
    enum class Attribute(val id: Long) {
      Mask(0L),
      State(2L),
      Supported(3L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      return Event.valueOf(name).id
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 87L
    }
  }

  class DishwasherMode : BaseCluster {
    enum class Attribute(val id: Long) {
      SupportedModes(0L),
      CurrentMode(1L),
      StartUpMode(2L),
      OnMode(3L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 89L
    }
  }

  class AirQuality : BaseCluster {
    enum class Attribute(val id: Long) {
      AirQuality(0L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 91L
    }
  }

  class SmokeCoAlarm : BaseCluster {
    enum class Attribute(val id: Long) {
      ExpressedState(0L),
      SmokeState(1L),
      COState(2L),
      BatteryAlert(3L),
      DeviceMuted(4L),
      TestInProgress(5L),
      HardwareFaultAlert(6L),
      EndOfServiceAlert(7L),
      InterconnectSmokeAlarm(8L),
      InterconnectCOAlarm(9L),
      ContaminationState(10L),
      SmokeSensitivityLevel(11L),
      ExpiryDate(12L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    companion object {
      const val ID = 92L
    }
  }

  class DishwasherAlarm : BaseCluster {
    enum class Attribute(val id: Long) {
      Mask(0L),
      Latch(1L),
      State(2L),
      Supported(3L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    companion object {
      const val ID = 93L
    }
  }

  class OperationalState : BaseCluster {
    enum class Attribute(val id: Long) {
      PhaseList(0L),
      CurrentPhase(1L),
      CountdownTime(2L),
      OperationalStateList(3L),
      OperationalState(4L),
      OperationalError(5L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    companion object {
      const val ID = 96L
    }
  }

  class RvcOperationalState : BaseCluster {
    enum class Attribute(val id: Long) {
      PhaseList(0L),
      CurrentPhase(1L),
      CountdownTime(2L),
      OperationalStateList(3L),
      OperationalState(4L),
      OperationalError(5L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    companion object {
      const val ID = 97L
    }
  }

  class HepaFilterMonitoring : BaseCluster {
    enum class Attribute(val id: Long) {
      Condition(0L),
      DegradationDirection(1L),
      ChangeIndication(2L),
      InPlaceIndicator(3L),
      LastChangedTime(4L),
      ReplacementProductList(5L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 113L
    }
  }

  class ActivatedCarbonFilterMonitoring : BaseCluster {
    enum class Attribute(val id: Long) {
      Condition(0L),
      DegradationDirection(1L),
      ChangeIndication(2L),
      InPlaceIndicator(3L),
      LastChangedTime(4L),
      ReplacementProductList(5L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 114L
    }
  }

  class DoorLock : BaseCluster {
    enum class Attribute(val id: Long) {
      LockState(0L),
      LockType(1L),
      ActuatorEnabled(2L),
      DoorState(3L),
      DoorOpenEvents(4L),
      DoorClosedEvents(5L),
      OpenPeriod(6L),
      NumberOfTotalUsersSupported(17L),
      NumberOfPINUsersSupported(18L),
      NumberOfRFIDUsersSupported(19L),
      NumberOfWeekDaySchedulesSupportedPerUser(20L),
      NumberOfYearDaySchedulesSupportedPerUser(21L),
      NumberOfHolidaySchedulesSupported(22L),
      MaxPINCodeLength(23L),
      MinPINCodeLength(24L),
      MaxRFIDCodeLength(25L),
      MinRFIDCodeLength(26L),
      CredentialRulesSupport(27L),
      NumberOfCredentialsSupportedPerUser(28L),
      Language(33L),
      LEDSettings(34L),
      AutoRelockTime(35L),
      SoundVolume(36L),
      OperatingMode(37L),
      SupportedOperatingModes(38L),
      DefaultConfigurationRegister(39L),
      EnableLocalProgramming(40L),
      EnableOneTouchLocking(41L),
      EnableInsideStatusLED(42L),
      EnablePrivacyModeButton(43L),
      LocalProgrammingFeatures(44L),
      WrongCodeEntryLimit(48L),
      UserCodeTemporaryDisableTime(49L),
      SendPINOverTheAir(50L),
      RequirePINforRemoteOperation(51L),
      ExpiringUserTimeout(53L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    companion object {
      const val ID = 257L
    }
  }

  class WindowCovering : BaseCluster {
    enum class Attribute(val id: Long) {
      Type(0L),
      PhysicalClosedLimitLift(1L),
      PhysicalClosedLimitTilt(2L),
      CurrentPositionLift(3L),
      CurrentPositionTilt(4L),
      NumberOfActuationsLift(5L),
      NumberOfActuationsTilt(6L),
      ConfigStatus(7L),
      CurrentPositionLiftPercentage(8L),
      CurrentPositionTiltPercentage(9L),
      OperationalStatus(10L),
      TargetPositionLiftPercent100ths(11L),
      TargetPositionTiltPercent100ths(12L),
      EndProductType(13L),
      CurrentPositionLiftPercent100ths(14L),
      CurrentPositionTiltPercent100ths(15L),
      InstalledOpenLimitLift(16L),
      InstalledClosedLimitLift(17L),
      InstalledOpenLimitTilt(18L),
      InstalledClosedLimitTilt(19L),
      Mode(23L),
      SafetyStatus(26L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 258L
    }
  }

  class BarrierControl : BaseCluster {
    enum class Attribute(val id: Long) {
      BarrierMovingState(1L),
      BarrierSafetyStatus(2L),
      BarrierCapabilities(3L),
      BarrierOpenEvents(4L),
      BarrierCloseEvents(5L),
      BarrierCommandOpenEvents(6L),
      BarrierCommandCloseEvents(7L),
      BarrierOpenPeriod(8L),
      BarrierClosePeriod(9L),
      BarrierPosition(10L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 259L
    }
  }

  class PumpConfigurationAndControl : BaseCluster {
    enum class Attribute(val id: Long) {
      MaxPressure(0L),
      MaxSpeed(1L),
      MaxFlow(2L),
      MinConstPressure(3L),
      MaxConstPressure(4L),
      MinCompPressure(5L),
      MaxCompPressure(6L),
      MinConstSpeed(7L),
      MaxConstSpeed(8L),
      MinConstFlow(9L),
      MaxConstFlow(10L),
      MinConstTemp(11L),
      MaxConstTemp(12L),
      PumpStatus(16L),
      EffectiveOperationMode(17L),
      EffectiveControlMode(18L),
      Capacity(19L),
      Speed(20L),
      LifetimeRunningHours(21L),
      Power(22L),
      LifetimeEnergyConsumed(23L),
      OperationMode(32L),
      ControlMode(33L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      return Event.valueOf(name).id
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 512L
    }
  }

  class Thermostat : BaseCluster {
    enum class Attribute(val id: Long) {
      LocalTemperature(0L),
      OutdoorTemperature(1L),
      Occupancy(2L),
      AbsMinHeatSetpointLimit(3L),
      AbsMaxHeatSetpointLimit(4L),
      AbsMinCoolSetpointLimit(5L),
      AbsMaxCoolSetpointLimit(6L),
      PICoolingDemand(7L),
      PIHeatingDemand(8L),
      HVACSystemTypeConfiguration(9L),
      LocalTemperatureCalibration(16L),
      OccupiedCoolingSetpoint(17L),
      OccupiedHeatingSetpoint(18L),
      UnoccupiedCoolingSetpoint(19L),
      UnoccupiedHeatingSetpoint(20L),
      MinHeatSetpointLimit(21L),
      MaxHeatSetpointLimit(22L),
      MinCoolSetpointLimit(23L),
      MaxCoolSetpointLimit(24L),
      MinSetpointDeadBand(25L),
      RemoteSensing(26L),
      ControlSequenceOfOperation(27L),
      SystemMode(28L),
      ThermostatRunningMode(30L),
      StartOfWeek(32L),
      NumberOfWeeklyTransitions(33L),
      NumberOfDailyTransitions(34L),
      TemperatureSetpointHold(35L),
      TemperatureSetpointHoldDuration(36L),
      ThermostatProgrammingOperationMode(37L),
      ThermostatRunningState(41L),
      SetpointChangeSource(48L),
      SetpointChangeAmount(49L),
      SetpointChangeSourceTimestamp(50L),
      OccupiedSetback(52L),
      OccupiedSetbackMin(53L),
      OccupiedSetbackMax(54L),
      UnoccupiedSetback(55L),
      UnoccupiedSetbackMin(56L),
      UnoccupiedSetbackMax(57L),
      EmergencyHeatDelta(58L),
      ACType(64L),
      ACCapacity(65L),
      ACRefrigerantType(66L),
      ACCompressorType(67L),
      ACErrorCode(68L),
      ACLouverPosition(69L),
      ACCoilTemperature(70L),
      ACCapacityformat(71L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 513L
    }
  }

  class FanControl : BaseCluster {
    enum class Attribute(val id: Long) {
      FanMode(0L),
      FanModeSequence(1L),
      PercentSetting(2L),
      PercentCurrent(3L),
      SpeedMax(4L),
      SpeedSetting(5L),
      SpeedCurrent(6L),
      RockSupport(7L),
      RockSetting(8L),
      WindSupport(9L),
      WindSetting(10L),
      AirflowDirection(11L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 514L
    }
  }

  class ThermostatUserInterfaceConfiguration : BaseCluster {
    enum class Attribute(val id: Long) {
      TemperatureDisplayMode(0L),
      KeypadLockout(1L),
      ScheduleProgrammingVisibility(2L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 516L
    }
  }

  class ColorControl : BaseCluster {
    enum class Attribute(val id: Long) {
      CurrentHue(0L),
      CurrentSaturation(1L),
      RemainingTime(2L),
      CurrentX(3L),
      CurrentY(4L),
      DriftCompensation(5L),
      CompensationText(6L),
      ColorTemperatureMireds(7L),
      ColorMode(8L),
      Options(15L),
      NumberOfPrimaries(16L),
      Primary1X(17L),
      Primary1Y(18L),
      Primary1Intensity(19L),
      Primary2X(21L),
      Primary2Y(22L),
      Primary2Intensity(23L),
      Primary3X(25L),
      Primary3Y(26L),
      Primary3Intensity(27L),
      Primary4X(32L),
      Primary4Y(33L),
      Primary4Intensity(34L),
      Primary5X(36L),
      Primary5Y(37L),
      Primary5Intensity(38L),
      Primary6X(40L),
      Primary6Y(41L),
      Primary6Intensity(42L),
      WhitePointX(48L),
      WhitePointY(49L),
      ColorPointRX(50L),
      ColorPointRY(51L),
      ColorPointRIntensity(52L),
      ColorPointGX(54L),
      ColorPointGY(55L),
      ColorPointGIntensity(56L),
      ColorPointBX(58L),
      ColorPointBY(59L),
      ColorPointBIntensity(60L),
      EnhancedCurrentHue(16384L),
      EnhancedColorMode(16385L),
      ColorLoopActive(16386L),
      ColorLoopDirection(16387L),
      ColorLoopTime(16388L),
      ColorLoopStartEnhancedHue(16389L),
      ColorLoopStoredEnhancedHue(16390L),
      ColorCapabilities(16394L),
      ColorTempPhysicalMinMireds(16395L),
      ColorTempPhysicalMaxMireds(16396L),
      CoupleColorTempToLevelMinMireds(16397L),
      StartUpColorTemperatureMireds(16400L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 768L
    }
  }

  class BallastConfiguration : BaseCluster {
    enum class Attribute(val id: Long) {
      PhysicalMinLevel(0L),
      PhysicalMaxLevel(1L),
      BallastStatus(2L),
      MinLevel(16L),
      MaxLevel(17L),
      IntrinsicBallastFactor(20L),
      BallastFactorAdjustment(21L),
      LampQuantity(32L),
      LampType(48L),
      LampManufacturer(49L),
      LampRatedHours(50L),
      LampBurnHours(51L),
      LampAlarmMode(52L),
      LampBurnHoursTripPoint(53L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 769L
    }
  }

  class IlluminanceMeasurement : BaseCluster {
    enum class Attribute(val id: Long) {
      MeasuredValue(0L),
      MinMeasuredValue(1L),
      MaxMeasuredValue(2L),
      Tolerance(3L),
      LightSensorType(4L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1024L
    }
  }

  class TemperatureMeasurement : BaseCluster {
    enum class Attribute(val id: Long) {
      MeasuredValue(0L),
      MinMeasuredValue(1L),
      MaxMeasuredValue(2L),
      Tolerance(3L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1026L
    }
  }

  class PressureMeasurement : BaseCluster {
    enum class Attribute(val id: Long) {
      MeasuredValue(0L),
      MinMeasuredValue(1L),
      MaxMeasuredValue(2L),
      Tolerance(3L),
      ScaledValue(16L),
      MinScaledValue(17L),
      MaxScaledValue(18L),
      ScaledTolerance(19L),
      Scale(20L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1027L
    }
  }

  class FlowMeasurement : BaseCluster {
    enum class Attribute(val id: Long) {
      MeasuredValue(0L),
      MinMeasuredValue(1L),
      MaxMeasuredValue(2L),
      Tolerance(3L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1028L
    }
  }

  class RelativeHumidityMeasurement : BaseCluster {
    enum class Attribute(val id: Long) {
      MeasuredValue(0L),
      MinMeasuredValue(1L),
      MaxMeasuredValue(2L),
      Tolerance(3L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1029L
    }
  }

  class OccupancySensing : BaseCluster {
    enum class Attribute(val id: Long) {
      Occupancy(0L),
      OccupancySensorType(1L),
      OccupancySensorTypeBitmap(2L),
      PIROccupiedToUnoccupiedDelay(16L),
      PIRUnoccupiedToOccupiedDelay(17L),
      PIRUnoccupiedToOccupiedThreshold(18L),
      UltrasonicOccupiedToUnoccupiedDelay(32L),
      UltrasonicUnoccupiedToOccupiedDelay(33L),
      UltrasonicUnoccupiedToOccupiedThreshold(34L),
      PhysicalContactOccupiedToUnoccupiedDelay(48L),
      PhysicalContactUnoccupiedToOccupiedDelay(49L),
      PhysicalContactUnoccupiedToOccupiedThreshold(50L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1030L
    }
  }

  class CarbonMonoxideConcentrationMeasurement : BaseCluster {
    enum class Attribute(val id: Long) {
      MeasuredValue(0L),
      MinMeasuredValue(1L),
      MaxMeasuredValue(2L),
      PeakMeasuredValue(3L),
      PeakMeasuredValueWindow(4L),
      AverageMeasuredValue(5L),
      AverageMeasuredValueWindow(6L),
      Uncertainty(7L),
      MeasurementUnit(8L),
      MeasurementMedium(9L),
      LevelValue(10L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1036L
    }
  }

  class CarbonDioxideConcentrationMeasurement : BaseCluster {
    enum class Attribute(val id: Long) {
      MeasuredValue(0L),
      MinMeasuredValue(1L),
      MaxMeasuredValue(2L),
      PeakMeasuredValue(3L),
      PeakMeasuredValueWindow(4L),
      AverageMeasuredValue(5L),
      AverageMeasuredValueWindow(6L),
      Uncertainty(7L),
      MeasurementUnit(8L),
      MeasurementMedium(9L),
      LevelValue(10L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1037L
    }
  }

  class NitrogenDioxideConcentrationMeasurement : BaseCluster {
    enum class Attribute(val id: Long) {
      MeasuredValue(0L),
      MinMeasuredValue(1L),
      MaxMeasuredValue(2L),
      PeakMeasuredValue(3L),
      PeakMeasuredValueWindow(4L),
      AverageMeasuredValue(5L),
      AverageMeasuredValueWindow(6L),
      Uncertainty(7L),
      MeasurementUnit(8L),
      MeasurementMedium(9L),
      LevelValue(10L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1043L
    }
  }

  class OzoneConcentrationMeasurement : BaseCluster {
    enum class Attribute(val id: Long) {
      MeasuredValue(0L),
      MinMeasuredValue(1L),
      MaxMeasuredValue(2L),
      PeakMeasuredValue(3L),
      PeakMeasuredValueWindow(4L),
      AverageMeasuredValue(5L),
      AverageMeasuredValueWindow(6L),
      Uncertainty(7L),
      MeasurementUnit(8L),
      MeasurementMedium(9L),
      LevelValue(10L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1045L
    }
  }

  class Pm25ConcentrationMeasurement : BaseCluster {
    enum class Attribute(val id: Long) {
      MeasuredValue(0L),
      MinMeasuredValue(1L),
      MaxMeasuredValue(2L),
      PeakMeasuredValue(3L),
      PeakMeasuredValueWindow(4L),
      AverageMeasuredValue(5L),
      AverageMeasuredValueWindow(6L),
      Uncertainty(7L),
      MeasurementUnit(8L),
      MeasurementMedium(9L),
      LevelValue(10L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1066L
    }
  }

  class FormaldehydeConcentrationMeasurement : BaseCluster {
    enum class Attribute(val id: Long) {
      MeasuredValue(0L),
      MinMeasuredValue(1L),
      MaxMeasuredValue(2L),
      PeakMeasuredValue(3L),
      PeakMeasuredValueWindow(4L),
      AverageMeasuredValue(5L),
      AverageMeasuredValueWindow(6L),
      Uncertainty(7L),
      MeasurementUnit(8L),
      MeasurementMedium(9L),
      LevelValue(10L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1067L
    }
  }

  class Pm1ConcentrationMeasurement : BaseCluster {
    enum class Attribute(val id: Long) {
      MeasuredValue(0L),
      MinMeasuredValue(1L),
      MaxMeasuredValue(2L),
      PeakMeasuredValue(3L),
      PeakMeasuredValueWindow(4L),
      AverageMeasuredValue(5L),
      AverageMeasuredValueWindow(6L),
      Uncertainty(7L),
      MeasurementUnit(8L),
      MeasurementMedium(9L),
      LevelValue(10L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1068L
    }
  }

  class Pm10ConcentrationMeasurement : BaseCluster {
    enum class Attribute(val id: Long) {
      MeasuredValue(0L),
      MinMeasuredValue(1L),
      MaxMeasuredValue(2L),
      PeakMeasuredValue(3L),
      PeakMeasuredValueWindow(4L),
      AverageMeasuredValue(5L),
      AverageMeasuredValueWindow(6L),
      Uncertainty(7L),
      MeasurementUnit(8L),
      MeasurementMedium(9L),
      LevelValue(10L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1069L
    }
  }

  class TotalVolatileOrganicCompoundsConcentrationMeasurement : BaseCluster {
    enum class Attribute(val id: Long) {
      MeasuredValue(0L),
      MinMeasuredValue(1L),
      MaxMeasuredValue(2L),
      PeakMeasuredValue(3L),
      PeakMeasuredValueWindow(4L),
      AverageMeasuredValue(5L),
      AverageMeasuredValueWindow(6L),
      Uncertainty(7L),
      MeasurementUnit(8L),
      MeasurementMedium(9L),
      LevelValue(10L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1070L
    }
  }

  class RadonConcentrationMeasurement : BaseCluster {
    enum class Attribute(val id: Long) {
      MeasuredValue(0L),
      MinMeasuredValue(1L),
      MaxMeasuredValue(2L),
      PeakMeasuredValue(3L),
      PeakMeasuredValueWindow(4L),
      AverageMeasuredValue(5L),
      AverageMeasuredValueWindow(6L),
      Uncertainty(7L),
      MeasurementUnit(8L),
      MeasurementMedium(9L),
      LevelValue(10L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1071L
    }
  }

  class WakeOnLan : BaseCluster {
    enum class Attribute(val id: Long) {
      MACAddress(0L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1283L
    }
  }

  class Channel : BaseCluster {
    enum class Attribute(val id: Long) {
      ChannelList(0L),
      Lineup(1L),
      CurrentChannel(2L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 1284L
    }
  }

  class TargetNavigator : BaseCluster {
    enum class Attribute(val id: Long) {
      TargetList(0L),
      CurrentTarget(1L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 1285L
    }
  }

  class MediaPlayback : BaseCluster {
    enum class Attribute(val id: Long) {
      CurrentState(0L),
      StartTime(1L),
      Duration(2L),
      SampledPosition(3L),
      PlaybackSpeed(4L),
      SeekRangeEnd(5L),
      SeekRangeStart(6L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 1286L
    }
  }

  class MediaInput : BaseCluster {
    enum class Attribute(val id: Long) {
      InputList(0L),
      CurrentInput(1L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 1287L
    }
  }

  class LowPower : BaseCluster {
    enum class Attribute(val id: Long) {
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 1288L
    }
  }

  class KeypadInput : BaseCluster {
    enum class Attribute(val id: Long) {
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 1289L
    }
  }

  class ContentLauncher : BaseCluster {
    enum class Attribute(val id: Long) {
      AcceptHeader(0L),
      SupportedStreamingProtocols(1L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 1290L
    }
  }

  class AudioOutput : BaseCluster {
    enum class Attribute(val id: Long) {
      OutputList(0L),
      CurrentOutput(1L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 1291L
    }
  }

  class ApplicationLauncher : BaseCluster {
    enum class Attribute(val id: Long) {
      CatalogList(0L),
      CurrentApp(1L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 1292L
    }
  }

  class ApplicationBasic : BaseCluster {
    enum class Attribute(val id: Long) {
      VendorName(0L),
      VendorID(1L),
      ApplicationName(2L),
      ProductID(3L),
      Application(4L),
      Status(5L),
      ApplicationVersion(6L),
      AllowedVendorList(7L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
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
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      throw NoSuchFieldError()
    }

    companion object {
      const val ID = 1293L
    }
  }

  class AccountLogin : BaseCluster {
    enum class Attribute(val id: Long) {
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 1294L
    }
  }

  class ElectricalMeasurement : BaseCluster {
    enum class Attribute(val id: Long) {
      MeasurementType(0L),
      DcVoltage(256L),
      DcVoltageMin(257L),
      DcVoltageMax(258L),
      DcCurrent(259L),
      DcCurrentMin(260L),
      DcCurrentMax(261L),
      DcPower(262L),
      DcPowerMin(263L),
      DcPowerMax(264L),
      DcVoltageMultiplier(512L),
      DcVoltageDivisor(513L),
      DcCurrentMultiplier(514L),
      DcCurrentDivisor(515L),
      DcPowerMultiplier(516L),
      DcPowerDivisor(517L),
      AcFrequency(768L),
      AcFrequencyMin(769L),
      AcFrequencyMax(770L),
      NeutralCurrent(771L),
      TotalActivePower(772L),
      TotalReactivePower(773L),
      TotalApparentPower(774L),
      Measured1stHarmonicCurrent(775L),
      Measured3rdHarmonicCurrent(776L),
      Measured5thHarmonicCurrent(777L),
      Measured7thHarmonicCurrent(778L),
      Measured9thHarmonicCurrent(779L),
      Measured11thHarmonicCurrent(780L),
      MeasuredPhase1stHarmonicCurrent(781L),
      MeasuredPhase3rdHarmonicCurrent(782L),
      MeasuredPhase5thHarmonicCurrent(783L),
      MeasuredPhase7thHarmonicCurrent(784L),
      MeasuredPhase9thHarmonicCurrent(785L),
      MeasuredPhase11thHarmonicCurrent(786L),
      AcFrequencyMultiplier(1024L),
      AcFrequencyDivisor(1025L),
      PowerMultiplier(1026L),
      PowerDivisor(1027L),
      HarmonicCurrentMultiplier(1028L),
      PhaseHarmonicCurrentMultiplier(1029L),
      InstantaneousVoltage(1280L),
      InstantaneousLineCurrent(1281L),
      InstantaneousActiveCurrent(1282L),
      InstantaneousReactiveCurrent(1283L),
      InstantaneousPower(1284L),
      RmsVoltage(1285L),
      RmsVoltageMin(1286L),
      RmsVoltageMax(1287L),
      RmsCurrent(1288L),
      RmsCurrentMin(1289L),
      RmsCurrentMax(1290L),
      ActivePower(1291L),
      ActivePowerMin(1292L),
      ActivePowerMax(1293L),
      ReactivePower(1294L),
      ApparentPower(1295L),
      PowerFactor(1296L),
      AverageRmsVoltageMeasurementPeriod(1297L),
      AverageRmsUnderVoltageCounter(1299L),
      RmsExtremeOverVoltagePeriod(1300L),
      RmsExtremeUnderVoltagePeriod(1301L),
      RmsVoltageSagPeriod(1302L),
      RmsVoltageSwellPeriod(1303L),
      AcVoltageMultiplier(1536L),
      AcVoltageDivisor(1537L),
      AcCurrentMultiplier(1538L),
      AcCurrentDivisor(1539L),
      AcPowerMultiplier(1540L),
      AcPowerDivisor(1541L),
      OverloadAlarmsMask(1792L),
      VoltageOverload(1793L),
      CurrentOverload(1794L),
      AcOverloadAlarmsMask(2048L),
      AcVoltageOverload(2049L),
      AcCurrentOverload(2050L),
      AcActivePowerOverload(2051L),
      AcReactivePowerOverload(2052L),
      AverageRmsOverVoltage(2053L),
      AverageRmsUnderVoltage(2054L),
      RmsExtremeOverVoltage(2055L),
      RmsExtremeUnderVoltage(2056L),
      RmsVoltageSag(2057L),
      RmsVoltageSwell(2058L),
      LineCurrentPhaseB(2305L),
      ActiveCurrentPhaseB(2306L),
      ReactiveCurrentPhaseB(2307L),
      RmsVoltagePhaseB(2309L),
      RmsVoltageMinPhaseB(2310L),
      RmsVoltageMaxPhaseB(2311L),
      RmsCurrentPhaseB(2312L),
      RmsCurrentMinPhaseB(2313L),
      RmsCurrentMaxPhaseB(2314L),
      ActivePowerPhaseB(2315L),
      ActivePowerMinPhaseB(2316L),
      ActivePowerMaxPhaseB(2317L),
      ReactivePowerPhaseB(2318L),
      ApparentPowerPhaseB(2319L),
      PowerFactorPhaseB(2320L),
      AverageRmsVoltageMeasurementPeriodPhaseB(2321L),
      AverageRmsOverVoltageCounterPhaseB(2322L),
      AverageRmsUnderVoltageCounterPhaseB(2323L),
      RmsExtremeOverVoltagePeriodPhaseB(2324L),
      RmsExtremeUnderVoltagePeriodPhaseB(2325L),
      RmsVoltageSagPeriodPhaseB(2326L),
      RmsVoltageSwellPeriodPhaseB(2327L),
      LineCurrentPhaseC(2561L),
      ActiveCurrentPhaseC(2562L),
      ReactiveCurrentPhaseC(2563L),
      RmsVoltagePhaseC(2565L),
      RmsVoltageMinPhaseC(2566L),
      RmsVoltageMaxPhaseC(2567L),
      RmsCurrentPhaseC(2568L),
      RmsCurrentMinPhaseC(2569L),
      RmsCurrentMaxPhaseC(2570L),
      ActivePowerPhaseC(2571L),
      ActivePowerMinPhaseC(2572L),
      ActivePowerMaxPhaseC(2573L),
      ReactivePowerPhaseC(2574L),
      ApparentPowerPhaseC(2575L),
      PowerFactorPhaseC(2576L),
      AverageRmsVoltageMeasurementPeriodPhaseC(2577L),
      AverageRmsOverVoltageCounterPhaseC(2578L),
      AverageRmsUnderVoltageCounterPhaseC(2579L),
      RmsExtremeOverVoltagePeriodPhaseC(2580L),
      RmsExtremeUnderVoltagePeriodPhaseC(2581L),
      RmsVoltageSagPeriodPhaseC(2582L),
      RmsVoltageSwellPeriodPhaseC(2583L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 2820L
    }
  }

  class UnitTesting : BaseCluster {
    enum class Attribute(val id: Long) {
      Boolean(0L),
      Bitmap8(1L),
      Bitmap16(2L),
      Bitmap32(3L),
      Bitmap64(4L),
      Int8u(5L),
      Int16u(6L),
      Int24u(7L),
      Int32u(8L),
      Int40u(9L),
      Int48u(10L),
      Int56u(11L),
      Int64u(12L),
      Int8s(13L),
      Int16s(14L),
      Int24s(15L),
      Int32s(16L),
      Int40s(17L),
      Int48s(18L),
      Int56s(19L),
      Int64s(20L),
      Enum8(21L),
      Enum16(22L),
      FloatSingle(23L),
      FloatDouble(24L),
      OctetString(25L),
      ListInt8u(26L),
      ListOctetString(27L),
      ListStructOctetString(28L),
      LongOctetString(29L),
      CharString(30L),
      LongCharString(31L),
      EpochUs(32L),
      EpochS(33L),
      VendorId(34L),
      ListNullablesAndOptionalsStruct(35L),
      EnumAttr(36L),
      StructAttr(37L),
      RangeRestrictedInt8u(38L),
      RangeRestrictedInt8s(39L),
      RangeRestrictedInt16u(40L),
      RangeRestrictedInt16s(41L),
      ListLongOctetString(42L),
      ListFabricScoped(43L),
      TimedWriteBoolean(48L),
      GeneralErrorBoolean(49L),
      ClusterErrorBoolean(50L),
      Unsupported(255L),
      NullableBoolean(16384L),
      NullableBitmap8(16385L),
      NullableBitmap16(16386L),
      NullableBitmap32(16387L),
      NullableBitmap64(16388L),
      NullableInt8u(16389L),
      NullableInt16u(16390L),
      NullableInt24u(16391L),
      NullableInt32u(16392L),
      NullableInt40u(16393L),
      NullableInt48u(16394L),
      NullableInt56u(16395L),
      NullableInt64u(16396L),
      NullableInt8s(16397L),
      NullableInt16s(16398L),
      NullableInt24s(16399L),
      NullableInt32s(16400L),
      NullableInt40s(16401L),
      NullableInt48s(16402L),
      NullableInt56s(16403L),
      NullableInt64s(16404L),
      NullableEnum8(16405L),
      NullableEnum16(16406L),
      NullableFloatSingle(16407L),
      NullableFloatDouble(16408L),
      NullableOctetString(16409L),
      NullableCharString(16414L),
      NullableEnumAttr(16420L),
      NullableStruct(16421L),
      NullableRangeRestrictedInt8u(16422L),
      NullableRangeRestrictedInt8s(16423L),
      NullableRangeRestrictedInt16u(16424L),
      NullableRangeRestrictedInt16s(16425L),
      WriteOnlyInt8u(16426L),
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    companion object {
      const val ID = 4294048773L
    }
  }

  class FaultInjection : BaseCluster {
    enum class Attribute(val id: Long) {
      GeneratedCommandList(65528L),
      AcceptedCommandList(65529L),
      EventList(65530L),
      AttributeList(65531L),
      FeatureMap(65532L),
      ClusterRevision(65533L);

      companion object {
        @Throws(NoSuchFieldError::class)
        fun value(id: Long): Attribute {
          for (attribute in Attribute.values()) {
            if (attribute.id == id) {
              return attribute
            }
          }
          throw NoSuchFieldError()
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

    override fun getEventName(id: Long): String {
      throw IllegalArgumentException()
    }

    override fun getCommandName(id: Long): String {
      return Command.value(id).toString()
    }

    override fun getAttributeID(name: String): Long {
      return Attribute.valueOf(name).id
    }

    override fun getEventID(name: String): Long {
      throw NoSuchFieldError()
    }

    override fun getCommandID(name: String): Long {
      return Command.valueOf(name).id
    }

    companion object {
      const val ID = 4294048774L
    }
  }

  companion object {
    fun getCluster(clusterId: Long): BaseCluster? {
      if (clusterId == Identify.ID) {
        return Identify()
      }
      if (clusterId == Groups.ID) {
        return Groups()
      }
      if (clusterId == Scenes.ID) {
        return Scenes()
      }
      if (clusterId == OnOff.ID) {
        return OnOff()
      }
      if (clusterId == OnOffSwitchConfiguration.ID) {
        return OnOffSwitchConfiguration()
      }
      if (clusterId == LevelControl.ID) {
        return LevelControl()
      }
      if (clusterId == BinaryInputBasic.ID) {
        return BinaryInputBasic()
      }
      if (clusterId == PulseWidthModulation.ID) {
        return PulseWidthModulation()
      }
      if (clusterId == Descriptor.ID) {
        return Descriptor()
      }
      if (clusterId == Binding.ID) {
        return Binding()
      }
      if (clusterId == AccessControl.ID) {
        return AccessControl()
      }
      if (clusterId == Actions.ID) {
        return Actions()
      }
      if (clusterId == BasicInformation.ID) {
        return BasicInformation()
      }
      if (clusterId == OtaSoftwareUpdateProvider.ID) {
        return OtaSoftwareUpdateProvider()
      }
      if (clusterId == OtaSoftwareUpdateRequestor.ID) {
        return OtaSoftwareUpdateRequestor()
      }
      if (clusterId == LocalizationConfiguration.ID) {
        return LocalizationConfiguration()
      }
      if (clusterId == TimeFormatLocalization.ID) {
        return TimeFormatLocalization()
      }
      if (clusterId == UnitLocalization.ID) {
        return UnitLocalization()
      }
      if (clusterId == PowerSourceConfiguration.ID) {
        return PowerSourceConfiguration()
      }
      if (clusterId == PowerSource.ID) {
        return PowerSource()
      }
      if (clusterId == GeneralCommissioning.ID) {
        return GeneralCommissioning()
      }
      if (clusterId == NetworkCommissioning.ID) {
        return NetworkCommissioning()
      }
      if (clusterId == DiagnosticLogs.ID) {
        return DiagnosticLogs()
      }
      if (clusterId == GeneralDiagnostics.ID) {
        return GeneralDiagnostics()
      }
      if (clusterId == SoftwareDiagnostics.ID) {
        return SoftwareDiagnostics()
      }
      if (clusterId == ThreadNetworkDiagnostics.ID) {
        return ThreadNetworkDiagnostics()
      }
      if (clusterId == WiFiNetworkDiagnostics.ID) {
        return WiFiNetworkDiagnostics()
      }
      if (clusterId == EthernetNetworkDiagnostics.ID) {
        return EthernetNetworkDiagnostics()
      }
      if (clusterId == TimeSynchronization.ID) {
        return TimeSynchronization()
      }
      if (clusterId == BridgedDeviceBasicInformation.ID) {
        return BridgedDeviceBasicInformation()
      }
      if (clusterId == Switch.ID) {
        return Switch()
      }
      if (clusterId == AdministratorCommissioning.ID) {
        return AdministratorCommissioning()
      }
      if (clusterId == OperationalCredentials.ID) {
        return OperationalCredentials()
      }
      if (clusterId == GroupKeyManagement.ID) {
        return GroupKeyManagement()
      }
      if (clusterId == FixedLabel.ID) {
        return FixedLabel()
      }
      if (clusterId == UserLabel.ID) {
        return UserLabel()
      }
      if (clusterId == ProxyConfiguration.ID) {
        return ProxyConfiguration()
      }
      if (clusterId == ProxyDiscovery.ID) {
        return ProxyDiscovery()
      }
      if (clusterId == ProxyValid.ID) {
        return ProxyValid()
      }
      if (clusterId == BooleanState.ID) {
        return BooleanState()
      }
      if (clusterId == IcdManagement.ID) {
        return IcdManagement()
      }
      if (clusterId == ModeSelect.ID) {
        return ModeSelect()
      }
      if (clusterId == LaundryWasherMode.ID) {
        return LaundryWasherMode()
      }
      if (clusterId == RefrigeratorAndTemperatureControlledCabinetMode.ID) {
        return RefrigeratorAndTemperatureControlledCabinetMode()
      }
      if (clusterId == LaundryWasherControls.ID) {
        return LaundryWasherControls()
      }
      if (clusterId == RvcRunMode.ID) {
        return RvcRunMode()
      }
      if (clusterId == RvcCleanMode.ID) {
        return RvcCleanMode()
      }
      if (clusterId == TemperatureControl.ID) {
        return TemperatureControl()
      }
      if (clusterId == RefrigeratorAlarm.ID) {
        return RefrigeratorAlarm()
      }
      if (clusterId == DishwasherMode.ID) {
        return DishwasherMode()
      }
      if (clusterId == AirQuality.ID) {
        return AirQuality()
      }
      if (clusterId == SmokeCoAlarm.ID) {
        return SmokeCoAlarm()
      }
      if (clusterId == DishwasherAlarm.ID) {
        return DishwasherAlarm()
      }
      if (clusterId == OperationalState.ID) {
        return OperationalState()
      }
      if (clusterId == RvcOperationalState.ID) {
        return RvcOperationalState()
      }
      if (clusterId == HepaFilterMonitoring.ID) {
        return HepaFilterMonitoring()
      }
      if (clusterId == ActivatedCarbonFilterMonitoring.ID) {
        return ActivatedCarbonFilterMonitoring()
      }
      if (clusterId == DoorLock.ID) {
        return DoorLock()
      }
      if (clusterId == WindowCovering.ID) {
        return WindowCovering()
      }
      if (clusterId == BarrierControl.ID) {
        return BarrierControl()
      }
      if (clusterId == PumpConfigurationAndControl.ID) {
        return PumpConfigurationAndControl()
      }
      if (clusterId == Thermostat.ID) {
        return Thermostat()
      }
      if (clusterId == FanControl.ID) {
        return FanControl()
      }
      if (clusterId == ThermostatUserInterfaceConfiguration.ID) {
        return ThermostatUserInterfaceConfiguration()
      }
      if (clusterId == ColorControl.ID) {
        return ColorControl()
      }
      if (clusterId == BallastConfiguration.ID) {
        return BallastConfiguration()
      }
      if (clusterId == IlluminanceMeasurement.ID) {
        return IlluminanceMeasurement()
      }
      if (clusterId == TemperatureMeasurement.ID) {
        return TemperatureMeasurement()
      }
      if (clusterId == PressureMeasurement.ID) {
        return PressureMeasurement()
      }
      if (clusterId == FlowMeasurement.ID) {
        return FlowMeasurement()
      }
      if (clusterId == RelativeHumidityMeasurement.ID) {
        return RelativeHumidityMeasurement()
      }
      if (clusterId == OccupancySensing.ID) {
        return OccupancySensing()
      }
      if (clusterId == CarbonMonoxideConcentrationMeasurement.ID) {
        return CarbonMonoxideConcentrationMeasurement()
      }
      if (clusterId == CarbonDioxideConcentrationMeasurement.ID) {
        return CarbonDioxideConcentrationMeasurement()
      }
      if (clusterId == NitrogenDioxideConcentrationMeasurement.ID) {
        return NitrogenDioxideConcentrationMeasurement()
      }
      if (clusterId == OzoneConcentrationMeasurement.ID) {
        return OzoneConcentrationMeasurement()
      }
      if (clusterId == Pm25ConcentrationMeasurement.ID) {
        return Pm25ConcentrationMeasurement()
      }
      if (clusterId == FormaldehydeConcentrationMeasurement.ID) {
        return FormaldehydeConcentrationMeasurement()
      }
      if (clusterId == Pm1ConcentrationMeasurement.ID) {
        return Pm1ConcentrationMeasurement()
      }
      if (clusterId == Pm10ConcentrationMeasurement.ID) {
        return Pm10ConcentrationMeasurement()
      }
      if (clusterId == TotalVolatileOrganicCompoundsConcentrationMeasurement.ID) {
        return TotalVolatileOrganicCompoundsConcentrationMeasurement()
      }
      if (clusterId == RadonConcentrationMeasurement.ID) {
        return RadonConcentrationMeasurement()
      }
      if (clusterId == WakeOnLan.ID) {
        return WakeOnLan()
      }
      if (clusterId == Channel.ID) {
        return Channel()
      }
      if (clusterId == TargetNavigator.ID) {
        return TargetNavigator()
      }
      if (clusterId == MediaPlayback.ID) {
        return MediaPlayback()
      }
      if (clusterId == MediaInput.ID) {
        return MediaInput()
      }
      if (clusterId == LowPower.ID) {
        return LowPower()
      }
      if (clusterId == KeypadInput.ID) {
        return KeypadInput()
      }
      if (clusterId == ContentLauncher.ID) {
        return ContentLauncher()
      }
      if (clusterId == AudioOutput.ID) {
        return AudioOutput()
      }
      if (clusterId == ApplicationLauncher.ID) {
        return ApplicationLauncher()
      }
      if (clusterId == ApplicationBasic.ID) {
        return ApplicationBasic()
      }
      if (clusterId == AccountLogin.ID) {
        return AccountLogin()
      }
      if (clusterId == ElectricalMeasurement.ID) {
        return ElectricalMeasurement()
      }
      if (clusterId == UnitTesting.ID) {
        return UnitTesting()
      }
      if (clusterId == FaultInjection.ID) {
        return FaultInjection()
      }
      return null
    }
  }

  interface BaseCluster {
    fun getID(): Long

    @Throws(NoSuchFieldError::class) fun getAttributeName(id: Long): String

    @Throws(NoSuchFieldError::class) fun getEventName(id: Long): String

    @Throws(NoSuchFieldError::class) fun getCommandName(id: Long): String

    @Throws(IllegalArgumentException::class) fun getAttributeID(name: String): Long

    @Throws(IllegalArgumentException::class) fun getEventID(name: String): Long

    @Throws(IllegalArgumentException::class) fun getCommandID(name: String): Long
  }
}
