package com.yuqinyidev.android.yyandroid.fw.presenter;

import com.yuqinyidev.android.yyandroid.fw.view.IBaseView;

/**
 * Created by RDX64 on 2017/6/23.
 */

public interface IBasePresenter<T extends IBaseView> {
    void attachView(T View);

    void detachView();
}
