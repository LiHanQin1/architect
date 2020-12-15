package com.dao.impl;

import com.dao.BaseDao;
import com.dao.NoticeDao;
import com.entity.Notice;

import java.util.List;

/**
 * 作者：chenbingfeng
 * 日期: 2020/12/15 15:37
 * 描述:
 */
public class NoticeImpl extends BaseDao implements NoticeDao {
    @Override
    public int insert(Notice notice) {
        String sql="insert into notice(title,neirong,time) values(?,?,?)";
        return update(sql,notice.getTitle(),notice.getNeirong(),notice.getTime());
    }

    @Override
    public int delete(int id) {
        String sql="delete from notice where id=?";
        return update(sql,id);
    }

    @Override
    public int update(Notice notice) {
        String sql="update notice set title=?,neirong=?,time=?";
        return update(sql,notice.getTitle(),notice.getNeirong(),notice.getTime());
    }

    @Override
    public List<Notice> queryAll() {
        String sql="select * from notice";
        return queryForList(Notice.class,sql);
    }
}