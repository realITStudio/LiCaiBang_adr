package com.real.licaibang.chart;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.DecimalFormat;

import timber.log.Timber;

/**
 * Created by dhc on 2017/2/12.
 */

public class MyAcisValueFormatter implements IAxisValueFormatter {
    private DecimalFormat mFormat;

    public MyAcisValueFormatter() {
        mFormat = new DecimalFormat("###,###,###,##0.0");
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        Timber.e(value+"  =");
        return mFormat.format(value);
    }
}