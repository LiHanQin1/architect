package com.service.impl;

import com.dao.YuGaoDao;
import com.dao.impl.YuGaoimpl;
import com.entity.Film;
import com.entity.YuGao;
import com.service.YuGaoService;
import com.utils.Page;

import java.util.List;

/**
 * 作者：czw
 * 日期: 2020/12/15 15:11
 * 描述:
 */
public class YuGaoServiceImpl implements YuGaoService {
    YuGaoDao yuGaoDao = new YuGaoimpl();
    @Override
    public int insert(YuGao yuGao) {
        return yuGaoDao.insert(yuGao);
    }

    @Override
    public int delete(int id) {
        return yuGaoDao.delete(id);
    }

    @Override
    public YuGao queryMovieByMovieId(YuGao yuGao) {
        return yuGaoDao.queryMovieByMovieId(yuGao);
    }

    @Override
    public int update(YuGao yuGao) {
        return yuGaoDao.update(yuGao);
    }

    @Override
    public List<YuGao> queryAll() {
        return yuGaoDao.queryAll();
    }

    @Override
    public YuGao queryMovieByMovieName(YuGao yuGao) {
        return yuGaoDao.queryMovieByMovieName(yuGao);
    }

    @Override
    public YuGao queryMovieByTypeId(YuGao yuGao) {
        return yuGaoDao.queryMovieByTypeId(yuGao);
    }

    @Override
    public YuGao queryMovieByDaoYan(YuGao yuGao) {
        return yuGaoDao.queryMovieByDaoYan(yuGao);
    }

    @Override
    public YuGao queryMovieByZhuYan(YuGao yuGao) {
        return yuGaoDao.queryMovieByZhuYan(yuGao);
    }

    @Override
    public List<YuGao> queryAddress() {
        return yuGaoDao.queryAddress();
    }

    @Override
    public YuGao query(int id) {
        return yuGaoDao.query(id);
    }

    @Override
    public Integer queryCounts() {
        return yuGaoDao.queryCounts();
    }

    @Override
    public Page<YuGao> queryByPage(int pageNo, int pageSize) {
        Page<YuGao> page=new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页展示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount=yuGaoDao.queryCounts();
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
        List<YuGao> items=yuGaoDao.queryUserBypage(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<YuGao> queryKeyWordByPage(YuGao yuGao, int pageNo, int pageSize) {
        Page<YuGao> page=new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页展示的数量
        page.setPageSize(pageSize);
        //求总记录数
        List<YuGao> yuGaoList=yuGaoDao.yuGaoList(yuGao);

        Integer pageTotalCount= yuGaoList.size();
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
        List<YuGao> items=yuGaoDao.queryUserByKeywordForPage(yuGao,begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public List<YuGao> yuGaoList(YuGao yuGao) {
        return yuGaoDao.yuGaoList(yuGao);
    }
}
