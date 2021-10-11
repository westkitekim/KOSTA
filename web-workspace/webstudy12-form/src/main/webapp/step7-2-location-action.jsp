<%@page import="javax.management.modelmbean.RequiredModelMBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step7-2-location-action</title>
</head>
<body>
	<%-- 김서연쓰
	<%
		String name = request.getParameter("userName");
		int age = Integer.parseInt(request.getParameter("userAge"));
		if(age >= 19) {
			
	%>
		<%=name %>님 즐거운 성인영화 관람되세요
		
		<%}else %>
		
		--%>
	
	<%-- 
			<%= %>는 문자열과 동일하게 안에서 사용 가능 -> <%=name%>
			jsp 코드가 아니면 모두 html 영역 
	--%>

	<%
	request.setCharacterEncoding("utf-8");//post방식 한글처리
	String name = request.getParameter("userName");
	int age = Integer.parseInt(request.getParameter("userAge"));
	if (age >= 19) {
	%>
	<%=name%>님 즐거운 성인영화 관람되세요
	<%
	} else {
	%>
		<script type="text/javascript">
			alert("<%=name%>님 나이 더 드시고 오세요")
			//지정한 경로로 이동시킨다
			//아래처럼 query string을 이용해 데이터를 전달할 수 있다(?~~~)
			<%-- <%= %>를 스크립트에서 문자열로 인식 --%>
			location.href="step7-3-child.jsp?name=<%=name%>";
		</script>
	<%
	}
	%>
</body>
</html>























