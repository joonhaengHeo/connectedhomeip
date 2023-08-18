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

object OperationalCredentials : BaseCluster() {
  const val ID = 62L

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

  sealed class Command(val id: Long, val name: String) {
    object AttestationRequest : Command(0L, "AttestationRequest")

    object CertificateChainRequest : Command(2L, "CertificateChainRequest")

    object CSRRequest : Command(4L, "CSRRequest")

    object AddNOC : Command(6L, "AddNOC")

    object UpdateNOC : Command(7L, "UpdateNOC")

    object UpdateFabricLabel : Command(9L, "UpdateFabricLabel")

    object RemoveFabric : Command(10L, "RemoveFabric")

    object AddTrustedRootCertificate : Command(11L, "AddTrustedRootCertificate")

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

  sealed class AttestationRequestCommandField(val id: Int, val name: String) {
    object AttestationNonce : AttestationRequestCommandField(0, "AttestationNonce")

    companion object {
      fun values(): List<AttestationRequestCommandField> {
        return AttestationRequestCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): AttestationRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): AttestationRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class CertificateChainRequestCommandField(val id: Int, val name: String) {
    object CertificateType : CertificateChainRequestCommandField(0, "CertificateType")

    companion object {
      fun values(): List<CertificateChainRequestCommandField> {
        return CertificateChainRequestCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): CertificateChainRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): CertificateChainRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class CSRRequestCommandField(val id: Int, val name: String) {
    object CSRNonce : CSRRequestCommandField(0, "CSRNonce")

    object IsForUpdateNOC : CSRRequestCommandField(1, "IsForUpdateNOC")

    companion object {
      fun values(): List<CSRRequestCommandField> {
        return CSRRequestCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): CSRRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): CSRRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class AddNOCCommandField(val id: Int, val name: String) {
    object NOCValue : AddNOCCommandField(0, "NOCValue")

    object ICACValue : AddNOCCommandField(1, "ICACValue")

    object IPKValue : AddNOCCommandField(2, "IPKValue")

    object CaseAdminSubject : AddNOCCommandField(3, "CaseAdminSubject")

    object AdminVendorId : AddNOCCommandField(4, "AdminVendorId")

    companion object {
      fun values(): List<AddNOCCommandField> {
        return AddNOCCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): AddNOCCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): AddNOCCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class UpdateNOCCommandField(val id: Int, val name: String) {
    object NOCValue : UpdateNOCCommandField(0, "NOCValue")

    object ICACValue : UpdateNOCCommandField(1, "ICACValue")

    companion object {
      fun values(): List<UpdateNOCCommandField> {
        return UpdateNOCCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): UpdateNOCCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): UpdateNOCCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class UpdateFabricLabelCommandField(val id: Int, val name: String) {
    object Label : UpdateFabricLabelCommandField(0, "Label")

    companion object {
      fun values(): List<UpdateFabricLabelCommandField> {
        return UpdateFabricLabelCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): UpdateFabricLabelCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): UpdateFabricLabelCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class RemoveFabricCommandField(val id: Int, val name: String) {
    object FabricIndex : RemoveFabricCommandField(0, "FabricIndex")

    companion object {
      fun values(): List<RemoveFabricCommandField> {
        return RemoveFabricCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): RemoveFabricCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): RemoveFabricCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class AddTrustedRootCertificateCommandField(val id: Int, val name: String) {
    object RootCACertificate : AddTrustedRootCertificateCommandField(0, "RootCACertificate")

    companion object {
      fun values(): List<AddTrustedRootCertificateCommandField> {
        return AddTrustedRootCertificateCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): AddTrustedRootCertificateCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): AddTrustedRootCertificateCommandField {
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
