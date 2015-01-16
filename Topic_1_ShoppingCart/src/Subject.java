//Observer Pattern used with Item(Offer and Product) and Transaction
public interface Subject {

	public void addObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void doNotify(String message);

}