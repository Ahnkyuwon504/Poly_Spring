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
	<h1># 게시판</h1>
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
			<c:forEach var="boardItem" items="${boardItemList}">
				<c:set var="cnt" value="${cnt+1}"/>
				
				<c:if test="${from <= cnt && cnt <= to}">
					<tr>
						<td>${cnt}</td>
						<td>
							<form id='oneBoardItem${boardItem.getItemid()}' action='/SpringBoard/oneBoardItem' method='post'>
								<input type='hidden' name='key_itemid' value='${boardItem.getItemid()}'/>
								<input type='hidden' name='key_boardid' value='${boardId}'/>
								<input type='hidden' name='key_count' value='${cnt}'/>
							</form>
							<a href='javascript:$("#oneBoardItem${boardItem.getItemid()}").submit()'>${boardItem.getTitle()}</a>
						</td>
						<td>${boardItem.getDate()}</td>
					</tr>

				</c:if>
				
			</c:forEach> 
		</tbody>
	</table>
	<ul>
		<li><a href='/SpringBoard/boardItem?from=${previousPageFrom}&to=${previousPageTo }&key_boardid=${boardId}'>&lt;</a></li>

		<c:forEach var="i" begin="1" end="${nowPageMax}" step="1">
			<li><a href='/SpringBoard/boardItem?from=${(i-1)*onePage + 1}&to=${i*onePage}&key_boardid=${boardId}'>${i}</a></li>
		</c:forEach>
		
		<li><a href='/SpringBoard/boardItem?from=${nextPageFrom}&to=${nextPageTo}&key_boardid=${boardId}'>&gt;</a></li>
	</ul>
	<form id='search' action='/SpringBoard/boardItem' method='post' accept-charset="utf-8">
		<input type='text' name='key_search'>
		<input type="hidden" name="key_boardid" value='${boardId}'>
		<button onclick='javascript:$("#search").submit()'>검 색</button>
	</form>
	<form action="/SpringBoard/insert" method="post">
	   	<input type="hidden" name="key_insert" value='${cnt + 1}'>
	   	<input type="hidden" name="key_boardid" value='${boardId}'>
	   	<button type="submit" formmethod="POST">글 작성</button>
	</form>
	<form>
		<button type="button" onclick="location.href='/SpringBoard/board'">게시판 목록</button>
	</form>
</body>
</html>