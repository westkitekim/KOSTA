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
<title>step18-append-after</title>

<style type="text/css">
	#span1{
		background-color: yellow;
	}
	#span2{
		background-color: lime;
	}
</style>
	<script type="text/javascript">
		$(function() {
 			$("#testBtn").click(function() {
				//방법1.
				$("#span1").append("가수");//append는 대상요소의 마지막 하위(자식) 요소로 추가, 따라서 css 적용. ex. <span>아이유가수</span>
				$("#span2").after("가수");//after는 대상요소의 형제요소로 추가되기 때문에 css 적용X. ex.<span>이효리</span>가수
				$("a[href*=daum]").append("go");//daum이 포함된 것은 모두 해당
				$("a[href*=google]").after("go");
				
			});
		});
	</script>
</head>
<body>
<div class="container">
<input type="button" id="testBtn" value="테스트"><br><br>
<span id="span1">아이유</span><hr>
<span id="span2">이효리</span><hr>
<a href="http://www.daum.net">다음넷으로</a><hr>
<a href="http://google.com">구글로</a><hr>
<a href="http://daum.net">다음넷으로</a><hr>
</div>
</body>
</html>











