package com.yuqinyidev.android.yyandroid.testmvp.bean;

import com.yuqinyidev.android.yyandroid.fw.bean.IBaseBean;

/**
 * Created by RDX64 on 2017/6/24.
 */

public class VersionBean implements IBaseBean {
    private String code;
    private String login;
    private String type;

    public String getLogin() {
        return login;
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }
}