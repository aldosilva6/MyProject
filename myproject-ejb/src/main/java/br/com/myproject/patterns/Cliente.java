package br.com.myproject.patterns;

/**
 * POJO de Cliente
 * 
 * @author aldosilva
 *
 */
public class Cliente {
	
	private String name;
	private String email;
	private Company company;
	
	
	public Cliente( String name, String email, Company company ) {
		super();
		this.name = name;
		this.email = email;
		this.company = company;
	}

	public Cliente( String name ) {
		super();
		this.name = name;
	}

	public Cliente( String name, String email ) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
