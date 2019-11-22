package com.bw.movie.fragment.movie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.movies.MyHomeMoviesYuGaoAdapter;
import com.bw.movie.bean.FindMoviesBean;
import com.bw.movie.contract.Contract;
import com.bw.movie.presenter.Presenter;
import com.bw.mvplibrary.base.BaseFragment;
import com.bw.mvplibrary.utils.Logger;

import butterknife.BindView;

/**
 * describe:JieshaoFragment
 * date:2019/11/15
 * author:任(Lenovo)
 * function:
 */
public class YuGaoFragment extends BaseFragment<Presenter> implements Contract.IView {

    public static final String TAG = "YuGaoFragment";
    @BindView(R.id.rec_home_movies_yg)
    RecyclerView recHomeMoviesYg;
    private String userId;
    private String sessionId;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_yugao;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        userId = sp.getString("userId","");
        sessionId = sp.getString("sessionId","");
        Intent intent = getActivity().getIntent();
        String moviesId = intent.getStringExtra("moviesId");
        presenter.doFindMovies(userId, sessionId, moviesId);
    }

    @Override
    public void onSuccess(Object obj) {
        FindMoviesBean findMoviesBean = (FindMoviesBean) obj;
        Logger.e(TAG,findMoviesBean.getMessage());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recHomeMoviesYg.setLayoutManager(linearLayoutManager);
        FindMoviesBean.ResultBean result = findMoviesBean.getResult();
        MyHomeMoviesYuGaoAdapter myHomeMoviesYuGaoAdapter = new MyHomeMoviesYuGaoAdapter(result, getActivity());
        recHomeMoviesYg.setAdapter(myHomeMoviesYuGaoAdapter);
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
