package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by fuck on 11/5/2015.
 */
@RestController
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    @ResponseBody
    public int add(@RequestParam(value = "name") String name,
                   @RequestParam(value = "info") String info,
                   @RequestParam(value = "password") String password,
                   @RequestParam(value = "email") String email
    )
    {
        User u = new User(name, info, password, email);
        return userService.addUser(u);

    }

    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    @ResponseBody
    public int update(@RequestParam(value = "name") String name,
                   @RequestParam(value = "info") String info,
                   @RequestParam(value = "password") String password,
                   @RequestParam(value = "email") String email
    )
    {
        User u = new User(name,info,password,email);
        return userService.updateUser(u);
    }

    @RequestMapping(value="/user/delete",method=RequestMethod.POST)
    @ResponseBody
    public int delete(@RequestParam(value = "id") long id)
    {
        return userService.deleteUser(id);
    }

    @RequestMapping(value = "/user")
    @ResponseBody
    public List<User> showAll()
    {
        return userService.returnAllUser();
    }

    @RequestMapping(value = "/user/test",method = RequestMethod.POST)
    @ResponseBody
    public User test(@RequestParam(value = "name") String name,
                   @RequestParam(value = "info") String info,
                   @RequestParam(value = "password") String password,
                   @RequestParam(value = "email") String email
    )
    {
        User u = new User(name, info, password, email);
        return u;

    }
}
