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
 * 日期: 2020/12/20 1:37
 * 描述:
 */
@WebServlet("/AddCommentServlet")
public class AddCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commentMessage = request.getParameter("CommentContent");
        Comment comment = new Comment();
        comment.setCommentContent(commentMessage);
        CommentService commentService = new CommentServiceImpl();
        commentService.insert(comment);
    }


}
