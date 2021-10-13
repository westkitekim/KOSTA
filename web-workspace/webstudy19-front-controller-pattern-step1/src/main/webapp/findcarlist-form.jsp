<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>findcarlist-form</title>
	</head>
	<body>
	<%--
			index.jsp -- findcarlist-form.jsp -- FrontControllerServlet -- DAO -- DB
														  |
												 findcarlist-result.jsp
	 --%>
		<form action="FrontControllerServlet">
			<input type="hidden" name="command" value="findCarListByMaker">
			<input type="text" name="maker" placeholder="제조사" required="required">
			<button>조회</button>
		</form>
	</body>
</html>