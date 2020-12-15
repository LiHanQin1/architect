package com.servlet;

import com.dao.NoticeDao;
import com.dao.impl.NoticeImpl;
import com.entity.Notice;
import com.entity.Vip;
import com.google.gson.Gson;
import com.service.NoticeService;
import com.service.impl.NoticeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 作者：chenbingfeng
 * 日期: 2020/12/15 19:58
 * 描述:
 */
@WebServlet("/notice.do")
public class NoticeServlet extends BaseServlet {
    NoticeService noticeService=new NoticeServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    public void queryNoticeAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Notice> list=noticeService.queryAll();
        Gson gson=new Gson();
        String jsonStr=gson.toJson(list);
        response.getWriter().write(jsonStr);

    }

}
