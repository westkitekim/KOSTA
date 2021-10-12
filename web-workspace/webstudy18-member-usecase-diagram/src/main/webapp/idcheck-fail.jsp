<%--
<%@page import="org.kosta.webstudy18.model.MemberDAO"%>
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
				function closePopup() {
					let mmid = opener.document.getElementById("id");
					opener.document.getElementById("id").value="";
					mmid.focus();
					//자신의 창을 종료
					self.close();
				}
			</script>
	</head>
	<body bgcolor="orange">
		<div class="container">
			<%=request.getParameter("id") %>는 중복! 사용불가
			<input type="button" value="확인" onclick="closePopup()">
			
	 	</div>
	</body>
</html>

 --%>


<%-- 강사님 풀이 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디 중복</title>
	<script type="text/javascript">
		//중간에 중복확인 성공 받아놓고 중복되는 아이디로 수정할 수 있기 때문에 미리 히든을 초기화 시킨다
		opener.document.getElementById("flag").value="";
		function closePopup() {
			//본창의 아이디 text 란에 입력한 아이디 value를 삭제하고 포커스를 준다
			let idComp = opener.document.getElementById("id");
			idComp.value="";
			//자신의 창을 종료
			idComp.focus();
			self.close();
		}
	</script>
</head>
<body bgcolor="orange" onunload="closePopup()">
	<div class="container">
		<%=request.getParameter("id")%>아이디 중복되어 사용불가합니다 <br><br> 
		<button onclick="closePopup()">확인</button>
	</div>
</body>
</html>









