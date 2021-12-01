package org.kosta.springmvc04.model.domain;
//VO, DTO, domain(업무영역) 다 같은 뜻 
//DB 컬럼 추가시 DTO 의 iv, getter/setter, toString 추가
public class ItemDTO {
	private int itemNo;
	private String name; 
	private String maker;
	private int price;
	private String regDate;//추가된 컬럼 - 인스턴스변수 추가
	//MyBatis 연동을 위한 기본생성자
	public ItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	//itemNo는 sequence이므로 제외한 생성자
	public ItemDTO(String name, String maker, int price) {
		super();
		this.name = name;
		this.maker = maker;
		this.price = price;
	}
	public ItemDTO(int itemNo, String name, String maker, int price) {
		super();
		this.itemNo = itemNo;
		this.name = name;
		this.maker = maker;
		this.price = price;
	}
	
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
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
	@Override
	public String toString() {
		return "ItemDTO [itemNo=" + itemNo + ", name=" + name + ", maker=" + maker + ", price=" + price + ", regDate="
				+ regDate + "]";
	}
	
}
