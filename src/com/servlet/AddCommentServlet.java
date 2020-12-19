package com.servlet;

import com.entity.Comment;
import com.service.CommentService;
import com.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者：czw
 * 日期: 2020/12/20 1:3
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
        Comment comment = new Comment();
        comment.setCommentContent(commentMessage);
        CommentService commentService = new CommentServiceImpl();
        commentService.insert(comment);


    }


}
