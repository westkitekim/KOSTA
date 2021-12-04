<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>jquery table</title>
<!-- tr, td 테스트 -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#testBtn").click(function() {
			//alert($(this).val());
			
			//1. 
			//테이블 중에 tbody 요소에 특정한 테이블 안에 tbody 요소의 tr에 접근하고 싶을 때(특정 행)
			//id가 friend인 tbody의 하위 tr들을 선택
			//$("#friend tr").css("background", "yellow");
			//alert($("#friend").html());
			
			//2. tr 선택
			//html로 하면 <td>태그 출력, text는 출력X
			//friend tr과 friend 차이 - <tr> 유무
			//즉, tbody의 id인 friend의 하위 tr 중 세 번째 tr을 선택
			//$("#friend tr:eq(2)").css("background", "yellow");
			
			//3. td 중 "당"이라는 문자열이 포함된 td만 선택 
			$("#friend td:contains(당)").css("background", "purple");//나중에 좌석정보 등에 활용???
		});//테스트버튼 click
		
		//4. friend id tbody의 하위 td가 클릭되었을 때 자신의 텍스트가 alert으로 출력
		//selector : #freind td
		$("#friend td").click(function() {
			alert($(this).text());
			
			//5. 클릭된 td 요소의 상위 tr로 이동해서 그 tr이 가진 하위 요소 첫 번째 td를 select 하여 text를 출력 
			//parent()사용, eq(0) 0번 째 인덱스
			let info = $(this).parent().children().eq(0).text();
			alert(info);
		});//click
		
	});//ready
</script>
</head>
<body>
	<div class="container">
		<input type="button" value="테스트" id="testBtn">
		<p>jquery로 table 제어</p>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>이름</th>
					<th>나이</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody id="friend">
				<tr>
					<td>아이유</td>
					<td>28</td>
					<td>동탄</td>
				</tr>
				<tr>
					<td>김연아</td>
					<td>24</td>
					<td>사당</td>
				</tr>
				<tr>
					<td>김태리</td>
					<td>27</td>
					<td>분당</td>
				</tr>
			</tbody>
		</table>

	</div>
</body>
</html>