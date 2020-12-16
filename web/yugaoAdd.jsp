<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/15
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>预告片添加</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="/architect/FileUploadServlet1"><br/>
    预告片名称:<input type="text" name="MovieName" id="MovieName"><br/>
    预告片类别:<input type="text" name="TypeId" id="TypeId"><br/>
    导演:<input type="text" name="DaoYan" id="DaoYan"><br/>
    主演:<input type="text" name="ZhuYan" id="ZhuYan"><br/>
    上映年份:<input type="text" name="ShowTime" id="ShowTime"><br/>
    图片:<input type="file" name="PicAddress" id="PicAddressTypeId"><br/>
    <input type="submit">
</form>
</body>
</html>
