package onlineShop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	// Untuk customer ID pakai 001
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Product> products =  new ArrayList<>();
	public static ArrayList<User> users = new ArrayList<>();
	public static Customer CurrentUser = new Customer("000", "Temporary", "@gmail.com", "-");
	public static String orderNumber = "1";
	
	public static void main(String[] args) {
		Customer cust1 = new Customer("001", "Arvel", "arvel1708@gmail.com", "Jl. Kemanggisan No. 200");
		users.add(cust1);
		Clothing cloth001 = new Clothing("001","Embroided Hawaiian", 149.99, "XL", 10);
		Clothing cloth002 = new Clothing("003","Oversized Logo T-Shirt", 229.99, "M", 1);
		Electronics elec001 = new Electronics("002","RTX 2070 Super", 299.99, "NVIDIA", 5);
		Electronics elec002 = new Electronics("004","i7-4700K", 150.00, "Intel", 15);
		products.add(cloth001);
		products.add(cloth002);
		products.add(elec001);
		products.add(elec002);
		
		int input = -1;
		String login = "";
		boolean loggedIn = false;
		
		do {
			loggedIn = false;
			login = "";
			System.out.print("\n\n=== Online Shopping Platform ===\nInput CustomerID :");
			login = sc.nextLine();
			for(User U : users) {
				if(U.userId.equalsIgnoreCase(login)) {
					CurrentUser = (Customer)U;
					loggedIn = true;
				}
			}
		}while(!loggedIn);
		
		do {		
			displayMainMenu();
			
			try {
				input = sc.nextInt();
			} catch (Exception e) {
				input = -1;
				System.out.println("Must be Integer[!]");
			}
			sc.nextLine();

			switch(input) {
			case 1:
				displayProductsMenu();
				break;
			case 2:
				displayCartMenu();
				break;
			case 3:
				displayOrdersMenu();
				break;
			case 4:
				displayCustomerInfo();
				break;
			}
		} while(input != 5);
		
	}

	static void displayMainMenu() {
		System.out.print("\n\n== Online Shopping Platform ===\n"
				+ "1. Shop for Products\n"
				+ "2. View Shopping Cart\n"
				+ "3. View Orders\n"
				+ "4. Customer Info\n"
				+ "5. Exit\n"
				+ "Your Choice: ");
	}
	
	static void displayProductsMenu() {
		int input = -1;
		String addProduct;
		boolean doneAdding;
		do {
			System.out.print("\n\n== Shop for Products ===\n"
					+ "1. View All Products\n"
					+ "2. Add Clothing to Cart\n"
					+ "3. Add Electronics to Cart\n"
					+ "4. Back to Main Menu\n"
					+ "Your Choice: ");
			
			try {
				input = sc.nextInt();
			} catch (Exception e) {
				input = -1;
				System.out.println("Must be Integer[!]");
			}
			sc.nextLine();
			
			switch(input) {
			case 1:
				System.out.println("\n\n=== View All Products ===");
				System.out.println("ID | Product Name | Price | Availability");
				for(Product P : products) {
					System.out.print(P.productId + " | " + P.productName + " | " + P.price + " | " );
					if(P.isAvailable()) {
						System.out.println("In Stock");
					}
					else {
						System.out.println("Out of Stock");
					}
					
					if (P instanceof Clothing) {
						System.out.println(((Clothing)P).quantityInStock);
					}else {
						System.out.println(((Electronics)P).warrantyPeriod);
					}
				}
				System.out.println("\nPress Enter to go back to Shop for Products Menu...");
				sc.nextLine();
				break;
			case 2:
				addProduct = "";
				doneAdding = false;
				System.out.println("\n\n=== Add CLothing to Cart ===");
				System.out.println("ID | Clothing Name | Price | Size | Availability");
				for(Product P : products) {
					if(P instanceof Clothing) {
						System.out.print(P.productId + " | " + P.productName + " | " + P.price + " | " + ((Clothing)P).size + " | ");
						if(P.isAvailable()) {
							System.out.println("In Stock");
						}
						else {
							System.out.println("Out of Stock");
						}
					}
				}
				do{
					doneAdding = false;
					System.out.print("\nEnter the ID to add to your cart (or type 'back' to go back): ");
					addProduct = sc.nextLine();
					for(Product P : products) {
						if(addProduct.equalsIgnoreCase(P.productId) && P.isAvailable()) {
							CurrentUser.cart.add(P);
							doneAdding = true;
						}
					}
				} while(!doneAdding && !addProduct.equalsIgnoreCase("back"));
				break;
			case 3:
				addProduct = "";
				doneAdding = false;
				System.out.println("\n\n=== Add Electronics to Cart ===");
				System.out.println("ID | Electronics Name | Price | Brand | Availability");
				for(Product P : products) {
					if(P instanceof Electronics) {
						System.out.print(P.productId + " | " + P.productName + " | " + P.price + " | " + ((Electronics)P).brand + " | ");
						if(P.isAvailable()) {
							System.out.println("In Stock");
						}
						else {
							System.out.println("Out of Stock");
						}
					}
				}
				do{
					doneAdding = false;
					System.out.print("\nEnter the ID to add to your cart (or type 'back' to go back): ");
					addProduct = sc.nextLine();
					for(Product P : products) {
						if(addProduct.equalsIgnoreCase(P.productId) && P.isAvailable()) {
							CurrentUser.cart.add(P);
							doneAdding = true;
						}
					}
				} while(!doneAdding && !addProduct.equalsIgnoreCase("back"));
				break;
			}
		} while(input != 4);
	}
	
	static void displayCartMenu() {
		int total = 0;
		int input = -1;
		do {
			System.out.print("\n\n=== View Shopping Cart ===\n"
					+ "1. View Cart Contents\n"
					+ "2. Checkout\n"
					+ "3. Back to Main Menu\n"
					+ "Your Choice: ");
			try {
				input = sc.nextInt();
			} catch (Exception e) {
				input = -1;
				System.out.println("Must be Integer[!]");
			}
			sc.nextLine();
			
			switch(input) {
			case 1:
				total = 0;
				System.out.println("\n\n=== View Cart Contents ===");
				System.out.println("ID | Product Name | Price");
				for(Product P : CurrentUser.cart) {
					System.out.println(P.productId + " | " + P.productName + " | " + P.price);
					total += P.price;
				}
				System.out.println("Total Price: $" + total);
				System.out.println("Press Enter to go back to View Shopping Cart Menu...");
				sc.nextLine();
				break;
			case 2:
				String choice = "";
				total = 0;
				System.out.println("\n\n=== Checkout ===");
				System.out.println("Review your order:");
				System.out.println("ID | Product Name | Price");
				for(Product P : CurrentUser.cart) {
					System.out.println(P.productId + " | " + P.productName + " | " + P.price);
					total += P.price;
				}
				System.out.println("Total Price: $" + total);
				do {
					System.out.println("Do you want to proceed with the checkout? (Y/N):");
					choice = sc.nextLine();
				} while(!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N"));
				
				if(choice.equalsIgnoreCase("Y")) {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
					LocalDateTime now = LocalDateTime.now();  

					
					Order newOrder = new Order(orderNumber,dtf.format(now),"Process");
					for(Product P : CurrentUser.cart) {
						newOrder.orderItems.add(P);
					}
					CurrentUser.cart.clear();
					CurrentUser.orders.add(newOrder);
					newOrder.processOrder();
					System.out.println("Order has been placed");
					int currentOrder = Integer.parseInt(orderNumber) + 1;
					orderNumber = Integer.toString(currentOrder);
				}
				break;
			}
		} while(input != 3);

	}
	
	static void displayOrdersMenu() {
		int input = -1;
		do {
			System.out.print("\n\n=== View Orders ===\n"
					+ "1. View Order History\n"
					+ "2. Track Order\n"
					+ "3. Back to Main Menu\n"
					+ "Your Choice: ");			
			try {
				input = sc.nextInt();
			} catch (Exception e) {
				input = -1;
				System.out.println("Must be Integer[!]");
			}
			sc.nextLine();
			
			switch(input) {
			case 1:
				String viewOrder = "";
				int sum = 0;
				do {
					System.out.println("\n\n===View Order History ===");
					System.out.println("Order ID | Order Date | Total Price");
					for(Order O : CurrentUser.orders) {
						sum = 0;
						System.out.print(O.orderId + " | " + O.orderDate + " | ");
						for(Product P : O.orderItems){
							sum += P.price;
						}
						System.out.println("$" + sum);
					}
					boolean orderIsThere = false;
					do {
						orderIsThere = false;
						viewOrder = "";
						System.out.println("Enter the Order ID to view details (or type 'back' to go back): ");
						viewOrder = sc.nextLine();
						for(Order O : CurrentUser.orders) {
							if(O.orderId.equalsIgnoreCase(viewOrder)) {
								orderIsThere = true;
								System.out.println("\n\n === Order Details ===");
								System.out.println("Order ID : " + O.orderId);
								System.out.println("Order Date : " + O.orderDate);
								sum = 0;
								for(Product P : O.orderItems){
									sum += P.price;
								}
								System.out.println("Total Price : $" + sum );
								
								System.out.println("\n\n Order Items: ");
								System.out.println("ID | Product Name | Price");
								for(Product P : O.orderItems) {
									System.out.println(P.productId + " | " + P.productName + " | " + P.price);
								}
								System.out.println("Press Enter to go back to View Order History...");
								sc.nextLine();
							}
						}
					}while(!orderIsThere && !viewOrder.equalsIgnoreCase("Back"));
				}while(!viewOrder.equalsIgnoreCase("Back"));
				break;
			case 2:
				String viewTracking = "";
				do {
					viewTracking = "";
					System.out.println("\n\n=== Track Order ===");
					System.out.print("Enter the Order ID to track (or type 'back' to go back): ");
					viewTracking = sc.nextLine();
					for(Order O : CurrentUser.orders) {
						if(O.orderId.equalsIgnoreCase(viewTracking)) {
							System.out.println("\n\n=== Order Tracking ===");
							System.out.println("Order ID : " + O.orderId);
							System.out.println("Order Status : " + O.Status + "\n");
							
							System.out.println("Press Enter to go back to Track Order Menu...");
							sc.nextLine();
						}
					}
					
				}while(!viewTracking.equalsIgnoreCase("Back"));
			
				
				break;
			}
		} while(input != 3);
		

	}
	
	static void displayCustomerInfo() {
		System.out.print("\n\n=== Customer Info ===\n"
				+ "Customer ID : "  + CurrentUser.userId
				+ "\nUsername    : " + CurrentUser.username
				+ "\nEmail       : " + CurrentUser.email
				+ "\nAddress     : " + CurrentUser.address
				+ "\nPress Enter to back to Main Menu...");
		sc.nextLine();
	}

}
