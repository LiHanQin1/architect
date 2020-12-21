package com.entity;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-21 10:05
 **/
public class Toupiao {
    private int id;
    private String vipName;
    private String movieName;
    private String time;

    @Override
    public String toString() {
        return "Toupiao{" +
                "id=" + id +
                ", vipName='" + vipName + '\'' +
                ", movieName='" + movieName + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public Toupiao() {
    }

    public Toupiao(int id, String vipName, String movieName, String time) {
        this.id = id;
        this.vipName = vipName;
        this.movieName = movieName;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
