package com.ctrl.base.app;

import android.app.Activity;

import androidx.fragment.app.Fragment;

import java.util.Stack;

/**
 * 对activity和fragment进行堆栈式管理
 */
public class LifeStackManager {

    private static Stack<Activity> activityStack;
    private static Stack<Fragment> fragmentStack;
    private static LifeStackManager INSTANCE;

    private LifeStackManager() {
    }

    public static LifeStackManager newINSTANCE() {
        if (INSTANCE == null) INSTANCE = new LifeStackManager();
        return INSTANCE;
    }

    public static Stack<Activity> getActivityStack() {
        return activityStack;
    }

    public static Stack<Fragment> getFragmentStack() {
        return fragmentStack;
    }

    /**
     * 添加activity
     *
     * @param activity activity
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) activityStack = new Stack<>();
        activityStack.add(activity);
    }

    /**
     * 移除指定activity
     *
     * @param activity activity
     */
    public void removeActivity(Activity activity) {
        if (activity != null) activityStack.remove(activity);
    }

    /**
     * 检查是否存在activity
     *
     * @return true存在，false不存在
     */
    public boolean isActivity() {
        if (activityStack != null) return !activityStack.isEmpty();
        return false;
    }

    /**
     * 获取当前activity
     *
     * @return activity
     */
    public Activity currentActivity() {
        return activityStack.lastElement();
    }

    /**
     * 获取指定activity
     *
     * @param cls 类名
     * @return activity
     */
    public Activity getActivity(Class<?> cls) {
        if (activityStack != null)
            for (Activity activity :
                    activityStack)
                if (activity.getClass().equals(cls)) return activity;
        return null;
    }

    /**
     * 结束当前activity
     */
    public void finishActivity() {
        finishActivity(activityStack.lastElement());
    }

    /**
     * 结束指定activity
     *
     * @param activity activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null)
            if (!activity.isFinishing())
                activity.finish();
    }

    /**
     * 结束指定类名activity
     *
     * @param cls 类名
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity :
                activityStack)
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }

    }

    /**
     * 结束所有activity
     */
    public void finishAllActivities() {
        for (int i = 0, size = activityStack.size(); i < size; i++)
            if (activityStack.get(i) != null) finishActivity(activityStack.get(i));
        activityStack.clear();
    }

    /**
     * 添加fragment
     *
     * @param fragment fragment
     */
    public void addFragment(Fragment fragment) {
        if (activityStack == null) fragmentStack = new Stack<>();
        fragmentStack.add(fragment);
    }

    /**
     * 移除fragment
     *
     * @param fragment fragment
     */
    public void removeFragment(Fragment fragment) {
        if (fragment != null) fragmentStack.remove(fragment);
    }

    /**
     * 检查是否存在fragment
     *
     * @return true存在，false不存在
     */
    public boolean isFragment() {
        if (fragmentStack != null) return !fragmentStack.isEmpty();
        return false;
    }

    /**
     * 获取当前fragment
     *
     * @return fragment
     */
    public Fragment currentFragment() {
        if (fragmentStack != null) return fragmentStack.lastElement();
        return null;
    }

    /**
     * 退出程序
     */
    public void appExit() {
        try {
            finishAllActivities();
        } catch (Exception e) {
            activityStack.clear();
            e.printStackTrace();
        }
    }
}