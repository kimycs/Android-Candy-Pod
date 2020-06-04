/*
 * Copyright 2020 Niranjan Bhoi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.developer.kimy.model;

import com.google.gson.annotations.SerializedName;

public class ITunesResponse {

    @SerializedName("feed")
    private Feed mFeed;

    public Feed getFeed() {
        return mFeed;
    }

    public void setFeed(Feed feed) {
        mFeed = feed;
    }
}
