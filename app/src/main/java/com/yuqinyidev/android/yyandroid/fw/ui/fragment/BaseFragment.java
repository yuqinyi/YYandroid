package com.yuqinyidev.android.yyandroid.fw.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuqinyidev.android.yyandroid.fw.ui.view.BaseView;
import com.yuqinyidev.android.yyandroid.fw.utils.LogUtil;

import butterknife.Unbinder;

/**
 * Created by RDX64 on 2017/6/23.
 */

public abstract class BaseFragment extends Fragment {
    public Context mContext;

    protected Unbinder mUnbinder;
    protected View mRootView;
    protected boolean isVisible;

    private boolean isPrepared;
    private boolean isFirst = true;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        Log.d("TAG", "fragment->setUserVisibleHint");
        if (getUserVisibleHint()) {
            isVisible = true;
            lazyLoad();
        } else {
            isVisible = false;
            onInvisible();
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        setHasOptionsMenu(true);
//        Log.d("TAG", "fragment->onCreate");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = initView();
        }
//        Log.d("TAG", "fragment->onCreateView");
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Log.d("TAG", "fragment->onActivityCreated");
        isPrepared = true;
        lazyLoad();
    }

    protected void lazyLoad() {
        if (!isPrepared || !isVisible || !isFirst) {
            return;
        }
        LogUtil.d("TAG", getClass().getName() + "->initData()");
        initData();
        isFirst = false;
    }

    //do something
    protected void onInvisible() {
    }

    public abstract View initView();

    public abstract void initData();
}
