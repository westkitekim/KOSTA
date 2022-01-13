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
<title>step19-jquery-event</title>
<!-- 이벤트 전파, 이벤트 버블링 막기 => stopPropagation() -->
<style type="text/css">
	.pro{
		background-color: lime;
	}
	.inner{
		background-color: orange;
	}
</style>
	<script type="text/javascript">
		$(function() {
			$(".pro").click(function(event) {
				//대상 클래스 안에 클래스가 또 존재하는 경우
				//이벤트 버블링 : 이벤트가 전파되는 현상, pro inner class 영역을 클릭했을 때 이벤트가 전파되어 alert이 두 번 발생
				alert($(this).html());
				event.stopPropagation();//이벤트가 전파되는 이벤트 버블링 현상을 막는다, 해당 코드가 없다면 pro inner class 수행시 2개의 코드가 수행됨(pro, pro inner)
			});
		});
	</script>
</head>
<body>
<div class="container">
	<div class="pro">
		pro class div 영역 <br><br>
		<div class="pro inner">
			pro inner class div 영역 
		</div>
	</div>
</div>
</body>
</html>



















