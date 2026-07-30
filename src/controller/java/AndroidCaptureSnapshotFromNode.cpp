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

#include "AndroidCaptureSnapshotFromNode.h"

#include <app-common/zap-generated/cluster-enums.h>
#include <app-common/zap-generated/cluster-objects.h>
#include <controller/CHIPDeviceControllerFactory.h>
#include <protocols/bdx/BdxUri.h>

using namespace chip::app::Clusters;

namespace chip {
namespace Controller {

constexpr const char * kDefaultSnapshotFileDesignator = "Capture";

AndroidCaptureSnapshotFromNode::AndroidCaptureSnapshotFromNode(chip::Controller::DeviceController * controller, NodeId remoteNodeId, EndpointId remoteEndpointId,
                                                       const chip::app::Clusters::CameraAvStreamManagement::Commands::CaptureSnapshot::Type request, uint16_t timeout,
                                                       jobject jCallbackObject) :
    mController(controller),
    mOnDeviceConnectedCallback(&OnDeviceConnectedFn, this), mOnDeviceConnectionFailureCallback(&OnDeviceConnectionFailureFn, this),
    mOnBdxTransferCallback(&OnBdxTransferCallback, this), mOnBdxTransferSuccessCallback(&OnBdxTransferSuccessCallback, this),
    mOnBdxTransferFailureCallback(&OnBdxTransferFailureCallback, this)
{
    mRemoteNodeId     = remoteNodeId;
    mRemoteEndpointId = remoteEndpointId;
    mRequest          = request;
    mTimeout          = timeout;

    if (mJavaCallback.Init(jCallbackObject) != CHIP_NO_ERROR)
    {
        ChipLogError(Controller, "Fail to init mJavaObjectRef");
        return;
    }
}

CHIP_ERROR AndroidCaptureSnapshotFromNode::CaptureSnapshotFromNode(DeviceController * controller, NodeId remoteNodeId, EndpointId remoteEndpointId,
                                                           const chip::app::Clusters::CameraAvStreamManagement::Commands::CaptureSnapshot::Type request, uint16_t timeout, jobject jcallback)
{
    VerifyOrReturnValue(controller != nullptr && jcallback != nullptr && remoteNodeId != kUndefinedNodeId && remoteEndpointId != kInvalidEndpointId,
                        CHIP_ERROR_INVALID_ARGUMENT);

    auto * captureSnapshot = new AndroidCaptureSnapshotFromNode(controller, remoteNodeId, remoteEndpointId, request, timeout, jcallback);
    VerifyOrReturnValue(captureSnapshot != nullptr, CHIP_ERROR_NO_MEMORY);

    CHIP_ERROR err = captureSnapshot->GetConnectedDevice();

    if (err != CHIP_NO_ERROR)
    {
        delete captureSnapshot;
        captureSnapshot = nullptr;
    }
    // Else will clean up when the callback is called.
    return err;
}

CHIP_ERROR AndroidCaptureSnapshotFromNode::GetConnectedDevice()
{
    return mController->GetConnectedDevice(mRemoteNodeId, &mOnDeviceConnectedCallback, &mOnDeviceConnectionFailureCallback, TransportPayloadCapability::kLargePayload);
}

CHIP_ERROR AndroidCaptureSnapshotFromNode::SendCaptureSnapshot(Messaging::ExchangeManager & exchangeMgr,
                                                               const SessionHandle & sessionHandle)
{
    if (mRequest.requestedProtocol == CameraAvStreamManagement::ProtocolsEnum::kBdx)
    {
        CharSpan designatorSpan;

        if (!mRequest.transferFileDesignator.HasValue())
        {
            ChipLogProgress(Controller, "BDX protocol requested but transferFileDesignator is missing. Using default '%s'.", kDefaultSnapshotFileDesignator);
            designatorSpan = CharSpan(kDefaultSnapshotFileDesignator, strlen(kDefaultSnapshotFileDesignator));
        }
        else
        {
            designatorSpan = mRequest.transferFileDesignator.Value();
        }

        CHIP_ERROR err = chip::bdx::MakeURI(mRemoteNodeId, designatorSpan, mFileDesignator);
        mRequest.transferFileDesignator.SetValue(mFileDesignator);

        if (err != CHIP_NO_ERROR)
        {
            ChipLogError(Controller, "Make BDX URI failure : %" CHIP_ERROR_FORMAT, err.Format());
            FinishCaptureSnapshotFromNode(static_cast<void *>(this), err);
            return err;
        }

        mBdxReceiver =
            new BdxDiagnosticLogsReceiver(&mOnBdxTransferCallback, &mOnBdxTransferSuccessCallback, &mOnBdxTransferFailureCallback,
                                          mController->GetFabricIndex(), mRemoteNodeId, mFileDesignator);
        VerifyOrReturnValue(mBdxReceiver != nullptr, CHIP_ERROR_NO_MEMORY);

        auto systemState = DeviceControllerFactory::GetInstance().GetSystemState();
        systemState->BDXTransferServer()->SetDelegate(mBdxReceiver);

        if (mTimeout > 0)
        {
            TEMPORARY_RETURN_IGNORED mBdxReceiver->StartBDXTransferTimeout(mTimeout);
        }
    }
    else if (mRequest.requestedProtocol == CameraAvStreamManagement::ProtocolsEnum::kResponsePayload)
    {
        ChipLogProgress(Controller, "Requested protocol is ResponsePayload. Skipping BDX setup.");
    }
    else
    {
        ChipLogError(Controller, "Unknown or unsupported protocol requested.");
        FinishCaptureSnapshotFromNode(static_cast<void *>(this), CHIP_ERROR_INVALID_ARGUMENT);
        return CHIP_ERROR_INVALID_ARGUMENT;
    }
    
    ClusterBase cluster(exchangeMgr, sessionHandle, mRemoteEndpointId);

    return cluster.InvokeCommand(mRequest, this, OnResponseCaptureSnapshot, OnCommandFailure);
}

void AndroidCaptureSnapshotFromNode::OnDeviceConnectedFn(void * context, Messaging::ExchangeManager & exchangeMgr,
                                                     const SessionHandle & sessionHandle)
{
    CHIP_ERROR err = CHIP_NO_ERROR;
    auto * self    = static_cast<AndroidCaptureSnapshotFromNode *>(context);
    VerifyOrReturn(self != nullptr, ChipLogProgress(Controller, "Device connected callback with null context. Ignoring"));

    err = self->SendCaptureSnapshot(exchangeMgr, sessionHandle);
    if (err != CHIP_NO_ERROR)
    {
        ChipLogError(Controller, "Snapshot Capture failure : %" CHIP_ERROR_FORMAT, err.Format());
        FinishCaptureSnapshotFromNode(context, err);
    }
}

void AndroidCaptureSnapshotFromNode::OnDeviceConnectionFailureFn(void * context, const ScopedNodeId & peerId, CHIP_ERROR err)
{
    ChipLogProgress(Controller, "OnDeviceConnectionFailureFn: %" CHIP_ERROR_FORMAT, err.Format());
    FinishCaptureSnapshotFromNode(context, err);
}

void AndroidCaptureSnapshotFromNode::OnResponseCaptureSnapshot(void * context,
                                                        const CameraAvStreamManagement::Commands::CaptureSnapshotResponse::DecodableType & data)
{
    auto * self = static_cast<AndroidCaptureSnapshotFromNode *>(context);
    VerifyOrReturn(self != nullptr,
                   ChipLogProgress(Controller, "Success callback with null context. Ignoring"));

    if (self->mRequest.requestedProtocol == CameraAvStreamManagement::ProtocolsEnum::kResponsePayload)
    {
        if (!data.data.empty())
        {
            ChipLogProgress(Controller, "Snapshot received inline in response.");
            CHIP_ERROR err = CHIP_NO_ERROR;
            self->OnTransferCallback(self->mController->GetFabricIndex(), self->mRemoteNodeId, data.data, &err);
            FinishCaptureSnapshotFromNode(context, err);
        }
        else
        {
            ChipLogError(Controller, "Snapshot data is empty but requested protocol is ResponsePayload.");
            FinishCaptureSnapshotFromNode(context, CHIP_ERROR_INCORRECT_STATE);
        }
    }
    else if (self->mRequest.requestedProtocol == CameraAvStreamManagement::ProtocolsEnum::kBdx)
    {
        if (!data.data.empty())
        {
            ChipLogProgress(Controller, "Warning: Snapshot data is not empty but requested protocol is BDX. Ignoring inline data.");
        }
        
        ChipLogProgress(Controller, "Success. Will receive snapshot from BDX protocol.");
    }
    else
    {
        ChipLogError(Controller, "Unknown protocol in response handling.");
        FinishCaptureSnapshotFromNode(context, CHIP_ERROR_INCORRECT_STATE);
    }
}

void AndroidCaptureSnapshotFromNode::OnCommandFailure(void * context, CHIP_ERROR err)
{
    ChipLogProgress(Controller, "OnCommandFailure %" CHIP_ERROR_FORMAT, err.Format());

    auto * self = static_cast<AndroidCaptureSnapshotFromNode *>(context);
    VerifyOrReturn(self != nullptr, ChipLogProgress(Controller, "Send command failure callback with null context. Ignoring"));

    FinishCaptureSnapshotFromNode(context, err);
}

void AndroidCaptureSnapshotFromNode::FinishCaptureSnapshotFromNode(void * context, CHIP_ERROR err)
{
    auto * self = static_cast<AndroidCaptureSnapshotFromNode *>(context);
    VerifyOrReturn(self != nullptr, ChipLogProgress(Controller, "Finish Snapshot Capture with null context. Ignoring"));

    if (self->mBdxReceiver != nullptr)
    {
        if (self->mTimeout > 0 && err != CHIP_ERROR_TIMEOUT)
        {
            self->mBdxReceiver->CancelBDXTransferTimeout();
        }
        delete self->mBdxReceiver;
        self->mBdxReceiver = nullptr;
    }

    CHIP_ERROR jniErr = CHIP_NO_ERROR;
    JNIEnv * env      = JniReferences::GetInstance().GetEnvForCurrentThread();
    JniLocalReferenceScope scope(env);

    jobject jCallback   = self->mJavaCallback.ObjectRef();
    jint jFabricIndex   = static_cast<jint>(self->mController->GetFabricIndex());
    jlong jremoteNodeId = static_cast<jlong>(self->mRemoteNodeId);

    VerifyOrExit(env != nullptr, ChipLogError(Controller, "Could not get JNIEnv for current thread"));

    if (err == CHIP_NO_ERROR)
    {
        ChipLogProgress(Controller, "Snapshot Capture succeeded.");
        jmethodID onSuccessMethod;
        // Java method signature : boolean onSuccess(int fabricIndex, long nodeId)
        jniErr = JniReferences::GetInstance().FindMethod(env, jCallback, "onSuccess", "(IJ)V", &onSuccessMethod);

        VerifyOrExit(jniErr == CHIP_NO_ERROR, ChipLogError(Controller, "Could not find onSuccess method"));

        env->CallVoidMethod(jCallback, onSuccessMethod, jFabricIndex, jremoteNodeId);
    }
    else
    {
        ChipLogError(Controller, "Snapshot Capture Failed : %" CHIP_ERROR_FORMAT, err.Format());

        jmethodID onErrorMethod;
        // Java method signature : void onError(int fabricIndex, long nodeId, long errorCode)
        jniErr = JniReferences::GetInstance().FindMethod(env, jCallback, "onError", "(IJJ)V", &onErrorMethod);
        VerifyOrExit(jniErr == CHIP_NO_ERROR, ChipLogError(Controller, "Could not find onError method"));

        env->CallVoidMethod(jCallback, onErrorMethod, jFabricIndex, jremoteNodeId, static_cast<jlong>(err.AsInteger()));
    }

exit:
    // Finish this function, this object will be deleted.
    delete self;
}

void AndroidCaptureSnapshotFromNode::OnBdxTransferCallback(void * context, FabricIndex fabricIndex, NodeId remoteNodeId,
                                                       const chip::ByteSpan & data, CHIP_ERROR * errInfoOnFailure)
{
    auto * self = static_cast<AndroidCaptureSnapshotFromNode *>(context);
    VerifyOrReturn(self != nullptr, ChipLogProgress(Controller, "Send command failure callback with null context. Ignoring"));

    self->OnTransferCallback(fabricIndex, remoteNodeId, data, errInfoOnFailure);
}

void AndroidCaptureSnapshotFromNode::OnTransferCallback(FabricIndex fabricIndex, NodeId remoteNodeId, const chip::ByteSpan & data,
                                                    CHIP_ERROR * errInfoOnFailure)
{
    VerifyOrReturn(mJavaCallback.HasValidObjectRef(), ChipLogError(Controller, "mJavaCallback is invalid"));

    JNIEnv * env = JniReferences::GetInstance().GetEnvForCurrentThread();
    VerifyOrReturn(env != nullptr, ChipLogError(Controller, "Could not get JNIEnv for current thread"));

    JniLocalReferenceScope scope(env);

    jmethodID onTransferDataMethod;
    // Java method signature : boolean onTransferData(int fabricIndex, long nodeId, byte[] data)
    *errInfoOnFailure =
        JniReferences::GetInstance().FindMethod(env, mJavaCallback.ObjectRef(), "onTransferData", "(IJ[B)Z", &onTransferDataMethod);
    VerifyOrReturn(*errInfoOnFailure == CHIP_NO_ERROR, ChipLogError(Controller, "Could not find onTransferData method"));
    chip::ByteArray dataByteArray(env, data);

    jboolean ret = env->CallBooleanMethod(mJavaCallback.ObjectRef(), onTransferDataMethod, static_cast<jint>(fabricIndex),
                                          static_cast<jlong>(remoteNodeId), dataByteArray.jniValue());

    if (ret != JNI_TRUE)
    {
        ChipLogError(Controller, "Transfer will be rejected.");
        *errInfoOnFailure = CHIP_ERROR_INTERNAL;
    }
}

void AndroidCaptureSnapshotFromNode::OnBdxTransferSuccessCallback(void * context, FabricIndex fabricIndex, NodeId remoteNodeId)
{
    ChipLogProgress(Controller, "OnBdxTransferSuccessCallback");

    auto * self = static_cast<AndroidCaptureSnapshotFromNode *>(context);
    VerifyOrReturn(self != nullptr, ChipLogProgress(Controller, "Send command failure callback with null context. Ignoring"));

    FinishCaptureSnapshotFromNode(context, CHIP_NO_ERROR);
}

void AndroidCaptureSnapshotFromNode::OnBdxTransferFailureCallback(void * context, FabricIndex fabricIndex, NodeId remoteNodeId,
                                                              CHIP_ERROR status)
{
    ChipLogProgress(Controller, "OnBdxTransferFailureCallback: %" CHIP_ERROR_FORMAT, status.Format());
}
} // namespace Controller
} // namespace chip