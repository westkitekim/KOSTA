package model;
//model 의 Service의 역할은 DAO에 중간에 위치해서 여러 개의 DAO를 맍춰서 여러개의 업무를 처리,
//비즈니스 로직, 트랜잭션을 처리하는 역할을 한다
//지금은 일단 중개의 역할
public interface ProductService {
	String findProductById(String id);
}
