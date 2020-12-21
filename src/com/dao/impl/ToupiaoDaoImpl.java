package com.dao.impl;

import com.dao.BaseDao;
import com.dao.ToupiaoDao;
import com.entity.Toupiao;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-21 10:08
 **/
public class ToupiaoDaoImpl extends BaseDao implements ToupiaoDao {
    @Override
    public int insert(Toupiao toupiao) {
        String sql = "insert into toupiao(vipName,movieName,time) values(?,?,?)";
        return update(sql,toupiao.getVipName(),toupiao.getMovieName(),toupiao.getTime());
    }

    @Override
    public Toupiao query(Toupiao toupiao) {
        String sql="select * from toupiao where vipName=? and movieName=?" ;
        return queryForOne(Toupiao.class,sql,toupiao.getVipName(),toupiao.getMovieName());
    }
}
