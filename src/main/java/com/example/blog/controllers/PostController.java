package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.services.PostService;
import javafx.geometry.Pos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    PostService postSvc;

    public PostController(PostService postSvc) {
        this.postSvc = postSvc;
    }

    @GetMapping (path = "/posts")
    public String posts(Model model){
        model.addAttribute("posts", postSvc.getAllPosts());
        return "posts/index";
    }

    @GetMapping (path = "/posts/{id}")
    public String show(Model model, @PathVariable long id){
        model.addAttribute("post", postSvc.getPost(id));
        return "posts/show";
    }

    @GetMapping (path = "/posts/create")
    public String getCreate(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String createPost(@ModelAttribute Post post){
        postSvc.save(post);
        return "redirect:/posts";
    }


}
