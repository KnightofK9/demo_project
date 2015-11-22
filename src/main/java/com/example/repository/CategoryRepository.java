package com.example.repository;

import com.example.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Knight of k9 on 21/11/2015.
 */
public interface CategoryRepository extends CrudRepository<Category,Long> {
    List<Category> findByName(String name);
    List<Category> findById(Long id);
}
