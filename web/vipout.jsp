<%--
  Created by IntelliJ IDEA.
  User: HongSiDa
  Date: 2020/12/21
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //销毁指定session的Attribute
    session.removeAttribute("vip");
    response.sendRedirect("index.jsp");
%>
