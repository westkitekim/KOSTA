<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		getAttribute(name) 은 서블릿에서 setAttribute(name, value)해준 값을 가져오는 것이고 
		getParameter(name) 은 클라의 요청에서 입력값을 가져오는 것! 
 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>findcar-ok</title>
	</head>
	<body>
		<a href="index.jsp">Home</a><hr>
		<%=request.getParameter("carNo") %> 차량정보 <br>
		<%=request.getAttribute("carInfo") %>
	</body>
</html>