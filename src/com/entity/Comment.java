package com.entity;

import java.security.Principal;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-09 9:47
 **/
public class Comment {
    private Integer CommentId;
    private Integer CommentTypeId;
    private Integer MovieId;
    private String CommentUser;
    private String CommentContent;
    private String CommentTime;
    private String MovieName;

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }


    public Comment(Integer commentId, Integer commentTypeId, Integer movieId, String commentUser, String commentContent, String commentTime) {
        CommentId = commentId;
        CommentTypeId = commentTypeId;
        MovieId = movieId;
        CommentUser = commentUser;
        CommentContent = commentContent;
        CommentTime = commentTime;
    }

    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "CommentId=" + CommentId +
                ", CommentTypeId=" + CommentTypeId +
                ", MovieId=" + MovieId +
                ", CommentUser='" + CommentUser + '\'' +
                ", CommentContent='" + CommentContent + '\'' +
                ", CommentTime='" + CommentTime + '\'' +
                ", MovieName='" + MovieName + '\'' +
                '}';
    }

    public Comment(Integer commentId, Integer commentTypeId, Integer movieId, String commentUser, String commentContent, String commentTime, String movieName) {
        CommentId = commentId;
        CommentTypeId = commentTypeId;
        MovieId = movieId;
        CommentUser = commentUser;
        CommentContent = commentContent;
        CommentTime = commentTime;
        MovieName = movieName;
    }

    public Integer getCommentId() {
        return CommentId;
    }

    public void setCommentId(Integer commentId) {
        CommentId = commentId;
    }

    public Integer getCommentTypeId() {
        return CommentTypeId;
    }

    public void setCommentTypeId(Integer commentTypeId) {
        CommentTypeId = commentTypeId;
    }

    public Integer getMovieId() {
        return MovieId;
    }

    public void setMovieId(Integer movieId) {
        MovieId = movieId;
    }

    public String getCommentUser() {
        return CommentUser;
    }

    public void setCommentUser(String commentUser) {
        CommentUser = commentUser;
    }

    public String getCommentContent() {
        return CommentContent;
    }

    public void setCommentContent(String commentContent) {
        CommentContent = commentContent;
    }

    public String getCommentTime() {
        return CommentTime;
    }

    public void setCommentTime(String commentTime) {
        CommentTime = commentTime;
    }
}
