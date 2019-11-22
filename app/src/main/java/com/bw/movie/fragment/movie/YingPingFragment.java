package com.bw.movie.fragment.movie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.adapter.movies.MyHomeMoviesYingPingAdapter;
import com.bw.movie.bean.GreatBean;
import com.bw.movie.bean.MovieCommentBean;
import com.bw.movie.contract.Contract;
import com.bw.movie.presenter.Presenter;
import com.bw.mvplibrary.base.BaseFragment;
import com.bw.mvplibrary.utils.Logger;
import com.bw.mvplibrary.utils.ToastUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * describe:JieshaoFragment
 * date:2019/11/15
 * author:任(Lenovo)
 * function:
 */
public class YingPingFragment extends BaseFragment<Presenter> implements Contract.IView {

    public static final String TAG = "YingPingFragment";
    @BindView(R.id.rec_home_movies_yp)
    RecyclerView recHomeMoviesYp;
    private String userId;
    private String sessionId;
    private String page = "1";
    private String count = "5";

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_yingping;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        userId = sp.getString("userId","");
        sessionId = sp.getString("sessionId","");
        Intent intent = getActivity().getIntent();
        String moviesId = intent.getStringExtra("moviesId");
        presenter.doComment(userId, sessionId, moviesId, page, count);
    }

    @Override
    public void onSuccess(Object obj) {
        MovieCommentBean movieCommentBean = (MovieCommentBean) obj;
        Logger.e(TAG, movieCommentBean.getMessage()+"movieCommentBean");
        List<MovieCommentBean.ResultBean> result = movieCommentBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recHomeMoviesYp.setLayoutManager(linearLayoutManager);
        MyHomeMoviesYingPingAdapter myHomeMoviesYingPingAdapter = new MyHomeMoviesYingPingAdapter(result, getActivity());
        recHomeMoviesYp.setAdapter(myHomeMoviesYingPingAdapter);
        myHomeMoviesYingPingAdapter.setOnClick(new MyHomeMoviesYingPingAdapter.onClick() {
            @Override
            public void onClick(String commentId) {
                presenter.doGreat(userId,sessionId,commentId);
            }
        });
    }

    @Override
    public void onSuccessFul(Object object) {
        GreatBean greatBean = (GreatBean) object;
        Logger.e(TAG,greatBean.getMessage()+"greatBean");
        ToastUtils.init(getContext());

        ToastUtils.show(greatBean.getMessage());
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
