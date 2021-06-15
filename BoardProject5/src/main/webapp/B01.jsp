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
<title>B01</title>
</head>
<body>
<%
	try {
		HuboService huboService = new HuboServiceImpl();
		TupyoService tupyoService = new TupyoServiceImpl();
		Tupyo tupyo = new Tupyo();
%>
	<form action='./B02.jsp' method='post' target='main'>
		<select name='kiho_key'>
<%	
		for (Hubo hubo : huboService.selectAll()) {
%>
		<option value='<%= hubo.getKiho() %>'><%= hubo.getKiho() %>번 <%= hubo.getName() %></option>
<%
		}
	}
	catch (Exception e) {
		out.print(e);
	}
%>
		</select>
		<select name='age_key'>
			<option value='1'>10대</option>
			<option value='2'>20대</option>
			<option value='3'>30대</option>
			<option value='4'>40대</option>
			<option value='5'>50대</option>
			<option value='6'>60대</option>
			<option value='7'>70대</option>
			<option value='8'>80대</option>
			<option value='9'>90대</option>
		</select>
		<input type='submit' value='투표하기'>
	</form>
</body>
</html>