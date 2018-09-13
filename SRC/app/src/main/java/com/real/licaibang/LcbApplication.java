package com.real.licaibang;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

import timber.log.Timber;


/**
 * Created by dhc on 2017/2/11.
 */

public class LcbApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        //初始化bugly -- 异常监控
        CrashReport.initCrashReport(LcbApplication.this, "76313c2c90", true);
    }
}
