<%--
  Created by IntelliJ IDEA.
  User: 14286
  Date: 2020/12/11
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="/architect/FileUploadServlet"><br/>
    影评名称:<input type="text" name="MovieName" id="MovieName"><br/>
    影评类别:<input type="text" name="TypeId" id="TypeId"><br/>
    导演:<input type="text" name="DaoYan" id="DaoYan"><br/>
    主演:<input type="text" name="ZhuYan" id="ZhuYan"><br/>
    上影年份:<input type="text" name="ShowTime" id="ShowTime"><br/>
    图片:<input type="file" name="PicAddress" id="PicAddressTypeId"><br/>
    详细介绍:<input type="text" name="Content" id="Content"><br/>
    <input type="submit">
</form>
</body>
</html>
