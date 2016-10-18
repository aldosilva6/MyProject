package br.com.myproject.newjava.collectionpipelines;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.myproject.patterns.Cliente;

/**
 * Repositório para cliente
 * 
 * @author aldosilva
 *
 */
public class ClienteRepository {

	List<Cliente> listCliente;

	public ClienteRepository(List<Cliente> listCliente) {
		super();
		this.listCliente = listCliente;
	}

	/**
	 * Clientes que possuem uma empresa associada e um email cadastrado
	 * 
	 * @return
	 */
	public List<String> getClienteEmailsOld() {
		List<String> listEmails = new ArrayList<String>();
		for (Cliente cliente : listCliente) {
			if (cliente.getCompany() != null) {
				String email = cliente.getEmail();
				if (email != null) {
					listEmails.add(email);
				}
			}
		}
		return listEmails;
	}

	/**
	 * CollectionPipeline - recurso novo do Java 8 - fica mais fácil
	 * fazer a leitura do que esta acontecendo no código, ao invés de
	 * dentro de um loop fazer todas as validações. Eu olho o que realmente
	 * esta acontecendo na collection em uma única linha.
	 * 
	 * <p>{@code Stream} - Permite fazer filtros dentro da Collection
	 * <p>{@code Filter} - Filtra todos clientes que tenham empresa e
	 * que tenham email
	 * <p>{@code Map} - Transforma os Clientes em String
	 * 
	 * @return Uma sequência de {@code String} de emails
	 * @since 1.8
	 */
	public List<String> getClienteEmailsCollectionPipeline() {
		//List<String> listEmails = new ArrayList<String>();
		return listCliente.stream()
				.filter( c -> c.getCompany() != null )
				.map( c -> c.getEmail() )
				.filter( m -> m != null )
				.collect( Collectors.toList() ) ;
		//for (String clienteEmail : clientPipelines) {
			//if (cliente.getCompany() != null) {
				//String email = cliente.getEmail();
				//if ( clienteEmail != null ) {
					//listEmails.add( clienteEmail );
				//}
			//}
		//}
		//return listEmails;
	}

	public List<Cliente> getListCliente() {
		return listCliente;
	}

	public void setListCliente(List<Cliente> listCliente) {
		this.listCliente = listCliente;
	}

}
