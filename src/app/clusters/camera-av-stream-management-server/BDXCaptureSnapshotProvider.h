/*
 *
 *    Copyright (c) 2023 Project CHIP Authors
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

#include <lib/core/CHIPConfig.h>

#if CHIP_CONFIG_ENABLE_BDX_CAPTURE_SNAPSHOT_TRANSFER

#include <app/CommandHandler.h>
#include <app/StatusResponse.h>
#include <protocols/bdx/TransferFacilitator.h>
#include <clusters/CameraAvStreamManagement/Commands.h>
#include <clusters/CameraAvStreamManagement/Structs.h>
#include <app/data-model-provider/ActionReturnStatus.h>

namespace chip {
namespace app {
namespace Clusters {
namespace CameraAvStreamManagement {

constexpr uint8_t kMaxFileDesignatorLen = 32;

/**
 * @brief Delegate interface specifically for handling BDX snapshot transfers.
 *        This allows the BDX component to interact only with the necessary transfer functions.
 */
class BDXSnapshotTransferDelegate
{
public:
    virtual ~BDXSnapshotTransferDelegate() = default;

    /**
     *   @brief Initializes and prepares a snapshot session for BDX transfer.
     *
     *   @param streamID          Indicates the streamID representing the snapshot stream.
     *
     *   @return CHIP_NO_ERROR if the session is successfully started; otherwise, an appropriate CHIP_ERROR.
     */
    virtual CHIP_ERROR StartSnapshotTransfer(const DataModel::Nullable<uint16_t> streamID, const Structs::VideoResolutionStruct::Type & resolution) = 0;

    /**
     *   @brief Terminates an active snapshot session and cleans up associated resources.
     *
     *   @param streamID          Indicates the streamID representing the snapshot stream.
     *
     *   @return CHIP_NO_ERROR if the session is successfully ended; otherwise, an appropriate CHIP_ERROR.
     */
    virtual CHIP_ERROR EndSnapshotTransfer(const DataModel::Nullable<uint16_t> streamID, const Structs::VideoResolutionStruct::Type & resolution) = 0;

    /**
     *   @brief Terminates an active snapshot session with a specific error code.
     *
     *   @param streamID          Indicates the streamID representing the snapshot stream.
     *   @param error             The CHIP_ERROR code indicating the reason for termination (e.g., transfer aborted).
     *
     *   @return CHIP_NO_ERROR if the session is successfully ended; otherwise, an appropriate CHIP_ERROR.
     */
    virtual CHIP_ERROR EndSnapshotTransfer(const DataModel::Nullable<uint16_t> streamID, const Structs::VideoResolutionStruct::Type & resolution, CHIP_ERROR error)
    {
        return EndSnapshotTransfer(streamID, resolution);
    }

    /**
     *   @brief Reads a chunk of snapshot data for the BDX transfer.
     *
     *   @param streamID          Indicates the streamID representing the snapshot stream.
     *   @param outBuffer         The buffer where the snapshot data chunk will be written.
     *   @param outIsEndOfSnapshot A boolean flag that is set to true if this chunk is the last part of the snapshot.
     *
     *   @return CHIP_NO_ERROR if the data is successfully read; otherwise, an appropriate CHIP_ERROR.
     */
    virtual CHIP_ERROR ReadSnapshotChunk(const DataModel::Nullable<uint16_t> streamID, const Structs::VideoResolutionStruct::Type & resolution, MutableByteSpan & outBuffer, bool & outIsEndOfSnapshot) = 0;
};

class BDXCaptureSnapshotProvider : public bdx::Initiator
{
public:
    BDXCaptureSnapshotProvider(){};
    ~BDXCaptureSnapshotProvider(){};

    /**
     * Initializes the BDX transfer session by creating a new exchange context for the transfer session.
     * It starts the BDX transfer session by calling InitiateTransfer which sends the SendInit BDX message
     * to the log requestor.
     *
     * @param commandObj      The command handler object from the RetrieveLogsRequest command
     * @param path            The command path from the RetrieveLogsRequest command
     * @param delegate        The log provider delegate that will provide the log chunks
     * @param intent          The log type requested
     * @param fileDesignator  The file designator to use for the BDX transfer
     */
    CHIP_ERROR InitializeTransfer(CommandHandler * commandObj, const ConcreteCommandPath & path,
                                  BDXSnapshotTransferDelegate * delegate, const DataModel::Nullable<uint16_t> streamID,
                                  const Structs::VideoResolutionStruct::Type & resolution, const ImageCodecEnum imageCodec, CharSpan fileDesignator);

    /**
     * This method handles BDX messages and other TransferSession events.
     *
     * @param[in] event An OutputEvent that contains output from the TransferSession object.
     */
    void HandleTransferSessionOutput(bdx::TransferSession::OutputEvent & event) override;

    bool IsBusy() const { return mInitialized; }

    void OnExchangeClosing(Messaging::ExchangeContext * ec) override;

private:
    void OnMsgToSend(bdx::TransferSession::OutputEvent & event);
    void OnAcceptReceived();
    void OnAckReceived();
    void OnAckEOFReceived();
    void OnStatusReceived(bdx::TransferSession::OutputEvent & event);
    void OnInternalError();
    void OnTimeout();

    void SendCommandResponse(DataModel::ActionReturnStatus status);

    /**
     * This method is called to reset state. It resets the transfer, cleans up the
     * exchange and ends log collection.
     * @param[in] error  A CHIP_ERROR value indicating the reason for resetting the state.
     *                   It is permissible to pass CHIP_NO_ERROR to indicate normal termination.
     */
    void Reset(CHIP_ERROR error);

    Messaging::ExchangeContext * mBDXTransferExchangeCtx;
    BDXSnapshotTransferDelegate * mDelegate;
    Optional<FabricIndex> mFabricIndex;
    Optional<NodeId> mPeerNodeId;
    bool mIsAcceptReceived             = false;
    // SnapshotSessionHandle mSnapshotSessionHandle = kInvalidSnapshotSessionHandle;
    CommandHandler::Handle mAsyncCommandHandle;
    ConcreteCommandPath mRequestPath = ConcreteCommandPath(kInvalidEndpointId, kInvalidClusterId, kInvalidCommandId);
    DataModel::Nullable<uint16_t> mStreamID;
    ImageCodecEnum mImageCodec;
    Structs::VideoResolutionStruct::Type mResolution;
    bool mInitialized                = false;
};

} // namespace CameraAvStreamManagement
} // namespace Clusters
} // namespace app
} // namespace chip
#endif
