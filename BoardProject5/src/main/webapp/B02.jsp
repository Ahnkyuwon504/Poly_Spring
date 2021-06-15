<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="tupyo.domain.*" %>
<%@ page import="tupyo.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>B02</title>
</head>
<body>
<%
	try {
		request.setCharacterEncoding("utf-8");
		TupyoService tupyoService = new TupyoServiceImpl();
		
		int kiho = Integer.parseInt(request.getParameter("kiho_key"));
		int age = Integer.parseInt(request.getParameter("age_key"));
		
		Tupyo tupyo = new Tupyo(kiho, age);
		tupyoService.create(tupyo);
%>
<%= tupyo.getKiho() %> 번 후보 <%= tupyo.getAge() %>0대 투표되었습니다.
<%	
	} catch (Exception e) {
		out.println(e);
	}
%>
</body>
</html>