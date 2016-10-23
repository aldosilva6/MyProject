package br.com.myproject.patterns.decorator;

import static org.junit.Assert.*;

import java.util.function.Function;

import org.junit.Test;

import br.com.myproject.patterns.strategy.types.Packing;
import br.com.myproject.patterns.strategy.types.Taxes;

public class DecoratorPriceTest {
	
	@Test
	public void testPrice() {
		Book book = new Book( 10 );
		assertEquals( 10 , book.getPrice() );
		
		//GiftPack = 15
		//InternationalTaxa = 20
		//InternationalDelivery = 5
		//Book + Taxa Internacional
		InternationalTaxes internationalTaxes = new InternationalTaxes( book );
		assertEquals( 30, internationalTaxes.getPrice() );
		
		//Book + Taxa de Entrega Internacional
		InternationalDelivery internationalDelivery = new InternationalDelivery( book );
		assertEquals( 15 , internationalDelivery.getPrice() );
		
		//Com DECORATOR	conseguimos adicionar comportamentos a qualquer classe que extend de Item
		//Book + Taxa Internacional + Taxa de Entrega Internacional + Taxa de embrulho para presente
		GiftPack giftPack = new GiftPack( new InternationalTaxes( new InternationalDelivery( book ) ) );
		assertEquals( 50, giftPack.getPrice() );
	}
	
	/**
	 * Adiciona comportamentos aos objetos sem ter que criar nenhuma classe
	 * 
	 * @since 1.8
	 */
	@Test 
	public void testPriceNewJava() {
		Book book = new Book( 10 );
		assertEquals( 10 , book.getPrice() );
		
		Function<Integer, Integer> internationalTaxes = value -> value + 20;
		assertEquals( 30, internationalTaxes.apply( book.getPrice() ).intValue() );
		
		Function<Integer, Integer> internationalDelivery = value -> value + 5;
		assertEquals( 15, internationalDelivery.apply( book.getPrice() ).intValue() );
		
		Function<Integer, Integer> giftPack = value -> value + 15;
		assertEquals( 50, giftPack.andThen( internationalTaxes ).andThen( internationalDelivery ).apply( book.getPrice() ).intValue() );
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPriceNewJavaEvenBetter() {
		//Fica muito mais legível o que estou adicionando ao item
		ItemNew book = new ItemNew( 10, Taxes::international, Packing::giftPacking );
		
		//GiftPack = 15
		//InternationalTaxa = 20
		//book.setItemExtras( Taxes::international, Packing::giftPacking );
		
		assertEquals( 45, book.getPrice() ); //Get price percorrendo os preços via for
		assertEquals( 45, book.getPriceReduce() ); //Get price percorrendo os preços via for
	}
}
