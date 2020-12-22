package com.servlet;

import com.dao.YuGaoDao;
import com.dao.impl.YuGaoimpl;
import com.entity.Film;
import com.entity.YuGao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author HongSiDa
 * @Description:
 * @Date 2020/12/16 20:09
 **/
@WebServlet("/YuGaoFileUploadServlet")
public class YuGaoFileUploadServlet extends HttpServlet {
    YuGaoDao yuGaoDao=null;
    public YuGaoFileUploadServlet() {
         yuGaoDao= new YuGaoimpl();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //防止中文乱码的金句
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //1 先判断上传的数据是否多段数据 （只有是多段的数据，才是文件上传的）
        if (ServletFileUpload.isMultipartContent(request)) {
            // 创建FileItemFactory 工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            YuGao yuGao = new YuGao();
            try {
                //解析上传的数据 得到每一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(request);
                //循环判断，每一个表单项 是普通类型 还是上传的文件
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        //普通表单项
                        System.out.println("普通表单项 name = " + fileItem.getFieldName());
                        //参数UTF-8解决乱码
                        System.out.println("value = " + fileItem.getString());
                        String str = fileItem.getFieldName();
                        switch (str) {
                            case "MovieName":
                                yuGao.setMovieName(fileItem.getString("utf-8"));
                                break;
                            case "TypeId":
                                yuGao.setTypeId(fileItem.getString("utf-8"));
                                break;
                            case "DaoYan":
                                yuGao.setDaoYan(fileItem.getString("utf-8"));
                                break;
                            case "ZhuYan":
                                yuGao.setZhuYan(fileItem.getString("utf-8"));
                                break;
                            case "ShowTime":
                                yuGao.setShowTime(fileItem.getString("utf-8"));
                                break;
                            case "Content":
                                yuGao.setContent(fileItem.getString("utf-8"));
                                break;
                        }
                    } else {
                        //上传的文件
                        System.out.println("表单项的name = " + fileItem.getFieldName());
                        System.out.println("上传的文件名:" + fileItem.getName());
                        StringBuilder sb = new StringBuilder("D:\\upload\\");
                        sb.append(fileItem.getName());
                        String path = sb.toString();
                        yuGao.setPicAddress(path);
                        fileItem.write(new File(path));
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int result = yuGaoDao.insert(yuGao);
            if (result>0){
                response.getWriter().print("<script> alert(\"添加成功!\");" +
                        "window.location.href=\"http://localhost:8000/architect/admin/html/addyugao.html\""+
                        " </script>");
            }else{
                response.getWriter().print("<script> alert(\"添加成功!\");" +
                        "window.location.href=\"http://localhost:8000/architect/admin/html/addyugao.html\""+
                        " </script>");
            }
        }
    }


}
