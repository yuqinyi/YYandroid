package com.yuqinyidev.android.yyandroid.trainingdiary.bean;

import com.yuqinyidev.android.yyandroid.fw.bean.BaseBean;

/**
 * Created by RDX64 on 2017/6/23.
 */

public class UserBean extends BaseBean {
    private String mFirstName;
    private String mLastName;

    public UserBean(String firstName, String lastName) {
        this.mFirstName = firstName;
        this.mLastName = lastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }
}
