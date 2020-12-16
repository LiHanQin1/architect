package com.service.impl;

import com.dao.YuGaoDao;
import com.dao.impl.YuGaoimpl;
import com.entity.YuGao;
import com.service.YuGaoService;

import java.util.List;

/**
 * 作者：czw
 * 日期: 2020/12/15 15:11
 * 描述:
 */
public class YuGaoServiceImpl implements YuGaoService {
    YuGaoDao yuGaoDao = new YuGaoimpl();
    @Override
    public int insert(YuGao yuGao) {
        return yuGaoDao.insert(yuGao);
    }

    @Override
    public int delete(int id) {
        return yuGaoDao.delete(id);
    }

    @Override
    public int update(YuGao yuGao) {
        return yuGaoDao.update(yuGao);
    }

    @Override
    public List<YuGao> queryAll() {
        return yuGaoDao.queryAll();
    }

    @Override
    public YuGao queryMovieByMovieName(YuGao yuGao) {
        return yuGaoDao.queryMovieByMovieName(yuGao);
    }

    @Override
    public YuGao queryMovieByTypeId(YuGao yuGao) {
        return yuGaoDao.queryMovieByTypeId(yuGao);
    }

    @Override
    public YuGao queryMovieByDaoYan(YuGao yuGao) {
        return yuGaoDao.queryMovieByDaoYan(yuGao);
    }

    @Override
    public YuGao queryMovieByZhuYan(YuGao yuGao) {
        return yuGaoDao.queryMovieByZhuYan(yuGao);
    }

    @Override
    public List<YuGao> queryAddress() {
        return yuGaoDao.queryAddress();
    }
}
