/*
 *
 *    Copyright (c) 2020 Project CHIP Authors
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

// module header, comes first
#include <controller/AbstractDnssdOperationalController.h>

#include <lib/core/CHIPEncoding.h>
#include <lib/support/logging/CHIPLogging.h>

namespace chip {
namespace Controller {

void AbstractDnssdOperationalController::OnOperationalNodeResolved(const chip::Dnssd::ResolvedNodeData & nodeData)
{
    if (nodeData.operationalData.peerId.GetCompressedFabricId() != mCompressedFabricId) {
        ChipLogDetail(Discovery, "SKip other compressed Fabric ID : " ChipLogFormatX64, ChipLogValueX64(nodeData.operationalData.peerId.GetCompressedFabricId()));
        return;
    }
    auto resolvedNodes = GetOperationalNodes();
    for (auto & resolvedNode : resolvedNodes)
    {
        if (!resolvedNode.resolutionData.IsValid())
        {
            continue;
        }
        if (strcmp(resolvedNode.resolutionData.hostName, nodeData.resolutionData.hostName) == 0 &&
            resolvedNode.resolutionData.port == nodeData.resolutionData.port)
        {
            resolvedNode = nodeData;
            if (mOperationalDiscoveryDelegate != nullptr)
            {
                mOperationalDiscoveryDelegate->OnOperationalDiscoveredDevice(nodeData);
            }
            return;
        }
    }
    for (auto & resolvedNode : resolvedNodes)
    {
        if (!resolvedNode.resolutionData.IsValid())
        {
            resolvedNode = nodeData;
            if (mOperationalDiscoveryDelegate != nullptr)
            {
                mOperationalDiscoveryDelegate->OnOperationalDiscoveredDevice(nodeData);
            }
            return;
        }
    }
    ChipLogError(Discovery, "Failed to add discovered node with hostname %s- Insufficient space", nodeData.resolutionData.hostName);
}

void AbstractDnssdOperationalController::OnOperationalNodeResolutionFailed(const PeerId & peerId, CHIP_ERROR error) {
    ChipLogError(Discovery, "OnOperationalNodeResolutionFailed");
}

CHIP_ERROR AbstractDnssdOperationalController::SetUpOperationalDiscovery(CompressedFabricId compressedFabricId)
{
    auto resolvedNodes = GetOperationalNodes();
    for (auto & resolveNode : resolvedNodes)
    {
        resolveNode.Reset();
    }

    mCompressedFabricId = compressedFabricId;
    return CHIP_NO_ERROR;
}

const Dnssd::ResolvedNodeData * AbstractDnssdOperationalController::GetOperationalNode(int idx)
{
    auto resolvedNodes = GetOperationalNodes();
    if (0 <= idx && idx < CHIP_DEVICE_CONFIG_MAX_DISCOVERED_NODES && resolvedNodes.data()[idx].resolutionData.IsValid())
    {
        return resolvedNodes.data() + idx;
    }
    return nullptr;
}

} // namespace Controller
} // namespace chip
