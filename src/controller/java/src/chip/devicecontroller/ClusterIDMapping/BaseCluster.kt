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

abstract class BaseCluster {
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