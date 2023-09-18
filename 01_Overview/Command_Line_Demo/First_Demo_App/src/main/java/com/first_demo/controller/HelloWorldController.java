package com.first_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController
{
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
