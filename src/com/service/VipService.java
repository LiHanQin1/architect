package com.service;

import com.entity.Vip;
import com.utils.Page;

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
    Vip query(int id);
    Vip queryUserByNameAndPassword(Vip vip);
    Vip queryUserByName(Vip vip);
    List<Vip>  vipList(Vip vip);

    /**
     *
     * @param pageNo 当前页码
     * @param pageSize 每页展示数量
     * @return
     */
    Page<Vip> queryByPage(int pageNo, int pageSize);
    Page<Vip> queryKeyWordByPage(Vip vip,int pageNo, int pageSize);
}
