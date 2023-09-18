package com.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach
{
    @Override
    public String getDailyWorkout() {
        return "Inside baseball coach";
    }
}
