package model;

import java.sql.SQLException;

//sql로 import 
import javax.sql.DataSource;

public class PointDAOImpl implements PointDAO {
	private DataSource dataSource;
	//dbcp를 DI 즉 컨테이너로부터 주입
	public PointDAOImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public void register(String pointInfo) {
		//test로 dataSource.getConnection() 추가
		try {
			System.out.println(pointInfo + " 포인트 정보를 db에 등록 " + dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
