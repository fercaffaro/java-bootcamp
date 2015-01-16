/*Design Pattern Singleton used to create an unique number for the transactions*/
public class TransactionNumber {

	private static TransactionNumber singleton = null;
	private static long uniqueNumber;

	private TransactionNumber() {
		uniqueNumber = 0;
	}

	public static TransactionNumber getInstance() {
		if (singleton == null) {
			singleton = new TransactionNumber();
		}
		return singleton;
	}

	public long getUniqueNumber() {
		uniqueNumber++;
		return uniqueNumber;
	}
}