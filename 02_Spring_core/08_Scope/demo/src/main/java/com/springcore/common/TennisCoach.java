package com.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach
{
    public TennisCoach()
    {
        System.out.println("Inside class + " + TennisCoach.class);
    }
    @Override
    public String getDailyWorkout() {
        return "Inside tennis coach";
    }
}
