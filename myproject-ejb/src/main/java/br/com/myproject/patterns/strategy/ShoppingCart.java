package br.com.myproject.patterns.strategy;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import br.com.myproject.enums.PaymentMethod;

/**
 * Strategy: Definir uma família de algoritimos, encapsular cada uma delas e
 * torná-las intercambiáveis. Strategy permite que o algoritimo varie
 * independente dos clientes que o utilizam.
 * 
 * @author aldosilva
 *
 */
public class ShoppingCart {

	private List<Item> items;

	/**
	 * Problema: A cada nova forma de pagamento é necessário adicionar um else
	 * if no código. O método esta fazendo 2 coisas, selecionando a forma de
	 * pagamento e fazendo o pagamento.
	 * 
	 * Viola o open/closed principle = aberta para extensão e fechada para
	 * modificação.
	 * 
	 * Dúvida: vale a pena mudar para criar toda uma estrutura de classe? Com o
	 * Java 8 ficou mais fácil.
	 * 
	 * @param paymentMethod
	 */
	public Integer payOld(PaymentMethod paymentMethod) {
		int total = cartTotal();
		if (paymentMethod == PaymentMethod.CREDIT) {
			// Lógica de pagamento
			total += 10;
			System.out.println("Pay with credit card " + total);
		} else if (paymentMethod == PaymentMethod.MONEY) {
			// Lógica de pagamento
			total += 5;
			System.out.println("Pay with money " + total);
		}
		return total;
	}

	/**
	 * Qualquer nova forma de pagamento que surgir não é necessário alterar o
	 * método pay, seguindo assim o princípio de Open/Closed Extensivel para
	 * mudança e fechada para modificação
	 * 
	 * Problema: Tivemos que criar um monte de classe
	 * 
	 * @param payment
	 * @return
	 */
	public Integer payNew(Payment payment) {
		int total = cartTotal();

		total = payment.pay(total);

		return total;
	}

	/**
	 * Utilizando interface funcional {@code Consumer} Java 8
	 * 
	 * Via lambda eu passo o que devo fazer. No exemplo estou passando
	 * uma classe com o que deve ser feito de acordo com o payment
	 * escolhido, criando somente 1 classe - PaymentsTypes
	 * 
	 * {@code Consumer} A interface consumer através do método accept
	 * executa o que estiver passando como parâmetro. Passado por 
	 * method reference
	 * 
	 * Alterei para usar a interface {@code Function} já que precisava
	 * do retorno do valor. Mas a idéia é a mesma.
	 * 
	 * @param payment
	 * @return
	 */
	public Integer pay( Function<Integer, Integer> payment ) {
		int total = cartTotal();
		
		//payment.accept( total ); Consumer
		
		total = payment.apply( total );
		
		return total;
	}

	/**
	 * Transforma a lista em int, pega os items que tem dentro dessa lista e
	 * soma os valores
	 * 
	 * Usando interface {@code Stream} do Java 8
	 * 
	 * @return
	 */
	private int cartTotal() {
		return items.stream().mapToInt(Item::getValor).sum();
	}

	/**
	 * @param items
	 */
	public ShoppingCart(List<Item> items) {
		super();
		this.items = items;
	}

	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

}
