package br.com.myproject.patterns.chainofresponsability;

public class Payment {

	int value;

	public Payment( int value ) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue( int value ) {
		this.value = value;
	}
	
	
}
