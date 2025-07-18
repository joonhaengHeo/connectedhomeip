/*
 *    Copyright (c) 2025 Project CHIP Authors
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

#include <app/data-model-provider/MetadataTypes.h>
#include <data-model-providers/codedriven/endpoint/EndpointInterface.h>
#include <lib/core/CHIPError.h>
#include <lib/support/CodeUtils.h>

namespace chip {
namespace app {

/**
 * @brief Represents a registration entry for an EndpointInterface within the EndpointInterfaceRegistry.
 *
 * This struct acts as a node in a singly-linked list used by the EndpointInterfaceRegistry.
 * It contains a pointer to the actual EndpointInterface and a pointer to the next
 * registration in the list.
 *
 * Callers are responsible for ensuring that both this registration object and the
 * EndpointInterface it points to outlive their registration with the EndpointInterfaceRegistry.
 */
struct EndpointInterfaceRegistration
{
    EndpointInterface * const endpointInterface;
    EndpointInterfaceRegistration * next;

    constexpr EndpointInterfaceRegistration(EndpointInterface & interface, EndpointInterfaceRegistration * next_item = nullptr) :
        endpointInterface(&interface), next(next_item)
    {}
    EndpointInterfaceRegistration(EndpointInterfaceRegistration && other) = default;

    EndpointInterfaceRegistration(const EndpointInterfaceRegistration & other)             = delete;
    EndpointInterfaceRegistration & operator=(const EndpointInterfaceRegistration & other) = delete;
};

/**
 * @brief Manages a collection of EndpointInterface instances.
 *
 * The EndpointInterfaceRegistry can be used to discover and interact programmatically
 * with Matter endpoints. It maintains a linked list of EndpointInterfaceRegistration
 * objects.
 *
 * Responsibilities:
 * - Allows registration and unregistration of endpoints.
 * - Provides a way to retrieve a specific endpoint by its EndpointId.
 * - Offers an iterator to traverse all registered endpoints.
 *
 * Lifetime Management:
 * - The registry stores raw pointers to EndpointInterface and EndpointInterfaceRegistration objects.
 * - It does NOT take ownership of these objects.
 * - Callers MUST ensure that any registered EndpointInterface and its corresponding
 *   EndpointInterfaceRegistration object outlive the EndpointInterfaceRegistry or are unregistered
 *   before being destroyed.
 */
class EndpointInterfaceRegistry
{
public:
    class Iterator
    {
    public:
        explicit Iterator(EndpointInterfaceRegistration * registration) : mCurrent(registration) {}

        Iterator & operator++()
        {
            mCurrent = (mCurrent ? mCurrent->next : nullptr);
            return *this;
        }
        bool operator==(const Iterator & other) const { return mCurrent == other.mCurrent; }
        bool operator!=(const Iterator & other) const { return mCurrent != other.mCurrent; }
        EndpointInterface * operator*() { return mCurrent->endpointInterface; }
        EndpointInterface * operator->() { return mCurrent->endpointInterface; }

    private:
        EndpointInterfaceRegistration * mCurrent;
    };

    /**
     * @brief Registers an endpoint.
     *
     * The provided `entry` (EndpointInterfaceRegistration) must not already be part of another list
     * (i.e., `entry.next` must be nullptr). The EndpointInterface within the entry must
     * be valid and have a valid EndpointId.
     *
     * @param entry The EndpointInterfaceRegistration containing the provider to register.
     *              The lifetime of this object must be managed by the caller.
     * @return CHIP_NO_ERROR on success.
     *         CHIP_ERROR_INVALID_ARGUMENT if entry.next is not nullptr,
     *                                     entry.endpointInterface is nullptr,
     *                                     or the endpoint ID is kInvalidEndpointId.
     *         CHIP_ERROR_DUPLICATE_KEY_ID if an endpoint with the same ID is already registered.
     */
    CHIP_ERROR Register(EndpointInterfaceRegistration & entry);

    /**
     * @brief Unregisters an endpoint with the given EndpointId.
     *
     * @note This method does not guarantee that iterators will remain valid after this call.
     *       If you are iterating over the registry, you should NOT call this method.
     *
     * @param endpointId The ID of the endpoint to unregister.
     * @return CHIP_NO_ERROR on success. It is not considered an error to
     *         unregister a provider that is not found.
     *         CHIP_ERROR_INVALID_ARGUMENT if endpointId is kInvalidEndpointId.
     */
    CHIP_ERROR Unregister(EndpointId endpointId);

    /** @return A pointer to the EndpointInterface for the given endpointId, or nullptr if not found. */
    EndpointInterface * Get(EndpointId endpointId);
    Iterator begin() { return Iterator(mRegistrations); }
    Iterator end() { return Iterator(nullptr); }

private:
    EndpointInterfaceRegistration * mRegistrations = nullptr;
    EndpointInterface * mCachedInterface           = nullptr;
    EndpointId mCachedEndpointId                   = kInvalidEndpointId;
};

} // namespace app
} // namespace chip
