package com.example.service;


import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.util.DemoConstant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Knight of k9 on 21/11/2015.
 */
@Service
 public class UserService
{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public  int addUser(User u)
    {
        for(User user: userRepository.findByName(u.getName()))
        {
            return DemoConstant.DUPLICATE;
        }
        userRepository.save(u);
        return DemoConstant.OK;
    }
    public  int deleteUser(long id)
    {
        for(User user: userRepository.findById(id))
        {
            userRepository.delete(user);
            return DemoConstant.OK;
        }
        return DemoConstant.NOTFOUND;
    }
    public  int updateUser(User young)
    {
        for(User old: userRepository.findByName(young.getName()))
        {
            young.setId(old.getId());
            young.setTsCreated(old.getTsCreated());
            userRepository.delete(old);
            userRepository.save(young);
            return DemoConstant.OK;
        }
        return DemoConstant.NOTFOUND;
    }
    public  List<User> returnAllUser()
    {
        List userList = new ArrayList<User>();
        for(User u:userRepository.findAll())
        {
            userList.add(u);
        }
        return userList;
    }

}
