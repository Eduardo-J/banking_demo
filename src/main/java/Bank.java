import java.util.LinkedHashMap;

public class Bank implements BankInterface{

	LinkedHashMap <Long, Account> accounts = new LinkedHashMap<>();
	
	Bank(){
		
	}

	public Account getAccount(long accountNumber) {
		
		if(accounts.containsKey(accountNumber)) {
			System.out.println("Found Account" + accountNumber);
			return accounts.get(accountNumber);
		} else {
			System.out.println("Failed to find account.");
			return null;
		}
	}
	
	@Override
	public long openCommercialAccount(Company company, int pin, double startingDeposit) {
		long accountNumber = (long) accounts.size() + 1;
		Account newAccount = new CommercialAccount(company, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, newAccount);
		accountNumber = (long) accounts.size() + 1;
		System.out.println("Commercial account created.");
		return accountNumber;
	}

	@Override
	public long openConsumerAccount(Person person, int pin, double startingDeposit) {
		
		long accountNumber = (long) accounts.size() + 1;
		Account newAccount = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, newAccount);
		accountNumber = (long) accounts.size() + 1;
		System.out.println("Consumer account created.");
		return accountNumber;
	}

	@Override
	public boolean authenticateUser(long accountNumber, int pin) {
		
		if(accounts.containsKey(accountNumber) &&  accounts.get(accountNumber).validatePin(pin)) {
			System.out.println("Account validated");
			return true;
		} else {
			System.out.println("Failed to validate account.");
			return false;
		}
	}

	@Override
	public double getBalance(long accountNumber) {

		if(accounts.containsKey(accountNumber)) {
			return accounts.get(accountNumber).getBalance();
		} else
			return 0;
	}

	@Override
	public void credit(long accountNumber, double amount) {
		
		if(accounts.containsKey(accountNumber)) {
			accounts.get(accountNumber).creditAccount(amount);
		}
	}

	@Override
	public boolean debit(long accountNumber, double amount) {
		
		if(accounts.containsKey(accountNumber)) {
			return accounts.get(accountNumber).debitAccount(amount);
		} else 
			return false;
	}
	
}
