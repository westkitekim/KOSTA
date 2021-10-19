<%@page import="org.kosta.webstudy23.model.ProductVO"%>
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
	<% 
		ProductVO vo = (ProductVO)request.getAttribute("pvo"); 
	%>
	상품 검색 결과 <br><br>
	아이디 :	<%=vo.getId() %><br>
	상품명 : 	<%=vo.getName() %><br>
	제조사 : 	<%=vo.getMaker() %><br>
	가격 : 	<%=vo.getPrice() %><br>
	등록일시 : <%=vo.getRegDate() %>	<br> 
</body>
</html>