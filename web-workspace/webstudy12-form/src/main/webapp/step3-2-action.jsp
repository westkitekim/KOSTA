<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step3-2-action</title>
</head>
<body>
<%
	//post 요청 메서드 일때는 별도의 한글처리가 필요 
	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("userName");
	//문자열로 받아오기 때문에 정수로 변환하여 연산
	int age = Integer.parseInt(request.getParameter("userAge"));
	if(age > 19) {
	%>	
	성인

	<%
	}else { 
	%>
	미성년
	<%
	}
	%>
	<br>
	이름 : <%=name %>
	<br>
	나이 : <%=age %>세
</body>
</html>











