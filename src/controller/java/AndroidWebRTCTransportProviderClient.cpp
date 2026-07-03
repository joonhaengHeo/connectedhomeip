/*
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

#include "AndroidWebRTCTransportProviderClient.h"

#include <lib/support/CodeUtils.h>
#include <lib/support/JniReferences.h>
#include <lib/support/logging/CHIPLogging.h>

namespace chip {
namespace Controller {

AndroidWebRTCTransportProviderClient::AndroidWebRTCTransportProviderClient(jobject javaCallbackObject)
{
    JNIEnv * env = JniReferences::GetInstance().GetEnvForCurrentThread();
    VerifyOrReturn(env != nullptr, ChipLogError(Controller, "Could not get JNIEnv for current thread"));

    // Initialize the global reference for the Java callback object.
    CHIP_ERROR err = mJavaCallback.Init(javaCallbackObject);
    if (err != CHIP_NO_ERROR)
    {
        ChipLogError(Controller, "Failed to initialize JNI global reference for callback");
        return;
    }

    // Resolve method IDs for onSuccess and onError.
    // Note: You must adjust the method names and signatures ("()V", "(I)V") to match your actual Java interface.
    jclass callbackClass = env->GetObjectClass(javaCallbackObject);
    mOnSuccessMethod     = env->GetMethodID(callbackClass, "onSuccess", "()V");
    mOnErrorMethod       = env->GetMethodID(callbackClass, "onError", "(I)V");
}

AndroidWebRTCTransportProviderClient::~AndroidWebRTCTransportProviderClient()
{
    // mJavaCallback is automatically released by the JniGlobalReference destructor.
}

CHIP_ERROR AndroidWebRTCTransportProviderClient::ProvideOffer(DeviceController * controller, NodeId deviceId, EndpointId endpointId, const CharSpan & offerSdp, jobject jcallback)
{
    auto * client = new AndroidWebRTCTransportProviderClient(jcallback);
    VerifyOrReturnError(client != nullptr, CHIP_ERROR_NO_MEMORY);

    client->InitCallbacks(HandleCommandResponse, HandleCommandError, HandleCommandDone);
    client->Init(deviceId, controller->GetFabricIndex(), endpointId);

    Clusters::WebRTCTransportProvider::Commands::ProvideOffer::Type value;

    value.webRTCSessionID = app::DataModel::NullNullable;
    value.sdp = offerSdp;
    value.streamUsage = StreamUsageEnum::kLiveView;
    value.originatingEndpointID = kWebRTCRequesterDynamicEndpointId;
    value.videoStreamID = NullOptional;
    value.audioStreamID = NullOptional;
    value.ICEServers = NullOptional;
    value.metadataEnabled = NullOptional;
    value.SFrameConfig = NullOptional;
    value.videoStreams = NullOptional;
    value.audioStreams = NullOptional;

    size_t requiredBufferSize = offerSdp.size() + 256;

    chip::Platform::ScopedMemoryBuffer<uint8_t> payloadBuffer;
    if (!payloadBuffer.Alloc(requiredBufferSize))
    {
        client->Cleanup();
        return CHIP_ERROR_NO_MEMORY;
    }

    chip::TLV::TLVWriter writer;
    writer.Init(payloadBuffer.Get(), requiredBufferSize);
    CHIP_ERROR err = chip::app::DataModel::Encode(writer, chip::TLV::AnonymousTag(), value);
    if (err == CHIP_NO_ERROR)
    {
        err = writer.Finalize();
    }

    if (err != CHIP_NO_ERROR)
    {
        client->Cleanup();
        return err;
    }

    err = client->SendCommand(client, 
                              endpointId, 
                              Clusters::WebRTCTransportProvider::Id, 
                              Clusters::WebRTCTransportProvider::Commands::ProvideOffer::Id, 
                              payloadBuffer.Get(), 
                              writer.GetLengthWritten());

    if (err != CHIP_NO_ERROR)
    {
        client->Cleanup();
        return err;
    }

    return CHIP_NO_ERROR;
}

CHIP_ERROR AndroidWebRTCTransportProviderClient::SolicitOffer(DeviceController * controller, NodeId deviceId, EndpointId endpointId, jobject jcallback)
{
    auto * client = new AndroidWebRTCTransportProviderClient(jcallback);
    VerifyOrReturnError(client != nullptr, CHIP_ERROR_NO_MEMORY);

    client->InitCallbacks(HandleCommandResponse, HandleCommandError, HandleCommandDone);
    client->Init(deviceId, controller->GetFabricIndex(), endpointId);

    Clusters::WebRTCTransportProvider::Commands::SolicitOffer::Type value;

    value.streamUsage = StreamUsageEnum::kLiveView;
    value.originatingEndpointID = kWebRTCRequesterDynamicEndpointId;
    value.videoStreamID = NullOptional;
    value.audioStreamID = NullOptional;
    value.ICEServers = NullOptional;
    value.metadataEnabled = NullOptional;
    value.SFrameConfig = NullOptional;
    value.videoStreams = NullOptional;
    value.audioStreams = NullOptional;

    constexpr size_t kPayloadSize = 256; 
    chip::Platform::ScopedMemoryBuffer<uint8_t> payloadBuffer;
    if (!payloadBuffer.Alloc(kPayloadSize))
    {
        client->Cleanup();
        return CHIP_ERROR_NO_MEMORY;
    }
    
    chip::TLV::TLVWriter writer;
    writer.Init(payloadBuffer.Get(), kPayloadSize);

    CHIP_ERROR err = chip::app::DataModel::Encode(writer, chip::TLV::AnonymousTag(), value);
    if (err == CHIP_NO_ERROR)
    {
        err = writer.Finalize();
    }

    if (err != CHIP_NO_ERROR)
    {
        client->Cleanup();
        return err;
    }

    err = client->SendCommand(client, 
                              endpointId, 
                              Clusters::WebRTCTransportProvider::Id, 
                              Clusters::WebRTCTransportProvider::Commands::SolicitOffer::Id, 
                              payloadBuffer.Get(), 
                              writer.GetLengthWritten());

    if (err != CHIP_NO_ERROR)
    {
        client->Cleanup();
        return err;
    }

    return CHIP_NO_ERROR;
}

CHIP_ERROR AndroidWebRTCTransportProviderClient::ProvideAnswer(DeviceController * controller, NodeId deviceId, EndpointId endpointId, const CharSpan & answerSdp, jobject jcallback)
{
    auto * client = new AndroidWebRTCTransportProviderClient(jcallback);
    VerifyOrReturnError(client != nullptr, CHIP_ERROR_NO_MEMORY);

    // TODO: Implement ProvideAnswer command sending logic here.

    return CHIP_NO_ERROR;
}

CHIP_ERROR AndroidWebRTCTransportProviderClient::ProvideICECandidate(DeviceController * controller, NodeId deviceId, EndpointId endpointId, const CharSpan & candidate, jobject jcallback)
{
    auto * client = new AndroidWebRTCTransportProviderClient(jcallback);
    VerifyOrReturnError(client != nullptr, CHIP_ERROR_NO_MEMORY);

    // TODO: Implement ProvideICECandidate command sending logic here.

    return CHIP_NO_ERROR;
}

void AndroidWebRTCTransportProviderClient::HandleCommandResponse(void * appContext, chip::EndpointId endpointId, chip::ClusterId clusterId,
                                                                 chip::CommandId commandId, size_t index,
                                                                 chip::Protocols::InteractionModel::Status status,
                                                                 chip::ClusterStatus clusterStatus, const uint8_t * payload, uint32_t length)
{
    auto * self = static_cast<AndroidWebRTCTransportProviderClient *>(appContext);
    if (self != nullptr)
    {
        self->NotifySuccess();
    }
}

void AndroidWebRTCTransportProviderClient::HandleCommandError(void * appContext, chip::Protocols::InteractionModel::Status status,
                                                              chip::ClusterStatus clusterStatus, CHIP_ERROR error)
{
    auto * self = static_cast<AndroidWebRTCTransportProviderClient *>(appContext);
    if (self != nullptr)
    {
        self->NotifyError(error);
    }
}

void AndroidWebRTCTransportProviderClient::HandleCommandDone(void * appContext)
{
    auto * self = static_cast<AndroidWebRTCTransportProviderClient *>(appContext);
    if (self != nullptr)
    {
        self->Cleanup();
    }
}

void AndroidWebRTCTransportProviderClient::NotifySuccess()
{
    JNIEnv * env = JniReferences::GetInstance().GetEnvForCurrentThread();
    VerifyOrReturn(env != nullptr, ChipLogError(Controller, "Could not get JNIEnv for current thread"));

    if (mJavaCallback.HasValidObjectRef() && mOnSuccessMethod != nullptr)
    {
        env->CallVoidMethod(mJavaCallback.ObjectRef(), mOnSuccessMethod);
    }
}

void AndroidWebRTCTransportProviderClient::NotifyError(CHIP_ERROR error)
{
    JNIEnv * env = JniReferences::GetInstance().GetEnvForCurrentThread();
    VerifyOrReturn(env != nullptr, ChipLogError(Controller, "Could not get JNIEnv for current thread"));

    if (mJavaCallback.HasValidObjectRef() && mOnErrorMethod != nullptr)
    {
        // Passes the CHIP_ERROR integer value to the Java onError method.
        env->CallVoidMethod(mJavaCallback.ObjectRef(), mOnErrorMethod, static_cast<jint>(error.AsInteger()));
    }
}

void AndroidWebRTCTransportProviderClient::Cleanup()
{
    // Deletes the current instance to prevent memory leaks after the async operation finishes.
    delete this;
}

} // namespace Controller
} // namespace chip