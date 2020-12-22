<%@ page import="com.entity.Film" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.Vip" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home</title>
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
                "                                <a href=\"updatepassword.jsp\" >修改密码</a>\n" +
                "                                <a href=\"vipout.jsp\">退出</a>\n" +
                "                            </div>\n" +
                "                        </div>")
            <% }
            %>
        })
    </script>

    <script type="text/javascript">
        $(window).load(function () {
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

        });
    </script>

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
            <div class="col-sm-3 logo"><a href="index.jsp"><img
                    src="images/logo.png" alt=""/></a></div>
            <div class="col-sm-6 nav">
                <ul>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="影片"><a
                            href="movie.jsp"> </a></span></li>

                </ul>
            </div>
            <div class="col-sm-3 header_right">
                <ul class="header_right_box">
                    <li id="vipInformation"><a href="login.html">用户登陆</a></li>
                    <%--<li class="last"><i class="edit"></i></li>--%>
                    <li id="menu"></li>
                    <a href="login.html">管理员登录</a>
                    <%--<div class="clearfix"> </div>--%>
                </ul>
            </div>


            <div class="clearfix"></div>
        </div>


        <div class="slider">
            <div class="callbacks_container">
                <ul class="rslides" id="slider">
                    <li>
                        <div id="a2"></div>
                    </li>
                    <li>
                        <div id="a1"></div>
                    </li>
                    <li>
                        <div id="a0"></div>
                    </li>
                </ul>
            </div>
            <script>
                $(function () {
                    $.ajax({
                        url: "http://localhost:8000/architect/FilmServlet",
                        data: {action: "queryAll"},
                        type: "GET",
                        dataType: "text",
                        success: function (data) {
                            address(data);
                        }
                    })

                    function address(data) {
                        let jsonObj = JSON.parse(data);
                        for (let i = 2; i >= 0; i--) {
                            let hits = jsonObj[i].Hits;
                            let movieName = jsonObj[i].MovieName;
                            let showTime = jsonObj[i].ShowTime;
                            showTime = showTime.substring(0, 10);
                            let trNode = "<img src='" + jsonObj[i].PicAddress.substring(2) + "' class=\"img-responsive\" alt=\"\">"
                                + "<div class=\"banner_desc\"><div class=\"col-md-3 grid_1\">" +
                                "<span style=\"color: white \">浏览量：" + hits + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>" +
                                "<span style=\"color: white \">" + movieName + "</span>" +
                                "</div></div>";
                            $(eval("a" + i)).append(trNode);
                        }
                    }
                })
            </script>


        </div>
        <div class="content">
            <div class="box_1">
                <h1 class="recent">热门电影</h1>
                <ul id="flexiselDemo3">

                </ul>
                <script>
                    $(function () {
                        $.ajax({
                            url: "http://localhost:8000/architect/FilmServlet",
                            data: {action: "queryAll"},
                            type: "GET",
                            dataType: "text",
                            success: function (data) {
                                movie(data);
                                movie2(data)
                            }
                        })

                        function movie(data) {
                            let jsonObj = JSON.parse(data);
                            for (var i = 3; i < jsonObj.length; i++) {
                                let imgpath = jsonObj[i].PicAddress;
                                let movieId = jsonObj[i].MovieId;
                                imgpath = "http://localhost:8000" + imgpath.substring(2).replaceAll("\\", "/");
                                let trNode = $("<li></li>");
                                trNode.append("<a href=\"http://localhost:8000/architect/FilmServlet?action=queryOne&MovieId=" + movieId + "\"><img style='width: 240px;height: 300px' src=\"" + imgpath + "\" class=\"img-responsive\"/>");
                                trNode.append("<div class=\"grid-flex\"><a href=\"#\">" + jsonObj[i].MovieName + "</a><p>" + jsonObj[i].ShowTime + "</p></div></a>")
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
                    })
                </script>


                <script type="text/javascript" src="js/jquery.flexisel.js"></script>
                <ul id="flexiselDemo1">

                </ul>
                <script>
                    function movie2(data) {
                        let jsonObj = JSON.parse(data);
                        for (var i = 3; i < jsonObj.length; i++) {
                            let imgpath = jsonObj[i].PicAddress;
                            let movieId = jsonObj[i].MovieId;
                            imgpath = "http://localhost:8000" + imgpath.substring(2).replaceAll("\\", "/");
                            let trNode = $("<li></li>");
                            trNode.append("<a href=\"http://localhost:8000/architect/FilmServlet?action=queryOne&MovieId=" + movieId + "\"><img style='width: 240px;height: 300px' src=\"" + imgpath + "\" class=\"img-responsive\"/>");
                            trNode.append("<div class=\"grid-flex\"><a href=\"#\">" + jsonObj[i].MovieName + "</a><p>" + jsonObj[i].ShowTime + "</p></div></a>")
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
                </script>
                <script>
                    $(function () {
                        $.ajax({
                            url: "http://localhost:8000/architect//notice.do",
                            data: {action: "queryNoticeAll"},
                            type: "GET",
                            dataType: "text",
                            success: function (data) {
                                notice(data)
                            }
                        })

                        function notice(data) {
                            let jsonObj = JSON.parse(data);
                            for (let i = 0; i < jsonObj.length; i++) {
                                let neirong = jsonObj[i].neirong;
                                let id = jsonObj[i].id;
                                if (jsonObj[i].neirong.length>50){
                                    let a = "...";
                                    let b = jsonObj[i].neirong.substring(0,50);
                                    neirong = b+a;
                                }
                                let trNode = "<div style='line-height: 35px'><a style='float: left' >" + jsonObj[i].title + "</a>" +
                                    "<a style='padding-left: 100px' href=\'http://localhost:8000/architect/notice.do?action=queryNoticebyId&Id=" + id + "'>" + neirong + "</a>"+
                                    "<a style='float: right;padding-right: 30px' >" + jsonObj[i].time + "</a><br></div>"
                                $("#tbody").append(trNode);
                            }
                        }
                    })
                </script>
                <div class="container">
                    <footer style="width: 1040px;margin-top: 50px" id="footer">
                        <div id="footer-widgets" class="gp-footer-larger-first-col">
                            <div class="gp-container">
                                <div class="footer_box">
                                    <div id="tbody" class="col_1_of_3 span_1_of_3">
                                        <h3 style="color: white;"> 网站公告</h3>
                                        <%--<h3>Categories</h3>--%>
                                        <%--<ul class="first">--%>
                                        <%--<li><a href="#">Dance</a></li>--%>
                                        <%--<li><a href="#">History</a></li>--%>
                                        <%--<li><a href="#">Specials</a></li>--%>
                                        <%--</ul>--%>
                                    </div>
                                    <%--<div class="col_1_of_3 span_1_of_3">--%>
                                    <%--&lt;%&ndash;<h3>Information</h3>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<ul class="first">&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li><a href="#">New products</a></li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li><a href="#">top sellers</a></li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li><a href="#">Specials</a></li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
                                    <%--</div>--%>
                                    <%--<div class="col_1_of_3 span_1_of_3">--%>
                                    <%--&lt;%&ndash;<h3>Follow Us</h3>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<ul class="first">&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li><a href="#">Facebook</a></li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li><a href="#">Twitter</a></li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li><a href="#">Youtube</a></li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
                                    <%--<div class="copy">--%>
                                    <%--&lt;%&ndash;<p>Copyright &copy; 2020.Company name All rights reserved.<a target="_blank"&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;href="http://guantaow.taobao.com/"></a><a&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;target="_blank" href="http://www.moobnn.com">影评</a></p>&ndash;%&gt;--%>
                                    <%--</div>--%>
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
