package com.real.licaibang.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.real.licaibang.R;
import com.real.licaibang.view.adapter.MainMarketVPAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dhc on 2017/2/11.
 */

public class MarketFragment extends BaseFragment {

    @BindView(R.id.tlt_main_market_data)
    TabLayout mDataTlt;
    @BindView(R.id.vpr_main_market_data)
    ViewPager mDataVpr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_market, container, false);

        ButterKnife.bind(this,view);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //绑定ViewPager 和 TabLayout
        mDataTlt.setTabMode (TabLayout.MODE_SCROLLABLE);
        mDataTlt.setupWithViewPager(mDataVpr);

        initViews();
    }


    private void initViews() {
        String [] tabStrings = new String[] {"活期","3个月内","3～6个月","6~12个月","12个月以上"};

        List<Fragment> lists = new ArrayList<Fragment>();
        lists.add(new MarketCurrentFragment());
        lists.add(new MarketIn3Fragment());
        lists.add(new MarketIn6Fragment());
        lists.add(new MarketIn12Fragment());
        lists.add(new MarketOut12Fragment());
        mDataVpr.setAdapter(new MainMarketVPAdapter(getActivity().getSupportFragmentManager(),getActivity(),lists,tabStrings));
    }
}
