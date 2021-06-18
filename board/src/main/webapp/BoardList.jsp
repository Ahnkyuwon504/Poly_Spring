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
<style>
body {
}
.simple_table {   font-weight: bold; width: 100%; border: none; border-collapse: separate; border-spacing: 2px;}
.simple_table th {   padding: 15px; border: none; border-left: 5px solid #C03; border-bottom: 1px solid #DDD; background: #FCF0F3; font-weight: normal; text-align:center; text-shadow: 0 1px #FFF; vertical-align: middle;}
.simple_table td { padding: 15px; border: none; border-bottom: 1px solid #DDD; text-align: left; background: pink; vertical-align: baseline;}
button {
  background: black;
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

.input-1 {
  background: black;
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
</style>
</head>
<body>
<h1 style='color : black'><b>게시판 목록입니다!</b></h1>
<%
	try {
		request.setCharacterEncoding("utf-8");

		String updateid = request.getParameter("board_key"); 
		String delete = request.getParameter("delete_key");
		String date = request.getParameter("date_key");
		String search = request.getParameter("search_key");
		
		BoardService boardService = BoardServiceImpl.getInstance();
		int howMany = boardService.howMany();
		
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
		
		if (search != null) {
			int countForSearch = 1;
			
%>
	<table class='simple_table'>
<%		
			for (Board board : boardService.searchOne(search)) {
				
%>
		<tr>
			<td><%= countForSearch %></td>
			<td>
					<form id='oneBoard<%= board.getId() %>' action='./OneBoard.jsp' method='post'>
						<input type='hidden' name='board_key' value='<%= board.getId() %>'/>
						<input type='hidden' name='count_key' value='<%= countForSearch %>'/>
					</form>
					<a href='javascript:$("#oneBoard<%= board.getId() %>").submit()'><%= board.getTitle() %></a>
			</td>
			<td><%= board.getDate() %></td>
		</tr>
<%
			countForSearch++;
			}
%>
	</table>
	<form action="./Insert.jsp" method="post">
    	<input type="hidden" name="insert_key" value='<%= howMany + 1 %>'>
    	<button class='btn-1' type="submit" formmethod="POST">새 글 작성</button>
	</form>
	
	<form action="./BoardList.jsp" method="post" accept-charset="utf-8">
	   	<input class='input-1' type="text" name="search_key">
	   	<button class='btn-1' type="submit" formmethod="POST">검색</button>
	</form>
	
<%	
		return;
		}
		
		int count = 1;
%>
	<table class='simple_table'>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>등록일</th>
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
    	<button class='btn-1' type="submit" formmethod="POST">새 글 작성</button>
	</form>
	
	<form action="./BoardList.jsp" method="post" accept-charset="utf-8">
	   	<input class='input-1' type="text" name="search_key">
	   	<button class='btn-1' type="submit" formmethod="POST">검색</button>
	</form>
	
<%
	} catch (Exception e) {
		out.print(e);
	}
%>
</body>
</html>








