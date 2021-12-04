package model;

public class CarDAO {
	private static CarDAO instance=new CarDAO();
	private CarDAO() {}
	public static CarDAO getInstance() {
		return instance;
	}
	public CarDTO getCarInfo(String maker) {
		CarDTO car=null;
		if(maker.contentEquals("현대")) {
			car=new CarDTO("소나타",200);
		}else if(maker.contentEquals("기아")) {
			car=new CarDTO("K5",300);
		}else if(maker.contentEquals("르노")) {
			car=new CarDTO("SM6",700);
		}
		return car;
	}
}






