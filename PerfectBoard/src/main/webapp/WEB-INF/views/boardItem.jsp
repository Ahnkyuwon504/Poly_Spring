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
<style>
#head {
	font-size: 1.6em;
 	font-weight: bold;
}
table.type10 {
  border-collapse: collapse;
  text-align: left;
  line-height: 1.5;
  border-top: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
  margin: 20px 10px;
}
table.type10 thead th {
  width: 150px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  color: #fff;
  background: #e7708d;
  margin: 20px 10px;
}
table.type10 tbody th {
  width: 150px;
  padding: 10px;
}
table.type10 td {
  width: 350px;
  padding: 10px;
  vertical-align: top;
}
table.type10 .even {
  background: #fdf3f5;
}
ul {
	text-align:center;
}
ul li {
	display:inline;
	vertical-align:middle;
}
ul li a {
	display:-moz-inline-stack;	/*FF2*/
	display:inline-block;
	vertical-align:top;
	padding:4px;
	margin-right:3px;
	width:15px !important;
	color:#000;
	font:bold 12px tahoma;
	border:1px solid #eee;
	text-align:center;
	text-decoration:none;
	width /**/:26px;	/*IE 5.5*/
}
ul li a.now {
	color:#fff;
	background-color:#f40;
	border:1px solid #f40;
}
ul li a:hover, ul li a:focus {
	color:#fff;
	border:1px solid #f40;
	background-color:#f40;
}
form {
	display:inline;
	vertical-align:middle;
}
button {
	display:inline;
	vertical-align:middle;
    background-color:#FF5A5F;
    color:white;
    width: 70px;
    height: 45px;
    font-size: 15px;
    font-weight: 700;
    border-radius: 6px;
    border: 0;
    outline: 0;
}
input[type=text]{
	display:inline;
	vertical-align:middle;
    height:40px;
    width:300px;
    border-radius: 4px;
    font-size: 20px;
}
</style>
</head>
<body>
<div style="text-align:center;">
	<h1 id='head'># ${board.getTitle()} 입니다.</h1>
	<table class='type10'>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>일자</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="cnt" value="${nowPage }"/>
			<c:forEach var="boardItem" items="${boardItems}">
				<c:set var="cnt" value="${cnt+1}"/>
				<c:if test="${cnt % 2 == 0}">
					<tr>
						<td class='even'>${cnt}</td>
						<td class='even'>
							<a href='javascript:$("#oneBoardItem${boardItem.getId()}").submit()'>${boardItem.getTitle()}</a>
							<form id='oneBoardItem${boardItem.getId()}' action='/PerfectBoard/oneBoardItem' method='post'>
								<input type='hidden' name='key_count' value='${cnt}'/>
								<input type='hidden' name='key_boardItemId' value='${boardItem.getId()}'/>
							</form>
						</td>
						<td class='even'>${boardItem.getStrDate()}</td>
			    	</tr>
		    	</c:if>
		    	<c:if test="${cnt % 2 != 0}">
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
		    	</c:if>
			</c:forEach> 
		</tbody>
	</table>
	<ul>
		<c:set var="now" value="0"/>
		<li><a href='/PerfectBoard/boardItem?key_previous=${1 }&key_now=${now }&key_boardId=${board.getId()}'>&lt;</a></li>
		<c:forEach var="i" begin="0" end="${nowPageMax - 1}" step="1">
			<li><a href='/PerfectBoard/boardItem?key_now=${i}&key_boardId=${board.getId()}'>${i+1}</a></li>
		</c:forEach>
		<li><a href='/PerfectBoard/boardItem?key_next=${1 }&key_now=${now }&key_boardId=${board.getId()}'>&gt;</a></li>
	</ul>
	
	<form id='search' action='/PerfectBoard/boardItem' method='post' accept-charset="utf-8">
		<input type='text' name='key_search'>
		<input type="hidden" name="key_boardId" value='${board.getId()}'>
		<button onclick='javascript:$("#search").submit()'>검 색</button>
	</form>
	<form action="/PerfectBoard/insert" method="post">
	   	<input type="hidden" name="key_count" value='${cnt + 1}'>
	   	<input type="hidden" name="key_boardId" value='${board.getId()}'>
	   	<button type="submit" formmethod="POST">글 작성</button>
	</form>
	<button type="button" onclick="location.href='/PerfectBoard/board'">게시판 목록</button>
</div>
</body>
</html>