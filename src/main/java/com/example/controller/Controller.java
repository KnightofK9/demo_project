package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Knight of k9 on 22/11/2015.
 */
@RestController
public class Controller {

    @RequestMapping(value ="/greeting")
    @ResponseBody
    public String greeting()
    {
        return "Welcome to testing page. ";
    }
}
