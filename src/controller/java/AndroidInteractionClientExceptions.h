/*
 *
 *    Copyright (c) 2024 Project CHIP Authors
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
#include <lib/core/CHIPError.h>

namespace chip {
class AndroidInteractionClientExceptions
{
public:
    AndroidInteractionClientExceptions(const AndroidInteractionClientExceptions &)             = delete;
    AndroidInteractionClientExceptions(const AndroidInteractionClientExceptions &&)            = delete;
    AndroidInteractionClientExceptions & operator=(const AndroidInteractionClientExceptions &) = delete;

    static AndroidInteractionClientExceptions & GetInstance()
    {
        static AndroidInteractionClientExceptions androidInteractionClientExceptions;
        return androidInteractionClientExceptions;
    }

    /**
     * Creates a Java AndroidInteractionClientException object in outEx.
     */
    CHIP_ERROR CreateAndroidInteractionClientException(JNIEnv * env, const char * message, uint32_t errorCode, jthrowable & outEx);

private:
    AndroidInteractionClientExceptions() {}
};
} // namespace chip
