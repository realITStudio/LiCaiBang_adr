package com.real.licaibang.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by dhc on 2017/2/12.
 */

public class MainMarketVPAdapter extends FragmentStatePagerAdapter {

    private String [] mTabTitleArray;
    private List<Fragment> mFragmentList;
    private Context mContext;

    public MainMarketVPAdapter(FragmentManager fm, Context context,
                               List<Fragment> fragmentList, String[] tabTitleArray) {
        super(fm);
        this.mFragmentList = fragmentList;
        this.mTabTitleArray = tabTitleArray;
        this.mContext = context;
    }


    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mTabTitleArray.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitleArray[position % mTabTitleArray.length];
    }
}
