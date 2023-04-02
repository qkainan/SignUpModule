package com.qkainan.servlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qkainan.dao.UserDao;
import com.qkainan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/userServlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置请求的编码
        req.setCharacterEncoding("utf-8");
        //2.设置响应的编码
        resp.setHeader("Content-Type","test/html;charset=utf-8");
        //获取用户提交的信息
        //TODO 验证用户名的唯一性&检查密码是否符合强度
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //3.获取“感兴趣”
        StringBuilder hobbies = new StringBuilder();
        String[] hobbyArray = req.getParameterValues("hobby");
        if (hobbies != null){
            for (String hobby:hobbyArray) {
                hobbies.append(hobby);
                hobbies.append(",");
            }
        }

        //4.将信息保存到数据库中

    }

    protected void addUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        User users = this.createUsers(req);
        UsersService usersService = new UsersServiceImpl();
        usersService.addUsers(users);
        resp.sendRedirect("ok.jsp");
    }

        //获取提交数据
    protected User createUsers(HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
