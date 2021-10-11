<%@page import="org.kosta.webstudy18.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="container">
		<h3>Model2 MVC 회원관리</h3>
		<%-- 1. 아이디로 회원 검색 --%>
 		<form action="FindMemberByIdServlet">
 			<input type="text" name="memberId" required="required" placeholder="아이디">
 			<button type="submit">검색</button>
 		</form>
 		
 		<%--2. 로그인 로그아웃 --%>
 		<%-- 비로그인 상태일때는 로그인 폼을 제공한다 --%>
 	
		<%-- 로그인 상태일때는 누구님 반갑습니다, 로그아웃 링크를 제공한다 --%>
		
		
					<br><br>
 		<form action="LoginServlet" method="post">
 			<input type="text" name="id" required="required" placeholder="아이디"><br>
 			<input type="text" name="password" required="required" placeholder="패스워드"><br>
 			<button type="submit">로그인</button>
		</form>
				
		<%
			MemberVO vo = (MemberVO)request.getAttribute("logmvo");
			if(vo == null) {
		%>	
		
		<%		
		} else {
		%>
			<%=vo.getName() %> 님 반갑습니다<br>
				<button type="submit">로그아웃</button>
		<%
		}
		%>
	</div>
</body>
</html>















