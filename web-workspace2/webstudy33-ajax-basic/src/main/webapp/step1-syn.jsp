<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>동기적 방식 통신 테스트</title>
	</head>
	<body>
		<form action="SynServlet">
			<input type="text" name="userInfo">
			<button>동기방식테스트</button>
		</form>
		<hr>
		<textarea rows="50" cols="50"></textarea>
	</body>
</html>