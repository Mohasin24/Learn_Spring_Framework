package com.spring.mvc.controller;

import com.spring.mvc.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController
{
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;
    @GetMapping("/showStudentForm")
    public String showForm(Model model)
    {
        // create student object
        Student student = new Student();

        // add student to the model
        model.addAttribute("student",student);

        // add countries
        model.addAttribute("countries",countries);

        // add languages
        model.addAttribute("languages",languages);

        // add systems
        model.addAttribute("systems",systems);

        return "student-form.html";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student)
    {
        // log the student data
        System.out.println("First name : "+student.getFirstName());
        System.out.println("Last name : "+student.getLastName());

        return "student-confirmation";
    }
}
