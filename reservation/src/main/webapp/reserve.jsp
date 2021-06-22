<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="reservation.domain.*" %>
<%@ page import="reservation.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>reserve</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="./reservation.css?after">
</head>
<body>

<%
	request.setCharacterEncoding("utf-8");
	ReservationService reservationService = ReservationServiceImpl.getInstance();
	
	String date = request.getParameter("key_date");
	int room = Integer.parseInt(request.getParameter("key_room"));
	String whatRoom = reservationService.roomName(room);
%>
	<form action='./reservationStatus.jsp' method='post' accept-charset="utf-8">
		<table>
			<tr>
				<td width=50>성명</td>
				<td width=50><input name='key_name' type='text'></td>
			</tr>
			<tr>
				<td width=50>예약일자</td>
				<td width=50><input name='key_date' type='text' value='<%= date %>' readonly></td>
			</tr>
			<tr>
				<td width=50>예약방</td>
				<td width=50><input type='text' value='<%= whatRoom %>' readonly></td>
			</tr>
			<tr>
				<td width=50>주소</td>
				<td width=50><input name='key_addr' type='text'></td>
			</tr>
			<tr>
				<td width=50>전화번호</td>
				<td width=50><input name='key_tel' type='text'></td>
			</tr>
			<tr>
				<td width=50>입금자명</td>
				<td width=50><input  name='key_name_money' type='text'></td>
			</tr>
			<tr>
				<td width=50>남기실말</td>
				<td width=50><input  name='key_memo' type='text'></td>
			</tr>
		</table>
		<br>
		<input name='key_room' type='hidden' value='<%= room %>'>
		<input type='submit' value='예약하기'>
	</form>
</body>
</html>








