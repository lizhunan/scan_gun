package com.ctrl.observe;


import com.ctrl.http.RespModel;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

public abstract class BaseObserver<T> extends DisposableObserver<RespModel<T>> {

    protected RespModel<T> respModel;
    private BaseView baseView;

    public BaseObserver(BaseView view) {
        this.baseView = view;
    }

    @Override
    protected void onStart() {
        if (baseView != null) {
            baseView.showLoading();
        }
    }

    @Override
    public void onNext(RespModel<T> tRespModel) {
        if (baseView != null) {
            baseView.hideLoading();
        }
        respModel = tRespModel;
        if (respModel != null) {
            if (respModel.isSuccess()) {
                if (tRespModel.getData() != null) {
                    onSuccess(tRespModel.getData());
                } else if (tRespModel.getDataList() != null) {
                    onSuccess(tRespModel.getDataList());
                } else {
                    onSuccess(tRespModel.getData());
                }
            } else {
                onFailed(respModel.getMsg());
            }
        } else {
            onFailed("返回json数据错误");
        }
    }

    @Override
    public void onError(Throwable e) {
        onFailed(e.getLocalizedMessage());
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T model);

    public abstract void onSuccess(List<T> model);

    public abstract void onFailed(String msg);
}
