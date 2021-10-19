<%@page import="model.FoodVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EL 기본연습</title>
	</head>
	<body>
	<%-- EL 사용시 import는 필요없음, 지금은 데이터를 넣어주기 위해 필요 --%>
	<%
		//컨트롤러에서 공유했다고 가정
		FoodVO vo = new FoodVO("짜장면", 5000);
		//1. request에 저장
		request.setAttribute("fvo", vo);//controller 에서 (set)넣어줬다고 가정
		//2. session에 저장
		session.setAttribute("food", new FoodVO("탕수육", 10000));
		//3. 동일한 이름의 request와 session에 정보를 할당(test용도)
		request.setAttribute("test", new FoodVO("떡볶이", 2000));
		session.setAttribute("test", new FoodVO("피자", 12000));
		
		
	%>
		1. 기존 방식으로 표현 : 
	<%
		FoodVO fvo = (FoodVO)request.getAttribute("fvo");
		FoodVO fvo2 = (FoodVO)session.getAttribute("food");
	%><%=fvo.getName() %>	<%=fvo.getPrice() %>
	  <%=fvo2.getName() %>	<%=fvo2.getPrice() %>
		<br><br>
		
		<%-- 
				${requestScope.fvo.name } 가 더 정확한 표현이며 requestScope는 생략가능, down casting 필요 없음
				하지만 구분이 필요한 때가 있다
		--%>
		2. EL 방식으로 표현 : ${fvo.name} ${fvo.price} ${requestScope.fvo.name } ${requestScope.fvo.price }
						  ${food.name } ${food.price } ${sessionScope.food.name } ${sessionScope.food.price }
		
		<br><br>
		3. 동일한 name 의 정보를 request와 session에서 EL로 정보를 확인 : 
		<%-- 
				아래와 같이 별도의 Scope를 명시하지 않으면 request 영역에 있는 정보를 반환한다
				request < session < application(ServletContext) 순으로 작은 범위의 값이 출력된다
		--%>
			${test.name } ${test.price } <%-- 떡볶이 2000 출력 --%>
		<%-- 
				session의 test 정보를 얻으려면 Scope를 명시한다
		--%>
			${sessionScope.test.name } ${sessionScope.test.price } <%-- 피자 12000 출력 --%>
	</body>
</html>

























