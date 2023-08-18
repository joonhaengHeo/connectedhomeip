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

object ThreadNetworkDiagnostics : BaseCluster() {
  const val ID = 53L

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

    object BetterPartitionAttachAttemptCount : Attribute(20L, "BetterPartitionAttachAttemptCount")

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

  sealed class Event(val id: Long, val name: String) {
    object ConnectionStatus : Event(0L, "ConnectionStatus")

    object NetworkFaultChange : Event(1L, "NetworkFaultChange")

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
    object ResetCounts : Command(0L, "ResetCounts")

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
