
public class ShoppingCartItem implements Comparable<ShoppingCartItem>{

	private int quantity;
	private Item item;
	

	
	public ShoppingCartItem(Item item, int quantity) {
		super();
		this.quantity = quantity;
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public double getUnitPrice(){
		return item.getPrice();
	}
	
	public double getSubtotalPrice(){
		return item.getPrice()*quantity;
	}

	@Override
	public String toString() {
		return "\n************************************************\nShoppingCartItem quantity=" 
				+ quantity + "\nitem=" + item.toString() + "]";
	}

	@Override
	public int compareTo(ShoppingCartItem o) {
		return item.compareTo(o.getItem());
	}
	
}
