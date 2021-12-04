<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<title>jquery basic - 위치에 대한 dom 제어</title>
	
	</head>
	<body>
		<script type="text/javascript">
			//1. 이 시점에서는 testSpan id의 span이 로드되어 있지 않기 때문에 null
			alert(document.getElementById("testSpan"));//null 의 alert 출력()
		</script>
		
		<script type="text/javascript">
			//3. 이 시점은 위치에 상관없이 사용하고 싶다면 document.ready로 사용
			//그게 아니라면 2번과 같이 위치에 따라 마지막에 작성해야 한다
			$(document).ready(function() {
				alert(document.getElementById("testSpan"));
			});
		</script>
		
		<span id="testSpan">즐공</span>

		<script type="text/javascript">
			//2. 이 시점에서는 testSpan id의 span이 로드되어 있기 때문에 [object HTMLSpanElement]
			alert(document.getElementById("testSpan"));//null 의 alert 출력()
		</script>
	</body>
</html>










