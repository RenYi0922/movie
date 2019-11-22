package com.bw.movie.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:MyFragmentPagerScheduleAdapter
 * date:2019/11/20
 * author:任(Lenovo)
 * function:
 */
public class MyFragmentPagerScheduleAdapter extends FragmentPagerAdapter {

    private ArrayList<String> tab;

    public MyFragmentPagerScheduleAdapter(FragmentManager fm, ArrayList<String> tab) {
        super(fm);
        this.tab = tab;
    }

    @Override
    public Fragment getItem(int i) {
        return null;
    }

    @Override
    public int getCount() {
        return tab.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tab.get(position);
    }
}
