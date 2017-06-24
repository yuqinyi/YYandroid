package com.yuqinyidev.android.yyandroid.testmvp.presenter;


import com.yuqinyidev.android.yyandroid.fw.common.Constant;
import com.yuqinyidev.android.yyandroid.fw.presenter.BasePresenter;
import com.yuqinyidev.android.yyandroid.testmvp.contract.MainContract;
import com.yuqinyidev.android.yyandroid.testmvp.response.BaseResponse;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by RDX64 on 2017/6/24.
 */

public class MainPresenterImpl extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    private MainContract.View mView;

    interface AppVersionService {
        //https://api.github.com/repos/{owner}/{repo}/contributors
        @GET("/repos/{owner}/{repo}/contributors")
        Observable<List<ContributorBean>> getContributors(
                @Path("owner") String owner,
                @Path("repo") String repo);
    }

    class ContributorBean {
        String login;
        String type;
    }

    @Override
    public void checkVersion(final String currentVersion) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        AppVersionService movieService = retrofit.create(AppVersionService.class);

        movieService.getContributors("square", "retrofit")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<ContributorBean>>() {
                    @Override
                    public void onStart() {
                        mView.showProgressDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.hideProgressDialog();
                        mView.showToast("请求出错" + e.getMessage());
                    }

                    @Override
                    public void onNext(List<ContributorBean> contributorBean) {
                        if (contributorBean != null && contributorBean.size() > 1) {
                            mView.showToast("发现最新版本" + contributorBean.get(0).login);
                        } else {
                            mView.showToast("已经是最新版本");
                        }
                    }
                });
    }

    @Override
    public void attachView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
