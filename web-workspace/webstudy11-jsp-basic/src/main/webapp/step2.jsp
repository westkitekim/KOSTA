<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp lifecycle</title>
</head>
<body>
	<%!
		public void jspInit() {
			System.out.println("jspInit()");
		}
		public void jspDestroy() {
			System.out.println("jspDestroy()");
		}
	%>
	<%
		System.out.println("jspService");
	%>
	JSP LifeCycle Test
</body>
</html>