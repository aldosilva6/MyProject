package br.com.myproject.patterns.template;

/**
 * Template: Definir o esqueleto de um algoritimo em uma operação
 * postergando alguns passos para as subclasses. Template Method 
 * permite que subclasses redefinam certo passo de um algoritimo
 * sem mudar a estrutura do mesmo. AbstractDAO por exemplo.
 * 
 * Quero usar um algoritimo, tentei usar muito o algoritimo mas aí
 * paro e penso: Quero mudar só umas linhas do meu algoritimo. 
 * 
 * @author aldosilva
 *
 */
public abstract class BankingOld {
	
	public void processOperation( ) {
		preProcessing(); //Dou para subclasse fazer o que quiser
		process();
		postProcessing();//Dou para subclasse fazer o que quiser
	}

	/**
	 * Implementação do método processar que é comum para todos.
	 * 
	 * @param op
	 */
	private void process() {
		System.out.println("Lógica processamento comum para todos");
	}

	public abstract void postProcessing();

	public abstract void preProcessing();

}
