<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>board</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="./board.css?after">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h1 id='head'># 게시판 목록</h1>
	<form action="/SpringBoard/boardItem" method="post">
		<c:forEach var="board" items="${boardList}">
	    	<input type="hidden" name="key_boardid" value='${board.getBoardid()}'>
	    	<button class='btn-1' type="submit" formmethod="POST"><c:out value="${board.getTitle()}" /></button>	
		</c:forEach> 
	</form>
</body>
</html>








