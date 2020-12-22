<%@ page import="com.entity.Film" %>
<%@ page import="com.service.CommentService" %>
<%@ page import="com.service.impl.CommentServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.Comment" %>
<%@ page import="com.entity.YuGao" %>
<%@ page import="com.entity.Vip" %><%--
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
    <script type="text/javascript">
        $(function () {
            <%
   List<Film> films=(List<Film>) request.getSession().getAttribute("film");
//   System.out.println(films.get(0).getPicAddress());
   Vip vip= (Vip) request.getSession().getAttribute("vip");
   if (vip!=null){   %>
            $("#vipInformation").empty();
            $("#vipInformation").html("当前用户:<%=vip.getUserName()%>");
            $("#menu").append("<div class=\"dropdown\" style=\"z-index: 100; position: relative;\">\n" +
                "                            <button class=\"dropbtn\">下拉菜单</button>\n" +
                "                            <div class=\"dropdown-content\">\n" +
                "                                <a href=\"updatepassword.jsp\" data-toggle=\"modal\" data-target=\"#myModal\">修改密码</a>\n" +
                "                                <a href=\"vipout.jsp\">退出</a>\n" +
                "                            </div>\n" +
                "                        </div>")
            <% }
            %>
        })
    </script>
    <style>
        /* 下拉按钮样式 */
        .dropbtn {
            background-color: white;
            color: black;
            padding: 8px;
            font-size: 14px;
            border: none;
            cursor: pointer;
        }

        /* 容器 <div> - 需要定位下拉内容 */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        /* 下拉内容 (默认隐藏) */
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
        }

        /* 下拉菜单的链接 */
        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        /* 鼠标移上去后修改下拉菜单链接颜色 */
        .dropdown-content a:hover {
            background-color: #f1f1f1
        }

        /* 在鼠标移上去后显示下拉菜单 */
        .dropdown:hover .dropdown-content {
            display: block;
        }

        /* 当下拉内容显示后修改下拉按钮的背景颜色 */
        .dropdown:hover .dropbtn {
            background-color: grey;
        }
    </style>
</head>
<body>
<%
    YuGao yuGao = (YuGao) request.getSession().getAttribute("yuGao1");
    String imgpath = yuGao.getPicAddress();
    imgpath = "http://localhost:8000" + imgpath.substring(2).replaceAll("\\\\", "/");
    String typeId = yuGao.getTypeId();
    String daoYan = yuGao.getDaoYan();
    String zhuYan = yuGao.getZhuYan();
    String showTime = yuGao.getShowTime();
%>

<div class="container">
    <div class="container_wrap">
        <div class="header_top">
            <div class="col-sm-3 logo"><a href="index.jsp"><img src="" alt=""/></a></div>
            <div class="col-sm-6 nav">
                <ul>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="comic"><a
                            href=" movie.jsp"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="movie"><a
                            href=" movie.jsp"> </a> </span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="video"><a
                            href=" movie.jsp"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="game"><a
                            href=" movie.jsp"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="tv"><a
                            href=" movie.jsp"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="more"><a
                            href=" movie.jsp"> </a></span></li>
                </ul>
            </div>
            <div class="col-sm-3 header_right">
                <ul class="header_right_box">
                    <li id="vipInformation"><a href="login.html">用户登陆</a></li>
                    <li id="menu"></li>
                    <a href="login.html">管理员登录</a>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>

        <div style="height: 1000px;" class="content">
            <div class="movie_top">
                <div class="col-md-9 movie_box">
                    <div class="grid images_3_of_2">
                        <div class="movie_image">
                            <img src="<%=imgpath%>" class="img-responsive" alt=""/>
                        </div>
                    </div>
                    <div style="line-height: 30px" class="desc1 span_3_of_2">
                        <p class="movie_option"><strong>电影名: </strong><a href="#"><%=yuGao.getMovieName()%>
                        </a></p>
                        <p class="movie_option"><strong>电影类型: </strong><%=typeId%>
                        </p>
                        <p class="movie_option"><strong>导演: </strong><a href="#"><%=daoYan%>
                        </a></p>
                        <p class="movie_option"><strong>主演: </strong><%=zhuYan%>
                        </p>
                        <p class="movie_option"><strong>上映时间: </strong><a href="#"><%=showTime%>
                        </a></p>
                    </div>
                    <div class="clearfix"></div>
                    </p>
                </div>
                <script>
                    $(function () {
                        $.ajax({
                            url: "http://localhost:8000/architect/FilmServlet",
                            data: {action: "orderByHits"},
                            type: "GET",
                            dataType: "text",
                            success: function (data) {
                                movie(data);
                            }
                        })
                        function movie(data) {
                            let jsonObj = JSON.parse(data);
                            for (let i = 0; i < 3; i++) {
                                let movieName = jsonObj[i].MovieName;
                                let hits = jsonObj[i].Hits;
                                let imgpath = jsonObj[i].PicAddress;
                                let movieId = jsonObj[i].MovieId;
                                imgpath = "http://localhost:8000" + imgpath.substring(2).replaceAll("\\", "/");
                                let trNode="<a href=\"http://localhost:8000/architect/FilmServlet?action=queryOne&MovieId=" + movieId + "\">" +
                                    "<img style='width: 200px;height: 240px;margin-left: 30px' src=\"" + imgpath + "\" class=\"img-responsive\"/>" +
                                    "<div style='text-align: center;padding-right: 80px' class=\"grid-flex\"><a href=\"#\">" + movieName + "</a><p>浏览量：" + hits + "</p></div></a>";
                                $("#tbody").append(trNode);
                            }
                        }
                    })
                </script>
                <div style="position: absolute;top:210px ;left: 1030px" id="tbody" class="col-md-3">
                    <span style="padding-left: 95px;font-size:25px">热搜榜</span><br/>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
