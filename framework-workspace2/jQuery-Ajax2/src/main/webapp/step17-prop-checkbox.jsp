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
<title>step17-prop-checkbox</title>
<!-- 전체선택을 클릭하면 나머지가 모두 선택되도록 만드는 예제 -->
</head>
<body>
<div class="container">
	<script type="text/javascript">
		$(function() {
			//allCheck 체크박스의 체크상태와 menu 체크박스들의 체크상태를 일치시킨다	
			//allCheck 체크박스를 체크하면 menu 체크박스들이 모두 체크되고, 체크해제하면 모두 체크해제된다
			$("#allCheck").change(function() {
				//alert($(this).prop("checked"));//checked 속성 값 확인
				
				//id가 menuForm인 checkbox 중 menu name checkbox들을 select 해서 모두 prop("checked", allCheck의 체크상태);
				$("#menuForm :checkbox[name=menu]").prop("checked", $(this).prop("checked"));
			});
		});
	</script>
	
<form action="test.jsp" id="menuForm">
<input type="checkbox" id="allCheck">전체선택<br>
<input type="checkbox" name="menu" value="삼겹살">삼겹살<br>
<input type="checkbox" name="menu" value="갈비살">갈비살<br>
<input type="checkbox" name="menu" value="꽃등심">꽃등심<br>
<input type="submit" value="주문">
</form>

</div>
</body>
</html>



















