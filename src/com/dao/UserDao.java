package com.dao;

import com.entity.User;
import com.entity.Vip;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-08 16:15
 **/
public interface UserDao {
    int insert(User user);
    int delete(int id);
    int update(User user);
    List<User> queryAll();
    User queryUserByNameAndPassword(User user);
    User queryUserByUsername(User user);
    //查询当前表的总记录条数
    Integer queryCounts();

    //分页查询
    List<User> queryUserBypage(int begin, int pageSize);


}
