package com.learn.hotornot;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.annotation.TargetApi;
import android.location.Location;
import android.location.LocationListener;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.learn.hotornot.data.DataRepository;
import com.learn.hotornot.databinding.ActivityMainBinding;
import com.learn.hotornot.details.DetailsFragment;
import com.learn.hotornot.overall.OverallFragment;

public class MainActivity extends AppCompatActivity implements MainView, LocationListener, DetailsFragment.DetailsFragmentListener, OverallFragment.OverallFragmentListener {
    private ActivityMainBinding binding;
    private DataRepository mDataRepository;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        mDataRepository = new DataRepository(this);
        setupTabLayout();

        binding.btnSync.setOnClickListener(v -> onRefreshWeatherData());

    }

    @Override
    public void onRefreshWeatherData() {
        mDataRepository.getWeatherData();
    }

    @Override
    public void setupTabLayout() {
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tabAdapter.addFragment(OverallFragment.newInstance(mDataRepository), OverallFragment.TITLE);
        tabAdapter.addFragment(DetailsFragment.newInstance(mDataRepository), DetailsFragment.TITLE);
        binding.viewPager.setAdapter(tabAdapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void getGpsLocation() {

    }
    @Override
    public void onDetailsFragmentInteraction(Uri uri) {

    }

    @Override
    public void onOverallFragmentInteraction(Uri uri) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
