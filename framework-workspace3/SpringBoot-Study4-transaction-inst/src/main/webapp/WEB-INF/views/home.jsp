<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>tx home</title>
</head>
<body>
<div class="container">
<h3>Spring Transaction</h3>
회원수 ${memberCount}명 <br><br>
<form action="findMemberById">
<input type="text" name="id" placeholder="ID" required="required">
<input type="submit" value="회원검색">
</form>
<br><br>
<form action="findPointById">
<input type="text" name="id" placeholder="ID" required="required">
<input type="submit" value="포인트검색">
</form>
<%--
		PointController 		PointMapper --> PointMapper.xml  <--> DB 
		findPointById() 
			|
			find-point-result.jsp  ( 검색결과 있으면 PointVO 정보 제공 , 없으면 비워둔다 ) 
 --%>
 <hr>
 <%-- 
 		▣ Transaction 연습
 			프리젠테이션 계층				비즈니스 계층 				영속성 계층
 			MemberController				MemberService			MemberMapper	
 			PointController 				MemberServiceImpl		PointMapper 
 			
 		복잡도가 많은 경우 비즈니스 계층을 두고 보편적으로 수행, insert, delete, update 되는 경우들
 		회원가입 될 때 포인트도 적립되는 경우(비즈니스 계층에서 수행, 비밀번호 암호화도 비즈니스에서 수행)
  --%>
  <form method="post" action="register">
  	아이디 <input type="text" name="id"><br>
  	패스워드 <input type="password" name="password"><br>
  	이름 <input type="text" name="name"><br>
  	주소 <input type="text" name="address"><br>
  	포인트 <input type="text" name="point"><br>
  	포인트타입 <input type="text" name="pointType"><br>
  	<input type="submit" value="등록">
  </form>
 
</div>
</body>
</html>







