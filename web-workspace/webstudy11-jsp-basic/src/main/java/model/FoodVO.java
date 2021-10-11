package model;

public class FoodVO {
	private String name;
	private String maker;
	private int price;
	//관례적으로 기본생성자 만들어준다
	public FoodVO() {
		super();
	}
	public FoodVO(String name, String maker, int price) {
		super();
		this.name = name;
		this.maker = maker;
		this.price = price;
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
		return "FoodVO [name=" + name + ", maker=" + maker + ", price=" + price + "]";
	}
	
}
