package com.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach
{
    @Override
    public String getDailyWorkout() {
        return "Inside track coach";
    }
}
