package com.aop.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect
{
    @Before("com.aop.aopdemo.aspect.PointcutDeclarations.forDaoPackage()")
    public void beforeOperation(JoinPoint joinPoint){
        System.out.println("\n==========>>>>> Executing @Before advice on method's");

        //get method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method Signature : " + methodSignature );

        // get method arguments

        Object[] objects = joinPoint.getArgs();

        for(Object obj : objects)
        {
            System.out.println("Argument : " + obj );
        }
    }

}
