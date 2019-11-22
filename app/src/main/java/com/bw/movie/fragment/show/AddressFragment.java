package com.bw.movie.fragment.show;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.adapter.cinema.MyAddressRecViewAdapter;
import com.bw.movie.adapter.cinema.MyPlaceRecViewAdapter;
import com.bw.movie.bean.AddressBean;
import com.bw.movie.bean.PlaceBean;
import com.bw.movie.contract.Contract;
import com.bw.movie.presenter.Presenter;
import com.bw.mvplibrary.base.BaseFragment;
import com.bw.mvplibrary.utils.Logger;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;

/**
 * describe:RecommendFragment
 * date:2019/11/13
 * author:任(Lenovo)
 * function:
 */
public class AddressFragment extends BaseFragment<Presenter> implements Contract.IView {

    public static final String TAG = "AddressFragment";
    @BindView(R.id.rec_show_address_left)
    RecyclerView recShowAddressLeft;
    @BindView(R.id.rec_show_address_right)
    RecyclerView recShowAddressRight;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_address_show;
    }

    @Override
    protected void initData() {
        super.initData();
        presenter.doAddress();
    }

    @Override
    public void onSuccess(Object obj) {
        AddressBean addressBean = (AddressBean) obj;
        Logger.e(TAG,addressBean.getMessage()+"address");
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recShowAddressLeft.setLayoutManager(linearLayoutManager);
        List<AddressBean.ResultBean> result = addressBean.getResult();
        MyAddressRecViewAdapter myAddressRecViewAdapter = new MyAddressRecViewAdapter(result, getContext());
        recShowAddressLeft.setAdapter(myAddressRecViewAdapter);
        myAddressRecViewAdapter.setOnClick(new MyAddressRecViewAdapter.onClick() {
            @Override
            public void onClick(String regionId) {
                recShowAddressRight.setVisibility(View.VISIBLE);
                presenter.doPlace(regionId);
                EventBus.getDefault().postSticky(regionId);
            }
        });
    }

    @Override
    public void onSuccessFul(Object object) {
        PlaceBean placeBean = (PlaceBean) object;
        Logger.e(TAG,placeBean.getMessage()+"place");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recShowAddressRight.setLayoutManager(linearLayoutManager);
        List<PlaceBean.ResultBean> result = placeBean.getResult();
        MyPlaceRecViewAdapter myPlaceRecViewAdapter = new MyPlaceRecViewAdapter(result, getContext());
        recShowAddressRight.setAdapter(myPlaceRecViewAdapter);
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
