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
	<form id='updateBoardItem' action='/PerfectBoard/updateComplete' method='post' accept-charset="utf-8">
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
					<input type='text' name='key_title' value='${boardItem.getTitle()}'/>
				</td>
			<tr>
			<tr>
				<th>일자</th>
				<td>
					<input type='text' value='${boardItem.getStrDate()}' readonly>
				</td>
			<tr>
			<tr>
				<th>내용</th>
				<td>
					<input type='text' name='key_content' value='${boardItem.getContent()}'/>
				</td>
			<tr>
		</table>
		<input type="hidden" name="key_boardItemId" value='${boardItem.getId()}'>
	</form>
	
	
	
	
	
	
	
	<form action="/PerfectBoard/boardItem" method="post">
	   	<input type="hidden" name="key_boardId" value='${boardId}'>
	   	<button type="submit" formmethod="POST">목록으로</button>
	</form>
	<button onclick='javascript:$("#updateBoardItem").submit()'>수정</button>
	<form action="/PerfectBoard/deleteComplete" method="post">
		<input type="hidden" name="key_boardItemId" value='${boardItem.getId()}'>
	   	<button type="submit" formmethod="POST">삭제</button>
	</form>
</body>
</html>