package com.entity;

/**
 * @Author HongSiDa
 * @Description:
 * @Date 2020/12/9 10:07
 **/
public class Film {
    private Integer MovieId;
    private String MovieName;
    private Integer TypeId;
    private String DaoYan;
    private String ZhuYan;
    private String ShowTime;
    private String PicAddress;
    private String Content;
    private String AddTime;
    private String Hits;

    public Film() {
    }

    public Film(Integer movieId, String movieName, Integer typeId, String daoYan, String zhuYan, String showTime, String picAddress, String content, String addTime, String hits) {
        MovieId = movieId;
        MovieName = movieName;
        TypeId = typeId;
        DaoYan = daoYan;
        ZhuYan = zhuYan;
        ShowTime = showTime;
        PicAddress = picAddress;
        Content = content;
        AddTime = addTime;
        Hits = hits;
    }

    @Override
    public String toString() {
        return "film{" +
                "MovieId=" + MovieId +
                ", MovieName='" + MovieName + '\'' +
                ", TypeId=" + TypeId +
                ", DaoYan='" + DaoYan + '\'' +
                ", ZhuYan='" + ZhuYan + '\'' +
                ", ShowTime='" + ShowTime + '\'' +
                ", PicAddress='" + PicAddress + '\'' +
                ", Content='" + Content + '\'' +
                ", AddTime='" + AddTime + '\'' +
                ", Hits='" + Hits + '\'' +
                '}';
    }

    public Integer getMovieId() {
        return MovieId;
    }

    public void setMovieId(Integer movieId) {
        MovieId = movieId;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public Integer getTypeId() {
        return TypeId;
    }

    public void setTypeId(Integer typeId) {
        TypeId = typeId;
    }

    public String getDaoYan() {
        return DaoYan;
    }

    public void setDaoYan(String daoYan) {
        DaoYan = daoYan;
    }

    public String getZhuYan() {
        return ZhuYan;
    }

    public void setZhuYan(String zhuYan) {
        ZhuYan = zhuYan;
    }

    public String getShowTime() {
        return ShowTime;
    }

    public void setShowTime(String showTime) {
        ShowTime = showTime;
    }

    public String getPicAddress() {
        return PicAddress;
    }

    public void setPicAddress(String picAddress) {
        PicAddress = picAddress;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getAddTime() {
        return AddTime;
    }

    public void setAddTime(String addTime) {
        AddTime = addTime;
    }

    public String getHits() {
        return Hits;
    }

    public void setHits(String hits) {
        Hits = hits;
    }


}
