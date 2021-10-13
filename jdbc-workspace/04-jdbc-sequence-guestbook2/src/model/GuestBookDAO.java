package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Library : 재사용할 수 있는 프로그램들을 말한다. 클래스들을 자료로 묶어놓은 것
public class GuestBookDAO {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String username = "scott";
	private String password = "tiger";

	public GuestBookDAO() throws ClassNotFoundException {
		Class.forName(driver);
	}

	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	// 오버로딩
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		// 위 메서드를 재사용
		closeAll(pstmt, con);
	}
	// register(), getAllGuestBookList() 김서연 풀이
	/*
	 * public void register(GuestBookDTO dto) throws SQLException { Connection con =
	 * null; PreparedStatement pstmt = null; try { con =
	 * DriverManager.getConnection(url, username, password); String sql =
	 * "insert into guestbook(guestbook_no, title, content) values (guestbook_seq.nextval, ?, ?)"
	 * ; pstmt = con.prepareStatement(sql); pstmt.setString(1, dto.getTitle());//
	 * 물음표에 차례로 바인딩 pstmt.setString(2, dto.getContent());
	 * 
	 * pstmt.executeUpdate(); } finally {// 에러가 나도 실행됨 //항상 작업을 했으면 닫아줘야 하기 때문에
	 * try/catch closeAll(pstmt, con); } }
	 * 
	 * public ArrayList<GuestBookDTO> getAllGuestBookList() throws SQLException {
	 * ArrayList<GuestBookDTO> list = new ArrayList<GuestBookDTO>(); Connection con
	 * = null; PreparedStatement pstmt = null; ResultSet rs = null;
	 * 
	 * try { con = DriverManager.getConnection(url, username, password);
	 * StringBuilder sql = new StringBuilder();
	 * sql.append("select guestbook_no, title, content ");
	 * sql.append("from guestbook "); sql.append("order by guestbook_no desc");
	 * 
	 * // id는 어차피 가지고 오니까 생략 pstmt = con.prepareStatement(sql.toString()); rs =
	 * pstmt.executeQuery();// 0일 수 있고 여러명있을 수 있음
	 * 
	 * while (rs.next()) {
	 * 
	 * GuestBookDTO dto = new GuestBookDTO(); dto.setGuestbookNo(rs.getInt(1));
	 * dto.setTitle(rs.getString(2)); dto.setContent(rs.getString(3));
	 * list.add(dto); // 방법3 생성자 오버로딩 추가
	 * 
	 * } } finally { closeAll(rs, pstmt, con); }
	 * 
	 * return list;
	 * 
	 * }
	 */

	// register(), getAllGuestBookList() 풀이본
	public void register(GuestBookDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// insert이기 때문에 ResultSet이 필요없다
		try {
			con = DriverManager.getConnection(url, username, password);
			StringBuilder sql = new StringBuilder();
			// 방법1
			sql.append("insert into guestbook(guestbook_no, title, content) ");
			sql.append("values (guestbook_seq.nextval, ?, ?)");
			// 방법2
			// String sql = "insert into guestbook(guestbook_no, title, content) values
			// (guestbook_seq.nextval, ?, ?)";
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getTitle());// 물음표에 차례로 바인딩
			pstmt.setString(2, dto.getContent());
			pstmt.executeUpdate();//
		} finally {// 에러가 나도 실행됨 //항상 작업을 했으면 닫아줘야 하기 때문에 try/catch
			closeAll(pstmt, con);
		}
	}

	public ArrayList<GuestBookDTO> getAllGuestBookList() throws SQLException {
		ArrayList<GuestBookDTO> list = new ArrayList<GuestBookDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, username, password);
			StringBuilder sql = new StringBuilder();
			// StringBuilder 사용 시 주의사항 : sql구문 띄어쓰기에 유의
			sql.append("select guestbook_no, title, content ");
			sql.append("from guestbook ");
			sql.append("order by guestbook_no desc");

			// id는 어차피 가지고 오니까 생략
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();// 0일 수 있고 여러명있을 수 있음

			while (rs.next()) {

				GuestBookDTO dto = new GuestBookDTO();
				dto.setGuestbookNo(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				list.add(dto);
				// 방법2
				// 매개변수 안에서 직접 생성자로 객체를 만들면서 넣는 방법
				// list.add(new GuestBookDTO(rs.getString(1), rs.getString(2),
				// rs.getString(3)));

			}
		} finally {
			closeAll(rs, pstmt, con);
		}

		return list;

	}

	/*
	 * 글 등록시에 db에서 발급한 시퀀스 정보를 dto의 guestbookNo에 할당시키도록 기존의 register메서드를 업데이트한 메서드
	 * Connection PreparedStatement insert sql 실행 ( sequence명.nextval )
	 * pstmt.close() -- 다 닫지 않고 pstmt만 close한다 PreparedStatement select sql 실행 (
	 * sequence명.currval ) ResultSet closeAll()
	 * 
	 */
	public void registerVer2(GuestBookDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// connection 만들고 같은 커넥션 내에서 nextval, ★currval★ 실행
			// 하나의 connection 내에서만 currval 을 사용 가능하다
			// sequence 가 담기는 dual table 은 table과 독립적
			con = DriverManager.getConnection(url, username, password);
			String insertSql = "insert into guestbook(guestbook_no, title, content) values(guestbook_seq.nextval, ?, ?)";
			pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, dto.getTitle());// 첫번째 물음표에 title 할당
			pstmt.setString(2, dto.getContent());// 두번째 물음표에 content 할당
			pstmt.executeUpdate();
			pstmt.close();// 실행시킨 다음 close

			// 발급받은 현재값
			String selectSql = "select guestbook_seq.currval from dual";// dual table 사용
			pstmt = con.prepareStatement(selectSql);
			pstmt.executeUpdate();
			rs = pstmt.executeQuery();
			if (rs.next()) {// 발급받은 현재값 받환
				int guestBookNo = rs.getInt(1);// INSERT 시점에 발급받은 시퀀스(guestbook_no)의 현재값을 받아온다
				dto.setGuestbookNo(guestBookNo);// dto에 할당한다
			}

		} finally {
			closeAll(rs, pstmt, con);
		}

	}

	/*
	 * 
	 */
	public ArrayList<GuestBookDTO> getGuestBookListLikeKeyword(String keyword) throws SQLException {
		ArrayList<GuestBookDTO> list = new ArrayList<GuestBookDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "SELECT guestbook_no, title, content FROM GUESTBOOK WHERE TITLE LIKE '%' || ? || '%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new GuestBookDTO(rs.getInt(1), rs.getString(2), rs.getString(3)));
				
				
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}

}
