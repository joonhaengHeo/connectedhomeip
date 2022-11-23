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
public class MatterAttributeData {
  private Integer dataVersion = null;
  private ChipAttributePath path = null;
  private byte[] dataTlv = null;

  private MatterAttributeData(Integer dataVersion, ChipAttributePath path, byte[] dataTlv) {
    this.dataVersion = dataVersion;
    this.path = path;
    this.dataTlv = dataTlv;
  }

  public Integer getDataVersion() {
    return dataVersion;
  }

  public ChipAttributePath getPath() {
    return path;
  }

  public byte[] getDataTlv() {
    return dataTlv;
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof MatterAttributeData) {
      MatterAttributeData that = (MatterAttributeData) object;
      return Objects.equals(this.dataVersion, that.dataVersion)
          && Objects.equals(this.path, that.path)
          && Objects.equals(this.dataTlv, that.dataTlv);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataVersion, path, dataTlv);
  }

  @Override
  public String toString() {
    return String.format(
        Locale.ENGLISH,
        "dataVersion %d, path %s, data %s, dataTlv.length %d",
        dataVersion,
        path,
        dataTlv.length);
  }

  public static MatterAttributeData newInstance(Integer dataVersion, ChipAttributePath path, byte[] dataTlv) {
    return new MatterAttributeData(dataVersion, path, dataTlv);
  }
}
