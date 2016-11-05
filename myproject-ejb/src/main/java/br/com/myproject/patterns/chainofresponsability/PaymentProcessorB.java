package br.com.myproject.patterns.chainofresponsability;


/**
 * Segundo filtro da cadeia, verificar se o cliente pode comprar.
 * 
 * @author aldosilva
 *
 */
public class PaymentProcessorB extends PaymentProcessor {

	@Override
	protected void handle( Payment p ) {
		System.out.println("Payment Processor B - Second filter");
	}

}
