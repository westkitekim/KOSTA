package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//DAO class 
public class TestTest {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String username = "scott";
	private String password = "tiger";
	//객체 생성시 jdbc사용하기 위해 driver class loading 
	public TestTest() throws ClassNotFoundException {
		Class.forName(driver);
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
		closeAll(pstmt, con);
	}
	public ArrayList<GuestBookDTO> getAllGuestBookList() throws SQLException {
		ArrayList<GuestBookDTO> list = new ArrayList<GuestBookDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "select guestbook_no, title, content from guestbook order by guestbook_no desc";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				/*
				GuestBookDTO dto = new GuestBookDTO();
				//데이터에서 가져온 행의 값들을 dto객체에 넣어 반환한다 
				dto.setGuestbookNo(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				list.add(dto);
				*/
				list.add(new GuestBookDTO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	public void register(GuestBookDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		//insert로 값을 넣어줄 (create)것이기 때문에 ResultSet 필요 없음
		try {
			con = DriverManager.getConnection(url, username, password);
			StringBuilder sql = new StringBuilder();
			sql.append("insert into guestbook(guestbook_no, title, content) ");
			sql.append("values (guestbook_seq, ?, ?)");
			//sql은 StringBuilder타입이고 prepareStatement()안의 인자는
			//인자값으로 sql구문이 들어와야 하기 때문에 String타입, 
			//type match를 하기 위해 toString()을 통해 문자열로 변환해준다
			pstmt = con.prepareStatement(sql.toString());
			//물음표에 값을 넣어줘야 하기 때문에 차례로 바인딩, 숫자는 column index
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.executeUpdate();
			
		}finally {
			closeAll(pstmt, con);
		}
		
	}
	
	public void registerVer2(GuestBookDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
		}finally {
			closeAll(pstmt, con);
		}
		
	}
	
	
}

























