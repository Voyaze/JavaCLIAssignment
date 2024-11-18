package onlineShop;

import java.util.ArrayList;

public class Customer extends User{
	String address;
	ArrayList<Order> orders = new ArrayList<>();
	ArrayList<Product> cart = new ArrayList<>();
	
	public Customer(String userId, String username, String email, String address) {
		super(userId, username, email);
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public ArrayList<Product> getCart() {
		return cart;
	}
	public void setCart(ArrayList<Product> cart) {
		this.cart = cart;
	}
	
	void displayCustomerInfo(){
		System.out.println("UserID = " + this.userId + "\n"
				+ "Username = " +  this.username + "\n"
				+ "Email = " + this.email + "\n"
				+ "Address = " + this.address);
		System.out.println("Order History : ");
		for (Order O : orders) {
			System.out.println(O.orderId + " " + O.orderDate);
		}
	}
	
	void addToCart(Product product) {
		this.cart.add(product);
	}
	
	void viewCart() {
		for(Product P : cart) {
			P.displayProductInfo();
		}
	}

}
