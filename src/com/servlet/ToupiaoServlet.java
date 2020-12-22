package com.servlet;

import com.dao.BaseDao;
import com.entity.Toupiao;
import com.google.gson.Gson;
import com.service.Toupiaoservice;
import com.service.impl.ToupiaoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-21 10:17
 **/
@WebServlet("/toupiao.do")
public class ToupiaoServlet extends BaseServlet {
    Toupiaoservice toupiaoservice = new ToupiaoServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vipName = request.getParameter("vipName");
        String movieName = request.getParameter("movieName");
        Toupiao toupiao = new Toupiao();
        toupiao.setVipName(vipName);
        toupiao.setMovieName(movieName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        toupiao.setTime(String.valueOf(simpleDateFormat.format(new Date())));
        Integer i = toupiaoservice.insert(toupiao);
        String str = (i == 1) ? "1" : "";
        response.getWriter().write(str);
    }

    public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vipName = request.getParameter("vipName");
        String movieName = request.getParameter("movieName");
        Toupiao toupiao = new Toupiao();
        toupiao.setVipName(vipName);
        toupiao.setMovieName(movieName);
        Toupiao toupiao1 = toupiaoservice.query(toupiao);
        if (toupiao1 == null) {
            response.getWriter().write("1");
        }

    }

    public void queryCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String movieName = request.getParameter("movieName");
        Toupiao toupiao = new Toupiao();
        toupiao.setMovieName(movieName);
        Integer integer = toupiaoservice.queryCounts(toupiao);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(integer);
        response.getWriter().write(jsonStr);

    }

    public void queryall(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Toupiao> list = toupiaoservice.queryAll();
        Gson gson = new Gson();
        String jsonStr = gson.toJson(list);
        response.getWriter().write(jsonStr);
    }
}
