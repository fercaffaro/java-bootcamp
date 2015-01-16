import java.text.SimpleDateFormat;
import java.util.Date;

/* Used by the Market Manager to know when
 * A new item/offer is added
 * A price is changed
 * A new transaction was made
 * Design pattern used Observer
 * */

public class MailList implements Observer{
	
	private String history ="";

	public MailList() {
	}
	
	@Override
	public void doUpdate(String message) {
		Date now = new Date();
		String dateMessage = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(now);
		String historyMessage = "\n"+dateMessage+"  "+message;
		history += historyMessage;
		//System.out.print(historyMessage);//This message should be send to Market Manager at the moment
		
	}
	

	public String getHistory() {
		return history;
	}

}
