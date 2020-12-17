package com.service.impl;

import com.dao.NoticeDao;
import com.dao.impl.NoticeImpl;
import com.entity.Notice;
import com.service.NoticeService;
import com.utils.Page;

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

    @Override
    public Notice query(int id) {
        return noticeDao.query(id);
    }

    @Override
    public Integer queryCounts() {
        return noticeDao.queryCounts();
    }

    @Override
    public Page<Notice> queryUserBypage(int pageNo, int pageSize) {
        Page<Notice> page=new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页展示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount= noticeDao.queryCounts();
        //设置总记录数
        page.setPageTotalCount(Math.toIntExact(pageTotalCount));
        //求总页码数
        Integer pageTotal=pageTotalCount/pageSize;
        if (pageTotalCount%pageSize>0){
            pageTotal+=1;
        }
        //配置总页码
        page.setPageTotal(pageTotal);
        //求当前的页数据的开始索引
        int begin=(page.getPageNo()-1)*pageSize;
        List<Notice> items=noticeDao.queryUserBypage(begin,pageSize);
        page.setItems(items);
        return page;
    }
}
