<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>검색결과실패</title>
	</head>
	<body>
		<script type="text/javascript">
			alert("${param.itemNo}번 아이템이 존재하지 않습니다");
			location.href = "home.do";
		</script>
	</body>
</html>