package br.com.myproject.patterns.executearound;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.myproject.patterns.executearound.util.OpenFileUtils;

public class OpenFileTest {

	@Test
	public void testReadFileOld() {
		OpenFile openFile = new OpenFile();
		assertEquals( "Sucesso", openFile.readFileOld( "/home/aldosilva/Files/javaFile.txt") );
	}
	
	
	@Test
	public void testReadFileJavaSeven() {
		OpenFile openFile = new OpenFile();
		assertEquals( "Sucesso", openFile.readFileJavaSeven( "/home/aldosilva/Files/javaFile.txt") );
	}
	
	@Test
	public void testReadFileExecuteAround() {
		OpenFile openFile = new OpenFile();
		assertEquals( "Sucesso", openFile.readFileJavaEight( OpenFileUtils::readFileExecuteAround, "/home/aldosilva/Files/javaFile.txt" ) );
	}

}
