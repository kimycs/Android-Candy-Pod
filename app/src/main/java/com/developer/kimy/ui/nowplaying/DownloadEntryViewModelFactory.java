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

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.developer.kimy.data.CandyPodRepository;

/**
 * Factory method that allows us to create a ViewModel with a constructor that takes a
 * {@link CandyPodRepository} and enclosure url.
 */
public class DownloadEntryViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final CandyPodRepository mRepository;
    private final String mEnclosureUrl;

    public DownloadEntryViewModelFactory(CandyPodRepository repository, String enclosureUrl) {
        mRepository = repository;
        mEnclosureUrl = enclosureUrl;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        // noinspection unchecked
        return (T) new DownloadEntryViewModel(mRepository, mEnclosureUrl);
    }
}
