<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="board.domain.*" %>
<%@ page import="board.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Update</title>
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
	<form id='updateBoard<%= id %>' action='./BoardList.jsp' method='post' accept-charset="utf-8">
	<table>
		<tr>
			<td>번호</td>
			<td>
				<input type='text' value='<%= count %>' readonly>
				<input type='hidden' name='board_key' value='<%= board.getId() %>'/>
			</td>
		<tr>
		<tr>
			<td>제목</td>
			<td>
				<input type='text' name='update_title_key' value='<%= board.getTitle() %>'/>
			</td>
		<tr>
		<tr>
			<td>일자</td>
			<td>
				<input type='text' value='<%= board.getDate() %>' readonly>
			</td>
		<tr>
		<tr>
			<td>내용</td>
			<td>
				<input type='text' name='update_content_key' value='<%= board.getContent() %>'/>
			</td>
		<tr>
	</table>
	</form>
	<button type="button" onclick="location.href='./BoardList.jsp'">취소</button>
	<form action="./BoardList.jsp" method="post">
    	<input type="hidden" name="delete_key" value='<%= id %>'>
    <button type="submit" formmethod="POST">삭제</button>
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