package com.bw.movie.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.bw.movie.R;
import com.bw.movie.bean.ScheduleBean;
import com.bw.movie.bean.TimeBean;
import com.bw.movie.contract.Contract;
import com.bw.movie.fragment.AllFragment;
import com.bw.movie.presenter.Presenter;
import com.bw.mvplibrary.base.BaseActivity;
import com.bw.mvplibrary.utils.Logger;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScheduleActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "ScheduleActivity";
    private ArrayList<String> tab = new ArrayList<>();
    @BindView(R.id.tab_layout_schedule)
    TabLayout tabLayoutSchedule;
    @BindView(R.id.view_pager_schedule)
    ViewPager viewPagerSchedule;
    private String id;

    @Override
    public void onSuccess(Object obj) {


    }

    @Override
    public void onSuccessFul(Object object) {

    }

    @Override
    public void onNowSuccess(Object now) {
        TimeBean timeBean  = (TimeBean) now;
        Logger.e(TAG,timeBean.getMessage()+"time");
        for (int i = 0; i < timeBean.getResult().size(); i++) {
            tab.add(timeBean.getResult().get(i));
        }
        tabLayoutSchedule.setupWithViewPager(viewPagerSchedule);
        viewPagerSchedule.setAdapter(new MyAdapter(getSupportFragmentManager()));
    }

    @Override
    public void onAfterSuccess(Object after) {

    }

    @Override
    public void onFail(String str) {

    }

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_schedule;
    }


    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        id = intent.getStringExtra("Id");

        presenter.doTime();
    }
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Bundle bundle = new Bundle();
            bundle.putString("Id",id);
            AllFragment allFragment = new AllFragment();
            allFragment.setArguments(bundle);
            return allFragment;
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
}
