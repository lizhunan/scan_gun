package com.ctrl.aop.log;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.fragment.app.Fragment;

import com.ctrl.aop.permission.PermissionCheck;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;

@Aspect
public class DebugAspectJ {

    private static DebugTraceListener debugTraceListener;

    public static void setDebugTraceListener(DebugTraceListener debugTraceListener) {
        DebugAspectJ.debugTraceListener = debugTraceListener;
    }

    @Pointcut("execution(* android.app.Activity+.onCreate(..))")
    public void activityPointcut() {
    }

    @Pointcut("execution(@com.ctrl.aop.log.Analyze * *(..))")
    public void aspectAnalyzeAnnotation() {
    }

    @Pointcut("execution(@com.ctrl.aop.log.DebugLog * *(..))")
    public void aspectDebugLogAnnotation() {
    }

    @Around("aspectAnalyzeAnnotation()")
    public void analyze(ProceedingJoinPoint joinPoint) throws Throwable {
        Object target = joinPoint.getTarget();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Analyze analyze = methodSignature.getMethod().getAnnotation(Analyze.class);
        long startTimeMillis = System.currentTimeMillis();
        joinPoint.proceed();
        if (debugTraceListener != null) {
            debugTraceListener.onAspectAnalyze(joinPoint, analyze, methodSignature, System.currentTimeMillis() - startTimeMillis);
        }
    }

    @Around("aspectDebugLogAnnotation() || activityPointcut()")
    public void debugLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTimeMillis = System.currentTimeMillis();
        joinPoint.proceed();
        long duration = System.currentTimeMillis() - startTimeMillis;
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        SourceLocation location = joinPoint.getSourceLocation();
        String message = String.format("%s(%s:%s) [%sms]", methodSignature.getMethod().getName(),
                location.getFileName(), location.getLine(), duration);
        if (debugTraceListener != null) {
            debugTraceListener.logger("DebugAspectJ_TRACE", message);
        } else {
            Log.e("DebugAspectJ_TRACE_NULL", message);
        }
    }

}
