<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>registercar-form</title>
	</head>
	<body>
	<%--
			index.jsp -- registercar-form.jsp -- FrontControllerServlet -- DAO -- DB
														   |
														   | redirect
														   |
												 registercar-result.jsp
	 --%>
	 	<form action="FrontControllerServlet" method="post">
	 		<input type="hidden" name="command" value="registerCar">
	 		<input type="text" name="carInfo" placeholder="차정보" required="required">
	 		<button type="submit">등록</button>
	 	</form>
	</body>
</html>