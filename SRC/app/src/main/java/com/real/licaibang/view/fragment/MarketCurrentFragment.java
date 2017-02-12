package com.real.licaibang.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.real.licaibang.R;
import com.real.licaibang.bean.PlatformYieldInfo;
import com.real.licaibang.chart.MyAcisValueFormatter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by dhc on 2017/2/12.
 */

public class MarketCurrentFragment extends BaseFragment {

    @BindView(R.id.bct_main_market_current)
    BarChart mBarChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_market_current, container, false);

        ButterKnife.bind(this, view);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        mBarChart.getDescription().setEnabled(false);

        List<PlatformYieldInfo> infos = new ArrayList<>();
        infos.add(new PlatformYieldInfo("余额宝", 3.6220f));
        infos.add(new PlatformYieldInfo("京东", 3.5220f));
        infos.add(new PlatformYieldInfo("网商银行", 3.4211f));
        infos.add(new PlatformYieldInfo("央行", 3.1329f));
        infos.add(new PlatformYieldInfo("腾讯", 2.9654f));
        infos.add(new PlatformYieldInfo("小米", 2.6368f));
        infos.add(new PlatformYieldInfo("招商", 1.9781f));
        infos.add(new PlatformYieldInfo("百度理财", 1.6220f));


        setData(infos);
    }


    private void setData(List<PlatformYieldInfo> pyInfos) {
        String [] platforms = new String[pyInfos.size()+1];
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for(int i=1;i<=pyInfos.size();i++) {
            platforms[i] = pyInfos.get(i-1).mPlatform;
            Timber.e("---"+pyInfos.get(i-1).mYield);
            yVals1.add(new BarEntry(i,pyInfos.get(i-1).mYield));
        }


        IAxisValueFormatter xAxisFormatter = new IndexAxisValueFormatter(platforms);

        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelCount(8);
        xAxis.setValueFormatter(xAxisFormatter);

        IAxisValueFormatter custom = new MyAcisValueFormatter();

        YAxis leftAxis = mBarChart.getAxisLeft();
        leftAxis.setValueFormatter(custom);

        YAxis rightAxis = mBarChart.getAxisRight();
        rightAxis.setValueFormatter(custom);

        BarDataSet set1;

        if (mBarChart.getData() != null &&
                mBarChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mBarChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            mBarChart.getData().notifyDataChanged();
            mBarChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "年化利率(%)");
            set1.setColors(ColorTemplate.MATERIAL_COLORS);

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(0.9f);

            mBarChart.setData(data);
        }
    }
}
