<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
1. Ŭ������ �̸��� �°� ���������� �ɰ���
2. 
	<c:out value="hello world"/>
	<c:forEach var="boardItem" items="${boardItems}">
		<p><c:out value="${boardItem.id}" /></p>
	</c:forEach>

</body>
</html>