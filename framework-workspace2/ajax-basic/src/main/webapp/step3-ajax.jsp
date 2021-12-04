<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax test</title>
<script type="text/javascript">
	let xhr;
	function startAjax(){
		let idComp=document.getElementById("userId");
		if(idComp.value==""){
			alert("아이디를 입력하세요!");
			return; //함수 실행을 종료한다 
		}
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState == 4 && xhr.status == 200) {
				document.getElementById("memberInfo").innerHTML = xhr.responseText;
			} else if(xhr.readyState < 4) {//4 미만은 대기상태 - 로딩중
				document.getElementById("memberInfo").innerHTML = "요청처리중..";
			}
		}
		xhr.open("get", "FindMemberAjaxServlet?userId="+idComp.value);
		xhr.send();//send() 가 호출될 때 요청이 완료 
	}
</script>
</head>
<body>
<%-- xhr.open("get",url?name=value);
	   xhr.send(null);
 --%>
<input type="text" id="userId" placeholder="사용자아이디">
<input type="button" value="ajax방식 조회" onclick="startAjax()">
<span id="memberInfo"></span>
</body>
</html>






