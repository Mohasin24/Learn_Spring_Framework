package com.aop.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutDeclarations
{
    @Pointcut("execution(* com.aop.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}
    @Pointcut("execution(* com.aop.aopdemo.dao.*.get* (..))")
    public void getter(){}

    // for setter methods
    @Pointcut("execution(* com.aop.aopdemo.dao.*.set* (..))")
    public void setter(){}

    // Exclude getters and setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void excludeGettersAndSetters(){}


}
