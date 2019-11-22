package com.bw.movie.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.adapter.MyFragmentPagerMoviesAdapter;
import com.bw.movie.adapter.cinema.MyCinemaRecViewAdapter;
import com.bw.movie.bean.FindCinemaBean;
import com.bw.movie.contract.Contract;
import com.bw.movie.fragment.cinema.YypjFragment;
import com.bw.movie.fragment.cinema.YyxqFragment;
import com.bw.movie.presenter.Presenter;
import com.bw.mvplibrary.base.BaseActivity;
import com.bw.mvplibrary.utils.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CinemaActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "CinemaActivity";
    @BindView(R.id.rec_show_cinema)
    RecyclerView recShowCinema;
    @BindView(R.id.tv_check_cinema)
    Button tvCheckCinema;
    private String userId;
    private String sessionId;
    private String id;
    private ArrayList<Fragment> list = new ArrayList<>();
    private ArrayList<String> tab = new ArrayList<>();
    @BindView(R.id.tab_layout_cinema)
    TabLayout tabLayoutCinema;
    @BindView(R.id.view_pager_cinema)
    ViewPager viewPagerCinema;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_cinema;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getSharedPreferences("login", MODE_PRIVATE);
        userId = sp.getString("userId","");
        sessionId = sp.getString("sessionId","");
        final Intent intent = getIntent();
        id = intent.getStringExtra("Id");
        presenter.doFindCinema(userId, sessionId, id);
        tab.add("影院详情");
        tab.add("影院评价");
        tabLayoutCinema.setupWithViewPager(viewPagerCinema);
        list.add(new YyxqFragment());
        list.add(new YyxqFragment());
        MyFragmentPagerMoviesAdapter myFragmentPagerMoviesAdapter = new MyFragmentPagerMoviesAdapter(getSupportFragmentManager(), list, tab);
        viewPagerCinema.setAdapter(myFragmentPagerMoviesAdapter);
        viewPagerCinema.setOffscreenPageLimit(2);
        tvCheckCinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(CinemaActivity.this, ScheduleActivity.class);
                intent1.putExtra("Id",id);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void onSuccess(Object obj) {
        FindCinemaBean findCinemaBean = (FindCinemaBean) obj;
        Logger.e(TAG, findCinemaBean.getMessage());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recShowCinema.setLayoutManager(linearLayoutManager);
        FindCinemaBean.ResultBean result = findCinemaBean.getResult();
        MyCinemaRecViewAdapter myCinemaRecViewAdapter = new MyCinemaRecViewAdapter(result, context());
        recShowCinema.setAdapter(myCinemaRecViewAdapter);
    }

    @Override
    public void onSuccessFul(Object object) {

    }

    @Override
    public void onNowSuccess(Object now) {

    }

    @Override
    public void onAfterSuccess(Object after) {

    }

    @Override
    public void onFail(String str) {

    }

}
