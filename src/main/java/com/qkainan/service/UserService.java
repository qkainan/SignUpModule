package com.qkainan.service;

import com.qkainan.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    User finById(Integer id);

    List<User> findAll();


    void insertUser(User user) throws IOException;
//    void insertUser(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("hobby")String hobby) throws IOException;

    void deleteUser(Integer id);

    void updateUser(User user);
}
