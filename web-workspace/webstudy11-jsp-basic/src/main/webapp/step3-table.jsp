<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//지시자 태그를 따로 더 넣어주거나 ctrl + spacebar로 자동 import
	ArrayList<String> list = new ArrayList<String>();
	list.add("김치찌개");
	list.add("큐브스테이크");
	list.add("감자찜");
	list.add("생선찜");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp table 연습</title>

<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
	<!-- 김서연쓰 <%--안의 코드 확인, <%= %>를 써서 불필요한 out.println코드를 뺀다--%>
	<table border="1">
		<tr><%--for(int i = 0; i < list.size(); i++) { --%>
			<td><%--out.println(i); %></td><td><%out.println(list.get(i)); --%></td>
		</tr><%--} --%>
	</table>
	-->
	
	<table>
		<%
			for(int i = 0; i < list.size(); i++) { 
		%>
		<tr>
			<td><%=i %></td>
			<td><%=list.get(i)%></td>
		</tr>
		<%
		} 
		%>
	</table>
	
</body>
</html>