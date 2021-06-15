<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="tupyo.domain.*" %>
<%@ page import="tupyo.dao.*" %>
<%@ page import="tupyo.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	HuboService huboService = new HuboServiceImpl();
	HuboDao hubodao = new HuboDaoImpl();
	
	for (Hubo hubo : hubodao.selectAll()) {
%>

		<%= hubo %>
<%
	}
	
	
%>





</body>
</html>








