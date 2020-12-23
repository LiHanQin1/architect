<%--
  Created by IntelliJ IDEA.
  User: 14286
  Date: 2020/12/23
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //销毁指定session的Attribute
    session.removeAttribute("user");
    response.sendRedirect("index.jsp");
%>

