package com.servlet;

import com.dao.BaseDao;
import com.entity.User;
import com.entity.Vip;
import com.google.gson.Gson;
import com.service.UserService;
import com.service.impl.UserSerciceImpl;
import com.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mean = request.getParameter("mean");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setTitle(mean);
        user.setUserName(username);
        user.setPwd(password);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setAddTime(String.valueOf(simpleDateFormat.format(new Date())));
        int result = userService.insert(user);
        String message = "注册失败";
        if (result > 0) {
            message = "注册成功";
            response.getWriter().write(message);
        } else {
            response.getWriter().write(message);
        }

    }
    //删除
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer userId= Integer.valueOf(request.getParameter("id"));
        Integer result=userService.delete(userId);
//        String message=(result >0 ) ?"删除成功":"删除失败";
        response.getWriter().write(result.toString());
    }
    //分页查询
    public void queryPage1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
            Page<User> page = userService.queryByPage(pageNo, Page.PAGE_SIZE);
            Gson gson = new Gson();
            String jsonStr = gson.toJson(page);
            response.getWriter().write(jsonStr);

        }

        //查询
    public void queryByUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username=request.getParameter("username");
        User user=new User();
        user.setUserName(username);
        User user1=userService.queryUserByUsername(user);
        String message = (user1 == null) ? null : "1";
        response.getWriter().write(message);

    }
}
