package com.trungthuc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Controller
public class TestController {
    @Autowired
    MessageSource messageSource;

    @GetMapping(value = "/message")
    public String testmesage(){
        return (String) messageSource.getMessage("hello.name.age",new Object[]{"Trung Thuc",18}, Locale.ENGLISH);
    }

    @GetMapping(value = "/axios")
    public String Axios(){
        return "page/home";
    }

}
