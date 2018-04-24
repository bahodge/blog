package com.example.blog.repositories;

import com.example.blog.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository <Post, Long>{
    @Query(value = "SELECT * FROM posts WHERE user_id =:id ", nativeQuery = true)
    Iterable<Post> findByUserId(@Param("id") long id);
    Post findById(long id);
}
