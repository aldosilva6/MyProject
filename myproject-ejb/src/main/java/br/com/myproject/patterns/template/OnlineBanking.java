package br.com.myproject.patterns.template;

public class OnlineBanking extends BankingOld {

	@Override
	public void postProcessing() {
		System.out.println("Enviou de sms para OnlineBanking");
	}

	@Override
	public void preProcessing() {
		System.out.println("Saber se o cliente tem Limite Online antes do processamento");
	}
	
	public void process(){
		System.out.println("Entrou no método de processamento do OnlineBanking");
		super.processOperation();
	}
}
