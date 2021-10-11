<%@page import="org.kosta.webstudy18.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>update-result.jsp</title>
		<link rel="stylesheet" type="text/css" href="css/home.css">
	</head>
	<body>
		<div class="container">
			<a href="index.jsp">Home</a><br><br>
			<%
			//session에서 데이터 가져오기
			MemberVO vo = (MemberVO)session.getAttribute("mvo");
			%>
			회원정보 수정완료 <br><br>
			아이디: <%=vo.getId() %><br>
			이름: <%=vo.getName() %><br>
			주소: <%=vo.getAddress() %><br>
		</div>
	</body>
</html>