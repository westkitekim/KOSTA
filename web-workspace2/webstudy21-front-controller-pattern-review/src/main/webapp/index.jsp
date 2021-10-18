<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Model2 MVC FrontController Pattern</title>
	</head>
	<body>
		<h3>Model2 MVC FrontController Pattern Review</h3>
		<form action="FrontControllerServlet">
			<input type="hidden" name="command" value="FindProductByIdController">
			<input type="number" name="productId" placeholder="상품아이디" required="required">
			<button type="submit">검색</button>
		</form>
		<br><br>
		<%-- 아래와 같이 query string 방식으로도 동작 가능 --%>
		<a href="FrontControllerServlet?command=FindProductByIdController&productId=1">상품조회테스트</a>
		<br><br>
		<%--
			 FrontControllerServlet -- HandlerMapping -- RegisterProductController
			 		   |
			 		   | redirect
			 		   |
			  	register-result.jsp
		 --%>
		 
		<form action="FrontControllerServlet" method="post">
			<input type="hidden" name="command" value="RegisterProductController">
			<input type="text" name="productInfo" placeholder="상품정보" required="required">
			<button type="submit">등록</button>
		</form>	
		<br><br>
		<%-- 
				하이퍼링크를 이용한 요청한 Http Request Get Method 이다(링크는 get 요청방식) 
				상품등록은 Post 요청방식만 동작되도록 RegisterProductController 에 기능을 추가해본다
		--%>
		<a href="FrontControllerServlet?command=RegisterProductController&productInfo=참이슬">상품등록테스트</a>
	</body>
</html>


