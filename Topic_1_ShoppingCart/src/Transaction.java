public class Transaction {
	
	private long id;
	private Customer customer;
	private Payment payment;
	private ShoppingCart shCart;
	
	public Transaction(Customer customer, Payment payment, ShoppingCart shCart) {
		super();
		this.customer = customer;
		this.payment = payment;
		this.shCart = shCart;
		TransactionNumber singleton = TransactionNumber.getInstance();
		this.id = singleton.getUniqueNumber();
	}
	
	public long getId(){
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public double getDiscount(){
		return payment.getDiscount(shCart.getCartItemList());
	}
	
	public double getSubTotal(){
		return shCart.getTotalWithoutDiscount();
	}
	
	public String getReceipt(){
		String receipt = "\n****************************************************************************";
		receipt += String.format("%-18s%-27d%-30s*","\n* Transaction n°: ",id, "Paymode: "+payment.getPaymentType());
					
		receipt +=	"\n* Name: " + customer.getSurname() + " " + customer.getName() + "\t\t\t\t\t\t\t   *"
						+"\n* Address: " + customer.getAddressNumber() + " " + customer.getAddressName() + " street.\t\t\t\t\t\t   *"
						+"\n****************************************************************************"
						+"\n* Cart Items\t\t\t\t|Quantity | Item price | Item Total*";
						
		receipt += shCart.getItemInfo();
		receipt += "\n*--------------------------------------------------------------------------*";
		double subTotal = getSubTotal();
		receipt += String.format("%-64s%1s%11.2f","\n* Sub Total: ","|",subTotal); 
		receipt += "*\n*--------------------------------------------------------------------------*";
		double discount = getDiscount()*-1;
		receipt += String.format("%-64s%1s%11.2f","\n* Paymode Discount: "+payment.infoDiscount(),"|",discount); 
				
		receipt += "*\n*--------------------------------------------------------------------------*";
		 
		receipt += String.format("%-64s%1s%11.2f","\n* Total: ","|",subTotal-discount); 
		receipt += "*\n*--------------------------------------------------------------------------*";
		return receipt;
	}

	public void commit(){
		SubjectItem.getInstance().doNotify("New Transacction has been made. Transaction n: "+id);
	}

}
