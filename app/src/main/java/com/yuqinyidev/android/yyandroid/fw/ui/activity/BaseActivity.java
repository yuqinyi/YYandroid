package com.yuqinyidev.android.yyandroid.fw.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.yuqinyidev.android.yyandroid.R;
import com.yuqinyidev.android.yyandroid.fw.app.YYApp;
import com.yuqinyidev.android.yyandroid.fw.presenter.BasePresenter;
import com.yuqinyidev.android.yyandroid.fw.view.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by RDX64 on 2017/6/23.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements IBaseView {
    protected T mPresenter;
    protected Activity mContext;
    private Unbinder mUnbinder;

    public enum TransitionMode {
        LEFT, RIGHT, TOP, BOTTOM, SCALE, FADE
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (toggleOverridePendingTransition()) {
            switch (getOverridePendingTransitionMode()) {
                case LEFT:
                    overridePendingTransition(R.anim.left_in, R.anim.left_out);
                    break;
                case RIGHT:
                    overridePendingTransition(R.anim.right_in, R.anim.right_out);
                    break;
                case TOP:
                    overridePendingTransition(R.anim.top_in, R.anim.top_out);
                    break;
                case BOTTOM:
                    overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);
                    break;
                case SCALE:
                    overridePendingTransition(R.anim.scale_in, R.anim.scale_out);
                    break;
                case FADE:
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    break;
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        mUnbinder = ButterKnife.bind(this);
        mContext = this;

        createPresenter();

        if (mPresenter != null)
            mPresenter.attachView(this);
        YYApp.getInstance().addActivity(this);
        initEventAndData();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
        mUnbinder.unbind();
        YYApp.getInstance().removeActivity(this);
    }

    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    protected abstract int getLayout();

    protected abstract void initEventAndData();

    protected abstract boolean toggleOverridePendingTransition();

    protected abstract TransitionMode getOverridePendingTransitionMode();

    protected abstract void createPresenter();

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
