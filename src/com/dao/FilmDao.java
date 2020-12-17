package com.dao;

import com.entity.Film;
import com.entity.User;

import java.util.List;

/**
 * @Author HongSiDa
 * @Description:
 * @Date 2020/12/9 10:32
 **/
public interface FilmDao {
    int insert(Film film);
    int delete(int id);
    int update(Film film);
    List<Film> queryAll();
    Film  queryMovieByMovieName(Film film);
    Film  queryMovieByTypeId(Film film);
    Film  queryMovieByDaoYan(Film film);
    Film  queryMovieByZhuYan(Film film);
    List<Film> queryAddress();

    Film query(int id);
    //查询当前表的总记录条数
    Integer queryCounts();
    //分页查询
    List<Film> queryUserBypage(int begin, int pageSize);
}
