<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="reservation.domain.*" %>
<%@ page import="reservation.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>reservationStatus</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="./reservation.css?after">
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	ReservationService reservationService = ReservationServiceImpl.getInstance();
	
	String date = request.getParameter("key_date");
	String strroom = request.getParameter("key_room");
	String name = request.getParameter("key_name");
	String addr = request.getParameter("key_addr");
	String tel = request.getParameter("key_tel");
	String name_money = request.getParameter("key_name_money");
	String memo = request.getParameter("key_memo");
	String strMaxDay = request.getParameter("key_maxday");
	int maxDay = reservationService.getMaxDay(strMaxDay);
	
	reservationService.isAvailCreate(date, strroom, name, addr, tel, name_money, memo);
%>
	<h1># 예약상황입니다. 오늘로부터 확인하려는 일수를 선택해 주십시오.</h1>
	<form action='./reservationStatus.jsp' method='post'>
		<select name='key_maxday'>
<%
	for (int i = 1; i <= ConstantValue.maxDay; i++) {
%>
			<option value='<%=i%>'><%=i%></option>
<%
	}
%>
		</select>
		<input type='submit' value='선택'>
	</form>
	<table>
		<tr>
			<th>일자</th>
			<th>Suite</th>
			<th>Superior</th>
			<th>Standard</th>
		</tr>
<%
	for (int i = 0; i < maxDay; i++) {
		String reservDate = reservationService.getDate(i)[0];
		String reservDay = reservationService.getDate(i)[1];
		String isAvailSuite = reservationService.checkAvail(reservDate, 1);
		String isAvailSuperior = reservationService.checkAvail(reservDate, 2);
		String isAvailStandard = reservationService.checkAvail(reservDate, 3);
%>
		<tr>
			<td><%= reservDate %><%= reservDay%></td>
			<td><%= isAvailSuite %></td>
			<td><%= isAvailSuperior %></td>
			<td><%= isAvailStandard %></td>
		</tr>
<%
	}
%>	
	</table>
</body>
</html>