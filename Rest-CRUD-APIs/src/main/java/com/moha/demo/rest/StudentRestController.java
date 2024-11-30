package com.moha.demo.rest;

import com.moha.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Object> getStudents(){

        List<Object> theStudents = new ArrayList<>();

        theStudents.add(new Student("Emily", "Carter"));
        theStudents.add(new Student("Liam", "Johnson"));
        theStudents.add(new Student("Sophia", "Ramirez"));

        return theStudents;
    }
}
