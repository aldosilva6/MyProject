package br.com.myproject.patterns.strategy.types;

public class Taxes {
	
	public static Integer international( Integer value ) {
		return value + 20;
	}

	//other taxes options here

}
