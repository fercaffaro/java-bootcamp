/* Composite Pattern, a Product is the Leaf
 * Item is the Component and Offer the Composite
 */

public class Product implements Item {

	private String name;
	private String detail;
	private double price;


	public Product(String name, String detail, double price) {
		this.name = name;
		this.detail = detail;
		this.price = price;
		
		//This message should be send to the observer when a new product is added to DB
		SubjectItem.getInstance().doNotify("The product: "+name+" has been added to the Data Base");
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		double oldPrice = this.price;
		this.price = price;
		SubjectItem.getInstance().doNotify("The product: "+name+" has changed the price. Old price: $"+oldPrice+" new price: $"+this.price);
	}

	@Override
	public String getInfo(int level) {
		String info = "\n* ";
		for (int i = 0; i <= level; i++) {
			info += "-";
		}
		info += name + ", " + detail + ", $" + price ;
		info = String.format("%-41s%-10s%-13s%-12s*",info,"|","|","|");
		return info;
	}

	@Override
	public int compareTo(Item o) {
		if (o instanceof Offer)
			return -1;
		Product aux = (Product) o;
		return aux.getName().compareTo(this.name);
	}

}
