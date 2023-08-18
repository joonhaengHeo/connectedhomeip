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

object ElectricalMeasurement : BaseCluster() {
  const val ID = 2820L

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

  sealed class Command(val id: Long, val name: String) {
    object GetProfileInfoCommand : Command(0L, "GetProfileInfoCommand")

    object GetMeasurementProfileCommand : Command(1L, "GetMeasurementProfileCommand")

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

  sealed class GetMeasurementProfileCommandCommandField(val id: Int, val name: String) {
    object AttributeId : GetMeasurementProfileCommandCommandField(0, "AttributeId")

    object StartTime : GetMeasurementProfileCommandCommandField(1, "StartTime")

    object NumberOfIntervals : GetMeasurementProfileCommandCommandField(2, "NumberOfIntervals")

    companion object {
      fun values(): List<GetMeasurementProfileCommandCommandField> {
        return GetMeasurementProfileCommandCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): GetMeasurementProfileCommandCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): GetMeasurementProfileCommandCommandField {
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
