package com.aop.aopdemo.aspect;

import com.aop.aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MyDemoLoginAspect
{
    @Around("execution(* com.aop.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //print out the method advising on
        System.out.println("\n===>>> afterAdviceFindAccounts on method : " + proceedingJoinPoint.getSignature().toShortString());

        //get begin timestamp
        long begin = System.currentTimeMillis();

        // execute the method
        Object result = null;

        try{
            result = proceedingJoinPoint.proceed();
        }
        catch (Exception exception)
        {
            // get the message
            System.out.println(exception.getMessage());

            // custom message
//            result = "Major accident happened, but no worries AOP will take care all of that.";

            // rethrow the exception
            throw exception;
        }

        // get ent timestamp
        long end = System.currentTimeMillis();

        long duration = end-begin;

        System.out.println("\n====>>>> Duration : " + duration/1000.0 + " seconds");

        return result;
    }


    @After("execution(* com.aop.aopdemo.dao.AccountDao.findAccounts(..))")
    public void afterAdviceFindAccounts(JoinPoint joinPoint){
        // log the method name
        System.out.println("\n===>>> afterAdviceFindAccounts on method : " + joinPoint.getSignature().toShortString());

    }
    @AfterThrowing(
            pointcut = "execution(* com.aop.aopdemo.dao.AccountDao.findAccounts(..))",
            throwing = "exception"
    )
    public void afterThrowingAdviceFindAccounts(JoinPoint joinPoint, Throwable exception)
    {
        // log the method name
        System.out.println("===>>> afterThrowingAdviceFindAccounts on method : " + joinPoint.getSignature().toShortString());

        //log the exception
        System.out.println("===>>> The exception is : " + exception);
    }

    @AfterReturning(
            pointcut = "execution(* com.aop.aopdemo.dao.AccountDao.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningAdvice(JoinPoint joinPoint, List<Account> result)
    {
        System.out.println("===>>> AfterReturningAdvice on method : " + joinPoint.getSignature().toShortString());

        System.out.println("===>>> Result is : " + result);

        //covert the name's to uppercae
        convertToUppercase(result);

        System.out.println("===>>> Result is : " + result);
    }

    private void convertToUppercase(List<Account> result)
    {
        for(Account obj : result)
        {
            //get the name's
            String firstName = obj.getFirstName().toUpperCase();
            String lastName = obj.getLastName().toUpperCase();

            //set the name's
            obj.setFirstName(firstName);
            obj.setLastName(lastName);
        }
    }

    //    @Before("com.aop.aopdemo.aspect.PointcutDeclarations.forDaoPackage()")
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
