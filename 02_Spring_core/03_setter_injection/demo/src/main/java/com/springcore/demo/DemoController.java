package com.springcore.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController
{
    private Coach myCoach;

    @Autowired
    public void setMyCoach(Coach myCoach)
    {
        this.myCoach=myCoach;
    }

    @GetMapping("/workout")
    public String workout()
    {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/fortune")
    public String fortune()
    {
        return "Today is your lucky day!";
    }
}
