package com.yuqinyidev.android.yyandroid.ui.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yuqinyidev.android.yyandroid.R;
import com.yuqinyidev.android.yyandroid.fw.ui.activity.BaseActivity;
import com.yuqinyidev.android.yyandroid.fw.ui.custom.MyViewPager;
import com.yuqinyidev.android.yyandroid.ui.adapter.MyFragmentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainMenuActivity extends AppCompatActivity {
    @BindView(R.id.view_pager)
    MyViewPager mViewPager;

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_main_menu);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setNoScroll(true);
        mViewPager.setAdapter(myFragmentPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);

        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);
        three = mTabLayout.getTabAt(2);
        four = mTabLayout.getTabAt(3);

        one.setIcon(R.drawable.ic_home_black_24dp);
        two.setIcon(R.drawable.ic_dashboard_black_24dp);
        three.setIcon(R.drawable.ic_notifications_black_24dp);
        four.setIcon(R.drawable.ic_mine_black_24dp);
    }

}
