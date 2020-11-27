package com.ctrl.observe;

import com.ctrl.http.RespModel;

/**
 * 基本回调，可自定义添加
 */
public interface BaseView {
    /**
     * 显示dialog
     */
    void showLoading();
    /**
     * 隐藏 dialog
     */

    void hideLoading();
    /**
     * 显示错误信息
     *
     * @param msg
     */
    void showError(String msg);
    /**
     * 错误码
     */
    void onErrorCode(RespModel model);
}
