package labTerminalB;

import java.util.Enumeration;
import java.util.Vector;

public class Customer 
        {
		private String _name;
		private Vector<Rental> _rentals = new Vector<Rental>();
		public Customer (String name){
			_name = name;
		};
		public void addRental(Rental arg) {
			_rentals.addElement(arg);
		}
		public String getName (){
			return _name;
		};
		
		/*
		 * TODO 4		20 Marks
		 * Identify the bad smells in the statement method and refactor the code
		 * In case you add a new method also provide specifications for new method
		 * after refactoring all test cases must still be passed
		 * Commit after each change and include a meaningful message about the change you made
		 * e.g. Method Move methodName();
		 * 
		 */
		
		
		/**
		 * TODO 3		10 Marks
		 * Provide suitable specification for statement method 
		 * @param nothing
		 * @return   total bill.
		 * This method constructing  statement  name of person.movies being rented, rental of that person.  
		 * @return  statement 
		 *  name of all movies which are being rented by that person
		 * calculate prices, and rental points of that person.
		 * 
		
	    */
		
		
		public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		String TotalBill = "Rental Record for " + getName() + "\n";
		
		while (rentals.hasMoreElements()) {
			
			Rental Rent = (Rental) rentals.nextElement();
		     	//determine amounts for each line
			
			double FrequentAmount = Rent.movie();
			     // add frequent renter points
			
			frequentRenterPoints ++;
			    // add bonus for a two day new release rental
			
			if ((Rent.getMovie().getPriceCode() == Movie.NEW_RELEASE)&&Rent.getDaysRented() > 1) frequentRenterPoints ++;
			   //show figures for this rental
			
			TotalBill += "\t" + Rent.getMovie().getTitle()+ "\t" +String.valueOf(FrequentAmount) + "\n";
			totalAmount += FrequentAmount;
		}
		
		 //add footer lines
		 TotalBill += "Amount owed is " + String.valueOf(totalAmount) +"\n";
		 TotalBill += "You earned " + String.valueOf(frequentRenterPoints)+" frequent renter points";
		 
		return TotalBill;
	}
}


