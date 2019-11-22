package com.bw.movie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.contract.Contract;
import com.bw.movie.presenter.Presenter;
import com.bw.mvplibrary.base.BaseActivity;
import com.bw.mvplibrary.utils.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class SwitchPlaceActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "SwitchPlaceActivity";
    @BindView(R.id.tv_name_switch_place)
    TextView tvNameSwitchPlace;
    @BindView(R.id.jc_video_switch_place)
    JCVideoPlayerStandard jcVideoSwitchPlace;
    private String name;
    private String video;
    private String movieId;
    private String cinemaId;

    @Override
    public void onSuccess(Object obj) {

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

    @Override
    protected Presenter providePresenter() {
        return null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventBus(Map<String, String> map) {
        name = map.get("name");
        video = map.get("video");
        movieId = map.get("movieId");
        tvNameSwitchPlace.setText(name);
        jcVideoSwitchPlace.setUp(video,jcVideoSwitchPlace.SCREEN_LAYOUT_NORMAL);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        cinemaId = intent.getStringExtra("cinemaId");
        Logger.e(TAG,cinemaId+"cinemaId");
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_switch_place;
    }
}
