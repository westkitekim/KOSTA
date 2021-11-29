package model;
//Service 는 DAO를 의존하고 있음
public class ProductServiceImpl implements ProductService {
	private ProductDAO productDAO;
	//생성자 대신 setter 사용 
	//DI ( Dependency Injection ) : setter 에 의존성 주입 ( spring ioc container가 bean or component or object 를 주입 )
	//set method에 DI 시킨다
	public void setProductDAO(ProductDAO productDAO) {
		//주입되는지 확인해보기
		System.out.println("setter DI :" + productDAO);
		this.productDAO = productDAO;
	}
	@Override
	public String findProductById(String id) {
		return productDAO.findProductById(id);
	}

}
