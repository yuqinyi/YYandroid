package com.yuqinyidev.android.yyandroid.trainingdiary.presenter;

import com.yuqinyidev.android.yyandroid.trainingdiary.bean.UserBean;
import com.yuqinyidev.android.yyandroid.trainingdiary.model.IUserModel;
import com.yuqinyidev.android.yyandroid.trainingdiary.model.UserModel;
import com.yuqinyidev.android.yyandroid.trainingdiary.view.IUserView;

/**
 * Created by RDX64 on 2017/6/23.
 */

public class UserPresenter {
    private IUserView mUserView;
    private IUserModel mUserModel;

    public UserPresenter(IUserView view) {
        mUserView = view;
        mUserModel = new UserModel();
    }

    public void saveUser(int id, String firstName, String lastName) {
        mUserModel.setID(id);
        mUserModel.setFirstName(firstName);
        mUserModel.setLastName(lastName);
    }

    public void loadUser(int id) {
        UserBean user = mUserModel.load(id);
        if (user != null) {
            mUserView.setFirstName(user.getFirstName());
            mUserView.setLastName(user.getLastName());
        }
    }
}
