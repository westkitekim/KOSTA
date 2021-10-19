<%@page import="java.sql.*, javax.sql.*, model.*"%><%-- java.sql.*, javax.sql.*, model.* --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>dbcp test</title>
	</head>
	<body>
	<%-- 실행시켜 결과값을 확인해보고, 1번과 2번의 차이점을 확인해본다 --%>
	
		1. 기존의 db 커넥션을 생성하고 소멸시키는 방식의 컨넥션 객체 : 
		<%
		String url="jdbc:oracle:thin:@127.0.01:1521:xe";
		Connection con = DriverManager.getConnection(url, "scott", "tiger");//컨넥션 생성
		
		/* 아파치톰캣 dbcp 가 datasource다... 다른 객체가 동작되고 있다는 것을 확인한다....*/
		%>
		<%=con.getClass() %>
		<%
		con.close();//컨넥션을 소멸시킨다
		%>
		<br><br>
		<%-- Interface DataSource - Connection pooling implementation(was 는 middle-tier) --%>
		2. DBCP(Database Connection Pool)을 이용해 컨넥션을 빌려오고 반납하는 방식의 컨넥션 객체 : 
		<%
		DataSource ds = DataSourceManager.getInstance().getDataSource();
		//DBCP로부터 컨넥션을 빌려온다
		Connection dbcpCon = ds.getConnection();
		%>
		
		<%=dbcpCon.getClass() %><%--tostring이 오버라이드되서 실제 클래스이름 가져온다? --%>
		<%
		//컨넥션을 소멸시키는 것이 아니라 dbcp에 반납한다
		//close()는 오버라이딩된 다른 메서드이기 때문
		dbcpCon.close();
		%>
		
	</body>
</html>





















