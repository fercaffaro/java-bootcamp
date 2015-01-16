import java.util.ArrayList;

public class PaymentPaypal implements Payment {

	private String email;
	private String password;

	public PaymentPaypal(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	/* Return the price of cheapest Item(product or offer) in the cart*/
	public double getDiscount(ArrayList<ShoppingCartItem> sci) {
		double cheapest = 0;
		ShoppingCartItem item = (ShoppingCartItem) sci.get(0);
		cheapest = item.getUnitPrice();
		for (int i = 1; i < sci.size(); i++) {
			item = (ShoppingCartItem) sci.get(i);
			double aux = item.getUnitPrice();
			if (aux < cheapest) {
				cheapest = aux;
			}
		}
		return cheapest;
	}

	@Override
	public String infoDiscount() {
		return "The cheapest item is for free";
	}
	
	@Override
	public String getPaymentType() {
		return "Paypal";
	}

}
