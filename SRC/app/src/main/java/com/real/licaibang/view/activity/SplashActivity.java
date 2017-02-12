package com.real.licaibang.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.real.licaibang.R;

/**
 * Created by dhc on 2017/2/11.
 */

public class SplashActivity extends BaseActivity {

    //延迟两秒
    private final int SPLASH_DISPLAY_TIME = 2 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);


        //2秒后跳到主页面
        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_TIME);
    }
}
