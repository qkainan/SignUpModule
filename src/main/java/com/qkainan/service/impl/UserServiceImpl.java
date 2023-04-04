package com.qkainan.service.impl;

import com.qkainan.dao.UserDao;
import com.qkainan.domain.User;
import com.qkainan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    public User finById(Integer id) {
        return userDao.findById(id);
    }
}
