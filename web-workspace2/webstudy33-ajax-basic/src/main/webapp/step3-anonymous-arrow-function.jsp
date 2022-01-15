<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>step3-anonymous-arrow-function</title>
	</head>
	<body>
		<h2>자바스크립트 익명함수(anonymous function)와 화살표함수(arrow function: ECMA6에서 추가된 함수)</h2>
		<script type="text/javascript">
			// 1. 일반적인 함수
			/*
			function hello() {
				alert("hello 일반함수");
			}
			hello();
			*/
			
			// 2. 익명함수: 함수명 없음 -> 위 코드와 동일한 결과값이나 방법의 차이 
			// 변수에 익명함수 객체를 할당, 편리성 : 굳이 버튼이 클릭될 때 or readystate change될 때 굳이 함수 만들지 않아도 됨
			/*
			let hello = function(){
				alert("hello 익명함수");
			}
			hello();
			*/
			
			// 3.
			// window.onload : 웹페이지가 완전히 로드된 후 발생하는 이벤트
			
			// 아래의 두 구문을 브라우저가 실행할 시점에는 infoDiv가 존재하지 않은 상태이므로 ERROR
			// 따라서 이러한 경우에 window.onload를 사용한다
			
			// 3-1. 
			// javascript interpreter 읽는 시점은 위에서부터 아래로 순차적으로 읽기 때문에 null값이 출력된다 
			// alert(document.getElementById("infoDiv"));//null값 출력
			
			// 3-2.
			// Uncaught TypeError: Cannot read properties of null (reading 'innerHTML') 
			// alert(document.getElementById("infoDiv").innerHTML);
			
			// window.onload : 웹페이지가 완전히 로드된 후 발생하는 이벤트
			// onload 이벤트 속성에 hi 라는 일반함수객체를 등록
			/*
			window.onload = hi;
			function hi() {
				alert("hi " + document.getElementById("infoDiv").innerHTML);
			}
			*/
			
			// 4. window onload에 익명함수(anonymous function)로 등록 
			/*
			window.onload = function() {
				alert("hi 익명함수" + document.getElementById("infoDiv").innerHTML);
			}
			*/
			
			// 5. window onload 에 화살표함수(arrow function)로 등록
			window.onload = ()=> {
				alert("hi 화살표함수" + document.getElementById("infoDiv").innerHTML);
			}
			
		</script>
		<br><br>
		<div id="infoDiv">
		익명함수와 화살표함수를 테스트 
		</div>
	</body>
</html>


















