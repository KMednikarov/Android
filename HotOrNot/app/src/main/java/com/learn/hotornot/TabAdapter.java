package com.learn.hotornot;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.learn.hotornot.details.DetailsFragment;
import com.learn.hotornot.overall.OverallFragment;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragmentsList = new ArrayList<>();
    private List<String> mFragmentTitlesList = new ArrayList<>();

    public TabAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentsList.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitlesList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentsList.size();
    }

    public void addFragment(Fragment fragment, String title){
        this.mFragmentsList.add(fragment);
        this.mFragmentTitlesList.add(title);
    }
}
