package br.com.myproject.patterns.strategy;

public class PaymentsTypes {
	
	
	public static Integer money( int amount ){
		amount += 5;
		System.out.println("Pay with money: " + amount );
		return amount;
	}
	
	public static Integer debit( int amount ){
		amount += 7;
		System.out.println("Pay with debit: " + amount );
		return amount;
	}
	
	public static Integer credit( int amount ){
		amount += 10;
		System.out.println("Pay with credit card: " + amount );
		return amount;
	}

}
