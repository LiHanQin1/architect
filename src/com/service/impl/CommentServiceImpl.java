package com.service.impl;

import com.dao.CommentDao;
import com.dao.impl.CommentDaoImpl;
import com.entity.Comment;
import com.entity.Film;
import com.service.CommentService;
import com.utils.Page;

import java.util.List;


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

    @Override
    public  List<Comment> queryCommentByMovieId(Integer movieId) {
        return commentDao.queryCommentByMovieId(movieId);
    }


    @Override
    public Comment query(int id) {
        return commentDao.query(id);
    }

    @Override
    public Integer queryCounts() {
        return commentDao.queryCounts();
    }

    @Override
    public Page<Comment> queryUserBypage(int pageNo, int pageSize) {
        Page<Comment> page=new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页展示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount= commentDao.queryCounts();
        //设置总记录数
        page.setPageTotalCount(Math.toIntExact(pageTotalCount));
        //求总页码数
        Integer pageTotal=pageTotalCount/pageSize;
        if (pageTotalCount%pageSize>0){
            pageTotal+=1;
        }
        //配置总页码
        page.setPageTotal(pageTotal);
        //求当前的页数据的开始索引
        int begin=(page.getPageNo()-1)*pageSize;
        List<Comment> items=commentDao.queryUserBypage(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public List<Comment> commentList(Film film) {
        return commentDao.commentList(film);
    }

    @Override
    public Page<Comment> queryKeyWordByPage(Film film, int pageNo, int pageSize) {
        Page<Comment> page=new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页展示的数量
        page.setPageSize(pageSize);
        //求总记录数
        List<Comment> commentList=commentDao.commentList(film);

        Integer pageTotalCount= commentList.size();
        //设置总记录数
        page.setPageTotalCount(Math.toIntExact(pageTotalCount));
        //求总页码数
        Integer pageTotal=pageTotalCount/pageSize;
        if (pageTotalCount%pageSize>0){
            pageTotal+=1;
        }
        //配置总页码
        page.setPageTotal(pageTotal);
        //求当前的页数据的开始索引
        int begin=(page.getPageNo()-1)*pageSize;
        List<Comment> items=commentDao.queryUserByKeywordForPage(film,begin,pageSize);
        page.setItems(items);
        return page;
    }
}
