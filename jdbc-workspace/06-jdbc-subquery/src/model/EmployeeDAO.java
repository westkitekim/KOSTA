package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {
	public EmployeeDAO() throws ClassNotFoundException {
		Class.forName(DbInfo.DRIVER);
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
	//사원 등록 메서드 
	public void register(Employee emp) throws SQLException {
		//지역변수는 선언된 자신의 영역 내에서만 사용 가능하기 때문에 따로 빼줌 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(DbInfo.URL, DbInfo.USERNAME, DbInfo.PASSWORD);
			String sql = "insert into s_employee(empno, name, job, salary) values(s_employee_seq.nextval, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emp.getName());
			pstmt.setString(2, emp.getJob());
			pstmt.setInt(3, emp.getSalary());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
		
		
	}
	
	public ArrayList<Employee> getEmployeeListByHighSalAndJob(String job) throws SQLException {
		ArrayList<Employee> list = new ArrayList<Employee>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(DbInfo.URL, DbInfo.USERNAME, DbInfo.PASSWORD);
			//StringBuilder는 가변적
			StringBuilder sql = new StringBuilder();
			sql.append("select empno, name, job, salary ");
			sql.append("from s_employee ");
			sql.append("where salary = (select max(salary) from S_EMPLOYEE where job = ?) ");
			sql.append("and job = ?");//메서드 인자값을 통해 확인해야 하므로 '?' 사용 
			//반환형이 StringBuilder이므로 toString()을 통해 문자열로 변환
			pstmt = con.prepareStatement(sql.toString());
			//물음표 2개 setting
			pstmt.setString(1, job);
			pstmt.setString(2, job);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Employee dto = new Employee();
				dto.setEmpno(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setJob(rs.getString(3));
				dto.setSalary(rs.getInt(4));
				list.add(dto);
				//방법 2
				//list.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}
	
	
	
	
	
	
}
