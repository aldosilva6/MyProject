package br.com.myproject.patterns.chainofresponsability;

/**
 * Terceiro filtro da cadeia, verifica se cliente não tem problema no SPC
 * 
 * @author aldosilva
 *
 */
public class PaymentProcessorC extends PaymentProcessor {

	@Override
	protected void handle(Payment p) {
		System.out.println("Payment processor C - Third filter");
	}

}
