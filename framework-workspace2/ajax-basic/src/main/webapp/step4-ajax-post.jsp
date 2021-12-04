<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax post 방식 테스트</title>
<script type="text/javascript">
	function startAjax(){		
		let postNoValue=document.getElementById("postNo").value;
		if(postNoValue==""){
			alert("게시물번호를 입력하세요");
			return; 
		}
		let xhr=new XMLHttpRequest();
		//readyState 상태값이 변경될때 실행될 함수(callback 함수)를 등록 
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				document.getElementById("deleteResult").innerHTML = xhr.responseText;
			}
		};//callback 함수를 등록 (이벤트 발생하면 호출되는 함수(onreadystate) : 콜백함수 ))		
		xhr.open("post", "AjaxPostServlet");
		//ajax post 방식일때 content-type을 지정해야 한다 
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xhr.send("pno="+postNoValue); // 예) xhr.send("nick="+nick+"&id="+id);
	}
</script>
</head>
<body>
<input type="number" id="postNo" placeholder="게시물번호">
<button type="button" onclick="startAjax()">삭제</button>
<span id="deleteResult"></span>
<%--
		1. 게시물번호를 입력하지 않고 삭제 버튼을 누르면 alert으로 게시물 번호를 입력하세요 후 ajax 통신은 하지 않고 함수 종료한다
		2. 게시물번호가 있다면 ajax post 방식으로 요청하고 요청시 게시물번호를 send 메서드에 query string 방식으로 전달한다 
		3. callback 함수에서 deleteResult span에 서버가 응답한 정보를 보여준다 
 --%>
</body>
</html>

















