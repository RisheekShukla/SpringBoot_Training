package pojo;

public class Product {
	private int prod_id;
	private String prod_name;
	private double sell_price;
	private int avail_q;
	public Product(int i, String string, double d, int j) {
		prod_id=i;
		prod_name=string;
		sell_price=d;
		avail_q=j;
	}
	public int getprod()
	{
		return prod_id;
	}
	public String getpname()
	{
		return prod_name;
	}
	public double getsp()
	{
		return sell_price;
	}
	public int getquant()
	{
		return avail_q;
	}
	public void setprod(int prod_id)
	{
		this.prod_id=prod_id;
	}
	public void setpname(String prod_name)
	{
		this.prod_name=prod_name;
	}
	public void setsp(double sellingPrice)
	{
		this.sell_price= sellingPrice;
	}
	public void setquant(int avail_q)
	{
		this.avail_q = avail_q;
	}
	@Override
    public String toString() {
        return "Product [ID: " + prod_id + ", Name: " + prod_name + ", Price: " + sell_price + ", Quantity: " + avail_q + "]";
    }
	
}
