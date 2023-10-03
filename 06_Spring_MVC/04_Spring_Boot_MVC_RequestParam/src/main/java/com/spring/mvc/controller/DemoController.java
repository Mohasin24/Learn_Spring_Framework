package com.spring.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/processForm-V2")
    public String shoutoutMeth(@RequestParam("studentName")String name, Model model)
    {
        // convert data to uppercase
        name = name.toUpperCase();

        // create the message
        String result = "Hey! " + name + ". How are you?";

        //add message to the model
        model.addAttribute("message",result);

        return "helloworld";
    }
}
