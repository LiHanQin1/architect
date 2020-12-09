package com.service.impl;

import com.entity.Film;
import com.service.FilmService;

import java.util.List;

/**
 * @Author HongSiDa
 * @Description:
 * @Date 2020/12/9 15:22
 **/
public class FilmServiceImpl implements FilmService {
    FilmService filmService=new FilmServiceImpl();
    @Override
    public int insert(Film film) {
        return filmService.insert(film);
    }

    @Override
    public int delete(int id) {
        return filmService.delete(id);
    }

    @Override
    public int update(Film film) {
        return filmService.update(film);
    }

    @Override
    public List<Film> queryAll() {
        return filmService.queryAll();
    }

    @Override
    public Film queryMovieByMovieName(Film film) {
        return filmService.queryMovieByMovieName(film);
    }

    @Override
    public Film queryMovieByTypeId(Film film) {
        return filmService.queryMovieByTypeId(film);
    }

    @Override
    public Film queryMovieByDaoYan(Film film) {
        return filmService.queryMovieByDaoYan(film);
    }

    @Override
    public Film queryMovieByZhuYan(Film film) {
        return filmService.queryMovieByZhuYan(film);
    }
}
