package com.bw.movie.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.adapter.MyHomeMoviesSwitchByRecAdapter;
import com.bw.movie.adapter.MyHomeMoviesSwitchRecAdapter;
import com.bw.movie.bean.AddressBean;
import com.bw.movie.bean.ByCinemaBean;
import com.bw.movie.bean.FindMoviesBean;
import com.bw.movie.bean.TimeBean;
import com.bw.movie.contract.Contract;
import com.bw.movie.fragment.SwitchFragment;
import com.bw.movie.presenter.Presenter;
import com.bw.mvplibrary.base.BaseActivity;
import com.bw.mvplibrary.utils.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class SwitchCinemaActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "SwitchCinemaActivity";
    @BindView(R.id.spinner_place)
    Spinner spinnerPlace;
    @BindView(R.id.spinner_time)
    Spinner spinnerTime;
    @BindView(R.id.tv_price_switch)
    TextView tvPriceSwitch;
    @BindView(R.id.rec_home_movies_switch)
    RecyclerView recHomeMoviesSwitch;
    @BindView(R.id.fragment_switch)
    FrameLayout frameLayout;
    private String userId;
    private String session;
    private MyHomeMoviesSwitchRecAdapter myHomeMoviesSwitchRecAdapter;
    private String id;

    @Override
    public void onSuccess(Object obj) {
        FindMoviesBean findMoviesBean = (FindMoviesBean) obj;
        Logger.e(TAG,findMoviesBean.getMessage()+"findMoviesBean");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recHomeMoviesSwitch.setLayoutManager(linearLayoutManager);
        FindMoviesBean.ResultBean result = findMoviesBean.getResult();
        Map<String,String> map = new HashMap<>();
        map.put("name",result.getName());
        map.put("video",result.getShortFilmList().get(1).getVideoUrl());
        EventBus.getDefault().postSticky(map);
        myHomeMoviesSwitchRecAdapter = new MyHomeMoviesSwitchRecAdapter(result,this);
        recHomeMoviesSwitch.setAdapter(myHomeMoviesSwitchRecAdapter);

    }

    @Override
    public void onSuccessFul(Object object) {
        AddressBean addressBean = (AddressBean) object;
        Logger.e(TAG,addressBean.getMessage()+"AddressBean");
        List<AddressBean.ResultBean> result = addressBean.getResult();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            String regionName = result.get(i).getRegionName();
            arrayList.add(regionName);
        }
        String[] strings = arrayList.toArray(new String[arrayList.size()]);
        //自定义选择填充后的字体样式
        //只能是textview样式，否则报错：ArrayAdapter requires the resource ID to be a TextView
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, R.layout.item_select, strings);
        //自定义下拉的字体样式
        spinnerAdapter.setDropDownViewResource(R.layout.item_drop);
        spinnerPlace.setAdapter(spinnerAdapter);
        spinnerPlace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int po = position;
                Map<String,String> map = new HashMap<>();
                map.put("po",po+"");
                EventBus.getDefault().postSticky(map);
                myHomeMoviesSwitchRecAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onNowSuccess(Object now) {
        TimeBean timeBean = (TimeBean) now;
        Logger.e(TAG,timeBean.getMessage()+"TimeBean");
        List<String> result = timeBean.getResult();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            String s = result.get(i);
            arrayList.add(s);
        }
        String[] spinnerAdapter = arrayList.toArray(new String[arrayList.size()]);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.item_select, spinnerAdapter);
        arrayAdapter.setDropDownViewResource(R.layout.item_drop);
        spinnerTime.setAdapter(arrayAdapter);
        spinnerTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int poo = position;
                Logger.e(TAG,poo+"");
                Map<String,String> map = new HashMap<>();
                map.put("poo",poo+"");
                EventBus.getDefault().postSticky(map);
                myHomeMoviesSwitchRecAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
        return R.layout.activity_switch_cinema;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getSharedPreferences("login", MODE_PRIVATE);
        userId = sp.getString("userId", "");
        session = sp.getString("session", "");
        Intent intent = getIntent();
        id = intent.getStringExtra("moviesId");
        presenter.doFindMovies(userId, session, id);
        presenter.doAddress();
        presenter.doTime();
    }

    /*@Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onEventBus(String regionId){
        presenter.doBy(regionId);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }*/

    @OnClick(R.id.tv_ss)
    public void onClick() {
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_switch,new SwitchFragment()).commit();

    }

}
