package onlineShop;

public class Clothing extends Product implements Orderable{
	String size;
	int quantityInStock;
	
	public Clothing(String productId, String productName, double price, String size, int quantityInStock) {
		super(productId, productName, price);
		this.size = size;
		this.quantityInStock = quantityInStock;
	}
	
	@Override
	public void displayProductInfo() {
		System.out.println("Product Id = " + this.productId + "\n"
				+ "ProductName = " + this.productName + "\n"
				+ "Size = " + this.size + "\n"
				+ "Price = " + this.price);
	}
	
	@Override
	public double getPrice() {
		return this.price;
	}
	
	@Override
	public boolean isAvailable() {
		if(this.quantityInStock > 0) {
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
	public void displayOrderDetails() {
		displayProductInfo();	
	}
	
}
