package com.service.impl;

import com.dao.FilmDao;
import com.dao.impl.FilmDaoImpl;
import com.entity.Film;
import com.entity.User;
import com.entity.Vip;
import com.service.FilmService;
import com.utils.Page;

import java.util.List;

/**
 * @Author HongSiDa
 * @Description:
 * @Date 2020/12/9 15:22
 **/
public class FilmServiceImpl implements FilmService {
    FilmDao filmDao = new FilmDaoImpl();
    @Override
    public int insert(Film film) {
        return filmDao.insert(film);
    }

    @Override
    public int delete(int id) {
        return filmDao.delete(id);
    }

    @Override
    public int update(Film film) {
        return filmDao.update(film);
    }

    @Override
    public List<Film> queryAll() {
        return filmDao.queryAll();
    }

    @Override
    public Film queryMovieByMovieName(Film film) {
        return filmDao.queryMovieByMovieName(film);
    }

    @Override
    public Film queryMovieByTypeId(Film film) {
        return filmDao.queryMovieByTypeId(film);
    }

    @Override
    public Film queryMovieByDaoYan(Film film) {
        return filmDao.queryMovieByDaoYan(film);
    }

    @Override
    public Film queryMovieByZhuYan(Film film) {
        return filmDao.queryMovieByZhuYan(film);
    }

    @Override
    public List<Film> queryAddress() {
        return filmDao.queryAddress();
    }

    @Override
    public Film query(int id) {
        return filmDao.query(id);
    }

    @Override
    public Integer queryCounts() {
        return filmDao.queryCounts();
    }

    @Override
    public Page<Film> queryByPage(int pageNo, int pageSize) {
        Page<Film> page=new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页展示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount=filmDao.queryCounts();
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
        List<Film> items=filmDao.queryUserBypage(begin,pageSize);
        page.setItems(items);
        return page;
    }


}
