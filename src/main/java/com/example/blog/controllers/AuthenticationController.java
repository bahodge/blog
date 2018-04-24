package com.example.blog.controllers;

import com.example.blog.models.User;
import com.example.blog.repositories.PostRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    private PostRepository postDao;

    public AuthenticationController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }

    @GetMapping(path = "/profile")
    public String showProfile(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user == null){
            return "users/login";
        } else {
            model.addAttribute("posts", postDao.findByUserId(user.getId()));
            return "users/profile";
        }
    }
}
