public class Runner{
	
	public static void main(String args[]) {
		
		Person bob = new Person("Bob", "Hill", 1);
		Bank bank1 = new Bank();
		
		bank1.openConsumerAccount(bob, 1111, 100);
		
		bank1.authenticateUser(1, 1111);
		System.out.println(bank1.getBalance(1));
		
		Transaction x = new Transaction(bank1, 1, 1111);
		x.credit(400);
		x.debit(200);
		System.out.println(x.getBalance());
	}
}