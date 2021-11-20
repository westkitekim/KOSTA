<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	<body>
		<%
		String id = request.getParameter("memberId");
		String password = request.getParameter("memberPass");
		String url = null;
		if(id.equals("java") && password.equals("1234")) {
			//로그인 정보를 담아야 하기 때문
			
		}else {
			
		}
		//response.sendRedirect(location);
		
		%>
	</body>
</html>