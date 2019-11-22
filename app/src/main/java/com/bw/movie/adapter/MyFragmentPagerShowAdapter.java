package com.bw.movie.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * describe:MyFragmentPagerAdapter
 * date:2019/11/11
 * author:任(Lenovo)
 * function:
 */
public class MyFragmentPagerShowAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    private ArrayList<String> tab;

    public MyFragmentPagerShowAdapter(FragmentManager fm, ArrayList<Fragment> list, ArrayList<String> tab) {
        super(fm);
        this.list = list;
        this.tab = tab;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tab.get(position);
    }
}
