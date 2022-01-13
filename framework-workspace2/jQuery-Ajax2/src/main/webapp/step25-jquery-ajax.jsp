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
<title>step25-jquery-ajax</title>
<!-- jQuery Ajax 연동 테스트 -->
<script type="text/javascript">
//	CountServlet 참고
	$(document).ready(function() {
		$("#ajaxBtn").click(function() {
			//ajax 연동
			$.ajax({//ajax()함수 콜 할때 JSON으로 부른다(call)
				type: "get",
				url: "CountServlet",
				data: "userId=javaking",
				success: function(result) {//result 변수명은 아무거나 상관없음
					//alert(result);
					
					$("#resultView").text(result);
				}
			});//ajax는 매개변수 인자값으로 JSON을 받는다 
		});//ajaxBtn click
	});//ready
</script>
</head>
<body>
<div class="container">
<input type="button" id="ajaxBtn" value="ajax연동테스트">
<span id="resultView"></span>
</div>
</body>
</html>









