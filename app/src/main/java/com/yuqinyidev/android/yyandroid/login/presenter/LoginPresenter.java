package com.yuqinyidev.android.yyandroid.login.presenter;

import com.yuqinyidev.android.yyandroid.login.model.ILoginModel;
import com.yuqinyidev.android.yyandroid.login.model.LoginModel;
import com.yuqinyidev.android.yyandroid.login.view.ILoginView;

/**
 * Created by RDX64 on 2017/6/24.
 */

public class LoginPresenter implements ILoginPresenter {
    private ILoginModel loginModel;

    private ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModel(this);
    }

    @Override
    public void login(String loginUser, String loginPassword) {
        loginView.showProgressDialog();
        loginModel.login(loginUser, loginPassword);
    }

    @Override
    public void loginSucceed() {
        loginView.hideProgressDialog();
        loginView.showLoginView();
    }
}
