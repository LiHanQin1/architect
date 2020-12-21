package com.service.impl;

import com.dao.ToupiaoDao;
import com.dao.impl.ToupiaoDaoImpl;
import com.entity.Toupiao;
import com.service.Toupiaoservice;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-21 10:11
 **/
public class ToupiaoServiceImpl implements Toupiaoservice {
    ToupiaoDao toupiaoDao=new ToupiaoDaoImpl();

    @Override
    public int insert(Toupiao toupiao) {
        return toupiaoDao.insert(toupiao);
    }

    @Override
    public Toupiao query(Toupiao toupiao) {
        return toupiaoDao.query(toupiao);
    }
}
