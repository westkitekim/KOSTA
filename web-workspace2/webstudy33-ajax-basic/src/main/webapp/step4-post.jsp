<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>step4-post</title>
	</head>
	<body>
		<script type="text/javascript">
			function startAjax() {
				let m = document.getElementById("message").value;
				if(m == "") {
					alert("등록할 메세지를 입력하세요");
					return;
				}
				
				//Ajax 통신을 위한 객체 생성
				let xhr = new XMLHttpRequest();
				
				//콜백함수(서버가 응답하면 동작할 함수)를 익명함수로 등록 
				xhr.onload = function() {
					alert(xhr.responseText);
				}
				//ajax 통신을 위한 정보할당
				xhr.open("post", "AjaxPostServlet")
				//ajax post 방식일 때 content type을 지정해야 한다. 
				xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				//ajax
				xhr.send("message=" + m);
				
			}
			
		
		</script>
		<input type="text" id="message" placeholder="메세지">
		<button type="button" onclick="startAjax()">post ajax test</button>
	</body>
</html>















