<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="board.domain.*" %>
<%@ page import="board.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="./board.css?after">
</head>
<body>
<%
	try {
		request.setCharacterEncoding("utf-8");

		int count = Integer.parseInt(request.getParameter("insert_key"));
		
		BoardService boardService = new BoardServiceImpl();
%>
	<form id='insertBoard' action='./BoardList.jsp' method='post' accept-charset="utf-8">
	<table>
		<tr>
			<td>번호</td>
			<td>
				<input type='text' value='<%= count %>' readonly>
			</td>
		<tr>
		<tr>
			<td>제목</td>
			<td>
				<input type='text' name='title_key'/>
			</td>
		<tr>
		<tr>
			<td>일자</td>
			<td>
				<input type='text' name='date_key' value='<%= boardService.getDate() %>' readonly>
			</td>
		<tr>
		<tr>
			<td>내용</td>
			<td>
				<input type='text' name='content_key'/>
			</td>
		<tr>
	</table>
	</form>
	<button type="button" onclick="location.href='./BoardList.jsp'">취소</button>
	<a href='javascript:$("#insertBoard").submit()'>추가</a>
<%
	}
	catch (Exception e) {
		out.print(e);
	}
%>
</body>
</html>