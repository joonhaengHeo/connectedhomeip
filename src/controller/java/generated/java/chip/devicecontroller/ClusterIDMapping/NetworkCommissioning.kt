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

object NetworkCommissioning : BaseCluster() {
  const val ID = 49L

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

  sealed class Command(val id: Long, val name: String) {
    object ScanNetworks : Command(0L, "ScanNetworks")

    object AddOrUpdateWiFiNetwork : Command(2L, "AddOrUpdateWiFiNetwork")

    object AddOrUpdateThreadNetwork : Command(3L, "AddOrUpdateThreadNetwork")

    object RemoveNetwork : Command(4L, "RemoveNetwork")

    object ConnectNetwork : Command(6L, "ConnectNetwork")

    object ReorderNetwork : Command(8L, "ReorderNetwork")

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

  sealed class ScanNetworksCommandField(val id: Int, val name: String) {
    object Ssid : ScanNetworksCommandField(0, "Ssid")

    object Breadcrumb : ScanNetworksCommandField(1, "Breadcrumb")

    companion object {
      fun values(): List<ScanNetworksCommandField> {
        return ScanNetworksCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): ScanNetworksCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): ScanNetworksCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class AddOrUpdateWiFiNetworkCommandField(val id: Int, val name: String) {
    object Ssid : AddOrUpdateWiFiNetworkCommandField(0, "Ssid")

    object Credentials : AddOrUpdateWiFiNetworkCommandField(1, "Credentials")

    object Breadcrumb : AddOrUpdateWiFiNetworkCommandField(2, "Breadcrumb")

    companion object {
      fun values(): List<AddOrUpdateWiFiNetworkCommandField> {
        return AddOrUpdateWiFiNetworkCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): AddOrUpdateWiFiNetworkCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): AddOrUpdateWiFiNetworkCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class AddOrUpdateThreadNetworkCommandField(val id: Int, val name: String) {
    object OperationalDataset : AddOrUpdateThreadNetworkCommandField(0, "OperationalDataset")

    object Breadcrumb : AddOrUpdateThreadNetworkCommandField(1, "Breadcrumb")

    companion object {
      fun values(): List<AddOrUpdateThreadNetworkCommandField> {
        return AddOrUpdateThreadNetworkCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): AddOrUpdateThreadNetworkCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): AddOrUpdateThreadNetworkCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class RemoveNetworkCommandField(val id: Int, val name: String) {
    object NetworkID : RemoveNetworkCommandField(0, "NetworkID")

    object Breadcrumb : RemoveNetworkCommandField(1, "Breadcrumb")

    companion object {
      fun values(): List<RemoveNetworkCommandField> {
        return RemoveNetworkCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): RemoveNetworkCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): RemoveNetworkCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class ConnectNetworkCommandField(val id: Int, val name: String) {
    object NetworkID : ConnectNetworkCommandField(0, "NetworkID")

    object Breadcrumb : ConnectNetworkCommandField(1, "Breadcrumb")

    companion object {
      fun values(): List<ConnectNetworkCommandField> {
        return ConnectNetworkCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): ConnectNetworkCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): ConnectNetworkCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class ReorderNetworkCommandField(val id: Int, val name: String) {
    object NetworkID : ReorderNetworkCommandField(0, "NetworkID")

    object NetworkIndex : ReorderNetworkCommandField(1, "NetworkIndex")

    object Breadcrumb : ReorderNetworkCommandField(2, "Breadcrumb")

    companion object {
      fun values(): List<ReorderNetworkCommandField> {
        return ReorderNetworkCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): ReorderNetworkCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): ReorderNetworkCommandField {
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
