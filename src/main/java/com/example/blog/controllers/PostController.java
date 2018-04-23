package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.models.User;
import com.example.blog.repositories.PostRepository;
import com.example.blog.repositories.UserRepository;
import com.example.blog.services.PostService;
import javafx.geometry.Pos;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostService postSvc;
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostService postSvc, PostRepository postDao, UserRepository userDao) {
        /*
        In this particular situation. having a Post service does not make sense.
        If the service was calling multiple repositories, it would make more sense.
         */
        this.userDao = userDao;
        this.postSvc = postSvc;
        this.postDao = postDao;
    }

//    public PostController(PostService postSvc) {
//        this.postSvc = postSvc;
//    }

//    All Posts
    @GetMapping (path = "/posts")
    public String posts(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

//  Individual Post
    @GetMapping (path = "/posts/{id}")
    public String show(Model model, @PathVariable long id){
        model.addAttribute("post", postDao.findById(id));
        return "posts/show";
    }

//    Create a post
    @GetMapping (path = "/posts/create")
    public String getCreate(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String createPost(@ModelAttribute Post post){
//        Eventually pulled from session??
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(userDao.findByUsername(user.getUsername()));
        postDao.save(post);
        return "redirect:/posts";
    }

//    Editing a post
    @GetMapping(path = "/posts/{id}/edit")
    public String getEdit(Model model, @PathVariable long id){
        model.addAttribute("post", postDao.findById(id));
        return "/posts/edit";
    }

    @PostMapping(path = "/posts/edit")
    public String handleEdit(@ModelAttribute Post post){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user != null){
            System.out.println(user.getUsername());
            Post editedPost = postDao.findById(post.getId());
            editedPost.setTitle(post.getTitle());
            editedPost.setBody(post.getBody());
            editedPost.setUser(userDao.findByUsername(user.getUsername()));
            postDao.save(editedPost);
            return "redirect:/posts";
        } else {
            return "/posts";
        }
    }

    @PostMapping(path = "/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        postDao.delete(id);
        return "redirect:/posts";
    }


}
