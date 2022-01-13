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
<title>step28-serialize</title>
<!-- querystring 자동생성 함수 -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#test").click(function() {
			alert($("#f1").serialize());
		});//click
	});//ready
</script>
</head>
<body>
<div class="container">
<%--
		ajax 방식으로 전송시 
		data:"name=장기하&tool=메모장&menu=맥주&menu=피자  와 같은 query string 을 만들어 
		전송해야 한다 
		위와 같은 form data 의 query string을 간편하게 만들수 있는 jquery의 serialize() 함수를 테스트해본다
		
		전달해야하는 데이터가 많은경우 querystring만드는 것이 번거롭기 때문 
 --%>
<form id="f1" action="front">
  이름 :<input type="text" name="name">
   <input type="hidden"
   name="command" value="register"> 
   <select name="tool">
   <option value="notepad">메모장</option>
   <option value="editplus">에디트플러스</option>
   <option value="eclipse">이클립스</option>
  </select> 
  <br>
  <input type="checkbox" name="menu" value="beer">맥주<br>
   <input type="checkbox" name="menu" value="pizza">피자<br> 
   <input type="button" value="test" id="test">
 </form>
</div>
</body>
</html>