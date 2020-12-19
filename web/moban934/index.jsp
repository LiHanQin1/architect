<%@ page import="com.entity.Film" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 14286
  Date: 2020/12/18
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Movie_store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- start plugins -->
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <link href='#css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
    <script src="js/responsiveslides.min.js"></script>
    <script>
        $(function () {
            $("#slider").responsiveSlides({
                auto: true,
                nav: true,
                speed: 500,
                namespace: "callbacks",
                pager: true,
            });
        });
    </script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url: "http://localhost:8000/architect/FilmServlet",
                data: {action: "queryPicAddress"},
                type: "GET",
                dataType: "text",
                success: function (data) {
                    address(data);
                }
            });

            function address(data) {
                let jsonObj = JSON.parse(data);
                for (let i = 0; i < 3; i++) {
                    let trNode = $("<li></li>");
                    let imgpath = jsonObj[i].PicAddress;
                    imgpath = "http://localhost:8000" + imgpath.substring(2).replaceAll("\\", "/");
                    console.log(imgpath)
                    trNode.append("<img  class='img-responsive' src=\'" + imgpath + "\'>");
                    $("#slider").append(trNode);

                }

            }
        })
    </script>

</head>
<body>
<%
    List<Film> films=(List<Film>) request.getSession().getAttribute("film");
//    System.out.println(films.get(0).getPicAddress());
%>
<div class="container">
    <div class="container_wrap">
        <div class="header_top">
            <div class="col-sm-3 logo"><a href="index.html"><img src="images/logo.png" alt=""/></a></div>
            <div class="col-sm-6 nav">
                <ul>
                    <li> <span class="simptip-position-bottom simptip-movable" data-tooltip="影片"><a href="movie.html"> </a></span></li>

                </ul>
            </div>
            <div class="col-sm-3 header_right">
                <ul class="header_right_box">
                    <li><img src="images/p1.png" alt=""/></li>
                    <li><p><a href="login.html">Carol Varois</a></p></li>
                    <li class="last"><i class="edit"> </i></li>
                    <div class="clearfix"> </div>
                </ul>
            </div>
            <div class="clearfix"> </div>
        </div>


        <div class="slider">
            <div class="callbacks_container">
                <ul class="rslides" id="slider">
                    <li><img src=<%=films.get(0).getPicAddress().substring(2)%> class="img-responsive" alt="">
                    </li>
                    <li><img src=<%=films.get(1).getPicAddress().substring(2)%> class="img-responsive" alt="">
                    </li>
                    <li><img src=<%=films.get(2).getPicAddress().substring(2)%> class="img-responsive" alt="">
                    </li>
                </ul>
            </div>

            <div class="banner_desc">
                <div class="col-md-9">
                    <ul class="list_1">
                        <li>发布时间<span class="m_1">2015年5月1日</span></li>
                        <li>评分 <span class="m_1"><img src="images/rating.png" alt=""/></span></li>
                    </ul>
                </div>
                <div class="col-md-3 grid_1">
                    <ul class="list_1 list_2">
                        <li><i class="icon1"> </i><p>2,548</p></li>
                        <li><i class="icon2"> </i><p>215</p></li>
                        <li><i class="icon3"> </i><p>546</p></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="content">
            <div class="box_1">
                <h1 class="recent">热门电影</h1>
                <ul id="flexiselDemo3">
                    <li><img src="images/1.jpg" class="img-responsive"/><div class="grid-flex"><a href="#">Syenergy 2mm</a><p>22.10.2014 | 14:40</p></div></li>
                    <li><img src="images/2.jpg" class="img-responsive"/><div class="grid-flex"><a href="#">Surf Yoke</a><p>22.01.2015 | 14:40</p></div></li>
                    <li><img src="images/3.jpg" class="img-responsive"/><div class="grid-flex"><a href="#">Salty Daiz</a><p>22.10.2013 | 14:40</p></div></li>
                    <li><img src="images/4.jpg" class="img-responsive"/><div class="grid-flex"><a href="#">Cheeky Zane</a><p>22.10.2014 | 14:40</p></div></li>
                    <li><img src="images/5.jpg" class="img-responsive"/><div class="grid-flex"><a href="#">Synergy</a><p>22.10.2013 | 14:40</p></div></li>
                </ul>
                <script type="text/javascript">
                    $(window).load(function() {
                        $("#flexiselDemo3").flexisel({
                            visibleItems: 4,
                            animationSpeed: 1000,
                            autoPlay: true,
                            autoPlaySpeed: 3000,
                            pauseOnHover: true,
                            enableResponsiveBreakpoints: true,
                            responsiveBreakpoints: {
                                portrait: {
                                    changePoint:480,
                                    visibleItems: 1
                                },
                                landscape: {
                                    changePoint:640,
                                    visibleItems: 2
                                },
                                tablet: {
                                    changePoint:768,
                                    visibleItems: 3
                                }
                            }
                        });

                    });
                </script>
                <script type="text/javascript" src="js/jquery.flexisel.js"></script>
                <ul id="flexiselDemo1">
                    <li><img src="images/8.jpg" class="img-responsive"/><div class="grid-flex"><a href="#">Syenergy 2mm</a><p>22.10.2014 | 14:40</p></div></li>
                    <li><img src="images/7.jpg" class="img-responsive"/><div class="grid-flex"><a href="#">Surf Yoke</a><p>22.01.2015 | 14:40</p></div></li>
                    <li><img src="images/6.jpg" class="img-responsive"/><div class="grid-flex"><a href="#">Salty Daiz</a><p>22.10.2013 | 14:40</p></div></li>
                    <li><img src="images/1.jpg" class="img-responsive"/><div class="grid-flex"><a href="#">Cheeky Zane</a><p>22.10.2014 | 14:40</p></div></li>
                    <li><img src="images/2.jpg" class="img-responsive"/><div class="grid-flex"><a href="#">Synergy</a><p>22.10.2013 | 14:40</p></div></li>
                </ul>
                <script type="text/javascript">
                    $(window).load(function() {
                        $("#flexiselDemo1").flexisel({
                            visibleItems: 4,
                            animationSpeed: 1000,
                            autoPlay: true,
                            autoPlaySpeed: 3000,
                            pauseOnHover: true,
                            enableResponsiveBreakpoints: true,
                            responsiveBreakpoints: {
                                portrait: {
                                    changePoint:480,
                                    visibleItems: 1
                                },
                                landscape: {
                                    changePoint:640,
                                    visibleItems: 2
                                },
                                tablet: {
                                    changePoint:768,
                                    visibleItems: 3
                                }
                            }
                        });

                    });
                </script>

                <div class="container">
                    <footer id="footer">
                        <div id="footer-3d">
                            <div class="gp-container">
                                <span class="first-widget-bend"></span>
                            </div>
                        </div>
                        <div id="footer-widgets" class="gp-footer-larger-first-col">
                            <div class="gp-container">
                                <div class="footer-widget footer-1">
                                    <div class="wpb_wrapper">
                                        <img src="images/f_logo.png" alt=""/>
                                    </div>
                                    <br>
                                    <p>公告</p>
                                    <p class="text">公告</p>
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
                                            <p>Copyright &copy; 2020.Company name All rights reserved.<a target="_blank" href="http://guantaow.taobao.com/"></a><a target="_blank" href="http://www.moobnn.com">影评</a></p>
                                        </div>
                                    </div>
                                    <div class="clearfix"> </div>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                        </div>
                    </footer>
                </div>
</body>
</html>
