<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirect-result.jsp</title>
</head>
<body bgcolor="orange">
	redirect result view page
	<%-- redirect 방식은 아래와 같이 request에 저장된 정보를 사용할 수 없다 : 검색정보가 아닌 null이 출력--%>
	<%-- 새로운 HttpServletRequest의 request이므로 request변수 안에 담겨진 정보가 없다 --%>
	<%=request.getAttribute("shareInfo") %>
</body>
</html>