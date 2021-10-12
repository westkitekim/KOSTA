<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>step15-popup.jsp</title>
			<script type="text/javascript">
				function closePopup() {
					//자신을 띄운 웹페이지 요소에 접근
					//자바스크립트의 opener 객체 : 자신을 띄운 웹페이지를 제어하기 위한 객체
					//본 창의 nick 입력 text 요소에 접근해서 value를 삭제해본다
					opener.document.getElementById("nick").value="";
					//본 창의 hidden flag에 접근해서 닉네임을 할당해본다 - hidden에 값 할당
					opener.document.getElementById("flag").value="<%=request.getParameter("nick")%>";
					//자신의 창을 종료
					self.close();
				}
			</script>
	</head>
	<body bgcolor="yellow">
		<%=request.getParameter("nick") %>님!
		팝업창입니다 <br><br>
		<input type="button" value="확인" onclick="closePopup()">
	</body>
</html>