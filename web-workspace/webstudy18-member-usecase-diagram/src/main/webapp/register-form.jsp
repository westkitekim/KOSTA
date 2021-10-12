<%@page import="org.kosta.webstudy18.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
 <link rel="stylesheet" type="text/css" href="css/home.css">
		<%-- 
				가입하기 submit 을 누르면
				패스워드와 패스워드 확인란과 동일한 패스워드를 입력했을 때만 submit 되게 javascript로 
				구현해본다
				
				일치하지 않으면 alert 로 패스워드와 패스워드 확인이 일치하지 않습니다 후 전송하지 않는다
		 --%>
		 
		 <%--
		<script type="text/javascript">
			function checkRegForm() {
				
				let p = document.getElementById("pass");
				let pCheck = document.getElementById("confirmPass");
				
				if(p.value != pCheck.value) {
					alert("패스워드와 패스워드 확인이 일치하지 않습니다");
					return false
				}
			}
		</script> 
		 --%>
		
		<!-- 강사님 풀이 -->
		<script type="text/javascript">
			function checkRegForm() {
				if(document.getElementById("pass").value != document.getElementById("confirmPass").value) {
					alert("패스워드와 패스워드 확인이 일치하지 않습니다");
					return false;//false를 리턴하면 전송되지 않는다
				}
				//인증받은 아이디(hidden에 저장되어 있는 value)와 input text에 입력된 아이디와
				//일치하지 않으면 가입시키지 않는다
				//사용가능시에 인증받은 아이디를 히든태그 value에 넣어줬으므로 비교해준다
				
				//나는 공란의 경우만 조건문에 넣어줬음 - 이렇게 하면 중복확인으로 가입가능상태를 받아놓고 
				//중간에 아이디를 다시 존재하는 것으로 수정해도 가입이 진행되어 버린다. 
				//따라서 hidden tag의 value 값과 사용자가 입력한 id를 비교하는 작업이 필요하다
				if(document.getElementById("flag").value != document.getElementById("id").value){
					alert("인증받은 아이디가 아닙니다 \n아이디 중복확인하세요");
					return false;
				}
					
			}
			/* 내 풀이 
			function checkId() {
				let mid = document.getElementById("id");
				
				if(mid.value == "") {
					alert("닉네임을 입력하세요!");
					mid.focus();
				}else {
					//팝업창을 띄울 때 server로 닉네임을 전달하려고 한다 : query string 이용
					//jsp가 아니라 서블릿으로 간다
					
					//query string은 GET 방식!! 
					window.open("IdCheckServlet?id=" + mid.value, "mypopup", "width=250, height=150, top=150, left=400");
				}
				
			*/
			function checkId() {
				let mid = document.getElementById("id");
				
				if(mid.value == "") {
					alert("아이디를 입력하세요!");
					mid.focus();
				}else {
					//팝업창을 띄울 때 server로 닉네임을 전달하려고 한다 : query string 이용
					//jsp가 아니라 서블릿으로 간다
					
					//query string은 GET 방식!! 
//★★★★★★★★★★★★헷갈렸던 부분 : 부모창에서 팝업을 띄울때 jsp로 접근한게 아니라 서블릿을 열어준다
//							- 서블릿에서 조건 확인 후에 각각에 해당하는 idcheck-ok.jsp/ idcheck-fail.jsp를 선택하여 열어주기 때문

<%--						- 그리고 id= ? 값에 <%=request.getParameter("id")%>가 아닌
							  같은 페이지에서 값을 불러오는 것이기 때문(?)에 위에서 설정해준 mid 변수의 value 값인
							  mid.value로 작성해야 한다.
--%>						
					window.open("IdCheckServlet?id=" + mid.value, "mypopup", "width=250, height=150, top=150, left=400");
				}
			}
		</script>
</head>
<body>
	<div class="container">
	
		<a href="index.jsp">Home</a><br>
		<hr>

		<form action="RegisterMemberServlet" method="post" onsubmit="return checkRegForm()">
			<input type="text" name="id" id="id" required="required" placeholder="아이디">
			<%-- 클라이언트가 아이디 중복확인 작업을 수행했는지 여부를 저장하는 용도로 hidden을 이용한다 --%>
			<input type="hidden" id="flag" value="">
			<button type="button" onclick="checkId()">중복확인</button><br>
			<br>
			<input type="password" name="password" id="pass" required="required" placeholder="패스워드"><br><br>
			<input type="password" name="confirmPassword" id="confirmPass" required="required" placeholder="패스워드확인"><br><br>
			<input type="text" name="name" required="required" placeholder="이름"><br><br>
			<input type="text" name="address" required="required" placeholder="주소"><br><br>
			<button type="submit">가입하기</button>
			<!-- button - onclick : 중복확인시 -->
			
		</form>
	</div>
</body>
</html>















