<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Web MVC, FrontController</title>
	</head>
	<body>
		<h3>Model 2 Architecture MVC, Singleton, Front Controller Design Pattern</h3>
<%--
		hidden 속성의 "command" name은 관례

		index.jsp --- FrontControllerServlet --- FindCustomerByIdController --- DAO --- DB
								|
						 findbyid-ok.jsp 
						 	   or
						 findbyid-fail.jsp
 --%>
 
 <%--
 		step6 에서는 command 를 컨트롤러명.do 스타일로 변경해서 적용해본다
 		
 		form의 action의 FrontControllerServlet을 각각의 서블릿 네임에 .do 붙임
 		원래의 url-pattern : FrontControllerServlet, 원래 코드 : <form action="FrontControllerServlet" method="post">
  --%>
		<form action="FindCustomerByIdController.do" method="get">
			<!-- <input type="hidden" name="command" value="FindCustomerByIdController"> -->
			<input type="text" name="id" placeholder="고객아이디" required="required">
			<button type="submit">검색</button>
		</form>
		<br><br>
		
		<form action="RegisterCustomerContorller.do" method="post">
			<!-- <input type="hidden" name="command" value="RegisterCustomerContorller"> -->
			<input type="text" name="customerInfo" placeholder="고객정보" required="required">
			<button type="submit">등록</button>
		</form>
		
		<br><br>
		<form action="UpdateCustomerContorller.do" method="post">
			<!-- <input type="hidden" name="command" value="UpdateCustomerContorller"> -->
			<input type="text" name="customerInfo" placeholder="고객정보" required="required">
			<button type="submit">수정</button>
		</form>
		<br><br>
		<form action="DeleteCustomerController.do" method="post">
			<!-- <input type="hidden" name="command" value="DeleteCustomerController"> -->
			<input type="text" name="customerId" placeholder="고객아이디" required="required">
			<button type="submit">삭제</button>
		</form>
		<br><br><br>
		<img src="image/frontcontroller.png">
	</body>
</html>






















