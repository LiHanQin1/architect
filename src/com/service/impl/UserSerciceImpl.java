package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.service.UserService;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-08 16:14
 **/
public class UserSerciceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public User queryUserByNameAndPassword(User user) {
        return userDao.queryUserByNameAndPassword(user);
    }
}
