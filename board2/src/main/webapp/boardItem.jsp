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
<link rel="stylesheet" type="text/css" href="./board.css">
</head>
<body>
<table>
<%
	BoardItemService boardItemService = BoardItemServiceImpl.getInstance();
	request.setCharacterEncoding("utf-8");
	
	String search = request.getParameter("key_search");
	int boardid = Integer.parseInt(request.getParameter("key_boardid"));
	int boardItemHowMany = boardItemService.selectAll(boardid).size();
	
	String keyword = "";
	
	if (search != null) {
		keyword = search;
	}

	int cnt = 1;
	for (BoardItem boardItem : boardItemService.selectAll(boardid, keyword)) {
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
	}
%>
</table>


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
</body>
</html>








