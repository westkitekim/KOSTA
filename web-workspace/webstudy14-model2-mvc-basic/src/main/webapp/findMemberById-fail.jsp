<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findMemberById-fail</title>
</head>
<body>
	<%-- 
			Controller인 FindMemberByIdServlet에서 forward 방식으로 이동했으므로
			아래와 같이 client가 전달한 id를 얻어와 출력할 수 있다
			
			view 만 담당하므로 alert() 기능만 수행한다
	 --%>
	<script type="text/javascript">
		alert("<%=request.getParameter("memberId")%>아이디에 대한 회원정보가 없습니다");
		location.href="findMemberById-form.jsp";
	</script>
</body>
</html>