package com.dao;

import com.entity.Vip;

import java.util.List;

/**
 * @Author HongSiDa
 * @Description:
 * @Date 2020/12/9 10:10
 **/
public interface VipDao {
    int insert(Vip vip);
    int delete(int id);
    int update(Vip vip);
    List<Vip> queryAll();
    Vip queryUserByNameAndPassword(Vip vip);
    Vip queryUserByName(Vip vip);

    //查询当前表的总记录条数
    Integer queryCounts();

    //分页查询
    List<Vip> queryUserBypage(int begin,int pageSize);

}
