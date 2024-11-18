package onlineShop;

public class User {
	String userId;
	String username;
	String email;
	
	public User(String userId, String username, String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	void displayUserInfo(){
		System.out.println("UserID = " + this.userId + "\n"
						+ "Username = " +  this.username + "\n"
						+ "Email = " + this.email);
	}
	
	void updateEmail(String newEmail) {
		setEmail(newEmail);
	}
	
	void placeOrder(Order order) {
		
	}
}
