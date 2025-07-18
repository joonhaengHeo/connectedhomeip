/*
 *
 *    Copyright (c) 2022 Project CHIP Authors
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

#import "MTREventTLVValueDecoder_Internal.h"

#import "MTRStructsObjc.h"
#import "NSDataSpanConversion.h"
#import "NSStringSpanConversion.h"

#include <app-common/zap-generated/cluster-objects.h>
#include <app-common/zap-generated/ids/Attributes.h>
#include <app-common/zap-generated/ids/Clusters.h>
#include <app-common/zap-generated/ids/Events.h>
#include <app/EventHeader.h>
#include <app/EventLoggingTypes.h>
#include <app/data-model/DecodableList.h>
#include <app/data-model/Decode.h>
#include <lib/support/TypeTraits.h>

using namespace chip;
using namespace chip::app;

static id _Nullable DecodeEventPayloadForIdentifyCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::Identify;
    switch (aEventId) {
    default: {
        // Not a known Identify event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForGroupsCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::Groups;
    switch (aEventId) {
    default: {
        // Not a known Groups event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForOnOffCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::OnOff;
    switch (aEventId) {
    default: {
        // Not a known OnOff event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForLevelControlCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::LevelControl;
    switch (aEventId) {
    default: {
        // Not a known LevelControl event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForPulseWidthModulationCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::PulseWidthModulation;
    switch (aEventId) {
    default: {
        // Not a known PulseWidthModulation event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForDescriptorCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::Descriptor;
    switch (aEventId) {
    default: {
        // Not a known Descriptor event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForBindingCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::Binding;
    switch (aEventId) {
    default: {
        // Not a known Binding event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForAccessControlCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::AccessControl;
    switch (aEventId) {
    case Events::AccessControlEntryChanged::Id: {
        Events::AccessControlEntryChanged::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRAccessControlClusterAccessControlEntryChangedEvent new];

        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.adminNodeID.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedLongLong:cppValue.adminNodeID.Value()];
            }
            value.adminNodeID = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.adminPasscodeID.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedShort:cppValue.adminPasscodeID.Value()];
            }
            value.adminPasscodeID = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.changeType)];
            value.changeType = memberValue;
        } while (0);
        do {
            MTRAccessControlClusterAccessControlEntryStruct * _Nullable memberValue;
            if (cppValue.latestValue.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [MTRAccessControlClusterAccessControlEntryStruct new];
                memberValue.privilege = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.latestValue.Value().privilege)];
                memberValue.authMode = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.latestValue.Value().authMode)];
                if (cppValue.latestValue.Value().subjects.IsNull()) {
                    memberValue.subjects = nil;
                } else {
                    { // Scope for our temporary variables
                        auto * array_3 = [NSMutableArray new];
                        auto iter_3 = cppValue.latestValue.Value().subjects.Value().begin();
                        while (iter_3.Next()) {
                            auto & entry_3 = iter_3.GetValue();
                            NSNumber * newElement_3;
                            newElement_3 = [NSNumber numberWithUnsignedLongLong:entry_3];
                            [array_3 addObject:newElement_3];
                        }
                        CHIP_ERROR err = iter_3.GetStatus();
                        if (err != CHIP_NO_ERROR) {
                            *aError = err;
                            return nil;
                        }
                        memberValue.subjects = array_3;
                    }
                }
                if (cppValue.latestValue.Value().targets.IsNull()) {
                    memberValue.targets = nil;
                } else {
                    { // Scope for our temporary variables
                        auto * array_3 = [NSMutableArray new];
                        auto iter_3 = cppValue.latestValue.Value().targets.Value().begin();
                        while (iter_3.Next()) {
                            auto & entry_3 = iter_3.GetValue();
                            MTRAccessControlClusterAccessControlTargetStruct * newElement_3;
                            newElement_3 = [MTRAccessControlClusterAccessControlTargetStruct new];
                            if (entry_3.cluster.IsNull()) {
                                newElement_3.cluster = nil;
                            } else {
                                newElement_3.cluster = [NSNumber numberWithUnsignedInt:entry_3.cluster.Value()];
                            }
                            if (entry_3.endpoint.IsNull()) {
                                newElement_3.endpoint = nil;
                            } else {
                                newElement_3.endpoint = [NSNumber numberWithUnsignedShort:entry_3.endpoint.Value()];
                            }
                            if (entry_3.deviceType.IsNull()) {
                                newElement_3.deviceType = nil;
                            } else {
                                newElement_3.deviceType = [NSNumber numberWithUnsignedInt:entry_3.deviceType.Value()];
                            }
                            [array_3 addObject:newElement_3];
                        }
                        CHIP_ERROR err = iter_3.GetStatus();
                        if (err != CHIP_NO_ERROR) {
                            *aError = err;
                            return nil;
                        }
                        memberValue.targets = array_3;
                    }
                }
                memberValue.fabricIndex = [NSNumber numberWithUnsignedChar:cppValue.latestValue.Value().fabricIndex];
            }
            value.latestValue = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.fabricIndex];
            value.fabricIndex = memberValue;
        } while (0);

        return value;
    }
    case Events::AccessControlExtensionChanged::Id: {
        Events::AccessControlExtensionChanged::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRAccessControlClusterAccessControlExtensionChangedEvent new];

        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.adminNodeID.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedLongLong:cppValue.adminNodeID.Value()];
            }
            value.adminNodeID = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.adminPasscodeID.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedShort:cppValue.adminPasscodeID.Value()];
            }
            value.adminPasscodeID = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.changeType)];
            value.changeType = memberValue;
        } while (0);
        do {
            MTRAccessControlClusterAccessControlExtensionStruct * _Nullable memberValue;
            if (cppValue.latestValue.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [MTRAccessControlClusterAccessControlExtensionStruct new];
                memberValue.data = AsData(cppValue.latestValue.Value().data);
                memberValue.fabricIndex = [NSNumber numberWithUnsignedChar:cppValue.latestValue.Value().fabricIndex];
            }
            value.latestValue = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.fabricIndex];
            value.fabricIndex = memberValue;
        } while (0);

        return value;
    }
    case Events::FabricRestrictionReviewUpdate::Id: {
        Events::FabricRestrictionReviewUpdate::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRAccessControlClusterFabricRestrictionReviewUpdateEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedLongLong:cppValue.token];
            value.token = memberValue;
        } while (0);
        do {
            NSString * _Nullable memberValue;
            if (cppValue.instruction.HasValue()) {
                memberValue = AsString(cppValue.instruction.Value());
                if (memberValue == nil) {
                    CHIP_ERROR err = CHIP_ERROR_INVALID_ARGUMENT;
                    *aError = err;
                    return nil;
                }
            } else {
                memberValue = nil;
            }
            value.instruction = memberValue;
        } while (0);
        do {
            NSString * _Nullable memberValue;
            if (cppValue.ARLRequestFlowUrl.HasValue()) {
                memberValue = AsString(cppValue.ARLRequestFlowUrl.Value());
                if (memberValue == nil) {
                    CHIP_ERROR err = CHIP_ERROR_INVALID_ARGUMENT;
                    *aError = err;
                    return nil;
                }
            } else {
                memberValue = nil;
            }
            value.arlRequestFlowUrl = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.fabricIndex];
            value.fabricIndex = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known AccessControl event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForActionsCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::Actions;
    switch (aEventId) {
    case Events::StateChanged::Id: {
        Events::StateChanged::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRActionsClusterStateChangedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedShort:cppValue.actionID];
            value.actionID = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.invokeID];
            value.invokeID = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.newState)];
            value.newState = memberValue;
        } while (0);

        return value;
    }
    case Events::ActionFailed::Id: {
        Events::ActionFailed::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRActionsClusterActionFailedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedShort:cppValue.actionID];
            value.actionID = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.invokeID];
            value.invokeID = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.newState)];
            value.newState = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.error)];
            value.error = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known Actions event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForBasicInformationCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::BasicInformation;
    switch (aEventId) {
    case Events::StartUp::Id: {
        Events::StartUp::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRBasicInformationClusterStartUpEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.softwareVersion];
            value.softwareVersion = memberValue;
        } while (0);

        return value;
    }
    case Events::ShutDown::Id: {
        Events::ShutDown::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRBasicInformationClusterShutDownEvent new];

        return value;
    }
    case Events::Leave::Id: {
        Events::Leave::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRBasicInformationClusterLeaveEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.fabricIndex];
            value.fabricIndex = memberValue;
        } while (0);

        return value;
    }
    case Events::ReachableChanged::Id: {
        Events::ReachableChanged::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRBasicInformationClusterReachableChangedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithBool:cppValue.reachableNewValue];
            value.reachableNewValue = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known BasicInformation event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForOTASoftwareUpdateProviderCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::OtaSoftwareUpdateProvider;
    switch (aEventId) {
    default: {
        // Not a known OTASoftwareUpdateProvider event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForOTASoftwareUpdateRequestorCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::OtaSoftwareUpdateRequestor;
    switch (aEventId) {
    case Events::StateTransition::Id: {
        Events::StateTransition::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTROTASoftwareUpdateRequestorClusterStateTransitionEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.previousState)];
            value.previousState = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.newState)];
            value.newState = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.reason)];
            value.reason = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.targetSoftwareVersion.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedInt:cppValue.targetSoftwareVersion.Value()];
            }
            value.targetSoftwareVersion = memberValue;
        } while (0);

        return value;
    }
    case Events::VersionApplied::Id: {
        Events::VersionApplied::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTROTASoftwareUpdateRequestorClusterVersionAppliedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.softwareVersion];
            value.softwareVersion = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedShort:cppValue.productID];
            value.productID = memberValue;
        } while (0);

        return value;
    }
    case Events::DownloadError::Id: {
        Events::DownloadError::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTROTASoftwareUpdateRequestorClusterDownloadErrorEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.softwareVersion];
            value.softwareVersion = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedLongLong:cppValue.bytesDownloaded];
            value.bytesDownloaded = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.progressPercent.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedChar:cppValue.progressPercent.Value()];
            }
            value.progressPercent = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.platformCode.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithLongLong:cppValue.platformCode.Value()];
            }
            value.platformCode = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known OTASoftwareUpdateRequestor event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForLocalizationConfigurationCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::LocalizationConfiguration;
    switch (aEventId) {
    default: {
        // Not a known LocalizationConfiguration event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForTimeFormatLocalizationCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::TimeFormatLocalization;
    switch (aEventId) {
    default: {
        // Not a known TimeFormatLocalization event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForUnitLocalizationCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::UnitLocalization;
    switch (aEventId) {
    default: {
        // Not a known UnitLocalization event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForPowerSourceConfigurationCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::PowerSourceConfiguration;
    switch (aEventId) {
    default: {
        // Not a known PowerSourceConfiguration event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForPowerSourceCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::PowerSource;
    switch (aEventId) {
    case Events::WiredFaultChange::Id: {
        Events::WiredFaultChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPowerSourceClusterWiredFaultChangeEvent new];

        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.current.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    NSNumber * newElement_0;
                    newElement_0 = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0)];
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.current = memberValue;
        } while (0);
        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.previous.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    NSNumber * newElement_0;
                    newElement_0 = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0)];
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.previous = memberValue;
        } while (0);

        return value;
    }
    case Events::BatFaultChange::Id: {
        Events::BatFaultChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPowerSourceClusterBatFaultChangeEvent new];

        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.current.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    NSNumber * newElement_0;
                    newElement_0 = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0)];
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.current = memberValue;
        } while (0);
        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.previous.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    NSNumber * newElement_0;
                    newElement_0 = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0)];
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.previous = memberValue;
        } while (0);

        return value;
    }
    case Events::BatChargeFaultChange::Id: {
        Events::BatChargeFaultChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPowerSourceClusterBatChargeFaultChangeEvent new];

        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.current.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    NSNumber * newElement_0;
                    newElement_0 = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0)];
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.current = memberValue;
        } while (0);
        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.previous.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    NSNumber * newElement_0;
                    newElement_0 = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0)];
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.previous = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known PowerSource event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForGeneralCommissioningCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::GeneralCommissioning;
    switch (aEventId) {
    default: {
        // Not a known GeneralCommissioning event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForNetworkCommissioningCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::NetworkCommissioning;
    switch (aEventId) {
    default: {
        // Not a known NetworkCommissioning event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForDiagnosticLogsCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::DiagnosticLogs;
    switch (aEventId) {
    default: {
        // Not a known DiagnosticLogs event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForGeneralDiagnosticsCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::GeneralDiagnostics;
    switch (aEventId) {
    case Events::HardwareFaultChange::Id: {
        Events::HardwareFaultChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRGeneralDiagnosticsClusterHardwareFaultChangeEvent new];

        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.current.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    NSNumber * newElement_0;
                    newElement_0 = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0)];
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.current = memberValue;
        } while (0);
        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.previous.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    NSNumber * newElement_0;
                    newElement_0 = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0)];
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.previous = memberValue;
        } while (0);

        return value;
    }
    case Events::RadioFaultChange::Id: {
        Events::RadioFaultChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRGeneralDiagnosticsClusterRadioFaultChangeEvent new];

        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.current.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    NSNumber * newElement_0;
                    newElement_0 = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0)];
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.current = memberValue;
        } while (0);
        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.previous.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    NSNumber * newElement_0;
                    newElement_0 = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0)];
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.previous = memberValue;
        } while (0);

        return value;
    }
    case Events::NetworkFaultChange::Id: {
        Events::NetworkFaultChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRGeneralDiagnosticsClusterNetworkFaultChangeEvent new];

        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.current.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    NSNumber * newElement_0;
                    newElement_0 = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0)];
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.current = memberValue;
        } while (0);
        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.previous.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    NSNumber * newElement_0;
                    newElement_0 = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0)];
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.previous = memberValue;
        } while (0);

        return value;
    }
    case Events::BootReason::Id: {
        Events::BootReason::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRGeneralDiagnosticsClusterBootReasonEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.bootReason)];
            value.bootReason = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known GeneralDiagnostics event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForSoftwareDiagnosticsCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::SoftwareDiagnostics;
    switch (aEventId) {
    case Events::SoftwareFault::Id: {
        Events::SoftwareFault::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSoftwareDiagnosticsClusterSoftwareFaultEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedLongLong:cppValue.id];
            value.id = memberValue;
        } while (0);
        do {
            NSString * _Nullable memberValue;
            if (cppValue.name.HasValue()) {
                memberValue = AsString(cppValue.name.Value());
                if (memberValue == nil) {
                    CHIP_ERROR err = CHIP_ERROR_INVALID_ARGUMENT;
                    *aError = err;
                    return nil;
                }
            } else {
                memberValue = nil;
            }
            value.name = memberValue;
        } while (0);
        do {
            NSData * _Nullable memberValue;
            if (cppValue.faultRecording.HasValue()) {
                memberValue = AsData(cppValue.faultRecording.Value());
            } else {
                memberValue = nil;
            }
            value.faultRecording = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known SoftwareDiagnostics event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForThreadNetworkDiagnosticsCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ThreadNetworkDiagnostics;
    switch (aEventId) {
    case Events::ConnectionStatus::Id: {
        Events::ConnectionStatus::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRThreadNetworkDiagnosticsClusterConnectionStatusEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.connectionStatus)];
            value.connectionStatus = memberValue;
        } while (0);

        return value;
    }
    case Events::NetworkFaultChange::Id: {
        Events::NetworkFaultChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRThreadNetworkDiagnosticsClusterNetworkFaultChangeEvent new];

        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.current.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    NSNumber * newElement_0;
                    newElement_0 = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0)];
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.current = memberValue;
        } while (0);
        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.previous.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    NSNumber * newElement_0;
                    newElement_0 = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0)];
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.previous = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known ThreadNetworkDiagnostics event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForWiFiNetworkDiagnosticsCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::WiFiNetworkDiagnostics;
    switch (aEventId) {
    case Events::Disconnection::Id: {
        Events::Disconnection::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRWiFiNetworkDiagnosticsClusterDisconnectionEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedShort:cppValue.reasonCode];
            value.reasonCode = memberValue;
        } while (0);

        return value;
    }
    case Events::AssociationFailure::Id: {
        Events::AssociationFailure::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRWiFiNetworkDiagnosticsClusterAssociationFailureEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.associationFailureCause)];
            value.associationFailureCause = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedShort:cppValue.status];
            value.status = memberValue;
        } while (0);

        return value;
    }
    case Events::ConnectionStatus::Id: {
        Events::ConnectionStatus::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRWiFiNetworkDiagnosticsClusterConnectionStatusEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.connectionStatus)];
            value.connectionStatus = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known WiFiNetworkDiagnostics event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForEthernetNetworkDiagnosticsCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::EthernetNetworkDiagnostics;
    switch (aEventId) {
    default: {
        // Not a known EthernetNetworkDiagnostics event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForTimeSynchronizationCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::TimeSynchronization;
    switch (aEventId) {
    case Events::DSTTableEmpty::Id: {
        Events::DSTTableEmpty::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRTimeSynchronizationClusterDSTTableEmptyEvent new];

        return value;
    }
    case Events::DSTStatus::Id: {
        Events::DSTStatus::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRTimeSynchronizationClusterDSTStatusEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithBool:cppValue.DSTOffsetActive];
            value.dstOffsetActive = memberValue;
        } while (0);

        return value;
    }
    case Events::TimeZoneStatus::Id: {
        Events::TimeZoneStatus::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRTimeSynchronizationClusterTimeZoneStatusEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithInt:cppValue.offset];
            value.offset = memberValue;
        } while (0);
        do {
            NSString * _Nullable memberValue;
            if (cppValue.name.HasValue()) {
                memberValue = AsString(cppValue.name.Value());
                if (memberValue == nil) {
                    CHIP_ERROR err = CHIP_ERROR_INVALID_ARGUMENT;
                    *aError = err;
                    return nil;
                }
            } else {
                memberValue = nil;
            }
            value.name = memberValue;
        } while (0);

        return value;
    }
    case Events::TimeFailure::Id: {
        Events::TimeFailure::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRTimeSynchronizationClusterTimeFailureEvent new];

        return value;
    }
    case Events::MissingTrustedTimeSource::Id: {
        Events::MissingTrustedTimeSource::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRTimeSynchronizationClusterMissingTrustedTimeSourceEvent new];

        return value;
    }
    default: {
        // Not a known TimeSynchronization event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForBridgedDeviceBasicInformationCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::BridgedDeviceBasicInformation;
    switch (aEventId) {
    case Events::StartUp::Id: {
        Events::StartUp::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRBridgedDeviceBasicInformationClusterStartUpEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.softwareVersion];
            value.softwareVersion = memberValue;
        } while (0);

        return value;
    }
    case Events::ShutDown::Id: {
        Events::ShutDown::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRBridgedDeviceBasicInformationClusterShutDownEvent new];

        return value;
    }
    case Events::Leave::Id: {
        Events::Leave::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRBridgedDeviceBasicInformationClusterLeaveEvent new];

        return value;
    }
    case Events::ReachableChanged::Id: {
        Events::ReachableChanged::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRBridgedDeviceBasicInformationClusterReachableChangedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithBool:cppValue.reachableNewValue];
            value.reachableNewValue = memberValue;
        } while (0);

        return value;
    }
    case Events::ActiveChanged::Id: {
        Events::ActiveChanged::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRBridgedDeviceBasicInformationClusterActiveChangedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.promisedActiveDuration];
            value.promisedActiveDuration = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known BridgedDeviceBasicInformation event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForSwitchCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::Switch;
    switch (aEventId) {
    case Events::SwitchLatched::Id: {
        Events::SwitchLatched::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSwitchClusterSwitchLatchedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.newPosition];
            value.newPosition = memberValue;
        } while (0);

        return value;
    }
    case Events::InitialPress::Id: {
        Events::InitialPress::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSwitchClusterInitialPressEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.newPosition];
            value.newPosition = memberValue;
        } while (0);

        return value;
    }
    case Events::LongPress::Id: {
        Events::LongPress::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSwitchClusterLongPressEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.newPosition];
            value.newPosition = memberValue;
        } while (0);

        return value;
    }
    case Events::ShortRelease::Id: {
        Events::ShortRelease::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSwitchClusterShortReleaseEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.previousPosition];
            value.previousPosition = memberValue;
        } while (0);

        return value;
    }
    case Events::LongRelease::Id: {
        Events::LongRelease::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSwitchClusterLongReleaseEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.previousPosition];
            value.previousPosition = memberValue;
        } while (0);

        return value;
    }
    case Events::MultiPressOngoing::Id: {
        Events::MultiPressOngoing::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSwitchClusterMultiPressOngoingEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.newPosition];
            value.newPosition = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.currentNumberOfPressesCounted];
            value.currentNumberOfPressesCounted = memberValue;
        } while (0);

        return value;
    }
    case Events::MultiPressComplete::Id: {
        Events::MultiPressComplete::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSwitchClusterMultiPressCompleteEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.previousPosition];
            value.previousPosition = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.totalNumberOfPressesCounted];
            value.totalNumberOfPressesCounted = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known Switch event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForAdministratorCommissioningCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::AdministratorCommissioning;
    switch (aEventId) {
    default: {
        // Not a known AdministratorCommissioning event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForOperationalCredentialsCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::OperationalCredentials;
    switch (aEventId) {
    default: {
        // Not a known OperationalCredentials event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForGroupKeyManagementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::GroupKeyManagement;
    switch (aEventId) {
    default: {
        // Not a known GroupKeyManagement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForFixedLabelCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::FixedLabel;
    switch (aEventId) {
    default: {
        // Not a known FixedLabel event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForUserLabelCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::UserLabel;
    switch (aEventId) {
    default: {
        // Not a known UserLabel event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForBooleanStateCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::BooleanState;
    switch (aEventId) {
    case Events::StateChange::Id: {
        Events::StateChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRBooleanStateClusterStateChangeEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithBool:cppValue.stateValue];
            value.stateValue = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known BooleanState event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForICDManagementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::IcdManagement;
    switch (aEventId) {
    default: {
        // Not a known ICDManagement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForTimerCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::Timer;
    switch (aEventId) {
    default: {
        // Not a known Timer event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForOvenCavityOperationalStateCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::OvenCavityOperationalState;
    switch (aEventId) {
    case Events::OperationalError::Id: {
        Events::OperationalError::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTROvenCavityOperationalStateClusterOperationalErrorEvent new];

        do {
            MTROvenCavityOperationalStateClusterErrorStateStruct * _Nonnull memberValue;
            memberValue = [MTROvenCavityOperationalStateClusterErrorStateStruct new];
            memberValue.errorStateID = [NSNumber numberWithUnsignedChar:cppValue.errorState.errorStateID];
            if (cppValue.errorState.errorStateLabel.HasValue()) {
                memberValue.errorStateLabel = AsString(cppValue.errorState.errorStateLabel.Value());
                if (memberValue.errorStateLabel == nil) {
                    CHIP_ERROR err = CHIP_ERROR_INVALID_ARGUMENT;
                    *aError = err;
                    return nil;
                }
            } else {
                memberValue.errorStateLabel = nil;
            }
            if (cppValue.errorState.errorStateDetails.HasValue()) {
                memberValue.errorStateDetails = AsString(cppValue.errorState.errorStateDetails.Value());
                if (memberValue.errorStateDetails == nil) {
                    CHIP_ERROR err = CHIP_ERROR_INVALID_ARGUMENT;
                    *aError = err;
                    return nil;
                }
            } else {
                memberValue.errorStateDetails = nil;
            }
            value.errorState = memberValue;
        } while (0);

        return value;
    }
    case Events::OperationCompletion::Id: {
        Events::OperationCompletion::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTROvenCavityOperationalStateClusterOperationCompletionEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.completionErrorCode];
            value.completionErrorCode = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.totalOperationalTime.HasValue()) {
                if (cppValue.totalOperationalTime.Value().IsNull()) {
                    memberValue = nil;
                } else {
                    memberValue = [NSNumber numberWithUnsignedInt:cppValue.totalOperationalTime.Value().Value()];
                }
            } else {
                memberValue = nil;
            }
            value.totalOperationalTime = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.pausedTime.HasValue()) {
                if (cppValue.pausedTime.Value().IsNull()) {
                    memberValue = nil;
                } else {
                    memberValue = [NSNumber numberWithUnsignedInt:cppValue.pausedTime.Value().Value()];
                }
            } else {
                memberValue = nil;
            }
            value.pausedTime = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known OvenCavityOperationalState event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForOvenModeCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::OvenMode;
    switch (aEventId) {
    default: {
        // Not a known OvenMode event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForLaundryDryerControlsCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::LaundryDryerControls;
    switch (aEventId) {
    default: {
        // Not a known LaundryDryerControls event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForModeSelectCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ModeSelect;
    switch (aEventId) {
    default: {
        // Not a known ModeSelect event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForLaundryWasherModeCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::LaundryWasherMode;
    switch (aEventId) {
    default: {
        // Not a known LaundryWasherMode event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForRefrigeratorAndTemperatureControlledCabinetModeCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::RefrigeratorAndTemperatureControlledCabinetMode;
    switch (aEventId) {
    default: {
        // Not a known RefrigeratorAndTemperatureControlledCabinetMode event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForLaundryWasherControlsCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::LaundryWasherControls;
    switch (aEventId) {
    default: {
        // Not a known LaundryWasherControls event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForRVCRunModeCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::RvcRunMode;
    switch (aEventId) {
    default: {
        // Not a known RVCRunMode event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForRVCCleanModeCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::RvcCleanMode;
    switch (aEventId) {
    default: {
        // Not a known RVCCleanMode event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForTemperatureControlCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::TemperatureControl;
    switch (aEventId) {
    default: {
        // Not a known TemperatureControl event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForRefrigeratorAlarmCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::RefrigeratorAlarm;
    switch (aEventId) {
    case Events::Notify::Id: {
        Events::Notify::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRRefrigeratorAlarmClusterNotifyEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.active.Raw()];
            value.active = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.inactive.Raw()];
            value.inactive = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.state.Raw()];
            value.state = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.mask.Raw()];
            value.mask = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known RefrigeratorAlarm event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForDishwasherModeCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::DishwasherMode;
    switch (aEventId) {
    default: {
        // Not a known DishwasherMode event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForAirQualityCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::AirQuality;
    switch (aEventId) {
    default: {
        // Not a known AirQuality event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForSmokeCOAlarmCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::SmokeCoAlarm;
    switch (aEventId) {
    case Events::SmokeAlarm::Id: {
        Events::SmokeAlarm::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSmokeCOAlarmClusterSmokeAlarmEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.alarmSeverityLevel)];
            value.alarmSeverityLevel = memberValue;
        } while (0);

        return value;
    }
    case Events::COAlarm::Id: {
        Events::COAlarm::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSmokeCOAlarmClusterCOAlarmEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.alarmSeverityLevel)];
            value.alarmSeverityLevel = memberValue;
        } while (0);

        return value;
    }
    case Events::LowBattery::Id: {
        Events::LowBattery::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSmokeCOAlarmClusterLowBatteryEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.alarmSeverityLevel)];
            value.alarmSeverityLevel = memberValue;
        } while (0);

        return value;
    }
    case Events::HardwareFault::Id: {
        Events::HardwareFault::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSmokeCOAlarmClusterHardwareFaultEvent new];

        return value;
    }
    case Events::EndOfService::Id: {
        Events::EndOfService::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSmokeCOAlarmClusterEndOfServiceEvent new];

        return value;
    }
    case Events::SelfTestComplete::Id: {
        Events::SelfTestComplete::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSmokeCOAlarmClusterSelfTestCompleteEvent new];

        return value;
    }
    case Events::AlarmMuted::Id: {
        Events::AlarmMuted::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSmokeCOAlarmClusterAlarmMutedEvent new];

        return value;
    }
    case Events::MuteEnded::Id: {
        Events::MuteEnded::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSmokeCOAlarmClusterMuteEndedEvent new];

        return value;
    }
    case Events::InterconnectSmokeAlarm::Id: {
        Events::InterconnectSmokeAlarm::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSmokeCOAlarmClusterInterconnectSmokeAlarmEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.alarmSeverityLevel)];
            value.alarmSeverityLevel = memberValue;
        } while (0);

        return value;
    }
    case Events::InterconnectCOAlarm::Id: {
        Events::InterconnectCOAlarm::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSmokeCOAlarmClusterInterconnectCOAlarmEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.alarmSeverityLevel)];
            value.alarmSeverityLevel = memberValue;
        } while (0);

        return value;
    }
    case Events::AllClear::Id: {
        Events::AllClear::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSmokeCOAlarmClusterAllClearEvent new];

        return value;
    }
    default: {
        // Not a known SmokeCOAlarm event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForDishwasherAlarmCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::DishwasherAlarm;
    switch (aEventId) {
    case Events::Notify::Id: {
        Events::Notify::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRDishwasherAlarmClusterNotifyEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.active.Raw()];
            value.active = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.inactive.Raw()];
            value.inactive = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.state.Raw()];
            value.state = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.mask.Raw()];
            value.mask = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known DishwasherAlarm event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForMicrowaveOvenModeCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::MicrowaveOvenMode;
    switch (aEventId) {
    default: {
        // Not a known MicrowaveOvenMode event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForMicrowaveOvenControlCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::MicrowaveOvenControl;
    switch (aEventId) {
    default: {
        // Not a known MicrowaveOvenControl event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForOperationalStateCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::OperationalState;
    switch (aEventId) {
    case Events::OperationalError::Id: {
        Events::OperationalError::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTROperationalStateClusterOperationalErrorEvent new];

        do {
            MTROperationalStateClusterErrorStateStruct * _Nonnull memberValue;
            memberValue = [MTROperationalStateClusterErrorStateStruct new];
            memberValue.errorStateID = [NSNumber numberWithUnsignedChar:cppValue.errorState.errorStateID];
            if (cppValue.errorState.errorStateLabel.HasValue()) {
                memberValue.errorStateLabel = AsString(cppValue.errorState.errorStateLabel.Value());
                if (memberValue.errorStateLabel == nil) {
                    CHIP_ERROR err = CHIP_ERROR_INVALID_ARGUMENT;
                    *aError = err;
                    return nil;
                }
            } else {
                memberValue.errorStateLabel = nil;
            }
            if (cppValue.errorState.errorStateDetails.HasValue()) {
                memberValue.errorStateDetails = AsString(cppValue.errorState.errorStateDetails.Value());
                if (memberValue.errorStateDetails == nil) {
                    CHIP_ERROR err = CHIP_ERROR_INVALID_ARGUMENT;
                    *aError = err;
                    return nil;
                }
            } else {
                memberValue.errorStateDetails = nil;
            }
            value.errorState = memberValue;
        } while (0);

        return value;
    }
    case Events::OperationCompletion::Id: {
        Events::OperationCompletion::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTROperationalStateClusterOperationCompletionEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.completionErrorCode];
            value.completionErrorCode = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.totalOperationalTime.HasValue()) {
                if (cppValue.totalOperationalTime.Value().IsNull()) {
                    memberValue = nil;
                } else {
                    memberValue = [NSNumber numberWithUnsignedInt:cppValue.totalOperationalTime.Value().Value()];
                }
            } else {
                memberValue = nil;
            }
            value.totalOperationalTime = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.pausedTime.HasValue()) {
                if (cppValue.pausedTime.Value().IsNull()) {
                    memberValue = nil;
                } else {
                    memberValue = [NSNumber numberWithUnsignedInt:cppValue.pausedTime.Value().Value()];
                }
            } else {
                memberValue = nil;
            }
            value.pausedTime = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known OperationalState event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForRVCOperationalStateCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::RvcOperationalState;
    switch (aEventId) {
    case Events::OperationalError::Id: {
        Events::OperationalError::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRRVCOperationalStateClusterOperationalErrorEvent new];

        do {
            MTRRVCOperationalStateClusterErrorStateStruct * _Nonnull memberValue;
            memberValue = [MTRRVCOperationalStateClusterErrorStateStruct new];
            memberValue.errorStateID = [NSNumber numberWithUnsignedChar:cppValue.errorState.errorStateID];
            if (cppValue.errorState.errorStateLabel.HasValue()) {
                memberValue.errorStateLabel = AsString(cppValue.errorState.errorStateLabel.Value());
                if (memberValue.errorStateLabel == nil) {
                    CHIP_ERROR err = CHIP_ERROR_INVALID_ARGUMENT;
                    *aError = err;
                    return nil;
                }
            } else {
                memberValue.errorStateLabel = nil;
            }
            if (cppValue.errorState.errorStateDetails.HasValue()) {
                memberValue.errorStateDetails = AsString(cppValue.errorState.errorStateDetails.Value());
                if (memberValue.errorStateDetails == nil) {
                    CHIP_ERROR err = CHIP_ERROR_INVALID_ARGUMENT;
                    *aError = err;
                    return nil;
                }
            } else {
                memberValue.errorStateDetails = nil;
            }
            value.errorState = memberValue;
        } while (0);

        return value;
    }
    case Events::OperationCompletion::Id: {
        Events::OperationCompletion::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRRVCOperationalStateClusterOperationCompletionEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.completionErrorCode];
            value.completionErrorCode = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.totalOperationalTime.HasValue()) {
                if (cppValue.totalOperationalTime.Value().IsNull()) {
                    memberValue = nil;
                } else {
                    memberValue = [NSNumber numberWithUnsignedInt:cppValue.totalOperationalTime.Value().Value()];
                }
            } else {
                memberValue = nil;
            }
            value.totalOperationalTime = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.pausedTime.HasValue()) {
                if (cppValue.pausedTime.Value().IsNull()) {
                    memberValue = nil;
                } else {
                    memberValue = [NSNumber numberWithUnsignedInt:cppValue.pausedTime.Value().Value()];
                }
            } else {
                memberValue = nil;
            }
            value.pausedTime = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known RVCOperationalState event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForScenesManagementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ScenesManagement;
    switch (aEventId) {
    default: {
        // Not a known ScenesManagement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForHEPAFilterMonitoringCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::HepaFilterMonitoring;
    switch (aEventId) {
    default: {
        // Not a known HEPAFilterMonitoring event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForActivatedCarbonFilterMonitoringCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ActivatedCarbonFilterMonitoring;
    switch (aEventId) {
    default: {
        // Not a known ActivatedCarbonFilterMonitoring event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForBooleanStateConfigurationCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::BooleanStateConfiguration;
    switch (aEventId) {
    case Events::AlarmsStateChanged::Id: {
        Events::AlarmsStateChanged::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRBooleanStateConfigurationClusterAlarmsStateChangedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.alarmsActive.Raw()];
            value.alarmsActive = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.alarmsSuppressed.HasValue()) {
                memberValue = [NSNumber numberWithUnsignedChar:cppValue.alarmsSuppressed.Value().Raw()];
            } else {
                memberValue = nil;
            }
            value.alarmsSuppressed = memberValue;
        } while (0);

        return value;
    }
    case Events::SensorFault::Id: {
        Events::SensorFault::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRBooleanStateConfigurationClusterSensorFaultEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedShort:cppValue.sensorFault.Raw()];
            value.sensorFault = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known BooleanStateConfiguration event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForValveConfigurationAndControlCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ValveConfigurationAndControl;
    switch (aEventId) {
    case Events::ValveStateChanged::Id: {
        Events::ValveStateChanged::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRValveConfigurationAndControlClusterValveStateChangedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.valveState)];
            value.valveState = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.valveLevel.HasValue()) {
                memberValue = [NSNumber numberWithUnsignedChar:cppValue.valveLevel.Value()];
            } else {
                memberValue = nil;
            }
            value.valveLevel = memberValue;
        } while (0);

        return value;
    }
    case Events::ValveFault::Id: {
        Events::ValveFault::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRValveConfigurationAndControlClusterValveFaultEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedShort:cppValue.valveFault.Raw()];
            value.valveFault = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known ValveConfigurationAndControl event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForElectricalPowerMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ElectricalPowerMeasurement;
    switch (aEventId) {
    case Events::MeasurementPeriodRanges::Id: {
        Events::MeasurementPeriodRanges::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRElectricalPowerMeasurementClusterMeasurementPeriodRangesEvent new];

        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.ranges.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    MTRElectricalPowerMeasurementClusterMeasurementRangeStruct * newElement_0;
                    newElement_0 = [MTRElectricalPowerMeasurementClusterMeasurementRangeStruct new];
                    newElement_0.measurementType = [NSNumber numberWithUnsignedShort:chip::to_underlying(entry_0.measurementType)];
                    newElement_0.min = [NSNumber numberWithLongLong:entry_0.min];
                    newElement_0.max = [NSNumber numberWithLongLong:entry_0.max];
                    if (entry_0.startTimestamp.HasValue()) {
                        newElement_0.startTimestamp = [NSNumber numberWithUnsignedInt:entry_0.startTimestamp.Value()];
                    } else {
                        newElement_0.startTimestamp = nil;
                    }
                    if (entry_0.endTimestamp.HasValue()) {
                        newElement_0.endTimestamp = [NSNumber numberWithUnsignedInt:entry_0.endTimestamp.Value()];
                    } else {
                        newElement_0.endTimestamp = nil;
                    }
                    if (entry_0.minTimestamp.HasValue()) {
                        newElement_0.minTimestamp = [NSNumber numberWithUnsignedInt:entry_0.minTimestamp.Value()];
                    } else {
                        newElement_0.minTimestamp = nil;
                    }
                    if (entry_0.maxTimestamp.HasValue()) {
                        newElement_0.maxTimestamp = [NSNumber numberWithUnsignedInt:entry_0.maxTimestamp.Value()];
                    } else {
                        newElement_0.maxTimestamp = nil;
                    }
                    if (entry_0.startSystime.HasValue()) {
                        newElement_0.startSystime = [NSNumber numberWithUnsignedLongLong:entry_0.startSystime.Value()];
                    } else {
                        newElement_0.startSystime = nil;
                    }
                    if (entry_0.endSystime.HasValue()) {
                        newElement_0.endSystime = [NSNumber numberWithUnsignedLongLong:entry_0.endSystime.Value()];
                    } else {
                        newElement_0.endSystime = nil;
                    }
                    if (entry_0.minSystime.HasValue()) {
                        newElement_0.minSystime = [NSNumber numberWithUnsignedLongLong:entry_0.minSystime.Value()];
                    } else {
                        newElement_0.minSystime = nil;
                    }
                    if (entry_0.maxSystime.HasValue()) {
                        newElement_0.maxSystime = [NSNumber numberWithUnsignedLongLong:entry_0.maxSystime.Value()];
                    } else {
                        newElement_0.maxSystime = nil;
                    }
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.ranges = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known ElectricalPowerMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForElectricalEnergyMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ElectricalEnergyMeasurement;
    switch (aEventId) {
    case Events::CumulativeEnergyMeasured::Id: {
        Events::CumulativeEnergyMeasured::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRElectricalEnergyMeasurementClusterCumulativeEnergyMeasuredEvent new];

        do {
            MTRElectricalEnergyMeasurementClusterEnergyMeasurementStruct * _Nullable memberValue;
            if (cppValue.energyImported.HasValue()) {
                memberValue = [MTRElectricalEnergyMeasurementClusterEnergyMeasurementStruct new];
                memberValue.energy = [NSNumber numberWithLongLong:cppValue.energyImported.Value().energy];
                if (cppValue.energyImported.Value().startTimestamp.HasValue()) {
                    memberValue.startTimestamp = [NSNumber numberWithUnsignedInt:cppValue.energyImported.Value().startTimestamp.Value()];
                } else {
                    memberValue.startTimestamp = nil;
                }
                if (cppValue.energyImported.Value().endTimestamp.HasValue()) {
                    memberValue.endTimestamp = [NSNumber numberWithUnsignedInt:cppValue.energyImported.Value().endTimestamp.Value()];
                } else {
                    memberValue.endTimestamp = nil;
                }
                if (cppValue.energyImported.Value().startSystime.HasValue()) {
                    memberValue.startSystime = [NSNumber numberWithUnsignedLongLong:cppValue.energyImported.Value().startSystime.Value()];
                } else {
                    memberValue.startSystime = nil;
                }
                if (cppValue.energyImported.Value().endSystime.HasValue()) {
                    memberValue.endSystime = [NSNumber numberWithUnsignedLongLong:cppValue.energyImported.Value().endSystime.Value()];
                } else {
                    memberValue.endSystime = nil;
                }
                if (cppValue.energyImported.Value().apparentEnergy.HasValue()) {
                    memberValue.apparentEnergy = [NSNumber numberWithLongLong:cppValue.energyImported.Value().apparentEnergy.Value()];
                } else {
                    memberValue.apparentEnergy = nil;
                }
                if (cppValue.energyImported.Value().reactiveEnergy.HasValue()) {
                    memberValue.reactiveEnergy = [NSNumber numberWithLongLong:cppValue.energyImported.Value().reactiveEnergy.Value()];
                } else {
                    memberValue.reactiveEnergy = nil;
                }
            } else {
                memberValue = nil;
            }
            value.energyImported = memberValue;
        } while (0);
        do {
            MTRElectricalEnergyMeasurementClusterEnergyMeasurementStruct * _Nullable memberValue;
            if (cppValue.energyExported.HasValue()) {
                memberValue = [MTRElectricalEnergyMeasurementClusterEnergyMeasurementStruct new];
                memberValue.energy = [NSNumber numberWithLongLong:cppValue.energyExported.Value().energy];
                if (cppValue.energyExported.Value().startTimestamp.HasValue()) {
                    memberValue.startTimestamp = [NSNumber numberWithUnsignedInt:cppValue.energyExported.Value().startTimestamp.Value()];
                } else {
                    memberValue.startTimestamp = nil;
                }
                if (cppValue.energyExported.Value().endTimestamp.HasValue()) {
                    memberValue.endTimestamp = [NSNumber numberWithUnsignedInt:cppValue.energyExported.Value().endTimestamp.Value()];
                } else {
                    memberValue.endTimestamp = nil;
                }
                if (cppValue.energyExported.Value().startSystime.HasValue()) {
                    memberValue.startSystime = [NSNumber numberWithUnsignedLongLong:cppValue.energyExported.Value().startSystime.Value()];
                } else {
                    memberValue.startSystime = nil;
                }
                if (cppValue.energyExported.Value().endSystime.HasValue()) {
                    memberValue.endSystime = [NSNumber numberWithUnsignedLongLong:cppValue.energyExported.Value().endSystime.Value()];
                } else {
                    memberValue.endSystime = nil;
                }
                if (cppValue.energyExported.Value().apparentEnergy.HasValue()) {
                    memberValue.apparentEnergy = [NSNumber numberWithLongLong:cppValue.energyExported.Value().apparentEnergy.Value()];
                } else {
                    memberValue.apparentEnergy = nil;
                }
                if (cppValue.energyExported.Value().reactiveEnergy.HasValue()) {
                    memberValue.reactiveEnergy = [NSNumber numberWithLongLong:cppValue.energyExported.Value().reactiveEnergy.Value()];
                } else {
                    memberValue.reactiveEnergy = nil;
                }
            } else {
                memberValue = nil;
            }
            value.energyExported = memberValue;
        } while (0);

        return value;
    }
    case Events::PeriodicEnergyMeasured::Id: {
        Events::PeriodicEnergyMeasured::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRElectricalEnergyMeasurementClusterPeriodicEnergyMeasuredEvent new];

        do {
            MTRElectricalEnergyMeasurementClusterEnergyMeasurementStruct * _Nullable memberValue;
            if (cppValue.energyImported.HasValue()) {
                memberValue = [MTRElectricalEnergyMeasurementClusterEnergyMeasurementStruct new];
                memberValue.energy = [NSNumber numberWithLongLong:cppValue.energyImported.Value().energy];
                if (cppValue.energyImported.Value().startTimestamp.HasValue()) {
                    memberValue.startTimestamp = [NSNumber numberWithUnsignedInt:cppValue.energyImported.Value().startTimestamp.Value()];
                } else {
                    memberValue.startTimestamp = nil;
                }
                if (cppValue.energyImported.Value().endTimestamp.HasValue()) {
                    memberValue.endTimestamp = [NSNumber numberWithUnsignedInt:cppValue.energyImported.Value().endTimestamp.Value()];
                } else {
                    memberValue.endTimestamp = nil;
                }
                if (cppValue.energyImported.Value().startSystime.HasValue()) {
                    memberValue.startSystime = [NSNumber numberWithUnsignedLongLong:cppValue.energyImported.Value().startSystime.Value()];
                } else {
                    memberValue.startSystime = nil;
                }
                if (cppValue.energyImported.Value().endSystime.HasValue()) {
                    memberValue.endSystime = [NSNumber numberWithUnsignedLongLong:cppValue.energyImported.Value().endSystime.Value()];
                } else {
                    memberValue.endSystime = nil;
                }
                if (cppValue.energyImported.Value().apparentEnergy.HasValue()) {
                    memberValue.apparentEnergy = [NSNumber numberWithLongLong:cppValue.energyImported.Value().apparentEnergy.Value()];
                } else {
                    memberValue.apparentEnergy = nil;
                }
                if (cppValue.energyImported.Value().reactiveEnergy.HasValue()) {
                    memberValue.reactiveEnergy = [NSNumber numberWithLongLong:cppValue.energyImported.Value().reactiveEnergy.Value()];
                } else {
                    memberValue.reactiveEnergy = nil;
                }
            } else {
                memberValue = nil;
            }
            value.energyImported = memberValue;
        } while (0);
        do {
            MTRElectricalEnergyMeasurementClusterEnergyMeasurementStruct * _Nullable memberValue;
            if (cppValue.energyExported.HasValue()) {
                memberValue = [MTRElectricalEnergyMeasurementClusterEnergyMeasurementStruct new];
                memberValue.energy = [NSNumber numberWithLongLong:cppValue.energyExported.Value().energy];
                if (cppValue.energyExported.Value().startTimestamp.HasValue()) {
                    memberValue.startTimestamp = [NSNumber numberWithUnsignedInt:cppValue.energyExported.Value().startTimestamp.Value()];
                } else {
                    memberValue.startTimestamp = nil;
                }
                if (cppValue.energyExported.Value().endTimestamp.HasValue()) {
                    memberValue.endTimestamp = [NSNumber numberWithUnsignedInt:cppValue.energyExported.Value().endTimestamp.Value()];
                } else {
                    memberValue.endTimestamp = nil;
                }
                if (cppValue.energyExported.Value().startSystime.HasValue()) {
                    memberValue.startSystime = [NSNumber numberWithUnsignedLongLong:cppValue.energyExported.Value().startSystime.Value()];
                } else {
                    memberValue.startSystime = nil;
                }
                if (cppValue.energyExported.Value().endSystime.HasValue()) {
                    memberValue.endSystime = [NSNumber numberWithUnsignedLongLong:cppValue.energyExported.Value().endSystime.Value()];
                } else {
                    memberValue.endSystime = nil;
                }
                if (cppValue.energyExported.Value().apparentEnergy.HasValue()) {
                    memberValue.apparentEnergy = [NSNumber numberWithLongLong:cppValue.energyExported.Value().apparentEnergy.Value()];
                } else {
                    memberValue.apparentEnergy = nil;
                }
                if (cppValue.energyExported.Value().reactiveEnergy.HasValue()) {
                    memberValue.reactiveEnergy = [NSNumber numberWithLongLong:cppValue.energyExported.Value().reactiveEnergy.Value()];
                } else {
                    memberValue.reactiveEnergy = nil;
                }
            } else {
                memberValue = nil;
            }
            value.energyExported = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known ElectricalEnergyMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForWaterHeaterManagementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::WaterHeaterManagement;
    switch (aEventId) {
    case Events::BoostStarted::Id: {
        Events::BoostStarted::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRWaterHeaterManagementClusterBoostStartedEvent new];

        do {
            MTRWaterHeaterManagementClusterWaterHeaterBoostInfoStruct * _Nonnull memberValue;
            memberValue = [MTRWaterHeaterManagementClusterWaterHeaterBoostInfoStruct new];
            memberValue.duration = [NSNumber numberWithUnsignedInt:cppValue.boostInfo.duration];
            if (cppValue.boostInfo.oneShot.HasValue()) {
                memberValue.oneShot = [NSNumber numberWithBool:cppValue.boostInfo.oneShot.Value()];
            } else {
                memberValue.oneShot = nil;
            }
            if (cppValue.boostInfo.emergencyBoost.HasValue()) {
                memberValue.emergencyBoost = [NSNumber numberWithBool:cppValue.boostInfo.emergencyBoost.Value()];
            } else {
                memberValue.emergencyBoost = nil;
            }
            if (cppValue.boostInfo.temporarySetpoint.HasValue()) {
                memberValue.temporarySetpoint = [NSNumber numberWithShort:cppValue.boostInfo.temporarySetpoint.Value()];
            } else {
                memberValue.temporarySetpoint = nil;
            }
            if (cppValue.boostInfo.targetPercentage.HasValue()) {
                memberValue.targetPercentage = [NSNumber numberWithUnsignedChar:cppValue.boostInfo.targetPercentage.Value()];
            } else {
                memberValue.targetPercentage = nil;
            }
            if (cppValue.boostInfo.targetReheat.HasValue()) {
                memberValue.targetReheat = [NSNumber numberWithUnsignedChar:cppValue.boostInfo.targetReheat.Value()];
            } else {
                memberValue.targetReheat = nil;
            }
            value.boostInfo = memberValue;
        } while (0);

        return value;
    }
    case Events::BoostEnded::Id: {
        Events::BoostEnded::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRWaterHeaterManagementClusterBoostEndedEvent new];

        return value;
    }
    default: {
        // Not a known WaterHeaterManagement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForCommodityPriceCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::CommodityPrice;
    switch (aEventId) {
    case Events::PriceChange::Id: {
        Events::PriceChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRCommodityPriceClusterPriceChangeEvent new];

        do {
            MTRCommodityPriceClusterCommodityPriceStruct * _Nullable memberValue;
            if (cppValue.currentPrice.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [MTRCommodityPriceClusterCommodityPriceStruct new];
                memberValue.periodStart = [NSNumber numberWithUnsignedInt:cppValue.currentPrice.Value().periodStart];
                if (cppValue.currentPrice.Value().periodEnd.IsNull()) {
                    memberValue.periodEnd = nil;
                } else {
                    memberValue.periodEnd = [NSNumber numberWithUnsignedInt:cppValue.currentPrice.Value().periodEnd.Value()];
                }
                if (cppValue.currentPrice.Value().price.HasValue()) {
                    memberValue.price = [NSNumber numberWithLongLong:cppValue.currentPrice.Value().price.Value()];
                } else {
                    memberValue.price = nil;
                }
                if (cppValue.currentPrice.Value().priceLevel.HasValue()) {
                    memberValue.priceLevel = [NSNumber numberWithShort:cppValue.currentPrice.Value().priceLevel.Value()];
                } else {
                    memberValue.priceLevel = nil;
                }
                if (cppValue.currentPrice.Value().description.HasValue()) {
                    memberValue.descriptionString = AsString(cppValue.currentPrice.Value().description.Value());
                    if (memberValue.descriptionString == nil) {
                        CHIP_ERROR err = CHIP_ERROR_INVALID_ARGUMENT;
                        *aError = err;
                        return nil;
                    }
                } else {
                    memberValue.descriptionString = nil;
                }
                if (cppValue.currentPrice.Value().components.HasValue()) {
                    { // Scope for our temporary variables
                        auto * array_3 = [NSMutableArray new];
                        auto iter_3 = cppValue.currentPrice.Value().components.Value().begin();
                        while (iter_3.Next()) {
                            auto & entry_3 = iter_3.GetValue();
                            MTRCommodityPriceClusterCommodityPriceComponentStruct * newElement_3;
                            newElement_3 = [MTRCommodityPriceClusterCommodityPriceComponentStruct new];
                            newElement_3.price = [NSNumber numberWithLongLong:entry_3.price];
                            newElement_3.source = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_3.source)];
                            if (entry_3.description.HasValue()) {
                                newElement_3.descriptionString = AsString(entry_3.description.Value());
                                if (newElement_3.descriptionString == nil) {
                                    CHIP_ERROR err = CHIP_ERROR_INVALID_ARGUMENT;
                                    *aError = err;
                                    return nil;
                                }
                            } else {
                                newElement_3.descriptionString = nil;
                            }
                            if (entry_3.tariffComponentID.HasValue()) {
                                newElement_3.tariffComponentID = [NSNumber numberWithUnsignedInt:entry_3.tariffComponentID.Value()];
                            } else {
                                newElement_3.tariffComponentID = nil;
                            }
                            [array_3 addObject:newElement_3];
                        }
                        CHIP_ERROR err = iter_3.GetStatus();
                        if (err != CHIP_NO_ERROR) {
                            *aError = err;
                            return nil;
                        }
                        memberValue.components = array_3;
                    }
                } else {
                    memberValue.components = nil;
                }
            }
            value.currentPrice = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known CommodityPrice event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForMessagesCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::Messages;
    switch (aEventId) {
    case Events::MessageQueued::Id: {
        Events::MessageQueued::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRMessagesClusterMessageQueuedEvent new];

        do {
            NSData * _Nonnull memberValue;
            memberValue = AsData(cppValue.messageID);
            value.messageID = memberValue;
        } while (0);

        return value;
    }
    case Events::MessagePresented::Id: {
        Events::MessagePresented::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRMessagesClusterMessagePresentedEvent new];

        do {
            NSData * _Nonnull memberValue;
            memberValue = AsData(cppValue.messageID);
            value.messageID = memberValue;
        } while (0);

        return value;
    }
    case Events::MessageComplete::Id: {
        Events::MessageComplete::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRMessagesClusterMessageCompleteEvent new];

        do {
            NSData * _Nonnull memberValue;
            memberValue = AsData(cppValue.messageID);
            value.messageID = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.responseID.HasValue()) {
                if (cppValue.responseID.Value().IsNull()) {
                    memberValue = nil;
                } else {
                    memberValue = [NSNumber numberWithUnsignedInt:cppValue.responseID.Value().Value()];
                }
            } else {
                memberValue = nil;
            }
            value.responseID = memberValue;
        } while (0);
        do {
            NSString * _Nullable memberValue;
            if (cppValue.reply.HasValue()) {
                if (cppValue.reply.Value().IsNull()) {
                    memberValue = nil;
                } else {
                    memberValue = AsString(cppValue.reply.Value().Value());
                    if (memberValue == nil) {
                        CHIP_ERROR err = CHIP_ERROR_INVALID_ARGUMENT;
                        *aError = err;
                        return nil;
                    }
                }
            } else {
                memberValue = nil;
            }
            value.reply = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.futureMessagesPreference.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.futureMessagesPreference.Value())];
            }
            value.futureMessagesPreference = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known Messages event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForDeviceEnergyManagementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::DeviceEnergyManagement;
    switch (aEventId) {
    case Events::PowerAdjustStart::Id: {
        Events::PowerAdjustStart::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRDeviceEnergyManagementClusterPowerAdjustStartEvent new];

        return value;
    }
    case Events::PowerAdjustEnd::Id: {
        Events::PowerAdjustEnd::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRDeviceEnergyManagementClusterPowerAdjustEndEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.cause)];
            value.cause = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.duration];
            value.duration = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithLongLong:cppValue.energyUse];
            value.energyUse = memberValue;
        } while (0);

        return value;
    }
    case Events::Paused::Id: {
        Events::Paused::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRDeviceEnergyManagementClusterPausedEvent new];

        return value;
    }
    case Events::Resumed::Id: {
        Events::Resumed::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRDeviceEnergyManagementClusterResumedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.cause)];
            value.cause = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known DeviceEnergyManagement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForEnergyEVSECluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::EnergyEvse;
    switch (aEventId) {
    case Events::EVConnected::Id: {
        Events::EVConnected::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTREnergyEVSEClusterEVConnectedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.sessionID];
            value.sessionID = memberValue;
        } while (0);

        return value;
    }
    case Events::EVNotDetected::Id: {
        Events::EVNotDetected::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTREnergyEVSEClusterEVNotDetectedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.sessionID];
            value.sessionID = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.state)];
            value.state = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.sessionDuration];
            value.sessionDuration = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithLongLong:cppValue.sessionEnergyCharged];
            value.sessionEnergyCharged = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.sessionEnergyDischarged.HasValue()) {
                memberValue = [NSNumber numberWithLongLong:cppValue.sessionEnergyDischarged.Value()];
            } else {
                memberValue = nil;
            }
            value.sessionEnergyDischarged = memberValue;
        } while (0);

        return value;
    }
    case Events::EnergyTransferStarted::Id: {
        Events::EnergyTransferStarted::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTREnergyEVSEClusterEnergyTransferStartedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.sessionID];
            value.sessionID = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.state)];
            value.state = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithLongLong:cppValue.maximumCurrent];
            value.maximumCurrent = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.maximumDischargeCurrent.HasValue()) {
                memberValue = [NSNumber numberWithLongLong:cppValue.maximumDischargeCurrent.Value()];
            } else {
                memberValue = nil;
            }
            value.maximumDischargeCurrent = memberValue;
        } while (0);

        return value;
    }
    case Events::EnergyTransferStopped::Id: {
        Events::EnergyTransferStopped::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTREnergyEVSEClusterEnergyTransferStoppedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.sessionID];
            value.sessionID = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.state)];
            value.state = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.reason)];
            value.reason = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithLongLong:cppValue.energyTransferred];
            value.energyTransferred = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.energyDischarged.HasValue()) {
                memberValue = [NSNumber numberWithLongLong:cppValue.energyDischarged.Value()];
            } else {
                memberValue = nil;
            }
            value.energyDischarged = memberValue;
        } while (0);

        return value;
    }
    case Events::Fault::Id: {
        Events::Fault::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTREnergyEVSEClusterFaultEvent new];

        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.sessionID.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedInt:cppValue.sessionID.Value()];
            }
            value.sessionID = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.state)];
            value.state = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.faultStatePreviousState)];
            value.faultStatePreviousState = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.faultStateCurrentState)];
            value.faultStateCurrentState = memberValue;
        } while (0);

        return value;
    }
    case Events::Rfid::Id: {
        Events::Rfid::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTREnergyEVSEClusterRFIDEvent new];

        do {
            NSData * _Nonnull memberValue;
            memberValue = AsData(cppValue.uid);
            value.uid = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known EnergyEVSE event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForEnergyPreferenceCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::EnergyPreference;
    switch (aEventId) {
    default: {
        // Not a known EnergyPreference event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForPowerTopologyCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::PowerTopology;
    switch (aEventId) {
    default: {
        // Not a known PowerTopology event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForEnergyEVSEModeCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::EnergyEvseMode;
    switch (aEventId) {
    default: {
        // Not a known EnergyEVSEMode event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForWaterHeaterModeCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::WaterHeaterMode;
    switch (aEventId) {
    default: {
        // Not a known WaterHeaterMode event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForDeviceEnergyManagementModeCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::DeviceEnergyManagementMode;
    switch (aEventId) {
    default: {
        // Not a known DeviceEnergyManagementMode event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForElectricalGridConditionsCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ElectricalGridConditions;
    switch (aEventId) {
    case Events::CurrentConditionsChanged::Id: {
        Events::CurrentConditionsChanged::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRElectricalGridConditionsClusterCurrentConditionsChangedEvent new];

        do {
            MTRElectricalGridConditionsClusterElectricalGridConditionsStruct * _Nullable memberValue;
            if (cppValue.currentConditions.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [MTRElectricalGridConditionsClusterElectricalGridConditionsStruct new];
                memberValue.periodStart = [NSNumber numberWithUnsignedInt:cppValue.currentConditions.Value().periodStart];
                if (cppValue.currentConditions.Value().periodEnd.IsNull()) {
                    memberValue.periodEnd = nil;
                } else {
                    memberValue.periodEnd = [NSNumber numberWithUnsignedInt:cppValue.currentConditions.Value().periodEnd.Value()];
                }
                memberValue.gridCarbonIntensity = [NSNumber numberWithShort:cppValue.currentConditions.Value().gridCarbonIntensity];
                memberValue.gridCarbonLevel = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.currentConditions.Value().gridCarbonLevel)];
                memberValue.localCarbonIntensity = [NSNumber numberWithShort:cppValue.currentConditions.Value().localCarbonIntensity];
                memberValue.localCarbonLevel = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.currentConditions.Value().localCarbonLevel)];
            }
            value.currentConditions = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known ElectricalGridConditions event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForDoorLockCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::DoorLock;
    switch (aEventId) {
    case Events::DoorLockAlarm::Id: {
        Events::DoorLockAlarm::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRDoorLockClusterDoorLockAlarmEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.alarmCode)];
            value.alarmCode = memberValue;
        } while (0);

        return value;
    }
    case Events::DoorStateChange::Id: {
        Events::DoorStateChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRDoorLockClusterDoorStateChangeEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.doorState)];
            value.doorState = memberValue;
        } while (0);

        return value;
    }
    case Events::LockOperation::Id: {
        Events::LockOperation::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRDoorLockClusterLockOperationEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.lockOperationType)];
            value.lockOperationType = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.operationSource)];
            value.operationSource = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.userIndex.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedShort:cppValue.userIndex.Value()];
            }
            value.userIndex = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.fabricIndex.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedChar:cppValue.fabricIndex.Value()];
            }
            value.fabricIndex = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.sourceNode.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedLongLong:cppValue.sourceNode.Value()];
            }
            value.sourceNode = memberValue;
        } while (0);
        do {
            NSArray * _Nullable memberValue;
            if (cppValue.credentials.HasValue()) {
                if (cppValue.credentials.Value().IsNull()) {
                    memberValue = nil;
                } else {
                    { // Scope for our temporary variables
                        auto * array_2 = [NSMutableArray new];
                        auto iter_2 = cppValue.credentials.Value().Value().begin();
                        while (iter_2.Next()) {
                            auto & entry_2 = iter_2.GetValue();
                            MTRDoorLockClusterCredentialStruct * newElement_2;
                            newElement_2 = [MTRDoorLockClusterCredentialStruct new];
                            newElement_2.credentialType = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_2.credentialType)];
                            newElement_2.credentialIndex = [NSNumber numberWithUnsignedShort:entry_2.credentialIndex];
                            [array_2 addObject:newElement_2];
                        }
                        CHIP_ERROR err = iter_2.GetStatus();
                        if (err != CHIP_NO_ERROR) {
                            *aError = err;
                            return nil;
                        }
                        memberValue = array_2;
                    }
                }
            } else {
                memberValue = nil;
            }
            value.credentials = memberValue;
        } while (0);

        return value;
    }
    case Events::LockOperationError::Id: {
        Events::LockOperationError::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRDoorLockClusterLockOperationErrorEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.lockOperationType)];
            value.lockOperationType = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.operationSource)];
            value.operationSource = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.operationError)];
            value.operationError = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.userIndex.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedShort:cppValue.userIndex.Value()];
            }
            value.userIndex = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.fabricIndex.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedChar:cppValue.fabricIndex.Value()];
            }
            value.fabricIndex = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.sourceNode.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedLongLong:cppValue.sourceNode.Value()];
            }
            value.sourceNode = memberValue;
        } while (0);
        do {
            NSArray * _Nullable memberValue;
            if (cppValue.credentials.HasValue()) {
                if (cppValue.credentials.Value().IsNull()) {
                    memberValue = nil;
                } else {
                    { // Scope for our temporary variables
                        auto * array_2 = [NSMutableArray new];
                        auto iter_2 = cppValue.credentials.Value().Value().begin();
                        while (iter_2.Next()) {
                            auto & entry_2 = iter_2.GetValue();
                            MTRDoorLockClusterCredentialStruct * newElement_2;
                            newElement_2 = [MTRDoorLockClusterCredentialStruct new];
                            newElement_2.credentialType = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_2.credentialType)];
                            newElement_2.credentialIndex = [NSNumber numberWithUnsignedShort:entry_2.credentialIndex];
                            [array_2 addObject:newElement_2];
                        }
                        CHIP_ERROR err = iter_2.GetStatus();
                        if (err != CHIP_NO_ERROR) {
                            *aError = err;
                            return nil;
                        }
                        memberValue = array_2;
                    }
                }
            } else {
                memberValue = nil;
            }
            value.credentials = memberValue;
        } while (0);

        return value;
    }
    case Events::LockUserChange::Id: {
        Events::LockUserChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRDoorLockClusterLockUserChangeEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.lockDataType)];
            value.lockDataType = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.dataOperationType)];
            value.dataOperationType = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.operationSource)];
            value.operationSource = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.userIndex.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedShort:cppValue.userIndex.Value()];
            }
            value.userIndex = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.fabricIndex.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedChar:cppValue.fabricIndex.Value()];
            }
            value.fabricIndex = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.sourceNode.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedLongLong:cppValue.sourceNode.Value()];
            }
            value.sourceNode = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.dataIndex.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithUnsignedShort:cppValue.dataIndex.Value()];
            }
            value.dataIndex = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known DoorLock event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForWindowCoveringCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::WindowCovering;
    switch (aEventId) {
    default: {
        // Not a known WindowCovering event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForClosureControlCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ClosureControl;
    switch (aEventId) {
    case Events::OperationalError::Id: {
        Events::OperationalError::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRClosureControlClusterOperationalErrorEvent new];

        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.errorState.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    NSNumber * newElement_0;
                    newElement_0 = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0)];
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.errorState = memberValue;
        } while (0);

        return value;
    }
    case Events::MovementCompleted::Id: {
        Events::MovementCompleted::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRClosureControlClusterMovementCompletedEvent new];

        return value;
    }
    case Events::EngageStateChanged::Id: {
        Events::EngageStateChanged::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRClosureControlClusterEngageStateChangedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithBool:cppValue.engageValue];
            value.engageValue = memberValue;
        } while (0);

        return value;
    }
    case Events::SecureStateChanged::Id: {
        Events::SecureStateChanged::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRClosureControlClusterSecureStateChangedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithBool:cppValue.secureValue];
            value.secureValue = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known ClosureControl event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForClosureDimensionCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ClosureDimension;
    switch (aEventId) {
    default: {
        // Not a known ClosureDimension event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForServiceAreaCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ServiceArea;
    switch (aEventId) {
    default: {
        // Not a known ServiceArea event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForPumpConfigurationAndControlCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::PumpConfigurationAndControl;
    switch (aEventId) {
    case Events::SupplyVoltageLow::Id: {
        Events::SupplyVoltageLow::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPumpConfigurationAndControlClusterSupplyVoltageLowEvent new];

        return value;
    }
    case Events::SupplyVoltageHigh::Id: {
        Events::SupplyVoltageHigh::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPumpConfigurationAndControlClusterSupplyVoltageHighEvent new];

        return value;
    }
    case Events::PowerMissingPhase::Id: {
        Events::PowerMissingPhase::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPumpConfigurationAndControlClusterPowerMissingPhaseEvent new];

        return value;
    }
    case Events::SystemPressureLow::Id: {
        Events::SystemPressureLow::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPumpConfigurationAndControlClusterSystemPressureLowEvent new];

        return value;
    }
    case Events::SystemPressureHigh::Id: {
        Events::SystemPressureHigh::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPumpConfigurationAndControlClusterSystemPressureHighEvent new];

        return value;
    }
    case Events::DryRunning::Id: {
        Events::DryRunning::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPumpConfigurationAndControlClusterDryRunningEvent new];

        return value;
    }
    case Events::MotorTemperatureHigh::Id: {
        Events::MotorTemperatureHigh::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPumpConfigurationAndControlClusterMotorTemperatureHighEvent new];

        return value;
    }
    case Events::PumpMotorFatalFailure::Id: {
        Events::PumpMotorFatalFailure::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPumpConfigurationAndControlClusterPumpMotorFatalFailureEvent new];

        return value;
    }
    case Events::ElectronicTemperatureHigh::Id: {
        Events::ElectronicTemperatureHigh::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPumpConfigurationAndControlClusterElectronicTemperatureHighEvent new];

        return value;
    }
    case Events::PumpBlocked::Id: {
        Events::PumpBlocked::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPumpConfigurationAndControlClusterPumpBlockedEvent new];

        return value;
    }
    case Events::SensorFailure::Id: {
        Events::SensorFailure::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPumpConfigurationAndControlClusterSensorFailureEvent new];

        return value;
    }
    case Events::ElectronicNonFatalFailure::Id: {
        Events::ElectronicNonFatalFailure::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPumpConfigurationAndControlClusterElectronicNonFatalFailureEvent new];

        return value;
    }
    case Events::ElectronicFatalFailure::Id: {
        Events::ElectronicFatalFailure::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPumpConfigurationAndControlClusterElectronicFatalFailureEvent new];

        return value;
    }
    case Events::GeneralFault::Id: {
        Events::GeneralFault::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPumpConfigurationAndControlClusterGeneralFaultEvent new];

        return value;
    }
    case Events::Leakage::Id: {
        Events::Leakage::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPumpConfigurationAndControlClusterLeakageEvent new];

        return value;
    }
    case Events::AirDetection::Id: {
        Events::AirDetection::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPumpConfigurationAndControlClusterAirDetectionEvent new];

        return value;
    }
    case Events::TurbineOperation::Id: {
        Events::TurbineOperation::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPumpConfigurationAndControlClusterTurbineOperationEvent new];

        return value;
    }
    default: {
        // Not a known PumpConfigurationAndControl event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForThermostatCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::Thermostat;
    switch (aEventId) {
    case Events::SystemModeChange::Id: {
        Events::SystemModeChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRThermostatClusterSystemModeChangeEvent new];

        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.previousSystemMode.HasValue()) {
                memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.previousSystemMode.Value())];
            } else {
                memberValue = nil;
            }
            value.previousSystemMode = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.currentSystemMode)];
            value.currentSystemMode = memberValue;
        } while (0);

        return value;
    }
    case Events::LocalTemperatureChange::Id: {
        Events::LocalTemperatureChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRThermostatClusterLocalTemperatureChangeEvent new];

        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.currentLocalTemperature.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = [NSNumber numberWithShort:cppValue.currentLocalTemperature.Value()];
            }
            value.currentLocalTemperature = memberValue;
        } while (0);

        return value;
    }
    case Events::OccupancyChange::Id: {
        Events::OccupancyChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRThermostatClusterOccupancyChangeEvent new];

        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.previousOccupancy.HasValue()) {
                memberValue = [NSNumber numberWithUnsignedChar:cppValue.previousOccupancy.Value().Raw()];
            } else {
                memberValue = nil;
            }
            value.previousOccupancy = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.currentOccupancy.Raw()];
            value.currentOccupancy = memberValue;
        } while (0);

        return value;
    }
    case Events::SetpointChange::Id: {
        Events::SetpointChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRThermostatClusterSetpointChangeEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.systemMode)];
            value.systemMode = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.occupancy.HasValue()) {
                memberValue = [NSNumber numberWithUnsignedChar:cppValue.occupancy.Value().Raw()];
            } else {
                memberValue = nil;
            }
            value.occupancy = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.previousSetpoint.HasValue()) {
                memberValue = [NSNumber numberWithShort:cppValue.previousSetpoint.Value()];
            } else {
                memberValue = nil;
            }
            value.previousSetpoint = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithShort:cppValue.currentSetpoint];
            value.currentSetpoint = memberValue;
        } while (0);

        return value;
    }
    case Events::RunningStateChange::Id: {
        Events::RunningStateChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRThermostatClusterRunningStateChangeEvent new];

        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.previousRunningState.HasValue()) {
                memberValue = [NSNumber numberWithUnsignedShort:cppValue.previousRunningState.Value().Raw()];
            } else {
                memberValue = nil;
            }
            value.previousRunningState = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedShort:cppValue.currentRunningState.Raw()];
            value.currentRunningState = memberValue;
        } while (0);

        return value;
    }
    case Events::RunningModeChange::Id: {
        Events::RunningModeChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRThermostatClusterRunningModeChangeEvent new];

        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.previousRunningMode.HasValue()) {
                memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.previousRunningMode.Value())];
            } else {
                memberValue = nil;
            }
            value.previousRunningMode = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.currentRunningMode)];
            value.currentRunningMode = memberValue;
        } while (0);

        return value;
    }
    case Events::ActiveScheduleChange::Id: {
        Events::ActiveScheduleChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRThermostatClusterActiveScheduleChangeEvent new];

        do {
            NSData * _Nullable memberValue;
            if (cppValue.previousScheduleHandle.HasValue()) {
                if (cppValue.previousScheduleHandle.Value().IsNull()) {
                    memberValue = nil;
                } else {
                    memberValue = AsData(cppValue.previousScheduleHandle.Value().Value());
                }
            } else {
                memberValue = nil;
            }
            value.previousScheduleHandle = memberValue;
        } while (0);
        do {
            NSData * _Nullable memberValue;
            if (cppValue.currentScheduleHandle.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = AsData(cppValue.currentScheduleHandle.Value());
            }
            value.currentScheduleHandle = memberValue;
        } while (0);

        return value;
    }
    case Events::ActivePresetChange::Id: {
        Events::ActivePresetChange::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRThermostatClusterActivePresetChangeEvent new];

        do {
            NSData * _Nullable memberValue;
            if (cppValue.previousPresetHandle.HasValue()) {
                if (cppValue.previousPresetHandle.Value().IsNull()) {
                    memberValue = nil;
                } else {
                    memberValue = AsData(cppValue.previousPresetHandle.Value().Value());
                }
            } else {
                memberValue = nil;
            }
            value.previousPresetHandle = memberValue;
        } while (0);
        do {
            NSData * _Nullable memberValue;
            if (cppValue.currentPresetHandle.IsNull()) {
                memberValue = nil;
            } else {
                memberValue = AsData(cppValue.currentPresetHandle.Value());
            }
            value.currentPresetHandle = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known Thermostat event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForFanControlCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::FanControl;
    switch (aEventId) {
    default: {
        // Not a known FanControl event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForThermostatUserInterfaceConfigurationCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ThermostatUserInterfaceConfiguration;
    switch (aEventId) {
    default: {
        // Not a known ThermostatUserInterfaceConfiguration event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForColorControlCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ColorControl;
    switch (aEventId) {
    default: {
        // Not a known ColorControl event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForBallastConfigurationCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::BallastConfiguration;
    switch (aEventId) {
    default: {
        // Not a known BallastConfiguration event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForIlluminanceMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::IlluminanceMeasurement;
    switch (aEventId) {
    default: {
        // Not a known IlluminanceMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForTemperatureMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::TemperatureMeasurement;
    switch (aEventId) {
    default: {
        // Not a known TemperatureMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForPressureMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::PressureMeasurement;
    switch (aEventId) {
    default: {
        // Not a known PressureMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForFlowMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::FlowMeasurement;
    switch (aEventId) {
    default: {
        // Not a known FlowMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForRelativeHumidityMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::RelativeHumidityMeasurement;
    switch (aEventId) {
    default: {
        // Not a known RelativeHumidityMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForOccupancySensingCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::OccupancySensing;
    switch (aEventId) {
    case Events::OccupancyChanged::Id: {
        Events::OccupancyChanged::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTROccupancySensingClusterOccupancyChangedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.occupancy.Raw()];
            value.occupancy = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known OccupancySensing event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForCarbonMonoxideConcentrationMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::CarbonMonoxideConcentrationMeasurement;
    switch (aEventId) {
    default: {
        // Not a known CarbonMonoxideConcentrationMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForCarbonDioxideConcentrationMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::CarbonDioxideConcentrationMeasurement;
    switch (aEventId) {
    default: {
        // Not a known CarbonDioxideConcentrationMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForNitrogenDioxideConcentrationMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::NitrogenDioxideConcentrationMeasurement;
    switch (aEventId) {
    default: {
        // Not a known NitrogenDioxideConcentrationMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForOzoneConcentrationMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::OzoneConcentrationMeasurement;
    switch (aEventId) {
    default: {
        // Not a known OzoneConcentrationMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForPM25ConcentrationMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::Pm25ConcentrationMeasurement;
    switch (aEventId) {
    default: {
        // Not a known PM25ConcentrationMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForFormaldehydeConcentrationMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::FormaldehydeConcentrationMeasurement;
    switch (aEventId) {
    default: {
        // Not a known FormaldehydeConcentrationMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForPM1ConcentrationMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::Pm1ConcentrationMeasurement;
    switch (aEventId) {
    default: {
        // Not a known PM1ConcentrationMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForPM10ConcentrationMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::Pm10ConcentrationMeasurement;
    switch (aEventId) {
    default: {
        // Not a known PM10ConcentrationMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForTotalVolatileOrganicCompoundsConcentrationMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::TotalVolatileOrganicCompoundsConcentrationMeasurement;
    switch (aEventId) {
    default: {
        // Not a known TotalVolatileOrganicCompoundsConcentrationMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForRadonConcentrationMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::RadonConcentrationMeasurement;
    switch (aEventId) {
    default: {
        // Not a known RadonConcentrationMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForSoilMeasurementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::SoilMeasurement;
    switch (aEventId) {
    default: {
        // Not a known SoilMeasurement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForWiFiNetworkManagementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::WiFiNetworkManagement;
    switch (aEventId) {
    default: {
        // Not a known WiFiNetworkManagement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForThreadBorderRouterManagementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ThreadBorderRouterManagement;
    switch (aEventId) {
    default: {
        // Not a known ThreadBorderRouterManagement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForThreadNetworkDirectoryCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ThreadNetworkDirectory;
    switch (aEventId) {
    default: {
        // Not a known ThreadNetworkDirectory event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForWakeOnLANCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::WakeOnLan;
    switch (aEventId) {
    default: {
        // Not a known WakeOnLAN event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForChannelCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::Channel;
    switch (aEventId) {
    default: {
        // Not a known Channel event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForTargetNavigatorCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::TargetNavigator;
    switch (aEventId) {
    case Events::TargetUpdated::Id: {
        Events::TargetUpdated::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRTargetNavigatorClusterTargetUpdatedEvent new];

        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.targetList.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    MTRTargetNavigatorClusterTargetInfoStruct * newElement_0;
                    newElement_0 = [MTRTargetNavigatorClusterTargetInfoStruct new];
                    newElement_0.identifier = [NSNumber numberWithUnsignedChar:entry_0.identifier];
                    newElement_0.name = AsString(entry_0.name);
                    if (newElement_0.name == nil) {
                        CHIP_ERROR err = CHIP_ERROR_INVALID_ARGUMENT;
                        *aError = err;
                        return nil;
                    }
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.targetList = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.currentTarget];
            value.currentTarget = memberValue;
        } while (0);
        do {
            NSData * _Nonnull memberValue;
            memberValue = AsData(cppValue.data);
            value.data = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known TargetNavigator event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForMediaPlaybackCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::MediaPlayback;
    switch (aEventId) {
    case Events::StateChanged::Id: {
        Events::StateChanged::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRMediaPlaybackClusterStateChangedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.currentState)];
            value.currentState = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedLongLong:cppValue.startTime];
            value.startTime = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedLongLong:cppValue.duration];
            value.duration = memberValue;
        } while (0);
        do {
            MTRMediaPlaybackClusterPlaybackPositionStruct * _Nonnull memberValue;
            memberValue = [MTRMediaPlaybackClusterPlaybackPositionStruct new];
            memberValue.updatedAt = [NSNumber numberWithUnsignedLongLong:cppValue.sampledPosition.updatedAt];
            if (cppValue.sampledPosition.position.IsNull()) {
                memberValue.position = nil;
            } else {
                memberValue.position = [NSNumber numberWithUnsignedLongLong:cppValue.sampledPosition.position.Value()];
            }
            value.sampledPosition = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithFloat:cppValue.playbackSpeed];
            value.playbackSpeed = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedLongLong:cppValue.seekRangeEnd];
            value.seekRangeEnd = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedLongLong:cppValue.seekRangeStart];
            value.seekRangeStart = memberValue;
        } while (0);
        do {
            NSData * _Nullable memberValue;
            if (cppValue.data.HasValue()) {
                memberValue = AsData(cppValue.data.Value());
            } else {
                memberValue = nil;
            }
            value.data = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithBool:cppValue.audioAdvanceUnmuted];
            value.audioAdvanceUnmuted = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known MediaPlayback event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForMediaInputCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::MediaInput;
    switch (aEventId) {
    default: {
        // Not a known MediaInput event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForLowPowerCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::LowPower;
    switch (aEventId) {
    default: {
        // Not a known LowPower event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForKeypadInputCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::KeypadInput;
    switch (aEventId) {
    default: {
        // Not a known KeypadInput event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForContentLauncherCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ContentLauncher;
    switch (aEventId) {
    default: {
        // Not a known ContentLauncher event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForAudioOutputCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::AudioOutput;
    switch (aEventId) {
    default: {
        // Not a known AudioOutput event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForApplicationLauncherCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ApplicationLauncher;
    switch (aEventId) {
    default: {
        // Not a known ApplicationLauncher event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForApplicationBasicCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ApplicationBasic;
    switch (aEventId) {
    default: {
        // Not a known ApplicationBasic event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForAccountLoginCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::AccountLogin;
    switch (aEventId) {
    case Events::LoggedOut::Id: {
        Events::LoggedOut::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRAccountLoginClusterLoggedOutEvent new];

        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.node.HasValue()) {
                memberValue = [NSNumber numberWithUnsignedLongLong:cppValue.node.Value()];
            } else {
                memberValue = nil;
            }
            value.node = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.fabricIndex];
            value.fabricIndex = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known AccountLogin event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForContentControlCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ContentControl;
    switch (aEventId) {
    case Events::RemainingScreenTimeExpired::Id: {
        Events::RemainingScreenTimeExpired::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRContentControlClusterRemainingScreenTimeExpiredEvent new];

        return value;
    }
    default: {
        // Not a known ContentControl event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForContentAppObserverCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ContentAppObserver;
    switch (aEventId) {
    default: {
        // Not a known ContentAppObserver event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForZoneManagementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::ZoneManagement;
    switch (aEventId) {
    case Events::ZoneTriggered::Id: {
        Events::ZoneTriggered::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRZoneManagementClusterZoneTriggeredEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedShort:cppValue.zone];
            value.zone = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.reason)];
            value.reason = memberValue;
        } while (0);

        return value;
    }
    case Events::ZoneStopped::Id: {
        Events::ZoneStopped::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRZoneManagementClusterZoneStoppedEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedShort:cppValue.zone];
            value.zone = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.reason)];
            value.reason = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known ZoneManagement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForCameraAVStreamManagementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::CameraAvStreamManagement;
    switch (aEventId) {
    default: {
        // Not a known CameraAVStreamManagement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForCameraAVSettingsUserLevelManagementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::CameraAvSettingsUserLevelManagement;
    switch (aEventId) {
    default: {
        // Not a known CameraAVSettingsUserLevelManagement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForWebRTCTransportProviderCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::WebRTCTransportProvider;
    switch (aEventId) {
    default: {
        // Not a known WebRTCTransportProvider event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForWebRTCTransportRequestorCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::WebRTCTransportRequestor;
    switch (aEventId) {
    default: {
        // Not a known WebRTCTransportRequestor event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForPushAVStreamTransportCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::PushAvStreamTransport;
    switch (aEventId) {
    case Events::PushTransportBegin::Id: {
        Events::PushTransportBegin::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPushAVStreamTransportClusterPushTransportBeginEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedShort:cppValue.connectionID];
            value.connectionID = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.triggerType)];
            value.triggerType = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.activationReason.HasValue()) {
                memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.activationReason.Value())];
            } else {
                memberValue = nil;
            }
            value.activationReason = memberValue;
        } while (0);

        return value;
    }
    case Events::PushTransportEnd::Id: {
        Events::PushTransportEnd::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRPushAVStreamTransportClusterPushTransportEndEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedShort:cppValue.connectionID];
            value.connectionID = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.triggerType)];
            value.triggerType = memberValue;
        } while (0);
        do {
            NSNumber * _Nullable memberValue;
            if (cppValue.activationReason.HasValue()) {
                memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.activationReason.Value())];
            } else {
                memberValue = nil;
            }
            value.activationReason = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known PushAVStreamTransport event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForChimeCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::Chime;
    switch (aEventId) {
    default: {
        // Not a known Chime event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForCommodityTariffCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::CommodityTariff;
    switch (aEventId) {
    default: {
        // Not a known CommodityTariff event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForEcosystemInformationCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::EcosystemInformation;
    switch (aEventId) {
    default: {
        // Not a known EcosystemInformation event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForCommissionerControlCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::CommissionerControl;
    switch (aEventId) {
    case Events::CommissioningRequestResult::Id: {
        Events::CommissioningRequestResult::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRCommissionerControlClusterCommissioningRequestResultEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedLongLong:cppValue.requestID];
            value.requestID = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedLongLong:cppValue.clientNodeID];
            value.clientNodeID = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.statusCode];
            value.statusCode = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.fabricIndex];
            value.fabricIndex = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known CommissionerControl event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForJointFabricDatastoreCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::JointFabricDatastore;
    switch (aEventId) {
    default: {
        // Not a known JointFabricDatastore event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForJointFabricAdministratorCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::JointFabricAdministrator;
    switch (aEventId) {
    default: {
        // Not a known JointFabricAdministrator event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForTLSCertificateManagementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::TlsCertificateManagement;
    switch (aEventId) {
    default: {
        // Not a known TLSCertificateManagement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForTLSClientManagementCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::TlsClientManagement;
    switch (aEventId) {
    default: {
        // Not a known TLSClientManagement event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForMeterIdentificationCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::MeterIdentification;
    switch (aEventId) {
    default: {
        // Not a known MeterIdentification event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForCommodityMeteringCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::CommodityMetering;
    switch (aEventId) {
    default: {
        // Not a known CommodityMetering event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForUnitTestingCluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::UnitTesting;
    switch (aEventId) {
    case Events::TestEvent::Id: {
        Events::TestEvent::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRUnitTestingClusterTestEventEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.arg1];
            value.arg1 = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.arg2)];
            value.arg2 = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithBool:cppValue.arg3];
            value.arg3 = memberValue;
        } while (0);
        do {
            MTRUnitTestingClusterSimpleStruct * _Nonnull memberValue;
            memberValue = [MTRUnitTestingClusterSimpleStruct new];
            memberValue.a = [NSNumber numberWithUnsignedChar:cppValue.arg4.a];
            memberValue.b = [NSNumber numberWithBool:cppValue.arg4.b];
            memberValue.c = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.arg4.c)];
            memberValue.d = AsData(cppValue.arg4.d);
            memberValue.e = AsString(cppValue.arg4.e);
            if (memberValue.e == nil) {
                CHIP_ERROR err = CHIP_ERROR_INVALID_ARGUMENT;
                *aError = err;
                return nil;
            }
            memberValue.f = [NSNumber numberWithUnsignedChar:cppValue.arg4.f.Raw()];
            memberValue.g = [NSNumber numberWithFloat:cppValue.arg4.g];
            memberValue.h = [NSNumber numberWithDouble:cppValue.arg4.h];
            if (cppValue.arg4.i.HasValue()) {
                memberValue.i = [NSNumber numberWithUnsignedChar:chip::to_underlying(cppValue.arg4.i.Value())];
            } else {
                memberValue.i = nil;
            }
            value.arg4 = memberValue;
        } while (0);
        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.arg5.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    MTRUnitTestingClusterSimpleStruct * newElement_0;
                    newElement_0 = [MTRUnitTestingClusterSimpleStruct new];
                    newElement_0.a = [NSNumber numberWithUnsignedChar:entry_0.a];
                    newElement_0.b = [NSNumber numberWithBool:entry_0.b];
                    newElement_0.c = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0.c)];
                    newElement_0.d = AsData(entry_0.d);
                    newElement_0.e = AsString(entry_0.e);
                    if (newElement_0.e == nil) {
                        CHIP_ERROR err = CHIP_ERROR_INVALID_ARGUMENT;
                        *aError = err;
                        return nil;
                    }
                    newElement_0.f = [NSNumber numberWithUnsignedChar:entry_0.f.Raw()];
                    newElement_0.g = [NSNumber numberWithFloat:entry_0.g];
                    newElement_0.h = [NSNumber numberWithDouble:entry_0.h];
                    if (entry_0.i.HasValue()) {
                        newElement_0.i = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0.i.Value())];
                    } else {
                        newElement_0.i = nil;
                    }
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.arg5 = memberValue;
        } while (0);
        do {
            NSArray * _Nonnull memberValue;
            { // Scope for our temporary variables
                auto * array_0 = [NSMutableArray new];
                auto iter_0 = cppValue.arg6.begin();
                while (iter_0.Next()) {
                    auto & entry_0 = iter_0.GetValue();
                    NSNumber * newElement_0;
                    newElement_0 = [NSNumber numberWithUnsignedChar:chip::to_underlying(entry_0)];
                    [array_0 addObject:newElement_0];
                }
                CHIP_ERROR err = iter_0.GetStatus();
                if (err != CHIP_NO_ERROR) {
                    *aError = err;
                    return nil;
                }
                memberValue = array_0;
            }
            value.arg6 = memberValue;
        } while (0);

        return value;
    }
    case Events::TestFabricScopedEvent::Id: {
        Events::TestFabricScopedEvent::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRUnitTestingClusterTestFabricScopedEventEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.fabricIndex];
            value.fabricIndex = memberValue;
        } while (0);

        return value;
    }
    case Events::TestDifferentVendorMeiEvent::Id: {
        Events::TestDifferentVendorMeiEvent::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRUnitTestingClusterTestDifferentVendorMeiEventEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.arg1];
            value.arg1 = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known UnitTesting event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
static id _Nullable DecodeEventPayloadForSampleMEICluster(EventId aEventId, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    using namespace Clusters::SampleMei;
    switch (aEventId) {
    case Events::PingCountEvent::Id: {
        Events::PingCountEvent::DecodableType cppValue;
        *aError = DataModel::Decode(aReader, cppValue);
        if (*aError != CHIP_NO_ERROR) {
            return nil;
        }

        __auto_type * value = [MTRSampleMEIClusterPingCountEventEvent new];

        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedInt:cppValue.count];
            value.count = memberValue;
        } while (0);
        do {
            NSNumber * _Nonnull memberValue;
            memberValue = [NSNumber numberWithUnsignedChar:cppValue.fabricIndex];
            value.fabricIndex = memberValue;
        } while (0);

        return value;
    }
    default: {
        // Not a known SampleMEI event.
        break;
    }
    }

    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}

id _Nullable MTRDecodeEventPayload(const ConcreteEventPath & aPath, TLV::TLVReader & aReader, CHIP_ERROR * aError)
{
    switch (aPath.mClusterId) {
    case Clusters::Identify::Id: {
        return DecodeEventPayloadForIdentifyCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::Groups::Id: {
        return DecodeEventPayloadForGroupsCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::OnOff::Id: {
        return DecodeEventPayloadForOnOffCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::LevelControl::Id: {
        return DecodeEventPayloadForLevelControlCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::PulseWidthModulation::Id: {
        return DecodeEventPayloadForPulseWidthModulationCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::Descriptor::Id: {
        return DecodeEventPayloadForDescriptorCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::Binding::Id: {
        return DecodeEventPayloadForBindingCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::AccessControl::Id: {
        return DecodeEventPayloadForAccessControlCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::Actions::Id: {
        return DecodeEventPayloadForActionsCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::BasicInformation::Id: {
        return DecodeEventPayloadForBasicInformationCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::OtaSoftwareUpdateProvider::Id: {
        return DecodeEventPayloadForOTASoftwareUpdateProviderCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::OtaSoftwareUpdateRequestor::Id: {
        return DecodeEventPayloadForOTASoftwareUpdateRequestorCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::LocalizationConfiguration::Id: {
        return DecodeEventPayloadForLocalizationConfigurationCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::TimeFormatLocalization::Id: {
        return DecodeEventPayloadForTimeFormatLocalizationCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::UnitLocalization::Id: {
        return DecodeEventPayloadForUnitLocalizationCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::PowerSourceConfiguration::Id: {
        return DecodeEventPayloadForPowerSourceConfigurationCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::PowerSource::Id: {
        return DecodeEventPayloadForPowerSourceCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::GeneralCommissioning::Id: {
        return DecodeEventPayloadForGeneralCommissioningCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::NetworkCommissioning::Id: {
        return DecodeEventPayloadForNetworkCommissioningCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::DiagnosticLogs::Id: {
        return DecodeEventPayloadForDiagnosticLogsCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::GeneralDiagnostics::Id: {
        return DecodeEventPayloadForGeneralDiagnosticsCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::SoftwareDiagnostics::Id: {
        return DecodeEventPayloadForSoftwareDiagnosticsCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ThreadNetworkDiagnostics::Id: {
        return DecodeEventPayloadForThreadNetworkDiagnosticsCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::WiFiNetworkDiagnostics::Id: {
        return DecodeEventPayloadForWiFiNetworkDiagnosticsCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::EthernetNetworkDiagnostics::Id: {
        return DecodeEventPayloadForEthernetNetworkDiagnosticsCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::TimeSynchronization::Id: {
        return DecodeEventPayloadForTimeSynchronizationCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::BridgedDeviceBasicInformation::Id: {
        return DecodeEventPayloadForBridgedDeviceBasicInformationCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::Switch::Id: {
        return DecodeEventPayloadForSwitchCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::AdministratorCommissioning::Id: {
        return DecodeEventPayloadForAdministratorCommissioningCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::OperationalCredentials::Id: {
        return DecodeEventPayloadForOperationalCredentialsCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::GroupKeyManagement::Id: {
        return DecodeEventPayloadForGroupKeyManagementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::FixedLabel::Id: {
        return DecodeEventPayloadForFixedLabelCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::UserLabel::Id: {
        return DecodeEventPayloadForUserLabelCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::BooleanState::Id: {
        return DecodeEventPayloadForBooleanStateCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::IcdManagement::Id: {
        return DecodeEventPayloadForICDManagementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::Timer::Id: {
        return DecodeEventPayloadForTimerCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::OvenCavityOperationalState::Id: {
        return DecodeEventPayloadForOvenCavityOperationalStateCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::OvenMode::Id: {
        return DecodeEventPayloadForOvenModeCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::LaundryDryerControls::Id: {
        return DecodeEventPayloadForLaundryDryerControlsCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ModeSelect::Id: {
        return DecodeEventPayloadForModeSelectCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::LaundryWasherMode::Id: {
        return DecodeEventPayloadForLaundryWasherModeCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::RefrigeratorAndTemperatureControlledCabinetMode::Id: {
        return DecodeEventPayloadForRefrigeratorAndTemperatureControlledCabinetModeCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::LaundryWasherControls::Id: {
        return DecodeEventPayloadForLaundryWasherControlsCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::RvcRunMode::Id: {
        return DecodeEventPayloadForRVCRunModeCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::RvcCleanMode::Id: {
        return DecodeEventPayloadForRVCCleanModeCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::TemperatureControl::Id: {
        return DecodeEventPayloadForTemperatureControlCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::RefrigeratorAlarm::Id: {
        return DecodeEventPayloadForRefrigeratorAlarmCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::DishwasherMode::Id: {
        return DecodeEventPayloadForDishwasherModeCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::AirQuality::Id: {
        return DecodeEventPayloadForAirQualityCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::SmokeCoAlarm::Id: {
        return DecodeEventPayloadForSmokeCOAlarmCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::DishwasherAlarm::Id: {
        return DecodeEventPayloadForDishwasherAlarmCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::MicrowaveOvenMode::Id: {
        return DecodeEventPayloadForMicrowaveOvenModeCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::MicrowaveOvenControl::Id: {
        return DecodeEventPayloadForMicrowaveOvenControlCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::OperationalState::Id: {
        return DecodeEventPayloadForOperationalStateCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::RvcOperationalState::Id: {
        return DecodeEventPayloadForRVCOperationalStateCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ScenesManagement::Id: {
        return DecodeEventPayloadForScenesManagementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::HepaFilterMonitoring::Id: {
        return DecodeEventPayloadForHEPAFilterMonitoringCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ActivatedCarbonFilterMonitoring::Id: {
        return DecodeEventPayloadForActivatedCarbonFilterMonitoringCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::BooleanStateConfiguration::Id: {
        return DecodeEventPayloadForBooleanStateConfigurationCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ValveConfigurationAndControl::Id: {
        return DecodeEventPayloadForValveConfigurationAndControlCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ElectricalPowerMeasurement::Id: {
        return DecodeEventPayloadForElectricalPowerMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ElectricalEnergyMeasurement::Id: {
        return DecodeEventPayloadForElectricalEnergyMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::WaterHeaterManagement::Id: {
        return DecodeEventPayloadForWaterHeaterManagementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::CommodityPrice::Id: {
        return DecodeEventPayloadForCommodityPriceCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::Messages::Id: {
        return DecodeEventPayloadForMessagesCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::DeviceEnergyManagement::Id: {
        return DecodeEventPayloadForDeviceEnergyManagementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::EnergyEvse::Id: {
        return DecodeEventPayloadForEnergyEVSECluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::EnergyPreference::Id: {
        return DecodeEventPayloadForEnergyPreferenceCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::PowerTopology::Id: {
        return DecodeEventPayloadForPowerTopologyCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::EnergyEvseMode::Id: {
        return DecodeEventPayloadForEnergyEVSEModeCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::WaterHeaterMode::Id: {
        return DecodeEventPayloadForWaterHeaterModeCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::DeviceEnergyManagementMode::Id: {
        return DecodeEventPayloadForDeviceEnergyManagementModeCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ElectricalGridConditions::Id: {
        return DecodeEventPayloadForElectricalGridConditionsCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::DoorLock::Id: {
        return DecodeEventPayloadForDoorLockCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::WindowCovering::Id: {
        return DecodeEventPayloadForWindowCoveringCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ClosureControl::Id: {
        return DecodeEventPayloadForClosureControlCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ClosureDimension::Id: {
        return DecodeEventPayloadForClosureDimensionCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ServiceArea::Id: {
        return DecodeEventPayloadForServiceAreaCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::PumpConfigurationAndControl::Id: {
        return DecodeEventPayloadForPumpConfigurationAndControlCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::Thermostat::Id: {
        return DecodeEventPayloadForThermostatCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::FanControl::Id: {
        return DecodeEventPayloadForFanControlCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ThermostatUserInterfaceConfiguration::Id: {
        return DecodeEventPayloadForThermostatUserInterfaceConfigurationCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ColorControl::Id: {
        return DecodeEventPayloadForColorControlCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::BallastConfiguration::Id: {
        return DecodeEventPayloadForBallastConfigurationCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::IlluminanceMeasurement::Id: {
        return DecodeEventPayloadForIlluminanceMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::TemperatureMeasurement::Id: {
        return DecodeEventPayloadForTemperatureMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::PressureMeasurement::Id: {
        return DecodeEventPayloadForPressureMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::FlowMeasurement::Id: {
        return DecodeEventPayloadForFlowMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::RelativeHumidityMeasurement::Id: {
        return DecodeEventPayloadForRelativeHumidityMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::OccupancySensing::Id: {
        return DecodeEventPayloadForOccupancySensingCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::CarbonMonoxideConcentrationMeasurement::Id: {
        return DecodeEventPayloadForCarbonMonoxideConcentrationMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::CarbonDioxideConcentrationMeasurement::Id: {
        return DecodeEventPayloadForCarbonDioxideConcentrationMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::NitrogenDioxideConcentrationMeasurement::Id: {
        return DecodeEventPayloadForNitrogenDioxideConcentrationMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::OzoneConcentrationMeasurement::Id: {
        return DecodeEventPayloadForOzoneConcentrationMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::Pm25ConcentrationMeasurement::Id: {
        return DecodeEventPayloadForPM25ConcentrationMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::FormaldehydeConcentrationMeasurement::Id: {
        return DecodeEventPayloadForFormaldehydeConcentrationMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::Pm1ConcentrationMeasurement::Id: {
        return DecodeEventPayloadForPM1ConcentrationMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::Pm10ConcentrationMeasurement::Id: {
        return DecodeEventPayloadForPM10ConcentrationMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::TotalVolatileOrganicCompoundsConcentrationMeasurement::Id: {
        return DecodeEventPayloadForTotalVolatileOrganicCompoundsConcentrationMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::RadonConcentrationMeasurement::Id: {
        return DecodeEventPayloadForRadonConcentrationMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::SoilMeasurement::Id: {
        return DecodeEventPayloadForSoilMeasurementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::WiFiNetworkManagement::Id: {
        return DecodeEventPayloadForWiFiNetworkManagementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ThreadBorderRouterManagement::Id: {
        return DecodeEventPayloadForThreadBorderRouterManagementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ThreadNetworkDirectory::Id: {
        return DecodeEventPayloadForThreadNetworkDirectoryCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::WakeOnLan::Id: {
        return DecodeEventPayloadForWakeOnLANCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::Channel::Id: {
        return DecodeEventPayloadForChannelCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::TargetNavigator::Id: {
        return DecodeEventPayloadForTargetNavigatorCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::MediaPlayback::Id: {
        return DecodeEventPayloadForMediaPlaybackCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::MediaInput::Id: {
        return DecodeEventPayloadForMediaInputCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::LowPower::Id: {
        return DecodeEventPayloadForLowPowerCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::KeypadInput::Id: {
        return DecodeEventPayloadForKeypadInputCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ContentLauncher::Id: {
        return DecodeEventPayloadForContentLauncherCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::AudioOutput::Id: {
        return DecodeEventPayloadForAudioOutputCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ApplicationLauncher::Id: {
        return DecodeEventPayloadForApplicationLauncherCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ApplicationBasic::Id: {
        return DecodeEventPayloadForApplicationBasicCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::AccountLogin::Id: {
        return DecodeEventPayloadForAccountLoginCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ContentControl::Id: {
        return DecodeEventPayloadForContentControlCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ContentAppObserver::Id: {
        return DecodeEventPayloadForContentAppObserverCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::ZoneManagement::Id: {
        return DecodeEventPayloadForZoneManagementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::CameraAvStreamManagement::Id: {
        return DecodeEventPayloadForCameraAVStreamManagementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::CameraAvSettingsUserLevelManagement::Id: {
        return DecodeEventPayloadForCameraAVSettingsUserLevelManagementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::WebRTCTransportProvider::Id: {
        return DecodeEventPayloadForWebRTCTransportProviderCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::WebRTCTransportRequestor::Id: {
        return DecodeEventPayloadForWebRTCTransportRequestorCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::PushAvStreamTransport::Id: {
        return DecodeEventPayloadForPushAVStreamTransportCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::Chime::Id: {
        return DecodeEventPayloadForChimeCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::CommodityTariff::Id: {
        return DecodeEventPayloadForCommodityTariffCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::EcosystemInformation::Id: {
        return DecodeEventPayloadForEcosystemInformationCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::CommissionerControl::Id: {
        return DecodeEventPayloadForCommissionerControlCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::JointFabricDatastore::Id: {
        return DecodeEventPayloadForJointFabricDatastoreCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::JointFabricAdministrator::Id: {
        return DecodeEventPayloadForJointFabricAdministratorCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::TlsCertificateManagement::Id: {
        return DecodeEventPayloadForTLSCertificateManagementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::TlsClientManagement::Id: {
        return DecodeEventPayloadForTLSClientManagementCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::MeterIdentification::Id: {
        return DecodeEventPayloadForMeterIdentificationCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::CommodityMetering::Id: {
        return DecodeEventPayloadForCommodityMeteringCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::UnitTesting::Id: {
        return DecodeEventPayloadForUnitTestingCluster(aPath.mEventId, aReader, aError);
    }
    case Clusters::SampleMei::Id: {
        return DecodeEventPayloadForSampleMEICluster(aPath.mEventId, aReader, aError);
    }
    default: {
        break;
    }
    }
    *aError = CHIP_ERROR_IM_MALFORMED_EVENT_PATH_IB;
    return nil;
}
