package com.servlet;

import com.entity.Vip;
import com.service.VipService;
import com.service.impl.VipServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author HongSiDa
 * @Description:
 * @Date 2020/12/9 18:46
 **/
@WebServlet("/vip.do")
public class VipServlet extends BaseServlet {
    VipService vipService=new VipServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Vip vip=new Vip();
        vip.setUserName(username);
        vip.setUserPwd(password);
        Vip vip1=vipService.queryUserByNameAndPassword(vip);
        if (vip1!=null){
            HttpSession session=request.getSession();
            session.setAttribute("vip",vip1);
            response.getWriter().write("登陆成功！");
            response.sendRedirect(request.getContextPath()+"/index.html");
        }else {
            response.getWriter().write("用户名或密码错误");
            response.sendRedirect(request.getContextPath()+"/index.html");
        }



    }
}
