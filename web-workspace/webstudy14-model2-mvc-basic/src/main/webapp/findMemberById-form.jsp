<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원검색폼</title>
</head>
<body>
<%--
		client  ---  FindMemberByIdServlet  ---  Model ( MemberDAO ) --- Database
							  |
							  | forward
							  |
					 1. findMemberById-ok.jsp  
					 			or
					 2. findMemberById-fail.jsp

 --%>
 	<form action="FindMemberByIdServlet">
 		<input type="text" name="memberId" required="required" placeholder="아이디">
 		<input type="submit" value="검색">
 	</form>
</body>
</html>




















