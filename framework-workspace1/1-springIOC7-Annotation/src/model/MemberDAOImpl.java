package model;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository // 컴포넌트 계열 - 컨테이너에게 객체 생성 명시 
public class MemberDAOImpl implements MemberDAO {
	private DataSource dataSource;
	@Autowired //DI 계열 , 생성자가 1개면 생략가능
	public MemberDAOImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	@Override
	public void register(String memberInfo) {
		try {
			System.out.println(memberInfo + "회원정보를 db에 등록" + dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
