<%@page import="org.kosta.webstudy16.model.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>find-ok</title>
</head>
<body>
<%
	//반환형이 object이므로 downcasting
	ProductVO vo = (ProductVO)request.getAttribute("pvo");
%>
아이디 : <%=vo.getId() %><br>
상품명 : <%=vo.getName() %><br>
제조사 : <%=vo.getMaker() %><br>
가격 : <%=vo.getPrice() %><br>
</body>
</html>