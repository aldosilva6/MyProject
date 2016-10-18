package br.com.myproject.patterns.strategy;

public class Money implements Payment {

	@Override
	public Integer pay( int amount ) {
		amount += 5;
		System.out.println( "Pay with Money " + amount );
		
		return amount;
	}

}
