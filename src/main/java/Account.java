
public class Account implements AccountInterface {

	AccountHolder accountHolder;
	long accountNumber;
	int pin;
	double balance;
	
	Account(AccountHolder accountHolder, long accountNumber, int pin, double startingDeposit){
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = startingDeposit;
	}
	
	public AccountHolder getAccountHolder(){
		return accountHolder;
	}

	@Override
	public boolean validatePin(int attemptedPin) {

		if(attemptedPin == pin)
			return true;
		else
			return false;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public long getAccountNumber() {
		return accountNumber;
	}

	@Override
	public void creditAccount(double amount) {
		balance += amount;
		
	}

	@Override
	public boolean debitAccount(double amount) {
		
		if(balance > amount) {
			balance -= amount;
			return true;
		} else
			return false;
	}
}
