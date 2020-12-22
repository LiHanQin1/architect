package com.servlet;

import com.entity.Film;
import com.entity.YuGao;
import com.service.FilmService;
import com.service.YuGaoService;
import com.service.impl.FilmServiceImpl;
import com.service.impl.YuGaoServiceImpl;
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
import java.util.List;

/**
 * 影评
 */
@WebServlet("/yugao")
public class YugaoUploadServlet1 extends HttpServlet {
   YuGaoService yuGaoService=null;
    public YugaoUploadServlet1(){
        yuGaoService=new YuGaoServiceImpl();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //1 先判断上传的数据是否多段数据 （只有是多段的数据，才是文件上传的）
        if (ServletFileUpload.isMultipartContent(request)) {
            // 创建FileItemFactory 工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            YuGao yuGao=new YuGao();
             String oldPath="";
            try {
                //解析上传的数据 得到每一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(request);
                //循环判断，每一个表单项 是普通类型 还是上传的文件
                for (FileItem fileItem :
                        list) {
                    if (fileItem.isFormField()) {
                        //普通表单项
                        System.out.println("普通表单项 name = " + fileItem.getFieldName());
                        //参数UTF-8解决乱码
                        System.out.println("value = " + fileItem.getString());
                        String str=fileItem.getFieldName();
                        switch (fileItem.getFieldName()){

                            case "MovieName":
                                yuGao.setMovieName(fileItem.getString("utf-8"));
                                break;
                            case "MovieId":
                                yuGao.setMovieId(Integer.valueOf(fileItem.getString("utf-8")));
                                Integer id=(Integer.valueOf(fileItem.getString("utf-8")));
                                oldPath=yuGaoService.query(id).getPicAddress();
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
                        if (!fileItem.getName().equals("")) {
                            System.out.println("表单项的name = " + fileItem.getFieldName());
                            System.out.println("上传的文件名:" + fileItem.getName());
                            String str = fileItem.getName();
                            StringBuffer sb = new StringBuffer("D:\\upload\\");
                            sb.append(fileItem.getName());
                            String path = sb.toString();
                            yuGao.setPicAddress(path);
                            fileItem.write(new File(path));
                        } else {
                            yuGao.setPicAddress(oldPath);
                        }
                    }


                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Integer result=yuGaoService.update(yuGao);
            String str1=(result==1)?"1":"";
            response.getWriter().write(str1);
        }
    }


}
