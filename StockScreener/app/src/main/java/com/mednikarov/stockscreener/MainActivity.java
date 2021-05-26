package com.mednikarov.stockscreener;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mednikarov.stockscreener.databinding.ActivityMainBinding;
import com.mednikarov.stockscreener.ui.fragments.SearchFragment;
import com.mednikarov.stockscreener.ui.fragments.WatchlistFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.bottomNavigation.setOnNavigationItemSelectedListener(bottomNavigationListener);
        setCurrentFragment(WatchlistFragment.newInstance());
    }

    private void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,fragment)
                .addToBackStack(null)
                .commit();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId()){
                case R.id.bottom_nav_watchlist_menu:
                    setCurrentFragment(WatchlistFragment.newInstance());
                    return true;
                case R.id.bottom_nav_search_menu:
                    setCurrentFragment(SearchFragment.newInstance());
                    return true;
            }
            return false;
        }
    };
}
