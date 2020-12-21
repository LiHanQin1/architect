package com.servlet;

import com.entity.Comment;
import com.entity.User;
import com.entity.Vip;
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

@WebServlet("/AddCommentServlet")
public class AddCommentServlet extends BaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    public void sendcomment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Vip user = (Vip) request.getSession().getAttribute("vip");
        System.out.println(user);
        if (user != null) {
            Comment comment = new Comment();
            String user1 = user.getUserName();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            comment.setCommentTime(String.valueOf(simpleDateFormat.format(new Date())));
            comment.setCommentUser(user1);
            String commentMessage = request.getParameter("message");
            comment.setCommentContent(commentMessage);
            Integer movieId = Integer.valueOf(request.getParameter("MovieId"));
            comment.setMovieId(movieId);
            comment.setCommentTypeId(movieId);
            CommentService commentService = new CommentServiceImpl();
            Integer i = commentService.insert(comment);
            if (i > 0) {
                response.sendRedirect("/architect/FilmServlet?action=queryOne&MovieId=" + movieId);
            }
            {
                response.getWriter().write("发布失败");
            }
        } else {
            response.getWriter().print("<script> alert(\"您还没登录!\");" +
                    "window.location.href=\"http://localhost:8000/architect/moban934/login.html\"" + " </script>");
        }
    }


}
