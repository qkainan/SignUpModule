package com.qkainan.controller;

import com.qkainan.aspect.InvokeLog;
import com.qkainan.common.ResponseResult;
import com.qkainan.domain.User;

import com.qkainan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@RestController//This is equivalent to @Controller and @ResponseBody integrated
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    @InvokeLog
    public ResponseResult insertUser(User user) throws IOException {
        userService.insertUser(user);

        return new ResponseResult(200, "Successful operation");
    }


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

        return new ResponseResult(200, "Successful operation");
    }


//    //bug 返回值被放入了响应体中，所以无法实现页面跳转
//    @RequestMapping("/pageJumpToSuccess")
//    private String pageJumpToSuccess(){
//        return "redirect:/success.jsp";
//    }


//    @PostMapping("/register")
//    @InvokeLog
//    public ResponseResult insertUser(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("hobby")String hobby) throws IOException {
//        userService.insertUser(username, password, hobby);
//        return new ResponseResult(200, "Successful operation");
//    }

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
