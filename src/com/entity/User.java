package com.entity;

/**
 * 作者：chenbingfeng
 * 日期: 2020/12/5 10:51
 * 描述:
 */
public class User {
    private Integer id;
    private String Title;
    private String UserName;
    private String Pwd;
    private String AddTime;
    private String LastTime;
    private Integer LogCount;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Pwd='" + Pwd + '\'' +
                ", AddTime='" + AddTime + '\'' +
                ", LastTime='" + LastTime + '\'' +
                ", LogCount=" + LogCount +
                '}';
    }

    public User() {
    }

    public User(Integer id, String title, String userName, String pwd, String addTime, String lastTime, Integer logCount) {
        this.id = id;
        Title = title;
        UserName = userName;
        Pwd = pwd;
        AddTime = addTime;
        LastTime = lastTime;
        LogCount = logCount;
    }

    public User(String userName, String pwd) {
        UserName = userName;
        Pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public String getAddTime() {
        return AddTime;
    }

    public void setAddTime(String addTime) {
        AddTime = addTime;
    }

    public String getLastTime() {
        return LastTime;
    }

    public void setLastTime(String lastTime) {
        LastTime = lastTime;
    }

    public Integer getLogCount() {
        return LogCount;
    }

    public void setLogCount(Integer logCount) {
        LogCount = logCount;
    }
}
