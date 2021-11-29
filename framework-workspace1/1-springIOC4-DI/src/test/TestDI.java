package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.ProductService;

public class TestDI {
	public static void main(String[] args) {
		//API 외울 필요는 없음 
		//설정파일 로딩시키기 
		//ClassPathXmlApplicationContext : Spring IOC Container(DI Container)
		//loading 하면 커피콩(bean) 생성
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring-config.xml");
		ProductService service = (ProductService) factory.getBean("productService");
		System.out.println(service.findProductById("1"));
		
		factory.close();
	}
}
