<%@page import="org.kosta.webstudy18.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
	<div class="container">
		<h3>Model2 Architecture MVC Pattern 회원관리</h3><hr>
		<%-- 1. 아이디로 회원 검색 --%>
 		<form action="FindMemberByIdServlet">
 			<input type="text" name="memberId" required="required" placeholder="아이디">
 			<button type="submit">검색</button>
 		</form>
		<br><br>
		<%-- 2. 로그인 로그아웃 --%>
		
 		<%--  2-1. 비로그인 상태일때는 로그인 폼을 제공한다 --%>
		<%
		//강사님은 MemberVO mvo 
		MemberVO vo = (MemberVO)session.getAttribute("mvo");
		if(vo == null) {//비로그인 상태
		%>
 		<form action="LoginServlet" method="post">
 			<input type="text" name="id" required="required" placeholder="아이디"><br>
 			<input type="password" name="password" required="required" placeholder="패스워드"><br>
 			<button type="submit">로그인</button>
		</form>
		<br><br>
		<%-- 회원가입 링크 anchor tag --%>
		<a href="register-form.jsp">회원가입</a>
		
		<%-- 2-2. 로그인 상태일때는 누구님 반갑습니다, 로그아웃 링크를 제공한다 --%>	
		<%-- 
			 로그 아웃은 get, post 다 가능하지만 권고하는 메서드는 로그인이나 로그아웃은 post 방식이다
			 get 방식일 경우 /LogoutServlet으로 웹브라우저에서 요청해도 들어가게 되어 url이 노출되기 때문에 
			 로그인과 로그아웃은 Post 방식으로 작성한다 
		
		 --%>
		<%		
		} else {//로그인 상태
		%>
		<%-- 
				- a href 링크는 기본적으로 get 요청방식이다 : 링크로 요청하기 때문  
				- 로그인, 로그아웃은 post 방식이 적합하다 
					( get 방식은 사용자가 브라우저 url 상에서 주소를 기입해서 실행해도 동작이 되기 때문 )
				<a href="#" onclick="logout()">로그아웃</a> 으로 post 방식 가능, #을 기입하고 onclick에 function을 기입한다
				
				
				코드 : 링크 살리기 
				<script type="text/javascript">
					function logout() {
						document.getElementById("logoutForm").submit();
					}
				</script>
				<form action="LogoutServlet" method="post" id="logoutForm"></form>
				<a href="#" onclick="logout()">로그아웃</a>
		--%>
		<!-- 버튼으로 전송하는 방법
			<form action="LogoutServlet" method = "post">
				<input type="submit" value = "로그아웃">
			</form> 
		--> 
		
		<script type="text/javascript">
			function logout() {
				document.getElementById("logoutForm").submit();
			}
			
		</script>
		
		
		<br><br>
	
		<form action="FindMemberListByAddressServlet">
			<input type="text" name="address" required="required" placeholder="주소">
			<button type="submit">조회</button>
		</form>
		<br><br>
		
		<%=vo.getName() %> 님 반갑습니다!<br><br>
		
		<form action="LogoutServlet" method="post" id="logoutForm"></form>
		<%--
			a 태그의 href 속성에 이동할 페이지를 작성하지 않고 "#" 만 넣어준다면
			페이지를 이동시키지 않고 함수를 부를 때 사용한다. 관례상 # 사용
			conclusion : 페이지 이동시키지 않고 함수만 실행시킬 경우 href="#" 작성! 
		--%>
		<a href="#" onclick="logout()">로그아웃</a>
		<br><br>
		<%-- 4. 회원정보수정 --%>
		<a href="update-form.jsp">회원정보수정</a>
		
		<%
		}
		%>
	</div>
</body>
</html>















