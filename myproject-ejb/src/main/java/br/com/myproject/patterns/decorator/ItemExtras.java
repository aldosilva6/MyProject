package br.com.myproject.patterns.decorator;

/**
 * Classe abstrata que sobreescreve o método getPrice da interface,
 * usando na implementação como referência o Item.
 * 
 * Cria-se uma classe abstrata implementando a interface com o método que
 * será DECORADO e usa-se na implementação do método a referencia para a interface.
 * 
 * Quando for criar um objeto que DECORA o Item com algum novo COMPORTAMENTO
 * eu herdo de ItemExtras, pois através do metódo getPrice eu consigo adicionar
 * um comportamento ao Item.
 * 
 * O pulo do gato é a referência para a interface que é recebia pelo construtor.
 * 
 * @see Item
 * @author aldosilva
 *
 */
public abstract class ItemExtras implements Item {
	
	private Item item;
	
	public ItemExtras( Item item ) {
		super();
		this.item = item;
	}

	@Override
	public int getPrice() {
		return item.getPrice();
	}
}
