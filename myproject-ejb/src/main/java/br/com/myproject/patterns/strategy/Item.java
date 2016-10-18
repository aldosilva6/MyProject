package br.com.myproject.patterns.strategy;

public class Item {
	
	private Integer valor;
	

	/**
	 * @param valor
	 */
	public Item( Integer valor ) {
		super();
		this.valor = valor;
	}

	/**
	 * @return the valor
	 */
	public Integer getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	

}
