<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Model 1 Architecture 회원수 조회</title>
</head>
<body>
<%--Model 1 사용시 jsp-db.jsp와 비교했을 때 코드 길이 줄어듦, 수정은 MemberDAO에서만 하면 된다 --%>
<%--화면(view)이 변경돼야 한다면 jsp 파일 수정(Model 1) --%>
	<%-- Model 1 Architecture 회원수 조회 --%>
	<% 
		MemberDAO dao = new MemberDAO();
		int count = dao.getTotalCount();
	%>
	<h4>총 회원수 <%=count %>명 </h4>
</body>
</html>