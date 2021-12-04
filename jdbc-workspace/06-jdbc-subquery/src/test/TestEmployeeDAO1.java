package test;

import java.sql.SQLException;

import model.Employee;
import model.EmployeeDAO;
//사원 등록예제 
public class TestEmployeeDAO1 {
	public static void main(String[] args) {
		try {
			EmployeeDAO dao = new EmployeeDAO();
			//vo dto, 안쓰기도 함
			//사원번호는 자동 발급하는 생성자 insert에 사용한다 
			Employee emp = new Employee("이용", "총무", 1100);
			dao.register(emp);
			//nextval 로 insert만 
			System.out.println("사원등록완료");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
