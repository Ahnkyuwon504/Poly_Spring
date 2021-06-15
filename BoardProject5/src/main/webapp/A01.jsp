<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="tupyo.domain.*" %>
<%@ page import="tupyo.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>A01</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="./tupyo.css">
</head>
<body>
	<table id='hubotable'>
<%
	HuboService huboService = new HuboServiceImpl();
	
	for (Hubo hubo : huboService.selectAll()) {
%>
		<tr>
			<td width=100><p>기호번호 : <%= hubo.getKiho() %></p></td>
			<td width=250><p>후보명 : <%= hubo.getName() %></p></td>
			<td width=50 style='text-align:right;'><p>
				<form id='delete<%= hubo.getKiho() %>' action='./A02.jsp' method='post' target='main'>
				<input type='hidden' name='kiho_key' value='<%= hubo.getKiho() %>'/>
				</form>
				<button onclick='javascript:$("#delete<%= hubo.getKiho() %>").submit()'>삭제</button>
			</td>
		</tr>
<%
	}
%>
		<tr>
			<form id='insert' action='./A03.jsp' method='post' target='main'>
				<td width=100>기호번호 : <input style='width:80px;' type='text' name='kiho_insert_key'></td>
				<td width=250>후보명 : <input type='text' name='name_insert_key' id='inputname'></td>
				<td width=50 style='text-align:right;'>
					<button onclick='javascript:$("#insert").submit()'>추가</button>
				</td>
			</form>
		</tr>
	</table>
</body>
</html>








