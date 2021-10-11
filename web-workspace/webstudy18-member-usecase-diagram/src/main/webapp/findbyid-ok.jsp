<%@page import="org.kosta.webstudy18.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findbyid-ok</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
	<div class="container">
	<a href="index.jsp">Home</a>
	<%
		MemberVO vo = (MemberVO)request.getAttribute("mvo");
	%>
		<h3>검색결과</h3>
		<table>
			<thead>
				<tr>
					<th>아이디</th><th>이름</th><th>주소</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=vo.getId() %></td>
					<td><%=vo.getName() %></td>
					<td><%=vo.getAddress() %></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>