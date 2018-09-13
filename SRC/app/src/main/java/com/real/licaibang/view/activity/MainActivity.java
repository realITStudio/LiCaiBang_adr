package com.real.licaibang.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.real.licaibang.R;
import com.real.licaibang.view.fragment.MarketFragment;
import com.real.licaibang.view.fragment.MineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.rgp_main_navigation)
    RadioGroup mNavigationRgp;
    @BindView(R.id.rbn_main_market)
    RadioButton mMarketRbn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMarketRbn.setChecked(true);
        //默认 行情Fragment
        setFragment(new MarketFragment());
        mNavigationRgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.rbn_main_market:
                        Timber.e("toMarketFragment");

                        setFragment(new MarketFragment());
                        break;
                    case R.id.rbn_main_mine:
                        Timber.e("toMineFragment");

                        setFragment(new MineFragment());
                        break;
                }

            }
        });
    }


    //切换指定 Fragment
    private void setFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flout_main_fragment, fragment).commit();
    }

}
