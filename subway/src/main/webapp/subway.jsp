<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="subway.domain.*" %>
<%@ page import="subway.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>subway</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	SubwayServiceImpl subwayServiceImpl = SubwayServiceImpl.getInstance();
	
	//subwayServiceImpl.deleteDB();
	//subwayServiceImpl.createDB();
	//subwayServiceImpl.insertDB();
	
	String start = request.getParameter("key_start");
	String arrive = request.getParameter("key_arrive");
	
	if (start == null) {
		start = "용산";
		arrive = "회기";
	} 
	
	Subway subway = subwayServiceImpl.create();
	Print print = subwayServiceImpl.getTime(subway, start, arrive);
	out.print(print.getRoute().toString());
%>
	<form action="./subway.jsp" method="post" accept-charset="utf-8">
	   	<input type="text" name="key_start">
	   	<input type="text" name="key_arrive">
	   	<button type="submit" formmethod="POST">검 색</button>
	</form>
	<h1>소요시간은 <%= print.getTime() %> 분 입니다.</h1>
	<h1>출발합니다.</h1>
<%
	for (String station : print.getRoute()) {
%>
	<h1><%= station %> 역을 정차합니다.</h1>
<%
	}
%>
	<h1>도착했습니다.</h1>
</body>
</html>