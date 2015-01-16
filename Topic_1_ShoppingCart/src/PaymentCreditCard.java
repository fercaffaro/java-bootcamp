import java.util.ArrayList;

public class PaymentCreditCard implements Payment {

	private String name;
	private int creditNumber;

	public PaymentCreditCard(String name, int creditNumber) {
		this.name = name;
		this.creditNumber = creditNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCreditNumber() {
		return creditNumber;
	}

	public void setCreditNumber(int creditNumber) {
		this.creditNumber = creditNumber;
	}

	@Override
	/* Return the 10% of the summation of all the items*/
	public double getDiscount(ArrayList<ShoppingCartItem> sci) {
		double total = 0;
		for(ShoppingCartItem item: sci){
			total += item.getSubtotalPrice();
		}
		return total*0.1;
	}

	@Override
	public String infoDiscount() {
		return "Discount 10% of the Total";
	}

	@Override
	public String getPaymentType() {
		return "Credit Card";
	}
}
