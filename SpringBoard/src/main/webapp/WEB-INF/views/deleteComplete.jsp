<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>deleteComplete</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="./board.css?after">
</head>
<body>
	<h1 id='head'># 삭제 완료되었습니다.</h1>
	<form action="/SpringBoard/boardItem" method="post">
	   	<input type="hidden" name="key_boardid" value='${boardId}'>
	   	<button type="submit" formmethod="POST">목록으로</button>
	</form>
</body>
</html>