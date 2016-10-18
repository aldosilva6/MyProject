package br.com.myproject.patterns.strategy;

public class CreditCard implements Payment {

	@Override
	public Integer pay( int amount ) {
		amount += 10;
		System.out.println( "Pay with credit card " + amount );
		
		return amount;
	}

}
