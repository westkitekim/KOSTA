<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step1-2-form-action</title>
</head>
<body>
<%--
		form에서 전달한 아이디와 이름을 입력받아 화면에 제공한다 
		아이디와 이름, 즉 input 태그의 name 값을 parameter로 받아 value 값을 반환한다
 --%>
 고객 아이디 :	<%=request.getParameter("userId") %>		
 고객이름 : <%=request.getParameter("userName") %>
</body>
</html>