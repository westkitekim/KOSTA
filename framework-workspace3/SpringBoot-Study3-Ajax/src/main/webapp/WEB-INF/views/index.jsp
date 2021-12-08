<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script><!-- jQuery 라이브러리 사용 -->
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<title>Home</title>
	</head>
	<body>
		<div class="container">
			<h3>SpringBoot Ajax Study</h3>
			
			<script type="text/javascript">
				$(function() {
					$("#AjaxBtn1").click(function() {
						$.ajax({
							type: "get",
							url: "testAjax1",
							data: "userId=javaking",
							success: function(result) {
								alert(result);
							}
						});//ajax
					});//AjaxBtn1 click
					
					$("#AjaxBtn2").click(function() {
						$.ajax({
							type: "get",
							url: "testAjax2",
							dataType: "json",
							data: "customerId=javaking",
							success: function(customer) {
								alert(customer.id + " " + customer.name + " " + customer.address);
							}
						});//ajax
					});//AjaxBtn2 click
					
					$("#AjaxBtn3").click(function() {
						$.ajax({
							type: "get",
							url: "testAjax3",
							dataType: "json",
							data: "id=javaking",
							success: function(result) {
								for(let i = 0; i < result.length; i++) {
									alert(result[i]);
								}
							}
						});//ajax
					});//AjaxBtn3 click
					
					$("#AjaxBtn4").click(function() {
						$.ajax({
							type: "get",
							url: "testAjax4",
							dataType: "json",
							data: "id=javaking",
							success: function(result) {
								for(let i = 0; i < result.length; i++) {
									alert(result[i].name + " " + result[i].address);
								}
							}
						});//ajax
					});//AjaxBtn4 click
					
					$("#AjaxBtn5").click(function() {
						$.ajax({
							type: "get",
							url: "testAjax5",
							dataType: "json",
							data: "id=javaking",
							success: function(result) {//key값으로 데이터 가져옴
								alert(result.CAR_NO + " " + result.MODEL);
							}
						});//ajax
					});//AjaxBtn5 click
					
					//data는 파라미터로 요청할 때 
					//일반문자열은 dataType(응답받을 때 받는 데이터타입, 응답받을 때 JSON은 parse해주기 때문에 )을 명시하지 않는다
					$("#AjaxBtn6").click(function() {
						$.ajax({
							type: "get",
							url: "testAjax6",
							data: "name=javaking&address=판교",
							success: function(result) {
								alert(result);
							}
						});//ajax
					});//AjaxBtn6 click
					
				});//ready
			</script>
			
			<%-- 1. 문자열 데이터로 응답받는 Ajax 테스트 --%>
			<button type="button" id="AjaxBtn1">AjaxTest1</button><br>
			<%-- 2. JSONObject(DTO or VO)로 응답받는 Ajax 테스트 --%>
			<button type="button" id="AjaxBtn2">AjaxTest2</button><br>
			<%-- 3. JSONArray로 응답받는 Ajax 테스트 --%>
			<button type="button" id="AjaxBtn3">AjaxTest3</button><br>
			<%-- 4. JSONArray(내부에 JSONObject)로 응답받는 Ajax 테스트 --%>
			<button type="button" id="AjaxBtn4">AjaxTest4</button><br>
			<%-- 5. JSONObject(내부에 Map)로 응답받는 Ajax 테스트 --%>
			<button type="button" id="AjaxBtn5">AjaxTest5</button><br>
			<%-- 6. 한글로 된 일반문자열 데이터 응답받는 테스트 --%>
			<button type="button" id="AjaxBtn6">AjaxTest6</button><br>
		</div>
	</body>
</html>












