<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>findbyid-ok</title>
	</head>
	<body>
		<a href="index.jsp">Home</a><br><br>
		고객정보 : <%=request.getAttribute("customerInfo") %>
	</body>
</html>