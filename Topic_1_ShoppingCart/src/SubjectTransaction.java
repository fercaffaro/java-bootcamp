import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Observer Pattern, Transaction is the Subject and MailList the observer
 * Singleton Pattern, all the items uses the same Subject.
 * */
public class SubjectTransaction implements Subject{
	
	private static SubjectTransaction singleton = null;
	private static Set<Observer> observers;
	
	private SubjectTransaction() {
		observers = new HashSet<Observer>(); 
	}

	public static SubjectTransaction getInstance() {
		if (singleton == null) {
			singleton = new SubjectTransaction();
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
