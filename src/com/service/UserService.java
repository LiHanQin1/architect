package com.service;

import com.entity.User;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-08 16:14
 **/
public interface UserService {
    int insert(User user);
    int delete(int id);
    int update(User user);
    List<User> queryAll();
    User queryUserByNameAndPassword(User user);
}
