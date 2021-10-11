<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session-test3</title>
</head>
<body>
<%
	//세션 무효화 처리 
	//내장객체로 사용 
	
	
	session.invalidate();
%> 세션 무효화 처리 
	<%-- 세션 무효화 처리되어 getAttribute 할 수 없다 --%>
	<%-- <%=session.getAttribute("mvo") %> --%> 
	<br><br>
	<a href="session-test1.jsp">session1에서 확인</a><br>
	<a href="session-test2.jsp">session3에서 확인</a><br>
</body>
</html>