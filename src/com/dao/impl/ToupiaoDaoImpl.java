package com.dao.impl;

import com.dao.BaseDao;
import com.dao.ToupiaoDao;
import com.entity.Film;
import com.entity.Toupiao;
import com.entity.Toupiao2;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-21 10:08
 **/
public class ToupiaoDaoImpl extends BaseDao implements ToupiaoDao {
    @Override
    public int insert(Toupiao toupiao) {
        String sql = "insert into toupiao(vipName,movieName,time) values(?,?,?)";
        return update(sql, toupiao.getVipName(), toupiao.getMovieName(), toupiao.getTime());
    }

    @Override
    public Toupiao query(Toupiao toupiao) {
        String sql = "select * from toupiao where vipName=? and movieName=?";
        return queryForOne(Toupiao.class, sql, toupiao.getVipName(), toupiao.getMovieName());
    }

    @Override
    public Integer queryCounts(Toupiao toupiao) {
        String sql = "select count(1) from toupiao WHERE movieName =?";
        return Math.toIntExact((long) queryForSingleValue(sql, toupiao.getMovieName()));

    }

    @Override
    public List<Toupiao> queryAll() {
        String sql = "SELECT\n" +
                "    movieName,\n" +
                "    count( * ) AS COUNT \n" +
                "FROM\n" +
                "   toupiao\n" +
                "GROUP BY\n" +
                "    movieName \n" +
                "ORDER BY\n" +
                "    COUNT DESC";
        return queryForList(Toupiao.class, sql);
    }

    @Override
    public List<Toupiao2> queryAll2() {
        String sql = "SELECT\n" +
                "id,\n" +
                "    movieName,\n" +
                "    count( * ) AS COUNT \n" +
                "FROM\n" +
                "   toupiao\n" +
                "GROUP BY\n" +
                "    movieName \n" +
                "ORDER BY\n" +
                "    COUNT DESC";

        return queryForList(Toupiao2.class, sql);
    }

    @Override
    public Integer queryCounts() {
        String sql="select count(1) from toupiao";
        return Math.toIntExact((long)queryForSingleValue(sql));
    }

    @Override
    public List<Toupiao> queryUserBypage(int begin, int pageSize) {
        String sql="select * from toupiao limit ?,?";
        return queryForList(Toupiao.class,sql,begin,pageSize);
    }

    @Override
    public List<Toupiao> queryUserByKeywordForPage(Toupiao toupiao, int begin, int pageSize) {
        String sql = "select * from toupiao where MovieName like concat(\'%\', ?,\'%\') limit ?,?";
        return queryForList(Toupiao.class, sql, toupiao.getMovieName(),begin,pageSize);
    }

    @Override
    public List<Toupiao> piaoList(Toupiao toupiao) {
        String sql="select * from toupiao where MovieName like concat(\'%\', ?,\'%\')";
        return  queryForList(Toupiao.class, sql, toupiao.getMovieName());
    }
}
