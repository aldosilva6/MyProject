package br.com.myproject.patterns;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.myproject.newjava.collectionpipelines.ClienteRepository;

public class ClienteRepositoryTest {
	
	private ClienteRepository repository;
	
	@Before
	public void setup() {
		Company company = new Company("GrupoUltra");
		Cliente completo1 = new Cliente("Ultragaz", "completo1@ultra.com.br", company);
		Cliente completo2 = new Cliente("Oxiteno", "completo2@ultra.com.br", company);
		Cliente clienteSemEmpresa = new Cliente("Extrafarma", "clienteSemEmpresa@ultra.com.br");
		Cliente clienteSomenteNome = new Cliente("ClienteSomenteNome");
		repository = new ClienteRepository( Arrays.asList( completo1, completo2, clienteSemEmpresa, clienteSomenteNome ) );
	}
	

	@Test
	public void getClientWithCompanyAndEmailTest() {
		List<String> listCliente = repository.getClienteEmailsOld();
		assertEquals( 2, listCliente.size() );
		assertTrue( listCliente.contains( "completo1@ultra.com.br" ) );
		assertTrue( listCliente.contains( "completo2@ultra.com.br" ) );
		assertFalse( listCliente.contains( "clienteSemEmpresa" ) );
	}

	@Test
	public void getClientWithCompanyAndEmailNewTest() {
		List<String> listCliente = repository.getClienteEmailsCollectionPipeline();
		assertEquals( 2, listCliente.size() );
		assertTrue( listCliente.contains( "completo1@ultra.com.br" ) );
		assertTrue( listCliente.contains( "completo2@ultra.com.br" ) );
		assertFalse( listCliente.contains( "clienteSemEmpresa" ) );
	}
}
