<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<title>jquery basic CSS class를 이용한 셀렉터</title>
	<!-- 특정한 클래스가 적용된 아이만 클릭시 이벤트 발생시켜보는 예제 -->
	<script type="text/javascript">
		$(document).ready(function() {//ready되는 시점에 dom이 모두 로드되면 익명함수의 내용을 수행 
			//1. 현 페이지의 이벤트 등록
			//	 jQuery에서는 css selector를 그대로 지원한다
			$(".ct").click(function() {
				//1-1. return
				//	   confirm은 boolean정보를 return하므로 
				//     return false 하면 이동되지 않는다(즉, 취소를 누르면 이동하지 않음, 역할 수행하지 않음)
				
				//1-2. this 는 현재 이벤트가 발생된 요소 객체, jQuery text()는 요소가 가지고 있는 텍스트 정보를 가리킴
				//	   다수의 이벤트를 select 할 수 있음
				//	   대상 요소의 정보를 가져와보는 예제
				//	   confirm을 띄웠을 때 ~~ 로 이동하시겠습니까? 
				//	   $(this).text() + 로 사용
				return confirm($(this).text() + "이동하시겠습니까?");//일단 현재 상태에서는 확인,취소 버튼 누르기만 하면 모두 넘어가는 상태
			});
		});
	</script>
</head>
<body>
<a href="http://daum.net" class="ct">다음넷으로</a><br>
<a href="http://naver.com">네이버로</a><br>
<a href="http://google.com" class="ct">구글로</a>
<%-- ct class 요소들만 클릭했을 때 confirm으로 확인해서 확인버튼 누르면 이동, 취소 누르면 이동하지 않는다 --%>
</body>
</html>



