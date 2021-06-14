<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.ac.kopo.kopo01.domain.*" %>
<%@ page import="kr.ac.kopo.kopo01.service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	BoardService boardService = new BoardServiceImpl();
	Board board1 = boardService.selectOne(1); // board선에선 boardservice 이용
	
	// 즉, 이 jsp 페이지에서는 어디서 가져오는지 관심도 없어..
	// 딱 두줄로 코드 끝
	
	
%>
hello world
board title: <%= board1.getTitle() %>
abcdfjkdsl
</body>
</html>








