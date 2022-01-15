<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>비동기 방식 테스트</title>
	</head>
	<body>
		<script type="text/javascript">
			let xhr;
			function startAjax() {
				xhr = new XMLHttpRequest();// Ajax 통신을 위한 자바스크립트 객체
				//test
				//alert(xhr);
				
				//아래의 callback 함수를 등록 : ajax 요청에 대해 서버가 응답하면 실행될 함수
				//onreadystatechange : readyState 상태가 변경될 때 실행됨 (4 라는 상태값이 응답완료)
				//콜백함수명을 등록(함수 자체가 객체, 함수 자체를 할당)
				//콜백이라는 함수 객체(callback()함수 구현체까지 모두)를 등록, javascript는 함수 자체가 객체
				xhr.onreadystatechange = callback;
				//서버와 통신하기 위해 필요한 정보를 할당
				xhr.open("get","AsynServlet");
				//서버와 통신을 요청
				xhr.send();
			}
			function callback() {
				//ajax 학습문서 참고
				//readyState : 4 서버로부터 데이터를 응답받은 상태
				//status 200 : 정상수행
				if(xhr.readyState == 4 && xhr.status == 200) {
					//responseText : 서버가 응답한 데이터
					alert(xhr.responseText);
					document.getElementById("resultView").innerHTML = xhr.responseText;
				}
			}
		</script>
		
<%-- 비동기일 때는 javascript에서 바로 Servlet으로 요청하기 때문에 form의 action 필요없음 --%>
		<form>
			<input type="text" name="userInfo">
			<button type="button" onclick="startAjax()">비동기방식테스트</button>
			<span id="resultView"></span>
		</form>
		<hr>
		<textarea rows="50" cols="50"></textarea>
	</body>
</html>