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
<title>jquery toggle</title>
<%--   
	   정보 더보기와 접기가 번갈아 가면서 표현된다 
	   detailInfo의 정보가 보이는 상태이면 접기가 표현되고위
	   detailInfo의 정보가 보이지 않는 상태이면 정보 더보기가 표현된다 
	   toggleSpan 을 클릭하면 아래 detailInfo가 보이는 상태와 
	   보이지 않는 상태로 번갈아 가면서 수행한다 	
--%>
<style type="text/css">
	#detailInfo{
		display: none;
	}
	#toggleSpan{
		background-color: yellow;
	}
</style>
<script type="text/javascript">
//document object model 이 로드 되면 동작되는 이벤트

	$(document).ready(function() {//DOM이 로드되면 실행될 익명함수 - callback 함수(이벤트 발생시 호출되는 함수)
		//이 익명함수는 현 페이지의 행위에 대한 이벤트 핸들러(콜백함수)를 등록
		//document.ready는 여러 개 나와도 상관없음
		//$는 jquery 표시
		$("#toggleSpan").click(function() {//toggle 클릭시 발생되는 이벤트
			$("#detailInfo").slideToggle(1000, function() {
				//alert($(this).css("display"));//data가 보이는 상태: block, 보이지 않는 상태는 none
				//alert($(this).css("display") == "none");//보이지 않는 상태이면 true
				if($(this).css("display") == "none") {
					$("#toggleSpan").text("정보 더보기");
				} else {
					$("#toggleSpan").text("접기");
				}
			});//slideToggle
		});//click
	});//ready
</script>
</head>
<body>
<div class="container">
<span id="toggleSpan">정보 더보기</span>
<br><br>
<p id="detailInfo">
본명

이지은(李知恩)[1]<br><br>

출생

1993년 5월 16일, 서울특별시 성동구 송정동[2] / 24세<br><br>

국적

대한민국파일:대한민국 국기.png<br><br>

본관

전주 이씨[3]<br><br>

신체

161.7cm, 44kg[4][5], A형<br><br>

가족

부모님, 남동생<br><br>
</p>

</div>
</body>
</html>