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
<title>C01</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="./tupyo.css">
</head>

<body>
후보 별 득표율
	<table>
<%
	try {
		HuboService huboService = new HuboServiceImpl();
		TupyoService tupyoService = new TupyoServiceImpl();
	
		for (Hubo hubo : huboService.selectAll()) {
			int redBoxAbsol = tupyoService.selectOneCount(hubo);
			int redBoxRel = redBoxAbsol * 100 / (tupyoService.selectAllCount());
%>
			<tr>
				<td width=420>
					<form id='onehubo<%= hubo.getKiho() %>' action='./C02.jsp' method='post' target='main'>
						<input type='hidden' name='kiho_key' value='<%= hubo.getKiho() %>'/>
					</form>
					<%= hubo.getKiho() %>번 <a href='javascript:$("#onehubo<%= hubo.getKiho() %>").submit()'><%= hubo.getName() %></a>
				</td>
				<td style='border-left: 1px solid black'>
					<p>
						<img src='./red.png' height='20px' width='<%= 50 * redBoxAbsol %>'>&nbsp;<%= redBoxAbsol %>(<%= redBoxRel %>%)
					</p>
				</td>
			</tr>
<%
		}
	}
	catch (Exception e) {
		out.print(e);
	}
%>
	</table>
</body>
</html>