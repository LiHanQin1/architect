package com.servlet;

import com.entity.Notice;
import com.service.NoticeService;
import com.service.impl.NoticeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者：czw
 * 日期: 2020/12/15 23:49
 * 描述:
 */
@WebServlet("/AddNoticeServlet")
public class AddNoticeServlet extends BaseServlet {
    NoticeService noticeService = new NoticeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String neirong = request.getParameter("neirong");
        String addtime = request.getParameter("addtime");
        Notice notice = new Notice();
        notice.setNeirong(neirong);
        notice.setTime(addtime);
        notice.setTitle(title);
        noticeService.insert(notice);
        response.getWriter();
    }
}
