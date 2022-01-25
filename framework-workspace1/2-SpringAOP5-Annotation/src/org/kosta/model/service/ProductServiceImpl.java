package org.kosta.model.service;

import org.kosta.model.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductDAO productDAO;
	//별도의 DI 어노테이션을 명시하지 않아도 가능하긴 하나 연습용으로 다 작성해보기
	@Autowired
	public ProductServiceImpl(ProductDAO productDAO) {
		super();
		this.productDAO = productDAO;
	}
	@Override
	public void register(String productInfo) {
		productDAO.register(productInfo);
	}
	@Override
	public String findById(String id) {
		return productDAO.findById(id);
	}
	@Override
	public String findByMaker(String maker) {
		return productDAO.findByMaker(maker);
	}

}
