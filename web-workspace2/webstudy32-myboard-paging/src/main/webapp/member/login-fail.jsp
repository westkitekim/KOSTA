<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login fail</title>
</head>
<body>
<script type="text/javascript">
	alert("로그인 되지 않았습니다");
	//location.href="../ListController.do";// home으로 보낸다   ../ 를 한 이유는 member 디렉토리 상위로 가야하기 때문에 
	location.href="${pageContext.request.contextPath}/ListController.do";
	</script>
	<%-- el로 웹어플리케이션명(컨텍스트path)을 가지고 온다 --%>
<%-- ${pageContext.request.contextPath} --%>
</body>
</html>