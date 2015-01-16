import java.util.ArrayList;


public interface Payment {

	public double getDiscount(ArrayList<ShoppingCartItem> sci); //return the mount of the discount
	public String infoDiscount(); //Return the motive of the discount
	public String getPaymentType();//Return the type of Payment
}
