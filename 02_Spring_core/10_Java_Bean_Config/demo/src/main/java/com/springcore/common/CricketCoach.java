package com.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach
{
    public CricketCoach()
    {
        System.out.println("Inside class + " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Inside the cricket coach";
    }
}
