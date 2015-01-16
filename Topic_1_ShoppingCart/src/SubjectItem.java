import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Observer Pattern, Item is the Subject and MailList the observer
 * Singleton Pattern, all the items uses the same Subject.
 * */
public class SubjectItem implements Subject{
	
	private static SubjectItem singleton = null;
	private static Set<Observer> observers;
	
	private SubjectItem() {
		observers = new HashSet<Observer>(); 
	}

	public static SubjectItem getInstance() {
		if (singleton == null) {
			singleton = new SubjectItem();
		}
		return singleton;
	}

	@Override
	//From Observer Pattern
	public  void addObserver(Observer observer) {
		observers.add(observer);	
	}

	@Override
	//From Observer Pattern
	public void removeObserver(Observer observer) {
		observers.remove(observer);
		
	}

	@Override
	//From Observer Pattern
	public void doNotify(String message) {
		Iterator<Observer> it = observers.iterator();
		while (it.hasNext()) {
			Observer observer = it.next();
			observer.doUpdate(message);
		}
		
	}

}
