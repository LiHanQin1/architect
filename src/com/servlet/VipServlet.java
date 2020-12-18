package com.servlet;

import com.entity.User;
import com.entity.Vip;
import com.google.gson.Gson;
import com.service.VipService;
import com.service.impl.VipServiceImpl;
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
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * @Author HongSiDa
 * @Description:
 * @Date 2020/12/9 18:46
 **/
@WebServlet("/vip.do")
public class VipServlet extends BaseServlet {
    VipService vipService = new VipServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Vip vip = new Vip();
        vip.setUserName(username);
        vip.setUserPwd(password);
        Vip vip1 = vipService.queryUserByNameAndPassword(vip);
        if (vip1 != null) {
            vip1.setLoginCount(vip1.getLoginCount() + 1);
            vipService.update(vip1);
            HttpSession session = request.getSession();
            session.setAttribute("vip", vip1);
            response.getWriter().write("登陆成功！");

        } else {

            response.getWriter().write("用户名或密码错误");
            response.sendRedirect(request.getContextPath() + "/index.html");
        }
    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("registername");
        String password = request.getParameter("registerpassword");
        String confirmpassword = request.getParameter("confirmregisterpassword");
        String tel = request.getParameter("tel");
        String qq = request.getParameter("qq");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        Vip vip = new Vip();
        vip.setUserName(username);
        vip.setUserPwd(password);
        vip.setTel(tel);
        vip.setQQ(qq);
        vip.setEmail(email);
        vip.setSex(sex);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        vip.setRegTime(String.valueOf(simpleDateFormat.format(new Date())));
        vip.setLoginCount(0);

        Vip vip1 = vipService.queryUserByName(vip);
        if (vip1 == null) {
            Integer result = vipService.insert(vip);
            if (result > 0) {
                response.getWriter().write("注册成功！");
            } else {
                response.getWriter().write("注册失败！");
            }
        }
    }

    public void queryUserByUsername(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //金句：防止中文乱码
        response.setContentType("textml;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String registername = request.getParameter("registername");
        Vip vip = new Vip();
        vip.setUserName(registername);
        Vip vip1 = vipService.queryUserByName(vip);
        String message = (vip1 == null) ? null : "1";
        response.getWriter().write(message);
    }

    //管理员界面注册普通用户
    public void registers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String QQ = request.getParameter("QQ");
        String TEL = request.getParameter("TEL");
        String Email = request.getParameter("Email");
        String sex = request.getParameter("sex");
        Vip vip = new Vip();
        vip.setUserName(username);
        vip.setUserPwd(password);
        vip.setQQ(QQ);
        vip.setTel(TEL);
        vip.setEmail(Email);
        vip.setSex(sex);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        vip.setRegTime(String.valueOf(simpleDateFormat.format(new Date())));
        vip.setLoginCount(0);
        int result = vipService.insert(vip);
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


    //查询全部普通用户信息
    public void queryAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Vip> vipList = vipService.queryAll();
        Gson gson = new Gson();
        String jsonStr = gson.toJson(vipList);
        response.getWriter().write(jsonStr);
        //   System.out.println(vipList.toString());
    }

    //删除
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("userId") != null) {
//            String userId = request.getParameter("userId");
//            Integer result = vipService.delete(Integer.parseInt(userId));
            Integer userId = Integer.valueOf(request.getParameter("userId"));
            Integer result = vipService.delete(userId);
//        String message=(result >0 ) ?"删除成功":"删除失败";
            response.getWriter().write(result.toString());
        }
    }
        //分页查询
        public void queryPage(HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
            Page<Vip> page = vipService.queryByPage(pageNo, Page.PAGE_SIZE);
            Gson gson = new Gson();
            String jsonStr = gson.toJson(page);
            response.getWriter().write(jsonStr);
        }
        //根据用户名查询

        public void queryByUsername (HttpServletRequest request, HttpServletResponse response) throws IOException {
            String username = request.getParameter("username");
            Vip vip = new Vip();
            vip.setUserName(username);
            Vip vip1 = vipService.queryUserByName(vip);
            String str1 = (vip1 == null) ? "" : "1";
            response.getWriter().write(str1);
        }
        public void updata (HttpServletRequest request, HttpServletResponse response) throws IOException {
            Integer MemberId = Integer.valueOf(request.getParameter("userId"));
            Vip vip = vipService.query(MemberId);
            System.out.println(vip);
            String UserName = request.getParameter("username");
            String UserPwd = request.getParameter("password");
            String Tel = request.getParameter("tel");
            String QQ = request.getParameter("qq");
            String Email = request.getParameter("Email");
            String Sex = request.getParameter("set");
            vip.setUserName(UserName);
            vip.setUserPwd(UserPwd);
            vip.setTel(Tel);
            vip.setQQ(QQ);
            vip.setEmail(Email);
            vip.setSex(Sex);
            Integer vip1 = vipService.update(vip);
            String str = (vip1 == 1) ? "1" : "";
            response.getWriter().write(str);

        }
    public void queryByKeyword (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String keyword = request.getParameter("keyword");
        Vip vip = new Vip();
        vip.setUserName(keyword);
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page<Vip> page = vipService.queryKeyWordByPage(vip,pageNo, Page.PAGE_SIZE);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(page);
        response.getWriter().write(jsonStr);
    }
    }
