package com.servlet;

import com.entity.Comment;
import com.google.gson.Gson;
import com.service.CommentService;
import com.service.impl.CommentServiceImpl;
import com.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 作者：chenbingfeng
 * 日期: 2020/12/16 15:43
 * 描述:
 */
@WebServlet("/Comment.do")
public class CommentServlet extends BaseServlet {
    CommentService commentService = new CommentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    public void queryAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Comment> comments = commentService.queryAll();
        Gson gson = new Gson();
        String jsonStr = gson.toJson(comments);
        response.getWriter().write(jsonStr);
//        System.out.println(film.toString());
    }

    public void queryPage1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page<Comment> commentPage = commentService.queryUserBypage(pageNo, Page.PAGE_SIZE);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(commentPage);
        response.getWriter().write(jsonStr);

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("userId") != null) {
//            String userId = request.getParameter("userId");
//            Integer result = vipService.delete(Integer.parseInt(userId));
            Integer userId = Integer.valueOf(request.getParameter("userId"));
            Integer result = commentService.delete(userId);
//        String message=(result >0 ) ?"删除成功":"删除失败";
            response.getWriter().write(result.toString());
        }


    }

    public void queryCommentByMovieId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String movieId = request.getParameter("MovieId");
        Comment comment = new Comment();
        comment.setMovieId(Integer.valueOf(movieId));
        List<Comment> list = commentService.queryCommentByMovieId(comment);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(list);
        response.getWriter().write(jsonStr);
    }


}