package com.service;

import com.entity.Notice;
import com.utils.Page;

import java.util.List;

/**
 * 作者：chenbingfeng
 * 日期: 2020/12/15 15:46
 * 描述:
 */
public interface NoticeService {
    int insert(Notice notice);
    int delete(int id);
    int update(Notice notice);
    List<Notice> queryAll();
    Notice query(int id);
    //查询当前表的总记录条数
    Integer queryCounts();
    //分页查询
    Page<Notice> queryUserBypage(int pageNo, int pageSize);
}
