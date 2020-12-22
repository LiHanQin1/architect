package com.service;

import com.entity.Toupiao;
import com.entity.Toupiao2;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-21 10:11
 **/
public interface Toupiaoservice {
    int insert(Toupiao toupiao);
    Toupiao query(Toupiao toupiao);
    Integer queryCounts(Toupiao toupiao);
    List<Toupiao> queryAll();
    List<Toupiao2> queryAll2();
}
