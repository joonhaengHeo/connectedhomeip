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

object Groups : BaseCluster() {
  const val ID = 4L

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

  sealed class Command(val id: Long, val name: String) {
    object AddGroup : Command(0L, "AddGroup")

    object ViewGroup : Command(1L, "ViewGroup")

    object GetGroupMembership : Command(2L, "GetGroupMembership")

    object RemoveGroup : Command(3L, "RemoveGroup")

    object RemoveAllGroups : Command(4L, "RemoveAllGroups")

    object AddGroupIfIdentifying : Command(5L, "AddGroupIfIdentifying")

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

  sealed class AddGroupCommandField(val id: Int, val name: String) {
    object GroupID : AddGroupCommandField(0, "GroupID")

    object GroupName : AddGroupCommandField(1, "GroupName")

    companion object {
      fun values(): List<AddGroupCommandField> {
        return AddGroupCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): AddGroupCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): AddGroupCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class ViewGroupCommandField(val id: Int, val name: String) {
    object GroupID : ViewGroupCommandField(0, "GroupID")

    companion object {
      fun values(): List<ViewGroupCommandField> {
        return ViewGroupCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): ViewGroupCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): ViewGroupCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class GetGroupMembershipCommandField(val id: Int, val name: String) {
    object GroupList : GetGroupMembershipCommandField(0, "GroupList")

    companion object {
      fun values(): List<GetGroupMembershipCommandField> {
        return GetGroupMembershipCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): GetGroupMembershipCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): GetGroupMembershipCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class RemoveGroupCommandField(val id: Int, val name: String) {
    object GroupID : RemoveGroupCommandField(0, "GroupID")

    companion object {
      fun values(): List<RemoveGroupCommandField> {
        return RemoveGroupCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): RemoveGroupCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): RemoveGroupCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class AddGroupIfIdentifyingCommandField(val id: Int, val name: String) {
    object GroupID : AddGroupIfIdentifyingCommandField(0, "GroupID")

    object GroupName : AddGroupIfIdentifyingCommandField(1, "GroupName")

    companion object {
      fun values(): List<AddGroupIfIdentifyingCommandField> {
        return AddGroupIfIdentifyingCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): AddGroupIfIdentifyingCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): AddGroupIfIdentifyingCommandField {
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
