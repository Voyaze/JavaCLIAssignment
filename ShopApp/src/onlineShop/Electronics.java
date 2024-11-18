package onlineShop;

public class Electronics extends Product implements Orderable{
	String brand;
	int warrantyPeriod;
	
	public Electronics(String productId, String productName, double price, String brand, int warrantyPeriod) {
		super(productId, productName, price);
		this.brand = brand;
		this.warrantyPeriod = warrantyPeriod;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}
	public void setWarrantyPeriod(int warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	@Override
	public void displayProductInfo() {
		System.out.println("Product Id = " + this.productId + "\n"
				+ "ProductName = " + this.productName + "\n"
				+ "Brand = " + this.brand + "\n"
				+ "Price = " + this.price);
	}
	
	@Override
	public double getPrice() {
		return this.price;
	}
	
	@Override
	public boolean isAvailable() {
		if(warrantyPeriod > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public void addToOrder(Order order) {
		order.addorderItems(this);
	}
	
	@Override
	public void displayOrderDetails(){
		displayProductInfo();
	}
}
