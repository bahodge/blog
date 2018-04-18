package com.example.blog.controllers;


import com.example.blog.services.StringTransformService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServiceTestController {
    private StringTransformService strSvc;

    public ServiceTestController(StringTransformService strSvc) {
        this.strSvc = strSvc;
    }

    @GetMapping("/word/{word}")
    @ResponseBody
    public String returnFirstLetter(@PathVariable String word){
        String firstLetter = strSvc.getFirstLetter(word);
        return "The first letter is: " + firstLetter;
    }

}
