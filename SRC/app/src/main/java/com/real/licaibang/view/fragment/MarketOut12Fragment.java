package com.real.licaibang.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.real.licaibang.R;

import butterknife.ButterKnife;

/**
 * Created by dhc on 2017/2/12.
 */

public class MarketOut12Fragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_market_out12, container, false);

        ButterKnife.bind(this, view);

        return view;
    }
}
