<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findMemberById-ok</title>
</head>
<body>
<%-- 
			Controller인 FindMemberByIdServlet에서 forward 방식으로 이동했으므로
			아래와 같이 아이디, 이름, 주소를 출력할 수 있다
--%>
<%
	MemberVO vo = (MemberVO)request.getAttribute("memberVO");

%>
아이디 : <%=vo.getId() %><br>
이름 : <%=vo.getName() %><br>
주소 : <%=vo.getAddress() %><br>
</body>
</html>