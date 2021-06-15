<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@ page import="tupyo.domain.*" %>
<%@ page import="tupyo.service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A03</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<%
	try {
		HuboService huboService = new HuboServiceImpl();
		request.setCharacterEncoding("utf-8");
		
		String kiho = request.getParameter("kiho_insert_key");
		String name = request.getParameter("name_insert_key");
		
		Hubo addHubo = new Hubo(Integer.parseInt(kiho), name);
		huboService.create(addHubo);
%>

<%= addHubo.getKiho() %> 번 <%= addHubo.getName() %> 후보 추가 완료

<%
	} catch (Exception e) {
		out.println(e);
	}
%>
</body>
</html>