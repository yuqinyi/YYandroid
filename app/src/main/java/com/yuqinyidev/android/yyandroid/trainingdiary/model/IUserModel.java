package com.yuqinyidev.android.yyandroid.trainingdiary.model;

import com.yuqinyidev.android.yyandroid.trainingdiary.bean.UserBean;

/**
 * Created by RDX64 on 2017/6/23.
 */

public interface IUserModel {
    void setID(int id);

    void setFirstName(String firstName);

    void setLastName(String lastName);

    int getID();

    UserBean load(int id);// 通过id读取user信息,返回一个UserBean
}
