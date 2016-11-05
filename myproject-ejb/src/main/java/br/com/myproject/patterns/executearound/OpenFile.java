package br.com.myproject.patterns.executearound;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;

import br.com.myproject.patterns.executearound.util.OpenFileUtils;

/**
 * 
 * Problema: Sempre que abrir uma conexão não esquecer de fechar
 * a conexão no finally. Abrir conexão de banco, abrir arquivo, etc....
 * 
 * Java 7 melhorou com o uso da interface AutoClosable, que faz com que
 * qualquer código que seja usado no try with resource que implementa 
 * essa interface feche automaticamente.
 * 
 * @author aldosilva
 *
 */
public class OpenFile {
	
	public String readFileOld( String fileName ) {
		String retorno = null;
		BufferedReader br = null;
		try {
			
			br = new BufferedReader( new FileReader( fileName ));
			System.out.println( br.readLine() );
			retorno = "Sucesso";
			
		} catch ( FileNotFoundException fnfe ) {
			retorno = "Falha";
			fnfe.printStackTrace();
		} catch ( IOException io ) {
			retorno = "Falha";
			io.printStackTrace();
		} finally {
			try {
				br.close();
			} catch ( IOException e ) {
				retorno = "Falha";
				e.printStackTrace();
			}
		}
		
		return retorno;
	}
	
	/**
	 * Try-with-resources - ARM (Automatic Resource Management)
	 * 
	 * @param fileName
	 * @return
	 */
	public String readFileJavaSeven( String fileName ) {
		String retorno = null;
		try ( BufferedReader br = new BufferedReader( new FileReader( fileName ) ) ) {

			System.out.println( br.readLine() );
			retorno = "Sucesso";
			
		} catch ( FileNotFoundException fnfe ) {
			retorno = "Falha";
			fnfe.printStackTrace();
		} catch ( IOException io ) {
			retorno = "Falha";
			io.printStackTrace();
		}
		
		return retorno;
	}
	
	
	/**
	 * Via passagem de parâmetro com a classe utilitária como referência eu consigo 
	 * deixar por conta da classe com o pattern ExecuteAround fazer o tratamento de 
	 * abertura, execução e fechamento do código
	 * 
	 * @param openFileUtils
	 * @param fileName
	 * @return
	 */
	public String readFileJavaEight( Function<String, String> openFileUtils, String fileName ) {
		String retorno = null;
		
		retorno = openFileUtils.apply( fileName );
		
		return retorno;
	}

}
