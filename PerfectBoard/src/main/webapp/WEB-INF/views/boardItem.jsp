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
	<h1 id='head'># ${boardTitle} 입니다.</h1>
	${boardId }
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>일자</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="cnt" value="0"/>
			<c:forEach var="boardItem" items="${boardItems}">
				<c:set var="cnt" value="${cnt+1}"/>
				<tr>
					<td>${cnt}</td>
					<td>${boardItem.getTitle()}</td>
					<td>${boardItem.getDate()}</td>
		    	</tr>	
			</c:forEach> 
		</tbody>
	</table>
</body>
</html>