package com.springcore.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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
