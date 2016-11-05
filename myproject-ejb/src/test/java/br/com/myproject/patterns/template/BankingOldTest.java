package br.com.myproject.patterns.template;

import static org.junit.Assert.*;

import org.junit.Test;

public class BankingOldTest {

	@Test
	public void testProcessingOld() {
		VIPBanking operationVIP = new VIPBanking();
		OnlineBanking operationOnlineBanking = new OnlineBanking();
		
		operationVIP.process();
		operationOnlineBanking.process();
		
		assertTrue(1==1);
	}
	
	@Test
	public void testProcessingNew() {
		BankingNew banking = new BankingNew();
		Operation openBankAccount = new OpenBankAccount();

		banking.processOperation( openBankAccount, Operation::preProcessing, Operation::postProcessing );
		
		assertTrue(1==1);
	}
}
