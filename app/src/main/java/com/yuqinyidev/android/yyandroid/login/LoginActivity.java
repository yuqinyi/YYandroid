package com.yuqinyidev.android.yyandroid.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yuqinyidev.android.yyandroid.R;
import com.yuqinyidev.android.yyandroid.fw.ui.activity.BaseActivity;
import com.yuqinyidev.android.yyandroid.login.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void showProgress(boolean enable) {

    }

    @Override
    public void showLoginView() {

    }
}
