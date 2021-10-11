package org.kosta.webstudy16.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// DAO : Data Access Object, VO : Value Object, DTO : Data Transfer Object, Service : Business Object
// ProductDAO 에 Singleton Design Pattern 적용해서 
// 시스템 상에서 단 한번 객체를 생성하여 외부에서 사용하게 한다
public class ProductDAO {
	//2. static으로 객체 생성 
	private static ProductDAO instance = new ProductDAO();
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String username="scott";
	private String password="tiger";
	
	//1. private Constructor 생성
	private ProductDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//3. static method로 객체 1번만 생성 
	public static ProductDAO getInstance() {
		return instance;
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
	public ProductVO findProductById(String id) throws SQLException {
		ProductVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "select name, maker, price from web_product where id = ?";
			pstmt = con.prepareStatement(sql);
			int pid = Integer.parseInt(id);
			pstmt.setInt(1, pid);//setString해도 무관(ProductVO객체에 넣을 때 형변환)
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new ProductVO(pid,rs.getString(1),rs.getString(2),rs.getInt(3));
			}
		}finally {
			closeAll(rs, pstmt, con);	
		}
		return vo;
	}
	
	public void register(ProductVO vo) throws SQLException {
		//만들때는 DAO, 백엔드부터 만들기 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//insert는 반환형을 void나 int 로만 가능 
			//등록 성공값인 1과 void
			con = DriverManager.getConnection(url, username, password);
			String sql = "insert into web_product(id, name, maker, price) values(web_product_seq.nextval, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getMaker());
			pstmt.setInt(3, vo.getPrice());
			//int result = pstmt.executeUpdate(); 에서 
			//result 값은 등록이 성공했으므로 1
			pstmt.executeUpdate();
			
		}finally {
			closeAll(pstmt, con);	
		}
	}
}

























