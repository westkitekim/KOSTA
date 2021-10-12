package org.kosta.webstudy18.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Singleton Design Pattern을 적용 : 시스템 상에서 단 한번 객체 생성해 공유하여 사용하고자 할 때 적용하는 설계 패턴
 */
public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String username = "scott";
	private String userpass = "tiger";
	private MemberDAO() {}//driver loading 은 자바 1.6 이상부터 자동생성되므로 생성자에서 구현하지 않는다 
	public static MemberDAO getInstance() {
		return instance;
	}
	//closeAll 오버로딩 2개 만든다
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
	
	public MemberVO findMemberById(String id) throws SQLException {
		MemberVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, username, userpass);
			String sql = "select name, address from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVO(id, null, rs.getString(1), rs.getString(2));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		
		return vo;
	}
	/*
	public MemberVO login(String id, String password) throws SQLException {
		MemberVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, username, userpass);
			String sql = "select name, address from member where id=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				vo = new MemberVO(null, null, rs.getString(1), rs.getString(2));
				
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
	*/
	//강사님 코드(MemberVO get하는 값만 상이)
	public MemberVO login(String id, String password) throws SQLException {
		MemberVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, username, userpass);
			String sql = "select name, address from member where id=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				//id와 password 는 필요없지만 나중에 회원정보에서 수정이 필요할 수 있기 때문에 넣어준다
				vo = new MemberVO(id, password, rs.getString(1), rs.getString(2));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
	
	public ArrayList<MemberVO> findMemberListByAddress(String address) throws SQLException {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, username, userpass);
			String sql = "select id, name from member where address = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				list.add(new MemberVO(rs.getString(1), null, rs.getString(2), null));
				
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		//없을 때는 빈 arrayList에서 반환 - jsp 에서 for 문 돌리지 않도록? 
		return list;
		
	}
	
	public void updateMember(MemberVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, username, userpass);
			String sql = "update member set password = ?, name = ?, address = ? where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getId());
			pstmt.executeUpdate();
			
		} finally {
			closeAll(pstmt, con);
		}
	}
	
	public void register(MemberVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, username, userpass);
			String sql = "insert into member(id, password, name, address) values (?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
			
		}
	}
	/* 내 풀이
	public boolean idCheck(String id) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, username, userpass);

			String sql = "select id from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals(id)) flag = true;
			}
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return flag;
	}
	*/
	
	public boolean idCheck(String id) throws SQLException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, username, userpass);
			//column으로 뽑지 않고 개수로 뽑는다(primary로 조회하기 때문에 0 아니면 1)
			String sql = "select count(*) from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			//조회정보가 1이면 아이디가 존재하므로 true 할당
			//rs.next() 반환값은 boolean
			if(rs.next() && rs.getInt(1) == 1) {
				result = true;
			}
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return result;
	}
	
}

























