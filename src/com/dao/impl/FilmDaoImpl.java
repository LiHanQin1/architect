package com.dao.impl;

import com.dao.BaseDao;
import com.dao.FilmDao;
import com.entity.Film;
import com.entity.User;
import com.entity.Vip;

import java.util.List;

/**
 * @Author HongSiDa
 * @Description:
 * @Date 2020/12/9 10:35
 **/
public class FilmDaoImpl extends BaseDao implements FilmDao {
    @Override
    public int insert(Film film) {
        String sql="insert into film(MovieName,TypeId,DaoYan,ZhuYan,ShowTime,PicAddress,Content,AddTime) values(?,?,?,?,?,?,?,?)";
        return update(sql,film.getMovieName(),film.getTypeId(),film.getDaoYan(),film.getZhuYan(),film.getShowTime(),film.getPicAddress(),film.getContent(),film.getAddTime());

    }

    @Override
    public int delete(int id) {
        String sql="delete from film where MovieId=?";
        return update(sql,id);
    }

    @Override
    public int update(Film film) {
        String sql="update film set MovieName=?,TypeId=?,DaoYan=?,ZhuYan=?,ShowTime=?,PicAddress=?,Content=?,Hits=?  where MovieId=?";
        return update(sql,film.getMovieName(),film.getTypeId(),film.getDaoYan(),film.getZhuYan(),film.getShowTime(),film.getPicAddress(),film.getContent(),film.getHits(),film.getMovieId());

    }

    @Override
    public List<Film> queryAll() {
        String sql="select * from film";
        return queryForList(Film.class,sql);
    }

    @Override
    public Film queryMovieByMovieName(Film film) {
        String sql = "select * from film where MovieName=?";
        return queryForOne(Film.class, sql, film.getMovieName());
    }

    @Override
    public Film queryMovieByTypeId(Film film) {
        String sql = "select * from film where TypeId=?";
        return queryForOne(Film.class, sql, film.getTypeId());
    }

    @Override
    public Film queryMovieByDaoYan(Film film) {
        String sql = "select * from film where DaoYan=?";
        return queryForOne(Film.class, sql, film.getDaoYan());
    }

    @Override
    public Film queryMovieByZhuYan(Film film) {
        String sql = "select * from film where ZhuYan=?";
        return queryForOne(Film.class, sql, film.getZhuYan());
    }

    @Override
    public Film queryMovieByMovieId(Film film) {
        String sql = "select * from film where MovieId = ?";
        return queryForOne(Film.class,sql,film.getMovieId());
    }

    @Override
    public List<Film> queryAddress() {
        String sql="select PicAddress from film";
        return queryForList(Film.class,sql);
    }

    @Override
    public Film query(int id) {
        String sql="select * from film where MovieId=?";
        return queryForOne(Film.class,sql,id);
    }

    @Override
    public Integer queryCounts() {
        String sql="select count(1) from film";
        return Math.toIntExact((long)queryForSingleValue(sql));
    }

    @Override
    public List<Film> queryUserBypage(int begin, int pageSize) {
        String sql="select * from film limit ?,?";
        return queryForList(Film.class,sql,begin,pageSize);
    }

    @Override
    public List<Film> queryUserByKeywordForPage(Film film, int begin, int pageSize) {
        String sql = "select * from film where MovieName like concat(\'%\', ?,\'%\') limit ?,?";
        return queryForList(Film.class, sql, film.getMovieName(),begin,pageSize);
    }

    @Override
    public List<Film> filmList(Film film) {
        String sql="select * from film where MovieName like concat(\'%\', ?,\'%\')";
        return  queryForList(Film.class, sql, film.getMovieName());
    }


}
