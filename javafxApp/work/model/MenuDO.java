package model;

public class MenuDO {

	private String foodName;
	private String foodKind;
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodKind() {
		return foodKind;
	}
	public void setFoodKind(String foodKind) {
		this.foodKind = foodKind;
	}
	@Override
	public String toString() {
		return "MenuDO [foodName=" + foodName + ", foodKind=" + foodKind + "]";
	}
	
	
}
