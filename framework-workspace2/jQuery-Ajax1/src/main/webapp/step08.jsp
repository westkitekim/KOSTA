<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>jquery show hide 함수</title>
<script type="text/javascript">
	$(document).ready(function(){
		//1. 예제
		//https://api.jquery.com/show/ 참고
		//$("#imgView").hide();//사진 감추기
		
		$("#showBtn").hide();//첫 화면에 사진보기 버튼 없애기
		
		$("#showBtn").click(function() {
			$("#imgView").show(3000, function() {//show(시간, 이벤트처리 후 후속작업 callback function 형태)
				$("#showBtn").hide();
				$("#hideBtn").show();
			});//시간을 설정하면 애니메이션효과
		});
		
		//https://api.jquery.com/show/ 참고
		$("#hideBtn").click(function() {
			$("#imgView").hide(3000, function() {
				$("#showBtn").show();
				$("#hideBtn").hide();
				
			});
		});
	});
</script>
</head>
<body>
<img src="록키.jpg" id="imgView">
<input type="button" value="사진보기" id="showBtn">
<input type="button" value="사진감추기" id="hideBtn">
</body>
</html>










