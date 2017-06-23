package com.yuqinyidev.android.yyandroid.fw.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.yuqinyidev.android.yyandroid.R;
import com.yuqinyidev.android.yyandroid.fw.app.ActivityCollector;

import butterknife.ButterKnife;

/**
 * Created by RDX64 on 2017/6/23.
 */

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseCompatActivity";

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: " + getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
