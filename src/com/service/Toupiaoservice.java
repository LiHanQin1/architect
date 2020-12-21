package com.service;

import com.entity.Toupiao;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-21 10:11
 **/
public interface Toupiaoservice {
    int insert(Toupiao toupiao);
    Toupiao query(Toupiao toupiao);
}
