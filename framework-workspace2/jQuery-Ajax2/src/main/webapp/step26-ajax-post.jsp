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
<title>step26-ajax-post</title>
<!-- post방식 연습예제, 서버 다녀와서 아래에 comment 출력, CommentServlet  -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#ajaxBtn").click(function() {
			let commentInfo = $("#comment").val();
			if(commentInfo == "") {
				alert("코멘트를 입력하세요");
				return;//함수 실행을 마친다
			} 
			//required는 submit했을 때만 수행됨
			//alert(1);//얘가 실행되지 않는다는 것은 상단의 return이 동작되었다는 뜻
			
			//사용자가 글을 입력했으면 ajax 통신을 한다 
			$.ajax({
				type: "post",
				url: "CommentServlet",
				data: "comment=" + commentInfo,
				success: function(result) {
					$("#resultView").html("<pre>" + result + "</pre>");
					//$("#comment").val("");
					$("#comment").empty();
				}
			});//ajax
		});//click
	});//ready
</script>
</head>
<body>
<div class="container">
<textarea rows="10" cols="20" id="comment"></textarea>
<br>
<input type="button" id="ajaxBtn" value="ajax연동테스트">
<hr>
<div id="resultView"></div>
</div>
</body>
</html>











