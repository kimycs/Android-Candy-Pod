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

package com.developer.kimy.ui.nowplaying;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.developer.kimy.data.CandyPodRepository;
import com.developer.kimy.data.FavoriteEntry;

/**
 * FavoriteEntryViewModel class is designed to store and manage {@link LiveData} FavoriteEntry.
 */
public class FavoriteEntryViewModel extends ViewModel {

    private final CandyPodRepository mRepository;
    private LiveData<FavoriteEntry> mFavoriteEntry;

    public FavoriteEntryViewModel(CandyPodRepository repository, String url) {
        mRepository = repository;
        mFavoriteEntry = mRepository.getFavoriteEpisodeByUrl(url);
    }

    public LiveData<FavoriteEntry> getFavoriteEntry() {
        return mFavoriteEntry;
    }
}
