package com.service;

import com.entity.Film;
import com.entity.User;
import com.utils.Page;

import java.util.List;

/**
 * @Author HongSiDa
 * @Description:
 * @Date 2020/12/9 10:32
 **/
public interface FilmService {
    int insert(Film film);
    int delete(int id);
    int update(Film film);
    List<Film> queryAll();
    Film  queryMovieByMovieName(Film film);
    Film  queryMovieByTypeId(Film film);
    Film  queryMovieByDaoYan(Film film);
    Film  queryMovieByZhuYan(Film film);
    Film  queryMovieByMovieId(Film film);
    List<Film> queryAddress();

    Film query(int id);
    //查询当前表的总记录条数
    Integer queryCounts();
    //分页查询
    Page<Film> queryByPage(int pageNo, int pageSize);

    Page<Film> queryKeyWordByPage(Film film,int pageNo, int pageSize);
    List<Film>  filmList(Film film);
}
