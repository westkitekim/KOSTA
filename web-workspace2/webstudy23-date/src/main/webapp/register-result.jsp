<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>등록결과</title>
	</head>
	<body>
		<!-- 원래코드 -->
		<!-- <a href="index.jsp">Home</a> -->
		<!-- 상품이 등록되었습니다  -->
		
		<%-- 방법2) 등록결과 화면에서 alert로 등록완료 메세지를 보여준 후 상품리스트 페이지로 이동되도록 처리해본다  --%>
		<script type="text/javascript">
			alert("상품이 등록되었습니다");
			location.href="AllProductListController.do";
		</script>
	</body>
</html>