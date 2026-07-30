/*
 *
 *    Copyright (c) 2026 Project CHIP Authors
 *    All rights reserved.
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

#pragma once

#include <app/OperationalSessionSetup.h>
#include <controller/CHIPDeviceController.h>
#include <lib/core/CHIPCallback.h>
#include <lib/support/JniReferences.h>
#include <lib/support/JniTypeWrappers.h>

#include "BdxDiagnosticLogsReceiver.h"

namespace chip {
namespace Controller {

/**
 * A helper class to capture and download a snapshot from a node via BDX given some parameters.
 */
class AndroidCaptureSnapshotFromNode
{
public:
    /*
     * @brief
     *   Try to look up the device attached to our controller with the given
     *   remote node id and ask it to capture and transfer a snapshot.
     *   If function returns an error, callback will never be executed. Otherwise, callback will always be executed.
     *
     * @param[in] controller The device controller
     * @param[in] remoteNodeId The remote device Id
     * @param[in] request CaptureSnapshot request parameters
     * @param[in] timeout Snapshot transfer timeout value. If this value is 0, controller does not handle timeouts.
     * @param[in] jCallbackObject The callback to call when Snapshot data is received and when an error occurs
     */
    static CHIP_ERROR CaptureSnapshotFromNode(DeviceController * controller, NodeId remoteNodeId, EndpointId remoteEndpointId,
                                          app::Clusters::CameraAvStreamManagement::Commands::CaptureSnapshot::Type request, uint16_t timeout,
                                          jobject jCallbackObject);

    // mFileDesignator spans into this object's own mFileDesignatorBuffer, so a copy would alias the
    // source's. Forbid copying explicitly, pinning the invariant to the buffer rather than to the
    // Callback members.
    AndroidCaptureSnapshotFromNode(const AndroidCaptureSnapshotFromNode &)             = delete;
    AndroidCaptureSnapshotFromNode & operator=(const AndroidCaptureSnapshotFromNode &) = delete;

private:
    AndroidCaptureSnapshotFromNode(DeviceController * controller, NodeId remoteNodeId, EndpointId remoteEndpointId, app::Clusters::CameraAvStreamManagement::Commands::CaptureSnapshot::Type request,
                               uint16_t timeout, jobject javaCallback);

    ~AndroidCaptureSnapshotFromNode() {}

    DeviceController * mController = nullptr;

    chip::Callback::Callback<OnDeviceConnected> mOnDeviceConnectedCallback;
    chip::Callback::Callback<OnDeviceConnectionFailure> mOnDeviceConnectionFailureCallback;
    chip::Callback::Callback<OnBdxTransfer> mOnBdxTransferCallback;
    chip::Callback::Callback<OnBdxTransferSuccess> mOnBdxTransferSuccessCallback;
    chip::Callback::Callback<OnBdxTransferFailure> mOnBdxTransferFailureCallback;

    chip::JniGlobalReference mJavaCallback;
    NodeId mRemoteNodeId                              = chip::kUndefinedNodeId;
    EndpointId mRemoteEndpointId                      = chip::kInvalidEndpointId;

    app::Clusters::CameraAvStreamManagement::Commands::CaptureSnapshot::Type mRequest;
    uint16_t mTimeout                                 = 0;

    char mFileDesignatorBuffer[bdx::DiagnosticLogs::kMaxFileDesignatorLen];
    MutableCharSpan mFileDesignator = MutableCharSpan(mFileDesignatorBuffer, bdx::DiagnosticLogs::kMaxFileDesignatorLen);

    BdxDiagnosticLogsReceiver * mBdxReceiver = nullptr;

    CHIP_ERROR GetConnectedDevice();
    CHIP_ERROR SendCaptureSnapshot(Messaging::ExchangeManager & exchangeMgr, const SessionHandle & sessionHandle);
    void OnTransferCallback(FabricIndex fabricIndex, NodeId remoteNodeId, const chip::ByteSpan & data,
                            CHIP_ERROR * errInfoOnFailure);
    static void FinishCaptureSnapshotFromNode(void * context, CHIP_ERROR err);

    static void OnDeviceConnectedFn(void * context, Messaging::ExchangeManager & exchangeMgr, const SessionHandle & sessionHandle);
    static void OnDeviceConnectionFailureFn(void * context, const ScopedNodeId & peerId, CHIP_ERROR error);

    static void OnResponseCaptureSnapshot(void * context,
                                       const app::Clusters::CameraAvStreamManagement::Commands::CaptureSnapshotResponse::DecodableType & data);
    static void OnCommandFailure(void * context, CHIP_ERROR err);

    static void OnBdxTransferCallback(void * context, FabricIndex fabricIndex, NodeId remoteNodeId, const chip::ByteSpan & data,
                                      CHIP_ERROR * errInfoOnFailure);
    static void OnBdxTransferSuccessCallback(void * context, FabricIndex fabricIndex, NodeId remoteNodeId);
    static void OnBdxTransferFailureCallback(void * context, FabricIndex fabricIndex, NodeId remoteNodeId, CHIP_ERROR status);
};

} // namespace Controller
} // namespace chip