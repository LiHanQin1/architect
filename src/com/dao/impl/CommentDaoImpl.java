package com.dao.impl;

import com.dao.BaseDao;
import com.dao.CommentDao;
import com.entity.Comment;
import com.entity.User;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-09 9:52
 **/
public class CommentDaoImpl extends BaseDao implements CommentDao {
    @Override
    public int insert(Comment comment) {
        String sql="insert into comment (CommentTypeId,MovieId,CommentUser,CommentContent,CommentTime)values(?,?,?,?,?)";
        return update(sql,comment.getCommentTypeId(),comment.getMovieId(),comment.getCommentUser(),comment.getCommentContent(),comment.getCommentTime());
    }

    @Override
    public int delete(int CommentId) {
        String sql="delete from comment where CommentId=? ";
        return 0;
    }

    @Override
    public int update(Comment comment) {
        String sql="update comment set CommentTypeId=?,MovieId=?,CommentUser=?,CommentContent=?,CommentTime=? where CommentId=?";
        return update(sql,comment.getCommentTypeId(),comment.getMovieId(),comment.getCommentUser(),comment.getCommentContent(),comment.getCommentTime(),comment.getCommentId());
    }

    @Override
    public List<Comment> queryAll() {
        String sql="select * from comment";
        return queryForList(Comment.class,sql);
    }
}
