<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>
<body>
	<h3>SpringMVC + MyBatis</h3>
	<br><br>
	<a href="getTotalCustomerCount.do">고객수 보기</a>
<!-- 
		CustomerController 				CustomerMapper		 	 DB
		getTotalCustomerCount() --					---
			|
		WEB-INF/views/customer-count.jsp
		고객 수는 1명입니다
		
 -->
 
 	<br><br>
 	<form action="findCustomerById.do">
 		<input type="text" name="id" placeholder="아이디" required="required">
 		<button>검색</button>
 	</form>
<!-- 
		CustomerController			CustomerMapper
		findCustomerById()	---
		|
		findbyid-success.jsp or findbyid-fail.jsp
	
-->
 
  	<br><br>
 	<form action="registerCustomer.do" method="post"><%-- post방식만 가능하게 한다 --%>
 		<input type="text" name="id" placeholder="아이디" required="required"><br>
 		<input type="text" name="name" placeholder="이름" required="required"><br>
 		<input type="text" name="address" placeholder="주소" required="required"><br>
 		<button>등록</button>
 	</form>
<%--
		* POST 요청방식만 고객등록되게 하고,
		  등록 성공시에는 redirect 방식으로 응답
		  중복되어 등록 안될 때는 forward 방식으로 응답
		
		CustomerController
		|
		registerCustomer() : 중복확인은 mapper.findCustomerById()를 이용
		|
		register-success.jsp or duplicate-id.jsp(아이디가 중복될 경우) 
 --%>
</body>
</html>


















