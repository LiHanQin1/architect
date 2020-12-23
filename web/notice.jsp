<%@ page import="com.entity.Film" %>
<%@ page import="com.service.CommentService" %>
<%@ page import="com.service.impl.CommentServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.Comment" %>
<%@ page import="com.entity.YuGao" %>
<%@ page import="com.entity.Notice" %><%--
  Created by IntelliJ IDEA.
  User: 14286
  Date: 2020/12/18
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
<!DOCTYPE HTML>
<html>
<head>

    <title>Yugao</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Movie_store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <link href=" css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href=" css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- start plugins -->
    <script type="text/javascript" src=" js/jquery-1.11.1.min.js"></script>
    <link href='#css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="container">
    <div class="container_wrap">
        <div class="header_top">
            <div class="col-sm-3 logo"><a href="index.jsp"><img src="images/logo.png" alt=""/></a></div>
            <div class="col-sm-6 nav">
                <ul>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="comic"><a
                            href=" movie.html"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="movie"><a
                            href=" movie.html"> </a> </span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="video"><a
                            href=" movie.html"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="game"><a
                            href=" movie.html"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="tv"><a
                            href=" movie.html"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="more"><a
                            href=" movie.html"> </a></span></li>
                </ul>
            </div>
            <div class="col-sm-3 header_right">
                <ul class="header_right_box">
                    <li><img src=" images/p1.png" alt=""/></li>
                    <li><p><a href="login.html">Carol Varois</a></p></li>
                    <li class="last"><i class="edit"> </i></li>
                    <div class="clearfix"></div>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>

        <%
            Notice notice = (Notice) request.getSession().getAttribute("notice1");

        %>
        <div style="height: 1000px;" class="content">
            <div class="movie_top">
                <div style=" width: 1150px" class="col-md-9 movie_box">
                    <div style="margin-left: 200px;width: 680px">
                        <h2 style="text-align: center"><b>网站公告</b></h2><br/>
                        <h3 align="center"><%=notice.getTitle()%></h3>

                    </div>
                    <div style="padding-top: 100px;width: 900px">
                        <span style="text-align: center;font-size: 15px;line-height: 30px;letter-spacing: 1px"><%=notice.getNeirong()%></span><br/>
                        <p style="float: right;padding-top: 80px;position: absolute;left: 800px;top: 400px"><%=notice.getTime()%></p>
                    </div>

                    <div class="clearfix"></div>

                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
