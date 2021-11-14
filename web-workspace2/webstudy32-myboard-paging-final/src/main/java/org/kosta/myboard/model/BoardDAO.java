package org.kosta.myboard.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class BoardDAO {
	private static BoardDAO instance=new BoardDAO();
	private DataSource dataSource;
	private BoardDAO() {
		this.dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static BoardDAO getInstance() {
		return instance;
	}
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException{
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException{
		if(rs!=null)
			rs.close();
		closeAll(pstmt, con);
	}
	public ArrayList<PostVO> getPostingList() throws SQLException{
		ArrayList<PostVO> list = new ArrayList<PostVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();//dbcp로부터 컨넥션을 빌려온다
			StringBuilder sql = new StringBuilder();
			sql.append("select b.no, b.title, m.name, to_char(b.time_posted, 'YYYY.MM.DD') as time_posted, b.hits ");
			sql.append("from board b, board_member m ");
			sql.append("where b.id=m.id ");
			sql.append("order by b.no desc");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//컬럼명 사용
				PostVO pvo = new PostVO();
				pvo.setNo(rs.getInt("no"));//getString(1,2,3...) 대신 컬럼명으로 가능
				pvo.setTitle(rs.getString("title"));
				pvo.setTimePosted(rs.getString("time_posted"));
				pvo.setHits(rs.getInt("hits"));
				MemberVO mvo = new MemberVO();
				mvo.setName(rs.getString("name"));
				pvo.setMemberVO(mvo);
				list.add(pvo);
			}
		} finally { 
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	public void updateHits(String no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "update board set hits= hits+1 where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	public PostVO getPostingByNo(String no) throws SQLException {
		PostVO pvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			//id 추가
			sql.append("select b.no, b.title, m.id, m.name, b.content, b.hits, to_char(b.time_posted, 'YYYY.MM.DD HH24.MI.SS') as time_posted ");
			sql.append("from board b, board_member m ");
			sql.append("where b.id = m.id and b.no = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			//primary key이므로 있거나 없거나
			if(rs.next()) {
				//column 이 많을 경우 column name 으로 값 할당한다 
				MemberVO mvo = new MemberVO(rs.getString("id"), null, rs.getString("name"));
				//public PostVO(int no, String title, String content, int hits, String timePosted, MemberVO memberVO) {
				pvo = new PostVO(rs.getInt("no"), rs.getString("title"), rs.getString("content"), rs.getInt("hits"), rs.getString("time_posted"), mvo);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return pvo;
	}
	public void posting(PostVO postVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "insert into board(no,title,content,time_posted,id) values(board_seq.nextval,?,?,sysdate,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, postVO.getTitle());
			pstmt.setString(2, postVO.getContent());
			pstmt.setString(3, postVO.getMemberVO().getId());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	public void deletePostByNo(String no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "delete from board where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	public void updatePostByNo(PostVO postVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "update board set title=?, content=? where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, postVO.getTitle());
			pstmt.setString(2, postVO.getContent());
			pstmt.setInt(3, postVO.getNo());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
}



















