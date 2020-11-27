package com.ctrl.base.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

public class BaseApplication extends Application {

    private static Application INSTANCE;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        setApplication(this);
    }

    /**
     * 当主工程没有继承BaseApplication时，手动设置
     *
     * @param application
     */
    public static synchronized void setApplication(Application application) {
        INSTANCE = application;
        context = getContext(application);
        //对activity进行监听，用于堆栈式管理
        application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                LifeStackManager.newINSTANCE().addActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                LifeStackManager.newINSTANCE().removeActivity(activity);
            }
        });
    }


    /**
     * 获取当前Application
     *
     * @return application
     */
    public static Application getInstance() {
        if (INSTANCE == null)
            throw new NullPointerException("应该集成BaseApplication或者调用setApplication方法");
        return INSTANCE;
    }

    /**
     * 获取Application上下文
     *
     * @return ApplicationContext
     */
    public static Context getContext(Context context) {
        if (context != null) return context;
        throw new NullPointerException("应该初始化Application");
    }
}
