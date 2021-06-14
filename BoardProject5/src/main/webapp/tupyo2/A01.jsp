<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="tupyo.domain.*" %>
<%@ page import="tupyo.service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	HuboService huboService = new HuboServiceImpl();
	Hubo hubo1 = huboService.selectOne(1);
%>
hello world
board title: <%= hubo1.getName() %>
abcdfjkdsl
</body>
</html>








