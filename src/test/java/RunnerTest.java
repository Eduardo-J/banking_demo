import static org.junit.Assert.*;

import org.junit.Test;

public class RunnerTest {

	Person bob = new Person("Bob", "Hill", 1);
	Person tom = new Person("Tom", "Dill", 2);
	Company com = new Company("companyInc", 3);

	Bank bank1 = new Bank();

	@Test
	public void testAthenticateUser() {
		
		bank1.openConsumerAccount(bob, 1111, 100);
		bank1.openConsumerAccount(bob, 2222, 123.45);
		bank1.openCommercialAccount(com, 3333, 1000);

		boolean authenticConsumer = bank1.authenticateUser(1, 1111);
		boolean notAuthenticConsumer = bank1.authenticateUser(1, 1212);
		boolean authenticCommercial = bank1.authenticateUser(3, 3333);
		boolean notAuthenticCommercial = bank1.authenticateUser(4, 3333);

		assertTrue(authenticConsumer);
		assertFalse(notAuthenticConsumer);
		assertTrue(authenticCommercial );
		assertFalse(notAuthenticCommercial );
	}
	
	@Test
	public void testBankCreditTransactions() {
		
		bank1.openConsumerAccount(bob, 1111, 100);
		bank1.openConsumerAccount(tom, 2222, 123.45);
		bank1.openCommercialAccount(com, 3333, 1000);
		
		Transaction trans1 = new Transaction(bank1, 1, 1111);
		Transaction trans2 = new Transaction(bank1, 2, 2222);
		Transaction trans3 = new Transaction(bank1, 3, 3333);


		trans1.credit(400);
		trans2.credit(300.12);
		trans3.credit(543.77);
		
		assertEquals((double) 500, trans1.getBalance(), 0.001);
		assertEquals((double) 423.57, trans2.getBalance(), 0.001);
		assertEquals((double) 1543.77, trans3.getBalance(), 0.001);

	}
	
	@Test
	public void testBankDebitTransactions() {
		
		bank1.openConsumerAccount(bob, 1111, 100);
		
		Transaction x = new Transaction(bank1, 1, 1111);
		boolean debitSufficient = x.debit(50);
		boolean debitInsufficient = x.debit(100);
		
		assertTrue(debitSufficient);
		assertFalse(debitInsufficient);

	}
}
