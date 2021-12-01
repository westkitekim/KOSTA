package org.kosta.model;

import org.springframework.stereotype.Repository;

//많이 사용되는 어노테이션 정리
//spring에게 bean을 생성할 것을 명시
@Repository
public class ProductDAOImpl implements ProductDAO {
	@Override
	public void register(String productInfo) {
		System.out.println(getClass().getName() + " register " + productInfo);
	}
}
