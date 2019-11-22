package com.bw.movie.fragment.cinema;

import com.bw.movie.R;
import com.bw.movie.contract.Contract;
import com.bw.movie.presenter.Presenter;
import com.bw.mvplibrary.base.BaseFragment;

/**
 * describe:YyxqFragment
 * date:2019/11/18
 * author:任(Lenovo)
 * function:
 */
public class YypjFragment extends BaseFragment<Presenter> implements Contract.IView {
    @Override
    public void onSuccess(Object obj) {

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
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_yypj;
    }
}
