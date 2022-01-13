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
<title>jquery mouse enter leave</title>
<!-- 마우스를 올리면 이미지가 보이는 예제 -->
<style type="text/css">
	#friendImg{
		display: none;
	}
	span{
		background-color: yellow;
		font-size: 25px;
	}
</style>
<script type="text/javascript">


/*	표현1. 아래와 동일한 표현
	jQuery(function() {
		alert("test");
	})
*/

/*	표현2. 
	$(document).ready(function() {
		alert("test2");
	});
*/

	//위 두 표현과 동일한 의미 jquery 3.n부텆 지원
	$(function() {
		//alert("test3");
		//infoSpan id의 span 영역에 마우스가 ★진입하면★ friendImg id의 이미지를 보여준다 
		//								 mouseenter(handler)		   show()
		/*
		$("#infoSpan").mouseenter(function() {
			$("#friendImg").show(3000);
		});
		*/
		//infoSpan id의 span 영역에 마우스가 ★벗어나면★ friendImg id의 이미지를 감춘다
		//								 mouseleave(handler)		   hide()
		/*
		$("#infoSpan").mouseleave(function() {
			$("#friendImg").hide(3000);
		});
		*/
		
		//hover 함수로 위의 두 가지 기능을 한 번에 표현할 수 있다, 2번째 hover로 선택 
		$("#infoSpan").hover(function() {
			$("#friendImg").show(3000);
		}, function() {
			$("#friendImg").hide(3000);
		})
	});
	

</script>
</head>
<body>
<div class="container">
	<span id="infoSpan">마우스를 올려보세요</span><br>
	<img src="아이유.jpg" class="img-circle" id="friendImg" width="304" height="236">
</div>
</body>
</html>









