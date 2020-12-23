package com.dao;

import com.entity.Film;
import com.entity.Toupiao;
import com.entity.Toupiao2;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-21 10:03
 **/
public interface ToupiaoDao {
    int insert(Toupiao toupiao);
    Toupiao query(Toupiao toupiao);
    Integer queryCounts(Toupiao toupiao);
    List<Toupiao> queryAll();
    List<Toupiao2> queryAll2();
    Integer queryCounts();
    List<Toupiao> queryUserBypage(int begin, int pageSize);
    List<Toupiao> queryUserByKeywordForPage(Toupiao toupiao, int begin, int pageSize);
    List<Toupiao>  piaoList(Toupiao toupiao);
}
