package com.springcore.demo;

import com.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController
{
    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach myCoach)
    {
        System.out.println("Inside class " + DemoController.class);
        this.myCoach=myCoach;
    }

    @GetMapping("/workout")
    public String workout()
    {
        return myCoach.getDailyWorkout();
    }

}
