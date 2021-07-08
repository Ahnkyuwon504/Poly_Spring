<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>boardItem</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h1># 새 글 작성</h1>
	<form id='insertBoardItem' action='/PerfectBoard/insertComplete' method='post' accept-charset="utf-8">
		<table>
			<tr>
				<td>번호</td>
				<td><input type='text' value='${count}' readonly></td>
			<tr>
			<tr>
				<td>제목</td>
				<td><input type='text' name='key_title'/></td>
			<tr>
			<tr>
				<td>일자</td>
				<td><input type='text' name='key_date' value='${date}' readonly></td>
			<tr>
			<tr>
				<td>내용</td>
				<td><input type='text' name='key_content'/></td>
			<tr>
		</table>
		<input type="hidden" name="key_boardid" value='${boardId}'>
	</form>
	<form action="/SpringBoard/boardItem" method="post">
	   	<input type="hidden" name="key_boardid" value='${boardId}'>
	   	<button type="submit" formmethod="POST">취소</button>
	</form>
	<button onclick='javascript:$("#insertBoardItem").submit()'>추가</button>
	
</body>
</html>