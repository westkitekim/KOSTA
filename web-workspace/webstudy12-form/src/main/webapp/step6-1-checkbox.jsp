<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step6-1-checkbox</title>
</head>
<body>
<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("마라탕");
	list.add("라면");
	list.add("닭강정");
%>
	
	<script type="text/javascript">
		//javascript 에서 onsubmit은 return false일 때만 전송되지 않고
		//나머지 return true나 return을 하지 않아도 전송된다
		function checkMenu() {
			let flag = false;
			let m = document.getElementsByName("menu");
			//for loop it ~ checked
			for(let i = 0; i < m.length; i++) {
				if(m[i].checked) {
					flag=true;
					break;
				}//if
			}//for
			if(flag == false) {
				alert("메뉴를 선택하세요!");
				return flag;
			}
		}//function
	
	</script>
	
	<form action="step6-2-checkbox-action.jsp" method="get" onsubmit="return checkMenu()">
		<%
		for(int i = 0; i < list.size(); i++) {
		%>
		<%-- checkbox에서는 requried 할 수 없음 - 전체 선택해야함
 			 http에 의해 html로 전송되면 모두 텍스트다
		--%>
		<input type="checkbox" name="menu" value="<%=list.get(i)%>"><%=list.get(i)%> <br>
		<%} %>
		<input type="submit" value="주문">
	</form>
	<%-- 
			step1.
			
			javascript로 checkbox에 하나 이상 체크가 되어 있지 않으면 -- onsubmit -- return false 는 안넘어감
			alert() 으로 메뉴를 선택하세요 후 전송시키지 않는다 
			
			step2. 
			
			step6-2-checkbox-action.jsp 에서 테이블 형식으로 선택한 메뉴를 보여준다
			
	
	 --%>
</body>
</html>
































