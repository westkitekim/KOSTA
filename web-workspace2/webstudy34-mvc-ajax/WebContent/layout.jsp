<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet"	href="css/myhome.css" />
</head>
<body>
	<div class="container">
		<div class="row header pt-3">
			<div class="col-sm-12">
				<h4>
					<a href="HomeController.do">MVC Ajax Home</a>
				</h4>
			</div>
		</div>
		<div class="row main">
			<div class="col-sm-9">
				<%--
			메인 화면에 대한 view 정보(url or jsp파일명)를 컨트롤러에서
			동적으로 할당받는다 
	 --%>
				<c:import url="${requestScope.url}" />
			</div>
			<div class="col-sm-3">
				<a href="FindMemberByIdFormController.do">회원검색</a>
				<br> 
				<a href="RegisterFormController.do">회원가입</a>
			</div>
		</div>
		<div class="row footer">
			<div class="col-sm-12">경기도 성남시 분당구 성남대로 34 6층 (구미동, 하나프라자빌딩) 
				대표번호 : 031-606-9311 Copyright © 2020 KOSTA ALL RIGHTS RESERVED</div>
		</div>
	</div>
</body>
</html>

















