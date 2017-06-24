package com.yuqinyidev.android.yyandroid.login.presenter;

/**
 * Created by RDX64 on 2017/6/24.
 */

public interface ILoginPresenter {
    void login(String loginUser, String loginPassword);

    void loginSucceed();
}
