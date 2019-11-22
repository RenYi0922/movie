package com.bw.movie.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.activity.LoadActivity;
import com.bw.movie.presenter.Presenter;
import com.bw.mvplibrary.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * describe:MineFragment
 * date:2019/11/11
 * author:任(Lenovo)
 * function:
 */
public class MineFragment extends BaseFragment<Presenter> {


    @Override
    protected Presenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initData() {
        super.initData();
    }


    @OnClick(R.id.img_sz)
    public void onClick() {
        Intent intent = new Intent(getContext(), LoadActivity.class);
        startActivity(intent);
    }
}
