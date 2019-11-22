package com.bw.movie.fragment.show;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;

import com.bw.movie.R;
import com.bw.movie.adapter.cinema.MyNearRecViewAdapter;
import com.bw.movie.bean.NearBean;
import com.bw.movie.contract.Contract;
import com.bw.movie.presenter.Presenter;
import com.bw.mvplibrary.base.BaseFragment;
import com.bw.mvplibrary.utils.Logger;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;

/**
 * describe:RecommendFragment
 * date:2019/11/13
 * author:任(Lenovo)
 * function:
 */
public class NearFragment extends BaseFragment<Presenter> implements Contract.IView {

    public static final String TAG = "NearFragment";
    private String userId;
    private String sessionId;
    private String page = "1";
    private String count = "10";
    private String longitude = "116.30551391385724";
    private String latitude = "40.04571807462411";
    @BindView(R.id.xRec_show_near)
    XRecyclerView xRecShowNear;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_near_show;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        userId = sp.getString("userId","");
        sessionId = sp.getString("sessionId","");
        presenter.doNear(userId, sessionId,longitude,latitude,page,count);
    }

    @Override
    public void onSuccess(Object obj) {
        NearBean nearBean = (NearBean) obj;
        Logger.e(TAG,nearBean.getMessage()+"nearBean");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        xRecShowNear.setLayoutManager(linearLayoutManager);
        List<NearBean.ResultBean> result = nearBean.getResult();
        MyNearRecViewAdapter myNearRecViewAdapter = new MyNearRecViewAdapter(result, getContext());
        xRecShowNear.setAdapter(myNearRecViewAdapter);
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
