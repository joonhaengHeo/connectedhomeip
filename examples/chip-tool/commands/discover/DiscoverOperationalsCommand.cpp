/*
 *   Copyright (c) 2021 Project CHIP Authors
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

#include "DiscoverOperationalsCommand.h"
#include <lib/support/BytesToHex.h>

using namespace ::chip;

CHIP_ERROR DiscoverOperationalsCommand::RunCommand()
{
    CurrentCommissioner().RegisterOperationalDiscoveryDelegate(this);
    Dnssd::DiscoveryFilter filter(Dnssd::DiscoveryFilterType::kNone, (uint64_t) 0);
    return CurrentCommissioner().DiscoverOperationalNodes(filter);
}

void DiscoverOperationalsCommand::OnOperationalDiscoveredDevice(const chip::Dnssd::ResolvedNodeData & nodeData)
{
    nodeData.LogNodeIdResolved();
}
