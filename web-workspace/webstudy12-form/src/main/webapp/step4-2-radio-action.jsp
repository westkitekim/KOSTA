<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step-4-radio-action</title>
</head>
<body>
	<% 
	//post request method이므로 한글처리
	request.setCharacterEncoding("utf-8");
	
	
	 
	%>
	<%-- radio는 반환하는 값이 1개이므로 getParameter로 1개만 받아온다 --%>
	<%=request.getParameter("menu") %> 주문완료!
	
</body>
</html>