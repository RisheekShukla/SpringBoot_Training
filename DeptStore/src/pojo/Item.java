package pojo;

public class Item {
	private String item_name;
	private String Category;
	private double buy_price;
	public Item(String string, String string2, double d) {
		item_name=string;
		Category = string2;
		buy_price = d;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public double getBuy_price() {
		return buy_price;
	}
	public void setBuy_price(int buy_price) {
		this.buy_price = buy_price;
	}
	
	@Override
    public String toString() {
        return "Item [Name: " + item_name + ", Category: " + Category + ", Buying Price: " + buy_price + "]";
    }
	
}
