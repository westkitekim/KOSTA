<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>  

<div class="row">
<div class="col-sm-8 offset-sm-2">
<form action="" method="post" id="registerForm">
<input type="text" name="id" id="memberId" required="required" placeholder="아이디" onkeyup="checkId()">
<span id="checkResult"></span><br>
<input type="password" name="password" required="required" placeholder="패스워드"><br>
<input type="text" name="name" required="required" placeholder="이름"><br>
<input type="text" name="address" required="required" placeholder="주소"><br>
<input type="submit" value="회원가입">
</form>
<%-- memberId id text 입력양식에 keyup 이벤트를 이용해서 
아이디 중복확인을 ajax 방식으로 처리할 수 있다  --%>


<script type="text/javascript">
	function checkId() {
		//onkeyup : 키보드를 눌렀다 뗄 때 발생하는 속성
		//alert("키");
		
		//아이디 입력텍스트에 기술한 정보를 Span 영역에 표현해본다
		//span 영역은 innerHTML
		document.getElementById("checkResult").innerHTML = document.getElementById("memberId").value;
		
		//아이디 4자 이상 10자 이하여야 합니다 출력 
		// 4자~ 10자 일때만 ajax로 넘길 것
		
		//ajax 와 onkeyup을 이용한 중복확인은 프로젝트에서 해본다
		//각 사이트의 글자수를 제한 걸어놓고 
	}
</script>
</div>
</div>


















