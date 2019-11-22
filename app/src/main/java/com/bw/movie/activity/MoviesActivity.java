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

import com.bw.movie.R;
import com.bw.movie.adapter.MyFragmentPagerMoviesAdapter;
import com.bw.movie.adapter.movies.MyHomeMoviesRecViewAdapter;
import com.bw.movie.bean.FindMoviesBean;
import com.bw.movie.bean.GzBean;
import com.bw.movie.bean.QgzBean;
import com.bw.movie.contract.Contract;
import com.bw.movie.fragment.movie.JieShaoFragment;
import com.bw.movie.fragment.movie.JuZhaoFragment;
import com.bw.movie.fragment.movie.YingPingFragment;
import com.bw.movie.fragment.movie.YuGaoFragment;
import com.bw.movie.presenter.Presenter;
import com.bw.mvplibrary.base.BaseActivity;
import com.bw.mvplibrary.utils.Logger;
import com.bw.mvplibrary.utils.ToastUtils;

import java.net.Inet4Address;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoviesActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "MoviesActivity";
    private String userId;
    private String sessionId;
    private String moviesId;
    @BindView(R.id.rec_movies)
    RecyclerView recMovies;
    @BindView(R.id.tab_layout_movies)
    TabLayout tabLayout;
    @BindView(R.id.view_pager_movies)
    ViewPager viewPagerMovies;
    private ArrayList<Fragment> list = new ArrayList<>();
    private ArrayList<String> tab = new ArrayList<>();

    @Override
    public void onSuccess(Object obj) {
        FindMoviesBean findMoviesBean = (FindMoviesBean) obj;
        Logger.e(TAG, findMoviesBean.getMessage());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recMovies.setLayoutManager(linearLayoutManager);
        MyHomeMoviesRecViewAdapter myHomeMoviesRecViewAdapter = new MyHomeMoviesRecViewAdapter(findMoviesBean, this);
        recMovies.setAdapter(myHomeMoviesRecViewAdapter);
        myHomeMoviesRecViewAdapter.setOnGz(new MyHomeMoviesRecViewAdapter.onGz() {
            @Override
            public void onGz(int num) {
                if (num % 2 == 1) {
                    //presenter.doGz(userId, sessionId, moviesId);
                } else if (num % 2 == 0) {
                    //presenter.doQgz(userId, sessionId, moviesId);
                }
            }
        });
    }

    @Override
    public void onSuccessFul(Object object) {
        GzBean gzBean = (GzBean) object;
        Logger.e(TAG, gzBean.getMessage() + "gzBean");
    }

    @Override
    public void onNowSuccess(Object now) {
        QgzBean qgzBean = (QgzBean) now;
        Logger.e(TAG, qgzBean.getMessage() + "QgzBean");
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
        return R.layout.activity_movies;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getSharedPreferences("login", MODE_PRIVATE);
        userId = sp.getString("userId", "");
        sessionId = sp.getString("sessionId", "");
        Intent intent = getIntent();
        moviesId = intent.getStringExtra("moviesId");
        presenter.doFindMovies(userId, sessionId, moviesId);
        tab.add("介绍");
        tab.add("预告");
        tab.add("剧照");
        tab.add("影评");
        tabLayout.setupWithViewPager(viewPagerMovies);
        list.add(new JieShaoFragment());
        list.add(new YuGaoFragment());
        list.add(new JuZhaoFragment());
        list.add(new YingPingFragment());
        MyFragmentPagerMoviesAdapter myFragmentPagerMoviesAdapter = new MyFragmentPagerMoviesAdapter(getSupportFragmentManager(), list, tab);
        viewPagerMovies.setAdapter(myFragmentPagerMoviesAdapter);
        viewPagerMovies.setOffscreenPageLimit(4);
    }

    @OnClick({R.id.btn_write, R.id.btn_buy_movies})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_write:
                ToastUtils.init(this);
                ToastUtils.show("正在进入...");
                break;
            case R.id.btn_buy_movies:
                Intent intent = new Intent(this, SwitchCinemaActivity.class);
                intent.putExtra("moviesId",moviesId);
                startActivity(intent);
                break;
        }
    }
}
