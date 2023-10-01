package com.aop.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyNoGettersAndSettersAspect
{
//    @Before("excludeGettersAndSetters()")
    public void beforeOperation(){
        System.out.println("\n==========>>>>> Executing @Before advice on method's");
    }
}
