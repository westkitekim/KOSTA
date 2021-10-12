<%-- 내 풀이
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
			opener.document.getElementById("flag").value="<%=request.getParameter("id")%>";
			self.close();
		}
	</script>
</head>
<body bgcolor="yellow">
	<div class="container">
		<%=request.getParameter("id") %>는 사용가능!
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
<title>Insert title here</title>
	<script type="text/javascript">
		//현재 팝업을 띄운 본창의 hidden tag에 접근해서 인증받은 아이디를 할당한다
		//부모창 접근 : opener
		//아래 코드를 function 안에 넣어도 되긴 하지만 
		//이 경우는 확인버튼을 눌렀을 때에만 가입이 가능하다(눌렀을 때 가입 자격부여를 하고 싶다면 function안에 넣어주고
		//그게 아니라 팝업과 동시에 띄운 상태에서도 가입가능하게 하려면 function 밖에서 수행해줘야 한다 )
		opener.document.getElementById("flag").value="<%=request.getParameter("id")%>";
		function closePopup() {
			opener.document.getElementById("pass").focus();
			self.close();
		}
	</script>
</head>
<%-- onunload 는 창의 끄기 버튼을 누를때 발생하는 이벤트 --%>
<!-- onunload="closePopup() : 창이 x표시 눌러도 같이 적용됨 - 다음 입력창으로 커서 이동이 -->
<body bgcolor="yellow" onunload="closePopup()">
	<div class="container">
		<%=request.getParameter("id") %> 아이디 사용가능합니다<br><br>
		<input type="button" value="확인" onclick="closePopup()">
	</div>
</body>
</html>



















