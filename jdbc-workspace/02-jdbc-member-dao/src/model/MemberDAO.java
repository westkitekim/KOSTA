package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * DAO : Data Access Object 데이터 엑세스(접근) 로직을 정의하는 객체
 */
public class MemberDAO {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String username = "scott";
	private String pass = "tiger";
	
	public MemberDAO() throws ClassNotFoundException {//로딩이 안되면 진행하지 않겠음 dao에서는 throws
		Class.forName(driver);	
	}
	
	/* DAO의 메서드에서는 Exception을 main으로 throws 처리한다
	 * 
	 * Connection
	 * insert sql 정의
	 * PreparedStatement
	 * sql 실행
	 * close
	 * 
	 */
	
	// 내 풀이
	// 닫는 것을 finally로 잡아주지 않으면
	// connection의 수는 제한되어 있고 
	// 에러가 나게 되면 close()가 실행되지 않고 끝나버리기 때문에 
	// 실행 개수가 많아질 경우 시스템이 과부화되어 뻗어버린다
	/*
	public void registerMember(MemberVO vo) throws SQLException {//insert만 하고 끝남
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		System.out.println("connection");
		String sql = "insert into membervo(id, password, name, address) values (?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPassword());
		pstmt.setString(3, vo.getName());
		pstmt.setString(4, vo.getAddress());
		int result = pstmt.executeUpdate();
		
		System.out.println("insert memberVO" + result);
		pstmt.close();
		con.close();
	}
	*/
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if(pstmt != null)
			pstmt.close();
		if(con != null)
			con.close();
	}
	//오버로딩, 조회할 때 사용한다 
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs != null)
			rs.close();
		closeAll(pstmt, con);
	}
	/*
	 * DAO 메서드에서는 Exception 을 main 으로 throws 처리한다
	 */
	public void registerMember(MemberVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, username, pass);
			String sql = "insert into member(id, password, name, address) values (?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());//물음표에 차례로 바인딩
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());
			pstmt.executeUpdate();	
		}finally {//에러가 나도 실행됨 //항상 작업을 했으면 닫아줘야 하기 때문에 try/catch
			closeAll(pstmt, con);
		}
	}
}
















