package com.service;

import com.entity.Film;
import com.entity.YuGao;
import com.utils.Page;

import java.util.List;

/**
 * 作者：czw
 * 日期: 2020/12/15 15:10
 * 描述:
 */
public interface YuGaoService {
    int insert(YuGao yuGao);
    int delete(int id);
    int update(YuGao yuGao);
    List<YuGao> queryAll();
    YuGao  queryMovieByMovieName(YuGao yuGao);
    YuGao  queryMovieByTypeId(YuGao yuGao);
    YuGao  queryMovieByDaoYan(YuGao yuGao);
    YuGao  queryMovieByZhuYan(YuGao yuGao);
    YuGao queryMovieByMovieId(YuGao yuGao);
    List<YuGao> queryAddress();
    YuGao query(int id);
    //查询当前表的总记录条数
    Integer queryCounts();
    //分页查询
    Page<YuGao> queryByPage(int pageNo, int pageSize);


    Page<YuGao> queryKeyWordByPage(YuGao yuGao,int pageNo, int pageSize);
    List<YuGao>  yuGaoList(YuGao yuGao);
}
