<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp와 html form 연동테스트</title>
</head>
<body>
	<!-- 아무것도 명시하지 않으면 form의 method는 get방식 -->
	<!-- jsp는 파일명이 자신의 url, action 의 수행할 jsp 파일이 없으면 404 에러-->
	<form action="step1-2-form-action.jsp">
		<input type="text" name="userId" placeholder="아이디" required="required">
		<input type="text" name="userName" placeholder="이름" required="required">
		<!-- submit으로 전송하면 form action의 서버의 url주소로 파일을 찾아간다 - 이게 없으면 404 에러 -->
		<input type="submit" value="전송">
	</form>
</body>
</html>