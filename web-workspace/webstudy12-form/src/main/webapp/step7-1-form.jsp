<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step7-1-form</title>
</head>
<body>
	<form action="step7-2-location-action.jsp" method="post" onsubmit="checkAge()">
		<input type="text" name="userName" placeholder="이름" required="required">
		<input type="number" name="userAge" placeholder="나이" min="1" required="required">
		<%-- button tag는 type을 별도로 명시하지 않으면 submit type이다 --%>
		<button>입장하기</button>
	</form>
	<%--
	
			step7-2-location-action.jsp
			19세 이상이면
			아이유님 즐거운 성인영화 관람되세요
			
			19세 미만이면 
			alert() 나이 더 먹고 오세요 
	
	 --%>
	 
</body>
</html>