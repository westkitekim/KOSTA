<%@page import="model.MemberVO"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findMemberById-action</title>
</head>
<body>
<%--
		findMemberById-form.jsp 의 폼으로부터 회원 아이디를 전달받는다
		MemberDAO 의 findMemberById(String id) : MemberVO 메서드를 구현한 후
		이 메서드를 이용해 전달받는 아이디에 대한 회원 정보를 반환받는다
		회원 정보가 존재하면 
		아이디 : java
		이름 : 아이유
		주소 : 오리
		
		존재하지 않으면 ( null 이 리턴될 경우 ) 
		javascript alert으로 머머 아이디에 대한 외원정보가 없습니다! 보여주고 확인 누르면
		findMemberById-form.jsp 로 다시 이동시킨다 ( javascript location.href=""를 이용 )
		
		구현순서 : MemberVO 정의 ->  MemberDAO 의 findMemberById() 메서드 구현 -> findMemberById-action 구현
--%>
<script>
	
</script>
	<%
	String id = request.getParameter("memberId");
	MemberDAO dao = new MemberDAO();
	MemberVO vo = dao.findMemberById(id);
	if(vo != null) {
	%>
	아이디 : <%=vo.getId() %><br>
	이름 : <%=vo.getName() %><br>
	주소 : <%=vo.getAddress() %>
	<%}else {%>
		<script type="text/javascript">
			alert("<%=id%>아이디에 대한 회원이 존재하지 않습니다");
			location.href = "findMemberById-form.jsp"
		
		</script>
	
	
	<%
	}
	%>


</body>
</html>










