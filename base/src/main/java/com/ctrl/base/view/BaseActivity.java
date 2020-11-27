package com.ctrl.base.view;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.ctrl.base.R;
import com.ctrl.base.databinding.ActivityBaseBinding;
import com.ctrl.base.utils.ClassUtil;
import com.ctrl.base.utils.StatusBarUtil;
import com.ctrl.base.vm.BaseViewModel;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by lizhunan on 2020/2/20
 * Activity基类
 */
public abstract class BaseActivity<V extends ViewDataBinding, VM extends AndroidViewModel> extends AppCompatActivity {

    protected V binding;
    protected VM viewModel;

    protected View errorView;
    protected View loadingView;
    protected CompositeDisposable compositeDisposable;
    protected ActivityBaseBinding baseBinding;

    /**
     * 填充当前fragment
     */
    protected Fragment currentFragment = new Fragment();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
         * 回调其他设置
         * */
        initView();
        initViewModel();
        setListener();
        initData();
    }

    @Override
    public void setContentView(int layoutResID) {
        initStatusBar();
        /*
         * 初始化布局文件
         * */
        baseBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_base, null, false);
        binding = DataBindingUtil.inflate(getLayoutInflater(), layoutResID, null, false);
        /*
         * 初始化布局
         * */
        RelativeLayout.LayoutParams params = new RelativeLayout
                .LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        binding.getRoot().setLayoutParams(params);
        RelativeLayout container = baseBinding.getRoot().findViewById(R.id.container);
        container.addView(binding.getRoot());
        getWindow().setContentView(baseBinding.getRoot());
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.fontScale != 1) {
            getResources();
        }
    }

    /**
     * 禁止改变字体大小
     */
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.compositeDisposable != null && !compositeDisposable.isDisposed()) {
            // clear 和 dispose的区别是：  disposed = true;
            this.compositeDisposable.clear();
        }
        if (binding != null) binding.unbind();
    }


    /**
     * 手动给View初始化
     *
     * @param id  View R.id
     * @param <T> View类型
     * @return View类型
     */
    protected <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    /**
     * 沉浸状态栏
     */
    private void initStatusBar() {
        //StatusBarUtil.setColor(this, color, 0);
        // 透明状态栏
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    /**
     * 设置是否为浸入式状态栏
     *
     * @param i true浸入式，false默认
     */
    protected void setImmersiveBar(boolean i) {
        if (i) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.hide();
            }
        }
    }

    /**
     * 初始化ViewModel
     */
    private void initViewModel() {
        Class<VM> viewModelClass = ClassUtil.getViewModel(this);
        if (viewModelClass != null) {
            this.viewModel = ViewModelProviders.of(this).get(viewModelClass);
        }
    }

    public void addSubscription(Disposable s) {
        if (this.compositeDisposable == null) {
            this.compositeDisposable = new CompositeDisposable();
        }
        this.compositeDisposable.add(s);
    }

    public void removeDisposable() {
        if (this.compositeDisposable != null && !compositeDisposable.isDisposed()) {
            this.compositeDisposable.dispose();
        }
    }


    /**
     * 刷新布局
     */
    protected void refreshLayout() {
    }

    /**
     * 切换fragment
     * 用于优化切换fragment时卡顿现象
     *
     * @param targetFragment 目标fragment
     * @param resId          fragment容器
     * @return FragmentTransaction
     */
    protected FragmentTransaction switchFragment(Fragment targetFragment, int resId) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (!targetFragment.isAdded()) {
            //第一次使用switchFragment()时currentFragment为null，所以要判断一下
            if (currentFragment != null) {
                fragmentTransaction.hide(currentFragment);
            }
            fragmentTransaction.add(resId, targetFragment, targetFragment.getClass().getName());
        } else {
            fragmentTransaction
                    .hide(currentFragment)
                    .show(targetFragment);
        }
        currentFragment = targetFragment;
        return fragmentTransaction;
    }


    protected abstract void initView();

    protected abstract void setListener();

    protected abstract void initData();

}
