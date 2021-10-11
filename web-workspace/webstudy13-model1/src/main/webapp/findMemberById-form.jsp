<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원검색폼</title>
</head>
<body>
<%-- Model 1 Architecture 방식으로 회원 검색서비스를 구현 --%>
	<form action="findMemberById-action.jsp">
		<input type="text" name="memberId" placeholder="아이디" required="required">
		<button type="submit">검색</button>
	
	</form>
</body>
</html>