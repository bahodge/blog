package com.example.blog.services;
import com.example.blog.models.Post;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private List<Post> posts;

//    Constructor
    public PostService() {
        this.posts = new ArrayList<>();
//        Creates a new generic posts
        createPosts();
    }

    private void createPosts(){
        posts.add(new Post(1,"Post 1", "Post Description 1"));
        posts.add(new Post(2,"Post 2", "Post Description 2"));
        posts.add(new Post(3,"Post 3", "Post Description 3"));
        posts.add(new Post(4,"Post 4", "Post Description 4"));
    }

    public void save (Post post){
        // Set id based on length
        post.setId(posts.size());
        // Add post to post list
        posts.add(post);
    }

    //    Get full list of posts
    public List<Post> getAllPosts(){
        return posts;
    }
//
////    Find individual post
    public Post getPost(long id){
        return posts.get((int) id - 1);
    }

}
