package com.dao.impl;

import com.dao.BaseDao;
import com.dao.UserDao;
import com.entity.User;
import com.entity.Vip;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-08 16:16
 **/
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public int insert(User user) {
        String sql="insert into user(Title,UserName,Pwd,AddTime,LogCount) values(?,?,?,?,?)";
        return update(sql,user.getTitle(),user.getUserName(),user.getPwd(),user.getAddTime(),user.getLogCount());
    }

    @Override
    public int delete(int id) {
        String sql="delete from user where id=?";
        return update(sql,id);
    }

    @Override
    public int update(User user) {
        String sql="update user set Title=?,UserName=?,Pwd=?,AddTime=?,LastTime=?,LogCount=? where id=?";
        return update(sql,user.getTitle(),user.getUserName(),user.getPwd(),user.getAddTime(),user.getLastTime(),user.getLogCount(),user.getId());
    }

    @Override
    public List<User> queryAll() {
        String sql="select*from user";
        return queryForList(User.class,sql);
    }

    @Override
    public User queryUserByNameAndPassword(User user) {
        String sql = "select *from user where UserName=? and  Pwd=?";
        return queryForOne(User.class, sql, user.getUserName(), user.getPwd());
    }

    @Override
    public User queryUserByUsername(User user) {
        String sql = "select *from user where UserName=? ";
        return queryForOne(User.class, sql, user.getUserName());
    }

    @Override
    public User query(int id) {
        String sql="select * from user where id=?";
        return queryForOne(User.class,sql,id);
    }

    @Override
    public Integer queryCounts() {
        String sql="select count(1) from user";
        return Math.toIntExact((long)queryForSingleValue(sql));
    }

    @Override
    public List<User> queryUserBypage(int begin, int pageSize) {
        String sql="select * from user limit ?,?";
        return queryForList(User.class,sql,begin,pageSize);
    }

    @Override
    public List<User> queryUserByKeywordForPage(User user, int begin, int pageSize) {
        String sql = "select * from user where UserName like concat(\'%\', ?,\'%\') limit ?,?";
        return queryForList(User.class, sql, user.getUserName(),begin,pageSize);
    }

    @Override
    public List<User> userList(User user) {
        String sql="select * from user where UserName like concat(\'%\', ?,\'%\')";
        return  queryForList(User.class, sql, user.getUserName());
    }
}
