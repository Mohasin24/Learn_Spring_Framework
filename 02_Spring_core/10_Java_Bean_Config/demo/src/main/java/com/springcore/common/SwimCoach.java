package com.springcore.common;

public class SwimCoach implements Coach
{
    public SwimCoach()
    {
        System.out.println("Inside the " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim for 1000 meters";
    }
}
