import java.util.ArrayList;

public class CommercialAccount extends Account{

	ArrayList <Person> authorizedUsers;
	
	CommercialAccount(Company company, long accountNumber, int pin, double startingDeposit) {
		
		super(company, accountNumber, pin, startingDeposit);
	}

	public void addAuthorizedUser(Person person) {
		
		authorizedUsers.add(person);
	}
	
	public boolean isAuthorizedUser(Person person) {
		
		for(Person currentUser : authorizedUsers)
			if (person.getIdNumber() == (currentUser.getIdNumber()))
				return true;
		
		return false;
	}
}
