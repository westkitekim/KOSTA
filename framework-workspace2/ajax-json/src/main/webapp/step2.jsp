<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSONArray를 이용해 ajax 통신하는 예제</title>
<script type="text/javascript">
	function startAjax() {
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				//1. 텍스트만 받아오기
				alert(xhr.responseText);
				
				//2. JSON객체를 가져옴 JSONArray : javascript배열
				//xhr.responseText로 반환되는 데이터 : ["손흥민","황의조","기성용"]
				let ja = JSON.parse(xhr.responseText);
				//alert(ja.length);
				
				//tbody의 id
				//js에서 누적시킬때는 공란으로 초기화하는 것이 좋음
				let tb = "";
				for(let i = 0; i < ja.length; i++) {
					tb += "<tr>";
					tb += "<td>" + ja[i] + "</td>";
					tb += "</tr>";
				}//for
				
				//아래 table의 tbody에 생성한 tr, td 정보를 입력한다 
				document.getElementById("player").innerHTML = tb;
				
			}//if
		}//callback
		//open : 요청정보 설정
		xhr.open("get", "JSONArrayServlet");
		xhr.send();
	}
	function clearPlayer() {
		document.getElementById("player").innerHTML="";
	}
</script>
</head>
<body>
<input type="button" value="JSONArray확인" onclick="startAjax()">
<input type="button" value="비우기" onclick="clearPlayer()">
<table border="1">
	<thead>
		<tr>
			<th>선수명</th>
		</tr>
	</thead>
	<tbody id="player"></tbody>
</table>
</body>
</html>





























