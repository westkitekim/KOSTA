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
<title>step22-next-prev.jsp</title>
<!-- 
		1. next() 
		span 클릭하면 옆 span 태그에 출력해보기
		화면상에서 정보를 search하거나 여러 정보를 찾아낼 때 사용
		
		infoDiv 안에 span요소가 있는 것을 유념할 것 
		
		2. prev()
		버튼 클릭시 자신의 버튼의 텍스트 뽑기
 -->
<script type="text/javascript">
	$(document).ready(function() {
		//1. infoDiv id의 class desc 요소를 클릭하면 자신의 요소 다음 요소에 자신의 텍스트 정보를 할당 
		//
		$("#infoDiv .desc").click(function() {
			$(this).next().text($(this).text());//내 속에 내가 많아..조성모 가시나무여..? 
		});
		
		//2. next() : 
		$("#deleteAllBtn").click(function() {
			$("#infoDiv .desc").next().empty();//desc selector 3개 모두 해당
			$("#infoDiv .desc").next().text("");//desc selector 3개 모두 해당
		});
		
		//3. prev() : 이전요소
		//br도, span도 하나의 태그 
		$("#prevBtn").click(function() {
			let info = $(this).prev().prev().prev().text();
			alert(info);
		});
	});
</script>
</head>
<body>
<div class="container">
<div id="infoDiv">
	<span class="desc">아이유</span><span></span><br>
	<span class="desc">손흥민</span><span></span><br>
	<span class="desc">이강인</span><span></span><br>
	<br><br>
	<input type="button" value="추가한 데이터를 지움" id="deleteAllBtn">
	<br><br>
	<span>한사랑산악회</span>
	<br><font>우하하</font>
	<button type="button" id="prevBtn">prevTest</button>
</div>
</div>
</body>
</html>





