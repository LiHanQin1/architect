package com.servlet;

import com.entity.Film;
import com.google.gson.Gson;
import com.service.FilmService;
import com.service.impl.FilmServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 作者：czw
 * 日期: 2020/12/14 9:53
 * 描述:
 */
@WebServlet("/FilmServlet")
public class filmServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
    }

    public void queryPicAddress(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FilmService filmService = new FilmServiceImpl();
        List<Film> film=filmService.queryAddress();
        Gson gson = new Gson();
        String jsonStr = gson.toJson(film);
        response.getWriter().write(jsonStr);
       // System.out.println(film.toString());
    }
}
