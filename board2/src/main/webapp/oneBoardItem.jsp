<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="board2.domain.*" %>
<%@ page import="board2.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>oneBoardItem</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="./board.css?after">
</head>
<body>
<%
	BoardItemService boardItemService = BoardItemServiceImpl.getInstance();
	
	request.setCharacterEncoding("utf-8");
	int itemid = Integer.parseInt(request.getParameter("key_itemid"));
	int count = Integer.parseInt(request.getParameter("key_count"));
	int boardid = Integer.parseInt(request.getParameter("key_boardid"));
	
	BoardItem boardItem = boardItemService.selectOne(itemid);
	boardItem.setComments(boardItemService.getAllComments(boardItem));
	
	String commentTitle = request.getParameter("key_commentTitle");
	String commentDate = request.getParameter("key_commentDate");
	String commentContent = request.getParameter("key_commentContent");
	
	if (commentTitle != null) {
		BoardItem newComment = new BoardItem(commentTitle, commentDate, commentContent, boardid);
		boardItemService.createComment(boardItem, newComment);
	}
%>
<h1 id='head'># '<%= boardItem.getTitle() %>' 게시물입니다.</h1>
<form id='updateBoardItem' action='./updateComplete.jsp' method='post' accept-charset="utf-8">
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
				<input type='text' name='key_title' value='<%= boardItem.getTitle() %>'/>
			</td>
		<tr>
		<tr>
			<td>일자</td>
			<td>
				<input type='text' value='<%= boardItemService.getDate() %>' readonly>
			</td>
		<tr>
		<tr>
			<td>내용</td>
			<td>
				<input type='text' name='key_content' value='<%= boardItem.getContent() %>'/>
			</td>
		<tr>
	</table>
	<input type="hidden" name="key_itemid" value='<%= itemid %>'>
	<input type="hidden" name="key_boardid" value='<%= boardid %>'>
</form>
<h1 id='head'>해당 게시글에 대한 댓글입니다.</h1>
<form id='insertComment' action='./oneBoardItem.jsp' method='post' accept-charset="utf-8">
	<table>
		<tr>
			<td>제목</td>
			<td>일자</td>
			<td>내용</td>
		<tr>
<%
	for (BoardItem comment : boardItem.getComments()) {
%>
		<tr>
			<td><%= comment.getTitle() %></td>
			<td><%= comment.getDate() %></td>
			<td><%= comment.getContent() %></td>
		<tr>
<%
	}
%>
		<tr>
			<td>
				<input type='text' name='key_commentTitle'>
			</td>
			<td>
				<input type='text' name='key_commentDate' value='<%= boardItemService.getDate() %>' readonly>
			</td>
			<td>
				<input type='text' name='key_commentContent'>
			</td>
		<tr>
	</table>
	 <input type="hidden" name="key_itemid" value='<%= itemid %>'>
	 <input type="hidden" name="key_count" value='<%= count %>'>
	 <input type="hidden" name="key_boardid" value='<%= boardid %>'>
</form>
<button onclick='javascript:$("#insertComment").submit()'>댓글 추가</button>
<form action="./boardItem.jsp" method="post">
   	<input type="hidden" name="key_boardid" value='<%= boardid %>'>
   	<button class='btn-1' type="submit" formmethod="POST">목록으로</button>
</form>
<form action="./deleteComplete.jsp" method="post">
	<input type="hidden" name="key_itemid" value='<%= itemid %>'>
   	<input type="hidden" name="key_boardid" value='<%= boardid %>'>
   	<button class='btn-1' type="submit" formmethod="POST">삭제</button>
</form>
<button class='btn-1' onclick='javascript:$("#updateBoardItem").submit()'>수정</button>
</body>
</html>








