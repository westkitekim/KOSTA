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
<title>jquery form 요소 제어</title>
<!-- 
		html5 에 data라는 속성 
	 	화면에는 보이지 않는 tr, td 속성 제어
	 	테이블에서 primary key를 숨김상태로 표시? 히든으로 표시도 되지만 
	 	data라는 태그로 심어놓을 수 있음
	 	
	 	data- 까지 쓰로 column name 개발자 마음대로 명명
-->
<script type="text/javascript">
	$(document).ready(function() {
		//testBtn1: get
		$("#testBtn1").click(function() {
			//id가 member인 요소의 data 속성 정보를 가져와본다
			//span 태그 뿐만 아니라 다른 태그도 가능 
			alert($("#member").data("id"));
			alert($("#member").data("age"));
		});
		
		//testBtn2 : set
		//testBtn2를 클릭 후 testBtn1을 누르면 다른 데이터로 변경된 것을 확인가능
		$("#testBtn2").click(function() {
			//id가 member인 요소의 data 속성 정보를 할당해본다 
			$("#member").data("id", "springking").data("age", 15);
		});//click
		
		//testBtn3 : 
		$("#testBtn3").click(function() {
			//1. customer span에 data 속성을 동적으로 할당해본다
			//$("#customer").data("id", "jQueryking");
			
			//2. JSON 형식으로도 데이터 담을 수 있음
			$("#customer").data("id", "jQueryking").data("detailInfo", {age: 11, name: "황희찬"});
			
		});
		
		//testBtn4
		$("#testBtn4").click(function() {
			alert($("#customer").data("id"));
			let cus = $("#customer").data("detailInfo");
			alert(cus.name + " " + cus.age);
		});
	});//ready
</script>
</head>
<body>
<div class="container">
<span id="member"  data-id="javaking" data-age="13">회원정보</span>
<br><br>
<button type="button" id="testBtn1">data 테스트1</button><br>
<button type="button" id="testBtn2">data 테스트2</button><br>
<button type="button" id="testBtn3">data 테스트3</button><br>
<button type="button" id="testBtn4">data 테스트4</button><br><br>
<span id="customer">고객정보</span>
</div>
</body>
</html>