package com.yuqinyidev.android.yyandroid.fw.contract;

import com.yuqinyidev.android.yyandroid.fw.bean.IBaseBean;
import com.yuqinyidev.android.yyandroid.fw.presenter.BasePresenter;
import com.yuqinyidev.android.yyandroid.fw.presenter.IBasePresenter;
import com.yuqinyidev.android.yyandroid.fw.view.IBaseView;

/**
 * Created by RDX64 on 2017/6/24.
 */

public interface IBaseContract {

    interface View extends IBaseView {
        void showUpdateDialog(IBaseBean bean);

        void showProgressDialog();

        void hideProgressDialog();

        void showToast(String message);
    }

    interface Presenter extends IBasePresenter<View> {
        void checkVersion(String currentVersion);
    }

}
