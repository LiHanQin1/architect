<%@ page import="com.entity.Vip" %><%--
  Created by IntelliJ IDEA.
  User: HongSiDa
  Date: 2020/12/21
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>

<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<html>
<head>
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
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        }

        /* 下拉菜单的链接 */
        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        /* 鼠标移上去后修改下拉菜单链接颜色 */
        .dropdown-content a:hover {background-color: #f1f1f1}

        /* 在鼠标移上去后显示下拉菜单 */
        .dropdown:hover .dropdown-content {
            display: block;
        }

        /* 当下拉内容显示后修改下拉按钮的背景颜色 */
        .dropdown:hover .dropbtn {
            background-color: grey;
        }
    </style>
    <title>UpdatePassword</title>
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
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://www.huangwx.cn/css/sweetalert.css">
    <script type="text/javascript" src="https://www.huangwx.cn/js/sweetalert-dev.js"></script>


    <script type="application/javascript">




    </script>
    <script src="js/responsiveslides.min.js"></script>
    <script type="text/javascript">
        <%
                   Vip vip= (Vip) request.getSession().getAttribute("vip");
                   %>


        function check(){
                var usedpassword=$("#usedpassword").val();
                var username="<%=vip.getUserName()%>";
                $.ajax({
                    url: "http://localhost:8000/architect/vip.do",
                    data: {action: "queryIsExist", username: username,usedpassword:usedpassword},
                    type: "GET",
                    dataType: "text",
                    success: function (data) {
                        if (data<=0){
                            return false;
                        }

                    }
                });
                var password=$("#password").val();
            if (password==""){
                    return false;
            }
                var confirmpassword=$("#confirmpassword").val();
                if (password!=confirmpassword) {
                    return false;
                }

                return true;
        }
        $(function () {
            <%
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

            $("#usedpassword").on("blur",function () {
                var username="<%=vip.getUserName()%>";
                var usedpassword=$("#usedpassword").val();
                $.ajax({
                    url: "http://localhost:8000/architect/vip.do",
                    data: {action: "queryIsExist", username: username,usedpassword:usedpassword},
                    type: "GET",
                    dataType: "text",
                    success: function (data) {
                        if (data>0){
                            $("#usedpasswordtips").html("原密码正确√");
                            return true;
                        } else{
                            $("#usedpasswordtips").html("原密码错误");
                            return false;
                        }

                    }
                });
            })
            $("#confirmpassword").on("blur",function () {
                var password=$("#password").val()
                var confirmpassword=$("#confirmpassword").val()
                if (password!=confirmpassword){
                    $("#confirmpasswordtips").html("确认密码与新密码不一致");
                    return false;
                }else{
                    $("#confirmpasswordtips").html("确认密码与新密码一致√");
                    return true;
                }
            })


        })


        function subtion() {
            var flag=check();
            if (flag) {
                $("#form").submit();
                var username="<%=vip.getUserName()%>";
                var password=$("#password").val();
                $.ajax({
                    url: "http://localhost:8000/architect/vip.do",
                    data: {action: "updatepassword", username: username,password:password},
                    type: "GET",
                    dataType: "text",
                    success: function (data) {
                        if (data>0){
                            alert("修改成功");
                        } else{
                            alert("修改失败");
                        }
                    }
                });

            }
        }
    </script>
</head>
<body>
<div class="container">
    <div class="container_wrap">
        <div class="header_top">
            <div class="col-sm-3 logo"><a href="index.jsp"><img src="images/logo.png" alt=""/></a></div>
            <div class="col-sm-6 nav">
                <ul>
                    <li> <span class="simptip-position-bottom simptip-movable" data-tooltip="comic"><a href="movie.jsp"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="movie"><a href="movie.jsp"> </a> </span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="video"><a href="movie.jsp"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="game"><a href="movie.jsp"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="tv"><a href="movie.jsp"> </a></span></li>
                    <li><span class="simptip-position-bottom simptip-movable" data-tooltip="more"><a href="movie.jsp"> </a></span></li>
                </ul>
            </div>
            <div class="col-sm-3 header_right">
                <ul class="header_right_box">
                    <li id="vipInformation"><a href="login.html" >登  陆</a></li>
                    <li id="menu"></li>
                    <div class="clearfix"> </div>
                </ul>
            </div>
            <div class="clearfix"> </div>
        </div>
        <div class="content">
            <div class="register">

                <div class="col-md-6 login-right" style="text-align: center">
                    <h3>Update   Password</h3>
                    <form  id="form" method="post">
                        <div>
                            <span>UsedPassword<label>*</label></span>
                            <input type="password" id="usedpassword" name="usedpassword">
                            <span id="usedpasswordtips" style="color: red"></span>
                        </div>
                        <div>
                            <span>NewPassword<label>*</label></span>
                            <input type="password" id="password" name="password">
                        </div>
                        <div>
                            <span>ConfirmPassword<label>*</label></span>
                            <input type="password" id="confirmpassword" name="confirmpassword">
                            <span id="confirmpasswordtips" style="color: red"></span>
                        </div>
                        <button id="sub" type="button" onclick="subtion()">确认修改</button>
                    </form>
                </div>
                <div class="clearfix"> </div>
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
