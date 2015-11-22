package com.example.service;

import com.example.model.Post;
import com.example.repository.PostRepository;
import com.example.util.DemoConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Knight of k9 on 21/11/2015.
 */
@Service
public class PostService {
    private final   PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public   int addPost(Post p)
    {
        for(Post post: postRepository.findByTitle(p.getTitle()))
        {
            return DemoConstant.DUPLICATE;
        }
        postRepository.save(p);
        return DemoConstant.OK;
    }
    public   int deletePost(long id)
    {
        for(Post post: postRepository.findById(id))
        {
            postRepository.delete(post);
            return DemoConstant.OK;
        }
        return DemoConstant.NOTFOUND;
    }
    public   int updatePost(Post young)
    {
        for(Post old: postRepository.findByTitle(young.getTitle()))
        {
            young.setId(old.getId());
            young.setTsCreated(old.getTsCreated());
            postRepository.delete(old);
            postRepository.save(young);
            return DemoConstant.OK;
        }
        return DemoConstant.NOTFOUND;
    }
    public   List<Post> returnAllPost()
    {
        List postList = new ArrayList<Post>();
        for(Post p:postRepository.findAll())
        {
            postList.add(p);
        }
        return postList;
    }
    public   List<Post> returnAllPostByCreatedTime()
    {
        List postList = new ArrayList<Post>();
        for(Post p:postRepository.findAllByOrderByTsCreatedDesc())
        {
            postList.add(p);
        }
        return postList;
    }
    public List<Post> returnByTitle(String title)
    {
        List postList = new ArrayList<Post>();
        for(Post p:postRepository.findByTitle(title))
        {
            postList.add(p);
        }
        return postList;

    }
    public List<Post> returnByContent(String content)
    {
        List postList = new ArrayList<Post>();
        for(Post p:postRepository.findByTitle(content))
        {
            postList.add(p);
        }
        return postList;

    }
    public   HashMap returnAllPostGroupByCategory()
    {
        HashMap postList = new HashMap();
        //Do something here

        return postList;

    }

}