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

package com.developer.kimy.ui;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.FragmentManager;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import com.developer.kimy.R;
import com.developer.kimy.databinding.ActivityMainBinding;
import com.developer.kimy.ui.downloads.DownloadsFragment;
import com.developer.kimy.ui.favorites.FavoritesFragment;
import com.developer.kimy.ui.podcasts.PodcastsFragment;
import com.developer.kimy.ui.contact.ContactsFragment;


import timber.log.Timber;

import static com.developer.kimy.utilities.Constants.INDEX_ZERO;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /** This field is used for data binding **/
    private ActivityMainBinding mMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(mMainBinding.appBarMain.toolbar);

        // Setup Timber
        Timber.plant(new Timber.DebugTree());

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mMainBinding.drawerLayout, mMainBinding.appBarMain.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mMainBinding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mMainBinding.navView.setNavigationItemSelectedListener(this);

        // Set PodcastsFragment as a default fragment when starting the app
        if (savedInstanceState == null) {
            onNavigationItemSelected(mMainBinding.navView.getMenu().getItem(INDEX_ZERO).setChecked(true));
        }
    }

    @Override
    public void onBackPressed() {
        if (mMainBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Replace the fragment using a FragmentManager and Transaction
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.nav_podcasts) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new PodcastsFragment())
                    .commit();
        } else if (id == R.id.nav_contacts) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new ContactsFragment())
                    .commit();
        } else if (id == R.id.nav_favorites) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new FavoritesFragment())
                    .commit();
        } else if (id == R.id.nav_downloads) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new DownloadsFragment())
                    .commit();
        }
        mMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
