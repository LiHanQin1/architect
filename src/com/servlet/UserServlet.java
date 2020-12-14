package com.servlet;

import com.dao.BaseDao;
import com.entity.User;
import com.service.UserService;
import com.service.impl.UserSerciceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-08 16:15
 **/
@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
    UserService userService = new UserSerciceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    //管理员登录
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);//获取谷歌验证码的值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");//从前端获取输入的验证码
        User user = userService.queryUserByNameAndPassword(new User(username, password));//根据账号密码从数据查询
        if (token.equals(code)) {
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/administrator.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/login.html");
            }
        } else {
            response.getWriter().write("验证码错误！！！");
        }
    }


}
