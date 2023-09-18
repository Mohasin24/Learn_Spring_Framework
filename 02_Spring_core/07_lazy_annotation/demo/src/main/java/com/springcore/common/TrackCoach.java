package com.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach
{
    public TrackCoach()
    {
        System.out.println("Inside class + " + TrackCoach.class);
    }
    @Override
    public String getDailyWorkout() {
        return "Inside track coach";
    }
}
