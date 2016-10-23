package br.com.myproject.patterns.decorator;

/**
 * Classe concreta que adiciona um COMPORTAMENTO ao Item
 * e recebe no construtor o Item, que é a interface que o
 * ItemExtras implementa.
 * 
 * Obrigatório ter explicitamente um construtor com o Item
 * que esta sendo usado na classe Abstrata
 * 
 * @see ItemExtras
 * @author aldosilva
 *
 */
public class GiftPack extends ItemExtras {

	public GiftPack( Item item ) {
		super( item );
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getPrice() {
		return 15 + super.getPrice();
	}
}
