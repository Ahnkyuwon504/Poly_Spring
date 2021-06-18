<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="board.domain.*" %>
<%@ page import="board.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Update</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
body {
	background-color : hotpink;
}
.simple_table {   font-weight: bold; width: 100%; border: none; border-collapse: separate; border-spacing: 2px;}
.simple_table th { padding: 15px; border: none; border-left: 5px solid #C03; border-bottom: 1px solid #DDD; background: #FCF0F3; font-weight: normal; text-align:center; text-shadow: 0 1px #FFF; vertical-align: middle;}
.simple_table td { padding: 15px; border: none; border-bottom: 1px solid #DDD; text-align: left; background: pink; vertical-align: baseline;}
button {
  background: none;
  border: 3px solid #fff;
  border-radius: 5px;
  color: #fff;
  display: block;
  font-size: 1.6em;
  font-weight: bold;
  margin: 1em auto;
  padding: 2em 6em;
  position: relative;
  text-transform: uppercase;
}

button::before,
button::after {
  background: #fff;
  content: '';
  position: absolute;
  z-index: -1;
}

button:hover {
  color: #2ecc71;
}

/* BUTTON 1 */
.btn-1::after {
  height: 0;
  left: 0;
  top: 0;
  width: 100%;
}

.btn-1:hover:after {
  height: 100%;
}
</style>
</head>
<body>
<h1 style='color : white'><b>수정 및 삭제 가능 있습니다.</b></h1>
<%
	try {
		request.setCharacterEncoding("utf-8");

		int count = Integer.parseInt(request.getParameter("count_key"));
		int id = Integer.parseInt(request.getParameter("board_key"));
		
		BoardService boardService = BoardServiceImpl.getInstance();
		Board board = boardService.selectOne(id);
%>
	<form id='updateBoard<%= id %>' action='./BoardList.jsp' method='post' accept-charset="utf-8">
	<table class='simple_table'>
		<tr>
			<th>번호</th>
			<td>
				<input type='text' value='<%= count %>' readonly>
				<input type='hidden' name='board_key' value='<%= board.getId() %>'/>
			</td>
		<tr>
		<tr>
			<th>제목</th>
			<td>
				<input type='text' name='update_title_key' value='<%= board.getTitle() %>'/>
			</td>
		<tr>
		<tr>
			<th>일자</th>
			<td>
				<input type='text' value='<%= board.getDate() %>' readonly>
			</td>
		<tr>
		<tr>
			<th>내용</th>
			<td>
				<input type='text' name='update_content_key' value='<%= board.getContent() %>'/>
			</td>
		<tr>
	</table>
	</form>
	<button class='btn-1' type="button" onclick="location.href='./BoardList.jsp'">취소</button>
	<form action="./BoardList.jsp" method="post">
    	<input type="hidden" name="delete_key" value='<%= id %>'>
    <button class='btn-1' type="submit" formmethod="POST">삭제</button>
	</form>
	<button class='btn-1'>
		<a href='javascript:$("#updateBoard<%= id %>").submit()'>수정</a>
	</button>
<%
	}
	catch (Exception e) {
		out.print(e);
	}
%>
</body>
</html>