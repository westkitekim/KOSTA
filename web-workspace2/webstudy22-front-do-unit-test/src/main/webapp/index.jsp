<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>.do test</title>
	</head>
	<body>
		<h3>client 요청방식 *.do 에 대한 단위테스트</h3>
		<%--
				요청 url이 .do 로 마치는 것은 모두 FrontControllerServlet이 처리하도록 설정하여 테스트 해본다
				현 페이지에서 요청해보고 서버 상의 콘솔에서 결과를 확인한다(서블릿에서 실행하는 것 아님..) 
		 --%>
		<a href="FindController.do">조회</a><br><br>
		<form action="RegisterController.do">
			<button>등록</button>
		</form>
	</body>
</html>