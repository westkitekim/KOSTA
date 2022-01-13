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
<title>step27-ajax-json</title>
<!-- JSONObject와 JSON Array test -->
<script type="text/javascript">
	$(function() {
		$("#jsonObjBtn").click(function() {
			$.ajax({//속성은 대소문자 구문하므로 주의할 것 
				type: "get",
				url: "JSONServlet",
				dataType: "json",//dataType이 없으면 문자열로 인식
				data: "command=getMemberInfo",
				success: function(result) {//매개변수를 선언해야 결과를 받을 수 있음, 변수명은 상관없음
					alert(result.name + " " + result.age);						
				}
			});//ajax
		});//click
		
		$("#jsonArrayBtn").click(function() {
			//ajax code 복붙, 다른 속성만 변경
			$.ajax({//속성은 대소문자 구문하므로 주의할 것 
				type: "get",
				dataType: "json",//dataType이 없으면 문자열로 인식
				url: "JSONServlet",
				data: "command=getMemberList",
				success: function(result) {//매개변수를 선언해야 결과를 받을 수 있음, 변수명은 상관없음
					//let data in result - 숫자 출력
					//let data of result -> 동일한 반복문
					for(let i = 0; i < result.length; i++) {
						alert(result[i]);
					}						
				}
			});//ajax
		});
	});//ready
</script>
</head>
<body>
<div class="container">
<button type="button" id="jsonObjBtn">JSONObject 테스트</button><br>
<button type="button" id="jsonArrayBtn">JSONArray 테스트</button><br>
</div>
</body>
</html>









