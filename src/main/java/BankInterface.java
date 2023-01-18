
public interface BankInterface {

	public long openCommercialAccount(Company company, int pin, double startingDeposit);
	
	public long openConsumerAccount(Person person, int pin, double startingDeposit);
		
	public boolean authenticateUser(long accountNumber, int pin);
	
	public double getBalance(long accountNumber);
	
	public void credit(long accountNumber, double amount);
	
	public boolean debit(long accountNumber, double amount);
}
