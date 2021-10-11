<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    <%-- isErrorPage : 에러페이지임을 알린다 --%>
<%
	//로깅라이브러리가 있는데, 파일에다가 로깅할 수 있도록 있음, 지금은 콘솔에서만 확인한다  - 나중에 스프링에서 사용
	//isErrorPage=true 명시했을때만 아래 코드를 사용가능
	//exception 객체는 isErrorPage="true" 를 설정했을 때 사용할 수 있다
	//에러 났을 때 콘솔이든 파일이든 항상 메세지를 남겨야 한다 - 꿀꺽 하고 무시하지 말것
	exception.printStackTrace();//예외 메세지와 발생 경로를 콘솔에 출력한다
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공사중</title>
</head>
<body>
<%-- jsp에서 에러가 발생하면 현 페이지를 클라이언트에게 보여준다 --%>
<img src="images/gong.jfif">
</body>
</html>