package com.aop.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneServiceImpl implements TrafficFortuneService
{

    @Override
    public String getFortune()
    {
        // delay the application
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Expect heavy traffic this morning.";
    }

    @Override
    public String getFortune(boolean tripWire)
    {
        if(tripWire)
        {
            throw new RuntimeException("Major accident! The highway is closed.");
        }
        return getFortune();
    }
}
