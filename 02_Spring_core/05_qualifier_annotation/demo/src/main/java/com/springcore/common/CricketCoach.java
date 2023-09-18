package com.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach
{
    @Override
    public String getDailyWorkout() {
        return "Inside the cricket coach";
    }
}
