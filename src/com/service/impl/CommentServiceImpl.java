package com.service.impl;

import com.dao.CommentDao;
import com.dao.impl.CommentDaoImpl;
import com.entity.Comment;
import com.service.CommentService;

import java.util.List;

/**
 * @Author HongSiDa
 * @Description:
 * @Date 2020/12/9 15:22
 **/
public class CommentServiceImpl implements CommentService {
    CommentDao commentDao=new CommentDaoImpl();
    @Override
    public int insert(Comment comment) {
        return commentDao.insert(comment);
    }

    @Override
    public int delete(int CommentId) {
        return commentDao.delete(CommentId);
    }

    @Override
    public int update(Comment comment) {
        return commentDao.update(comment);
    }

    @Override
    public List<Comment> queryAll() {
        return commentDao.queryAll();
    }
}
