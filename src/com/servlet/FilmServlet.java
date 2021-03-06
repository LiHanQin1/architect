package com.servlet;

import com.entity.Film;
import com.entity.User;
import com.google.gson.Gson;
import com.service.FilmService;
import com.service.impl.FilmServiceImpl;
import com.utils.Page;

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
public class FilmServlet extends BaseServlet {
    FilmService filmService = new FilmServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
    }

    public void queryPicAddress(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Film> film=filmService.queryAddress();
        request.getSession().setAttribute("film",film);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(film);
        response.getWriter().write(jsonStr);
        System.out.println(film.toString());

    }
    public void orderByHits(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Film> film =filmService.orderByHits();
        Gson gson=new Gson();
        String jsonStr=gson.toJson(film);
        response.getWriter().write(jsonStr);
    }

    public void queryAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Film> film=filmService.queryAll();
        Gson gson=new Gson();
        String jsonStr=gson.toJson(film);
        response.getWriter().write(jsonStr);
    }

    public void updateHit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String movieId = request.getParameter("MovieId");
        Film film = new Film();
        film.setMovieId(Integer.valueOf(movieId));
        Film film1 = filmService.queryMovieByMovieId(film);
        Integer hits = film1.getHits();
        hits++;
        film1.setHits(hits);
        filmService.update(film1);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(film1);
        response.getWriter().write(jsonStr);
    }
    public void queryOne(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer movieId = Integer.valueOf(request.getParameter("MovieId"));
        Film film = new Film();
        film.setMovieId(movieId);
        Film film1=filmService.queryMovieByMovieId(film);
        Gson gson=new Gson();
        String jsonStr=gson.toJson(film1);
        response.getWriter().write(jsonStr);
        request.getSession().setAttribute("film1",film1);
        request.getRequestDispatcher("single.jsp").forward(request,response);
    }
    public void queryOne2(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer movieId = Integer.valueOf(request.getParameter("id"));
        Film film = new Film();
        film.setMovieId(movieId);
        Film film1=filmService.queryMovieByMovieId(film);
        Gson gson=new Gson();
        String jsonStr=gson.toJson(film1);
        response.getWriter().write(jsonStr);

    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer userId= Integer.valueOf(request.getParameter("userId"));
        Integer result=filmService.delete(userId);
//        String message=(result >0 ) ?"删除成功":"删除失败";
        response.getWriter().write(result.toString());
    }
    //分页查询
    public void queryPage1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page<Film> page = filmService.queryByPage(pageNo, Page.PAGE_SIZE);
        System.out.println(page.toString());
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
    }

    public void queryByKeyword (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String keyword = request.getParameter("keyword");
        Film film = new Film();
        film.setMovieName(keyword);
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page<Film> page = filmService.queryKeyWordByPage(film,pageNo, Page.PAGE_SIZE);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
    }

}
