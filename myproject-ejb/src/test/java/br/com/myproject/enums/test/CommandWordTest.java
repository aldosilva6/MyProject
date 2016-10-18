package br.com.myproject.enums.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import br.com.myproject.enums.CommandWord;

public class CommandWordTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testName() {
		CommandWord commandWord = CommandWord.GO;
		
		assertEquals("GO", commandWord.name());
	}
	
	@Test
	public void testSwitchCase() {
		CommandWord commandWord = CommandWord.TAKE;

		String resultado = null;
		
		switch (commandWord) {
			case GO:
				resultado = commandWord.toString();
				System.out.println("Case GO");
				break;
			case LOOK:
				resultado = commandWord.name();
				System.out.println("Case LOOK");
				break;
			case TAKE:
				resultado = commandWord.name();
				System.out.println("Case TAKE");
				break;
			case HELP:
				resultado = commandWord.name();
				System.out.println("Case HELP");
				break;
			case QUIT:
				resultado = commandWord.name();
				System.out.println("Case QUIT");
				break;
		}
		
		assertEquals("GO", resultado);
		
	}
	
	@Test
	public void testNameAndOrdinal() {
		CommandWord commandWord = CommandWord.LOOK;
		
		assertEquals("LOOK", commandWord.name());
		assertEquals(12, commandWord.ordinal());
	}
	
	@Test
	public void testValues() {
		CommandWord[] cvValues = CommandWord.values();
		
		for (CommandWord commandWord : cvValues) {
			System.out.println("Old:" + commandWord);
		}
		
		assertTrue("Comparando os valores", cvValues.length == 2);
	}
	
	@Test
	public void testValuesJava8 () {
		CommandWord[] cvValues = CommandWord.values();
		
		Arrays.stream(cvValues).forEach(System.out::println);

		
		assertTrue("Comparando os valores", cvValues.length == 5);
	}
	
	
	@Test
	public void testNewSwitchCase() {
		CommandWord commandWord = CommandWord.GO;
		
		assertEquals("GO", commandWord.execute());
	}
}
