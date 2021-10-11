<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step5-1-select</title>
</head>
<body>
	<form action="step5-2-select-action.jsp">
		<select name="line" required="required">
			<%--버튼을 통해 서버로 전송 submit --%>
			<%--기본값, 선택하지 않았을때 기본으로 선택되어 있는 value값 --%>
			<option value="">-호선-</option>
			<%
			for (int i = 1; i <= 9; i++) {
			%>
			<option value="<%=i%>">-<%=i%>호선-
			</option>
			<%
			}
			%>
		</select>
		<button type="submit">선택</button>
	</form>
	<%--
			jsp for loop를 이용해 1호선 ~ 9호선 까지 옵션을 생성한다
			실제 전송 정보는 호선을 제외한 1~9까지의 정보가 전송된다
			
			선택 submit을 누르면 
			step5-2-select-action.jsp
			
			1~4호선까지는 코레일 3호선 선택하셨습니다
			5~9호선까지는 도시철도 6호선 선택하셨습니다  로 응답하게 만든다
	 --%>
</body>
</html>