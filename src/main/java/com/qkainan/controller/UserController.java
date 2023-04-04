package com.qkainan.controller;

import com.qkainan.domain.User;
import com.qkainan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController//This is equivalent to @Controller and @ResponseBody integrated
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Integer id){
        User user = userService.finById(id);
        return user;
    }
}
