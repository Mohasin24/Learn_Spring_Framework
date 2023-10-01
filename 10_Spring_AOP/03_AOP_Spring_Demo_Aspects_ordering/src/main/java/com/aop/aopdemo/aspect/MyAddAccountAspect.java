package com.aop.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyAddAccountAspect
{
    @Before("com.aop.aopdemo.aspect.PointcutDeclarations.forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("==========>>>>> Executing @Before advice on method");
    }
}
