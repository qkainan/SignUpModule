package com.qkainan.servlet;

import com.qkainan.dao.UserDao;
import com.qkainan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

    private SqlSession session;

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
        insertUser(req , resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    //获取提交数据
    private User createUser(HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String hobby = req.getParameter("hobby");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setHobby(hobby);
        return user;
    }

    //添加注册对象
    private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //传入对应配置文件的输入流，读取配置文件获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过SqlSessionFactory获取SqlSession对象(理解为一个数据库连接),并用session接受。
        session = sqlSessionFactory.openSession();

        //获取用户填入的数据
        User user = this.createUser(req);

        //获取UserDao实现类对象(Mapper)
        UserDao userDao = session.getMapper(UserDao.class);
        userDao.insert(user.getUsername(), user.getPassword(), user.getHobby().toString());

        //提交事务，释放资源
        session.commit();
        session.close();

        resp.sendRedirect("ok.jsp");
    }

}
