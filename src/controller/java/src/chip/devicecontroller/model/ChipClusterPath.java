/*
 *   Copyright (c) 2022 Project CHIP Authors
 *   All rights reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package chip.devicecontroller.model;

import java.util.Locale;
import java.util.Objects;

/** An attribute path that should be used for requests. */
public class ChipClusterPath {
  protected ChipPathId endpointId, clusterId;

  protected ChipClusterPath(ChipPathId endpointId, ChipPathId clusterId) {
    this.endpointId = endpointId;
    this.clusterId = clusterId;
  }

  public ChipPathId getEndpointId() {
    return endpointId;
  }

  public ChipPathId getClusterId() {
    return clusterId;
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof ChipClusterPath) {
      ChipClusterPath that = (ChipClusterPath) object;
      return Objects.equals(this.endpointId, that.endpointId)
          && Objects.equals(this.clusterId, that.clusterId);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(endpointId, clusterId);
  }

  @Override
  public String toString() {
    return String.format(
        Locale.ENGLISH,
        "Endpoint %s, cluster %s",
        endpointId,
        clusterId);
  }

  public static ChipClusterPath newInstance(
      ChipPathId endpointId, ChipPathId clusterId) {
    return new ChipClusterPath(endpointId, clusterId);
  }

  /** Create a new {@link ChipAttributePath} with only concrete ids. */
  public static ChipClusterPath newInstance(int endpointId, long clusterId) {
    return new ChipClusterPath(
        ChipPathId.forId(endpointId), ChipPathId.forId(clusterId));
  }
}
