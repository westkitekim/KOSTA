<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    <%-- errorPage : 현 jsp 에서 error가 발생하면 지정한 jsp로 클라이언트에게 응답하게 하는 설정, 웹컨테이너에게 알리는 것
    				 지정하지 않으면 HTTP 상태코드(Http status) 메세지가 그대로 출력된다. 현재에서는 서버의 문제이므로 500코드 출력
    --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>errorPage 설정 테스트</title>
</head>
<body>
<%
	String name="아이유";
	//테스트를 위해 고의로 예외를 발생시켜본다
	name=null;
%> 이름은 <%=name.length() %>자로 구성되어 있습니다
</body>
</html>