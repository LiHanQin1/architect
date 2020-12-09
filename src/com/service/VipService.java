package com.service;

import com.entity.Vip;

import java.util.List;

/**
 * @Author HongSiDa
 * @Description:
 * @Date 2020/12/9 15:17
 **/
public interface VipService {
    int insert(Vip vip);
    int delete(int id);
    int update(Vip vip);
    List<Vip> queryAll();
    Vip queryUserByNameAndPassword(Vip vip);
}
