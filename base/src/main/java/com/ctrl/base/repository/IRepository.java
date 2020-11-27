package com.ctrl.base.repository;

public interface IRepository {

    /**
     * ViewModel销毁时清除Model，
     * viewModel结束时应及时清除model的绑定
     */
    void onCleared();
}
