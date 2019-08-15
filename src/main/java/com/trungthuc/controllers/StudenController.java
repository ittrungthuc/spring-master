package com.trungthuc.controllers;

import com.trungthuc.domains.Student;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController

public class StudenController {

    @PostMapping(value = "/student")
    public Student createStudent(@Valid @RequestBody Student student){
       try {
           System.out.println("student = " + student);
           return student;
       }catch (Exception e){
           e.getStackTrace();
           return null;
       }

    }
}
