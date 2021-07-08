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
	<h1 id='head'># ${board.getTitle()} 입니다.</h1>
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
					<td>
						<a href='javascript:$("#oneBoardItem${boardItem.getId()}").submit()'>${boardItem.getTitle()}</a>
						<form id='oneBoardItem${boardItem.getId()}' action='/PerfectBoard/oneBoardItem' method='post'>
							<input type='hidden' name='key_count' value='${cnt}'/>
							<input type='hidden' name='key_boardItemId' value='${boardItem.getId()}'/>
						</form>
					</td>
					<td>${boardItem.getStrDate()}</td>
		    	</tr>	
			</c:forEach> 
		</tbody>
	</table>
	
	<form action="/PerfectBoard/insert" method="post">
	   	<input type="hidden" name="key_count" value='${cnt + 1}'>
	   	<input type="hidden" name="key_boardId" value='${board.getId()}'>
	   	<button type="submit" formmethod="POST">글 작성</button>
	</form>
	
	<button type="button" onclick="location.href='/PerfectBoard/board'">게시판 목록</button>
</body>
</html>