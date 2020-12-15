package com.service;

import com.entity.Notice;

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
}
