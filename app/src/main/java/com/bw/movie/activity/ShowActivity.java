package com.bw.movie.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.adapter.MyFragmentPagerAdapter;
import com.bw.movie.fragment.HomeFragment;
import com.bw.movie.fragment.MineFragment;
import com.bw.movie.fragment.ShowFragment;
import com.bw.movie.presenter.Presenter;
import com.bw.movie.view.MyCustomViewPager;
import com.bw.mvplibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ShowActivity extends BaseActivity<Presenter>  implements View.OnClickListener{

    private ArrayList<Fragment> list = new ArrayList<>();
    private List<LinearLayout> liner = new ArrayList<>();
    @BindView(R.id.view_pager)
    MyCustomViewPager viewPager;
    @BindView(R.id.image_movei_dj)
    ImageView imageMoveiDj;
    @BindView(R.id.lin_movei)
    LinearLayout linMovei;
    @BindView(R.id.image_cinem_dj)
    ImageView imageCinemDj;
    @BindView(R.id.lin_cinem)
    LinearLayout linCinem;
    @BindView(R.id.image_myy_dj)
    ImageView imageMyyDj;
    @BindView(R.id.lin_myy)
    LinearLayout linMyy;
    @BindView(R.id.lay_one)
    LinearLayout layOne;
    @BindView(R.id.lay_two)
    LinearLayout layTwo;
    @BindView(R.id.lay_swe)
    LinearLayout laySwe;
    @Override
    protected Presenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        super.initData();
        list.add(new HomeFragment());
        list.add(new ShowFragment());
        list.add(new MineFragment());
        liner.add(linMovei);
        liner.add(linCinem);
        liner.add(linMyy);
        imageMoveiDj.setOnClickListener(this);
        imageCinemDj.setOnClickListener(this);
        imageMyyDj.setOnClickListener(this);


        MyFragmentPagerAdapter fragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(fragmentPagerAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_movei_dj:
                imageMoveiDj.setVisibility(View.GONE);
                imageCinemDj.setVisibility(View.VISIBLE);
                imageMyyDj.setVisibility(View.VISIBLE);
                linMovei.setVisibility(View.VISIBLE);
                linCinem.setVisibility(View.GONE);
                linMyy.setVisibility(View.GONE);
                viewPager.setCurrentItem(0);
                break;
            case R.id.image_cinem_dj:
                imageMoveiDj.setVisibility(View.VISIBLE);
                imageCinemDj.setVisibility(View.GONE);
                imageMyyDj.setVisibility(View.VISIBLE);
                linMovei.setVisibility(View.GONE);
                linCinem.setVisibility(View.VISIBLE);
                linMyy.setVisibility(View.GONE);
                viewPager.setCurrentItem(1);
                break;
            case R.id.image_myy_dj:
                imageMoveiDj.setVisibility(View.VISIBLE);
                imageCinemDj.setVisibility(View.VISIBLE);
                imageMyyDj.setVisibility(View.GONE);
                linMovei.setVisibility(View.GONE);
                linCinem.setVisibility(View.GONE);
                linMyy.setVisibility(View.VISIBLE);
                viewPager.setCurrentItem(2);
                break;
        }
    }
}
