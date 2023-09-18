package com.springcore.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("emailNotification")
public class TennisCoach implements Coach
{
    @Override
    public String getDailyWorkout() {
        return "Inside tennis coach";
    }
}
