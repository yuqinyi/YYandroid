package com.yuqinyidev.android.yyandroid.fw.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by RDX64 on 2017/6/23.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

}
