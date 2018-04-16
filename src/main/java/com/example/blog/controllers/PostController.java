package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @RequestMapping (path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String posts(){
        return "Posts Page";
    }

    @RequestMapping (path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String indPost(@PathVariable String id){
        return "This is the page for post #"+ id;
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
