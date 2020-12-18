package com.dao;

import com.entity.Film;
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
    Notice query(int id);
    //查询当前表的总记录条数
    Integer queryCounts();
    //分页查询
    List<Notice> queryUserBypage(int begin, int pageSize);

    List<Notice> queryUserByKeywordForPage(Notice notice, int begin, int pageSize);
    List<Notice>  noticeList(Notice notice);

}
