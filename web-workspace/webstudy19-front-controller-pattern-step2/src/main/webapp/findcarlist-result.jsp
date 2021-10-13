<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>findcarlist-result</title>
	</head>
	<body>
		<%
		@SuppressWarnings("unchecked") //casting warning 무시
		ArrayList<String> carList = (ArrayList<String>) request.getAttribute("carList");
		%>
		<a href="index.jsp">Home</a>
		<br>
		<br>
		<%=request.getParameter("maker") %> 제조사 차량리스트 <br><br>
		<%
		for (int i = 0; i < carList.size(); i++) {
		%>
		<%=carList.get(i)%><br>
		<%
		}
		%>
	</body>
</html>