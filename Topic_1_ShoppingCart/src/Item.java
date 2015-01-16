/* Composite Pattern, an Item is the Component, 
 * Product the Leaf and Offer the Composite.
 */

public interface Item extends Comparable<Item>{
	
	public void setPrice(double price);
	public double getPrice();
	public String getName();
	public String getInfo(int level);//level is used to know the level of the item in the tree

}
