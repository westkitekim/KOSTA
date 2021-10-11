<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp session test</title>
</head>
<body>
<%-- 서버상에서 세션이 만들어지고 세션 객체의 유일한 키값 : session id -- 얘가 쿠키로 전달 --%>
<%--
		web container에 의해 jsp 가 java로 생성되어 실행될 때 session을 생성하므로 아래와 같이 
		세션 아이디를 확인할 수 있다 ( tomcat/work 에서 확인 ) C:\kosta224\WAS\web-tomcat\work\Catalina\localhost\webstudy17-mvc-session\org\apache\jsp
		session_002dtest1_jsp.java 파일에서 확인 
 --%>
session id : <%=session.getId() %>
<%-- 같은 원리로 ServletConfig 와 ServletContext 객체도 config 와 application 변수로 사용할 수 있다 
	
	 ServletConfig : org.apache.catalina.core.StandardWrapperFacade@a599cb3

	 ServletContext : org.apache.catalina.core.ApplicationContextFacade@445c03bc
	 
	 로 출력된다 - 내장객체 이므로 변수를 바로 사용 가능 변수가 만들어져 있음 

--%>
<br><br>
ServletConfig : <%=config %>
<br><br>
ServletContext : <%=application %>
<br><br>
<%-- session에 회원객체를 할당해본다 --%>
<%
	MemberVO vo = new MemberVO("javaking", null, "아이유", "오리");
	session.setAttribute("mvo", vo);
	

%>
<a href="session-test2.jsp">session2에서 확인</a>
</body>
</html>









