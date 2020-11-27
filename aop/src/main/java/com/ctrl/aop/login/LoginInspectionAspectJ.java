package com.ctrl.aop.login;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

public class LoginInspectionAspectJ {

    @Pointcut("execution(@com.ctrl.irrigatedarea.base.aop.login.Login * *(..))")
    public void inspectionLogin() {
    }

    @Around("inspectionLogin()")
    public void inspection(ProceedingJoinPoint joinPoint) throws Throwable {

    }

}
