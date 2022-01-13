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
<title>jquery table hover</title>
<!-- 좌석정보 활용!!!!! -->
<script type="text/javascript">
	/* $(document).ready(function() {
		
	}); */
	
	$(function() {
		$("#membody td").hover(function() {
			$(this).css("background", "yellow");
			$("#memInfo").text($(this).text());
		}, function() {
			$(this).css("background", "white");
			$("#memInfo").text("");//벗어나면 text 지워줌
		});
	});//ready
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<!-- offset-2 : 총 12 중 2 비중만큼 오른쪽으로 이동 -->
			<div class="col-sm-8 col-sm-offset-2">
				<table class="table  table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>NAME</th>
							<th>ADDR</th>
						</tr>
					</thead>
					<tbody id="membody">
						<tr>
							<td>java</td>
							<td>아이유</td>
							<td>하와이</td>
						</tr>
						<tr>
							<td>jquery</td>
							<td>김태리</td>
							<td>울릉도</td>
						</tr>
						<tr>
							<td>ajax</td>
							<td>강동원</td>
							<td>백령도</td>
						</tr>
					</tbody>
				</table>
				<span id="memInfo"></span>
				
			</div>
		</div>
	</div>
</body>
</html>











