package com.bw.movie.adapter;

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
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;

    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
