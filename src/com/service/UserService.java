package com.service;

import com.entity.User;
import com.entity.Vip;
import com.utils.Page;

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
    User queryUserByUsername(User user);
    User query(int id);
    //查询当前表的总记录条数
    Integer queryCounts();

    //分页查询
    Page<User> queryByPage(int pageNo, int pageSize);

}
