package com.example.blog.controllers;

import com.example.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @GetMapping (path = "/posts")
    public String posts(Model model){
        List<Post> posts = new ArrayList<>();
        Post p1 = new Post("Post 1", "Post 1 body is so cool!!!");
        Post p2 = new Post("Post 2", "Post 2 Body is super neat!");
        posts.add(p1);
        posts.add(p2);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping (path = "/posts/{id}")
    public String onePost(Model model, @PathVariable int id){
        Post post = new Post("My First Post", "This post is so awesome!!!");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @RequestMapping (path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String getCreate(){
        return "'Create' Get Request";
    }

    @RequestMapping (path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost(){
        return "Create a new post";
    }


}
