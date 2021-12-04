<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step1-syn.jsp</title>
</head>
<body>
<%--
		  웹프로그래밍에 있어서 비동기 Ajax 통신이란(기간을 함께한다: 서버가 응답하기 전 내가 실행할 수 없는 것은 동기적인 방식)
  		  필요한 데이터만 응답받는 방식이다.(요청을 해놓고 내 할일을 한다. 나중에 호출되는 콜백, ajax 안에서도 데이터를 동기적인 방식으로 잡아줄 수 있음)
          사용자는 페이지 변경없이 필요한 데이터만 응답받음으로써
          응답여부와 관계없이 작업을 지속할 수 있다   
          step1-syn.jsp ( 동기적 통신 방식 ) , step2-asyn.jsp ( 비동기 ajax 통신 방식 ) 을 비교 
          
          노란색배경의 페이지가 나오면 동기적인 방식으로 페이지가 전환된 것
 --%>
 <form action="SynServlet">
 	<input type="text" name="userInfo">
 	<input type="submit" value="동기적 방식테스트">
 </form>
 <hr>
 <form>
 <textarea rows="100" cols="100"></textarea>
 </form>
</body>
</html>










