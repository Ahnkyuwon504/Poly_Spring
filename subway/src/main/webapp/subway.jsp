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
<link rel="stylesheet" type="text/css" href="./reservation.css?after">
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	SubwayServiceImpl subwayServiceImpl = SubwayServiceImpl.getInstance();
	
	//subwayServiceImpl.deleteDB();
	//subwayServiceImpl.createDB();
	//subwayServiceImpl.insertDB();
	
	int time = 0;
	Subway subway = subwayServiceImpl.create();
	/*
	String strStart = request.getParameter("key_start");
	String strArrive = request.getParameter("key_arrive");
	
	if (strStart != null) {
		int start = Integer.parseInt(strStart); 
		int arrive = Integer.parseInt(strArrive); 
		time = subwayServiceImpl.getTime(subway, start, arrive);
	} */
%>
	<h1>소요시간은 <%= time %> 분 입니다.</h1>
</body>
</html>