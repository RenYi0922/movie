package com.bw.movie.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;

import com.bw.movie.R;
import com.bw.movie.activity.MoviesActivity;
import com.bw.movie.adapter.home.MyHomeAdapter;
import com.bw.movie.bean.AfterBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.NowBean;
import com.bw.movie.contract.Contract;
import com.bw.movie.presenter.Presenter;
import com.bw.mvplibrary.base.BaseFragment;
import com.bw.mvplibrary.utils.Logger;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;

/**
 * describe:HomeFragment
 * date:2019/11/11
 * author:任(Lenovo)
 * function:
 */
public class HomeFragment extends BaseFragment<Presenter> implements Contract.IView {

    public static final String TAG = "HomeFragment";
    private String page = "1";
    private String count = "5";
    @BindView(R.id.xRec_home)
    XRecyclerView xRecHome;
    private String userId;
    private String sessionId;
    private List<BannerBean.ResultBean> bannerBeanResult;
    private List<HotBean.ResultBean> hotBeanResult;
    private List<NowBean.ResultBean> nowBeanResult;
    private List<AfterBean.ResultBean> afterBeanResult;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        userId = sp.getString("userId","");
        sessionId = sp.getString("sessionId","");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        xRecHome.setLayoutManager(linearLayoutManager);
        presenter.doNow(userId,sessionId,page,"3");
        presenter.doBanner();
        presenter.doHot(page,count);
        presenter.doAfter(page,count);
    }

    @Override
    public void onSuccess(Object obj) {
        BannerBean bannerBean = (BannerBean) obj;
        Logger.e(TAG,bannerBean.getMessage()+"banner");
        bannerBeanResult = bannerBean.getResult();
        MyHomeAdapter myHomeAdapter = new MyHomeAdapter(bannerBeanResult, afterBeanResult, nowBeanResult, hotBeanResult, getContext());
        xRecHome.setAdapter(myHomeAdapter);
    }

    @Override
    public void onSuccessFul(Object object) {
        HotBean hotBean = (HotBean) object;
        Logger.e(TAG,hotBean.getMessage()+"hot");
        hotBeanResult = hotBean.getResult();
        MyHomeAdapter myHomeAdapter = new MyHomeAdapter(bannerBeanResult, afterBeanResult, nowBeanResult, hotBeanResult, getContext());
        xRecHome.setAdapter(myHomeAdapter);
        myHomeAdapter.setOnClick(new MyHomeAdapter.onClick() {
            @Override
            public void moviesId(String moviesId) {
                Intent intent = new Intent(getActivity(), MoviesActivity.class);
                intent.putExtra("moviesId",moviesId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onNowSuccess(Object now) {
        NowBean nowBean = (NowBean) now;
        Logger.e(TAG,nowBean.getMessage()+"now");
        nowBeanResult = nowBean.getResult();
        MyHomeAdapter myHomeAdapter = new MyHomeAdapter(bannerBeanResult, afterBeanResult, nowBeanResult, hotBeanResult, getContext());
        xRecHome.setAdapter(myHomeAdapter);
        myHomeAdapter.setOnClick(new MyHomeAdapter.onClick() {
            @Override
            public void moviesId(String moviesId) {
                Intent intent = new Intent(getActivity(), MoviesActivity.class);
                intent.putExtra("moviesId",moviesId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onAfterSuccess(Object after) {
        AfterBean afterBean = (AfterBean) after;
        Logger.e(TAG,afterBean.getMessage()+"after");
        afterBeanResult = afterBean.getResult();
        MyHomeAdapter myHomeAdapter = new MyHomeAdapter(bannerBeanResult, afterBeanResult, nowBeanResult, hotBeanResult, getContext());
        xRecHome.setAdapter(myHomeAdapter);
        myHomeAdapter.setOnClick(new MyHomeAdapter.onClick() {
            @Override
            public void moviesId(String moviesId) {
                Intent intent = new Intent(getActivity(), MoviesActivity.class);
                intent.putExtra("moviesId",moviesId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onFail(String str) {

    }

}
