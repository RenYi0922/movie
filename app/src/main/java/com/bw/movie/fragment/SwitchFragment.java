package com.bw.movie.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.MyHomeMoviesSwitchByRecAdapter;
import com.bw.movie.bean.ByCinemaBean;
import com.bw.movie.bean.FindCinemasInfoByRegion;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.bean.TimeBean;
import com.bw.movie.contract.Contract;
import com.bw.movie.presenter.Presenter;
import com.bw.mvplibrary.base.BaseFragment;
import com.bw.mvplibrary.utils.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

import static android.content.Context.MODE_PRIVATE;

/**
 * describe:SwitchFragment
 * date:2019/11/21
 * author:任(Lenovo)
 * function:
 */
public class SwitchFragment extends BaseFragment<Presenter> implements Contract.IView {

    public static final String TAG = "SwitchFragment";
    private String userId;
    private String session;
    @BindView(R.id.rec_place_movies_switch)
    RecyclerView rec_place_movies_switch;
    private String po;
    private String page = "1";
    private String count = "10";
    private String moviesId;
    private String poo;

    @Override
    public void onSuccess(Object obj) {
         FindCinemasInfoByRegion findCinemasInfoByRegion = (FindCinemasInfoByRegion) obj;
        Logger.e(TAG,findCinemasInfoByRegion.getMessage()+"findCinemasInfoByRegion");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rec_place_movies_switch.setLayoutManager(linearLayoutManager);
        List<FindCinemasInfoByRegion.ResultBean> result = findCinemasInfoByRegion.getResult();
        MyHomeMoviesSwitchByRecAdapter myHomeMoviesSwitchByRecAdapter = new MyHomeMoviesSwitchByRecAdapter(result,getContext());
        rec_place_movies_switch.setAdapter(myHomeMoviesSwitchByRecAdapter);
    }

    @Override
    public void onSuccessFul(Object object) {
        ByCinemaBean byCinemaBean = (ByCinemaBean) object;
        Logger.e(TAG,byCinemaBean.getMessage()+"ByCinemaBean");
        presenter.doFindCinemasInfoByRegion(moviesId,po,page,count);
    }

    @Override
    public void onNowSuccess(Object now) {
        TimeBean timeBean = (TimeBean) now;
        Logger.e(TAG,timeBean.getMessage()+"TimeBean");
        presenter.doFindCinemasInfoByData(moviesId,poo,page,count);
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
        return R.layout.fragment_switch;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void EventBus(Map<String,String> map){
        po = map.get("po");
        poo = map.get("poo");
        presenter.doBy(po);
        presenter.doTime();
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("login", MODE_PRIVATE);
        userId = sp.getString("userId", "");
        session = sp.getString("session", "");
        Intent intent = getActivity().getIntent();
        moviesId = intent.getStringExtra("moviesId");
    }
}
