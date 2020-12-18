package com.dao.impl;

import com.dao.BaseDao;
import com.dao.NoticeDao;
import com.entity.Film;
import com.entity.Notice;
import com.service.NoticeService;
import com.service.impl.NoticeServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * 作者：chenbingfeng
 * 日期: 2020/12/15 15:37
 * 描述:
 */
public class NoticeImpl extends BaseDao implements NoticeDao {
    @Override
    public int insert(Notice notice) {
        String sql = "insert into notice(title,neirong,time) values(?,?,?)";
        return update(sql, notice.getTitle(), notice.getNeirong(), notice.getTime());
    }

    @Override
    public int delete(int id) {
        String sql = "delete from notice where id=?";
        return update(sql, id);
    }

    @Override
    public int update(Notice notice) {
        String sql = "update notice set title=?,neirong=?,time=? where id=?";
        return update(sql, notice.getTitle(), notice.getNeirong(), notice.getTime(), notice.getId());
    }



    @Override
    public List<Notice> queryAll() {
        String sql = "select * from notice";
        return queryForList(Notice.class, sql);
    }

    @Override
    public Notice query(int id) {
        String sql = "select * from notice where id=?";
        return queryForOne(Notice.class, sql, id);
    }

    @Override
    public Integer queryCounts() {
        String sql = "select count(1) from notice";
        return Math.toIntExact((long) queryForSingleValue(sql));
    }

    @Override
    public List<Notice> queryUserBypage(int begin, int pageSize) {
        String sql = "select * from notice limit ?,?";
        return queryForList(Notice.class, sql, begin, pageSize);
    }

    @Override
    public List<Notice> queryUserByKeywordForPage(Notice notice, int begin, int pageSize) {
        String sql = "select * from notice where title like concat(\'%\', ?,\'%\') limit ?,?";
        return queryForList(Notice.class, sql, notice.getTitle(),begin,pageSize);
    }

    @Override
    public List<Notice> noticeList(Notice notice) {
        String sql="select * from notice where title like concat(\'%\', ?,\'%\')";
        return  queryForList(Notice.class, sql, notice.getTitle());
    }

}
