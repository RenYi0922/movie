package com.bw.movie.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.cinema.MyScheduleRecViewAdapter;
import com.bw.movie.bean.ScheduleBean;
import com.bw.movie.contract.Contract;
import com.bw.movie.presenter.Presenter;
import com.bw.mvplibrary.base.BaseFragment;
import com.bw.mvplibrary.utils.Logger;
import com.bw.mvplibrary.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;

/**
 * describe:AllFragment
 * date:2019/11/20
 * author:任(Lenovo)
 * function:
 */
public class AllFragment extends BaseFragment<Presenter> implements Contract.IView {

    public static final String TAG = "AllFragment";
    @BindView(R.id.rec_show_schedule_view)
    RecyclerView recShowScheduleView;
    private String page = "1";
    private String count = "10";

    @Override
    public void onSuccess(Object obj) {
        ScheduleBean scheduleBean = (ScheduleBean) obj;
        Logger.e(TAG, scheduleBean.getMessage());
        if ("查询成功".equals(scheduleBean.getMessage())) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            recShowScheduleView.setLayoutManager(linearLayoutManager);
            List<ScheduleBean.ResultBean> result = scheduleBean.getResult();
            MyScheduleRecViewAdapter myScheduleRecViewAdapter = new MyScheduleRecViewAdapter(result, getActivity());
            recShowScheduleView.setAdapter(myScheduleRecViewAdapter);
        }else {
            ToastUtils.init(getActivity());
            ToastUtils.show("此影院目前没有上映电影");
        }
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
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_all;
    }

    @Override
    protected void initData() {
        super.initData();
        Bundle arguments = getArguments();
        String id = arguments.getString("Id");
        presenter.doSchedule(id, page, count);
    }
}
