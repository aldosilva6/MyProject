package br.com.myproject.patterns.template;

public class OpenBankAccount implements Operation {

	@Override
	public void preProcessing() {
		System.out.println("Lógica de processamento ANTES de processar OpenBankAccount");
	}

	@Override
	public void postProcessing() {
		System.out.println("Lógica de processamento DEPOIS de processar OpenBankAccount");
	}


	public void process() {
		System.out.println("Lógica de processamento do OpenBankAccount");
	}
	
	
}
