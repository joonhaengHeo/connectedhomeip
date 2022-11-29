/*
 *
 *    Copyright (c) 2022 Project CHIP Authors
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

//#include <controller/java/CHIPAttributeTLVValueEncoder.h>

//#include <app/data-model/DecodableList.h>
#include <app-common/zap-generated/cluster-objects.h>
#include <app-common/zap-generated/ids/Attributes.h>
#include <app-common/zap-generated/ids/Clusters.h>
#include <app/MessageDef/AttributeDataIBs.h>
#include <app/data-model/Encode.h>
#include <jni.h>
#include <lib/support/CHIPListUtils.h>
#include <lib/support/JniReferences.h>
#include <lib/support/JniTypeWrappers.h>
#include <lib/support/TypeTraits.h>
#include <vector>

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wshorten-64-to-32"

namespace chip {

CHIP_ERROR EncodeAttributeValue(const app::ConcreteAttributePath & aPath, jobject jValue, TLV::TLVWriter & aWriter)
{
    JNIEnv * env   = JniReferences::GetInstance().GetEnvForCurrentThread();
    CHIP_ERROR err = CHIP_NO_ERROR;

    ListFreer listFreer;
    std::vector<Platform::UniquePtr<JniByteArray>> cleanupByteArrays;
    std::vector<Platform::UniquePtr<JniUtfString>> cleanupStrings;

    switch (aPath.mClusterId)
    {
    case app::Clusters::Identify::Id: {
        using namespace app::Clusters::Identify;
        switch (aPath.mAttributeId)
        {
        case Attributes::IdentifyTime::Id: {
            using TypeInfo = Attributes::IdentifyTime::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::Groups::Id: {
        using namespace app::Clusters::Groups;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::Scenes::Id: {
        using namespace app::Clusters::Scenes;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::OnOff::Id: {
        using namespace app::Clusters::OnOff;
        switch (aPath.mAttributeId)
        {
        case Attributes::OnTime::Id: {
            using TypeInfo = Attributes::OnTime::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::OffWaitTime::Id: {
            using TypeInfo = Attributes::OffWaitTime::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::StartUpOnOff::Id: {
            using TypeInfo = Attributes::StartUpOnOff::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::OnOffSwitchConfiguration::Id: {
        using namespace app::Clusters::OnOffSwitchConfiguration;
        switch (aPath.mAttributeId)
        {
        case Attributes::SwitchActions::Id: {
            using TypeInfo = Attributes::SwitchActions::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::LevelControl::Id: {
        using namespace app::Clusters::LevelControl;
        switch (aPath.mAttributeId)
        {
        case Attributes::Options::Id: {
            using TypeInfo = Attributes::Options::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::OnOffTransitionTime::Id: {
            using TypeInfo = Attributes::OnOffTransitionTime::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::OnLevel::Id: {
            using TypeInfo = Attributes::OnLevel::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::OnTransitionTime::Id: {
            using TypeInfo = Attributes::OnTransitionTime::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::OffTransitionTime::Id: {
            using TypeInfo = Attributes::OffTransitionTime::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::DefaultMoveRate::Id: {
            using TypeInfo = Attributes::DefaultMoveRate::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::StartUpCurrentLevel::Id: {
            using TypeInfo = Attributes::StartUpCurrentLevel::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::BinaryInputBasic::Id: {
        using namespace app::Clusters::BinaryInputBasic;
        switch (aPath.mAttributeId)
        {
        case Attributes::OutOfService::Id: {
            using TypeInfo = Attributes::OutOfService::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().BooleanToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::PresentValue::Id: {
            using TypeInfo = Attributes::PresentValue::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().BooleanToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::Descriptor::Id: {
        using namespace app::Clusters::Descriptor;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::Binding::Id: {
        using namespace app::Clusters::Binding;
        switch (aPath.mAttributeId)
        {
        case Attributes::Binding::Id: {
            using TypeInfo = Attributes::Binding::TypeInfo;
            TypeInfo::Type cppValue;
            {
                using ListType_0       = std::remove_reference_t<decltype(cppValue)>;
                using ListMemberType_0 = ListMemberTypeGetter<ListType_0>::Type;
                jint jValueSize;
                chip::JniReferences::GetInstance().GetListSize(jValue, jValueSize);
                if (jValueSize != 0)
                {
                    auto * listHolder_0 = new ListHolder<ListMemberType_0>(jValueSize);
                    listFreer.add(listHolder_0);

                    for (jint i_0 = 0; i_0 < jValueSize; ++i_0)
                    {
                        jobject element_0;
                        chip::JniReferences::GetInstance().GetListItem(jValue, i_0, element_0);
                        jobject element_0_nodeItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "node", "Ljava/util/Optional;",
                                                                          element_0_nodeItem_1);
                        if (element_0_nodeItem_1 != nullptr)
                        {
                            jobject optionalValue_2;
                            chip::JniReferences::GetInstance().GetOptionalValue(element_0_nodeItem_1, optionalValue_2);
                            if (optionalValue_2 != nullptr)
                            {
                                auto & definedValue_2 = listHolder_0->mList[i_0].node.Emplace();
                                definedValue_2        = static_cast<std::remove_reference_t<decltype(definedValue_2)>>(
                                    chip::JniReferences::GetInstance().LongToPrimitive(optionalValue_2));
                            }
                        }
                        jobject element_0_groupItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "group", "Ljava/util/Optional;",
                                                                          element_0_groupItem_1);
                        if (element_0_groupItem_1 != nullptr)
                        {
                            jobject optionalValue_2;
                            chip::JniReferences::GetInstance().GetOptionalValue(element_0_groupItem_1, optionalValue_2);
                            if (optionalValue_2 != nullptr)
                            {
                                auto & definedValue_2 = listHolder_0->mList[i_0].group.Emplace();
                                definedValue_2        = static_cast<std::remove_reference_t<decltype(definedValue_2)>>(
                                    chip::JniReferences::GetInstance().IntegerToPrimitive(optionalValue_2));
                            }
                        }
                        jobject element_0_endpointItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "endpoint", "Ljava/util/Optional;",
                                                                          element_0_endpointItem_1);
                        if (element_0_endpointItem_1 != nullptr)
                        {
                            jobject optionalValue_2;
                            chip::JniReferences::GetInstance().GetOptionalValue(element_0_endpointItem_1, optionalValue_2);
                            if (optionalValue_2 != nullptr)
                            {
                                auto & definedValue_2 = listHolder_0->mList[i_0].endpoint.Emplace();
                                definedValue_2        = static_cast<std::remove_reference_t<decltype(definedValue_2)>>(
                                    chip::JniReferences::GetInstance().IntegerToPrimitive(optionalValue_2));
                            }
                        }
                        jobject element_0_clusterItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "cluster", "Ljava/util/Optional;",
                                                                          element_0_clusterItem_1);
                        if (element_0_clusterItem_1 != nullptr)
                        {
                            jobject optionalValue_2;
                            chip::JniReferences::GetInstance().GetOptionalValue(element_0_clusterItem_1, optionalValue_2);
                            if (optionalValue_2 != nullptr)
                            {
                                auto & definedValue_2 = listHolder_0->mList[i_0].cluster.Emplace();
                                definedValue_2        = static_cast<std::remove_reference_t<decltype(definedValue_2)>>(
                                    chip::JniReferences::GetInstance().LongToPrimitive(optionalValue_2));
                            }
                        }
                        jobject element_0_fabricIndexItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "fabricIndex", "Ljava/lang/Integer;",
                                                                          element_0_fabricIndexItem_1);
                        listHolder_0->mList[i_0].fabricIndex =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].fabricIndex)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_0_fabricIndexItem_1));
                    }
                    cppValue = ListType_0(listHolder_0->mList, jValueSize);
                }
                else
                {
                    cppValue = ListType_0();
                }
            }

            // isArray
            // is_struct

            err =
                app::DataModel::EncodeForWrite(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::AccessControl::Id: {
        using namespace app::Clusters::AccessControl;
        switch (aPath.mAttributeId)
        {
        case Attributes::Acl::Id: {
            using TypeInfo = Attributes::Acl::TypeInfo;
            TypeInfo::Type cppValue;
            {
                using ListType_0       = std::remove_reference_t<decltype(cppValue)>;
                using ListMemberType_0 = ListMemberTypeGetter<ListType_0>::Type;
                jint jValueSize;
                chip::JniReferences::GetInstance().GetListSize(jValue, jValueSize);
                if (jValueSize != 0)
                {
                    auto * listHolder_0 = new ListHolder<ListMemberType_0>(jValueSize);
                    listFreer.add(listHolder_0);

                    for (jint i_0 = 0; i_0 < jValueSize; ++i_0)
                    {
                        jobject element_0;
                        chip::JniReferences::GetInstance().GetListItem(jValue, i_0, element_0);
                        jobject element_0_privilegeItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "privilege", "Ljava/lang/Integer;",
                                                                          element_0_privilegeItem_1);
                        listHolder_0->mList[i_0].privilege =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].privilege)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_0_privilegeItem_1));
                        jobject element_0_authModeItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "authMode", "Ljava/lang/Integer;",
                                                                          element_0_authModeItem_1);
                        listHolder_0->mList[i_0].authMode =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].authMode)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_0_authModeItem_1));
                        jobject element_0_subjectsItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "subjects", "Ljava/util/ArrayList;",
                                                                          element_0_subjectsItem_1);
                        if (element_0_subjectsItem_1 == nullptr)
                        {
                            listHolder_0->mList[i_0].subjects.SetNull();
                        }
                        else
                        {
                            auto & nonNullValue_2 = listHolder_0->mList[i_0].subjects.SetNonNull();
                            {
                                using ListType_3       = std::remove_reference_t<decltype(nonNullValue_2)>;
                                using ListMemberType_3 = ListMemberTypeGetter<ListType_3>::Type;
                                jint element_0_subjectsItem_1Size;
                                chip::JniReferences::GetInstance().GetListSize(element_0_subjectsItem_1,
                                                                               element_0_subjectsItem_1Size);
                                if (element_0_subjectsItem_1Size != 0)
                                {
                                    auto * listHolder_3 = new ListHolder<ListMemberType_3>(element_0_subjectsItem_1Size);
                                    listFreer.add(listHolder_3);

                                    for (jint i_3 = 0; i_3 < element_0_subjectsItem_1Size; ++i_3)
                                    {
                                        jobject element_3;
                                        chip::JniReferences::GetInstance().GetListItem(element_0_subjectsItem_1, i_3, element_3);
                                        listHolder_3->mList[i_3] =
                                            static_cast<std::remove_reference_t<decltype(listHolder_3->mList[i_3])>>(
                                                chip::JniReferences::GetInstance().LongToPrimitive(element_3));
                                    }
                                    nonNullValue_2 = ListType_3(listHolder_3->mList, element_0_subjectsItem_1Size);
                                }
                                else
                                {
                                    nonNullValue_2 = ListType_3();
                                }
                            }
                        }
                        jobject element_0_targetsItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "targets", "Ljava/util/ArrayList;",
                                                                          element_0_targetsItem_1);
                        if (element_0_targetsItem_1 == nullptr)
                        {
                            listHolder_0->mList[i_0].targets.SetNull();
                        }
                        else
                        {
                            auto & nonNullValue_2 = listHolder_0->mList[i_0].targets.SetNonNull();
                            {
                                using ListType_3       = std::remove_reference_t<decltype(nonNullValue_2)>;
                                using ListMemberType_3 = ListMemberTypeGetter<ListType_3>::Type;
                                jint element_0_targetsItem_1Size;
                                chip::JniReferences::GetInstance().GetListSize(element_0_targetsItem_1,
                                                                               element_0_targetsItem_1Size);
                                if (element_0_targetsItem_1Size != 0)
                                {
                                    auto * listHolder_3 = new ListHolder<ListMemberType_3>(element_0_targetsItem_1Size);
                                    listFreer.add(listHolder_3);

                                    for (jint i_3 = 0; i_3 < element_0_targetsItem_1Size; ++i_3)
                                    {
                                        jobject element_3;
                                        chip::JniReferences::GetInstance().GetListItem(element_0_targetsItem_1, i_3, element_3);
                                        jobject element_3_clusterItem_4;
                                        chip::JniReferences::GetInstance().GetObjectField(element_3, "cluster", "Ljava/lang/Long;",
                                                                                          element_3_clusterItem_4);
                                        if (element_3_clusterItem_4 == nullptr)
                                        {
                                            listHolder_3->mList[i_3].cluster.SetNull();
                                        }
                                        else
                                        {
                                            auto & nonNullValue_5 = listHolder_3->mList[i_3].cluster.SetNonNull();
                                            nonNullValue_5        = static_cast<std::remove_reference_t<decltype(nonNullValue_5)>>(
                                                chip::JniReferences::GetInstance().LongToPrimitive(element_3_clusterItem_4));
                                        }
                                        jobject element_3_endpointItem_4;
                                        chip::JniReferences::GetInstance().GetObjectField(
                                            element_3, "endpoint", "Ljava/lang/Integer;", element_3_endpointItem_4);
                                        if (element_3_endpointItem_4 == nullptr)
                                        {
                                            listHolder_3->mList[i_3].endpoint.SetNull();
                                        }
                                        else
                                        {
                                            auto & nonNullValue_5 = listHolder_3->mList[i_3].endpoint.SetNonNull();
                                            nonNullValue_5        = static_cast<std::remove_reference_t<decltype(nonNullValue_5)>>(
                                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_3_endpointItem_4));
                                        }
                                        jobject element_3_deviceTypeItem_4;
                                        chip::JniReferences::GetInstance().GetObjectField(
                                            element_3, "deviceType", "Ljava/lang/Long;", element_3_deviceTypeItem_4);
                                        if (element_3_deviceTypeItem_4 == nullptr)
                                        {
                                            listHolder_3->mList[i_3].deviceType.SetNull();
                                        }
                                        else
                                        {
                                            auto & nonNullValue_5 = listHolder_3->mList[i_3].deviceType.SetNonNull();
                                            nonNullValue_5        = static_cast<std::remove_reference_t<decltype(nonNullValue_5)>>(
                                                chip::JniReferences::GetInstance().LongToPrimitive(element_3_deviceTypeItem_4));
                                        }
                                    }
                                    nonNullValue_2 = ListType_3(listHolder_3->mList, element_0_targetsItem_1Size);
                                }
                                else
                                {
                                    nonNullValue_2 = ListType_3();
                                }
                            }
                        }
                        jobject element_0_fabricIndexItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "fabricIndex", "Ljava/lang/Integer;",
                                                                          element_0_fabricIndexItem_1);
                        listHolder_0->mList[i_0].fabricIndex =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].fabricIndex)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_0_fabricIndexItem_1));
                    }
                    cppValue = ListType_0(listHolder_0->mList, jValueSize);
                }
                else
                {
                    cppValue = ListType_0();
                }
            }

            // zcl struct
            // struct_contains_array
            // zcl struct
            // isArray
            // is_struct

            err =
                app::DataModel::EncodeForWrite(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Extension::Id: {
            using TypeInfo = Attributes::Extension::TypeInfo;
            TypeInfo::Type cppValue;
            {
                using ListType_0       = std::remove_reference_t<decltype(cppValue)>;
                using ListMemberType_0 = ListMemberTypeGetter<ListType_0>::Type;
                jint jValueSize;
                chip::JniReferences::GetInstance().GetListSize(jValue, jValueSize);
                if (jValueSize != 0)
                {
                    auto * listHolder_0 = new ListHolder<ListMemberType_0>(jValueSize);
                    listFreer.add(listHolder_0);

                    for (jint i_0 = 0; i_0 < jValueSize; ++i_0)
                    {
                        jobject element_0;
                        chip::JniReferences::GetInstance().GetListItem(jValue, i_0, element_0);
                        jobject element_0_dataItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "data", "[B", element_0_dataItem_1);
                        cleanupByteArrays.push_back(
                            chip::Platform::MakeUnique<chip::JniByteArray>(env, static_cast<jbyteArray>(element_0_dataItem_1)));
                        listHolder_0->mList[i_0].data = cleanupByteArrays.back()->byteSpan();
                        jobject element_0_fabricIndexItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "fabricIndex", "Ljava/lang/Integer;",
                                                                          element_0_fabricIndexItem_1);
                        listHolder_0->mList[i_0].fabricIndex =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].fabricIndex)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_0_fabricIndexItem_1));
                    }
                    cppValue = ListType_0(listHolder_0->mList, jValueSize);
                }
                else
                {
                    cppValue = ListType_0();
                }
            }

            // zcl struct
            // fabric isFabricScoped
            // isArray
            // is_struct

            err =
                app::DataModel::EncodeForWrite(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::Actions::Id: {
        using namespace app::Clusters::Actions;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::Basic::Id: {
        using namespace app::Clusters::Basic;
        switch (aPath.mAttributeId)
        {
        case Attributes::NodeLabel::Id: {
            using TypeInfo = Attributes::NodeLabel::TypeInfo;
            TypeInfo::Type cppValue;
            cleanupStrings.push_back(chip::Platform::MakeUnique<chip::JniUtfString>(env, static_cast<jstring>(jValue)));
            cppValue = cleanupStrings.back()->charSpan();

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Location::Id: {
            using TypeInfo = Attributes::Location::TypeInfo;
            TypeInfo::Type cppValue;
            cleanupStrings.push_back(chip::Platform::MakeUnique<chip::JniUtfString>(env, static_cast<jstring>(jValue)));
            cppValue = cleanupStrings.back()->charSpan();

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::LocalConfigDisabled::Id: {
            using TypeInfo = Attributes::LocalConfigDisabled::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().BooleanToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::OtaSoftwareUpdateProvider::Id: {
        using namespace app::Clusters::OtaSoftwareUpdateProvider;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::OtaSoftwareUpdateRequestor::Id: {
        using namespace app::Clusters::OtaSoftwareUpdateRequestor;
        switch (aPath.mAttributeId)
        {
        case Attributes::DefaultOtaProviders::Id: {
            using TypeInfo = Attributes::DefaultOtaProviders::TypeInfo;
            TypeInfo::Type cppValue;
            {
                using ListType_0       = std::remove_reference_t<decltype(cppValue)>;
                using ListMemberType_0 = ListMemberTypeGetter<ListType_0>::Type;
                jint jValueSize;
                chip::JniReferences::GetInstance().GetListSize(jValue, jValueSize);
                if (jValueSize != 0)
                {
                    auto * listHolder_0 = new ListHolder<ListMemberType_0>(jValueSize);
                    listFreer.add(listHolder_0);

                    for (jint i_0 = 0; i_0 < jValueSize; ++i_0)
                    {
                        jobject element_0;
                        chip::JniReferences::GetInstance().GetListItem(jValue, i_0, element_0);
                        jobject element_0_providerNodeIDItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "providerNodeID", "Ljava/lang/Long;",
                                                                          element_0_providerNodeIDItem_1);
                        listHolder_0->mList[i_0].providerNodeID =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].providerNodeID)>>(
                                chip::JniReferences::GetInstance().LongToPrimitive(element_0_providerNodeIDItem_1));
                        jobject element_0_endpointItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "endpoint", "Ljava/lang/Integer;",
                                                                          element_0_endpointItem_1);
                        listHolder_0->mList[i_0].endpoint =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].endpoint)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_0_endpointItem_1));
                        jobject element_0_fabricIndexItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "fabricIndex", "Ljava/lang/Integer;",
                                                                          element_0_fabricIndexItem_1);
                        listHolder_0->mList[i_0].fabricIndex =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].fabricIndex)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_0_fabricIndexItem_1));
                    }
                    cppValue = ListType_0(listHolder_0->mList, jValueSize);
                }
                else
                {
                    cppValue = ListType_0();
                }
            }

            // isArray
            // is_struct

            err =
                app::DataModel::EncodeForWrite(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::LocalizationConfiguration::Id: {
        using namespace app::Clusters::LocalizationConfiguration;
        switch (aPath.mAttributeId)
        {
        case Attributes::ActiveLocale::Id: {
            using TypeInfo = Attributes::ActiveLocale::TypeInfo;
            TypeInfo::Type cppValue;
            cleanupStrings.push_back(chip::Platform::MakeUnique<chip::JniUtfString>(env, static_cast<jstring>(jValue)));
            cppValue = cleanupStrings.back()->charSpan();

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::TimeFormatLocalization::Id: {
        using namespace app::Clusters::TimeFormatLocalization;
        switch (aPath.mAttributeId)
        {
        case Attributes::HourFormat::Id: {
            using TypeInfo = Attributes::HourFormat::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ActiveCalendarType::Id: {
            using TypeInfo = Attributes::ActiveCalendarType::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::UnitLocalization::Id: {
        using namespace app::Clusters::UnitLocalization;
        switch (aPath.mAttributeId)
        {
        case Attributes::TemperatureUnit::Id: {
            using TypeInfo = Attributes::TemperatureUnit::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::PowerSourceConfiguration::Id: {
        using namespace app::Clusters::PowerSourceConfiguration;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::PowerSource::Id: {
        using namespace app::Clusters::PowerSource;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::GeneralCommissioning::Id: {
        using namespace app::Clusters::GeneralCommissioning;
        switch (aPath.mAttributeId)
        {
        case Attributes::Breadcrumb::Id: {
            using TypeInfo = Attributes::Breadcrumb::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::NetworkCommissioning::Id: {
        using namespace app::Clusters::NetworkCommissioning;
        switch (aPath.mAttributeId)
        {
        case Attributes::InterfaceEnabled::Id: {
            using TypeInfo = Attributes::InterfaceEnabled::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().BooleanToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::DiagnosticLogs::Id: {
        using namespace app::Clusters::DiagnosticLogs;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::GeneralDiagnostics::Id: {
        using namespace app::Clusters::GeneralDiagnostics;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::SoftwareDiagnostics::Id: {
        using namespace app::Clusters::SoftwareDiagnostics;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::ThreadNetworkDiagnostics::Id: {
        using namespace app::Clusters::ThreadNetworkDiagnostics;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::WiFiNetworkDiagnostics::Id: {
        using namespace app::Clusters::WiFiNetworkDiagnostics;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::EthernetNetworkDiagnostics::Id: {
        using namespace app::Clusters::EthernetNetworkDiagnostics;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::BridgedDeviceBasic::Id: {
        using namespace app::Clusters::BridgedDeviceBasic;
        switch (aPath.mAttributeId)
        {
        case Attributes::NodeLabel::Id: {
            using TypeInfo = Attributes::NodeLabel::TypeInfo;
            TypeInfo::Type cppValue;
            cleanupStrings.push_back(chip::Platform::MakeUnique<chip::JniUtfString>(env, static_cast<jstring>(jValue)));
            cppValue = cleanupStrings.back()->charSpan();

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::Switch::Id: {
        using namespace app::Clusters::Switch;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::AdministratorCommissioning::Id: {
        using namespace app::Clusters::AdministratorCommissioning;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::OperationalCredentials::Id: {
        using namespace app::Clusters::OperationalCredentials;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::GroupKeyManagement::Id: {
        using namespace app::Clusters::GroupKeyManagement;
        switch (aPath.mAttributeId)
        {
        case Attributes::GroupKeyMap::Id: {
            using TypeInfo = Attributes::GroupKeyMap::TypeInfo;
            TypeInfo::Type cppValue;
            {
                using ListType_0       = std::remove_reference_t<decltype(cppValue)>;
                using ListMemberType_0 = ListMemberTypeGetter<ListType_0>::Type;
                jint jValueSize;
                chip::JniReferences::GetInstance().GetListSize(jValue, jValueSize);
                if (jValueSize != 0)
                {
                    auto * listHolder_0 = new ListHolder<ListMemberType_0>(jValueSize);
                    listFreer.add(listHolder_0);

                    for (jint i_0 = 0; i_0 < jValueSize; ++i_0)
                    {
                        jobject element_0;
                        chip::JniReferences::GetInstance().GetListItem(jValue, i_0, element_0);
                        jobject element_0_groupIdItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "groupId", "Ljava/lang/Integer;",
                                                                          element_0_groupIdItem_1);
                        listHolder_0->mList[i_0].groupId =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].groupId)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_0_groupIdItem_1));
                        jobject element_0_groupKeySetIDItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "groupKeySetID", "Ljava/lang/Integer;",
                                                                          element_0_groupKeySetIDItem_1);
                        listHolder_0->mList[i_0].groupKeySetID =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].groupKeySetID)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_0_groupKeySetIDItem_1));
                        jobject element_0_fabricIndexItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "fabricIndex", "Ljava/lang/Integer;",
                                                                          element_0_fabricIndexItem_1);
                        listHolder_0->mList[i_0].fabricIndex =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].fabricIndex)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_0_fabricIndexItem_1));
                    }
                    cppValue = ListType_0(listHolder_0->mList, jValueSize);
                }
                else
                {
                    cppValue = ListType_0();
                }
            }

            // zcl struct
            // isArray
            // is_struct

            err =
                app::DataModel::EncodeForWrite(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::FixedLabel::Id: {
        using namespace app::Clusters::FixedLabel;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::UserLabel::Id: {
        using namespace app::Clusters::UserLabel;
        switch (aPath.mAttributeId)
        {
        case Attributes::LabelList::Id: {
            using TypeInfo = Attributes::LabelList::TypeInfo;
            TypeInfo::Type cppValue;
            {
                using ListType_0       = std::remove_reference_t<decltype(cppValue)>;
                using ListMemberType_0 = ListMemberTypeGetter<ListType_0>::Type;
                jint jValueSize;
                chip::JniReferences::GetInstance().GetListSize(jValue, jValueSize);
                if (jValueSize != 0)
                {
                    auto * listHolder_0 = new ListHolder<ListMemberType_0>(jValueSize);
                    listFreer.add(listHolder_0);

                    for (jint i_0 = 0; i_0 < jValueSize; ++i_0)
                    {
                        jobject element_0;
                        chip::JniReferences::GetInstance().GetListItem(jValue, i_0, element_0);
                        jobject element_0_labelItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "label", "Ljava/lang/String;",
                                                                          element_0_labelItem_1);
                        cleanupStrings.push_back(
                            chip::Platform::MakeUnique<chip::JniUtfString>(env, static_cast<jstring>(element_0_labelItem_1)));
                        listHolder_0->mList[i_0].label = cleanupStrings.back()->charSpan();
                        jobject element_0_valueItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "value", "Ljava/lang/String;",
                                                                          element_0_valueItem_1);
                        cleanupStrings.push_back(
                            chip::Platform::MakeUnique<chip::JniUtfString>(env, static_cast<jstring>(element_0_valueItem_1)));
                        listHolder_0->mList[i_0].value = cleanupStrings.back()->charSpan();
                    }
                    cppValue = ListType_0(listHolder_0->mList, jValueSize);
                }
                else
                {
                    cppValue = ListType_0();
                }
            }

            // zcl struct
            // zcl struct
            // zcl struct
            // zcl struct
            // isArray
            // is_struct

            err =
                app::DataModel::EncodeForWrite(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::BooleanState::Id: {
        using namespace app::Clusters::BooleanState;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::ModeSelect::Id: {
        using namespace app::Clusters::ModeSelect;
        switch (aPath.mAttributeId)
        {
        case Attributes::StartUpMode::Id: {
            using TypeInfo = Attributes::StartUpMode::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::OnMode::Id: {
            using TypeInfo = Attributes::OnMode::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::DoorLock::Id: {
        using namespace app::Clusters::DoorLock;
        switch (aPath.mAttributeId)
        {
        case Attributes::Language::Id: {
            using TypeInfo = Attributes::Language::TypeInfo;
            TypeInfo::Type cppValue;
            cleanupStrings.push_back(chip::Platform::MakeUnique<chip::JniUtfString>(env, static_cast<jstring>(jValue)));
            cppValue = cleanupStrings.back()->charSpan();

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::AutoRelockTime::Id: {
            using TypeInfo = Attributes::AutoRelockTime::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::SoundVolume::Id: {
            using TypeInfo = Attributes::SoundVolume::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::OperatingMode::Id: {
            using TypeInfo = Attributes::OperatingMode::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::EnableOneTouchLocking::Id: {
            using TypeInfo = Attributes::EnableOneTouchLocking::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().BooleanToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::EnablePrivacyModeButton::Id: {
            using TypeInfo = Attributes::EnablePrivacyModeButton::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().BooleanToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::WrongCodeEntryLimit::Id: {
            using TypeInfo = Attributes::WrongCodeEntryLimit::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::UserCodeTemporaryDisableTime::Id: {
            using TypeInfo = Attributes::UserCodeTemporaryDisableTime::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::RequirePINforRemoteOperation::Id: {
            using TypeInfo = Attributes::RequirePINforRemoteOperation::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().BooleanToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::WindowCovering::Id: {
        using namespace app::Clusters::WindowCovering;
        switch (aPath.mAttributeId)
        {
        case Attributes::Mode::Id: {
            using TypeInfo = Attributes::Mode::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::BarrierControl::Id: {
        using namespace app::Clusters::BarrierControl;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::PumpConfigurationAndControl::Id: {
        using namespace app::Clusters::PumpConfigurationAndControl;
        switch (aPath.mAttributeId)
        {
        case Attributes::LifetimeRunningHours::Id: {
            using TypeInfo = Attributes::LifetimeRunningHours::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::LifetimeEnergyConsumed::Id: {
            using TypeInfo = Attributes::LifetimeEnergyConsumed::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::OperationMode::Id: {
            using TypeInfo = Attributes::OperationMode::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ControlMode::Id: {
            using TypeInfo = Attributes::ControlMode::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::Thermostat::Id: {
        using namespace app::Clusters::Thermostat;
        switch (aPath.mAttributeId)
        {
        case Attributes::OccupiedCoolingSetpoint::Id: {
            using TypeInfo = Attributes::OccupiedCoolingSetpoint::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::OccupiedHeatingSetpoint::Id: {
            using TypeInfo = Attributes::OccupiedHeatingSetpoint::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::MinHeatSetpointLimit::Id: {
            using TypeInfo = Attributes::MinHeatSetpointLimit::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::MaxHeatSetpointLimit::Id: {
            using TypeInfo = Attributes::MaxHeatSetpointLimit::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::MinCoolSetpointLimit::Id: {
            using TypeInfo = Attributes::MinCoolSetpointLimit::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::MaxCoolSetpointLimit::Id: {
            using TypeInfo = Attributes::MaxCoolSetpointLimit::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::MinSetpointDeadBand::Id: {
            using TypeInfo = Attributes::MinSetpointDeadBand::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ControlSequenceOfOperation::Id: {
            using TypeInfo = Attributes::ControlSequenceOfOperation::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::SystemMode::Id: {
            using TypeInfo = Attributes::SystemMode::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::FanControl::Id: {
        using namespace app::Clusters::FanControl;
        switch (aPath.mAttributeId)
        {
        case Attributes::FanMode::Id: {
            using TypeInfo = Attributes::FanMode::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::FanModeSequence::Id: {
            using TypeInfo = Attributes::FanModeSequence::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::PercentSetting::Id: {
            using TypeInfo = Attributes::PercentSetting::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::SpeedSetting::Id: {
            using TypeInfo = Attributes::SpeedSetting::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::RockSetting::Id: {
            using TypeInfo = Attributes::RockSetting::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::WindSetting::Id: {
            using TypeInfo = Attributes::WindSetting::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::ThermostatUserInterfaceConfiguration::Id: {
        using namespace app::Clusters::ThermostatUserInterfaceConfiguration;
        switch (aPath.mAttributeId)
        {
        case Attributes::TemperatureDisplayMode::Id: {
            using TypeInfo = Attributes::TemperatureDisplayMode::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::KeypadLockout::Id: {
            using TypeInfo = Attributes::KeypadLockout::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ScheduleProgrammingVisibility::Id: {
            using TypeInfo = Attributes::ScheduleProgrammingVisibility::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::ColorControl::Id: {
        using namespace app::Clusters::ColorControl;
        switch (aPath.mAttributeId)
        {
        case Attributes::Options::Id: {
            using TypeInfo = Attributes::Options::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::WhitePointX::Id: {
            using TypeInfo = Attributes::WhitePointX::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::WhitePointY::Id: {
            using TypeInfo = Attributes::WhitePointY::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ColorPointRX::Id: {
            using TypeInfo = Attributes::ColorPointRX::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ColorPointRY::Id: {
            using TypeInfo = Attributes::ColorPointRY::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ColorPointRIntensity::Id: {
            using TypeInfo = Attributes::ColorPointRIntensity::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ColorPointGX::Id: {
            using TypeInfo = Attributes::ColorPointGX::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ColorPointGY::Id: {
            using TypeInfo = Attributes::ColorPointGY::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ColorPointGIntensity::Id: {
            using TypeInfo = Attributes::ColorPointGIntensity::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ColorPointBX::Id: {
            using TypeInfo = Attributes::ColorPointBX::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ColorPointBY::Id: {
            using TypeInfo = Attributes::ColorPointBY::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ColorPointBIntensity::Id: {
            using TypeInfo = Attributes::ColorPointBIntensity::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::StartUpColorTemperatureMireds::Id: {
            using TypeInfo = Attributes::StartUpColorTemperatureMireds::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::BallastConfiguration::Id: {
        using namespace app::Clusters::BallastConfiguration;
        switch (aPath.mAttributeId)
        {
        case Attributes::MinLevel::Id: {
            using TypeInfo = Attributes::MinLevel::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::MaxLevel::Id: {
            using TypeInfo = Attributes::MaxLevel::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::IntrinsicBalanceFactor::Id: {
            using TypeInfo = Attributes::IntrinsicBalanceFactor::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::BallastFactorAdjustment::Id: {
            using TypeInfo = Attributes::BallastFactorAdjustment::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::LampType::Id: {
            using TypeInfo = Attributes::LampType::TypeInfo;
            TypeInfo::Type cppValue;
            cleanupStrings.push_back(chip::Platform::MakeUnique<chip::JniUtfString>(env, static_cast<jstring>(jValue)));
            cppValue = cleanupStrings.back()->charSpan();

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::LampManufacturer::Id: {
            using TypeInfo = Attributes::LampManufacturer::TypeInfo;
            TypeInfo::Type cppValue;
            cleanupStrings.push_back(chip::Platform::MakeUnique<chip::JniUtfString>(env, static_cast<jstring>(jValue)));
            cppValue = cleanupStrings.back()->charSpan();

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::LampRatedHours::Id: {
            using TypeInfo = Attributes::LampRatedHours::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::LampBurnHours::Id: {
            using TypeInfo = Attributes::LampBurnHours::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::LampAlarmMode::Id: {
            using TypeInfo = Attributes::LampAlarmMode::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::LampBurnHoursTripPoint::Id: {
            using TypeInfo = Attributes::LampBurnHoursTripPoint::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::IlluminanceMeasurement::Id: {
        using namespace app::Clusters::IlluminanceMeasurement;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::TemperatureMeasurement::Id: {
        using namespace app::Clusters::TemperatureMeasurement;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::PressureMeasurement::Id: {
        using namespace app::Clusters::PressureMeasurement;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::FlowMeasurement::Id: {
        using namespace app::Clusters::FlowMeasurement;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::RelativeHumidityMeasurement::Id: {
        using namespace app::Clusters::RelativeHumidityMeasurement;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::OccupancySensing::Id: {
        using namespace app::Clusters::OccupancySensing;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::WakeOnLan::Id: {
        using namespace app::Clusters::WakeOnLan;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::Channel::Id: {
        using namespace app::Clusters::Channel;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::TargetNavigator::Id: {
        using namespace app::Clusters::TargetNavigator;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::MediaPlayback::Id: {
        using namespace app::Clusters::MediaPlayback;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::MediaInput::Id: {
        using namespace app::Clusters::MediaInput;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::LowPower::Id: {
        using namespace app::Clusters::LowPower;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::KeypadInput::Id: {
        using namespace app::Clusters::KeypadInput;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::ContentLauncher::Id: {
        using namespace app::Clusters::ContentLauncher;
        switch (aPath.mAttributeId)
        {
        case Attributes::SupportedStreamingProtocols::Id: {
            using TypeInfo = Attributes::SupportedStreamingProtocols::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::AudioOutput::Id: {
        using namespace app::Clusters::AudioOutput;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::ApplicationLauncher::Id: {
        using namespace app::Clusters::ApplicationLauncher;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::ApplicationBasic::Id: {
        using namespace app::Clusters::ApplicationBasic;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::AccountLogin::Id: {
        using namespace app::Clusters::AccountLogin;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::ElectricalMeasurement::Id: {
        using namespace app::Clusters::ElectricalMeasurement;
        switch (aPath.mAttributeId)
        {
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    case app::Clusters::UnitTesting::Id: {
        using namespace app::Clusters::UnitTesting;
        switch (aPath.mAttributeId)
        {
        case Attributes::Boolean::Id: {
            using TypeInfo = Attributes::Boolean::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().BooleanToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Bitmap8::Id: {
            using TypeInfo = Attributes::Bitmap8::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Bitmap16::Id: {
            using TypeInfo = Attributes::Bitmap16::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Bitmap32::Id: {
            using TypeInfo = Attributes::Bitmap32::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Bitmap64::Id: {
            using TypeInfo = Attributes::Bitmap64::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Int8u::Id: {
            using TypeInfo = Attributes::Int8u::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Int16u::Id: {
            using TypeInfo = Attributes::Int16u::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Int24u::Id: {
            using TypeInfo = Attributes::Int24u::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Int32u::Id: {
            using TypeInfo = Attributes::Int32u::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Int40u::Id: {
            using TypeInfo = Attributes::Int40u::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Int48u::Id: {
            using TypeInfo = Attributes::Int48u::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Int56u::Id: {
            using TypeInfo = Attributes::Int56u::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Int64u::Id: {
            using TypeInfo = Attributes::Int64u::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Int8s::Id: {
            using TypeInfo = Attributes::Int8s::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Int16s::Id: {
            using TypeInfo = Attributes::Int16s::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Int24s::Id: {
            using TypeInfo = Attributes::Int24s::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Int32s::Id: {
            using TypeInfo = Attributes::Int32s::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Int40s::Id: {
            using TypeInfo = Attributes::Int40s::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Int48s::Id: {
            using TypeInfo = Attributes::Int48s::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Int56s::Id: {
            using TypeInfo = Attributes::Int56s::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Int64s::Id: {
            using TypeInfo = Attributes::Int64s::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Enum8::Id: {
            using TypeInfo = Attributes::Enum8::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Enum16::Id: {
            using TypeInfo = Attributes::Enum16::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::FloatSingle::Id: {
            using TypeInfo = Attributes::FloatSingle::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().FloatToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::FloatDouble::Id: {
            using TypeInfo = Attributes::FloatDouble::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().DoubleToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::OctetString::Id: {
            using TypeInfo = Attributes::OctetString::TypeInfo;
            TypeInfo::Type cppValue;
            cleanupByteArrays.push_back(chip::Platform::MakeUnique<chip::JniByteArray>(env, static_cast<jbyteArray>(jValue)));
            cppValue = cleanupByteArrays.back()->byteSpan();

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ListInt8u::Id: {
            using TypeInfo = Attributes::ListInt8u::TypeInfo;
            TypeInfo::Type cppValue;
            {
                using ListType_0       = std::remove_reference_t<decltype(cppValue)>;
                using ListMemberType_0 = ListMemberTypeGetter<ListType_0>::Type;
                jint jValueSize;
                chip::JniReferences::GetInstance().GetListSize(jValue, jValueSize);
                if (jValueSize != 0)
                {
                    auto * listHolder_0 = new ListHolder<ListMemberType_0>(jValueSize);
                    listFreer.add(listHolder_0);

                    for (jint i_0 = 0; i_0 < jValueSize; ++i_0)
                    {
                        jobject element_0;
                        chip::JniReferences::GetInstance().GetListItem(jValue, i_0, element_0);
                        listHolder_0->mList[i_0] = static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0])>>(
                            chip::JniReferences::GetInstance().IntegerToPrimitive(element_0));
                    }
                    cppValue = ListType_0(listHolder_0->mList, jValueSize);
                }
                else
                {
                    cppValue = ListType_0();
                }
            }

            // isArray

            err =
                app::DataModel::EncodeForWrite(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ListOctetString::Id: {
            using TypeInfo = Attributes::ListOctetString::TypeInfo;
            TypeInfo::Type cppValue;
            {
                using ListType_0       = std::remove_reference_t<decltype(cppValue)>;
                using ListMemberType_0 = ListMemberTypeGetter<ListType_0>::Type;
                jint jValueSize;
                chip::JniReferences::GetInstance().GetListSize(jValue, jValueSize);
                if (jValueSize != 0)
                {
                    auto * listHolder_0 = new ListHolder<ListMemberType_0>(jValueSize);
                    listFreer.add(listHolder_0);

                    for (jint i_0 = 0; i_0 < jValueSize; ++i_0)
                    {
                        jobject element_0;
                        chip::JniReferences::GetInstance().GetListItem(jValue, i_0, element_0);
                        cleanupByteArrays.push_back(
                            chip::Platform::MakeUnique<chip::JniByteArray>(env, static_cast<jbyteArray>(element_0)));
                        listHolder_0->mList[i_0] = cleanupByteArrays.back()->byteSpan();
                    }
                    cppValue = ListType_0(listHolder_0->mList, jValueSize);
                }
                else
                {
                    cppValue = ListType_0();
                }
            }

            // isArray

            err =
                app::DataModel::EncodeForWrite(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ListStructOctetString::Id: {
            using TypeInfo = Attributes::ListStructOctetString::TypeInfo;
            TypeInfo::Type cppValue;
            {
                using ListType_0       = std::remove_reference_t<decltype(cppValue)>;
                using ListMemberType_0 = ListMemberTypeGetter<ListType_0>::Type;
                jint jValueSize;
                chip::JniReferences::GetInstance().GetListSize(jValue, jValueSize);
                if (jValueSize != 0)
                {
                    auto * listHolder_0 = new ListHolder<ListMemberType_0>(jValueSize);
                    listFreer.add(listHolder_0);

                    for (jint i_0 = 0; i_0 < jValueSize; ++i_0)
                    {
                        jobject element_0;
                        chip::JniReferences::GetInstance().GetListItem(jValue, i_0, element_0);
                        jobject element_0_member1Item_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "member1", "Ljava/lang/Long;",
                                                                          element_0_member1Item_1);
                        listHolder_0->mList[i_0].member1 =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].member1)>>(
                                chip::JniReferences::GetInstance().LongToPrimitive(element_0_member1Item_1));
                        jobject element_0_member2Item_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "member2", "[B", element_0_member2Item_1);
                        cleanupByteArrays.push_back(
                            chip::Platform::MakeUnique<chip::JniByteArray>(env, static_cast<jbyteArray>(element_0_member2Item_1)));
                        listHolder_0->mList[i_0].member2 = cleanupByteArrays.back()->byteSpan();
                    }
                    cppValue = ListType_0(listHolder_0->mList, jValueSize);
                }
                else
                {
                    cppValue = ListType_0();
                }
            }

            // isArray
            // is_struct

            err =
                app::DataModel::EncodeForWrite(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::LongOctetString::Id: {
            using TypeInfo = Attributes::LongOctetString::TypeInfo;
            TypeInfo::Type cppValue;
            cleanupByteArrays.push_back(chip::Platform::MakeUnique<chip::JniByteArray>(env, static_cast<jbyteArray>(jValue)));
            cppValue = cleanupByteArrays.back()->byteSpan();

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::CharString::Id: {
            using TypeInfo = Attributes::CharString::TypeInfo;
            TypeInfo::Type cppValue;
            cleanupStrings.push_back(chip::Platform::MakeUnique<chip::JniUtfString>(env, static_cast<jstring>(jValue)));
            cppValue = cleanupStrings.back()->charSpan();

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::LongCharString::Id: {
            using TypeInfo = Attributes::LongCharString::TypeInfo;
            TypeInfo::Type cppValue;
            cleanupStrings.push_back(chip::Platform::MakeUnique<chip::JniUtfString>(env, static_cast<jstring>(jValue)));
            cppValue = cleanupStrings.back()->charSpan();

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::EpochUs::Id: {
            using TypeInfo = Attributes::EpochUs::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::EpochS::Id: {
            using TypeInfo = Attributes::EpochS::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().LongToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::VendorId::Id: {
            using TypeInfo = Attributes::VendorId::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ListNullablesAndOptionalsStruct::Id: {
            using TypeInfo = Attributes::ListNullablesAndOptionalsStruct::TypeInfo;
            TypeInfo::Type cppValue;
            {
                using ListType_0       = std::remove_reference_t<decltype(cppValue)>;
                using ListMemberType_0 = ListMemberTypeGetter<ListType_0>::Type;
                jint jValueSize;
                chip::JniReferences::GetInstance().GetListSize(jValue, jValueSize);
                if (jValueSize != 0)
                {
                    auto * listHolder_0 = new ListHolder<ListMemberType_0>(jValueSize);
                    listFreer.add(listHolder_0);

                    for (jint i_0 = 0; i_0 < jValueSize; ++i_0)
                    {
                        jobject element_0;
                        chip::JniReferences::GetInstance().GetListItem(jValue, i_0, element_0);
                        jobject element_0_nullableIntItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "nullableInt", "Ljava/lang/Integer;",
                                                                          element_0_nullableIntItem_1);
                        if (element_0_nullableIntItem_1 == nullptr)
                        {
                            listHolder_0->mList[i_0].nullableInt.SetNull();
                        }
                        else
                        {
                            auto & nonNullValue_2 = listHolder_0->mList[i_0].nullableInt.SetNonNull();
                            nonNullValue_2        = static_cast<std::remove_reference_t<decltype(nonNullValue_2)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_0_nullableIntItem_1));
                        }
                        jobject element_0_optionalIntItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "optionalInt", "Ljava/util/Optional;",
                                                                          element_0_optionalIntItem_1);
                        if (element_0_optionalIntItem_1 != nullptr)
                        {
                            jobject optionalValue_2;
                            chip::JniReferences::GetInstance().GetOptionalValue(element_0_optionalIntItem_1, optionalValue_2);
                            if (optionalValue_2 != nullptr)
                            {
                                auto & definedValue_2 = listHolder_0->mList[i_0].optionalInt.Emplace();
                                definedValue_2        = static_cast<std::remove_reference_t<decltype(definedValue_2)>>(
                                    chip::JniReferences::GetInstance().IntegerToPrimitive(optionalValue_2));
                            }
                        }
                        jobject element_0_nullableOptionalIntItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "nullableOptionalInt", "Ljava/util/Optional;",
                                                                          element_0_nullableOptionalIntItem_1);
                        if (element_0_nullableOptionalIntItem_1 != nullptr)
                        {
                            jobject optionalValue_2;
                            chip::JniReferences::GetInstance().GetOptionalValue(element_0_nullableOptionalIntItem_1,
                                                                                optionalValue_2);
                            if (optionalValue_2 != nullptr)
                            {
                                auto & definedValue_2 = listHolder_0->mList[i_0].nullableOptionalInt.Emplace();
                                if (optionalValue_2 == nullptr)
                                {
                                    definedValue_2.SetNull();
                                }
                                else
                                {
                                    auto & nonNullValue_3 = definedValue_2.SetNonNull();
                                    nonNullValue_3        = static_cast<std::remove_reference_t<decltype(nonNullValue_3)>>(
                                        chip::JniReferences::GetInstance().IntegerToPrimitive(optionalValue_2));
                                }
                            }
                        }
                        jobject element_0_nullableStringItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "nullableString", "Ljava/lang/String;",
                                                                          element_0_nullableStringItem_1);
                        if (element_0_nullableStringItem_1 == nullptr)
                        {
                            listHolder_0->mList[i_0].nullableString.SetNull();
                        }
                        else
                        {
                            auto & nonNullValue_2 = listHolder_0->mList[i_0].nullableString.SetNonNull();
                            cleanupStrings.push_back(chip::Platform::MakeUnique<chip::JniUtfString>(
                                env, static_cast<jstring>(element_0_nullableStringItem_1)));
                            nonNullValue_2 = cleanupStrings.back()->charSpan();
                        }
                        jobject element_0_optionalStringItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "optionalString", "Ljava/util/Optional;",
                                                                          element_0_optionalStringItem_1);
                        if (element_0_optionalStringItem_1 != nullptr)
                        {
                            jobject optionalValue_2;
                            chip::JniReferences::GetInstance().GetOptionalValue(element_0_optionalStringItem_1, optionalValue_2);
                            if (optionalValue_2 != nullptr)
                            {
                                auto & definedValue_2 = listHolder_0->mList[i_0].optionalString.Emplace();
                                cleanupStrings.push_back(
                                    chip::Platform::MakeUnique<chip::JniUtfString>(env, static_cast<jstring>(optionalValue_2)));
                                definedValue_2 = cleanupStrings.back()->charSpan();
                            }
                        }
                        jobject element_0_nullableOptionalStringItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(
                            element_0, "nullableOptionalString", "Ljava/util/Optional;", element_0_nullableOptionalStringItem_1);
                        if (element_0_nullableOptionalStringItem_1 != nullptr)
                        {
                            jobject optionalValue_2;
                            chip::JniReferences::GetInstance().GetOptionalValue(element_0_nullableOptionalStringItem_1,
                                                                                optionalValue_2);
                            if (optionalValue_2 != nullptr)
                            {
                                auto & definedValue_2 = listHolder_0->mList[i_0].nullableOptionalString.Emplace();
                                if (optionalValue_2 == nullptr)
                                {
                                    definedValue_2.SetNull();
                                }
                                else
                                {
                                    auto & nonNullValue_3 = definedValue_2.SetNonNull();
                                    cleanupStrings.push_back(
                                        chip::Platform::MakeUnique<chip::JniUtfString>(env, static_cast<jstring>(optionalValue_2)));
                                    nonNullValue_3 = cleanupStrings.back()->charSpan();
                                }
                            }
                        }
                        jobject element_0_nullableStructItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(
                            element_0, "nullableStruct", "Lchip/devicecontroller/ChipStructs$UnitTestingClusterSimpleStruct;",
                            element_0_nullableStructItem_1);
                        if (element_0_nullableStructItem_1 == nullptr)
                        {
                            listHolder_0->mList[i_0].nullableStruct.SetNull();
                        }
                        else
                        {
                            auto & nonNullValue_2 = listHolder_0->mList[i_0].nullableStruct.SetNonNull();
                            jobject element_0_nullableStructItem_1_aItem_3;
                            chip::JniReferences::GetInstance().GetObjectField(
                                element_0_nullableStructItem_1, "a", "Ljava/lang/Integer;", element_0_nullableStructItem_1_aItem_3);
                            nonNullValue_2.a = static_cast<std::remove_reference_t<decltype(nonNullValue_2.a)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_0_nullableStructItem_1_aItem_3));
                            jobject element_0_nullableStructItem_1_bItem_3;
                            chip::JniReferences::GetInstance().GetObjectField(
                                element_0_nullableStructItem_1, "b", "Ljava/lang/Boolean;", element_0_nullableStructItem_1_bItem_3);
                            nonNullValue_2.b = static_cast<std::remove_reference_t<decltype(nonNullValue_2.b)>>(
                                chip::JniReferences::GetInstance().BooleanToPrimitive(element_0_nullableStructItem_1_bItem_3));
                            jobject element_0_nullableStructItem_1_cItem_3;
                            chip::JniReferences::GetInstance().GetObjectField(
                                element_0_nullableStructItem_1, "c", "Ljava/lang/Integer;", element_0_nullableStructItem_1_cItem_3);
                            nonNullValue_2.c = static_cast<std::remove_reference_t<decltype(nonNullValue_2.c)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_0_nullableStructItem_1_cItem_3));
                            jobject element_0_nullableStructItem_1_dItem_3;
                            chip::JniReferences::GetInstance().GetObjectField(element_0_nullableStructItem_1, "d", "[B",
                                                                              element_0_nullableStructItem_1_dItem_3);
                            cleanupByteArrays.push_back(chip::Platform::MakeUnique<chip::JniByteArray>(
                                env, static_cast<jbyteArray>(element_0_nullableStructItem_1_dItem_3)));
                            nonNullValue_2.d = cleanupByteArrays.back()->byteSpan();
                            jobject element_0_nullableStructItem_1_eItem_3;
                            chip::JniReferences::GetInstance().GetObjectField(
                                element_0_nullableStructItem_1, "e", "Ljava/lang/String;", element_0_nullableStructItem_1_eItem_3);
                            cleanupStrings.push_back(chip::Platform::MakeUnique<chip::JniUtfString>(
                                env, static_cast<jstring>(element_0_nullableStructItem_1_eItem_3)));
                            nonNullValue_2.e = cleanupStrings.back()->charSpan();
                            jobject element_0_nullableStructItem_1_fItem_3;
                            chip::JniReferences::GetInstance().GetObjectField(
                                element_0_nullableStructItem_1, "f", "Ljava/lang/Integer;", element_0_nullableStructItem_1_fItem_3);
                            nonNullValue_2.f = static_cast<std::remove_reference_t<decltype(nonNullValue_2.f)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_0_nullableStructItem_1_fItem_3));
                            jobject element_0_nullableStructItem_1_gItem_3;
                            chip::JniReferences::GetInstance().GetObjectField(
                                element_0_nullableStructItem_1, "g", "Ljava/lang/Float;", element_0_nullableStructItem_1_gItem_3);
                            nonNullValue_2.g = static_cast<std::remove_reference_t<decltype(nonNullValue_2.g)>>(
                                chip::JniReferences::GetInstance().FloatToPrimitive(element_0_nullableStructItem_1_gItem_3));
                            jobject element_0_nullableStructItem_1_hItem_3;
                            chip::JniReferences::GetInstance().GetObjectField(
                                element_0_nullableStructItem_1, "h", "Ljava/lang/Double;", element_0_nullableStructItem_1_hItem_3);
                            nonNullValue_2.h = static_cast<std::remove_reference_t<decltype(nonNullValue_2.h)>>(
                                chip::JniReferences::GetInstance().DoubleToPrimitive(element_0_nullableStructItem_1_hItem_3));
                        }
                        jobject element_0_optionalStructItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "optionalStruct", "Ljava/util/Optional;",
                                                                          element_0_optionalStructItem_1);
                        if (element_0_optionalStructItem_1 != nullptr)
                        {
                            jobject optionalValue_2;
                            chip::JniReferences::GetInstance().GetOptionalValue(element_0_optionalStructItem_1, optionalValue_2);
                            if (optionalValue_2 != nullptr)
                            {
                                auto & definedValue_2 = listHolder_0->mList[i_0].optionalStruct.Emplace();
                                jobject optionalValue_2_aItem_3;
                                chip::JniReferences::GetInstance().GetObjectField(optionalValue_2, "a", "Ljava/lang/Integer;",
                                                                                  optionalValue_2_aItem_3);
                                definedValue_2.a = static_cast<std::remove_reference_t<decltype(definedValue_2.a)>>(
                                    chip::JniReferences::GetInstance().IntegerToPrimitive(optionalValue_2_aItem_3));
                                jobject optionalValue_2_bItem_3;
                                chip::JniReferences::GetInstance().GetObjectField(optionalValue_2, "b", "Ljava/lang/Boolean;",
                                                                                  optionalValue_2_bItem_3);
                                definedValue_2.b = static_cast<std::remove_reference_t<decltype(definedValue_2.b)>>(
                                    chip::JniReferences::GetInstance().BooleanToPrimitive(optionalValue_2_bItem_3));
                                jobject optionalValue_2_cItem_3;
                                chip::JniReferences::GetInstance().GetObjectField(optionalValue_2, "c", "Ljava/lang/Integer;",
                                                                                  optionalValue_2_cItem_3);
                                definedValue_2.c = static_cast<std::remove_reference_t<decltype(definedValue_2.c)>>(
                                    chip::JniReferences::GetInstance().IntegerToPrimitive(optionalValue_2_cItem_3));
                                jobject optionalValue_2_dItem_3;
                                chip::JniReferences::GetInstance().GetObjectField(optionalValue_2, "d", "[B",
                                                                                  optionalValue_2_dItem_3);
                                cleanupByteArrays.push_back(chip::Platform::MakeUnique<chip::JniByteArray>(
                                    env, static_cast<jbyteArray>(optionalValue_2_dItem_3)));
                                definedValue_2.d = cleanupByteArrays.back()->byteSpan();
                                jobject optionalValue_2_eItem_3;
                                chip::JniReferences::GetInstance().GetObjectField(optionalValue_2, "e", "Ljava/lang/String;",
                                                                                  optionalValue_2_eItem_3);
                                cleanupStrings.push_back(chip::Platform::MakeUnique<chip::JniUtfString>(
                                    env, static_cast<jstring>(optionalValue_2_eItem_3)));
                                definedValue_2.e = cleanupStrings.back()->charSpan();
                                jobject optionalValue_2_fItem_3;
                                chip::JniReferences::GetInstance().GetObjectField(optionalValue_2, "f", "Ljava/lang/Integer;",
                                                                                  optionalValue_2_fItem_3);
                                definedValue_2.f = static_cast<std::remove_reference_t<decltype(definedValue_2.f)>>(
                                    chip::JniReferences::GetInstance().IntegerToPrimitive(optionalValue_2_fItem_3));
                                jobject optionalValue_2_gItem_3;
                                chip::JniReferences::GetInstance().GetObjectField(optionalValue_2, "g", "Ljava/lang/Float;",
                                                                                  optionalValue_2_gItem_3);
                                definedValue_2.g = static_cast<std::remove_reference_t<decltype(definedValue_2.g)>>(
                                    chip::JniReferences::GetInstance().FloatToPrimitive(optionalValue_2_gItem_3));
                                jobject optionalValue_2_hItem_3;
                                chip::JniReferences::GetInstance().GetObjectField(optionalValue_2, "h", "Ljava/lang/Double;",
                                                                                  optionalValue_2_hItem_3);
                                definedValue_2.h = static_cast<std::remove_reference_t<decltype(definedValue_2.h)>>(
                                    chip::JniReferences::GetInstance().DoubleToPrimitive(optionalValue_2_hItem_3));
                            }
                        }
                        jobject element_0_nullableOptionalStructItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(
                            element_0, "nullableOptionalStruct", "Ljava/util/Optional;", element_0_nullableOptionalStructItem_1);
                        if (element_0_nullableOptionalStructItem_1 != nullptr)
                        {
                            jobject optionalValue_2;
                            chip::JniReferences::GetInstance().GetOptionalValue(element_0_nullableOptionalStructItem_1,
                                                                                optionalValue_2);
                            if (optionalValue_2 != nullptr)
                            {
                                auto & definedValue_2 = listHolder_0->mList[i_0].nullableOptionalStruct.Emplace();
                                if (optionalValue_2 == nullptr)
                                {
                                    definedValue_2.SetNull();
                                }
                                else
                                {
                                    auto & nonNullValue_3 = definedValue_2.SetNonNull();
                                    jobject optionalValue_2_aItem_4;
                                    chip::JniReferences::GetInstance().GetObjectField(optionalValue_2, "a", "Ljava/lang/Integer;",
                                                                                      optionalValue_2_aItem_4);
                                    nonNullValue_3.a = static_cast<std::remove_reference_t<decltype(nonNullValue_3.a)>>(
                                        chip::JniReferences::GetInstance().IntegerToPrimitive(optionalValue_2_aItem_4));
                                    jobject optionalValue_2_bItem_4;
                                    chip::JniReferences::GetInstance().GetObjectField(optionalValue_2, "b", "Ljava/lang/Boolean;",
                                                                                      optionalValue_2_bItem_4);
                                    nonNullValue_3.b = static_cast<std::remove_reference_t<decltype(nonNullValue_3.b)>>(
                                        chip::JniReferences::GetInstance().BooleanToPrimitive(optionalValue_2_bItem_4));
                                    jobject optionalValue_2_cItem_4;
                                    chip::JniReferences::GetInstance().GetObjectField(optionalValue_2, "c", "Ljava/lang/Integer;",
                                                                                      optionalValue_2_cItem_4);
                                    nonNullValue_3.c = static_cast<std::remove_reference_t<decltype(nonNullValue_3.c)>>(
                                        chip::JniReferences::GetInstance().IntegerToPrimitive(optionalValue_2_cItem_4));
                                    jobject optionalValue_2_dItem_4;
                                    chip::JniReferences::GetInstance().GetObjectField(optionalValue_2, "d", "[B",
                                                                                      optionalValue_2_dItem_4);
                                    cleanupByteArrays.push_back(chip::Platform::MakeUnique<chip::JniByteArray>(
                                        env, static_cast<jbyteArray>(optionalValue_2_dItem_4)));
                                    nonNullValue_3.d = cleanupByteArrays.back()->byteSpan();
                                    jobject optionalValue_2_eItem_4;
                                    chip::JniReferences::GetInstance().GetObjectField(optionalValue_2, "e", "Ljava/lang/String;",
                                                                                      optionalValue_2_eItem_4);
                                    cleanupStrings.push_back(chip::Platform::MakeUnique<chip::JniUtfString>(
                                        env, static_cast<jstring>(optionalValue_2_eItem_4)));
                                    nonNullValue_3.e = cleanupStrings.back()->charSpan();
                                    jobject optionalValue_2_fItem_4;
                                    chip::JniReferences::GetInstance().GetObjectField(optionalValue_2, "f", "Ljava/lang/Integer;",
                                                                                      optionalValue_2_fItem_4);
                                    nonNullValue_3.f = static_cast<std::remove_reference_t<decltype(nonNullValue_3.f)>>(
                                        chip::JniReferences::GetInstance().IntegerToPrimitive(optionalValue_2_fItem_4));
                                    jobject optionalValue_2_gItem_4;
                                    chip::JniReferences::GetInstance().GetObjectField(optionalValue_2, "g", "Ljava/lang/Float;",
                                                                                      optionalValue_2_gItem_4);
                                    nonNullValue_3.g = static_cast<std::remove_reference_t<decltype(nonNullValue_3.g)>>(
                                        chip::JniReferences::GetInstance().FloatToPrimitive(optionalValue_2_gItem_4));
                                    jobject optionalValue_2_hItem_4;
                                    chip::JniReferences::GetInstance().GetObjectField(optionalValue_2, "h", "Ljava/lang/Double;",
                                                                                      optionalValue_2_hItem_4);
                                    nonNullValue_3.h = static_cast<std::remove_reference_t<decltype(nonNullValue_3.h)>>(
                                        chip::JniReferences::GetInstance().DoubleToPrimitive(optionalValue_2_hItem_4));
                                }
                            }
                        }
                        jobject element_0_nullableListItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "nullableList", "Ljava/util/ArrayList;",
                                                                          element_0_nullableListItem_1);
                        if (element_0_nullableListItem_1 == nullptr)
                        {
                            listHolder_0->mList[i_0].nullableList.SetNull();
                        }
                        else
                        {
                            auto & nonNullValue_2 = listHolder_0->mList[i_0].nullableList.SetNonNull();
                            {
                                using ListType_3       = std::remove_reference_t<decltype(nonNullValue_2)>;
                                using ListMemberType_3 = ListMemberTypeGetter<ListType_3>::Type;
                                jint element_0_nullableListItem_1Size;
                                chip::JniReferences::GetInstance().GetListSize(element_0_nullableListItem_1,
                                                                               element_0_nullableListItem_1Size);
                                if (element_0_nullableListItem_1Size != 0)
                                {
                                    auto * listHolder_3 = new ListHolder<ListMemberType_3>(element_0_nullableListItem_1Size);
                                    listFreer.add(listHolder_3);

                                    for (jint i_3 = 0; i_3 < element_0_nullableListItem_1Size; ++i_3)
                                    {
                                        jobject element_3;
                                        chip::JniReferences::GetInstance().GetListItem(element_0_nullableListItem_1, i_3,
                                                                                       element_3);
                                        listHolder_3->mList[i_3] =
                                            static_cast<std::remove_reference_t<decltype(listHolder_3->mList[i_3])>>(
                                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_3));
                                    }
                                    nonNullValue_2 = ListType_3(listHolder_3->mList, element_0_nullableListItem_1Size);
                                }
                                else
                                {
                                    nonNullValue_2 = ListType_3();
                                }
                            }
                        }
                        jobject element_0_optionalListItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "optionalList", "Ljava/util/Optional;",
                                                                          element_0_optionalListItem_1);
                        if (element_0_optionalListItem_1 != nullptr)
                        {
                            jobject optionalValue_2;
                            chip::JniReferences::GetInstance().GetOptionalValue(element_0_optionalListItem_1, optionalValue_2);
                            if (optionalValue_2 != nullptr)
                            {
                                auto & definedValue_2 = listHolder_0->mList[i_0].optionalList.Emplace();
                                {
                                    using ListType_3       = std::remove_reference_t<decltype(definedValue_2)>;
                                    using ListMemberType_3 = ListMemberTypeGetter<ListType_3>::Type;
                                    jint optionalValue_2Size;
                                    chip::JniReferences::GetInstance().GetListSize(optionalValue_2, optionalValue_2Size);
                                    if (optionalValue_2Size != 0)
                                    {
                                        auto * listHolder_3 = new ListHolder<ListMemberType_3>(optionalValue_2Size);
                                        listFreer.add(listHolder_3);

                                        for (jint i_3 = 0; i_3 < optionalValue_2Size; ++i_3)
                                        {
                                            jobject element_3;
                                            chip::JniReferences::GetInstance().GetListItem(optionalValue_2, i_3, element_3);
                                            listHolder_3->mList[i_3] =
                                                static_cast<std::remove_reference_t<decltype(listHolder_3->mList[i_3])>>(
                                                    chip::JniReferences::GetInstance().IntegerToPrimitive(element_3));
                                        }
                                        definedValue_2 = ListType_3(listHolder_3->mList, optionalValue_2Size);
                                    }
                                    else
                                    {
                                        definedValue_2 = ListType_3();
                                    }
                                }
                            }
                        }
                        jobject element_0_nullableOptionalListItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "nullableOptionalList", "Ljava/util/Optional;",
                                                                          element_0_nullableOptionalListItem_1);
                        if (element_0_nullableOptionalListItem_1 != nullptr)
                        {
                            jobject optionalValue_2;
                            chip::JniReferences::GetInstance().GetOptionalValue(element_0_nullableOptionalListItem_1,
                                                                                optionalValue_2);
                            if (optionalValue_2 != nullptr)
                            {
                                auto & definedValue_2 = listHolder_0->mList[i_0].nullableOptionalList.Emplace();
                                if (optionalValue_2 == nullptr)
                                {
                                    definedValue_2.SetNull();
                                }
                                else
                                {
                                    auto & nonNullValue_3 = definedValue_2.SetNonNull();
                                    {
                                        using ListType_4       = std::remove_reference_t<decltype(nonNullValue_3)>;
                                        using ListMemberType_4 = ListMemberTypeGetter<ListType_4>::Type;
                                        jint optionalValue_2Size;
                                        chip::JniReferences::GetInstance().GetListSize(optionalValue_2, optionalValue_2Size);
                                        if (optionalValue_2Size != 0)
                                        {
                                            auto * listHolder_4 = new ListHolder<ListMemberType_4>(optionalValue_2Size);
                                            listFreer.add(listHolder_4);

                                            for (jint i_4 = 0; i_4 < optionalValue_2Size; ++i_4)
                                            {
                                                jobject element_4;
                                                chip::JniReferences::GetInstance().GetListItem(optionalValue_2, i_4, element_4);
                                                listHolder_4->mList[i_4] =
                                                    static_cast<std::remove_reference_t<decltype(listHolder_4->mList[i_4])>>(
                                                        chip::JniReferences::GetInstance().IntegerToPrimitive(element_4));
                                            }
                                            nonNullValue_3 = ListType_4(listHolder_4->mList, optionalValue_2Size);
                                        }
                                        else
                                        {
                                            nonNullValue_3 = ListType_4();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    cppValue = ListType_0(listHolder_0->mList, jValueSize);
                }
                else
                {
                    cppValue = ListType_0();
                }
            }

            // isArray
            // is_struct

            err =
                app::DataModel::EncodeForWrite(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::EnumAttr::Id: {
            using TypeInfo = Attributes::EnumAttr::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::RangeRestrictedInt8u::Id: {
            using TypeInfo = Attributes::RangeRestrictedInt8u::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::RangeRestrictedInt8s::Id: {
            using TypeInfo = Attributes::RangeRestrictedInt8s::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::RangeRestrictedInt16u::Id: {
            using TypeInfo = Attributes::RangeRestrictedInt16u::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::RangeRestrictedInt16s::Id: {
            using TypeInfo = Attributes::RangeRestrictedInt16s::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ListLongOctetString::Id: {
            using TypeInfo = Attributes::ListLongOctetString::TypeInfo;
            TypeInfo::Type cppValue;
            {
                using ListType_0       = std::remove_reference_t<decltype(cppValue)>;
                using ListMemberType_0 = ListMemberTypeGetter<ListType_0>::Type;
                jint jValueSize;
                chip::JniReferences::GetInstance().GetListSize(jValue, jValueSize);
                if (jValueSize != 0)
                {
                    auto * listHolder_0 = new ListHolder<ListMemberType_0>(jValueSize);
                    listFreer.add(listHolder_0);

                    for (jint i_0 = 0; i_0 < jValueSize; ++i_0)
                    {
                        jobject element_0;
                        chip::JniReferences::GetInstance().GetListItem(jValue, i_0, element_0);
                        cleanupByteArrays.push_back(
                            chip::Platform::MakeUnique<chip::JniByteArray>(env, static_cast<jbyteArray>(element_0)));
                        listHolder_0->mList[i_0] = cleanupByteArrays.back()->byteSpan();
                    }
                    cppValue = ListType_0(listHolder_0->mList, jValueSize);
                }
                else
                {
                    cppValue = ListType_0();
                }
            }

            // isArray

            err =
                app::DataModel::EncodeForWrite(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ListFabricScoped::Id: {
            using TypeInfo = Attributes::ListFabricScoped::TypeInfo;
            TypeInfo::Type cppValue;
            {
                using ListType_0       = std::remove_reference_t<decltype(cppValue)>;
                using ListMemberType_0 = ListMemberTypeGetter<ListType_0>::Type;
                jint jValueSize;
                chip::JniReferences::GetInstance().GetListSize(jValue, jValueSize);
                if (jValueSize != 0)
                {
                    auto * listHolder_0 = new ListHolder<ListMemberType_0>(jValueSize);
                    listFreer.add(listHolder_0);

                    for (jint i_0 = 0; i_0 < jValueSize; ++i_0)
                    {
                        jobject element_0;
                        chip::JniReferences::GetInstance().GetListItem(jValue, i_0, element_0);
                        jobject element_0_fabricSensitiveInt8uItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "fabricSensitiveInt8u", "Ljava/lang/Integer;",
                                                                          element_0_fabricSensitiveInt8uItem_1);
                        listHolder_0->mList[i_0].fabricSensitiveInt8u =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].fabricSensitiveInt8u)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_0_fabricSensitiveInt8uItem_1));
                        jobject element_0_optionalFabricSensitiveInt8uItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "optionalFabricSensitiveInt8u",
                                                                          "Ljava/util/Optional;",
                                                                          element_0_optionalFabricSensitiveInt8uItem_1);
                        if (element_0_optionalFabricSensitiveInt8uItem_1 != nullptr)
                        {
                            jobject optionalValue_2;
                            chip::JniReferences::GetInstance().GetOptionalValue(element_0_optionalFabricSensitiveInt8uItem_1,
                                                                                optionalValue_2);
                            if (optionalValue_2 != nullptr)
                            {
                                auto & definedValue_2 = listHolder_0->mList[i_0].optionalFabricSensitiveInt8u.Emplace();
                                definedValue_2        = static_cast<std::remove_reference_t<decltype(definedValue_2)>>(
                                    chip::JniReferences::GetInstance().IntegerToPrimitive(optionalValue_2));
                            }
                        }
                        jobject element_0_nullableFabricSensitiveInt8uItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "nullableFabricSensitiveInt8u",
                                                                          "Ljava/lang/Integer;",
                                                                          element_0_nullableFabricSensitiveInt8uItem_1);
                        if (element_0_nullableFabricSensitiveInt8uItem_1 == nullptr)
                        {
                            listHolder_0->mList[i_0].nullableFabricSensitiveInt8u.SetNull();
                        }
                        else
                        {
                            auto & nonNullValue_2 = listHolder_0->mList[i_0].nullableFabricSensitiveInt8u.SetNonNull();
                            nonNullValue_2        = static_cast<std::remove_reference_t<decltype(nonNullValue_2)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(
                                           element_0_nullableFabricSensitiveInt8uItem_1));
                        }
                        jobject element_0_nullableOptionalFabricSensitiveInt8uItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "nullableOptionalFabricSensitiveInt8u",
                                                                          "Ljava/util/Optional;",
                                                                          element_0_nullableOptionalFabricSensitiveInt8uItem_1);
                        if (element_0_nullableOptionalFabricSensitiveInt8uItem_1 != nullptr)
                        {
                            jobject optionalValue_2;
                            chip::JniReferences::GetInstance().GetOptionalValue(
                                element_0_nullableOptionalFabricSensitiveInt8uItem_1, optionalValue_2);
                            if (optionalValue_2 != nullptr)
                            {
                                auto & definedValue_2 = listHolder_0->mList[i_0].nullableOptionalFabricSensitiveInt8u.Emplace();
                                if (optionalValue_2 == nullptr)
                                {
                                    definedValue_2.SetNull();
                                }
                                else
                                {
                                    auto & nonNullValue_3 = definedValue_2.SetNonNull();
                                    nonNullValue_3        = static_cast<std::remove_reference_t<decltype(nonNullValue_3)>>(
                                        chip::JniReferences::GetInstance().IntegerToPrimitive(optionalValue_2));
                                }
                            }
                        }
                        jobject element_0_fabricSensitiveCharStringItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "fabricSensitiveCharString",
                                                                          "Ljava/lang/String;",
                                                                          element_0_fabricSensitiveCharStringItem_1);
                        cleanupStrings.push_back(chip::Platform::MakeUnique<chip::JniUtfString>(
                            env, static_cast<jstring>(element_0_fabricSensitiveCharStringItem_1)));
                        listHolder_0->mList[i_0].fabricSensitiveCharString = cleanupStrings.back()->charSpan();
                        jobject element_0_fabricSensitiveStructItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(
                            element_0, "fabricSensitiveStruct",
                            "Lchip/devicecontroller/ChipStructs$UnitTestingClusterSimpleStruct;",
                            element_0_fabricSensitiveStructItem_1);
                        jobject element_0_fabricSensitiveStructItem_1_aItem_2;
                        chip::JniReferences::GetInstance().GetObjectField(element_0_fabricSensitiveStructItem_1, "a",
                                                                          "Ljava/lang/Integer;",
                                                                          element_0_fabricSensitiveStructItem_1_aItem_2);
                        listHolder_0->mList[i_0].fabricSensitiveStruct.a =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].fabricSensitiveStruct.a)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(
                                    element_0_fabricSensitiveStructItem_1_aItem_2));
                        jobject element_0_fabricSensitiveStructItem_1_bItem_2;
                        chip::JniReferences::GetInstance().GetObjectField(element_0_fabricSensitiveStructItem_1, "b",
                                                                          "Ljava/lang/Boolean;",
                                                                          element_0_fabricSensitiveStructItem_1_bItem_2);
                        listHolder_0->mList[i_0].fabricSensitiveStruct.b =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].fabricSensitiveStruct.b)>>(
                                chip::JniReferences::GetInstance().BooleanToPrimitive(
                                    element_0_fabricSensitiveStructItem_1_bItem_2));
                        jobject element_0_fabricSensitiveStructItem_1_cItem_2;
                        chip::JniReferences::GetInstance().GetObjectField(element_0_fabricSensitiveStructItem_1, "c",
                                                                          "Ljava/lang/Integer;",
                                                                          element_0_fabricSensitiveStructItem_1_cItem_2);
                        listHolder_0->mList[i_0].fabricSensitiveStruct.c =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].fabricSensitiveStruct.c)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(
                                    element_0_fabricSensitiveStructItem_1_cItem_2));
                        jobject element_0_fabricSensitiveStructItem_1_dItem_2;
                        chip::JniReferences::GetInstance().GetObjectField(element_0_fabricSensitiveStructItem_1, "d", "[B",
                                                                          element_0_fabricSensitiveStructItem_1_dItem_2);
                        cleanupByteArrays.push_back(chip::Platform::MakeUnique<chip::JniByteArray>(
                            env, static_cast<jbyteArray>(element_0_fabricSensitiveStructItem_1_dItem_2)));
                        listHolder_0->mList[i_0].fabricSensitiveStruct.d = cleanupByteArrays.back()->byteSpan();
                        jobject element_0_fabricSensitiveStructItem_1_eItem_2;
                        chip::JniReferences::GetInstance().GetObjectField(element_0_fabricSensitiveStructItem_1, "e",
                                                                          "Ljava/lang/String;",
                                                                          element_0_fabricSensitiveStructItem_1_eItem_2);
                        cleanupStrings.push_back(chip::Platform::MakeUnique<chip::JniUtfString>(
                            env, static_cast<jstring>(element_0_fabricSensitiveStructItem_1_eItem_2)));
                        listHolder_0->mList[i_0].fabricSensitiveStruct.e = cleanupStrings.back()->charSpan();
                        jobject element_0_fabricSensitiveStructItem_1_fItem_2;
                        chip::JniReferences::GetInstance().GetObjectField(element_0_fabricSensitiveStructItem_1, "f",
                                                                          "Ljava/lang/Integer;",
                                                                          element_0_fabricSensitiveStructItem_1_fItem_2);
                        listHolder_0->mList[i_0].fabricSensitiveStruct.f =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].fabricSensitiveStruct.f)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(
                                    element_0_fabricSensitiveStructItem_1_fItem_2));
                        jobject element_0_fabricSensitiveStructItem_1_gItem_2;
                        chip::JniReferences::GetInstance().GetObjectField(element_0_fabricSensitiveStructItem_1, "g",
                                                                          "Ljava/lang/Float;",
                                                                          element_0_fabricSensitiveStructItem_1_gItem_2);
                        listHolder_0->mList[i_0].fabricSensitiveStruct.g =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].fabricSensitiveStruct.g)>>(
                                chip::JniReferences::GetInstance().FloatToPrimitive(element_0_fabricSensitiveStructItem_1_gItem_2));
                        jobject element_0_fabricSensitiveStructItem_1_hItem_2;
                        chip::JniReferences::GetInstance().GetObjectField(element_0_fabricSensitiveStructItem_1, "h",
                                                                          "Ljava/lang/Double;",
                                                                          element_0_fabricSensitiveStructItem_1_hItem_2);
                        listHolder_0->mList[i_0].fabricSensitiveStruct.h =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].fabricSensitiveStruct.h)>>(
                                chip::JniReferences::GetInstance().DoubleToPrimitive(
                                    element_0_fabricSensitiveStructItem_1_hItem_2));
                        jobject element_0_fabricSensitiveInt8uListItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "fabricSensitiveInt8uList",
                                                                          "Ljava/util/ArrayList;",
                                                                          element_0_fabricSensitiveInt8uListItem_1);
                        {
                            using ListType_2 = std::remove_reference_t<decltype(listHolder_0->mList[i_0].fabricSensitiveInt8uList)>;
                            using ListMemberType_2 = ListMemberTypeGetter<ListType_2>::Type;
                            jint element_0_fabricSensitiveInt8uListItem_1Size;
                            chip::JniReferences::GetInstance().GetListSize(element_0_fabricSensitiveInt8uListItem_1,
                                                                           element_0_fabricSensitiveInt8uListItem_1Size);
                            if (element_0_fabricSensitiveInt8uListItem_1Size != 0)
                            {
                                auto * listHolder_2 =
                                    new ListHolder<ListMemberType_2>(element_0_fabricSensitiveInt8uListItem_1Size);
                                listFreer.add(listHolder_2);

                                for (jint i_2 = 0; i_2 < element_0_fabricSensitiveInt8uListItem_1Size; ++i_2)
                                {
                                    jobject element_2;
                                    chip::JniReferences::GetInstance().GetListItem(element_0_fabricSensitiveInt8uListItem_1, i_2,
                                                                                   element_2);
                                    listHolder_2->mList[i_2] =
                                        static_cast<std::remove_reference_t<decltype(listHolder_2->mList[i_2])>>(
                                            chip::JniReferences::GetInstance().IntegerToPrimitive(element_2));
                                }
                                listHolder_0->mList[i_0].fabricSensitiveInt8uList =
                                    ListType_2(listHolder_2->mList, element_0_fabricSensitiveInt8uListItem_1Size);
                            }
                            else
                            {
                                listHolder_0->mList[i_0].fabricSensitiveInt8uList = ListType_2();
                            }
                        }
                        jobject element_0_fabricIndexItem_1;
                        chip::JniReferences::GetInstance().GetObjectField(element_0, "fabricIndex", "Ljava/lang/Integer;",
                                                                          element_0_fabricIndexItem_1);
                        listHolder_0->mList[i_0].fabricIndex =
                            static_cast<std::remove_reference_t<decltype(listHolder_0->mList[i_0].fabricIndex)>>(
                                chip::JniReferences::GetInstance().IntegerToPrimitive(element_0_fabricIndexItem_1));
                    }
                    cppValue = ListType_0(listHolder_0->mList, jValueSize);
                }
                else
                {
                    cppValue = ListType_0();
                }
            }

            // isArray
            // is_struct

            err =
                app::DataModel::EncodeForWrite(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::TimedWriteBoolean::Id: {
            using TypeInfo = Attributes::TimedWriteBoolean::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().BooleanToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::GeneralErrorBoolean::Id: {
            using TypeInfo = Attributes::GeneralErrorBoolean::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().BooleanToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::ClusterErrorBoolean::Id: {
            using TypeInfo = Attributes::ClusterErrorBoolean::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().BooleanToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::Unsupported::Id: {
            using TypeInfo = Attributes::Unsupported::TypeInfo;
            TypeInfo::Type cppValue;
            cppValue = static_cast<std::remove_reference_t<decltype(cppValue)>>(
                chip::JniReferences::GetInstance().BooleanToPrimitive(jValue));

            // else

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableBoolean::Id: {
            using TypeInfo = Attributes::NullableBoolean::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().BooleanToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableBitmap8::Id: {
            using TypeInfo = Attributes::NullableBitmap8::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableBitmap16::Id: {
            using TypeInfo = Attributes::NullableBitmap16::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableBitmap32::Id: {
            using TypeInfo = Attributes::NullableBitmap32::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableBitmap64::Id: {
            using TypeInfo = Attributes::NullableBitmap64::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableInt8u::Id: {
            using TypeInfo = Attributes::NullableInt8u::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableInt16u::Id: {
            using TypeInfo = Attributes::NullableInt16u::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableInt24u::Id: {
            using TypeInfo = Attributes::NullableInt24u::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableInt32u::Id: {
            using TypeInfo = Attributes::NullableInt32u::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableInt40u::Id: {
            using TypeInfo = Attributes::NullableInt40u::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableInt48u::Id: {
            using TypeInfo = Attributes::NullableInt48u::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableInt56u::Id: {
            using TypeInfo = Attributes::NullableInt56u::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableInt64u::Id: {
            using TypeInfo = Attributes::NullableInt64u::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableInt8s::Id: {
            using TypeInfo = Attributes::NullableInt8s::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableInt16s::Id: {
            using TypeInfo = Attributes::NullableInt16s::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableInt24s::Id: {
            using TypeInfo = Attributes::NullableInt24s::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableInt32s::Id: {
            using TypeInfo = Attributes::NullableInt32s::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableInt40s::Id: {
            using TypeInfo = Attributes::NullableInt40s::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableInt48s::Id: {
            using TypeInfo = Attributes::NullableInt48s::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableInt56s::Id: {
            using TypeInfo = Attributes::NullableInt56s::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableInt64s::Id: {
            using TypeInfo = Attributes::NullableInt64s::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().LongToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableEnum8::Id: {
            using TypeInfo = Attributes::NullableEnum8::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableEnum16::Id: {
            using TypeInfo = Attributes::NullableEnum16::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableFloatSingle::Id: {
            using TypeInfo = Attributes::NullableFloatSingle::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().FloatToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableFloatDouble::Id: {
            using TypeInfo = Attributes::NullableFloatDouble::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().DoubleToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableOctetString::Id: {
            using TypeInfo = Attributes::NullableOctetString::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                cleanupByteArrays.push_back(chip::Platform::MakeUnique<chip::JniByteArray>(env, static_cast<jbyteArray>(jValue)));
                nonNullValue_0 = cleanupByteArrays.back()->byteSpan();
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableCharString::Id: {
            using TypeInfo = Attributes::NullableCharString::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                cleanupStrings.push_back(chip::Platform::MakeUnique<chip::JniUtfString>(env, static_cast<jstring>(jValue)));
                nonNullValue_0 = cleanupStrings.back()->charSpan();
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableEnumAttr::Id: {
            using TypeInfo = Attributes::NullableEnumAttr::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableRangeRestrictedInt8u::Id: {
            using TypeInfo = Attributes::NullableRangeRestrictedInt8u::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableRangeRestrictedInt8s::Id: {
            using TypeInfo = Attributes::NullableRangeRestrictedInt8s::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableRangeRestrictedInt16u::Id: {
            using TypeInfo = Attributes::NullableRangeRestrictedInt16u::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        case Attributes::NullableRangeRestrictedInt16s::Id: {
            using TypeInfo = Attributes::NullableRangeRestrictedInt16s::TypeInfo;
            TypeInfo::Type cppValue;
            if (jValue == nullptr)
            {
                cppValue.SetNull();
            }
            else
            {
                auto & nonNullValue_0 = cppValue.SetNonNull();
                nonNullValue_0        = static_cast<std::remove_reference_t<decltype(nonNullValue_0)>>(
                    chip::JniReferences::GetInstance().IntegerToPrimitive(jValue));
            }

            // nullable

            err = app::DataModel::Encode(aWriter, TLV::ContextTag(to_underlying(app::AttributeDataIB::Tag::kData)), cppValue);
            return err;
        }
        default:
            err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
            break;
        }
        break;
    }
    default:
        err = CHIP_ERROR_IM_MALFORMED_ATTRIBUTE_PATH_IB;
        break;
    }
    return err;
}

} // namespace chip