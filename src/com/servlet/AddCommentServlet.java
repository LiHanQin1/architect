package com.servlet;

import com.entity.Comment;
import com.service.CommentService;
import com.service.impl.CommentServiceImpl;
import javafx.scene.input.DataFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：czw
 * 日期: 2020/12/20 1:37
 * 描述:
 */
@WebServlet("/AddCommentServlet")
public class AddCommentServlet extends BaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    public void sendcomment(HttpServletRequest request, HttpServletResponse response) {
        String commentMessage = request.getParameter("message");
        Integer movieId = (Integer) request.getSession().getAttribute("MovieId");
        String commentTypeId = String.valueOf(request.getSession().getAttribute("CommentTypeId"));
        Comment comment = new Comment();
        comment.setCommentContent(commentMessage);
        comment.setMovieId(movieId);
        comment.setCommentTypeId(Integer.valueOf(commentTypeId));
        Date date = new Date();
        SimpleDateFormat  dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String commentTime = dataFormat.format(date);
        comment.setCommentTime(commentTime);
        CommentService commentService = new CommentServiceImpl();
        commentService.insert(comment);
    }


}
