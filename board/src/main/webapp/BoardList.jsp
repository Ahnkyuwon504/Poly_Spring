<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="board.domain.*" %>
<%@ page import="board.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>BoardList</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="./board.css?after">
</head>
<body>
<%
	try {
		request.setCharacterEncoding("utf-8");

		String updateid = request.getParameter("board_key"); 
		String delete = request.getParameter("delete_key");
		String date = request.getParameter("date_key");
		
		BoardService boardService = new BoardServiceImpl();
		
		if (updateid != null) {
			String title = request.getParameter("update_title_key");
			String content = request.getParameter("update_content_key");
			
			int updateId = Integer.parseInt(updateid);
			Board updateBoard = boardService.selectOne(updateId);
			boardService.update(updateBoard, title, content);
		}
		
		if (delete != null) {
			int deleteId = Integer.parseInt(delete);
			Board deleteBoard = boardService.selectOne(deleteId);
			boardService.delete(deleteBoard);
		}
		
		if (date != null && date.length() > 0) {
			String title = request.getParameter("title_key");
			String content = request.getParameter("content_key");
			Board insertBoard = new Board(title, date, content);
			boardService.create(insertBoard);
		}
		
		int count = 1;
%>
	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>등록일</td>
		</tr>
<%
		for (Board board : boardService.selectAll()) {
%>
		<tr>
			<td><%= count %></td>
			<td>
					<form id='oneBoard<%= board.getId() %>' action='./OneBoard.jsp' method='post'>
						<input type='hidden' name='board_key' value='<%= board.getId() %>'/>
						<input type='hidden' name='count_key' value='<%= count %>'/>
					</form>
					<a href='javascript:$("#oneBoard<%= board.getId() %>").submit()'><%= board.getTitle() %></a>
			</td>
			<td><%= board.getDate() %></td>
		</tr>
<%
		count++;
		}
%>
	</table>
	<form action="./Insert.jsp" method="post">
    	<input type="hidden" name="insert_key" value='<%= count %>'>
    	<button type="submit" formmethod="POST">새 글 작성</button>
	</form>
<%
	} catch (Exception e) {
		out.print(e);
	}
%>
</body>
</html>








