<%@ page import="com.entity.Film" %>
<%@ page import="com.service.CommentService" %>
<%@ page import="com.service.impl.CommentServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.Comment" %>
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

    <title>Single</title>
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



    <%--    投票--%>
    <script type="text/javascript">
        $(function () {
            <%
                   Vip vip = (Vip) request.getSession().getAttribute("vip");
                   Film film = (Film) request.getSession().getAttribute("film1");
                   String imgpath = film.getPicAddress();
                   imgpath = "http://localhost:8000" + imgpath.substring(2).replaceAll("\\\\", "/");
                   String typeId = film.getTypeId();
                   String daoYan = film.getDaoYan();
                   String zhuYan = film.getZhuYan();
                   String showTime = film.getShowTime();
                   String content = film.getContent();
                   Integer hits = film.getHits();
                   Integer movieId = film.getMovieId();
              
   List<Film> films=(List<Film>) request.getSession().getAttribute("film");
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

            function init() {
                let movieName = "<%=film.getMovieName()%>";
                $.ajax({
                    url: "http://localhost:8000/architect/toupiao.do",
                    data: {action: "queryCount", movieName: movieName},
                    type: "GET",
                    dataType: "text",
                    success: function (data) {
                        let jsonObj = JSON.parse(data);
                        $("#toupiao").html(jsonObj)
                    }
                })
            }

            $("#btn").on("click", function () {
                let vipName = "";
                <%
                if(vip!=null){%>
                vipName = "<%=vip.getUserName()%>";
                <%--<% } %>--%>
                let movieName = "<%=film.getMovieName()%>";
                $.ajax({
                    url: "http://localhost:8000/architect/toupiao.do",
                    data: {action: "query", vipName: vipName, movieName: movieName},
                    type: "GET",
                    dataType: "text",
                    success: function (data) {
                        if (data > 0) {
                            //调用投票
                            vote();
                        } else {
                            alert("您已经投过票")
                        }
                    }
                })
                <% } else if(vip==null){%>
                alert("您还未登录");
                window.location.href = "/login.html";
                <%  }%>

            })


            init();

            function vote() {
                let vipName = "";
                <%
                if(vip!=null){%>
                vipName =<%=vip.getUserName()%>;
                let movieName = "<%=film.getMovieName()%>";
                $.ajax({
                    url: "http://localhost:8000/architect/toupiao.do",
                    data: {action: "insert", vipName: vipName, movieName: movieName},
                    type: "GET",
                    dataType: "text",
                    success: function (data) {
                        alert("投票成功");
                        Hits = Hits + 1;
                        $("#toupiao").html(Hits);
                    }
                })
                <% } %>
            }

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


<div class="container">
    <div class="container_wrap">
        <div class="header_top">
            <div class="col-sm-3 logo"><a href="index.jsp"><img src="" alt=""/></a></div>
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
                    <li id="vipInformation"><a href="login.html">用户登陆</a></li>
                    <li id="menu"></li>
                    <a href="adminlogin.html">管理员登录</a>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>

        <div class="content">
            <div class="movie_top">
                <div class="col-md-9 movie_box">
                    <div class="grid images_3_of_2">
                        <div class="movie_image">
                            <img src="<%=imgpath%>" class="img-responsive" alt=""/>
                        </div>
                    </div>
                    <div style="line-height: 30px" class="desc1 span_3_of_2">
                        <p class="movie_option"><strong>电影名: </strong><a href="#"><%=film.getMovieName()%>
                        </a></p>
                        <p class="movie_option"><strong>电影类型: </strong><%=typeId%>
                        </p>
                        <p class="movie_option"><strong>导演: </strong><a href="#"><%=daoYan%>
                        </a></p>
                        <p class="movie_option"><strong>主演: </strong><%=zhuYan%>
                        </p>
                        <p class="movie_option"><strong>上映时间: </strong><a href="#"><%=showTime%>
                        </a></p>
                        <p class="movie_option"><strong>浏览量: </strong><a href="#"><%=hits%>
                        </a></p>
                        <p class="movie_option"><strong>投票数: </strong><a id="toupiao" href="#">
                        </a></p>
                        <div class="down_btn">
                            <button id="btn">投票</button>
                        </div>

                    </div>
                    <div class="clearfix"></div>
                    <p class="m_4"><%=content%>
                    </p>
                    <form action="http://localhost:8000/architect/AddCommentServlet?MovieId=<%=movieId%>" method="post">
                        <input name="action" type="hidden" value="sendcomment"/>
                        <%
                            session.setAttribute("MovieId", film.getMovieId());
                            session.setAttribute("CommentTypeId", film.getTypeId());
                        %>
                        <div class="text">
                            <textarea name="message" id="message" class="message" onfocus="this.value = '';"
                            ></textarea>
                        </div>
                        <div class="form-submit1">
                            <button type="submit" name="submit" id="submit">发表评论</button>
                            <br>
                        </div>
                        <div class="clearfix"></div>
                    </form>

                    <%
                        Film film1 = (Film) request.getSession().getAttribute("film1");
                        Integer movieId2 = film1.getMovieId();
                        CommentService commentService = new CommentServiceImpl();
                        List<Comment> commentList = commentService.queryCommentByMovieId(movieId2);
                    %>


                    <div class="single">
                        <h1><%=commentList.size()%> Comments</h1>
                        <ul class="single_list">

                            <%
                                for (int i = 0; i < commentList.size(); i++) {
                                    String commentTime = commentList.get(i).getCommentTime();
                                    commentTime = commentTime.substring(0, 19);
                            %>
                            <li>
                                <div class="data">
                                    <div class="title"><%=commentList.get(i).getCommentUser()%> / <%=commentTime%> / <a
                                            href="#">reply</a></div>
                                    <p><%=commentList.get(i).getCommentContent()%>
                                    </p>
                                </div>
                                <div class="clearfix"></div>
                            </li>

                            <%
                                }
                            %>
                        </ul>
                    </div>
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
