package com.yuqinyidev.android.yyandroid.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuqinyidev.android.yyandroid.R;
import com.yuqinyidev.android.yyandroid.fw.ui.fragment.BaseFragment;
import com.yuqinyidev.android.yyandroid.fw.ui.view.BaseView;
import com.yuqinyidev.android.yyandroid.ui.adapter.AppIconAdapter;
import com.yuqinyidev.android.yyandroid.ui.dto.AppIcon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RDX64 on 2017/6/22.
 */

public class FragmentMainHome extends BaseFragment {
    private List<AppIcon> mAppIconList = new ArrayList<>();

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAppIcons();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_main_home, container, false);
        mUnbinder = ButterKnife.bind(this, mRootView);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 5);
        mRecyclerView.setLayoutManager(layoutManager);
        AppIconAdapter adapter = new AppIconAdapter(mAppIconList);
        mRecyclerView.setAdapter(adapter);
        return mRootView;
    }

    @Override
    public View initView() {
        return mRootView;
    }

    @Override
    public void initData() {
    }

    private void initAppIcons() {
        for (int i = 0; i < 1; i++) {
            mAppIconList.add(new AppIcon("训练日志", R.drawable.apple_pic));
//            mAppIconList.add(new AppIcon(getRandomlengthName("Apple"), R.drawable.apple_pic));
//            mAppIconList.add(new AppIcon(getRandomlengthName("Banana"), R.drawable.banana_pic));
//            mAppIconList.add(new AppIcon(getRandomlengthName("Orange"), R.drawable.orange_pic));
//            mAppIconList.add(new AppIcon(getRandomlengthName("Watermelon"), R.drawable.watermelon_pic));
//            mAppIconList.add(new AppIcon(getRandomlengthName("Pear"), R.drawable.pear_pic));
//            mAppIconList.add(new AppIcon(getRandomlengthName("Grape"), R.drawable.grape_pic));
//            mAppIconList.add(new AppIcon(getRandomlengthName("Pineapple"), R.drawable.pineapple_pic));
//            mAppIconList.add(new AppIcon(getRandomlengthName("Strawberry"), R.drawable.strawberry_pic));
//            mAppIconList.add(new AppIcon(getRandomlengthName("Cherry"), R.drawable.cherry_pic));
//            mAppIconList.add(new AppIcon(getRandomlengthName("Mango"), R.drawable.mango_pic));
        }
    }

    private String getRandomlengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(name);
        }
        return stringBuilder.toString();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
