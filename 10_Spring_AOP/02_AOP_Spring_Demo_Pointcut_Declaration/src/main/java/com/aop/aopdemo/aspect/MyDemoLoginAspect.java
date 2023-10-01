package com.aop.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect
{
    // for all methods with any number of and any type of parameters
    @Pointcut("execution(* com.aop.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    // for getter methods
    @Pointcut("execution(* com.aop.aopdemo.dao.*.get* (..))")
    private void getter(){}

    // for setter methods
    @Pointcut("execution(* com.aop.aopdemo.dao.*.set* (..))")
    private void setter(){}

    // Exclude getters and setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void excludeGettersAndSetters(){}

    @Before("excludeGettersAndSetters()")
    public void beforeOperation(){
        System.out.println("\n==========>>>>> Executing @Before advice on method's");
    }














//
////    @Before("forDaoPackage()")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n==========>>>>> Executing @Before advice on method");
//    }
//
////    @Before("forDaoPackage()")
//    public void performApiAnalytics(){
//        System.out.println("==========>>>>> Performing API analytics");
//    }
}
