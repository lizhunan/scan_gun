package com.ctrl.aop.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public interface DebugTraceListener {
    void logger(String tag, String message);

    void onAspectAnalyze(ProceedingJoinPoint joinPoint, Analyze analyze, MethodSignature methodSignature, long duration);
}
