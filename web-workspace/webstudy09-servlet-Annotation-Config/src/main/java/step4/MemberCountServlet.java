package step4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberCountServlet
 */
@WebServlet("/MemberCountServlet")
public class MemberCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

	// 부모나 상위에서 명시한 exception외에 다른것은 try catch로 잡아줘야함
	@Override
	public void init() throws ServletException {
		try {
			// driver loading 은 한 번만 한다
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("init() 에서 jdbc driver loading");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// DB연동만 확인
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// JDBC를 이용한 데이터베이스와의 연동
			con = DriverManager.getConnection(url, "scott", "tiger");
			String sql = "select count(*) from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
			}

			// 클라이언트에세 서비스하기 위한 부분
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("총회원수" + count + "명");

			out.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
