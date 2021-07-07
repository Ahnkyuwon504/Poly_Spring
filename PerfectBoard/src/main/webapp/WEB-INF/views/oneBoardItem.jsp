<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>board</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h1 id='head'># 게시판 목록</h1>
	<form action="/PerfectBoard/boardItem" method="post">
		<c:forEach var="board" items="${boards}">
	    	<input type="hidden" name="key_boardId" value='${board.getId()}'>
	    	<button type="submit" formmethod="POST"><c:out value="${board.getTitle()}" /></button>	
		</c:forEach> 
	</form>
</body>
</html>