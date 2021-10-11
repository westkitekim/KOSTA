<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session-test2</title>
</head>
<body>
	<%
	//jsp에서는 기본session을 만들어준다
			
	//session-test1 에서 session에 저장한 회원 객체가 존재하는 지 확인해서 존재하면 회원 이름을 보여주고 
	//존재하지 않으면 현 세션에서는 회원정보가 존재하지 않습니다 라고 메세지를 보여준다 
	
	//브라우저 끄고 session 2만 실행하면 에러 
	
	MemberVO vo = (MemberVO)session.getAttribute("mvo");
	if(vo != null) {
	%>
		세션에 저장된 회원 이름 <%=vo.getName() %> 님 
	
	<%
	}else {
	%>
		현 세션에서는 회	원정보가 존재하지 않습니다
	<%
	}
	
	%>
	<br><br>
	<a href="session-test1.jsp">session1에서 확인</a><br>
	<a href="session-test3.jsp">session3에서 확인</a><br>
	
</body>
</html>












