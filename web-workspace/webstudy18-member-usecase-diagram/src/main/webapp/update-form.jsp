<%@page import="org.kosta.webstudy18.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>update-form.jsp</title>
		<link rel="stylesheet" type="text/css" href="css/home.css">
	</head>
	<body>
		<div class="container">
		<a href="index.jsp">Home</a>
		<% 
		MemberVO vo = (MemberVO)session.getAttribute("mvo");
		if(vo != null) {
		%>
		<form action="UpdateMemberServlet" method="post">
			아이디<input type="text" name="id" readonly="readonly" value="<%=vo.getId() %>"><br>
			패스워드<input type="text" name="password" value="<%=vo.getPassword() %>" required="required"><br>
			이름<input type="text" name="name" value="<%=vo.getName() %>" required="required"><br>
			주소<input type="text" name="address" value="<%=vo.getAddress() %>" required="required"><br>
			<button type="submit">수정하기</button>
		</form>
		<%
		} else {
			response.sendRedirect("index.jsp");//로그인 상태가 아니면 index.jsp로 이동시킨다(참고사항)
		}%>
		</div>
	</body>
</html>