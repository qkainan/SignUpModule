package com.qkainan.dao;

import com.qkainan.domain.User;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    //查询所有用户
    List<User> findAll();

    //根据id查询用户，
    User findById(Integer id);

    //根据用户名查询用户，
    User findByUsername(String username);

    //注册时添加用户
    void insert(@Param("username") String username,@Param("password")String password,@Param("hobby")String hobby) throws IOException;
}
