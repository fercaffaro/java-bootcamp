import java.util.ArrayList;

public class PaymentCash implements Payment {
	
	public PaymentCash() {
	}

	@Override
	/* Return the price of the most expensive Item(product or offer) */
	public double getDiscount(ArrayList<ShoppingCartItem> sci) {
		double mostExpensive = 0;
		for (ShoppingCartItem item : sci) {
			double aux = item.getUnitPrice();
			if (aux > mostExpensive) {
				mostExpensive = aux;
			}
		}
		return mostExpensive*0.9;
	}

	@Override
	public String infoDiscount() {
		return "90% of the most expensive item";
	}

	@Override
	public String getPaymentType() {
		return "Cash";
	}
}
