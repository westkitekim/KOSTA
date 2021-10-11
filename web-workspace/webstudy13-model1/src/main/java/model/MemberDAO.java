package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String username="scott";
	private String password="tiger";
	public MemberDAO() throws ClassNotFoundException {
		Class.forName(driver);
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs != null)
			rs.close();
		closeAll(pstmt, con);
	}
	//overloading
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException { 
		if(pstmt != null)
			pstmt.close();
		if(con != null)
			con.close();
	}
	public int getTotalCount() throws SQLException {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "select count(*) from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next())
				count = rs.getInt(1);
			
		}finally {
			closeAll(rs, pstmt, con);
			
		}
		return count;
		
		
	}
	
	public MemberVO findMemberById(String id) throws SQLException {
		MemberVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "select name, address from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				vo = new MemberVO(id,null,rs.getString(1),rs.getString(2));
			}
			
		}finally {
			closeAll(rs, pstmt, con);
			
		}
		
		return vo;
		
		
	}
}




















