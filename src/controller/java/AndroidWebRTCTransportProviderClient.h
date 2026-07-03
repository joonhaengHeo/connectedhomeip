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

#pragma once

#include <jni.h>
#include <lib/support/JniReferences.h>

#include <src/controller/webrtc/WebRTCTransportProviderClient.h>

namespace chip {
namespace Controller {

/**
 * A helper class that sends Matter WebRTC Transport Provider cluster commands.
 * It extends WebRTCTransportProviderClient to directly handle command responses
 * and manage the JNI callbacks and its own memory lifecycle for Android.
 */
class AndroidWebRTCTransportProviderClient : public WebRTCTransportProviderClient
{
public:
    // Static methods to be called from JNI.
    // Internally, these dynamically allocate (new) an AndroidWebRTCTransportProviderClient 
    // object to send commands and wait for asynchronous responses.
    static CHIP_ERROR ProvideOffer(DeviceController * controller, NodeId deviceId, EndpointId endpointId, const CharSpan & offerSdp, jobject jcallback);
    static CHIP_ERROR SolicitOffer(DeviceController * controller, NodeId deviceId, EndpointId endpointId, jobject jcallback);
    static CHIP_ERROR ProvideAnswer(DeviceController * controller, NodeId deviceId, EndpointId endpointId, const CharSpan & answerSdp, jobject jcallback);
    static CHIP_ERROR ProvideICECandidate(DeviceController * controller, NodeId deviceId, EndpointId endpointId, const CharSpan & candidate, jobject jcallback);

private:
    // Constructors and destructors are set to private because the object lifecycle 
    // is managed internally for asynchronous operations.
    AndroidWebRTCTransportProviderClient(jobject javaCallbackObject);
    ~AndroidWebRTCTransportProviderClient();

    static void HandleCommandResponse(void * appContext, chip::EndpointId endpointId, chip::ClusterId clusterId,
                                      chip::CommandId commandId, size_t index,
                                      chip::Protocols::InteractionModel::Status status,
                                      chip::ClusterStatus clusterStatus, const uint8_t * payload, uint32_t length);
    static void HandleCommandError(void * appContext, chip::Protocols::InteractionModel::Status status,
                                   chip::ClusterStatus clusterStatus, CHIP_ERROR error);
    static void HandleCommandDone(void * appContext);

    // Internal helper functions responsible for executing JNI callbacks and freeing memory.
    void NotifySuccess();
    void NotifyError(CHIP_ERROR error);
    
    // Frees its own memory (delete this) when the operation is completed or an error occurs.
    void Cleanup();

    chip::JniGlobalReference mJavaCallback;
    jmethodID mOnSuccessMethod = nullptr;
    jmethodID mOnErrorMethod   = nullptr;
};

} // Namespace Controller
} // namespace chip