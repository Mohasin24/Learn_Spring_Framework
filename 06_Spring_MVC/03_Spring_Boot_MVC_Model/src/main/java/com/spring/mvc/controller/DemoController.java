package com.spring.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/processForm-V2")
    public String shoutoutMeth(HttpServletRequest request, Model model)
    {
        // get the request parameter from the html form
        String name = request.getParameter("studentName");

        // convert data to uppercase
        name = name.toUpperCase();

        // create the message
        String result = "Yo! " + name;

        //add message to the model
        model.addAttribute("message",result);

        return "helloworld";
    }
}
