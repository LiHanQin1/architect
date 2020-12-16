package com.dao.impl;

import com.dao.BaseDao;
import com.dao.YuGaoDao;

import com.entity.YuGao;

import java.util.List;

/**
 * 作者：czw
 * 日期: 2020/12/15 14:57
 * 描述:
 */
public class YuGaoimpl extends BaseDao implements YuGaoDao {
    @Override
    public int insert(YuGao yuGao) {
        String sql="insert into yugao(MovieName,TypeId,DaoYan,ZhuYan,ShowTime,PicAddress) values(?,?,?,?,?,?)";
        return update(sql,yuGao.getMovieName(),yuGao.getTypeId(),yuGao.getDaoYan(),yuGao.getZhuYan(),yuGao.getShowTime(),yuGao.getPicAddress());
    }

    @Override
    public int delete(int id) {
        String sql="delete from yugao where MovieId=?";
        return update(sql,id);
    }

    @Override
    public int update(YuGao yuGao) {
        String sql="update yugao set MovieName=?,TypeId=?,DaoYan=?,ZhuYan=?,ShowTime=?,PicAddress=?";
        return update(sql,yuGao.getMovieName(),yuGao.getTypeId(),yuGao.getDaoYan(),yuGao.getZhuYan(),yuGao.getShowTime(),yuGao.getPicAddress());
    }

    @Override
    public List<YuGao> queryAll() {
        String sql="select * from yugao";
        return queryForList(YuGao.class,sql);
    }

    @Override
    public YuGao queryMovieByMovieName(YuGao yuGao) {
        String sql = "select * from yugao where MovieName=?";
        return queryForOne(YuGao.class, sql, yuGao.getMovieName());
    }

    @Override
    public YuGao queryMovieByTypeId(YuGao yuGao) {
        String sql = "select * from yugao where TypeId=?";
        return queryForOne(YuGao.class, sql, yuGao.getTypeId());
    }

    @Override
    public YuGao queryMovieByDaoYan(YuGao yuGao) {
        String sql = "select * from yugao where DaoYan=?";
        return queryForOne(YuGao.class, sql, yuGao.getDaoYan());
    }

    @Override
    public YuGao queryMovieByZhuYan(YuGao yuGao) {
        String sql = "select * from yugao where ZhuYan=?";
        return queryForOne(YuGao.class, sql, yuGao.getZhuYan());
    }

    @Override
    public List<YuGao> queryAddress() {
        String sql="select PicAddress from yugao";
        return queryForList(YuGao.class,sql);
    }

}
