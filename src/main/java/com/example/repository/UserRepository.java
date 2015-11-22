package com.example.repository;

import com.example.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by fuck on 11/5/2015.
 */
public interface UserRepository extends CrudRepository<User,Long>
{
    List<User> findByName(String name);
    List<User> findById(Long id);
}

