package com.entity;

/**
 * 作者：chenbingfeng
 * 日期: 2020/12/22 11:02
 * 描述:
 */
public class Toupiao2 {
    private int id;

    private String movieName;
    private Integer COUNT;

    public Toupiao2() {
    }

    @Override
    public String toString() {
        return "Toupiao2{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", COUNT=" + COUNT +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getCOUNT() {
        return COUNT;
    }

    public void setCOUNT(Integer COUNT) {
        this.COUNT = COUNT;
    }

    public Toupiao2(int id, String movieName, Integer COUNT) {
        this.id = id;
        this.movieName = movieName;
        this.COUNT = COUNT;
    }
}
