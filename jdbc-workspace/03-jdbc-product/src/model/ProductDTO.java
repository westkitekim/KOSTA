package model;
//DTO : Data Transfer Object 
public class ProductDTO {
	private String id; //number로 db에 저장되어있지만 getString()으로 끌어오면 됌
	private String name;
	private String maker;
	private int price; //연산은 되지만 소수점 이하는 관리하지 않겠다 number 가 무조건 int 나 double 이 아니다  
	
	public ProductDTO() {// 기본생성자 
		super();
		
	}
	public ProductDTO(String id, String name, String maker, int price) {
		super();
		this.id = id;
		this.name = name;
		this.maker = maker;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", maker=" + maker + ", price=" + price + "]";
	}
	
	
}
