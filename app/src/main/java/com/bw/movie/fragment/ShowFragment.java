package com.bw.movie.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.bw.movie.R;
import com.bw.movie.adapter.MyFragmentPagerShowAdapter;
import com.bw.movie.fragment.show.AddressFragment;
import com.bw.movie.fragment.show.NearFragment;
import com.bw.movie.fragment.show.RecommendFragment;
import com.bw.movie.presenter.Presenter;
import com.bw.mvplibrary.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * describe:ShowFragment
 * date:2019/11/11
 * author:任(Lenovo)
 * function:
 */
public class ShowFragment extends BaseFragment<Presenter> {

    private ArrayList<Fragment> list = new ArrayList<>();
    private ArrayList<String> tab = new ArrayList<>();
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager_show)
    ViewPager viewPagerShow;

    @Override
    protected Presenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_show;
    }

    @Override
    protected void initData() {
        super.initData();
        tab.add("推荐影院");
        tab.add("附近影院");
        tab.add("海淀区");
        list.add(new RecommendFragment());
        list.add(new NearFragment());
        list.add(new AddressFragment());
        tabLayout.setupWithViewPager(viewPagerShow);
        MyFragmentPagerShowAdapter myFragmentPagerShowAdapter = new MyFragmentPagerShowAdapter(getFragmentManager(), list, tab);
        viewPagerShow.setAdapter(myFragmentPagerShowAdapter);
    }
}
