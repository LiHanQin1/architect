<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/15
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加公告</title>
</head>
<body>
<form method="post"  action="AddNoticeServlet">
    公告标题:<input type="text" name="title" id="title1"><br/>
    公告内容:<input type="text" name="neirong" id="neirong1"><br/>
    公告时间:<input type="text" name="addtime" id="addtime1"><br/>
    <input type="submit">
</form>
</body>
</html>
