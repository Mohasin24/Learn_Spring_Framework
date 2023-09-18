package com.rest_api.rest;

import com.rest_api.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController
@RequestMapping("/api")
public class StudentRestController
{
    //first method to popullate the data
//    private static List<Student> list = new ArrayList<>();

//    static {
//        list.add(new Student("Mohasin", "Patel"));
//        list.add(new Student("Ravi", "Sharma"));
//        list.add(new Student("Manoj", "Tiwari"));
//    }

    //Second method to popullate the data
    private List<Student> list;

    @PostConstruct
    private void loadData()
    {
        list = new ArrayList<>();
        this.list.add(new Student("Mohasin", "Patel"));
        this.list.add(new Student("Ravi", "Sharma"));
        this.list.add(new Student("Manoj", "Tiwari"));
    }

    //    @ResponseBody  //when we use only @Controller then we have to use @ResponseBody to return it as response
    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return  list;
    }

    //Return the student at the given Id i.e. use undex here
    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        if((studentId>=list.size()) || (studentId<0))
        {
            throw new StudentNotFoundException("Student id not found : " + studentId );
        }

        return list.get(studentId);
    }
}
