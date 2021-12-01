<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>home</title>
	</head>
	<body>
		<h1>SpringMVC MyBatis jUnit 연습</h1>
		<br><br>
		<!-- 첫화면 띄우면 정보(ex.${totalItemCount })를 가져와 띄움 -->
		아이템수 ${totalItemCount }
<!-- 
		HomeController  --  ItemMapper
		|
		home()
		|
		index.jsp
-->

		<br><br>
		<form action="findItemByNo.do">
			<input type="number" name="itemNo" placeholder="아이템번호" required="required">
			<button>검색</button>
		</form>
		
		<br><br>
		<a href="getAllItemList.do">아이템 리스트</a>
		
		<br><br>
		<form action="registerItem.do" method="post">
			<input type="text" name="name" placeholder="이름" required="required">
			<input type="text" name="maker" placeholder="제조사" required="required">
			<input type="number" name="price" placeholder="가격" required="required">
			<button>등록</button>
		</form>
		<%-- 
			register-item-result.jsp에서 등록된 아이템 상세 정보가 제공된다 
			
			index.jsp -- Controller					  Controller
						 registerItem() : redirect -> registerItemResult(itemNo)
						 										|
						 								register-item-result.jsp
		--%>
		
	</body>
</html>