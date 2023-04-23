package com.qkainan.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从session中获取用户名，判断是否存在
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if(StringUtils.isEmpty(username)){
            //如果获取不到说明未登录 ，重定向跳转到注册、登录页面
            String contextPath = request.getServletContext().getContextPath();
            response.sendRedirect(contextPath+"/index.jsp");
        }else{
            //如果获取到了，说明之前登录过。放行。
            return true;
        }
        return false;
    }
}

