package com.springcore.demo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach
{
    @Override
    public String getDailyWorkout() {
        return "Run for 15 min";
    }
}
