package com.first_demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController
{
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;
    @GetMapping("/teaminfo")
    public String teamInfo()
    {
        return "Coach : " + coachName + ", Team : " + teamName;
    }
    @GetMapping("/hello")
    public String helloWorld()
    {
        return "Hello World SpringBoot Mohasin ";
    }

    @GetMapping("/workout")
    public String workout()
    {
        return "Run for 5km daily";
    }
}
