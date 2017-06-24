package com.yuqinyidev.android.yyandroid.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.yuqinyidev.android.yyandroid.R;
import com.yuqinyidev.android.yyandroid.fw.app.YYApp;
import com.yuqinyidev.android.yyandroid.fw.ui.activity.BaseActivity;
import com.yuqinyidev.android.yyandroid.login.presenter.ILoginPresenter;
import com.yuqinyidev.android.yyandroid.login.presenter.LoginPresenter;
import com.yuqinyidev.android.yyandroid.login.view.ILoginView;
import com.yuqinyidev.android.yyandroid.testmvp.view.CheckVersionActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.yuqinyidev.android.yyandroid.R.id.progressBar;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.edt_login_user)
    EditText edtLoginUser;
    @BindView(R.id.edt_login_password)
    EditText edtLoginPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.layout_login)
    LinearLayout loginLayout;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = new LoginPresenter(this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void login() {
        loginPresenter.login(edtLoginUser.getText().toString(), edtLoginPassword.getText().toString());
    }

    @Override
    public void showProgress(boolean enable) {
        if (enable) {
            progressBar.setVisibility(View.VISIBLE);
            loginLayout.setVisibility(View.GONE);
        } else {
            progressBar.setVisibility(View.GONE);
            loginLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showLoginView() {
        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
        CheckVersionActivity.start();
        finish();
    }

    public static void start() {
        Intent intent = new Intent(YYApp.getInstance().getContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        YYApp.getInstance().getContext().startActivity(intent);
    }
}
