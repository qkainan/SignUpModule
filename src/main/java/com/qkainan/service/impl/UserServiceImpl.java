package com.qkainan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qkainan.common.PageResult;
import com.qkainan.dao.UserDao;
import com.qkainan.domain.User;
import com.qkainan.service.UserService;
import org.apache.ibatis.annotations.Param;
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

    public PageResult findByPage(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userDao.findAll();
        PageInfo pageInfo = new PageInfo(list);
        PageResult pageResult = new PageResult(pageInfo.getPageNum(), pageInfo.getPageSize(), (int) pageInfo.getTotal(), list);
        return pageResult;
    }

    public void insertUser(@Param("username")String username, @Param("password")String password, @Param("hobby")String hobby) throws IOException {
        userDao.insertUser(username, password, hobby);
    }

    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }


}
