package com.yuqinyidev.android.yyandroid.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuqinyidev.android.yyandroid.R;
import com.yuqinyidev.android.yyandroid.fw.ui.fragment.BaseFragment;

/**
 * Created by RDX64 on 2017/6/22.
 */

public class FragmentMainMine extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_mine, container, false);
    }

}
