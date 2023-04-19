package com.qkainan.dao;

import com.qkainan.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;
@Mapper
public interface UserDao {

    //查询所有用户
    List<User> findAll();


    //根据id查询用户，
    User findById(Integer id);

    //注册时添加用户
    void insertUser(User user) throws IOException;

//    void insertUser(@Param("username")String username, @Param("password")String password, @Param("hobby")String hobby) throws IOException;

    void deleteUser(Integer id);

    void updateUser(User user);
}
