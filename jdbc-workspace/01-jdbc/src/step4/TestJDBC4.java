package step4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * ID에 해당하는 회원 정보를 삭제
 * 
 * ○ 스캐너를 이용해 아이디를 입력받은 후 아이디에 해당하는 회원을 삭제
 *   삭제에 성공하면 executeUpdate() 의 반환값이 1이 반환된다 -> 머머 id 회원 정보를 삭제
 * ○ 아이디에 해당하는 회원이 없어서 삭제하지 못하면 executeUpdate() 의 반환값은 0이 반환 -> 머머 id에 해당하는 
 *   회원이 없어서 삭제하지 못했습니다
 */
public class TestJDBC4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 회원의 아이디를 입력하세요:");
		String id = scanner.nextLine();
		scanner.close();
		
		//제일 먼저 
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, "scott", "tiger");
			String sql = "delete from member where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();//result : 삭제한 row의 수가 반환
			
			if(result == 1) {
				System.out.println(id + " 아이디 회원정보를 삭제");
			}else {
				System.out.println(id + " 아이디 회원정보가 존재하지 않아 삭제하지 못했습니다");
				
			}
			pstmt.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}


















