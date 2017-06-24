package com.yuqinyidev.android.yyandroid.login.contract;

import com.yuqinyidev.android.yyandroid.fw.bean.IBaseBean;
import com.yuqinyidev.android.yyandroid.fw.contract.IBaseContract;
import com.yuqinyidev.android.yyandroid.fw.presenter.IBasePresenter;
import com.yuqinyidev.android.yyandroid.fw.view.IBaseView;
import com.yuqinyidev.android.yyandroid.login.presenter.ILoginPresenter;
import com.yuqinyidev.android.yyandroid.login.view.ILoginView;

/**
 * Created by RDX64 on 2017/6/24.
 */

public class LoginContract implements IBaseContract {

    public interface IView extends ILoginView {
    }

    public interface IPresenter extends ILoginPresenter {
    }

}
