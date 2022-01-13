<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>step24-json</title>
<!-- Ajax 가기 전 연습예제 -->
<script type="text/javascript">
	//JSON : JavaScript Object Notation 자바스크립트 객체 표기법(순수 자바스크립트 스타일로 가는 방법)
	//Java 의 map과 유사
	function testJSONObj() {
		let person = {name: "아이유", addr: "종로", age: 28};//JavaScript Object
		alert(person.name + " " + person.addr + " " + person.age);
	}
	
	//JavaScript Array
	function testJSONArray() {
		let pa = ["ioc", "di", "aop", "springmvc"];//JavaScript Array
		for(let i = 0; i < pa.length; i++) {
			alert(pa[i]);
		}
	}
</script>
</head>
<body>
<div class="container">
	<input type="button" value="testJSON" onclick="testJSONObj()">
	<input type="button" value="testJSONArray" onclick="testJSONArray()">
</div>
</body>
</html>








