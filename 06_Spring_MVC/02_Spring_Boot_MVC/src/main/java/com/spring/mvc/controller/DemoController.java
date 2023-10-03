package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController
{
    @RequestMapping("/")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String showData()
    {
        return "helloworld";
    }

}
