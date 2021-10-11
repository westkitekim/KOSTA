<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
    <%-- sql의 패키지 모두 import한다 - java.sql.* --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 회원수 가져오기 -->
<title>jsp와 db연동</title>
</head>
<body>
	<%
		String driver = "oracle.jdbc.OracleDriver";
		//1.6부터 생략가능 
		Class.forName(driver);
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		String sql = "select count(*) from member";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		int count = 0;
		if(rs.next()) {
			count = rs.getInt(1);
			
		}
		rs.close();
		pstmt.close();
		con.close();
		
	
	%>
	<h3>초기 웹 개발방식 : jsp 와 database 연동</h3>
	<h4>총 회원수 <%=count %>명 </h4>
	
	
</body>
</html>












