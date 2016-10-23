package br.com.myproject.patterns.decorator;

public class InternationalDelivery extends ItemExtras {
	
	public InternationalDelivery( Item item ) {
		super( item );
		// TODO Auto-generated constructor stub
	}
	
	public int getPrice() {
		return 5 + super.getPrice();
	}

}
