package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String rollDice(){
        return ("dice");
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(Model model, @PathVariable int guess){
//        Make a random number based on that number of dice
        model.addAttribute("guess", guess);
        int num = (int) Math.floor(Math.random() * 6) + 1;
        model.addAttribute("num", num);
        return ("dice");
    }
}
