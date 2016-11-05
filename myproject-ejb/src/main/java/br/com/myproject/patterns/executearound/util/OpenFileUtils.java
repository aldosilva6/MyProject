package br.com.myproject.patterns.executearound.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OpenFileUtils {
	
	/**
	 * 
	 * Execute Around: Deixar o cliente livre de fazer ações como 
	 * abrir e fechar arquivos e conexões, assim livra o cliente de 
	 * esquecer algum dos itens. Código de preparação, código de execução
	 * e código de fechamento.
	 * 
	 * Todo mundo que for ter que ler um arquivo usa esse método via
	 * lambida e dessa forma a pessoa que esta usando nunca irá esquecer
	 * de fechar o arquivo. 
	 * 
	 * @param fileName
	 * @return
	 */
	public static String readFileExecuteAround( String fileName ) {
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

}
