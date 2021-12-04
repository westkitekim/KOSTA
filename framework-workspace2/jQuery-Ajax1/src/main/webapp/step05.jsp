<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>jquery selector 연습</title>
<script type="text/javascript">
	$(document).ready(function() {
		//문제1
		$("#btn2").click(function() {
			alert($(this).val() + " 떳음?");//val() : 입력양식의 value 를 반환
		});	
		
		//문제2
		/* $("#btn3").click(function() {
			alert($(this).val() + "클릭");
		}); */
		
		//문제2-1, span 영역 찾기
		$("#btn3").click(function() {
			//방법1. innerHTML과 동일한 html()
			//jQuery html() : innerHTML 역할, HTML Tag를 반영
			//$("#resultView").html("<font color=purple>" + $(this).val() + "</font>");//html 코드까지 쓰겠다 할 때 사용
			
			//방법2. text() 사용
			//jQuery text() : 오직 text로만 반영
			$("#resultView").text("<font color=purple>" + $(this).val() + "</font>");
		});
	});
</script>
</head>
<body>
<!-- 
		요구사항(문제)
		1. btn2 id 버튼을 클릭했을 때만 alert으로 클릭 
		2. btn3 id 버튼을 클릭했을 때 alert으로 자신의 value를 띄운다
		   2-1. 이벤트 처리를 변경해서 alert 대신 
		   		resultView 아이디의 span 영역에 자신의 value를 출력해본다. 
 -->
<input type="button" value="테스트1"><br>
<input type="button" value="테스트2" id="btn2"><br>
<input type="button" value="테스트3" id="btn3"><br>
<span id="resultView"></span>
</body>
</html>



















