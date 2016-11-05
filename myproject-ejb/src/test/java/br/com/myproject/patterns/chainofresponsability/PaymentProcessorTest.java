package br.com.myproject.patterns.chainofresponsability;

import org.junit.Test;

public class PaymentProcessorTest {
	
	@Test
	public void testPaymentProcessor() {
		PaymentProcessor paymentProcessor = getPaymentProcessor();
		
		//Não faz diferença a quantidade de processos da cadeia, o cliente
		//somente sabe do método process
		paymentProcessor.process( new Payment( 10 ) );
	}

	private static PaymentProcessor getPaymentProcessor() {
		PaymentProcessor pai = new PaymentProcessorA();
		
		pai.setNext( new PaymentProcessorB() );
		pai.setNext( new PaymentProcessorC() );
		
		return pai;
	}
}
