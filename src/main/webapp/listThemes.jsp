<%@page import="com.eyrc.Repository.Theme"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%! int i; %>
	<% for ( i = 0; i < (Integer)request.getAttribute("counter"); i++){ %>
		<%=i %>
		<%=request.getAttribute("theme"+i) %>
		<br>
	<%}%>
</body>
</html>