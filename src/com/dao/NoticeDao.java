package com.dao;

import com.entity.Notice;
import org.apache.tools.ant.taskdefs.Delete;

import java.util.List;

/**
 * 作者：chenbingfeng
 * 日期: 2020/12/15 15:33
 * 描述:
 */
public interface NoticeDao {
    int insert(Notice notice);
    int delete(int id);
    int update(Notice notice);
    List<Notice> queryAll();
}
