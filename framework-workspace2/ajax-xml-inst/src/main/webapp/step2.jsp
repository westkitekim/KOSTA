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
		let modelComp=document.getElementById("modelView");
		let priceComp=document.getElementById("priceView");
		if(makerComp.value==""){
			modelComp.innerHTML="";
			priceComp.innerHTML="";
			return;	
		}
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				//xml 을 응답받는다
				//alert(xhr.responseXML);
				let carVal=xhr.responseXML.getElementsByTagName("car");				
				/* alert(carVal[0].childNodes[0].nodeName);//model
				alert(carVal[0].childNodes[0].childNodes[0].nodeValue);//model 의 정보 
				alert(carVal[0].childNodes[1].nodeName);//price
				alert(carVal[0].childNodes[1].childNodes[0].nodeValue);//price의 정보  */
				modelComp.innerHTML=carVal[0].childNodes[0].childNodes[0].nodeValue;
				priceComp.innerHTML=carVal[0].childNodes[1].childNodes[0].nodeValue;
			}
		}//callback
		xhr.open("get", "FindCarXMLServlet?maker="+makerComp.value);
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
<br><br><br><br>
<span id="modelView"></span>
<br><br><br><br>
<span id="priceView"></span>
</body>
</html>
<%-- 
		step1 과 차이점은 자동차모델정보와 가격정보를 웹 화면의 별도의 영역에서 제공하려 한다 
		이 경우 서버측에서 기존 방식으로 문자열만으로 제공한다면 
		클라이언트 측에서 특정 기준으로 문자열을 분해해서 보여줄 수 밖에 없다 
		즉, 정보가 많고, 리스트 등의 구조체가 필요한 경우 한계가 있다.
		-> 따라서 구조화된 정보를 송수신하기 위해 XML or JSON 을 이용한다 
		이번 예제는 XML 방식으로 서버가 정보를 송신하고 Client javascript 에서 xml 정보를 수신하여
		표현해보는 예제다. 
		
		-> XML은 너무 복잡하여 JSON이 나오게 되었고 많이 사용되고 있음
 --%>






