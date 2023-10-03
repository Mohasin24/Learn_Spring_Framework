package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class DemoLoggingAspect
{
    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // setup pointcut
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage(){}
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow(){}

    // @Before advice
    @Before("forAppFlow()")
    public void beforeAdvice(JoinPoint joinPoint){
        // display method name
        String theMethod = joinPoint.getSignature().toShortString();
        logger.info("=====>>>>> in @Before calling the method : "+theMethod);

        // display the arguments to the method

        // get the arguments
        Object[] args = joinPoint.getArgs();

        //loop through the args
        for (Object obj : args)
        {
            logger.info("=====>>>>> Arguments : " + obj);
        }
    }

    // @After returning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result)
    {
        // display the method we are returning
        String theMethod = joinPoint.getSignature().toShortString();
        logger.info("=====>>>>> in @AfterReturning calling the method : "+theMethod);

        // display data returned
        logger.info("====>>>>>> Result is : " + result);
    }
}
