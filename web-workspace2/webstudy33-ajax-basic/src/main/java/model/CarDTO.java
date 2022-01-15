package model;

public class CarDTO {
	private String model;
	private int price;
	private String maker;
	
	public CarDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarDTO(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}
	public CarDTO(String model, int price, String maker) {
		super();
		this.model = model;
		this.price = price;
		this.maker = maker;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	@Override
	public String toString() {
		return "CarDTO [model=" + model + ", price=" + price + ", maker=" + maker + "]";
	}
	
}
