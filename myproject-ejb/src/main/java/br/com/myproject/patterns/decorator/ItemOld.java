package br.com.myproject.patterns.decorator;

/**
 * Decorator: "Dinamicamente, agregar responsabilidades adicionais aos objetos.
 * Os Decorators fornecem uma alternativa flexível ao uso de subclasses para 
 * extensão de funcionalidades.
 * 
 * 
 * Problema: ItemInternacional extends Item. ItemInternacionalComImposto extends Item.
 * ItemExpress extends Item. Quando se quer internacional e Expresse criava-se 
 * ItemInternacionalAndExpresse extends Item. Começa-se a criar toda uma hierarquia 
 * de classe por conta da diferença de preços entre os tipos de Item.
 * 
 * @author aldosilva
 *
 */
public class ItemOld {
	
	private int price;
	

	public ItemOld( int price ) {
		super();
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
