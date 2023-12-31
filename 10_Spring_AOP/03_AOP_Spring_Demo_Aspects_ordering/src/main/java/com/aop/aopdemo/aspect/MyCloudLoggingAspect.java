package com.aop.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLoggingAspect
{
    @Before("com.aop.aopdemo.aspect.PointcutDeclarations.forDaoPackage()")
    public void logToCloud(){
        System.out.println("==========>>>>> Logging to cloud");
    }
}
