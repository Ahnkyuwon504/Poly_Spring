<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>updateComplete</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h1># 수정 완료되었습니다.</h1>
	<form action="/PerfectBoard/boardItem" method="post">
	   	<input type="hidden" name="key_boardId" value='${boardId}'>
	   	<button type="submit" formmethod="POST">목록으로</button>
	</form> 
</body>
</html>