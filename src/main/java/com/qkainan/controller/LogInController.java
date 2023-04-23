package com.qkainan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogInController {

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session){
        //往session域中写入用户名用来代表登录成功
        session.setAttribute("username",username);
        return "/page/success.jsp";
    }
}
