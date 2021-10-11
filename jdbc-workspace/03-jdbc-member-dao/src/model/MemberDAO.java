package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * DAO : Data Access Object 데이터 엑세스(접근) 로직을 정의하는 객체
 */
public class MemberDAO {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String username = "scott";
	private String pass = "tiger";

	public MemberDAO() throws ClassNotFoundException {// 로딩이 안되면 진행하지 않겠음 dao에서는 throws
		Class.forName(driver);
	}

	/*
	 * DAO의 메서드에서는 Exception을 main으로 throws 처리한다
	 * 
	 * Connection insert sql 정의 PreparedStatement sql 실행 close
	 */

	// 내 풀이
	// 닫는 것을 finally로 잡아주지 않으면
	// connection의 수는 제한되어 있고
	// 에러가 나게 되면 close()가 실행되지 않고 끝나버리기 때문에
	// 실행 개수가 많아질 경우 시스템이 과부화되어 뻗어버린다
	
	/*
	public void registerMember(MemberVO vo) throws SQLException {// insert만 하고 끝남
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
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	// 오버로딩, 조회할 때 사용한다
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
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
			pstmt.setString(1, vo.getId());// 물음표에 차례로 바인딩
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());
			pstmt.executeUpdate();
		} finally {// 에러가 나도 실행됨 //항상 작업을 했으면 닫아줘야 하기 때문에 try/catch
			closeAll(pstmt, con);
		}
	}
	/*
	 * public MemberVO findMemberById(String id) throws SQLException { MemberVO
	 * memberVO = new MemberVO(); Connection con = null; PreparedStatement pstmt =
	 * null; ResultSet rs = null; MemberVO result = null; try { con =
	 * DriverManager.getConnection(url, username, pass); String sql =
	 * "select id, password, name, address from member where id = ?";
	 * 
	 * pstmt = con.prepareStatement(sql); pstmt.setString(1, id); rs =
	 * pstmt.executeQuery();
	 * 
	 * if(id == memberVO.getId()) { result = memberVO; }
	 * 
	 * 
	 * }finally { closeAll(rs, pstmt, con); } return result; }
	 */

	public MemberVO findMemberById(String id) throws SQLException {
		MemberVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, username, pass);
			String sql = "select password, name, address from member where id = ?";// id는 어차피 가지고 오니까 생략
			//PreparedStatement 는 ?만 빼고 나머지(정해진 것)는 미리 메모리에 올려둔다, 보안이 좋다
			//secure coding guide에 나옴
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);// 1은 sql의 첫번 째 물음표를 의미한다 , 1번째 물음표에 id를 set하겠다
									//
			rs = pstmt.executeQuery();
			// primary key 인 id로 검색했으므로 회원정보가 1명 존재하거나 존재하지 않는다
			if (rs.next()) {// 검색 결과 행row가 존재하면 true 반환
				// 1번째가 password (id 는 인자로 가지고 있어서 따로 뺐음
				// rs.getString(1) -> sql의 column index ( 첫 번째 컬럼 password를 가르킨다 )
				// -> select 할 때 id는 빼서 가져왔기 때문
				// -> id는 왜 뺐느냐? : 인자값에 있으니까 그대로 사용하면 되기 때문이다
				vo = new MemberVO(id, rs.getString(1), rs.getString(2), rs.getString(3));
			}

		} finally {
			closeAll(rs, pstmt, con);
		}

		return vo;
	}

	/*
	 * member table에 저장된 회원 정보(id, name)를 list로 반환하는 메서드 list의 요소는 MemberVO이고
	 * MemberVO 객체의 id와 name 인스턴스 변수의 정보만 할당되면 된다
	 */
	/*
	 * public ArrayList<MemberVO> getAllMemberList() throws SQLException {
	 * ArrayList<MemberVO> list = new ArrayList<MemberVO>(); MemberVO vo = null;
	 * Connection con = null; PreparedStatement pstmt = null; ResultSet rs = null;
	 * 
	 * try { con = DriverManager.getConnection(url, username, pass); String sql =
	 * "select id,name from member";// id는 어차피 가지고 오니까 생략 pstmt =
	 * con.prepareStatement(sql);
	 * 
	 * rs = pstmt.executeQuery();
	 * 
	 * while (true) { if (rs.next()) { vo = new MemberVO(rs.getString(1),
	 * rs.getString(2)); list.add(vo); }
	 * 
	 * } } finally { closeAll(rs, pstmt, con); }
	 * 
	 * return list; }
	 */

	/*
	 * member table에 저장된 회원 정보(id, name)를 list로 반환하는 메서드 list의 요소는 MemberVO이고
	 * MemberVO 객체의 id와 name 인스턴스 변수의 정보만 할당되면 된다
	 */

	public ArrayList<MemberVO> getAllMemberList() throws SQLException {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, username, pass);
			String sql = "select id,name from member";// id는 어차피 가지고 오니까 생략
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// 0일 수 있고 여러명있을 수 있음

			// 검색한 행이 존재하면 true 반환
			while (rs.next()) {// 3개의 값이 있다면 3번 true 나옴 커서로 움직이기 때문에 반드시 실행되어야함
				// 방법1
				// list.add(new MemberVO(rs.getString(1),null,rs.getString(2),null));
				// 방법2 set method 이용
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString(1));
				vo.setName(rs.getString(2));
				list.add(vo);
				// 방법3 생성자 오버로딩 추가

			}
		} finally {
			closeAll(rs, pstmt, con);
		}

		return list;
	}

}// class
