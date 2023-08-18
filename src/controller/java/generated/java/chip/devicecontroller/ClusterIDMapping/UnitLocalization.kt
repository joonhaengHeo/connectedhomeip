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

object UnitLocalization : BaseCluster() {
  const val ID = 45L

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
}
