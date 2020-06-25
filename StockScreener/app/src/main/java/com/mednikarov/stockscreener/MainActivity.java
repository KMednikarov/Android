package com.mednikarov.stockscreener;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.mednikarov.stockscreener.databinding.ActivityMainBinding;
import com.mednikarov.stockscreener.views.search.SearchFragment;
import com.mednikarov.stockscreener.views.watchlist.WatchlistFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setupTabLayout();
    }

    public void setupTabLayout() {
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tabAdapter.addFragment(WatchlistFragment.newInstance(),getString(R.string.watchlist_fragment_title));
        tabAdapter.addFragment(SearchFragment.newInstance(),getString(R.string.search_fragment_title));
        binding.viewPager.setAdapter(tabAdapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

}
