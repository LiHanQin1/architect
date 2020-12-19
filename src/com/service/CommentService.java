package com.service;

import com.entity.Comment;
import com.entity.Film;
import com.utils.Page;

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
    List<Comment> queryCommentByMovieId(Integer movieId);

    Comment query(int id);
    //查询当前表的总记录条数
    Integer queryCounts();
    //分页查询
    Page<Comment> queryUserBypage(int pageNo, int pageSize);

    List<Comment>  commentList(Film film);
    Page<Comment> queryKeyWordByPage(Film film,int pageNo, int pageSize);
}
