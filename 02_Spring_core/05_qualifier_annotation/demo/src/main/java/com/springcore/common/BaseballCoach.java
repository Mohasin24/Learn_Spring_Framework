package com.springcore.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("jjj")
public class BaseballCoach implements Coach
{
    @Override
    public String getDailyWorkout() {
        return "Inside baseball coach";
    }
}
