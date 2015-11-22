package com.example.service;

import com.example.model.Category;
import com.example.model.User;
import com.example.repository.CategoryRepository;
import com.example.util.DemoConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Knight of k9 on 21/11/2015.
 */
@Service
public class CategoryService {
    private  CategoryRepository categoryRepository;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public  int addCategory(Category c)
    {
        for(Category category: categoryRepository.findByName(c.getName()))
        {
            return DemoConstant.DUPLICATE;
        }
        categoryRepository.save(c);
        return DemoConstant.OK;
    }
    public  int deleteCategory(long id)
    {
        for(Category category: categoryRepository.findById(id))
        {
            categoryRepository.delete(category);
            return DemoConstant.OK;
        }
        return DemoConstant.NOTFOUND;
    }
    public  int updateCategory(Category young)
    {
        for(Category old: categoryRepository.findByName(young.getName()))
        {

            young.setId(old.getId());
            young.setTsCreated(old.getTsCreated());
            categoryRepository.delete(old);
            categoryRepository.save(young);
            return DemoConstant.OK;
        }
        return DemoConstant.NOTFOUND;
    }
    public  List<Category> returnAllCategory()
    {
        List categoryList = new ArrayList<Category>();
        for(Category c:categoryRepository.findAll())
        {
            categoryList.add(c);
        }
        return categoryList;
    }

}