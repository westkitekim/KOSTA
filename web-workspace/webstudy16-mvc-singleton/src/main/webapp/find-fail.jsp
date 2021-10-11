<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>find-fail</title>
</head>
<body>
<%--
		javascript alert 으로 메세지를 7 아이디에 해당하는 상품 정보가 없습니다 
		확인 누르면 
		index.jsp로 이동하게 한다
		
 --%>
 <script type="text/javascript">
 	//컨트롤러 거쳐도 request살이있음
 	alert("<%=request.getParameter("productId")%> 아이디에 해당하는 상품 정보가 없습니다");
 	location.href="index.jsp";
 </script>
</body>
</html>