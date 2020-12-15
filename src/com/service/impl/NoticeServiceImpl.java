package com.service.impl;

import com.dao.NoticeDao;
import com.dao.impl.NoticeImpl;
import com.entity.Notice;
import com.service.NoticeService;

import java.util.List;

/**
 * 作者：chenbingfeng
 * 日期: 2020/12/15 15:47
 * 描述:
 */
public class NoticeServiceImpl implements NoticeService {
    NoticeDao noticeDao=new NoticeImpl();
    @Override
    public int insert(Notice notice) {
        return noticeDao.insert(notice);
    }

    @Override
    public int delete(int id) {
        return noticeDao.delete(id);
    }

    @Override
    public int update(Notice notice) {
        return noticeDao.update(notice);
    }

    @Override
    public List<Notice> queryAll() {
        return noticeDao.queryAll();
    }
}
