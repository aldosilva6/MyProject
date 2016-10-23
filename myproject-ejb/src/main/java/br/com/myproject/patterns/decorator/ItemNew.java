package br.com.myproject.patterns.decorator;

import java.util.function.Function;
import java.util.stream.Stream;

public class ItemNew {
	
	private int price;

	private Function<Integer, Integer>[] itemExtras = new Function[]{}; 
	
	public ItemNew( int price ) {
		super();
		this.price = price;
	}
	
	public ItemNew( int price, @SuppressWarnings("unchecked") Function<Integer, Integer>... itemExtras ) {
		this.price = price;
		this.itemExtras = itemExtras;
	}
	
	/**
	 * Percorre a lista de items extras e aplica ele + ele mesmo
	 * 
	 * @return <em>price + itemExtra +  itemExtra ........</em>
	 */
	public int getPrice() {
		int priceWithExtra = this.price;
		for ( Function<Integer, Integer> itemExtra : itemExtras ) {
			priceWithExtra = itemExtra.apply( priceWithExtra );
		}
		return priceWithExtra;
	}
	
	
	/**
	 * 
	 * {@code reduce} - Coloca um monte de coisa que esta no {@code Stream} para
	 * um único item. 
	 * <p>
	 * Primeiro parâmetro é: O que devo fazer com o primeiro item?
	 * Segundo parâmetro é: Se tiver 2 funções o que devo fazer?
	 * </p>
	 * 
	 * {@code Function.identity()} função que recebe x e retorna x. Se tiver só 
	 * uma função nos itemsExtras irá retornar só ela.
	 * {@code Function::andThen } o que deve fazer com cada uma das sequências do Stream
	 * andThen apply compose
	 * 
	 * @return <em>price + itemExtra +  itemExtra ........</em>
	 */
	public int getPriceReduce() {
		Function<Integer, Integer> extras = Stream.of( itemExtras ).reduce( Function.identity(), Function::andThen );
		
		return extras.apply( price );
	}
	
	public void setItemExtras( @SuppressWarnings("unchecked") Function<Integer, Integer> ...itemExtras ) {
		this.itemExtras = itemExtras;
	}
}
