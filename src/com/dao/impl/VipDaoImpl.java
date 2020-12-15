package com.dao.impl;

import com.dao.BaseDao;
import com.dao.VipDao;
import com.entity.User;
import com.entity.Vip;

import java.util.List;

/**
 * @Author HongSiDa
 * @Description:
 * @Date 2020/12/9 10:15
 **/
public class VipDaoImpl extends BaseDao implements VipDao {
    @Override
    public int insert(Vip vip) {
        String sql="insert into vip(UserName,UserPwd,Tel,QQ,Email,Sex,RegTime) values(?,?,?,?,?,?,?)";
        return update(sql,vip.getUserName(),vip.getUserPwd(),vip.getTel(),vip.getQQ(),vip.getEmail(),vip.getSex(),vip.getRegTime());
    }

    @Override
    public int delete(int id) {
        String sql="delete from vip where MemberId=?";
        return update(sql,id);
    }

    @Override
    public int update(Vip vip) {
        String sql="update vip set UserName=?,UserPwd=?,Tel=?,QQ=?,Email=?,Sex=? where MemberId=?";
        return update(sql,vip.getUserName(),vip.getUserPwd(),vip.getTel(),vip.getQQ(),vip.getEmail(),vip.getSex(),vip.getMemberId());
    }

    @Override
    public List<Vip> queryAll() {
        String sql="select * from vip";
        return queryForList(Vip.class,sql);
    }

    @Override
    public Vip queryUserByNameAndPassword(Vip vip) {
        String sql = "select * from vip where UserName=? and  UserPwd=?";
        return queryForOne(Vip.class, sql, vip.getUserName(), vip.getUserPwd());
    }

    @Override
    public Vip queryUserByName(Vip vip) {
        String sql = "select * from vip where UserName=? ";
        return queryForOne(Vip.class, sql, vip.getUserName());
    }

    @Override
    public Integer queryCounts() {
        String sql="select count(1) from vip";
        return Math.toIntExact((long)queryForSingleValue(sql));
    }

    @Override
    public List<Vip> queryUserBypage(int begin, int pageSize) {
        String sql="select * from vip limit ?,?";
        return queryForList(Vip.class,sql,begin,pageSize);
    }
}
