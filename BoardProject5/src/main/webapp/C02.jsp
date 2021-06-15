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
<title>C02</title>
<link rel="stylesheet" href="./tupyo.css">
</head>
<body>
<%
	try {
		HuboService huboService = new HuboServiceImpl();
		TupyoService tupyoService = new TupyoServiceImpl();
		
		String kiho = request.getParameter("kiho_key");
		Hubo hubo = huboService.selectOne(Integer.parseInt(kiho));
%>
<%= hubo.getKiho() %>번 <%= hubo.getName() %> 후보 득표성향 분석
	<table>
<%		
		int count = 1;
		int allAgeTupyo = tupyoService.selectAllCount();
		for (int oneAgeTupyo : tupyoService.selectOneAgeCount(hubo)) {
			int per = oneAgeTupyo * 100 / allAgeTupyo;
%>
			<tr>
				<td width=100><p><%= count %>0대</p></td>
				<td style='border-left: 1px solid black'>
					<p>
						<img src='./red.png' height=20px width=<%= 50 * oneAgeTupyo %>>&nbsp;<%= oneAgeTupyo %>(<%= per %>%)
					</p>
				</td>
			</tr>
<%
		count++;
		}
	}
	catch (Exception e) {
		out.print(e);
	}
%>
	</table>
</body>
</html>