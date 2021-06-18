<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="board.domain.*" %>
<%@ page import="board.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
body {
	background-color : hotpink;
}
.simple_table { font-weight: bold; width: 100%; border: none; border-collapse: separate; border-spacing: 2px;}
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
<h1 style='color : white'><b>게시물 생성 가능하십니다!</b></h1>
<%
	try {
		request.setCharacterEncoding("utf-8");

		int count = Integer.parseInt(request.getParameter("insert_key"));
		
		BoardService boardService = BoardServiceImpl.getInstance();
%>
	<form id='insertBoard' action='./BoardList.jsp' method='post' accept-charset="utf-8">
	<table class='simple_table'>
		<tr>
			<th>번호</th>
			<td>
				<input type='text' value='<%= count %>' readonly>
			</td>
		<tr>
		<tr>
			<th>제목</th>
			<td>
				<input type='text' maxlength="20" required name='title_key'/>
			</td>
		<tr>
		<tr>
			<th>일자</th>
			<td>
				<input type='text' name='date_key' value='<%= boardService.getDate() %>' readonly>
			</td>
		<tr>
		<tr>
			<th>내용</th>
			<td>
				<input type='text' name='content_key'/>
			</td>
		<tr>
	</table>
	</form>
	<button class='btn-1' type="button" onclick="location.href='./BoardList.jsp'">취소</button>
	<button class='btn-1'><a href='javascript:$("#insertBoard").submit()'>추가</a></button>
<%
	}
	catch (Exception e) {
		out.print(e);
	}
%>
</body>
</html>