package com.qkainan.service.impl;

import com.qkainan.dao.UserDao;
import com.qkainan.domain.User;
import com.qkainan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User finById(Integer id) {
        return userDao.findById(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }



    public void insertUser(User user) throws IOException {
        userDao.insertUser(user);
    }

//    public void insertUser(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("hobby")String hobby) throws IOException {
//        userDao.insertUser(username, password, hobby);
//    }
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }


}
