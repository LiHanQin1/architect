package com.servlet;


import com.entity.Film;
import com.entity.YuGao;
import com.google.gson.Gson;
import com.service.YuGaoService;
import com.service.impl.YuGaoServiceImpl;
import com.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 作者：czw
 * 日期: 2020/12/15 15:15
 * 描述:
 */
@WebServlet("/YuGaoServlet")
public class YuGaoServlet extends BaseServlet {
    YuGaoService yuGaoService = new YuGaoServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer userId= Integer.valueOf(request.getParameter("userId"));
        Integer result=yuGaoService.delete(userId);
//        String message=(result >0 ) ?"删除成功":"删除失败";
        response.getWriter().write(result.toString());
    }

    public void queryOne(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer movieId = Integer.valueOf(request.getParameter("MovieId"));
        YuGao yuGao = new YuGao();
        yuGao.setMovieId(movieId);
        YuGao yuGao1=yuGaoService.queryMovieByMovieId(yuGao);
        Gson gson=new Gson();
        String jsonStr=gson.toJson(yuGao1);
        response.getWriter().write(jsonStr);
        request.getSession().setAttribute("yuGao1",yuGao1);
        request.getRequestDispatcher("yugao.jsp").forward(request,response);
    }

    public void queryPicAddress(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<YuGao> film=yuGaoService.queryAddress();
        Gson gson = new Gson();
        String jsonStr = gson.toJson(film);
        response.getWriter().write(jsonStr);
    }

    public void queryAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<YuGao> film=yuGaoService.queryAll();
        Gson gson = new Gson();
        String jsonStr = gson.toJson(film);
        response.getWriter().write(jsonStr);
    }
    public void queryPage1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page<YuGao> page = yuGaoService.queryByPage(pageNo, Page.PAGE_SIZE);
        System.out.println(page.toString());
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
    }

    public void queryByKeyword (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String keyword = request.getParameter("keyword");
        YuGao yuGao = new YuGao();
        yuGao.setMovieName(keyword);
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page<YuGao> page = yuGaoService.queryKeyWordByPage(yuGao,pageNo, Page.PAGE_SIZE);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
    }
}
