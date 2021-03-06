package com.dao;

import com.entity.Comment;
import com.entity.Film;
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
    List<Comment>  queryCommentByMovieId(Integer movieId);

    Comment query(int id);
    //查询当前表的总记录条数
    Integer queryCounts();
    //分页查询
    List<Comment> queryUserBypage(int begin, int pageSize);

    List<Comment> queryUserByKeywordForPage(Film film, int begin, int pageSize);
    List<Comment>  commentList(Film film);
}
