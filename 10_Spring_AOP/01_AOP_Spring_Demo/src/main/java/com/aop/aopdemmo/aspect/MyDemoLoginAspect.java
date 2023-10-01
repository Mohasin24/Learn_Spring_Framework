package com.aop.aopdemmo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect
{
//    @Before("execution(public void add*())")
//    @Before("execution(* add*(com.aop.aopdemmo.entity.Account))")
//    @Before("execution(* add*(*))")
//    @Before("execution(* add*(..))")
    @Before("execution(* com.aop.aopdemmo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n==========>>>>> Executing @Before advice on method");
    }
}
