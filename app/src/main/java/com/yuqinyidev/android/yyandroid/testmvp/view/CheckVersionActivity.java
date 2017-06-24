package com.yuqinyidev.android.yyandroid.testmvp.view;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.yuqinyidev.android.yyandroid.R;
import com.yuqinyidev.android.yyandroid.fw.bean.IBaseBean;
import com.yuqinyidev.android.yyandroid.fw.ui.activity.BaseActivity;
import com.yuqinyidev.android.yyandroid.testmvp.bean.VersionBean;
import com.yuqinyidev.android.yyandroid.testmvp.contract.MainContract;
import com.yuqinyidev.android.yyandroid.testmvp.presenter.MainPresenterImpl;

import butterknife.BindView;

/**
 * Created by RDX64 on 2017/6/24.
 */

public class CheckVersionActivity extends BaseActivity<MainPresenterImpl> implements MainContract.View, View.OnClickListener {
    @BindView(R.id.btn_getVersion)
    Button btnGetVersion;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_check_version;
    }

    @Override
    protected void initEventAndData() {
        btnGetVersion.setOnClickListener(this);


    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }

    @Override
    protected void createPresenter() {
        mPresenter = new MainPresenterImpl();
    }


    @Override
    public void showError(String msg) {

    }

    @Override
    public void useNightMode(boolean isNight) {

    }

    @Override
    public void showUpdateDialog(IBaseBean bean) {

    }

    @Override
    public void showProgressDialog() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressDialog() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {
        try {
            PackageManager pm = getPackageManager();
            PackageInfo pi = pm.getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES);
            String versionName = pi.versionName;
            mPresenter.checkVersion(versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
