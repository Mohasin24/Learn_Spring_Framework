package com.util;

import com.springcore.common.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach
{
    @Override
    public String getDailyWorkout() {
        return "Run for 15 min";
    }
}
