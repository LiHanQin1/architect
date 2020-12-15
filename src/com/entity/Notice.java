package com.entity;

/**
 * 作者：chenbingfeng
 * 日期: 2020/12/15 15:30
 * 描述: 公告
 */

public class Notice {
    private String title;
    private String neirong;
    private String time;
    private Integer id;

    @Override
    public String toString() {
        return "Notice{" +
                "title='" + title + '\'' +
                ", neirong='" + neirong + '\'' +
                ", time='" + time + '\'' +
                ", id=" + id +
                '}';
    }

    public Notice() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Notice(String title, String neirong, String time, Integer id) {
        this.title = title;
        this.neirong = neirong;
        this.time = time;
        this.id = id;
    }
}
