package com.servlet;

import com.entity.Film;
import com.service.FilmService;
import com.service.impl.FilmServiceImpl;
import org.apache.commons.fileupload.FileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-14 9:44
 **/
@WebServlet("/filmServlet")
public class filmServlet extends BaseServlet {
    FilmService filmService=new FilmServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
    }
    private void qureyAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Film> film=filmService.queryAll();
        System.out.println(film);
        request.setAttribute("film",film);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
