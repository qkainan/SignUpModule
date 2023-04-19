package com.qkainan.service;

import com.qkainan.common.PageResult;
import com.qkainan.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

public interface UserService {
    User finById(Integer id);

    List<User> findAll();

    PageResult findByPage(Integer pageSize, Integer pageNum);

    void insertUser(User user) throws IOException;
//    void insertUser(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("hobby")String hobby) throws IOException;

    void deleteUser(Integer id);

    void updateUser(User user);
}
