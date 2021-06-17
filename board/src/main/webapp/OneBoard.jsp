<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="board.domain.*" %>
<%@ page import="board.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>OneBoard</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="./board.css?after">
</head>
<body>
<%
	try {
		request.setCharacterEncoding("utf-8");

		int count = Integer.parseInt(request.getParameter("count_key"));
		int id = Integer.parseInt(request.getParameter("board_key"));
		
		BoardService boardService = new BoardServiceImpl();
		Board board = boardService.selectOne(id);
%>
	<table>
		<tr>
			<td>번호</td>
			<td><%= count %></td>
		<tr>
		<tr>
			<td>제목</td>
			<td><%= board.getTitle() %></td>
		<tr>
		<tr>
			<td>일자</td>
			<td><%= board.getDate() %></td>
		<tr>
		<tr>
			<td>내용</td>
			<td><%= board.getContent() %></td>
		<tr>
	</table>
	
	<button type="button" onclick="location.href='./BoardList.jsp' ">목록</button>
	<form id='updateBoard<%= id %>' action='./Update.jsp' method='post'>
		<input type='hidden' name='board_key' value='<%= id %>'/>
		<input type='hidden' name='count_key' value='<%= count %>'/>
	</form>
	<a href='javascript:$("#updateBoard<%= id %>").submit()'>수정</a>
<%
	}
	catch (Exception e) {
		out.print(e);
	}
%>
</body>
</html>










