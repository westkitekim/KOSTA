package org.kosta.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// Component 계열 어노테이션 - spring container에게 객체(bean) ★생성★할 것을 명시
@Service
public class ProductServiceImpl implements ProductService {
	private ProductDAO productDAO;
	//DI 계열 어노테이션 -> spring container에게 dependency injection 할 것을 명시(DI, 객체 ★주입★) 
	@Autowired
	public ProductServiceImpl(ProductDAO productDAO) {
		super();
		this.productDAO = productDAO;
	}
	//생성자를 단일하게 갈 때는 autowired 생략 가능, 하지만 여러 개일 때는 명시해줘야 한다.
	public ProductServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void register(String productInfo) {
		productDAO.register(productInfo);
	}
}
