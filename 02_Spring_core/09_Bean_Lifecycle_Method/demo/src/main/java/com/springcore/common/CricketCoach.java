package com.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach
{
    //post
    @PostConstruct
    public void doStartUpStuff()
    {
        System.out.println("In doStartUpStuff method of " + getClass().getSimpleName());

    }

    //pre
    @PreDestroy
    public void doCleanUpStuff()
    {
        System.out.println("In doCleanUpStuff method of " + getClass().getSimpleName());
    }

    public CricketCoach()
    {
        System.out.println("Inside class + " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Inside the cricket coach";
    }
}
