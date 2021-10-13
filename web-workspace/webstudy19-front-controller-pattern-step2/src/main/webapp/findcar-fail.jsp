<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		getParameter(name) - name 매칭 주의 
 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<script type="text/javascript">
			alert("<%=request.getParameter("carNo")%>차 정보가 존재하지 않습니다");
			location.href = "index.jsp";
		</script>
	</body>
</html>

























