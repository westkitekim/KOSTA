<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step5-1-select2-onchange-javascript</title>
</head>
<body>
	<%-- submit 없이 option을 선택한 즉시 서버로 전송되도록 javascript onchange 속성을 이용해본다 --%>
	<%-- form에 javascript 지정 --%>
	
	<script type="text/javascript">
		function sendLine() {
			let lineComp=document.getElementById("line");
			if(lineComp.value!="") {
				//공란이 아닐때만 이벤트 발생
				//공란인 경우 : --호선-- : 기본선택
				//alert(lineComp.value); //test code
				
				//subway id form을 submit 한다
				//서버에 전송하는 것은 form이기 때문에!! 유의, form의 이름은 subway
				document.getElementById("subway").submit();
			}
		}
	</script>
	
	<%-- 
			select : 목록상자, 선택하면 서버에 전송되도록 구현해본다
			
			select에 name과 id가 둘 다 있는 이유 
				- id를 통해 javascript DOM객체에서 데이터를 가져오고 
				- jsp에서 서버를 통해 데이터를 가져와야 한다
				-> 둘 다 데이터를 가져오는 것이지만 가져오는 방법이 다르다고 해야할까?
			
			option : 목록상자 안에 들어가는 값, 기본값 따로, 연속적으로 들어가는 값은 
				     스크립틀릿을 이용하여 자바 코드의 반복문으로 작성한다 
	--%>
	<form action="step5-2-select-action.jsp" id="subway">
		<select name="line" id="line" required="required" onchange="sendLine()">
			<option value="">-호선-</option>
			<%
			for (int i = 1; i <= 9; i++) {
			%>
			<option value="<%=i%>">-<%=i%>호선-</option>
			<%
			}
			%>
		</select>
		<!-- <button type="submit">선택</button> -->
	</form>
	<%--
			예제) 
			
			jsp for loop를 이용해 1호선 ~ 9호선 까지 옵션을 생성한다
			실제 전송 정보는 호선을 제외한 1~9까지의 정보가 전송된다
			
			선택 submit을 누르면 
			step5-2-select-action.jsp
			
			1~4호선까지는 코레일 3호선 선택하셨습니다
			5~9호선까지는 도시철도 6호선 선택하셨습니다  로 응답하게 만든다
	 --%>
</body>
</html>