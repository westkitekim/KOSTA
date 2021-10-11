package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//DAO 연습 
public class TestTest {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String username = "scott";
	private String password = "tiger";
	//기본 생성자에서 Class driver 를 loading 시킨다 
	public TestTest() throws ClassNotFoundException {
		Class.forName(driver);//checked Exception
	}
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if(pstmt != null)
			pstmt.close();
		if(con != null)
			con.close();
	}
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs != null) 
			rs.close();
	}
	//그냥 아이디가 아니라.. 
	public boolean existById(int productId) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "select count(*) from product where id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1) == 1)
					flag = true;
				
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		
		return flag;
	}
	
	
	
	
	
	
	
	
	
 }
