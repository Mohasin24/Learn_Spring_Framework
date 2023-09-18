package com.springcore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BaseballCoach implements Coach
{
    public BaseballCoach()
    {
        System.out.println("Inside class + " + BaseballCoach.class);
    }
    @Override
    public String getDailyWorkout() {
        return "Inside baseball coach";
    }
}
