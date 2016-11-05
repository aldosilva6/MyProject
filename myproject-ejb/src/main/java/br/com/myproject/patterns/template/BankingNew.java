package br.com.myproject.patterns.template;

import java.util.function.Consumer;

/**
 * Template passsa a ser uma classe concreta e os métodos recebem
 * como parâmetro a interface {@code Consumer}. Resolvendo o problema
 * de herança das subclasses, uma vez que quando se herda uma classe
 * é muito difícil remover a herança depois que os métodos estão implementados.
 * 
 * 
 * @author aldosilva - Pattern Template sem necessidade de herança
 *
 */
public class BankingNew {
	
	public void processOperation( Operation op ) {
		process( op );
	}
	
	public void processOperation( Operation op, 
								  Consumer<Operation> preProcessing, 
								  Consumer<Operation> postProcessing ) {
		preProcessing.accept( op );
		process( op );
		postProcessing.accept( op );
		
	}
	
	/**
	 * Implementação do método processar que é comum para todos.
	 * 
	 * @param op
	 */
	private void process( Operation op ){
		op.process();
		System.out.println("Lógica processamento comum para todos");
	}
	
}
