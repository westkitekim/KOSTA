<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
		type 명시하지 않으면 submit(button) 
--%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>findcar-form</title>
	</head>
	<body>
	<%--
			index.jsp -- findcar-form.jsp -- FrontControllerServlet -- DAO -- DB
													  |
											     findcar-ok.jsp
											     	  or
											     findcar-fail.jsp
			
			Note> hidden의 위치는 form내부이면 어디든 상관없다
	 --%>
		<form action="FrontControllerServlet">
			<input type="hidden" name="command" value="findCarByNo">
			<input type="number" name="carNo" placeholder="차번호" required="required">
			<button>검색</button>
		</form>
	</body>
</html>













