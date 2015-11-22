package com.example.repository;

import com.example.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Knight of k9 on 21/11/2015.
 */
public interface PostRepository extends CrudRepository<Post,Long> {
    List<Post> findById(Long id);
    List<Post> findByTitle(String title);
    List<Post> findByContent(String content);
    List<Post> findAllByOrderByTsCreatedDesc();
    List<Post> findByCategoryName(String name);
    List<Post> findByContentLikeIgnoreCase(String content);
}
