package com.yuqinyidev.android.yyandroid.trainingdiary.model;

import com.yuqinyidev.android.yyandroid.trainingdiary.bean.UserBean;

/**
 * Created by RDX64 on 2017/6/23.
 */

public class UserModel implements IUserModel {
    private int id;
    private String first;
    private String last;

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public void setFirstName(String firstName) {
        this.first = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.last = lastName;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public UserBean load(int id) {
        if (id == this.id) {
            return new UserBean(this.first, this.last);
        }
        return null;
    }
}
