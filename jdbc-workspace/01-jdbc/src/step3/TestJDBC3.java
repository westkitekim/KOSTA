package step3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * MEMBER ID로 SELECT 
 * ID는 PRIMARY KEY(PK, 주키, 기본키 ...)이므로 SQL을 실행하면
 * 1명의 회원정보가 존재하거나 아니면 회원정보가 존재하지 않는다(있거나 없거나)
 */
public class TestJDBC3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("검색할 회원아이디를 입력하세요:");
		String id = scanner.nextLine();//동적으로 아이디 받음
		scanner.close();
		//primary key인 id를 통해 조회하면 1행 or 0행만 반환되므로 
		//while이 아니라 if(2가지 경우의 수)를 사용한다 
		System.out.println(id + " 아이디 회원정보를 db에서 조회");
		
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, "scott", "tiger");//import
			String sql = "select name, address from member where id =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			//?에 대한 바인딩 필요
			pstmt.setString(1, id);//첫 번째 물음표엥 id 세팅
			ResultSet rs = pstmt.executeQuery();//select 일때는 결과 반환받음
			
			// PRIMARY KEY인 id로 검색했으므로 한 row 행이 존재하거나 아니면 존재하지 않는 2경우로 나뉘게 되므로 
			// if else로 결과를 보여준다 
			if(rs.next()) {//1명이 있거나 없거나
				System.out.println(rs.getString(1) + rs.getString(2));
			}else {
				System.out.println(id + "아이디를 가진 회원은 존재하지 않습니다");
			}
			
			rs.close();
			pstmt.close();
			con.close();
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}













