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
<title>step21-select-option</title>
<script type="text/javascript">
	$(function() {
		//JavaScript Array
		let arr = ["손흥민", "이강인", "황의조"];
		$("#createOption").click(function() {
			//생성시 여러번 누르면 중복되는 현상 방지 
			$("#friend").empty();
			for(let i = 0; i < arr.length; i++) {
				//누적해서 만들어도 되고 
				$("#friend").append("<option value=" + arr[i] + ">" + arr[i] + "</option>");
			}
		});//click
		
		//자식요소를 삭제 : empty()
		$("#deleteOption").click(function() {
			$("#friend").empty();
		});
		
		//자바스크립트에서도 자료구조를 지원하는 것을 확인해보는 메서드
		//참고) Set은 중복불허인 구조체 
		$("#setBtn").click(function() {
			let set = new Set();
			set.add("손흥민");
			set.add("황의조");
			set.add("황의조");
			set.add("손흥민");
			alert(set.size);
			//String data in set
			for(let data of set){//반복문 set의 내용을 하나씩 꺼냄 in
				alert(data);
			}
		});
	});
</script>
</head>
<body>
<div class="container">
<input type="button" value="셀렉트옵션생성" id="createOption">
<input type="button" value="셀렉트옵션삭제" id="deleteOption">
<select id="friend"></select>
<hr>
<input type="button" value="set-test" id="setBtn"><!-- 자료구조 지원참고 -->
</div>
</body>
</html>
















