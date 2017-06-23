package com.yuqinyidev.android.yyandroid.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuqinyidev.android.yyandroid.R;
import com.yuqinyidev.android.yyandroid.fw.ui.fragment.BaseFragment;
import com.yuqinyidev.android.yyandroid.fw.ui.view.BaseView;

/**
 * Created by RDX64 on 2017/6/22.
 */

public class FragmentMainNotice extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_main_notice, container, false);
        return mRootView;
    }

    @Override
    public View initView() {
        return mRootView;
    }

    @Override
    public void initData() {

    }

}
