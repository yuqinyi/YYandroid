package com.yuqinyidev.android.yyandroid.login.model.impl;

import android.os.Handler;

import com.yuqinyidev.android.yyandroid.fw.utils.LogUtils;
import com.yuqinyidev.android.yyandroid.login.model.ILoginModel;
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
                LogUtils.d("LoginModel", "user: " + loginUser + "\tpassword: " + loginPassword);
                presenter.loginSucceed();
            }
        }, 2000);
    }
}
