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
    <link href=" /architect/moban934/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href=" /architect/moban934/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- start plugins -->
    <script type="text/javascript" src=" /architect/moban934/js/jquery-1.11.1.min.js"></script>
    <link href='#css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="container">
    <div class="container_wrap">
        <div class="header_top">
            <div class="col-sm-3 logo"><a href="/architect/moban934/index.jsp"><img src="/architect/moban934/images/logo.png" alt=""/></a></div>
            <div class="col-sm-6 nav">
                <ul>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="comic"><a
                            href=" /architect/moban934/movie.html"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="movie"><a
                            href=" /architect/moban934/movie.html"> </a> </span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="video"><a
                            href=" /architect/moban934/movie.html"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="game"><a
                            href=" /architect/moban934/movie.html"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="tv"><a
                            href=" /architect/moban934/movie.html"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="more"><a
                            href=" /architect/moban934/movie.html"> </a></span></li>
                </ul>
            </div>
            <div class="col-sm-3 header_right">
                <ul class="header_right_box">
                    <li><img src=" /architect/moban934/images/p1.png" alt=""/></li>
                    <li><p><a href="/architect/moban934/login.html">Carol Varois</a></p></li>
                    <li class="last"><i class="edit"> </i></li>
                    <div class="clearfix"></div>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>

        <%--<script>--%>
        <%--$(function () {--%>
        <%--$.ajax({--%>
        <%--url: "http://localhost:8000/architect//notice.do",--%>
        <%--data: {action: "queryNoticeAll"},--%>
        <%--type: "GET",--%>
        <%--dataType: "text",--%>
        <%--success: function (data) {--%>
        <%--notice(data)--%>
        <%--}--%>
        <%--})--%>

        <%--function notice(data) {--%>
        <%--let jsonObj = JSON.parse(data);--%>

        <%--let neirong = jsonObj[i].neirong;--%>
        <%--let trNode = "<div style='line-height: 35px'><a style='float: left' >" + jsonObj[i].title + "</a>" +--%>
        <%--"<a style='padding-left: 100px'>" + neirong + "</a>" +--%>
        <%--"<a style='float: right;padding-right: 30px' >" + jsonObj[i].time + "</a><br></div>"--%>
        <%--$("#tbody").append(trNode);--%>
        <%--}--%>
        <%--}--%>
        <%--})--%>
        <%--</script>--%>
        <%
            Notice notice = (Notice) request.getSession().getAttribute("notice1");

        %>
        <div style="height: 1000px;" class="content">
            <div class="movie_top">
                <div style=" width: 1150px" class="col-md-9 movie_box">
                    <div style="margin-left: 200px;width: 680px">
                        <h2 style="text-align: center">网站公告</h2><br/>
                        <h3 align="center"><%=notice.getTitle()%></h3>
                        <span style="text-align: center;font-size: 15px;line-height: 30px;letter-spacing: 1px"><%=notice.getNeirong()%></span><br/>
                        <p style="float: right;position: absolute;left: 800px;top: 800px"><%=notice.getTime()%></p>
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
