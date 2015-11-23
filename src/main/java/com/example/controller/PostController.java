package com.example.controller;
import com.example.model.FileObject;
import com.example.model.ImgObject;
import com.example.model.Post;
import com.example.model.VidObject;
import com.example.service.PostService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by fuck on 11/5/2015.
 */
@RestController
public class PostController {
    private PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/post/addwithfile",method = RequestMethod.POST)
    @ResponseBody
    public int addWithFile(@RequestParam(value = "title") String title,
                           @RequestParam(value = "content") String content,
                           @RequestParam(value = "ownername") String ownerName,
                           @RequestParam(value = "categoryname") String categoryName,
                           @RequestParam(value = "file")MultipartFile file
                           )
    {
        Post p = new Post(title,content,ownerName,categoryName);
        String filePath="C:\\demo_project\\demo_project\\src\\main\\files";
        String imgPath="C:\\demo_project\\demo_project\\src\\main\\files\\img";
        String path = filePath;
        String fileExt = FilenameUtils.getExtension(file.getOriginalFilename());
        if(fileExt.compareTo("img")==0||fileExt.compareTo("jpg")==0||fileExt.compareTo("png")==0)
        {
            path = imgPath;
        }
        return postService.addPost(p);
    }

    @RequestMapping(value = "/post/add",method = RequestMethod.POST)
    @ResponseBody
    public int add(@RequestParam(value = "title") String title,
                   @RequestParam(value = "content") String content,
                   @RequestParam(value = "ownername") String ownerName,
                   @RequestParam(value = "categoryname") String categoryName
    )
    {
        Post p = new Post(title,content,ownerName,categoryName);
        return postService.addPost(p);
    }

    @RequestMapping(value = "/post/update",method = RequestMethod.POST)
    @ResponseBody
    public int update(@RequestParam(value = "title") String title,
                      @RequestParam(value = "content") String content,
                      @RequestParam(value = "ownername") String ownerName,
                      @RequestParam(value = "categoryname") String categoryName
    )
    {
        Post p = new Post(title,content,ownerName,categoryName);
        return postService.updatePost(p);
    }

    @RequestMapping(value="/post/delete",method=RequestMethod.POST)
    @ResponseBody
    public int delete(@RequestParam(value = "id") long id)
    {
        return postService.deletePost(id);
    }

    @RequestMapping(value = "/post")
    @ResponseBody
    public List<Post> showAll()
    {
        return postService.returnAllPost();
    }

    @RequestMapping(value = "/post/recent")
    @ResponseBody
    public List<Post> showRecent()
    {
        return postService.returnAllPostByCreatedTime();
    }

    @RequestMapping(value = "/post/search",method = RequestMethod.POST)
    @ResponseBody
    public List<Post> showByTitle(@RequestParam(value = "title") String title)
    {
        return postService.returnByTitle(title);}


    @RequestMapping(value = "/post/searchbc",method = RequestMethod.POST)
    @ResponseBody
    public List<Post> showByContent(@RequestParam(value = "content") String content)
    {
        return postService.returnByContent(content);
    }

    @RequestMapping(value = "/post/category")
    @ResponseBody
    public HashMap showByCategory()
    {
        return postService.returnAllPostGroupByCategory();
    }


}
