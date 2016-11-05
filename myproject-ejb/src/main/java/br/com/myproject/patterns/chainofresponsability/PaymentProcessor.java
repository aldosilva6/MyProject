package br.com.myproject.patterns.chainofresponsability;


/**
 * Pattern: Evitar o acoplamento do remetente de uma solicitação ao seu
 * receptor, ao dar mais de um objeto a oportunidade de tratar a solicitação.
 * Encadear os objetos receptores, passando a solicitação ao longo da cadeia
 * até que um objeto a trate.
 * 
 * Resumo: Executar uma sequência de objetos e alguns desses objetos podem
 * processar o recurso que esta passando por ele, sem que o cliente precise
 * saber o que esta sendo processado.
 * 
 * Exemplo clássico filtro do servlet, a requisição vai passando e qualquer
 * objeto pode operar aquele objeto.
 * 
 * Uma das formas de criar uma cadeia de responsabilidades. Posso adicionar
 * responsabilidades sem ter que modificar o meu filtro, consigo adicionar
 * filtros na cadeia.
 * 
 * @author aldosilva
 *
 */
public abstract class PaymentProcessor {
	
	private PaymentProcessor next;
	
	/**
	 * Sempre que chamado irá posicionar o próximo como ultimo da fila
	 * 
	 * @param processors
	 */
	public void setNext( PaymentProcessor processors ) {
		//Senão tiver nenhum próximo seta como primeiro da árvore
		if ( next == null ) { 
			next = processors;
		} else { //Senão chama o filho dele e dá next
			next.setNext( processors );
		}
	}
	
	public Payment process( Payment p ) {
		handle( p );
		//Vai passando pelo próximo, cada um sendo executado na cadeia
		if ( next != null) { 
			return next.process( p );
		} else {
			return p; //Retorna o próprio objeto que entrou na fila
		}
	}
	
	protected abstract void handle( Payment p );
}
