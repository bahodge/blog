package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/home")
    public String welcome() {
        return "home";
    }

    @GetMapping("/home/{name}")
    public String welcome(@PathVariable String name,Model model){
        model.addAttribute("name", name);
        return ("home");
    }

    @GetMapping("/home/users")
    public String welcomeUsers(Model model){
        List<String> users = new ArrayList<>();
        users.add("Bob");
        users.add("Debbie");
        users.add("Steven");
        users.add("Tim");
        users.add("Brandon");
        users.add("Lori-Beth");

        model.addAttribute("users", users);
        return ("home");
    }
}
