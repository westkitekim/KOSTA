<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>jquery 셀렉터 연습</title>
<script type="text/javascript">
	//
	$(document).ready(function(){
		$("#testBtn").click(function() {
			alert($(this).val());
		});
		
		$(".student, .teacher").click(function() {
			$("#result").text($(this).text());//자신의 text 출력
		});
	});
</script>
</head>
<body>
<input type="button" value="셀렉터연습" id="testBtn">
<%-- id testBtn 버튼 클릭되면 자신의 value가 alert으로 출력되게 한다  --%>
<div class="student">아이유</div>
<div>장기하</div>
<div class="student">록키</div>
<div class="teacher">정우성</div>
<div class="teacher">김태희</div>
<hr>
<div id="result"></div>
<%-- 
		class 가 student or teacher 인 대상 요소들이 클릭되면 result id div 에 자신의 text가 출력된다
		$("셀렉터, 셀렉터") - 다수의 대상을 셀렉터 할 때의 사용법
--%>
</body>
</html>












