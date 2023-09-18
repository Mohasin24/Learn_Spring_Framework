package com.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach
{
    public CricketCoach()
    {
        System.out.println("Inside class + " + CricketCoach.class);
    }
    @Override
    public String getDailyWorkout() {
        return "Inside the cricket coach";
    }
}
