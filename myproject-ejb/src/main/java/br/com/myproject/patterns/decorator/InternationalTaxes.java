package br.com.myproject.patterns.decorator;

public class InternationalTaxes extends ItemExtras {

	public InternationalTaxes( Item item ) {
		super(item);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getPrice() {
		return 20 + super.getPrice();
	}
}
