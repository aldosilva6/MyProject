package br.com.myproject.patterns.chainofresponsability;

/**
 * Filtro Pai
 * 
 * @author aldosilva
 *
 */
public class PaymentProcessorA extends PaymentProcessor {

	@Override
	protected void handle( Payment p ) {
		System.out.println("Payment processor A - First filter");
	}

}
