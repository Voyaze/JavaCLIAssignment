package onlineShop;

import java.util.ArrayList;

public class Order {
	String orderId;
	String orderDate;
	ArrayList<Product> orderItems = new ArrayList<>();;
	String Status;

	public Order(String orderId, String orderDate, String status) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		Status = status;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public ArrayList<Product> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(ArrayList<Product> orderItems) {
		this.orderItems = orderItems;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	void addorderItems(Product product) {
		orderItems.add(product);
	}
	
	void displayOrderInfo() {
		System.out.println("Order ID = " + this.orderId + "\n"
				+ "Order Date = " + this.orderDate);
	}

	double calculateTotalPrice() {
		double sum = 0;
		for(Product P : orderItems) {
			sum += P.price;
		}
		return sum;
	}
	
	void processOrder() {
		for(Product P : orderItems) {
			if(P instanceof Clothing) {
				((Clothing) P).quantityInStock -= 1;
			}
			else if(P instanceof Electronics) {
				((Electronics) P).warrantyPeriod -=1;
			}
		}
	}
}
