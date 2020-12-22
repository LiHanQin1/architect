package com.dao;

import com.entity.Toupiao;

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
}
