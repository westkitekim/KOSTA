<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login-fail.jsp</title>
</head>
<body>
	<%-- login-fail.jsp 먼저 실행시켜서 오류가 없는지 확인 --%>
	<script type="text/javascript">
		alert("로그인 실패");
		location.href="mvc-login.jsp";
	</script>
</body>
</html>