<%@ page import="com.entity.Film" %>
<%@ page import="com.service.CommentService" %>
<%@ page import="com.service.impl.CommentServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.Comment" %><%--
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
    <link href="/architect/moban934/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="/architect/moban934/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- start plugins -->
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <link href='#css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
</head>
<body>

<%
    Film film = (Film) request.getSession().getAttribute("film1");
    String imgpath = film.getPicAddress();
    imgpath = "http://localhost:8000" + imgpath.substring(2).replaceAll("\\\\", "/");
    String typeId = film.getTypeId();
    String daoYan = film.getDaoYan();
    String zhuYan = film.getZhuYan();
    String showTime = film.getShowTime();
    String content = film.getContent();
    Integer hits = film.getHits();
    Integer movieid=film.getMovieId();
%>

<div class="container">
    <div class="container_wrap">
        <div class="header_top">
            <div class="col-sm-3 logo"><a href="index.jsp"><img src="" alt=""/></a></div>
            <div class="col-sm-6 nav">
                <ul>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="comic"><a
                            href="/architect/moban934/movie.html"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="movie"><a
                            href="/architect/moban934/movie.html"> </a> </span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="video"><a
                            href="/architect/moban934/movie.html"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="game"><a
                            href="/architect/moban934/movie.html"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="tv"><a
                            href="/architect/moban934/movie.html"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="more"><a
                            href="/architect/moban934/movie.html"> </a></span></li>
                </ul>
            </div>
            <div class="col-sm-3 header_right">
                <ul class="header_right_box">
                    <li><img src="/architect/moban934/images/p1.png" alt=""/></li>
                    <li><p><a href="login.html">Carol Varois</a></p></li>
                    <li class="last"><i class="edit"> </i></li>
                    <div class="clearfix"></div>
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
                    </div>
                    <div class="clearfix"></div>
                    <p class="m_4"><%=content%>
                    </p>
                    <form action="http://localhost:8000/architect/AddCommentServlet?MovieId=<%=movieid%>" method="post" >
                        <input name="action" type="hidden" value="sendcomment"/>
                        <%
                            session.setAttribute("MovieId",film.getMovieId());
                            session.setAttribute("CommentTypeId",film.getTypeId());
                        %>
                        <div class="text">
                            <textarea name="message" id="message" class="message"  onfocus="this.value = '';"
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
                        Integer movieId = film1.getMovieId();
                        CommentService commentService = new CommentServiceImpl();
                        List<Comment> commentList = commentService.queryCommentByMovieId(movieId);
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
                <div class="col-md-3">
                    <div class="movie_img">
                        <div class="grid_2">
                            <img src="/architect/moban934/images/pic6.jpg" class="img-responsive" alt="">
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
                        <img src="/architect/moban934/images/pic2.jpg" class="img-responsive" alt="">
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
                        <img src="/architect/moban934/images/pic9.jpg" class="img-responsive" alt="">
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
        </div>
    </div>
</div>
<div class="container">
    <footer id="footer">
        <div id="footer-3d">
            <div class="gp-container">
                <span class="first-widget-bend"> </span>
            </div>
        </div>
        <div id="footer-widgets" class="gp-footer-larger-first-col">
            <div class="gp-container">
                <div class="footer-widget footer-1">
                    <div class="wpb_wrapper">
                        <img src="images/f_logo.png" alt=""/>
                    </div>
                    <br>
                    <p>It is a long established fact that a reader will be distracted by the readable content of a
                        page.</p>
                    <p class="text">There are many variations of passages of Lorem Ipsum available, but the majority
                        have suffered.</p>
                </div>
                <div class="footer_box">
                    <div class="col_1_of_3 span_1_of_3">
                        <h3>Categories</h3>
                        <ul class="first">
                            <li><a href="#">Dance</a></li>
                            <li><a href="#">History</a></li>
                            <li><a href="#">Specials</a></li>
                        </ul>
                    </div>
                    <div class="col_1_of_3 span_1_of_3">
                        <h3>Information</h3>
                        <ul class="first">
                            <li><a href="#">New products</a></li>
                            <li><a href="#">top sellers</a></li>
                            <li><a href="#">Specials</a></li>
                        </ul>
                    </div>
                    <div class="col_1_of_3 span_1_of_3">
                        <h3>Follow Us</h3>
                        <ul class="first">
                            <li><a href="#">Facebook</a></li>
                            <li><a href="#">Twitter</a></li>
                            <li><a href="#">Youtube</a></li>
                        </ul>
                        <div class="copy">
                            <p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank"
                                                                                         href="http://guantaow.taobao.com/">厚朴网络淘宝店</a><a
                                    target="_blank" href="http://www.moobnn.com">网页模板</a></p>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </footer>
</div>
</body>
</html>
