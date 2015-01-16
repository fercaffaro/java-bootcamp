/*Composite Pattern, an Offer is the Composite
 */

import java.util.ArrayList;
import java.util.List;

public class Offer implements Item {

	private double price;
	private String name;
	private List<Item> offerItems;

	public Offer(String name){
		this.name = name;
		price = 0;
		offerItems = new ArrayList<Item>();
		//This message should be send to the observer when a new product is added to DB
		SubjectItem.getInstance().doNotify("The offer: "+name+" has been added to the Data Base");
	}

	@Override
	public String getName() {
		return name;
	}

	public void add(Item item) {
		offerItems.add(item);
	}

	public void remove(Item item) {
		offerItems.remove(item);
	}

	public List<Item> getComponents() {
		return offerItems;
	}

	public Item getComponent(int index) {
		return offerItems.get(index);
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
	//level is the level of the tree
	public String getInfo(int level) {
		String info = "";
		if (level > 0) {
			info = "\n* ";
			for (int i = 0; i <= level; i++) {
				info += "-";
			}
			info += name + ", $" + price;
			info = String.format("%-41s%-10s%-13s%-12s*",info,"|","|","|");
		}
		for (Item item : offerItems) {
			info += item.getInfo(level + 1);
		}
		return info;
	}

	@Override
	public int compareTo(Item o) {
		if (o instanceof Product)
			return -1;
		Offer aux = (Offer) o;
		return aux.getName().compareTo(this.name);
	}

}