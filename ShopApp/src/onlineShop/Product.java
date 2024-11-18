package onlineShop;

abstract public class Product {
	String productId;
	String productName;
	double price;
	
	public Product(String productId, String productName, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	void displayProductInfo(){
		System.out.println("Product Id = " + this.productId + "\n"
				+ "ProductName = " + this.productName + "\n"
				+ "Price = " + this.price);
	}
	
	boolean isAvailable() {
		return true;
	}
}