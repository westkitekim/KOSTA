<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax(JSON을 이용하여 통신)</title>
<script type="text/javascript">
	function startAjax() {
		let maker = document.getElementById("maker").value;
		if(maker == "") {
			document.getElementById("modelView").innerHTML = "";
			document.getElementById("priceView").innerHTML = "";
			return;
		}
		let xhr = new XMLHttpRequest();
		xhr.onload = function() {
			//alert(xhr.responseText);
			//JSON 객체로 파싱
			//응답정보를 json object로 변환한다
			let json = JSON.parse(xhr.responseText);
			//alert(json.model);
			//alert(json.price);
			document.getElementById("modelView").innerHTML = json.model;
			document.getElementById("priceView").innerHTML = json.price;
		}
		xhr.open("get", "JSONObjectServlet?maker=" + maker);
		xhr.send();
	}
</script>
</head>
<body>
<select id="maker" onchange="startAjax()">
<option value="">---</option>
<option value="현대">현대</option>
<option value="르노">르노</option>
<option value="기아">기아</option>
</select>
모델 <span id="modelView"></span> 가격 <span id="priceView"></span>
</body>
</html>










