<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step1 jsp basic</title>
</head>
<body>
	<!-- html 주석 -->
	<%-- jsp 주석 :  client 측에 전달되지 않는다 --%>
	<%-- jsp 주석은 클라에게 보이지 않는다. 크롬 우클릭 페이지 소스보기 - jsp 주석은 안보인다 --%>
	jsp 기본
	<br>
	<br>
	<%
	//script 안에서는 java 주석으로 사용한다 
	//아래 코드는 service() 메서드 내에 삽입된다 
	for (int i = 0; i < 10; i++) {
	%>
	<font color="green" size="5"><%=i+1 %>.가을전어회</font><br>
	<%
	}
	%>
	<br><br>
	
	<%-- 인스턴스 변수 선언 --%>
	<%
		//private int count; -- error : local variable 에서는 modifier 사용 불가 (service() 내부이므로)
	
	%>
	<%!
		private int count;
	%>
	<%-- service메서드 내에 out.print(count++) 로 코드가 생성 --%>
	<%-- 인스턴스 변수이므로 다른 웹브라우저에서도 count가 유지된다 --%>
	접속수 <%=count++ %>

</body>
</html>