import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class ShoppingCart {
	
	private int id;
	private Date expirationDate; 
	private ArrayList<ShoppingCartItem> cartItemList;
	
	public ShoppingCart() {
		this.id = 0;
		
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, 30); //the ShoppingCart will live only 30 minutes
		this.expirationDate = now.getTime();
		
		this.cartItemList = new ArrayList<ShoppingCartItem>();
	}
	
	public ShoppingCart(int id, Date expirationDate, ArrayList<ShoppingCartItem> cartItemList) {
		this.id = id;
		this.expirationDate = expirationDate;
		this.cartItemList = cartItemList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy : HH:mm");
		String aux = "expirationDate = " + dateFormat.format(expirationDate);
		for (ShoppingCartItem cartItem : cartItemList) {
			aux += cartItem.toString();
		}
		return aux;
	}

	public ArrayList<ShoppingCartItem> getCartItemList() {
		return cartItemList;
	}

	/*
	 * Add a cart item if is new Update the cart item if exists
	 */
	public void addCartItem(Item item, int quantity) {
		int index = -1;
		ShoppingCartItem sci;
		for (int i = 0; i < cartItemList.size(); i++) {
			sci = (ShoppingCartItem) cartItemList.get(i);
			index = sci.getItem().compareTo(item);
			if (index >= 0) {
				// there is an item item in the cart, I update
				sci.setQuantity(quantity);
				break;
			}
		}
		if (index < 0) {
			// there is no item in the cart, I add the item
			this.cartItemList.add(new ShoppingCartItem(item, quantity));
		}
	}
	
	public double getTotalWithoutDiscount(){
		double aux = 0;
		for(ShoppingCartItem sci: cartItemList){
			aux += sci.getSubtotalPrice();
		}
		return aux;
	}
	
	//return the items of the cart as a Item Price String.
	public String getItemInfo(){
		String info = "";
		for (ShoppingCartItem cartItem : cartItemList) {
		
			info += "\n*---------------------------------------|---------|------------|-----------*";
			//Shows ShoppingCart Items
			info += String.format("%-41s%-1s%9d%-1s%12.2f%-1s%11.2f*","\n* "+cartItem.getItem().getName(),"|",cartItem.getQuantity(),"|",cartItem.getUnitPrice(),"|",cartItem.getSubtotalPrice());
			
			//Shows the detail of ShoppingCart Items
			info += cartItem.getItem().getInfo(0);
		}
		
		return info;
	}


}
