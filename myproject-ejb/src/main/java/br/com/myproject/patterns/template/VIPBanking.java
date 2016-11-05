package br.com.myproject.patterns.template;

public class VIPBanking extends BankingOld {

	@Override
	public void postProcessing() {
		System.out.println("Enviou de sms para VIP");	
	}

	@Override
	public void preProcessing() {
		System.out.println("Saber se o cliente tem Limite VIP antes do processamento");
	}
	
	public void process(){
		System.out.println("Entrou no método de processamento do VIPBanking");
		super.processOperation();
	}
}
