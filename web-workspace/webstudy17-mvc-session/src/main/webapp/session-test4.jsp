<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    <%-- session="false"을 명시해서 session을 자동 생성하지 않도록 설정 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session-test4</title>
</head>
<body>
	<%--
			지시자 태그에서 세션을 자동 생성하지 않도록 설정했으므로 아래와 같이 error 난다
			session 자동생성하지 않으면 session파일에 session 지시자 사라진다 
			
			보통은 default로 session 자동생성 기능을 사용하지만 참고사항으로 알아둘 것!! 
	 --%>
	<%-- 
			<%@ %>지시자 코드에서 session="false"로 지정했다면 
			session 자동생성 안되었으므로 아래 코드는 error 발생
				<%=session %> 
			
			하지만 아래 코드는 정상 작동
				<%=application %> 
			어플리케이션 변수가 생성된 _jspServer()메서드에서 session만 만들어지지 않고(자동생성 false)
			ServletContext의 application 변수는 유효
	--%>
	
	
	세션을 자동 생성하지 않도록 설정 
	
	<%-- 필요시 세션을 생성하기 위해서는 아래와 같이 기술하면 된다 --%>
	<%
		HttpSession session = request.getSession();
	%>
	<%=session.getId() %>
</body>
</html>