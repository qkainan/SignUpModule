package com.qkainan.controller;

import com.qkainan.common.PageResult;
import com.qkainan.common.ResponseResult;
import com.qkainan.domain.User;

import com.qkainan.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController//This is equivalent to @Controller and @ResponseBody integrated
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseResult findById(@PathVariable Integer id) {
        User user = userService.finById(id);
        if (user == null) {
            //There is no corresponding user
            return new ResponseResult(500, "User does not exist");
        }
        return new ResponseResult(200, "Successful operation", user);
    }

    @GetMapping("/user")
    public ResponseResult findAll() {
        List<User> list = userService.findAll();
        return new ResponseResult(200, "Successful operation", list);
    }

    @GetMapping("/user/{pageSize}/{pageNum}")
    public ResponseResult findByResult(@PathVariable("pageSize") Integer pageSize, @PathVariable("pageNum") Integer pageNum) {
        PageResult pageResult = userService.findByPage(pageSize, pageNum);
        return new ResponseResult(200, "Successful operation");
    }

    @PostMapping("/register")
    public ResponseResult insertUser(@Param("username")String username, @Param("password")String password, @Param("hobby")String hobby) throws IOException {
        userService.insertUser(username, password, hobby);
        return new ResponseResult(200,"操作成功");
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseResult deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return new ResponseResult(200,"操作成功");
    }

    @PutMapping("/user/update")
    public ResponseResult updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseResult(200,"操作成功");
    }
}
