<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="tupyo.domain.*" %>
<%@ page import="tupyo.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>A02</title>
</head>
<body>
<%
	try {
		HuboService huboService = new HuboServiceImpl();
		request.setCharacterEncoding("utf-8");
		
		String kiho = request.getParameter("kiho_key");
		
		Hubo delHubo = huboService.selectOne(Integer.parseInt(kiho));
		huboService.delete(delHubo);
%>
<%= delHubo.getKiho() %> 번 <%= delHubo.getName() %> 후보 삭제 완료
<%	
	} catch (Exception e) {
		out.println(e);
	}
%>
</body>
</html>