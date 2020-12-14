package com.service.impl;

import com.dao.FilmDao;
import com.dao.impl.FilmDaoImpl;
import com.entity.Film;
import com.service.FilmService;

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


}
