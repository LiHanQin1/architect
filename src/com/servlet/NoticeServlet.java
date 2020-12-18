package com.servlet;

import com.entity.Film;
import com.entity.Notice;
import com.google.gson.Gson;
import com.service.NoticeService;
import com.service.impl.NoticeServiceImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.dao.NoticeDao;
import com.dao.impl.NoticeImpl;
import com.entity.Notice;
import com.entity.Vip;
import com.google.gson.Gson;
import com.service.NoticeService;
import com.service.impl.NoticeServiceImpl;
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
 * 日期: 2020/12/15 19:58
 * 描述:
 */
@WebServlet("/notice.do")
public class NoticeServlet extends BaseServlet {
    NoticeService noticeService = new NoticeServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    public void queryNoticeAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Notice> list = noticeService.queryAll();
        Gson gson = new Gson();
        String jsonStr = gson.toJson(list);
        response.getWriter().write(jsonStr);

    }

    public void queryAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Notice> notices = noticeService.queryAll();
        Gson gson=new Gson();
        String jsonStr = gson.toJson(notices);
        response.getWriter().write(jsonStr);

    }

    public void registers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String lasttime = request.getParameter("lasttime");
        String neirong = request.getParameter("neirong");
        Notice notice = new Notice();
        notice.setTitle(title);
        notice.setNeirong(neirong);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        notice.setTime(String.valueOf(simpleDateFormat.format(new Date())));
        int result = noticeService.insert(notice);
        String message = "注册失败";
        if (result > 0) {
            response.getWriter().print("<script> alert(\"注册成功!\");" +
                    "window.location.href=\"http://localhost:8000/architect/admin/html/add.html\"" +
                    " </script>");
        } else {
            response.getWriter().print("<script> alert(\"注册失败!\");" +
                    "window.location.href=\"http://localhost:8000/architect/admin/html/add.html\"" +
                    " </script>");
        }


    }

    public void queryPage1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page<Notice> commentPage = noticeService.queryUserBypage(pageNo, Page.PAGE_SIZE);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(commentPage);
        response.getWriter().write(jsonStr);

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("userId") != null) {
//            String userId = request.getParameter("userId");
//            Integer result = vipService.delete(Integer.parseInt(userId));
            Integer userId = Integer.valueOf(request.getParameter("userId"));
            Integer result = noticeService.delete(userId);
//        String message=(result >0 ) ?"删除成功":"删除失败";
            response.getWriter().write(result.toString());
        }
    }

    public void updata(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        Notice notice = noticeService.query(userId);
        System.out.println(notice);
        String title = request.getParameter("title");
        String neirong = request.getParameter("neirong");
        String time = request.getParameter("time");
        notice.setTime(time);
        notice.setTitle(title);
        notice.setNeirong(neirong);
        Integer integer = noticeService.update(notice);
        String str = (integer == 1) ? "1" : "";
        response.getWriter().write(str);
    }

    public void queryByKeyword (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String keyword = request.getParameter("keyword");
        Notice notice = new Notice();
        notice.setTitle(keyword);
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page<Notice> page = noticeService.queryKeyWordByPage(notice,pageNo, Page.PAGE_SIZE);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
    }

}
