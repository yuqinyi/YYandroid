package com.yuqinyidev.android.yyandroid.login.model;

import android.os.Handler;
import android.util.Log;

import com.blankj.utilcode.util.LogUtils;
import com.yuqinyidev.android.yyandroid.fw.utils.LogUtil;
import com.yuqinyidev.android.yyandroid.login.presenter.ILoginPresenter;

/**
 * Created by RDX64 on 2017/6/24.
 */

public class LoginModel implements ILoginModel {
    private ILoginPresenter presenter;

    private Handler mHandler = new Handler();

    public LoginModel(ILoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void login(final String loginUser, final String loginPassword) {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                LogUtil.d("LoginModel", "user: " + loginUser + "\tpassword: " + loginPassword);
                presenter.loginSucceed();
            }
        }, 2000);
    }
}
