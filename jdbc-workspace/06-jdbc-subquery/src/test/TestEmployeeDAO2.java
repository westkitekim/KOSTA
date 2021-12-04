package test;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Employee;
import model.EmployeeDAO;
//job이 개발인 사원중에서 salary가 가장 높은 사원 조회 

public class TestEmployeeDAO2 {
	public static void main(String[] args) {
		try {
			EmployeeDAO dao = new EmployeeDAO();
			//vo dto, 안쓰기도 함
			//사원번호는 자동 발급하는 생성자 insert에 사용한다 
			String job = "개발";
			/*
			 * 해당 job(직종) 의 사원 중 가장 높은 salary를 받는 
			 * 사원 정보를 조회하는 메서드 
			 * 반환형은 여러개 일 수 있기 때문에 
			 * 높은 연봉 받는 사람이 여러명 일 수 있기 때문에 ArrayList로 받고 
			 * 형은 
			 */
			ArrayList<Employee> list 
			= dao.getEmployeeListByHighSalAndJob(job);
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
