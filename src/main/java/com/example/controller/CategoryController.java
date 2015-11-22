package com.example.controller;
import com.example.model.Category;
import com.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by fuck on 11/5/2015.
 */
@RestController
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/category/add",method = RequestMethod.POST)
    @ResponseBody
    public int add(@RequestParam(value = "name") String name,
                   @RequestParam(value = "info") String info

    )
    {
        Category c = new Category(name,info);
        return categoryService.addCategory(c);
    }

    @RequestMapping(value = "/category/update",method = RequestMethod.POST)
    @ResponseBody
    public int update(@RequestParam(value = "name") String name,
                      @RequestParam(value = "info") String info
    )
    {
        Category c = new Category(name,info);

        return categoryService.updateCategory(c);
    }

    @RequestMapping(value="/category/delete",method=RequestMethod.POST)
    @ResponseBody
    public int delete(@RequestParam(value = "id") long id)
    {
        return categoryService.deleteCategory(id);
    }

    @RequestMapping(value = "/category")
    @ResponseBody
    public List<Category> showAll()
    {
        return categoryService.returnAllCategory();
    }

}
