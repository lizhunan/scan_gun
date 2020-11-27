package com.ctrl.aop.permission;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PermissionCheckAspectJ {

    private static final String TAG = "PermissionCheck";

    @Pointcut("execution(@com.ctrl.aop.permission.PermissionCheck * *(..)) && @annotation(ann)")
    public void checkPermission(PermissionCheck ann) {

    }

    @Around("checkPermission(permissionCheck)")
    public Object check(ProceedingJoinPoint joinPoint, PermissionCheck permissionCheck) throws Throwable {
        if (permissionCheck != null) {
            Context context = null;
            try {
                if (joinPoint.getThis() instanceof Fragment)
                    context = ((Fragment) joinPoint.getThis()).getActivity();
                else
                    context = (Context) joinPoint.getThis();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (context != null) {
                String[] checkStrings = permissionCheck.checkString();
                if (Permission.checkSelfPermission(context, checkStrings))
                    return joinPoint.proceed();
                else {
                    Activity activity = null;
                    if (joinPoint.getThis() instanceof Activity) {
                        activity = (Activity) joinPoint.getThis();
                    } else if (joinPoint.getThis() instanceof Fragment) {
                        activity = ((Fragment) joinPoint.getThis()).getActivity();
                    }
                    Permission.requestPermission(checkStrings, activity);
                    if (permissionCheck.access()) {
                        return joinPoint.proceed();
                    } else {
                        return null;//return null;如果为null则不会继续执行后续任务
                    }

                }
            }
        }
        return joinPoint.proceed();
    }
}
