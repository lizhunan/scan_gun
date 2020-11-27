package com.ctrl.aop.test;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DemoAspect {
    String TAG = "DemoAspect";

    @Pointcut("execution(* com.ctrl.irrigatedarea.mvp.view.main.MainActivity.onNavigationItemSelected(..))")
    public void logForActivity(){

    }

    @Before("logForActivity()")
    public void log(JoinPoint joinPoint){
        Log.e(TAG,  " aop拦截");
    }

}
