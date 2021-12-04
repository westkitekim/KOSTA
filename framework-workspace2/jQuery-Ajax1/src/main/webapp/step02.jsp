<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>jquery basic</title>
<!-- jquery ready 검색 -> https://api.jquery.com/ready/ -->
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {//현 페이지의 이벤트 핸들러를 등록
			//버튼 제어
			//1. jQuery selector 사용
			// :button 의 뜻 - input type="button" 을 select한다
			//button태그가 아닌 input 태그이기 때문에 동작하지 않음
			//-> selector 사용
			$(":button").click(function() {//click하면 동작
				alert("버튼 클릭");
			});
		});
	</script>
<input type="button" value="버튼1"><br>
<input type="button" value="버튼2"><br>
<input type="button" value="버튼3"><br>
<input type="submit" value="전송버튼"><br>
</body>
</html>




