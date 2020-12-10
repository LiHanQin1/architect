package com.service.impl;

import com.dao.VipDao;
import com.dao.impl.VipDaoImpl;
import com.entity.Vip;
import com.service.VipService;

import java.util.List;

/**
 * @Author HongSiDa
 * @Description:
 * @Date 2020/12/9 15:17
 **/
public class VipServiceImpl implements VipService {
    VipDao vipDao=new VipDaoImpl();
    @Override
    public int insert(Vip vip) {
        return vipDao.insert(vip);
    }

    @Override
    public int delete(int id) {
        return vipDao.delete(id);
    }

    @Override
    public int update(Vip vip) {
        return vipDao.update(vip);
    }

    @Override
    public List<Vip> queryAll() {
        return vipDao.queryAll();
    }

    @Override
    public Vip queryUserByNameAndPassword(Vip vip) {
        return vipDao.queryUserByNameAndPassword(vip);
    }

    @Override
    public Vip queryUserByName(Vip vip) {
        return vipDao.queryUserByName(vip);
    }
}
