<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>oneBoardItem</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h1># ${count}번째 게시물입니다.</h1>
	<form id='updateBoardItem' action='/SpringBoard/updateComplete' method='post' accept-charset="utf-8">
		<table class="type11">
			<tr>
				<th>번호</th>
				<td>
					<input type='text' value='${count}' readonly>
				</td>
			<tr>
			<tr>
				<th>제목</th>
				<td>
					<input type='text' name='key_title' value='${title}'/>
				</td>
			<tr>
			<tr>
				<th>일자</th>
				<td>
					<input type='text' value='${date}' readonly>
				</td>
			<tr>
			<tr>
				<th>내용</th>
				<td>
					<input type='text' name='key_content' value='${content}'/>
				</td>
			<tr>
		</table>
		<input type="hidden" name="key_itemid" value='${itemId}'>
		<input type="hidden" name="key_boardid" value='${boardId }'>
	</form>
	<h1 id='head'># ${count}번째 게시물에 대한 댓글입니다.</h1>
	<form id='insertComment' action='/SpringBoard/oneBoardItem' method='post' accept-charset="utf-8">
		<table>
		<thead>
			<tr>
				<th>제목</th>
				<th>일자</th>
				<th>내용</th>
			<tr>
		</thead>
		<tbody>
			<c:forEach var="comment" items="${comments}">
				<tr>
					<td>${comment.getTitle()}</td>
					<td>${comment.getDate()}</td>
					<td>${comment.getContent()}</td>
				</tr>
			</c:forEach> 
			<tr>
				<td>
					<input type='text' name='key_commentTitle'>
				</td>
				<td>
					<input type='text' name='key_commentDate' value='${date}' readonly>
				</td>
				<td>
					<input type='text' name='key_commentContent'>
				</td>
			</tr>
		</tbody>
		</table>
		<input type="hidden" name="key_itemid" value='${itemId}'>
		<input type="hidden" name="key_boardid" value='${boardId}'>
		<input type="hidden" name="key_count" value='${count}'>
	</form>

	<form action="/SpringBoard/boardItem" method="post">
	   	<input type="hidden" name="key_boardid" value='${boardId}'>
	   	<button type="submit" formmethod="POST">목록</button>
	</form>
	
	<form action="/SpringBoard/deleteComplete" method="post">
		<input type="hidden" name="key_itemid" value='${itemId}'>
	   	<input type="hidden" name="key_boardid" value='${boardId}'>
	   	<button type="submit" formmethod="POST">삭제</button>
	</form>
	
	<button onclick='javascript:$("#insertComment").submit()'>추가</button>
	
	<button onclick='javascript:$("#updateBoardItem").submit()'>수정</button>
</body>
</html>



