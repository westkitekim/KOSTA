<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<title>jquery 기본</title>
		<script type="text/javascript">
/*
	★★★★★★★★★★★★★★무조건 암기★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
	★ window load 와 jquery document ready 의 차이점 											   
	★ -> window load 는 img , 동영상과 같은 요소들이 모두 load 된 후에 호출 							   
	★ -> document ready 는 DOM 이 load 되는 시점에 호출 
	★   ( 이미지나 동영상 같은 자원들이 로드되지 않아도  document 객체가 준비되면 실행)
	★   jquery document ready 가 되는 시점에 익명함수 내에 현 페이지에서 동작될 이벤트에 대한 동작을 바인딩(등록)
	★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
*/
			
			//1. vanila javascript 방식 
			//바닐라자바스크립트에서 사용되는 window.load -- 현재 창이 로드되면
			/* window.onload = function() {
				alert("window load");//페이지의 모든 자원(요소)이 로드되면 뜸(초기작업 필요시 윈도우 뜰 때 작동하려고 할 때 사용, 단 자원이 )
			}  */
			
			//2. jQuery방식(거의 안씀) - document 가 준비되면 내부적으로 동작시킴 (완전히 로드되지 않아도)
			//자동완성시 ready선택 - 매개변수 없는 것으로 조금 번거롭게 연습, 매개변수 있으면 편함(즉, 익명함수까지 자동생성)
			//어차피 ready 되면 동작될 함수이기 때문에 인자값으로 익명함수를 넣어준다 
			/* jQuery(document).ready(function() {
				alert("jquery document ready");
				
			}); */
			
			//3. jQuery와 동일한 표현 $
			//document에서 jQuery 표현으로 감싸면 jQuery의 함수가 나온다 - jQuery화
			/* $(document).ready(hello);//인자값에 함수객체 등록, 콜백처럼 작동
			function hello() {
				alert("hello jquery");
			} */
			
			//4. 아래처럼 익명함수로 주로 사용한다 
			//위처럼 별도의 함수를 만드나, 함수를 넣는 것이나 똑같기 때문에 익명함수로 주로 사용
			$(document).ready(function() {//DOM이 로드되면 이 익명함수가 실행
				//alert("현 페이지의 이벤트 핸들러를 등록");//이벤트 처리를 등록한다(담당자 등록)
				$("a").click(function() {//a tag가 cllick 될 때 실행될 익명함수(핸들러)를 등록
					//<a>태그가 클릭되면 ~~ 익명함수를 동작하라 -> a태그로 된 test1~3 모두 클릭하면 해당 alert함수 작동
					alert("링크 클릭했네용");
				});
				
				//4-2. span 에 대한 이벤트 핸들러(이벤트가 발생될 때 동작되는 함수)를 등록 
				$("span").click(function() {
					alert("span 클릭했네");
				});
			});
		</script>
	</head>
	<body>
		jQuery Basic
		<ul>
			<li><a href="#">test1</a></li>
			<li><a href="#">test2</a></li>
			<li><a href="#">test3</a></li>
		</ul>
		<span>클릭해봐1</span><br>
		<span>클릭해봐2</span>
	</body>
</html>







