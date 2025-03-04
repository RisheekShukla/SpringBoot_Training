package pojo;

public class Product {
	private int productid;
	private String productname;
	private double sellingprice;
	private int availablequantity;
	public Product(int productid, String productname, double sellingprice, int availablequantity) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.sellingprice = sellingprice;
		this.availablequantity = availablequantity;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getSellingprice() {
		return sellingprice;
	}
	public void setSellingprice(double sellingprice) {
		this.sellingprice = sellingprice;
	}
	public int getAvailablequantity() {
		return availablequantity;
	}
	public void setAvailablequantity(int availablequantity) {
		this.availablequantity = availablequantity;
	}
}
