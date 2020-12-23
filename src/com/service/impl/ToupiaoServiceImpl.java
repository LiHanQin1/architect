package com.service.impl;

import com.dao.ToupiaoDao;
import com.dao.impl.ToupiaoDaoImpl;
import com.entity.Film;
import com.entity.Toupiao;
import com.entity.Toupiao2;
import com.service.Toupiaoservice;
import com.utils.Page;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-21 10:11
 **/
public class ToupiaoServiceImpl implements Toupiaoservice {
    ToupiaoDao toupiaoDao=new ToupiaoDaoImpl();

    @Override
    public int insert(Toupiao toupiao) {
        return toupiaoDao.insert(toupiao);
    }

    @Override
    public Toupiao query(Toupiao toupiao) {
        return toupiaoDao.query(toupiao);
    }

    @Override
    public Integer queryCounts(Toupiao toupiao) {
        return toupiaoDao.queryCounts(toupiao);
    }

    @Override
    public List<Toupiao> queryAll() {
        return toupiaoDao.queryAll();
    }

    @Override
    public List<Toupiao2> queryAll2() {
        return toupiaoDao.queryAll2();
    }

    @Override
    public Integer queryCounts() {
        return toupiaoDao.queryCounts();
    }

    @Override
    public Page<Toupiao> queryByPage(int pageNo, int pageSize) {
        Page<Toupiao> page=new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页展示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount=toupiaoDao.queryCounts();
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
        List<Toupiao> items=toupiaoDao.queryUserBypage(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Toupiao> queryUserByKeywordForPage(Toupiao toupiao,  int pageNo, int pageSize) {
        Page<Toupiao> page=new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页展示的数量
        page.setPageSize(pageSize);
        //求总记录数
        List<Toupiao> filmList=toupiaoDao.piaoList(toupiao);

        Integer pageTotalCount= filmList.size();
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
        List<Toupiao> items=toupiaoDao.queryUserByKeywordForPage(toupiao,begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public List<Toupiao> piaoList(Toupiao toupiao) {
        return toupiaoDao.piaoList(toupiao);
    }
}
