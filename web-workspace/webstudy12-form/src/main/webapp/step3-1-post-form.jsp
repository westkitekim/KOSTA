<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post 방식 요청</title>
</head>
<body>
	<form method="post" action="step3-2-action.jsp">
		<input type="text" name="userName" placeholder="이름" required="required"><br> 
		<input type="number" name="userAge" placeholder="나이" required="required" min="1"><br>
		<button type="submit">전송</button>
	</form>
	<%--
		19세 이상이면 
		성인 
		미만이면
		미성년 
		
		성인 
		이름 : 박보검 
		나이 :19세 
		
		미성년
		이름 : 이강인 
		나이 : 18세 
 --%>
</body>
</html>



















