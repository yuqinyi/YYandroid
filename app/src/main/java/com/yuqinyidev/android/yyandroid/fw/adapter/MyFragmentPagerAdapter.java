package com.yuqinyidev.android.yyandroid.fw.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yuqinyidev.android.yyandroid.ui.fragment.FragmentMainDiscover;
import com.yuqinyidev.android.yyandroid.ui.fragment.FragmentMainHomePage;
import com.yuqinyidev.android.yyandroid.ui.fragment.FragmentMainMine;
import com.yuqinyidev.android.yyandroid.ui.fragment.FragmentMainNotice;

/**
 * Created by RDX64 on 2017/6/22.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"首页", "发现", "通知", "我的"};

    public MyFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new FragmentMainDiscover();
            case 2:
                return new FragmentMainNotice();
            case 3:
                return new FragmentMainMine();
        }
        return new FragmentMainHomePage();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

}
