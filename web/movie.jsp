<%@ page import="com.entity.Vip" %>
<%@ page import="com.entity.Film" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HongSiDa
  Date: 2020/12/22
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Movie</title>
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
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- start plugins -->
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <link href='#css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
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
<div class="container">
    <div class="container_wrap">
        <div class="header_top">
            <div class="col-sm-3 logo"><a href="index.jsp"><img src="images/logo.png" alt=""/></a></div>
            <div class="col-sm-6 nav">
                <ul>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="comic"><a
                            href="movie.jsp"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="movie"><a
                            href="movie.jsp"> </a> </span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="video"><a
                            href="movie.jsp"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="game"><a
                            href="movie.jsp"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="tv"><a
                            href="movie.jsp"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="more"><a
                            href="movie.jsp"> </a></span></li>
                </ul>
            </div>
            <div class="col-sm-3 header_right">
                <ul class="header_right_box">
                    <li id="vipInformation" style="margin-right: 10px"><a href="login.html">用户登陆</a></li>
                    <li id="menu"></li>
                    <a href="login.html">管理员登录</a>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="content">
            <h1 class="m_3">正在上映</h1>
            <div class="movie_top">
                <div class="col-md-9 movie_box">
                    <div id="tbody1"></div>
                    <script>
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
                            $.ajax({
                                url: "http://localhost:8000/architect/FilmServlet",
                                data: {action: "queryAll"},
                                type: "GET",
                                dataType: "text",
                                success: function (data) {
                                    movies(data);
                                }
                            })

                            function movies(data) {
                                let jsonObj = JSON.parse(data);
                                for (var i = 3; i < jsonObj.length; i++) {
                                    let imgpath = jsonObj[i].PicAddress;
                                    let Hits = jsonObj[i].Hits;
                                    let movieId = jsonObj[i].MovieId;
                                    imgpath = "http://localhost:8000" + imgpath.substring(2).replaceAll("\\", "/");
                                    let trNode = $("<div class=\"movie movie-test movie-test-dark movie-test-left\">");
                                    trNode.append("<div class=\"movie__images\"><a href=\"http://localhost:8000/architect/FilmServlet?action=queryOne&MovieId=" + movieId + "\" id='show" + i + "' class=\"movie-beta__link\">" +
                                        " <img alt=\"\" style='width: 250px;height: 240px;' src=\"" + imgpath + "\" class=\"img-responsive\" alt=\"\"/></a></div>" +
                                        "<div class=\"movie__info\"><a href=\"single.jsp\" style='font-size:19px' class=\"movie__title\">" + jsonObj[i].MovieName + "</a><br/>" +
                                        "<ul class=\"list_6\"><li><p>导演：" + jsonObj[i].DaoYan + "</p></li><li><p>主演：" + jsonObj[i].ZhuYan + "</p></li>" +
                                        "<li><p>上映时间：" + jsonObj[i].ShowTime + "</p></li><li><p>浏览量：<label id='ydl" + i + "'>" + Hits + "</label></p></li>" + "" +
                                        "<div class=\"clearfix\"> </div></div><br/>");
                                    $("#tbody1").append(trNode);
                                    window.onload = $(eval("show" + i)).click(function () {
                                        $.ajax({
                                            url: "http://localhost:8000/architect/FilmServlet",
                                            data: {action: "updateHit", MovieId: movieId},
                                            type: "GET",

                                            dataType: "text",
                                            success: function (data) {
                                                hits(data);
                                            }
                                        })

                                        function hits(data) {
                                            let jsonObj = JSON.parse(data);
                                            Hits = Hits + 1;
                                            $(eval("ydl" + i)).html(Hits);

                                        }
                                    });
                                }

                            }

                            $.ajax({
                                url: "http://localhost:8000/architect/YuGaoServlet",
                                data: {action: "queryAll"},
                                type: "GET",
                                dataType: "text",
                                success: function (data) {
                                    movie(data);
                                    movie2(data);
                                }
                            })

                            function movie(data) {
                                let jsonObj = JSON.parse(data);
                                for (var i = 0; i < jsonObj.length; i++) {
                                    let imgpath = jsonObj[i].PicAddress;
                                    let movieId = jsonObj[i].MovieId;
                                    imgpath = "http://localhost:8000" + imgpath.substring(2).replaceAll("\\", "/");
                                    let trNode = $("<li></li>");
                                    trNode.append("<a href=\"http://localhost:8000/architect/YuGaoServlet?action=queryOne&MovieId=" + movieId + "\"><img style='width: 240px;height: 300px' src=\"" + imgpath + "\" class=\"img-responsive\"/></a>");
                                    trNode.append("<div class=\"grid-flex\"><a href=\"#\">" + jsonObj[i].MovieName + "</a><p>" + jsonObj[i].ShowTime + "</p></div>")
                                    $("#flexiselDemo3").append(trNode);
                                }
                                $("#flexiselDemo3").flexisel({
                                    visibleItems: 4,
                                    animationSpeed: 1000,
                                    autoPlay: true,
                                    autoPlaySpeed: 3000,
                                    pauseOnHover: true,
                                    enableResponsiveBreakpoints: true,
                                    responsiveBreakpoints: {
                                        portrait: {
                                            changePoint: 480,
                                            visibleItems: 1
                                        },
                                        landscape: {
                                            changePoint: 640,
                                            visibleItems: 2
                                        },
                                        tablet: {
                                            changePoint: 768,
                                            visibleItems: 3
                                        }
                                    }
                                });
                            }

                            function movie2(data) {
                                let jsonObj = JSON.parse(data);
                                for (var i = 0; i < jsonObj.length; i++) {
                                    let imgpath = jsonObj[i].PicAddress;
                                    let movieId = jsonObj[i].MovieId;
                                    imgpath = "http://localhost:8000" + imgpath.substring(2).replaceAll("\\", "/");
                                    let trNode = $("<li></li>");
                                    trNode.append("<a href=\"http://localhost:8000/architect/YuGaoServlet?action=queryOne&MovieId=" + movieId + "\"><img style='width: 240px;height: 300px' src=\"" + imgpath + "\" class=\"img-responsive\"/></a>");
                                    trNode.append("<div class=\"grid-flex\"><a href=\"#\">" + jsonObj[i].MovieName + "</a><p>" + jsonObj[i].ShowTime + "</p></div>")
                                    $("#flexiselDemo1").append(trNode);
                                }
                                $("#flexiselDemo1").flexisel({
                                    visibleItems: 4,
                                    animationSpeed: 1000,
                                    autoPlay: true,
                                    autoPlaySpeed: 3000,
                                    pauseOnHover: true,
                                    enableResponsiveBreakpoints: true,
                                    responsiveBreakpoints: {
                                        portrait: {
                                            changePoint: 480,
                                            visibleItems: 1
                                        },
                                        landscape: {
                                            changePoint: 640,
                                            visibleItems: 2
                                        },
                                        tablet: {
                                            changePoint: 768,
                                            visibleItems: 3
                                        }
                                    }
                                });
                            }
                        })
                    </script>

                </div>
                <div class="col-md-3">
                    <div class="movie_img">
                        <div class="grid_2">
                            <img src="images/pic6.jpg" class="img-responsive" alt="">
                            <div class="caption1">
                                <ul class="list_5 list_7">
                                    <li><i class="icon5"> </i>
                                        <p>3,548</p></li>
                                </ul>
                                <i class="icon4 icon6 icon7"> </i>
                                <p class="m_3">Guardians of the Galaxy</p>
                            </div>
                        </div>
                    </div>
                    <div class="grid_2 col_1">
                        <img src="images/pic2.jpg" class="img-responsive" alt="">
                        <div class="caption1">
                            <ul class="list_3 list_7">
                                <li><i class="icon5"> </i>
                                    <p>3,548</p></li>
                            </ul>
                            <i class="icon4 icon7"> </i>
                            <p class="m_3">Guardians of the Galaxy</p>
                        </div>
                    </div>
                    <div class="grid_2 col_1">
                        <img src="images/pic9.jpg" class="img-responsive" alt="">
                        <div class="caption1">
                            <ul class="list_3 list_7">
                                <li><i class="icon5"> </i>
                                    <p>3,548</p></li>
                            </ul>
                            <i class="icon4 icon7"> </i>
                            <p class="m_3">Guardians of the Galaxy</p>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
            <script type="text/javascript" src="js/jquery.flexisel.js"></script>
            <h1 class="recent">即将上映</h1>
            <ul id="flexiselDemo3">

            </ul>


            <script type="text/javascript">
                $(window).load(function () {


                });
            </script>
            <ul id="flexiselDemo1">

            </ul>
            <script type="text/javascript">
                $(window).load(function () {
                    $("#flexiselDemo1").flexisel({
                        visibleItems: 4,
                        animationSpeed: 1000,
                        autoPlay: true,
                        autoPlaySpeed: 3000,
                        pauseOnHover: true,
                        enableResponsiveBreakpoints: true,
                        responsiveBreakpoints: {
                            portrait: {
                                changePoint: 480,
                                visibleItems: 1
                            },
                            landscape: {
                                changePoint: 640,
                                visibleItems: 2
                            },
                            tablet: {
                                changePoint: 768,
                                visibleItems: 3
                            }
                        }
                    });

                });
            </script>
        </div>
    </div>
</div>
<div class="container">
    <footer id="footer">
        <div id="footer-3d">
            <div class="gp-container">
                <span class="first-widget-bend"></span>
            </div>
        </div>
        <div id="footer-widgets" class="gp-footer-larger-first-col">
            <div class="gp-container">

                <div class="clearfix"></div>
            </div>
            <div class="clearfix"></div>
        </div>
</div>
</footer>
</div>
</body>
</html>