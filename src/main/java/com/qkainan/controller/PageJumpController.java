package com.qkainan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageJumpController {

    @RequestMapping("/pageJumpToSuccess")
    public ModelAndView pageJumpToSuccess(ModelAndView modelAndView){
        //页面跳转
        modelAndView.setViewName("redirect:/page/success.jsp");
        return modelAndView;
    }

}
