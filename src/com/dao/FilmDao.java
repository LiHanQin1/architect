package com.dao;

import com.entity.Film;

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
}
