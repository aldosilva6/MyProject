package br.com.myproject.patterns.decorator;

/**
 * Um produto que implementa o Item
 * 
 * @see Item
 * @author aldosilva
 *
 */
public class Book implements Item {
	
	private int price;

	public Book( int price ) {
		super();
		this.price = price;
	}

	@Override
	public int getPrice() {		
		return price;
	}
	
	

}
