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

object OtaSoftwareUpdateProvider : BaseCluster() {
  const val ID = 41L

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

  sealed class Command(val id: Long, val name: String) {
    object QueryImage : Command(0L, "QueryImage")

    object ApplyUpdateRequest : Command(2L, "ApplyUpdateRequest")

    object NotifyUpdateApplied : Command(4L, "NotifyUpdateApplied")

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

  sealed class QueryImageCommandField(val id: Int, val name: String) {
    object VendorID : QueryImageCommandField(0, "VendorID")

    object ProductID : QueryImageCommandField(1, "ProductID")

    object SoftwareVersion : QueryImageCommandField(2, "SoftwareVersion")

    object ProtocolsSupported : QueryImageCommandField(3, "ProtocolsSupported")

    object HardwareVersion : QueryImageCommandField(4, "HardwareVersion")

    object Location : QueryImageCommandField(5, "Location")

    object RequestorCanConsent : QueryImageCommandField(6, "RequestorCanConsent")

    object MetadataForProvider : QueryImageCommandField(7, "MetadataForProvider")

    companion object {
      fun values(): List<QueryImageCommandField> {
        return QueryImageCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): QueryImageCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): QueryImageCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class ApplyUpdateRequestCommandField(val id: Int, val name: String) {
    object UpdateToken : ApplyUpdateRequestCommandField(0, "UpdateToken")

    object NewVersion : ApplyUpdateRequestCommandField(1, "NewVersion")

    companion object {
      fun values(): List<ApplyUpdateRequestCommandField> {
        return ApplyUpdateRequestCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): ApplyUpdateRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): ApplyUpdateRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class NotifyUpdateAppliedCommandField(val id: Int, val name: String) {
    object UpdateToken : NotifyUpdateAppliedCommandField(0, "UpdateToken")

    object SoftwareVersion : NotifyUpdateAppliedCommandField(1, "SoftwareVersion")

    companion object {
      fun values(): List<NotifyUpdateAppliedCommandField> {
        return NotifyUpdateAppliedCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): NotifyUpdateAppliedCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): NotifyUpdateAppliedCommandField {
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
