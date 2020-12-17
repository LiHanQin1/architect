package com.dao;

import com.entity.Film;
import com.entity.YuGao;
import com.entity.YuGao;

import java.util.List;

/**
 * 作者：czw
 * 日期: 2020/12/15 14:56
 * 描述:
 */
public interface YuGaoDao {
    int insert(YuGao yuGao);
    int delete(int id);
    int update(YuGao yuGao);
    List<YuGao> queryAll();
    YuGao  queryMovieByMovieName(YuGao yuGao);
    YuGao  queryMovieByTypeId(YuGao yuGao);
    YuGao  queryMovieByDaoYan(YuGao yuGao);
    YuGao  queryMovieByZhuYan(YuGao yuGao);
    List<YuGao> queryAddress();
    YuGao query(int id);
    //查询当前表的总记录条数
    Integer queryCounts();
    //分页查询
    List<YuGao> queryUserBypage(int begin, int pageSize);
}
