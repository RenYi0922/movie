package com.bw.movie.fragment.show;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;

import com.bw.movie.R;
import com.bw.movie.adapter.cinema.MyRecommendRecViewAdapter;
import com.bw.movie.bean.RecommendBean;
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
public class RecommendFragment extends BaseFragment<Presenter> implements Contract.IView {

    public static final String TAG = "RecommendFragment";
    private String userId;
    private String sessionId;
    private String page = "1";
    private String count = "10";
    @BindView(R.id.xRec_show_recommend)
    XRecyclerView xRecShowRecommend;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_recommend_show;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        userId = sp.getString("userId","");
        sessionId = sp.getString("sessionId","");
        presenter.doRec(userId, sessionId,page,count);
    }

    @Override
    public void onSuccess(Object obj) {
        RecommendBean recommendBean = (RecommendBean) obj;
        Logger.e(TAG,recommendBean.getMessage()+"recommendBean");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        xRecShowRecommend.setLayoutManager(linearLayoutManager);
        List<RecommendBean.ResultBean> result = recommendBean.getResult();
        MyRecommendRecViewAdapter myRecommendRecViewAdapter = new MyRecommendRecViewAdapter(result, getContext());
        xRecShowRecommend.setAdapter(myRecommendRecViewAdapter);
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
