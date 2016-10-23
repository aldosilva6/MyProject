package br.com.myproject.patterns.strategy;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.com.myproject.enums.PaymentMethod;

public class ShoppingCartTest {
	
	ShoppingCart cart;
	
	@Before
	public void setup() {
		Item item1 = new Item( 10 );
		Item item2 = new Item( 20 );
		
		cart = new ShoppingCart( Arrays.asList( item1, item2 ) );
	}
	
	@Test
	public void testTotalCart() {
		assertEquals( 2, cart.getItems().size() );
	}
	
	@Test
	public void testTotalValor() {
		assertEquals( 40, cart.payOld( PaymentMethod.CREDIT ).intValue() );
		assertEquals( 35, cart.payOld( PaymentMethod.MONEY ).intValue() );
	}
	
	@Test
	public void testTotalValorNew() {
		assertEquals( 40, cart.payNew( new CreditCard() ).intValue() );
		assertEquals( 35, cart.payNew( new Money() ).intValue() );
	}
	
	/**
	 * @since 1.8
	 */
	@Test
	public void testTotalValorNewJava() {
		assertEquals( 40, cart.pay( PaymentsTypes::credit ).intValue() );
		assertEquals( 35, cart.pay( PaymentsTypes::money ).intValue() );
	}

}
