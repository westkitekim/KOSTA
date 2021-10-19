package org.kosta.webstudy23.model;

public class ProductVO {
	//sql의 number는 VO에서 int, String 상관 없지만 데이터가 많아지면 메모리를 많이 차지하므로 number일 경우 int로 맞춰주는게 합당하다 
	private int id;
	private String name;
	private String maker;
	private int price;
	private String regDate;
	//기본생성자는 관례쩍
	public ProductVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	//id는 sequence, date는 sysdate 시스템 시간이므로 자동적으로 데이터가 할당되므로 id와 regDate가 없는 생성작도 필요
	public ProductVO(String name, String maker, int price) {
		super();
		this.name = name;
		this.maker = maker;
		this.price = price;
	}
	
	public ProductVO(String name, String maker, String regDate) {
		super();
		this.name = name;
		this.maker = maker;
		this.regDate = regDate;
	}
	
	public ProductVO(int id, String name, String maker, String regDate) {
		super();
		this.id = id;
		this.name = name;
		this.maker = maker;
		this.regDate = regDate;
	}
	public ProductVO(int id, String name, String maker, int price, String regDate) {
		super();
		this.id = id;
		this.name = name;
		this.maker = maker;
		this.price = price;
		this.regDate = regDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", name=" + name + ", maker=" + maker + ", price=" + price + ", regDate="
				+ regDate + "]";
	}
	
	
}
