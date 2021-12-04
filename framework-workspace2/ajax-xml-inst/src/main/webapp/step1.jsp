<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax 방식으로 자동차정보 조회하기 </title>
<script type="text/javascript">
	function startAjax(){
		let makerComp=document.getElementById("maker");
		if(makerComp.value==""){
			document.getElementById("carView").innerHTML="";
			return;	
		}
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				document.getElementById("carView").innerHTML=xhr.responseText;
			}
		}//callback
		xhr.open("get", "FindCarServlet?maker="+makerComp.value);
		xhr.send();
	}
</script>
</head>
<body>
<select id="maker" onchange="startAjax()">
	<option value="">----</option>
	<option value="현대">현대</option>
	<option value="르노">르노</option>
	<option value="기아">기아</option>
</select>
<span id="carView"></span>
</body>
</html>
<%-- select option 을 사용자가 선택하면 maker select option의 value를 서버로 전달하고 
	   응답받은 정보를 carView span 영역에 보여준다 
	   만악 option value가 공란이면 carView span 영역의 데이터를 비워준다 
	   step1의 FindCarServlet을 참조해서 ajax get 방식으로 구현해본다 
 --%>






