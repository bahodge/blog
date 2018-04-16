package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
//    Listen for this URL pattern
    @GetMapping("/hello")
//    Fire this function when request received
    @ResponseBody
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/logout")
    @ResponseBody
    public String logout(){
        return "You logged out";
    }

    @RequestMapping(path = "/lights", method = RequestMethod.GET)
    @ResponseBody
    public String lights() {
        return "Lights ON";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable String name) {
        return "Hello " + name;
    }
}
