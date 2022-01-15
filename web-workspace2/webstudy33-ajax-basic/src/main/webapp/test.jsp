<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<script type="text/javascript">
			let xhr;
			function startAjax() {
				xhr = new XMLHttpRequest();//Ajax 통신을 위한 js 객체 
				alert(xhr);
				//readyState 상태가 변경될때 실행된다(4일때 응답완료)
				
				xhr.onreadystatechange = callback;
				//아래의 callback()함수를 등록, 
				xhr.open('get', 'AsynServlet');
				xhr.send()
			}
			function callback() {
				if(xhr.readyState== 4 && xhr.status == 200) {
					alert(xhr.responseText);
					document.getElementById('resultView').innerHTML = xhr.responseTest;
				}
			}
			function startAjax2() {
				xhr = new XMLHttpRequest(); //Ajax 통신을 위한 javascript object
				alert(xhr);
				//callback 함수를 등록하고 
				//readyState 상태가 변경될때 실행된다(4라는 상태값은 응답완료)
				
				
				xhr.onreadyStateChange = callback;
				xhr.open('get', 'AsynServlet');
				xhr.send();
				
				
			}
			function callback2() {
				if(xhr.readyState == 4 && xhr.status == 200) {
					alert(xhr.responseText);
					document.getElementById('resultView').innerHTML = xhr.responseText;
				}
			}
		</script>
		
		<%-- 비동기일 때는 form 의 action 필요 없음  --%>
		<form> 
			<input type="text" name="userInfo">
			<button type="button" onclick="startAjax()">비동기방식테스트</button>
			<span if="resultView"></span>
		</form>
		<hr>
		<textarea rows="50" cols="50"></textarea>
	</body>
</html>