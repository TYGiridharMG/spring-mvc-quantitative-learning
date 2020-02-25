<%@page import="com.tyss.springmvc.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	UserBean bean = (UserBean) session.getAttribute("bean");
%>
<h1>Welcome <%=bean.getName()%></h1>
</body>
</html>