package com.service;

import com.entity.Comment;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-09 9:51
 **/
public interface CommentService {
    int insert(Comment comment);
    int delete(int CommentId);
    int update(Comment comment);
    List<Comment> queryAll();
}
