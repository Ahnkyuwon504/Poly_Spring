<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>board</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h1 id='head'># 게시판 목록</h1>
	<form method="post">
		<c:forEach var="board" items="${boards}">
	    	<input type="hidden" name="key_boardId" value='${board.getId()}'>
	    	<button type="submit" formaction="/PerfectBoard/boardItem"><c:out value="${board.getTitle()}" /></button>	
			${board.getId()}입니다.
		</c:forEach> 
	</form>
</body>
</html>