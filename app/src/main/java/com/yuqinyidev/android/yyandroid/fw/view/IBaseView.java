package com.yuqinyidev.android.yyandroid.fw.view;

/**
 * Created by RDX64 on 2017/6/24.
 */

public interface IBaseView {

    void showProgressDialog();

    void hideProgressDialog();

    void showErrorDialog(String msg);

    void showToast(String message);

}
