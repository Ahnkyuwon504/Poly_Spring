<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="board2.domain.*" %>
<%@ page import="board2.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>boardItem</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="./board.css?after">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<h1 id='head'># 게시판</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>일자</th>
		</tr>
<%
	request.setCharacterEncoding("utf-8");
	BoardItemService boardItemService = BoardItemServiceImpl.getInstance();
	int onePage = ConstantValue.onePage;
	
	String search = request.getParameter("key_search");
	int boardid = Integer.parseInt(request.getParameter("key_boardid"));
	String strfrom = request.getParameter("from");
	String strto = request.getParameter("to");
	
	int boardItemHowMany = boardItemService.selectAll(boardid).size();
	String keyword = boardItemService.getKeyWord(search);
	
	int from = boardItemService.getFromAndTo(strfrom, strto, boardItemHowMany, onePage)[0];
	int to = boardItemService.getFromAndTo(strfrom, strto, boardItemHowMany, onePage)[1];
	
	int cnt = 1;
	for (BoardItem boardItem : boardItemService.selectAll(boardid, keyword)) {
		if (cnt < from) {
			cnt++;
			continue;
		}
%>
		<tr>
			<td><%= cnt %></td>
			<td>
				<form id='oneBoardItem<%= boardItem.getItemid() %>' action='./oneBoardItem.jsp' method='post'>
					<input type='hidden' name='key_itemid' value='<%= boardItem.getItemid() %>'/>
					<input type='hidden' name='key_boardid' value='<%= boardid %>'/>
					<input type='hidden' name='key_count' value='<%= cnt %>'/>
				</form>
				<a href='javascript:$("#oneBoardItem<%= boardItem.getItemid() %>").submit()'><%= boardItem.getTitle() %></a>
			</td>
			<td><%= boardItem.getDate() %></td>
		</tr>
<%	
		cnt++;
		if (cnt > to) {
			break;
		}
	}
%>
	</table>
	<div>
		<div style="width: 140px; display: inline-block;"></div>
		<a href='boardItem.jsp?from=<%= from - onePage %>&to=<%= from - 1 %>&key_boardid=<%= boardid %>'>이전</a>
<%
	for (int i = 1; i <= boardItemService.selectAll(boardid, keyword).size() / onePage + 1; i++) {
%>
		<a href='boardItem.jsp?from=<%= (i-1)*onePage + 1 %>&to=<%= i*onePage %>&key_boardid=<%= boardid %>'><%= i %></a>
<%
	}
%>

		<a href='boardItem.jsp?from=<%= from + onePage %>&to=<%=from + 2*onePage - 1 %>&key_boardid=<%= boardid %>'>다음</a>
	</div>
	<br>
	<form id='search' action='./boardItem.jsp' method='post' accept-charset="utf-8">
		<input type='text' name='key_search'>
		<input type="hidden" name="key_boardid" value='<%= boardid %>'>
	</form>
	<button class='btn-1' onclick='javascript:$("#search").submit()'>검 색</button>
	<form action="./insert.jsp" method="post">
	   	<input type="hidden" name="key_insert" value='<%= boardItemHowMany + 1 %>'>
	   	<input type="hidden" name="key_boardid" value='<%= boardid %>'>
	   	<button class='btn-1' type="submit" formmethod="POST">새 글 작성</button>
	</form>
	<button class='btn-1' type="button" onclick="location.href='./board.jsp'">게시판 목록으로</button>
	
	<c:out value="hello world"/>
	<c:forEach var="boardItem" items="${boardItems}">
		<p><c:out value="${boardItem.id}" /></p>
	</c:forEach>
</body>
</html>








