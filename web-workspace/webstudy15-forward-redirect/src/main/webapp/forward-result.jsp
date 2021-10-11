<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward-result.jsp</title>
</head>
<!-- 구분을 위해 forward 배경색 지정 -->
<body bgcolor="yellow">
	forward-result view page
	
	<%-- forward 방식이므로 request 에 저장한 정보를 이용할 수 있다 --%>
	<%=request.getAttribute("shareInfo") %>
</body>
</html>