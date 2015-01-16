public class Test {

	public static void main(String[] args) {
		
		/*Add the observer(MailList) to the subjects(Product, Info, Transaction)*/
		MailList ml = new MailList();
		SubjectItem itemNotifier = SubjectItem.getInstance();//The item manager for notifications
		itemNotifier.addObserver(ml);//Now the mailList will be notified when an item is created or the price is updated
		SubjectTransaction transactionNotifier = SubjectTransaction.getInstance();//The item manager for notifications
		transactionNotifier.addObserver(ml);//Now the mailList will be notified when a transaction is committed
		
		


		/* Creates 3 products (leaf in composite pattern) */
		Product  p1 = new Product("PC","3GB Ram", 5500);
		Product  p2 = new Product("Desk","oak", 3000);
		Product  p3 = new Product("Chair","ergonomic", 1500);
		
		/* Creates an Offer (composite in composite pattern)
		 * the offer consists in a desk and a chair for $4000(regular price $4500)
		*/
		Offer offer1 = new Offer("Combo 1");
		offer1.add(p2);
		offer1.add(p3);
		offer1.setPrice(4000);

		/* Offers the offer 1 and a PC for $8000 (regular price $9500)*/
		Offer offer2 = new Offer("Combo 2");
		offer2.setPrice(8000);
		offer2.add(offer1);//$4000
		offer2.add(p1);//$5500

		/* Shows the product's and offer's info*/
//		System.out.println("Product 1: "+p1.toString());
//		System.out.println("Product 2: "+p2.toString());
//		System.out.println("Product 3: "+p3.toString());
//		System.out.println("\n\noffer 1: \n"+offer1.toString());
//		System.out.println("\n\noffer 2: \n"+offer2.toString());
	

		/*Creates a Shopping Cart*/
		ShoppingCart shCart = new ShoppingCart();
		shCart.addCartItem(p1, 3); //adds 3 product1
		shCart.addCartItem(offer2, 1);//adds 1 offer2
		shCart.addCartItem(p1, 2);//update p1 quantity to 2
		shCart.addCartItem(offer1, 2);//update offer1 quantity to 2
		shCart.addCartItem(offer2, 3);//update offer2 quantity to 2
//		System.out.println("\n\nShoppingCart : \n"+shCart.toString());
		
		/*Select the Payment (Strategy)
		 * example
		 * p1= $5500 x 2 = $11000
		 * offer1 = $4000 x 2 = $8000 (cheapest $4000)
		 * offer2 = $8000 x 3 = $24000 most expensive
		 * 
		 * Total = $43000
		 * CashDiscount = $8000x0,9 = $7200
		 * CreditCardDiscount = 10% of $43000.0 = $4300.0
		 * Paypal = $4000
		 * */
		Customer customer = new Customer("John","Smith","user","pass","Belgrano",123,"j.smith@mail.com");
		//Payment payment = new PaymentCash(); //use this for Cash discount
		Payment payment = new PaymentCreditCard("John Smith",12345); //use this for CreditcCard discount
		//Payment payment = new PaymentPaypal("john.smith@email.com","thepass");//use this for Paypal discount
		Transaction tr = new Transaction(customer, payment,shCart);//creates the transaction with customer, the payment and the items of the shopping cart
		tr.commit();//To confirm the transaction, this notifies the observers
		System.out.println(tr.getReceipt()); //Print the receipt of the transaction
//		payment = new PaymentPaypal("john.smith@email.com","thepass");//use this for Paypal discount
//		tr = new Transaction(customer, payment,shCart);//creates the transaction with customer, the payment and the items of the shopping cart		
//		System.out.println(tr.getReceipt()); //Print the receipt of the transaction
//		payment = new PaymentCash(); //use this for Cash discount
//		tr = new Transaction(customer, payment,shCart);//creates the transaction with customer, the payment and the items of the shopping cart		
//		System.out.println(tr.getReceipt()); //Print the receipt of the transaction
		
		//Now shows the mailList history
		System.out.println("\n\nMail List History:\n"+ml.getHistory());
	}

}
