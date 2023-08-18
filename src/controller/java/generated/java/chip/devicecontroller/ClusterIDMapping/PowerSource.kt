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

object PowerSource : BaseCluster() {
  const val ID = 47L

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

  sealed class Event(val id: Long, val name: String) {
    object WiredFaultChange : Event(0L, "WiredFaultChange")

    object BatFaultChange : Event(1L, "BatFaultChange")

    object BatChargeFaultChange : Event(2L, "BatChargeFaultChange")

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
}
