public class Customer {

	private String name;
	private String surname;
	private String user;
	private String password;
	private String addressName;
	private int addressNumber;
	private String email;
	private ShoppingCart cart; 
	

	public Customer() {
		name = "";
		surname = "";
		user = "";
		password = "";
		addressName = "";
		addressNumber = 123;
		email = "";
		cart = new ShoppingCart();
	}

	public Customer(String name, String surname, String user, String password, String addressName, int addressNumber, String email) {
		this.name = name;
		this.surname = surname;
		this.user = user;
		this.password = password;
		this.addressName = addressName;
		this.addressNumber = addressNumber;
		this.email = email;
		cart = new ShoppingCart();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public int getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(int addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Customer info:\n------------------\nname=" + name + ", surname=" + surname + ", user=" + user + ", password=" + password + ", addressName="
				+ addressName + ", addressNumber=" + addressNumber + ", email=" + email + "\n------------------\n";
	}

	
}
