package com.qkainan.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class PageJump {

    @RequestMapping("/pageJumpToSuccess")
    public String pageJumpToSuccess(){
        return "redirect:/success.jsp";
    }

}
