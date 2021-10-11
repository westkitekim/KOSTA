<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Model2 MVC, Singleton</title>
</head>
<body>
	<h4>Model2 MVC + Singleton Design Pattern</h4>
	<%--
			index.jsp ----- FindProductByIdServlet -----  ProductDAO  			-----			Database
													findProductById(String id):ProductVO
									  |
									  | forward
									  |
							 find-fail or find-ok
	--%>
	<form action="FindProductByIdServlet">
		<input type="number" name="productId" placeholder="상품아이디" required="required">
		<!-- button은 default가 submit -->
		<button>검색</button>
	</form>
	<hr>
	<%--
			index.jsp  -----  RegisterProductServlet  -----  ProductDAO  	  ----- 		Database
			
														   register(ProductVO vo)
										|
										| redirect 방식으로 이동해서
										| 새로고침시 재등록되지 않도록 처리
										|
								register-result.jsp
	
	 --%>
	<%-- 상품 등록, id는 자동발급, id 제외한 나머지 등록 --%>
	<form action="RegisterProductServlet" method="post">
		<input type="text" name="name" placeholder="상품명" required="required"><br>
		<input type="text" name="maker" placeholder="제조사" required="required"><br>
		<input type="text" name="price" placeholder="가격" required="required"><br>
		<button>등록</button>
	</form>
</body>
</html>












