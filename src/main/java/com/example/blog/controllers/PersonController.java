package com.example.blog.controllers;

import com.example.blog.repositories.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    private PersonRepository personDao;

    public PersonController(PersonRepository personDao) {
        this.personDao = personDao;
    }

    @GetMapping(path = "/people")
    public String showPeople(Model model){
        model.addAttribute("people", personDao.findAll());
        return "/people";

    }
}
