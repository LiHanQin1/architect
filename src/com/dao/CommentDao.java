package com.dao;

import com.entity.Comment;
import com.entity.User;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-09 9:51
 **/
public interface CommentDao {
    int insert(Comment comment);
    int delete(int CommentId);
    int update(Comment comment);
    List<Comment> queryAll();
}
